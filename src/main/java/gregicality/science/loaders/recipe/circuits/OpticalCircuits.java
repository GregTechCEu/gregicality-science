package gregicality.science.loaders.recipe.circuits;

import gregicality.science.api.unification.ore.GCYSOrePrefix;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.common.items.MetaItems;
import net.minecraftforge.fluids.FluidStack;

import static gregicality.multiblocks.api.recipes.GCYMRecipeMaps.ALLOY_BLAST_RECIPES;
import static gregicality.science.api.recipes.GCYSRecipeMaps.*;
import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregicality.science.common.items.GCYSMetaItems.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class OpticalCircuits {

    public static void init() {
        pram();
        opticalFiber();
        dielectricMirror();
        lasers();
        board();
    }

    private static void pram() {
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, GSTGlass)
                .input(wireFine, Americium, 32)
                .output(PHASE_CHANGE_MEMORY, 8)
                .duration(800).EUt(VA[UHV]).buildAndRegister();
    }

    private static void opticalFiber() {
        // Si + 4Cl -> SiCl4
        BURNER_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Silicon)
                .fluidInputs(Chlorine.getFluid(4000))
                .fluidOutputs(SiliconTetrachloride.getFluid(1000))
                .temperature(873)
                .duration(150).EUt(VA[HV]).buildAndRegister();

        // Ge + 2O -> GeO2
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Germanium)
                .fluidInputs(Oxygen.getFluid(2000))
                .output(dust, GermaniumDioxide, 3)
                .duration(150).EUt(VA[HV]).buildAndRegister();

        // 0.25GeCl4 + 0.25POCl3 + SiCl4-> 0.25GePSi4 + 5.75Cl
        CVD_RECIPES.recipeBuilder()
                .fluidInputs(GermaniumTetrachloride.getFluid(250))
                .fluidInputs(PhosphorylChloride.getFluid(250))
                .fluidInputs(SiliconTetrachloride.getFluid(1000))
                .notConsumable(MetaItems.SHAPE_EXTRUDER_WIRE)
                .output(OPTICAL_FIBER, 8)
                .temperature(1800)
                .duration(400).EUt(VA[IV]).buildAndRegister();

        //TODO Low Gravity
        ALLOY_BLAST_RECIPES.recipeBuilder()
                .input(dust, Zirconium, 5)
                .input(dust, Barium, 2)
                .input(dust, Lanthanum)
                .input(dust, Aluminium)
                .input(dust, Sodium, 2)
                .fluidInputs(Fluorine.getFluid(6200))
                .notConsumable(new IntCircuitIngredient(5))
                .fluidOutputs(ZBLANGlass.getFluid(L * 11))
                .blastFurnaceTemp(1073)
                .duration(1800).EUt(VA[HV]).buildAndRegister();

        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(ingot, ZBLANGlass)
                .input(dust, Erbium)
                .output(ingot, ErbiumDopedZBLANGlass, 2)
                .duration(200).EUt(VA[HV]).buildAndRegister();

        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(ingot, ZBLANGlass)
                .input(dust, Praseodymium)
                .output(ingot, PraseodymiumDopedZBLANGlass, 2)
                .duration(200).EUt(VA[HV]).buildAndRegister();

        EXTRUDER_RECIPES.recipeBuilder()
                .input(ingot, ErbiumDopedZBLANGlass)
                .notConsumable(MetaItems.SHAPE_EXTRUDER_WIRE)
                .output(OPTICAL_FIBER)
                .duration(400).EUt(VA[HV]).buildAndRegister();

        EXTRUDER_RECIPES.recipeBuilder()
                .input(ingot, PraseodymiumDopedZBLANGlass)
                .notConsumable(MetaItems.SHAPE_EXTRUDER_WIRE)
                .output(OPTICAL_FIBER)
                .duration(400).EUt(VA[HV]).buildAndRegister();

        //TODO Implement Optical Fiber Cables
