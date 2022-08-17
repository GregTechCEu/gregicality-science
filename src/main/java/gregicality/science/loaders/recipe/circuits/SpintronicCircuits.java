package gregicality.science.loaders.recipe.circuits;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.common.blocks.BlockGlassCasing;
import gregtech.common.blocks.MetaBlocks;
import net.minecraftforge.fluids.FluidStack;

import static gregicality.science.api.recipes.GCYSRecipeMaps.CVD_RECIPES;
import static gregicality.science.api.recipes.GCYSRecipeMaps.MOLECULAR_BEAM_RECIPES;
import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregicality.science.common.items.GCYSMetaItems.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;

public class SpintronicCircuits {

    //TODO additional magnets as needed: YbPtBi - antiferromagnetic, GaMnAs - ferromagnetic semiconductor
    public static void init() {
        sttram();
        topologicalIsolators();
        boseEinsteinCondensate();
        board();
        smd();
        circuits();
    }

    private static void sttram() {
        FORMING_PRESS_RECIPES.recipeBuilder()
                .input(plate, PlutoniumPhosphide)
                .input(foil, Lithium6)
                .output(SPIN_TRANSFER_TORQUE_MEMORY)
                .duration(200).EUt(VA[UEV]).buildAndRegister();
    }

    private static void topologicalIsolators() {
        MOLECULAR_BEAM_RECIPES.recipeBuilder()
                .input(dust, Bismuth)
                .input(dust, Antimony)
                .input(dust, Tellurium, 2)
                .input(dust, Sulfur)
                .notConsumable(plate, CadmiumSulfide)
                .output(dust, BismuthChalcogenide, 5)
                .duration(80).EUt(VA[UV]).buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dust, Cadmium)
                .input(dust, Tellurium, 2)
                .fluidInputs(Mercury.getFluid(2000))
                .output(dust, MercuryCadmiumTelluride, 5)
                .notConsumable(new IntCircuitIngredient(1))
                .duration(400).EUt(VA[UHV]).buildAndRegister();

