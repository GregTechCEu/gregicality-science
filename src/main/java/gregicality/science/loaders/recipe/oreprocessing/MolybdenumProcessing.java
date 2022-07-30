package gregicality.science.loaders.recipe.oreprocessing;

import gregtech.api.recipes.RecipeMaps;

import static gregicality.science.api.recipes.GCYSRecipeMaps.ROASTER_RECIPES;
import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.CENTRIFUGE_RECIPES;
import static gregtech.api.recipes.RecipeMaps.CHEMICAL_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;

public class MolybdenumProcessing {

    public static void init(){
        molybdenum();
        rhenium();
    }

    private static void molybdenum() {
        // MoS2 + 9O -> MoO3 + 2SO2 + ReO2
        ROASTER_RECIPES.recipeBuilder()
                .input(dust, Molybdenite, 3)
                .fluidInputs(Oxygen.getFluid(8000))
                .output(dust, MolybdenumTrioxide, 4)
                .fluidOutputs(SulfurDioxide.getFluid(2000))
                .fluidOutputs(MolybdenumFlue.getFluid(1000))
                .temperature(1400)
                .duration(200)
                .EUt(VA[MV])
                .buildAndRegister();

        // MoO3 + 6H -> Mo + 3H2O
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, MolybdenumTrioxide, 4)
                .fluidInputs(Hydrogen.getFluid(6000))
                .output(dust, Molybdenum)
                .fluidOutputs(Water.getFluid(3000))
                .duration(200)
                .EUt(VA[HV])
                .buildAndRegister();

        // CaMoO4 + 2HCl -> MoO3 + CaCl2 + H2O
        RecipeMaps.CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, Powellite, 6)
                .fluidInputs(HydrochloricAcid.getFluid(2000))
                .output(dust, MolybdenumTrioxide, 4)
                .output(dust, CalciumChloride, 3)
                .fluidOutputs(Water.getFluid(1000))
                .duration(200)
                .EUt(VA[HV])
                .buildAndRegister();

        // PbMoO4 + 2HCl -> MoO3 + H2O + PbCl2
        RecipeMaps.CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, Wulfenite, 6)
                .fluidInputs(HydrochloricAcid.getFluid(2000))
                .output(dust, MolybdenumTrioxide, 4)
                .output(dust, LeadChloride, 3)
                .fluidOutputs(Water.getFluid(1000))
                .duration(200)
                .EUt(VA[HV])
                .buildAndRegister();
    }

    private static void rhenium() {
        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(MolybdenumFlue.getFluid(1000))
                .chancedOutput(dust, MolybdenumTrioxide, 1000, 0)
                .fluidOutputs(TraceRheniumFlue.getFluid(500))
                .duration(200).EUt(60).buildAndRegister();

        // ReO2 + Na2CO3 + NaOH + 3Cl -> HReO4 + 3NaCl + CO2
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, SodaAsh, 6)
                .input(dust, SodiumHydroxide, 3)
                .fluidInputs(TraceRheniumFlue.getFluid(1000))
                .fluidInputs(Chlorine.getFluid(3000))
                .output(dust, PerrhenicAcid, 6)
                .output(dust, Salt, 6)
                .fluidOutputs(CarbonDioxide.getFluid(1000))
                .duration(100).EUt(VA[IV]).buildAndRegister();

        // HReO4 + NH3 -> NH4ReO4
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, PerrhenicAcid, 6)
                .fluidInputs(Ammonia.getFluid(1000))
                .output(dust, AmmoniumPerrhenate, 10)
                .duration(100).EUt(VA[EV]).buildAndRegister();

        // NH4ReO4 + H2S -> Re + NH3 + H2SO4 + H (H lost)
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, AmmoniumPerrhenate, 10)
                .fluidInputs(HydrogenSulfide.getFluid(1000))
                .output(dust, Rhenium)
                .fluidOutputs(Ammonia.getFluid(1000))
                .fluidOutputs(SulfuricAcid.getFluid(1000))
                .duration(100).EUt(VA[EV]).buildAndRegister();

    }
}
