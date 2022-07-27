package gregicality.science.loaders.recipe.chain;

import static gregicality.science.api.recipes.GCYSRecipeMaps.DRYER_RECIPES;
import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregtech.api.GTValues.IV;
import static gregtech.api.GTValues.VA;
import static gregtech.api.recipes.RecipeMaps.CHEMICAL_RECIPES;
import static gregtech.api.recipes.RecipeMaps.MIXER_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;

public class IsotopesChain {

    public static void init() {
        lithiumIsotopes();
    }

    private static void lithiumIsotopes() {
        // LiH + H2O -> LiOH + 2H
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, LithiumHydride, 2)
                .fluidInputs(Water.getFluid(1000))
                .output(dust, LithiumHydroxide, 3)
                .fluidOutputs(Hydrogen.getFluid(2000))
                .duration(50).EUt(8).buildAndRegister();

        // COLEX Process
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Lithium)
                .input(dust, LithiumHydroxide, 3)
                .fluidInputs(Mercury.getFluid(1000))
                .fluidOutputs(LithiumAmalgam.getFluid(1000))
                .duration(80).EUt(240).buildAndRegister();

        // ... except we don't have room in a tower so we use the dryer :(
        // this uses a lot of power to prevent energy exploits via fusion
        DRYER_RECIPES.recipeBuilder()
                .fluidInputs(LithiumAmalgam.getFluid(10000))
                .output(dust, Lithium6)
                .output(dust, Lithium7Hydroxide, 27)
                .fluidOutputs(Mercury.getFluid(10000))
                .duration(800).EUt(VA[IV] / 2).buildAndRegister();
    }
}