        CANNER_RECIPES.recipeBuilder()
                .input(wireFine, MercuryCadmiumTelluride, 16)
                .input(spring, CarbonNanotube)
                .output(TOPOLOGICAL_INSULATOR_TUBE)
                .cleanroom(CleanroomType.CLEANROOM)
                .duration(20).EUt(VA[HV]).buildAndRegister();
    }

    private static void boseEinsteinCondensate() {
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(FIELD_GENERATOR_IV)
                .input(HELIUM_NEON_LASER)
                .input(plate, Trinium, 2)
                .input(cableGtSingle, Europium, 2)
                .inputs(MetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockGlassCasing.CasingType.LAMINATED_GLASS, 2))
                .output(BOSE_EINSTEIN_CONDENSATE_CONTAINMENT_UNIT)
                .duration(80).EUt(VA[UV]).buildAndRegister();

        CANNER_RECIPES.recipeBuilder()
                .input(BOSE_EINSTEIN_CONDENSATE_CONTAINMENT_UNIT)
                .input(dust, Rubidium, 8)
                .output(BOSE_EINSTEIN_CONDENSATE)
                .cleanroom(CleanroomType.CLEANROOM)
                .duration(20).EUt(VA[IV]).buildAndRegister();
    }

    private static void board() {
        CVD_RECIPES.recipeBuilder()
                .input(plate, CarbonNanotube)
                .input(foil, Phosphorene, 4)
                .output(SPINTRONIC_BOARD)
                .cleanroom(CleanroomType.CLEANROOM)
                .duration(40).EUt(VA[UEV]).buildAndRegister();

        for (FluidStack stack : new FluidStack[]{TetramethylammoniumHydroxide.getFluid(4000), EDP.getFluid(1000)}) {
            CHEMICAL_RECIPES.recipeBuilder()
                    .input(SPINTRONIC_BOARD)
                    .input(foil, Fullerene, 16)
                    .fluidInputs(stack)
                    .output(SPINTRONIC_CIRCUIT_BOARD)
                    .cleanroom(CleanroomType.CLEANROOM)
                    .duration(210).EUt(VA[LuV]).buildAndRegister();
        }

        // processing unit
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(SPINTRONIC_CIRCUIT_BOARD)
                .input(plate, PlutoniumPhosphide, 2)
                .input(plate, BismuthFerrite)
                .input(foil, BismuthChalcogenide, 2)
                .input(TOPOLOGICAL_INSULATOR_TUBE)
                .input(BOSE_EINSTEIN_CONDENSATE)
                .input(wireFine, ThalliumCopperChloride, 24)
                .fluidInputs(SolderingAlloy.getFluid(L))
                .output(ESR_COMPUTATION_UNIT)
                .duration(600).EUt(VA[UEV]).buildAndRegister();
    }

    private static void smd() {
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(wireFine, MercuryCadmiumTelluride, 4)
                .input(gem, HexagonalBoronNitride)
                .output(SPINTRONIC_RESISTOR, 16)
                .fluidInputs(Kevlar.getFluid(L * 2))
                .duration(160).EUt(VA[UHV]).buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(wireFine, CarbonNanotube, 8)
                .input(plate, AmorphousBoronNitride)
                .fluidInputs(Kevlar.getFluid(L))
                .output(SPINTRONIC_TRANSISTOR, 16)
                .duration(160).EUt(VA[UHV]).buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(wireGtSingle, CarbonNanotube, 2)
                .input(plate, CubicBoronNitride)
                .fluidInputs(Kevlar.getFluid(L / 4))
                .output(SPINTRONIC_CAPACITOR, 16)
                .duration(160).EUt(VA[UHV]).buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(dust, CadmiumSelenide)
                .input(wireFine, CarbonNanotube, 4)
                .fluidInputs(Kevlar.getFluid(L / 2))
                .output(SPINTRONIC_DIODE, 16)
                .duration(160).EUt(VA[UHV]).buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(ring, Fullerene)
                .input(wireFine, ThalliumCopperChloride, 4)
                .fluidInputs(Kevlar.getFluid(L))
                .output(SPINTRONIC_INDUCTOR, 16)
                .duration(160).EUt(VA[UHV]).buildAndRegister();

    }

    private static void circuits() {
        //TODO SoC Recipe
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(ESR_COMPUTATION_UNIT)
                .input(CRYSTAL_CENTRAL_PROCESSING_UNIT) //TODO new CPU
                .input(SPINTRONIC_RESISTOR, 8)
                .input(SPINTRONIC_CAPACITOR, 8)
                .input(SPINTRONIC_TRANSISTOR, 8)
                .input(wireFine, CarbonNanotube, 8)
                .output(SPINTRONIC_PROCESSOR, 2)
                .duration(200).EUt(VA[UEV]).cleanroom(CleanroomType.CLEANROOM).buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(SPINTRONIC_CIRCUIT_BOARD)
                .input(SPINTRONIC_PROCESSOR, 2)
                .input(SPINTRONIC_INDUCTOR, 6)
                .input(SPINTRONIC_CAPACITOR, 12)
                .input(SPIN_TRANSFER_TORQUE_MEMORY, 24)
                .input(wireFine, CarbonNanotube, 16)
                .output(SPINTRONIC_ASSEMBLY, 2)
                .solderMultiplier(2)
                .duration(400).EUt(VA[UEV]).cleanroom(CleanroomType.CLEANROOM).buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(SPINTRONIC_CIRCUIT_BOARD)
                .input(SPINTRONIC_ASSEMBLY, 2)
                .input(SPINTRONIC_DIODE, 8)
                .input(NOR_MEMORY_CHIP, 16) //TODO new NOR Gate
                .input(SPIN_TRANSFER_TORQUE_MEMORY, 32)
                .input(wireFine, CarbonNanotube, 24)
                .input(foil, Fullerene, 32)
                .input(plate, PlutoniumPhosphide, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 12))
                .output(SPINTRONIC_COMPUTER)
                .duration(400).EUt(1_228_800).buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Fullerene, 2)
                .input(SPINTRONIC_COMPUTER, 2)
                .input(SPINTRONIC_DIODE, 8)
                .input(NOR_MEMORY_CHIP, 16) //TODO new NOR Gate
                .input(SPIN_TRANSFER_TORQUE_MEMORY, 32)
                .input(NANO_POWER_IC, 2)
                .input(cableGtSingle, CarbonNanotube, 8)
                .input(SPINTRONIC_INDUCTOR, 8)
                .input(SPINTRONIC_CAPACITOR, 16)
                .input(SPINTRONIC_RESISTOR, 8)
                .input(plate, PlutoniumPhosphide, 8)
                .fluidInputs(SolderingAlloy.getFluid(L * 20))
                .fluidInputs(CarbonNanotube.getFluid(L * 9))
                .output(SPINTRONIC_MAINFRAME)
                .duration(1200).EUt(9_600_000).buildAndRegister();
    }
}
