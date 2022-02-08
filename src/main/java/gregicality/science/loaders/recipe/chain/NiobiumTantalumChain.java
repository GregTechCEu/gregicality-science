package gregicality.science.loaders.recipe.chain;

import gregtech.api.recipes.RecipeMaps;

import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregtech.api.GTValues.HV;
import static gregtech.api.GTValues.VA;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;

public class NiobiumTantalumChain {

    public static void init() {
        niobiumProcess();
        tantalumProcess();
    }

    private static void niobiumProcess() {
        RecipeMaps.CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, Pyrochlore, 11)
                .fluidInputs(HydrofluoricAcid.getFluid(2000))
                .output(dust, NiobiumPentoxide, 7)
                .output(dust, TantalumPentoxide)
                .output(dust, CalciumDifluoride, 6)
                .fluidOutputs(Water.getFluid(2000))
                .duration(200).EUt(VA[HV]).buildAndRegister();
    }

    private static void tantalumProcess() {
        RecipeMaps.CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, Tantalite, 9)
                .fluidInputs(HydrofluoricAcid.getFluid(2000))
                .output(dust, TantalumPentoxide, 7)
                .output(dust, NiobiumPentoxide)
                .output(dust, ManganeseDifluoride, 6)
                .fluidOutputs(Water.getFluid(1000))
                .duration(200).EUt(VA[HV]).buildAndRegister();
    }
}
