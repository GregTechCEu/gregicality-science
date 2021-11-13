package gregicadditions.recipes.categories.handlers;

import gregicadditions.utils.Tuple;
import gregtech.api.GTValues;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.properties.PropertyKey;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.util.GTUtility;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.FluidStack;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static gregicadditions.GAMaterials.*;
import static gregicadditions.item.GAMetaItems.INSULATION_WIRE_ASSEMBLY;
import static gregtech.api.GTValues.M;
import static gregtech.api.recipes.GTRecipeHandler.removeRecipesByInputs;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLER_RECIPES;
import static gregtech.api.recipes.RecipeMaps.UNPACKER_RECIPES;
import static gregtech.api.recipes.RecipeMaps.PACKER_RECIPES;
import static gregtech.api.recipes.ingredients.IntCircuitIngredient.getIntegratedCircuit;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.loaders.oreprocessing.WireRecipeHandler.INSULATION_MATERIALS;

// TODO remove this class, set the GA_INSULATIONS values to some List/Map in CEu
public class WireRecipeHandler {

    /**
     * Mapping of [IngotMaterial, Maximum Allowed Tier]. Updating this List will change all autogenerated recipes.
     *
     * For example, Fullerene can be used for any tier of cables,
     * but Rubber can only be used for ULV and LV cables.
     */
    private static final List<Tuple<Material, Integer>> GA_INSULATIONS = Arrays.asList(
            new Tuple<>(Rubber,                 GTValues.LV),
            new Tuple<>(Polycaprolactam,        GTValues.MV),
            new Tuple<>(Polyethylene,           GTValues.HV),
            new Tuple<>(PolyvinylChloride,      GTValues.EV),
            new Tuple<>(PolyphenyleneSulfide,   GTValues.LuV),
            new Tuple<>(Polybenzimidazole,      GTValues.UV),
            new Tuple<>(Polyetheretherketone,   GTValues.UEV),
            new Tuple<>(Zylon,                  GTValues.UMV),
            new Tuple<>(FullerenePolymerMatrix, GTValues.MAX)
    );

    /**
     * Base number of foils to use for each size of cables.
     *
     * When combined with the above, we can predict how our recipes will behave. For example,
     *
     * A 16x Platinum Wire (IV-tier) can be covered with the following insulations:
     * - 16 Polyphenylene Sulfide Foil
     * - 8 PBI Foil
     * - 4 PEEK Foil
     * - 2 Zylon Foil
     * - 1 Fullerene Foil
     *
     *
     * A 8x Tin Wire (LV-tier) can be covered with the following insulations:
     * - 8 Rubber Foil
     * - 4 Polycaprolactam Foil
     * - 2 Polyethylene Foil
     * - 1 PVC Foil
     *   ... and each other foil, only 1 needed
     */
    private static final List<Integer> BASE_INSULATION = Arrays.asList(
            4,   // 1x
            4,   // 2x
            8,   // 4x
            8,   // 8x
            16   // 16x
    );

    /**
     * The first tier of cables that Insulation Wire Assembly is required for.
     * Right now it is UMV, meaning only UMV, UXV, and MAX cables require it.
     * This is different from before, where any cable covered with Zylon or Fullerene needed Assembly.
     */
    private static final int INSULATION_ASSEMBLY_TIER = GTValues.UMV;

    /**
     * Some helper data structures for the logic below. Nothing below here should need to be changed, and
     * instead try to adjust the above values first.
     */
    private static final OrePrefix[] WIRE_DOUBLING_ORDER = new OrePrefix[]{wireGtSingle, wireGtDouble, wireGtQuadruple, wireGtOctal, wireGtHex};
    private static final OrePrefix[] CABLE_DOUBLING_ORDER = new OrePrefix[]{cableGtSingle, cableGtDouble, cableGtQuadruple, cableGtOctal, cableGtHex};
    private static final Map<Integer, Integer> MATERIAL_MAPPING = new HashMap<>();

