package gregicality.science.loaders.recipe.chain;

import gregtech.api.recipes.ingredients.IntCircuitIngredient;

import static gregicality.science.api.recipes.GCYSRecipeMaps.*;
import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregicality.science.api.unification.ore.GCYSOrePrefix.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

/**
 * Adds recipes for simple materials with few steps
 */
public class SimpleMaterials {

    public static void init() {
        siliconCarbide();
        lithiumNiobate();
        bscco();
        advancedSolder();
    }

    private static void siliconCarbide() {
        // produced via the Lely Method
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Graphite)
                .input(dust, Silicon)
                .notConsumable(new IntCircuitIngredient(1))
                .output(dust, SiliconCarbide, 2)
                .duration(300).EUt(VA[EV]).buildAndRegister();
    }

    private static void lithiumNiobate() {
        // 2LiOH + H2O2 -> Li2O2 + 2H2O
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, LithiumHydroxide, 6)
                .fluidInputs(HydrogenPeroxide.getFluid(1000))
                .output(dust, LithiumPeroxide, 4)
                .fluidOutputs(Water.getFluid(2000))
                .duration(300).EUt(VA[LV]).buildAndRegister();

        // Li2O2 -> Li2O + O
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, LithiumPeroxide, 4)
                .output(dust, LithiumOxide, 3)
                .fluidOutputs(Oxygen.getFluid(1000))
                .duration(600).EUt(VA[MV]).buildAndRegister();

        // 2Nb + 5O -> Nb2O5
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Niobium, 2)
                .fluidInputs(Oxygen.getFluid(5000))
                .output(dust, NiobiumPentoxide, 7)
                .duration(50).EUt(VA[LV]).buildAndRegister();

        AUTOCLAVE_RECIPES.recipeBuilder()
                .input(dust, NiobiumPentoxide, 14)
                .input(dust, Magnesia, 4)
                .fluidInputs(DistilledWater.getFluid(8000))
                .output(seedCrystal, LithiumNiobate)
                .duration(900).EUt(VA[IV]).buildAndRegister();
    }

    private static void bscco() {
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Copper)
                .fluidInputs(Oxygen.getFluid(1000))
                .output(dust, CupricOxide, 2)
                .duration(50).EUt(VA[LV]).buildAndRegister();

        // SrSO4 + 2C -> SrS + 2CO2
        ROASTER_RECIPES.recipeBuilder()
                .input(dust, Celestine, 6)
                .input(dust, Carbon, 2)
                .output(dust, StrontiumSulfide, 2)
                .fluidOutputs(CarbonDioxide.getFluid(2000))
                .temperature(1600)
                .duration(400).EUt(VA[EV]).buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, Celestine, 6)
                .input(gem, Coke)
                .output(dust, StrontiumSulfide, 2)
                .fluidOutputs(CarbonDioxide.getFluid(2000))
                .temperature(1600)
                .duration(400).EUt(VA[EV]).buildAndRegister();

        // SrS + CO2 + H2O -> SrCO3 + H2S
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, StrontiumSulfide, 2)
                .fluidInputs(Water.getFluid(1000))
                .fluidInputs(CarbonDioxide.getFluid(1000))
                .output(dust, StrontiumCarbonate, 5)
                .fluidOutputs(HydrogenSulfide.getFluid(1000))
                .duration(900).EUt(VA[EV]).buildAndRegister();

        // SrS + Na2CO3 -> SrCO3 + Na2S
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, StrontiumSulfide, 2)
                .input(dust, SodaAsh, 6)
                .output(dust, StrontiumCarbonate, 5)
                .output(dust, SodiumSulfide, 3)
                .duration(300).EUt(VA[EV]).buildAndRegister();

        // Bi2O3 + 2SrCO3 + CaCO3 + 2CuO -> Bi2Sr2CaCu2O8 (Loss of O and CO2)
        MIXER_RECIPES.recipeBuilder()
                .input(dust, BismuthTrioxide, 5)
                .input(dust, StrontiumCarbonate, 10)
                .input(dust, Calcite, 5)
                .input(dust, CupricOxide, 4)
                .output(dust, BSCCO, 15)
                .duration(1200).EUt(VA[LuV]).buildAndRegister();
    }

    public static void advancedSolder() {
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Tin, 4)
                .input(dust, Lead, 3)
                .input(dust, Bismuth, 1)
                .input(dust, Cadmium, 1)
                .input(dust, Indium, 1)
                .fluidOutputs(AdvancedSolder.getFluid(4000))
                .duration(400).EUt(VA[LuV]).buildAndRegister();
    }
}
