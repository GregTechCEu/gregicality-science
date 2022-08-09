package gregicality.science.loaders.recipe;

import gregicality.multiblocks.api.unification.GCYMMaterials;
import gregicality.science.common.metatileentities.GCYSMetaTileEntities;
import gregtech.api.GTValues;
import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.metatileentities.MetaTileEntities;
import gregtech.loaders.recipe.CraftingComponent;
import gregtech.loaders.recipe.MetaTileEntityLoader;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import org.apache.commons.lang3.ArrayUtils;

import static gregicality.science.api.unification.materials.GCYSMaterials.PedotTMA;
import static gregicality.science.common.items.GCYSMetaItems.VOLTAGE_COIL_UHV;
import static gregtech.api.GTValues.UHV;
import static gregtech.api.GTValues.VA;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLER_RECIPES;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLY_LINE_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.ELECTRIC_PUMP_LuV;
import static gregtech.common.items.MetaItems.ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT;
import static gregtech.common.metatileentities.MetaTileEntities.*;
import static gregtech.loaders.recipe.CraftingComponent.HULL;
import static gregtech.loaders.recipe.CraftingComponent.*;

public class GCYSMetaTileEntityLoader {

    public static void init() {
        singleBlocks();
        energy();
        multiblocks();
        hulls();
    }

    private static void singleBlocks() {
        MetaTileEntityLoader.registerMachineRecipe(GCYSMetaTileEntities.DRYER, "WCW", "SHS", "WCW", 'W', CraftingComponent.CABLE, 'C', CraftingComponent.CIRCUIT, 'S', CraftingComponent.SPRING, 'H', CraftingComponent.HULL);
    }

