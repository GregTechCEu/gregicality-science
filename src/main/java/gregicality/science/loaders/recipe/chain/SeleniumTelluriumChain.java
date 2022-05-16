package gregicality.science.loaders.recipe.chain;

import gregtech.api.recipes.ingredients.IntCircuitIngredient;

import static gregicality.science.api.recipes.GCYSRecipeMaps.ROASTER_RECIPES;
import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static gregtech.api.unification.ore.OrePrefix.ingot;

public class SeleniumTelluriumChain {

    public static void init() {
        mud();
        tellurium();
        selenium();
    }

    private static void mud() {
        // CuSO4 + H2O -> H2SO4 + Cu + O
        //TODO 2 Slot electrolyzer
        // uses circuit 2 so it is optional
//        ELECTROLYZER_RECIPES.recipeBuilder()
//                .fluidInputs(BlueVitriol.getFluid(1000))
//                .fluidInputs(Water.getFluid(1000))
//                .circuit(2)
//                .output(dust, Copper)
//                .output(dustSmall, ChalcogenAnodeMud)
//                .fluidOutputs(SulfuricAcid.getFluid(1000))
//                .fluidOutputs(Oxygen.getFluid(1000))
//                .duration(TBD)
//                .EUt(TBD)
//                .buildAndRegister();

        // optional recovery of metals to provide some nice bonus
        CENTRIFUGE_RECIPES.recipeBuilder()
                .input(dust, ChalcogenAnodeMud)
                .output(dust, Silver)
                .chancedOutput(dust, Copper, 1000, 1000)
                .chancedOutput(dust, Gold, 750, 750)
                .duration(300)
                .EUt(64)
                .buildAndRegister();
    }

    private static void tellurium() {
        // Ag2TeSe + 4O + Na2CO3 -> Na2TeO3 + SeO2 + 2Ag + CO2
        ROASTER_RECIPES.recipeBuilder()
                .input(dust, ChalcogenAnodeMud)
                .input(dust, SodaAsh, 6)
                .fluidInputs(Oxygen.getFluid(4000))
                .output(dust, SodiumTellurite, 6)
                .output(dust, SeleniumDioxide, 3)
                .output(ingot, Silver, 2)
                .fluidOutputs(CarbonDioxide.getFluid(1000))
                .duration(600)
                .temperature(1900)
                .EUt(VA[HV])
                .buildAndRegister();

        // Na2TeO3 + H2O -> TeO2 + 2NaOH
        ELECTROLYZER_RECIPES.recipeBuilder()
                .input(dust, SodiumTellurite, 6)
                .fluidInputs(Water.getFluid(1000))
                .notConsumable(new IntCircuitIngredient(2))
                .output(dust, TelluriumDioxide, 3)
                .output(dust, SodiumHydroxide, 6)
                .duration(400)
                .EUt(VA[MV])
                .buildAndRegister();

        // TeO2 + 2SO2 + H2O -> Te + H2SO4 + SO3
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, TelluriumDioxide, 3)
                .fluidInputs(SulfurDioxide.getFluid(2000))
                .fluidInputs(Water.getFluid(1000))
                .output(dust, Tellurium)
                .fluidOutputs(SulfuricAcid.getFluid(1000))
                .fluidOutputs(SulfurTrioxide.getFluid(1000))
                .duration(200)
                .EUt(VA[HV])
                .buildAndRegister();
    }

    private static void selenium() {
        // SeO2 + H2O -> H2SeO3
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, SeleniumDioxide, 3)
                .fluidInputs(Water.getFluid(1000))
                .output(dust, SelenousAcid, 6)
                .duration(400)
                .EUt(VA[MV])
                .buildAndRegister();

        // H2SeO3 + 2SO2 -> Se + H2SO4 + SO3
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, SelenousAcid, 6)
                .fluidInputs(SulfurDioxide.getFluid(2000))
                .output(dust, Selenium)
                .fluidOutputs(SulfuricAcid.getFluid(1000))
                .fluidOutputs(SulfurTrioxide.getFluid(1000))
                .duration(200)
                .EUt(VA[HV])
                .buildAndRegister();
    }
}