    /**
     * Handler Registry method. Called in {@link gregicadditions.CommonProxy#registerOrePrefix(RegistryEvent.Register)}.
     */
    public static void register() {

        // Populate the material mapping map
        List<Integer> insulationCutoffs = GA_INSULATIONS.stream().map(Tuple::getValue).collect(Collectors.toList());
        int insulationIndex = 0;
        for (int i = GTValues.ULV; i <= GTValues.MAX; i++) {
            int cutoff = insulationCutoffs.get(insulationIndex);
            if (i <= cutoff)
                MATERIAL_MAPPING.put(i, insulationIndex);
            if (i == cutoff)
                insulationIndex++;
        }

        // Register the OrePrefix handlers
//        for (OrePrefix wirePrefix : WIRE_DOUBLING_ORDER)
//            wirePrefix.addProcessingHandler(Material.class, WireRecipeHandler::processWireGt); todo material processing handlers
//
//        cableGtSingle.addProcessingHandler(Material.class, WireRecipeHandler::processCableStripping);
//        wireGtSingle.addProcessingHandler(Material.class, WireRecipeHandler::processWireCompression);
    }

    /**
     * Wire Material Handler. Handles all Wire OrePrefixes. Generates:
     *
     * + Cable covering recipes using foils, based on the data set above
     * - Removes all GTCE autogenerated cable covering recipes in favor of our own
     */
    private static void processWireGt(OrePrefix wireGt, Material material) {
        if (material.getProperty(PropertyKey.WIRE) == null) return;

        int cableAmount = (int) (wireGt.materialAmount * 2 / M);
        int gtCableTier = GTUtility.getTierByVoltage(material.getProperty(PropertyKey.WIRE).voltage);
        int cableTier = GTUtility.getTierByVoltage(material.getProperty(PropertyKey.WIRE).voltage);
        int cableSize = ArrayUtils.indexOf(WIRE_DOUBLING_ORDER, wireGt);
        OrePrefix cablePrefix = OrePrefix.getPrefix("cable" + wireGt.name().substring(4));

        // Removals of GTCE Recipes
        for (Material fluid : INSULATION_MATERIALS.keySet()) {

            int materialAmount = getGTCECableMaterialAmount(gtCableTier, INSULATION_MATERIALS.get(fluid));
            if (materialAmount == -1) continue;

            // Remove the 1x -> larger cable recipe
            if (wireGt != wireGtSingle)
                removeRecipesByInputs(ASSEMBLER_RECIPES, new ItemStack[]{OreDictUnifier.get(wireGtSingle, material, cableAmount), getIntegratedCircuit(24 + cableSize)}, new FluidStack[]{fluid.getFluid(materialAmount * cableAmount)});

            // Remove the normal cable covering recipe
            removeRecipesByInputs(ASSEMBLER_RECIPES, new ItemStack[]{OreDictUnifier.get(wireGt, material), getIntegratedCircuit(24)}, new FluidStack[]{fluid.getFluid(materialAmount * cableAmount)});
        }

        // Addition of new Recipes
        for (int i = 0; i < GA_INSULATIONS.size(); i++) {

            Tuple<Material, Integer> insulationData = GA_INSULATIONS.get(i);
            if (cableTier > insulationData.getValue()) continue;

            int materialAmount = getCableMaterialAmount(cableTier, cableSize, i);
            if (materialAmount == -1) continue;

            if (wireGt != wireGtSingle) {

                // Add the 1x -> larger cable recipe
                RecipeBuilder<?> builder = ASSEMBLER_RECIPES.recipeBuilder().duration(150).EUt(8)
                        .input(wireGtSingle, material, cableAmount)
                        .circuitMeta(24 + cableSize)
                        .input(foil, insulationData.getKey(), materialAmount)
                        .output(cablePrefix, material);

                if (cableTier >= INSULATION_ASSEMBLY_TIER)
                    builder.inputs(INSULATION_WIRE_ASSEMBLY.getStackForm(Math.max(1, materialAmount / 2)));

                builder.buildAndRegister();
            }

            // Add the normal cable covering recipe
            RecipeBuilder<?> builder = ASSEMBLER_RECIPES.recipeBuilder().duration(150).EUt(8)
                    .circuitMeta(24)
                    .input(wireGt, material)
                    .input(foil, insulationData.getKey(), materialAmount)
                    .output(cablePrefix, material);

            if (cableTier >= INSULATION_ASSEMBLY_TIER)
                builder.inputs(INSULATION_WIRE_ASSEMBLY.getStackForm(Math.max(1, materialAmount / 2)));

            builder.buildAndRegister();
        }
    }

