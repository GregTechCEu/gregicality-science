package gregicality.science.loaders.recipe.rockets;

import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;

import static gregicality.science.api.recipes.GCYSRecipeMaps.LAUNCHPAD_RECIPES;

public class RocketRecipes {

    public static void init() {

        //Temporary recipe for testing
        LAUNCHPAD_RECIPES.recipeBuilder()
                .input(OrePrefix.ingot, Materials.Iron)
                .output(OrePrefix.gemExquisite, Materials.Diamond)
                .duration(20)
                .EUt(20)
                .buildAndRegister();
    }
}
