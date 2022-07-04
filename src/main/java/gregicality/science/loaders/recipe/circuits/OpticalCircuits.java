package gregicality.science.loaders.recipe.circuits;

import gregtech.common.items.MetaItems;

import static gregicality.science.api.recipes.GCYSRecipeMaps.BURNER_REACTOR_RECIPES;
import static gregicality.science.api.recipes.GCYSRecipeMaps.CVD_RECIPES;
import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregicality.science.common.items.GCYSMetaItems.OPTICAL_FIBER;
import static gregicality.science.common.items.GCYSMetaItems.PHASE_CHANGE_MEMORY;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLER_RECIPES;
import static gregtech.api.recipes.RecipeMaps.CHEMICAL_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class OpticalCircuits {

    public static void init() {
        pram();
        opticalFiber();
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
}
