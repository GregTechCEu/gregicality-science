package gregicality.science.loaders.recipe.circuits;

import gregicality.science.common.GCYSConfigHolder;
import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ModHandler;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidStack;

import static gregicality.science.api.recipes.GCYSRecipeMaps.PRESSURE_CHAMBER_RECIPES;
import static gregicality.science.api.unification.materials.GCYSMaterials.Kovar;
import static gregicality.science.common.items.GCYSMetaItems.VACUUM_TUBE_COMPONENTS;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLER_RECIPES;
import static gregtech.api.recipes.RecipeMaps.MIXER_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.common.items.MetaItems.GLASS_TUBE;
import static gregtech.common.items.MetaItems.VACUUM_TUBE;

public class PrimitiveCircuits {

    public static void init() {
        ModHandler.addShapelessRecipe("dust_kovar", OreDictUnifier.get(OrePrefix.dust, Kovar, 6),
                OreDictUnifier.get(OrePrefix.dust, Iron),
                OreDictUnifier.get(OrePrefix.dust, Iron),
                OreDictUnifier.get(OrePrefix.dust, Iron),
                OreDictUnifier.get(OrePrefix.dust, Iron),
                OreDictUnifier.get(OrePrefix.dust, Nickel),
                OreDictUnifier.get(OrePrefix.dust, Nickel),
                OreDictUnifier.get(OrePrefix.dust, Cobalt)
        );

        MIXER_RECIPES.recipeBuilder()
                .input(OrePrefix.dust, Iron, 4)
                .input(OrePrefix.dust, Nickel, 2)
                .input(OrePrefix.dust, Cobalt)
                .notConsumable(new IntCircuitIngredient(4))
                .output(OrePrefix.dust, Kovar, 7)
                .duration(160).EUt(VA[ULV]).buildAndRegister();

        if (!GCYSConfigHolder.circuitOverrides.harderVacuumTubes) return;

        removeGTCERecipes();

        ModHandler.addShapedRecipe("vacuum_tube_components", VACUUM_TUBE_COMPONENTS.getStackForm(),
                "RGR", "WWW",
                'R', new UnificationEntry(OrePrefix.stick, Steel),
                'G', new UnificationEntry(OrePrefix.dust, Glowstone),
                'W', new UnificationEntry(OrePrefix.wireGtSingle, Copper));

        ModHandler.addShapedRecipe("vacuum_tube_components_foil", VACUUM_TUBE_COMPONENTS.getStackForm(),
                "RGR", "WWW",
                'R', new UnificationEntry(OrePrefix.stick, Steel),
                'G', new UnificationEntry(OrePrefix.foil, Gold),
                'W', new UnificationEntry(OrePrefix.wireGtSingle, Copper));

        for (Material copper : new Material[]{Copper, AnnealedCopper}) {
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(OrePrefix.foil, Gold)
                    .input(OrePrefix.bolt, Steel, 2)
                    .input(OrePrefix.wireGtSingle, copper, 2)
                    .circuitMeta(1)
                    .output(VACUUM_TUBE_COMPONENTS, copper == Copper ? 2 : 4)
                    .duration(120).EUt(VA[ULV]).buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(OrePrefix.foil, Gold)
                    .input(OrePrefix.bolt, Steel)
                    .input(OrePrefix.wireGtSingle, copper, 2)
                    .fluidInputs(RedAlloy.getFluid(L / 8))
                    .output(VACUUM_TUBE_COMPONENTS, copper == Copper ? 4 : 6)
                    .duration(120).EUt(VA[ULV]).buildAndRegister();
        }

        PRESSURE_CHAMBER_RECIPES.recipeBuilder()
                .input(GLASS_TUBE)
                .input(VACUUM_TUBE_COMPONENTS)
                .input(OrePrefix.ring, Kovar)
                .output(VACUUM_TUBE)
                .pressure(13E-5)
                .duration(100).EUt(16).buildAndRegister();
    }

    private static void removeGTCERecipes() {
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:vacuum_tube"));

        for (Material copper : new Material[]{Copper, AnnealedCopper}) {
            GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES,
                    GLASS_TUBE.getStackForm(),
                    OreDictUnifier.get(OrePrefix.bolt, Steel, 2),
                    OreDictUnifier.get(OrePrefix.wireGtSingle, copper, 2),
                    IntCircuitIngredient.getIntegratedCircuit(1));

            GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES,
                    new ItemStack[]{
                        GLASS_TUBE.getStackForm(),
                        OreDictUnifier.get(OrePrefix.bolt, Steel, 2),
                        OreDictUnifier.get(OrePrefix.wireGtSingle, copper, 2),
                        IntCircuitIngredient.getIntegratedCircuit(1)
                    }, new FluidStack[]{RedAlloy.getFluid(L / 8)});
        }
    }
}
