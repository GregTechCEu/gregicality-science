package gregicality.science.loaders.recipe.chain;

import gregtech.api.recipes.ingredients.IntCircuitIngredient;

import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregicality.science.api.unification.ore.GCYSOrePrefix.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;

/**
 * Adds recipes for simple materials with few steps
 */
public class SimpleMaterials {

    public static void init() {
        siliconCarbide();
        lithiumNiobate();
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
}