//        CHEMICAL_BATH_RECIPES.recipeBuilder()
//                .input(OPTICAL_FIBER, 4)
//                .fluidInputs(KaptonK.getFluid(L * 2))
//                .output(OPTICAL_FIBER_CABLE)
//                .duration(100).EUt(VA[HV]).buildAndRegister();
//
//        CHEMICAL_BATH_RECIPES.recipeBuilder()
//                .input(OPTICAL_FIBER, 4)
//                .fluidInputs(Kevlar.getFluid(L / 9))
//                .output(OPTICAL_FIBER_CABLE)
//                .duration(100).EUt(VA[HV]).buildAndRegister();
    }

    private static void dielectricMirror() {
        // 2Ta + 5O -> Ta2O5
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Tantalum, 2)
                .fluidInputs(Oxygen.getFluid(5000))
                .output(dust, TantalumPentoxide, 7)
                .duration(110).EUt(VA[LV]).buildAndRegister();

        MOLECULAR_BEAM_RECIPES.recipeBuilder()
                .input(dust, ErbiumDopedZBLANGlass, 2)
                .input(dust, PraseodymiumDopedZBLANGlass, 2)
                .input(dust, TantalumPentoxide, 2)
                .input(plate, PolyethyleneTerephthalate)
                .output(DIELECTRIC_MIRROR)
                .temperature(2520)
                .duration(250).EUt(VA[IV]).buildAndRegister();
    }

    private static void lasers() {
        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Helium.getFluid(900))
                .fluidInputs(Neon.getFluid(100))
                .fluidOutputs(HeliumNeon.getFluid(1000))
                .duration(300).EUt(16).buildAndRegister();

        AUTOCLAVE_RECIPES.recipeBuilder()
                .input(dust, YttriumOxide, 3)
                .input(dust, Alumina, 5)
                .fluidInputs(DistilledWater.getFluid(8000))
                .output(GCYSOrePrefix.seedCrystal, NdYAG)
                .duration(288).EUt(VA[IV]).buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(DIELECTRIC_MIRROR)
                .input(plate, SterlingSilver, 2)
                .input(cableGtSingle, Platinum, 2)
                .fluidInputs(BorosilicateGlass.getFluid(L * 2))
                .output(EMPTY_LASER_ASSEMBLY)
                .duration(100).EUt(VA[IV]).buildAndRegister();

        CANNER_RECIPES.recipeBuilder()
                .input(EMPTY_LASER_ASSEMBLY)
                .fluidInputs(HeliumNeon.getFluid(1000))
                .output(HELIUM_NEON_LASER)
                .duration(120).EUt(16).buildAndRegister();

        CANNER_RECIPES.recipeBuilder()
                .input(EMPTY_LASER_ASSEMBLY)
                .input(gem, NdYAG)
                .output(ND_YAG_LASER)
                .duration(120).EUt(16).buildAndRegister();
    }

    private static void board() {
        CVD_RECIPES.recipeBuilder()
                .input(plate, GalliumNitride)
                .input(foil, Americium, 4)
                .output(OPTICAL_BOARD)
                .duration(40).EUt(VA[UHV]).buildAndRegister();

        for (FluidStack stack : new FluidStack[]{TetramethylammoniumHydroxide.getFluid(4000), EPD.getFluid(1000)}) {
            CHEMICAL_RECIPES.recipeBuilder()
                    .input(OPTICAL_BOARD)
                    .input(foil, Americium, 64)
                    .fluidInputs(stack)
                    .output(OPTICAL_CIRCUIT_BOARD)
                    .duration(2100).EUt(VA[IV]).buildAndRegister();
        }

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(OPTICAL_CIRCUIT_BOARD)
                .input(HELIUM_NEON_LASER)
                .input(ND_YAG_LASER)
//                .input(OPTICAL_FIBER_CABLE, 2) //TODO optical fiber cables
                .input(lens, Diamond, 4)
                .fluidInputs(SolderingAlloy.getFluid(L))
                .output(OPTICAL_LASER_CONTROL_UNIT)
                .duration(600).EUt(UHV).buildAndRegister();
    }
}