    private static void energy() {
        // Energy Hatches
        // Input
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLY_LINE_RECIPES,
                new ItemStack[]{MetaTileEntities.HULL[UHV].getStackForm(), OreDictUnifier.get(cableGtSingle, Europium, 4),
                        ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT.getStackForm(2), OreDictUnifier.get(circuit, MarkerMaterials.Tier.UHV),
                OreDictUnifier.get(wireGtDouble, RutheniumTriniumAmericiumNeutronate, 2)},
                new FluidStack[]{SodiumPotassium.getFluid(12000), SolderingAlloy.getFluid(5760)});

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(MetaTileEntities.HULL[UHV])
                .input(cableGtSingle, Europium, 4)
                .input(ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT, 2) //TODO next PIC
                .input(circuit, MarkerMaterials.Tier.UHV)
                .input(VOLTAGE_COIL_UHV, 2)
                .fluidInputs(SodiumPotassium.getFluid(12000))
                .fluidInputs(SolderingAlloy.getFluid(5760))
                .output(ENERGY_INPUT_HATCH[UHV])
                .duration(1000).EUt(VA[UHV]).buildAndRegister();

        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES,
                ENERGY_INPUT_HATCH[UHV].getStackForm(2), ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT.getStackForm(),
                OreDictUnifier.get(wireGtDouble, RutheniumTriniumAmericiumNeutronate), OreDictUnifier.get(wireGtQuadruple, Europium, 2));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(TRANSFORMER[UHV])
                .input(ENERGY_INPUT_HATCH[UHV])
                .input(ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT) //TODO next PIC
                .input(VOLTAGE_COIL_UHV)
                .input(wireGtQuadruple, Europium, 2)
                .output(ENERGY_INPUT_HATCH_4A[5])
                .duration(100).EUt(VA[UHV]).buildAndRegister();

        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES,
                ENERGY_INPUT_HATCH_4A[5].getStackForm(2), ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT.getStackForm(2),
                OreDictUnifier.get(wireGtDouble, RutheniumTriniumAmericiumNeutronate), OreDictUnifier.get(wireGtOctal, Europium, 2));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(ADJUSTABLE_TRANSFORMER[UHV])
                .input(ENERGY_INPUT_HATCH_4A[5])
                .input(ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT, 2) //TODO next PIC
                .input(VOLTAGE_COIL_UHV)
                .input(wireGtOctal, Europium, 2)
                .output(ENERGY_INPUT_HATCH_16A[4])
                .duration(200).EUt(VA[UHV]).buildAndRegister();

        // Output
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLY_LINE_RECIPES,
                new ItemStack[]{MetaTileEntities.HULL[UHV].getStackForm(), OreDictUnifier.get(spring, Europium, 4),
                        ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT.getStackForm(2), OreDictUnifier.get(circuit, MarkerMaterials.Tier.UHV),
                        OreDictUnifier.get(wireGtDouble, RutheniumTriniumAmericiumNeutronate, 2)},
                new FluidStack[]{SodiumPotassium.getFluid(12000), SolderingAlloy.getFluid(5760)});

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(MetaTileEntities.HULL[UHV])
                .input(spring, Europium, 4)
                .input(ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT, 2) //TODO next PIC
                .input(circuit, MarkerMaterials.Tier.UHV)
                .input(VOLTAGE_COIL_UHV, 2)
                .fluidInputs(SodiumPotassium.getFluid(12000))
                .fluidInputs(SolderingAlloy.getFluid(5760))
                .output(ENERGY_OUTPUT_HATCH[UHV])
                .duration(1000).EUt(VA[UHV]).buildAndRegister();

        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES,
                ENERGY_OUTPUT_HATCH[UHV].getStackForm(2), ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT.getStackForm(),
                OreDictUnifier.get(wireGtDouble, RutheniumTriniumAmericiumNeutronate), OreDictUnifier.get(wireGtQuadruple, Europium, 2));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(TRANSFORMER[UHV])
                .input(ENERGY_OUTPUT_HATCH[UHV])
                .input(ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT) //TODO next PIC
                .input(VOLTAGE_COIL_UHV)
                .input(wireGtQuadruple, Europium, 2)
                .output(ENERGY_OUTPUT_HATCH_4A[5])
                .duration(100).EUt(VA[UHV]).buildAndRegister();

        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES,
                ENERGY_OUTPUT_HATCH_4A[5].getStackForm(2), ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT.getStackForm(2),
                OreDictUnifier.get(wireGtDouble, RutheniumTriniumAmericiumNeutronate), OreDictUnifier.get(wireGtOctal, Europium, 2));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(ADJUSTABLE_TRANSFORMER[UHV])
                .input(ENERGY_OUTPUT_HATCH_4A[5])
                .input(ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT, 2) //TODO next PIC
                .input(VOLTAGE_COIL_UHV)
                .input(wireGtOctal, Europium, 2)
                .output(ENERGY_OUTPUT_HATCH_16A[4])
                .duration(200).EUt(VA[UHV]).buildAndRegister();

        // Transformers
        // Regular
        MetaTileEntityLoader.registerMachineRecipe(ArrayUtils.subarray(MetaTileEntities.TRANSFORMER, GTValues.UHV, GTValues.MAX), "WCC", "TH ", "WCC", 'W', POWER_COMPONENT, 'C', CABLE, 'T', CABLE_TIER_UP, 'H', HULL);

        // Adjustable
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(TRANSFORMER[UHV])
                .input(ELECTRIC_PUMP_LuV)
                .input(wireGtQuadruple, PedotTMA)
                .input(wireGtOctal, Europium)
                .input(springSmall, Europium)
                .input(spring, PedotTMA)
                .fluidInputs(Lubricant.getFluid(4000))
                .output(ADJUSTABLE_TRANSFORMER[UHV])
                .duration(200).EUt(VA[UHV]).buildAndRegister();
    }

    private static void multiblocks() {
        ModHandler.addShapedRecipe("crystallization_crucible", GCYSMetaTileEntities.CRYSTALLIZATION_CRUCIBLE.getStackForm(),
                "CMC", "LHL", "PCP",
                'C', new UnificationEntry(OrePrefix.circuit, MarkerMaterials.Tier.IV),
                'M', new UnificationEntry(OrePrefix.plateDouble, GCYMMaterials.MolybdenumDisilicide),
                'L', new UnificationEntry(OrePrefix.pipeNormalFluid, Materials.Titanium),
                'H', MetaTileEntities.HULL[GTValues.EV].getStackForm(),
                'P', new UnificationEntry(plate, Materials.Titanium)
        );
    }

    private static void hulls() {
        //TODO if setting Nt to something else stays remove this
//        ModHandler.removeRecipeByName("gregtech:casing_uhv");
//        //TODO remove the aaaaaaaaaaaaaa after CEu #1119 is merged
//        ModHandler.addShapedRecipe(true, "casing_uhvaaaaaaaaaaaaaa", MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.UHV),
//                "PPP", "PwP", "PPP",
//                'P', new UnificationEntry(plate, Orichalcum));
//
//        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES, IntCircuitIngredient.getIntegratedCircuit(8), OreDictUnifier.get(plate, Neutronium, 8));
//        ASSEMBLER_RECIPES.recipeBuilder()
//                .input(plate, Orichalcum, 8)
//                .circuitMeta(8)
//                .outputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.UHV))
//                .duration(50).EUt(16).buildAndRegister();
    }
}
