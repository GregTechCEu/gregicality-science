package gregicality.science.loaders.recipe;

import gregicality.science.loaders.recipe.chain.PlatinumGroupProcessing;
import gregicality.science.loaders.recipe.chain.RareEarthProcessing;
import gregicality.science.loaders.recipe.vacuum.VacuumRecipes;

public class GCYSRecipeLoader {

    public static void init() {
        initChains();
        VacuumRecipes.init();
    }

    private static void initChains() {
        RareEarthProcessing.init();
        PlatinumGroupProcessing.init();
    }
}