    /**
     * Cable Stripping Material Handler. Generates:
     *
     * + Cable -> Wire Stripping recipes for all Cables
     */
    private static void processCableStripping(OrePrefix prefix, Material material) {
        if (material.getProperty(PropertyKey.WIRE) != null) {

            for (int i = 0; i < CABLE_DOUBLING_ORDER.length; i++) {

                UNPACKER_RECIPES.recipeBuilder().duration(100).EUt(7)
                        .input(CABLE_DOUBLING_ORDER[i], material)
                        .notConsumable(new IntCircuitIngredient(0))
                        .output(WIRE_DOUBLING_ORDER[i], material)
                        .buildAndRegister();
            }
        }
    }


    /**
     * Wire compression Material Handler
     */
    private static void processWireCompression(OrePrefix prefix, Material material) {
        if (material.getProperty(PropertyKey.WIRE) != null) {
            for(int startTier = 0; startTier < 4; startTier++) {
                for (int i = 1; i < 5 - startTier; i++) {
                    PACKER_RECIPES.recipeBuilder()
                        .inputs(OreDictUnifier.get(WIRE_DOUBLING_ORDER[startTier], material, 1 << i))
                        .notConsumable(new IntCircuitIngredient(i))
                        .outputs(OreDictUnifier.get(WIRE_DOUBLING_ORDER[startTier + i], material, 1))
                        .buildAndRegister();
                }
            }
        }
    }

    /**
     * This is a copy-paste of {@link gregtech.loaders.oreprocessing.WireRecipeHandler} getMaterialAmount() which is private.
     * It is only used to get consistent behavior with GTCE for the removal of the old wire insulation recipes.
     *
     * @param cableTier      The tier of the cable.
     * @param insulationTier The tier of the insulation material, from {@link gregtech.loaders.oreprocessing.WireRecipeHandler#INSULATION_MATERIALS}.
     * @return The amount of fluid used in the Recipe.
     */
    private static int getGTCECableMaterialAmount(int cableTier, int insulationTier) {
        if (cableTier > insulationTier)
            return -1;

        int insulationDiscount = (insulationTier - cableTier) / 2;
        return Math.max(36, 144 / (1 + insulationDiscount));
    }

    /**
     * Method used to scale the number of foils needed to cover a wire based on the tier and cable size.
     * Currently, this will use the base values set as above for on-tier recipes, and then following that
     * it will divide the number of foils required by 2 for each subsequent tier.
     *
     * @param cableTier       The voltage tier of the cable.
     * @param cableSize       The thickness of the cable, as an index of {@link WireRecipeHandler#CABLE_DOUBLING_ORDER}.
     * @param insulationIndex The index of the insulation in {@link WireRecipeHandler#GA_INSULATIONS}.
     * @return The number of foils to use in the cable covering recipe.
     */
    private static int getCableMaterialAmount(int cableTier, int cableSize, int insulationIndex) {

        int insulationDiscount = insulationIndex - MATERIAL_MAPPING.get(cableTier);
        if (insulationDiscount < 0)
            return -1;

        return Math.max(1, BASE_INSULATION.get(cableSize) / (int) Math.pow(2, insulationDiscount));
    }
}
