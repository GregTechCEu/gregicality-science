package gregicality.science.loaders.recipe;

import gregicality.science.loaders.recipe.chain.RareEarthProcessing;

public class GCYSRecipeLoader {

    public static void init() {
        initChains();
    }

    private static void initChains() {
        RareEarthProcessing.init();
    }
}
