package gregicality.science.loaders.recipe.vacuum;

import static gregicality.science.api.recipes.GCYSRecipeMaps.STEAM_EJECTOR_RECIPES;
import static gregtech.api.unification.material.Materials.Steam;

public class VacuumRecipes {

    public static void init() {
        STEAM_EJECTOR_RECIPES.recipeBuilder()
                .fluidInputs(Steam.getFluid(1))
                .duration(200).EUt(1)
                .buildAndRegister();
    }
}
