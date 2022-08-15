package gregicality.science.loaders.recipe.circuits;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import net.minecraftforge.fluids.FluidStack;

import static gregicality.science.api.recipes.GCYSRecipeMaps.CVD_RECIPES;
import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregicality.science.common.items.GCYSMetaItems.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;

public class GoowareCircuits {

    public static void init() {
        // Regular Circuit Board
        CVD_RECIPES.recipeBuilder()
                .input(plate, KaptonE)
                .input(foil, Europium, 4)
                .output(GOOWARE_BOARD)
                .cleanroom(CleanroomType.CLEANROOM)
                .duration(40).EUt(VA[UV]).buildAndRegister();

        for (FluidStack stack : new FluidStack[]{TetramethylammoniumHydroxide.getFluid(2000), EDP.getFluid(500)}) {
            CHEMICAL_RECIPES.recipeBuilder()
                    .input(GOOWARE_BOARD)
                    .input(foil, YttriumBariumCuprate, 48)
                    .fluidInputs(stack)
                    .output(GOOWARE_CIRCUIT_BOARD)
                    .cleanroom(CleanroomType.CLEANROOM)
                    .duration(210).EUt(VA[EV]).buildAndRegister();
        }

        // Processing Unit
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(FLUID_CELL_LARGE_STAINLESS_STEEL.getStackForm())
                .input(plate, Naquadah, 4)
                .input(plate, Ruridit, 2)
                .input(bolt, Trinium, 12)
                .input(stick, SamariumMagnetic)
                .input(rotor, Iridium)
                .input(ELECTRIC_MOTOR_LuV)
                .fluidInputs(SolderingAlloy.getFluid(L))
                .outputs(BZ_REACTION_CHAMBER.getStackForm())
                .duration(600).EUt(VA[UV]).buildAndRegister();

        CANNER_RECIPES.recipeBuilder()
                .inputs(BZ_REACTION_CHAMBER.getStackForm())
                .fluidInputs(BZMedium.getFluid(500))
                .outputs(NONLINEAR_CHEMICAL_OSCILLATOR.getStackForm())
                .duration(60).EUt(VA[IV]).buildAndRegister();

        // Circuits
        // TODO SoC Style Recipe
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(GOOWARE_CIRCUIT_BOARD)
                .input(NONLINEAR_CHEMICAL_OSCILLATOR)
                .input(CRYSTAL_CENTRAL_PROCESSING_UNIT)
                .input(ADVANCED_SMD_CAPACITOR, 16)
                .input(ADVANCED_SMD_TRANSISTOR, 16)
                .input(wireFine, Europium, 8)
                .output(GOOWARE_PROCESSOR, 2)
                .duration(200).EUt(VA[UV]).cleanroom(CleanroomType.CLEANROOM).buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(GOOWARE_CIRCUIT_BOARD)
                .input(GOOWARE_PROCESSOR, 2)
                .input(ADVANCED_SMD_INDUCTOR, 16)
                .input(ADVANCED_SMD_CAPACITOR, 32)
                .input(RANDOM_ACCESS_MEMORY, 40)
                .input(wireFine, Europium, 16)
                .output(GOOWARE_ASSEMBLY, 2)
                .solderMultiplier(2)
                .duration(400).EUt(VA[UV]).cleanroom(CleanroomType.CLEANROOM).buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(GOOWARE_CIRCUIT_BOARD)
                .input(GOOWARE_ASSEMBLY, 2)
                .input(ADVANCED_SMD_DIODE, 10)
                .input(NOR_MEMORY_CHIP, 16)
                .input(RANDOM_ACCESS_MEMORY, 32)
                .input(wireFine, Europium, 24)
                .input(foil, KaptonK, 32)
                .input(plate, Americium, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 9))
                .output(GOOWARE_COMPUTER)
                .duration(400).EUt(153_600).buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Darmstadtium, 2)
                .input(GOOWARE_COMPUTER, 2)
                .input(ADVANCED_SMD_DIODE, 64)
                .input(ADVANCED_SMD_CAPACITOR, 64)
                .input(ADVANCED_SMD_TRANSISTOR, 64)
                .input(ADVANCED_SMD_RESISTOR, 64)
                .input(ADVANCED_SMD_INDUCTOR, 64)
                .input(foil, KaptonK, 64)
                .input(RANDOM_ACCESS_MEMORY, 32)
                .input(wireGtDouble, PedotPSS, 16)
                .input(plate, Americium, 8)
                .fluidInputs(SolderingAlloy.getFluid(L * 20))
                .fluidInputs(KaptonE.getFluid(L * 9))
                .output(GOOWARE_MAINFRAME)
                .duration(2000).EUt(1_200_000).buildAndRegister();
    }
}
