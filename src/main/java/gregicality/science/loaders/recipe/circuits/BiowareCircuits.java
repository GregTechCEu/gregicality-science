package gregicality.science.loaders.recipe.circuits;

import gregicality.science.common.GCYSConfigHolder;
import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.MarkerMaterials;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregicality.science.common.items.GCYSMetaItems.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;

public class BiowareCircuits {

    public static void init() {
        // Regular Circuit Board
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, KaptonE, 32)
                .input(STERILE_PETRI_DISH, 8)
                .input(ELECTRIC_PUMP_ZPM)
                .input(SENSOR_LUV)
                .input(circuit, MarkerMaterials.Tier.Master)
                .input(foil, YttriumBariumCuprate, 32)
                .fluidInputs(EvolutionaryMedium.getFluid(4000))
                .output(BIOWARE_BOARD, 32)
                .duration(1200).EUt(VA[UV]).buildAndRegister();

        for (FluidStack stack : new FluidStack[]{Iron3Chloride.getFluid(7500), SodiumPersulfate.getFluid(15000)}) {
            CHEMICAL_RECIPES.recipeBuilder()
                    .input(BIOWARE_BOARD)
                    .input(foil, YttriumBariumCuprate, 48)
                    .fluidInputs(stack)
                    .output(BIOWARE_CIRCUIT_BOARD)
                    .duration(2100).EUt(VA[EV]).buildAndRegister();
        }

        // Processing Unit
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(BIOWARE_CIRCUIT_BOARD)
                .input(SUPERINTELLIGENT_ORGANISM, 16)
                .input(pipeSmallFluid, Polybenzimidazole, 8)
                .input(plate, Ruridit, 8)
                .input(foil, SiliconeRubber, 32)
                .input(bolt, Trinium, 8)
                .fluidInputs(EvolutionaryMedium.getFluid(250))
                .output(SENTIENT_PROCESSOR)
                .duration(600).EUt(VA[UV]).buildAndRegister();

        // Circuits

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(SENTIENT_PROCESSOR)
                .input(CRYSTAL_CENTRAL_PROCESSING_UNIT)
                .input(QUBIT_CENTRAL_PROCESSING_UNIT)
                .input(ADVANCED_SMD_CAPACITOR, 16)
                .input(ADVANCED_SMD_TRANSISTOR, 16)
                .input(wireFine, Europium, 8)
                .output(BIOWARE_PROCESSOR, 2)
                .duration(200).EUt(VA[UV]).buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(BIOWARE_CIRCUIT_BOARD)
                .input(BIOWARE_PROCESSOR, 2)
                .input(ADVANCED_SMD_INDUCTOR, 16)
                .input(ADVANCED_SMD_CAPACITOR, 32)
                .input(RANDOM_ACCESS_MEMORY, 40)
                .input(wireFine, Europium, 16)
                .output(BIOWARE_ASSEMBLY, 2)
                .solderMultiplier(2)
                .duration(400).EUt(VA[UV]).buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(BIOWARE_CIRCUIT_BOARD)
                .input(BIOWARE_ASSEMBLY, 2)
                .input(ADVANCED_SMD_DIODE, 10)
                .input(NOR_MEMORY_CHIP, 16)
                .input(RANDOM_ACCESS_MEMORY, 32)
                .input(wireFine, Europium, 24)
                .input(foil, KaptonK, 32)
                .input(plate, Americium, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 9))
                .output(BIOWARE_COMPUTER)
                .duration(400).EUt(153_600).buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Darmstadtium, 2)
                .input(BIOWARE_COMPUTER, 2)
                .input(ADVANCED_SMD_DIODE, 64)
                .input(ADVANCED_SMD_CAPACITOR, 64)
                .input(ADVANCED_SMD_TRANSISTOR, 64)
                .input(ADVANCED_SMD_RESISTOR, 64)
                .input(ADVANCED_SMD_INDUCTOR, 64)
                .input(foil, KaptonK, 64)
                .input(RANDOM_ACCESS_MEMORY, 32)
                .input(wireGtDouble, RutheniumTriniumAmericiumNeutronate, 16)
                .input(plate, Americium, 8)
                .fluidInputs(SolderingAlloy.getFluid(L * 20))
                .fluidInputs(KaptonE.getFluid(L * 9))
                .output(BIOWARE_MAINFRAME)
                .duration(2000).EUt(1_200_000).buildAndRegister();

        // Harder Wetware
        if (GCYSConfigHolder.circuitOverrides.harderWetwareCircuits) {
            GTRecipeHandler.removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[]{
                    MULTILAYER_FIBER_BOARD.getStackForm(16),
                    PETRI_DISH.getStackForm(),
                    ELECTRIC_PUMP_LUV.getStackForm(),
                    SENSOR_IV.getStackForm(),
                    OreDictUnifier.get(circuit, MarkerMaterials.Tier.Elite),
                    OreDictUnifier.get(foil, NiobiumTitanium, 16)},
                    new FluidStack[]{SterileGrowthMedium.getFluid(4000)});
        }

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, KaptonK, 16)
                .input(STERILE_PETRI_DISH)
                .input(ELECTRIC_PUMP_LUV)
                .input(SENSOR_IV)
                .input(circuit, MarkerMaterials.Tier.Elite)
                .input(foil, NiobiumTitanium, 16)
                .fluidInputs(SterileGrowthMedium.getFluid(4000))
                .output(WETWARE_BOARD, 16)
                .duration(1200).EUt(VA[LuV]).buildAndRegister();
    }
}
