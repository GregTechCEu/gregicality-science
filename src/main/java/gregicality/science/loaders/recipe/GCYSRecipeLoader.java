package gregicality.science.loaders.recipe;

import gregicality.science.loaders.recipe.chain.*;
import gregicality.science.loaders.recipe.vacuum.VacuumRecipes;

public class GCYSRecipeLoader {

    public static void init() {
        initHandlers();
        initChains();
        VacuumRecipes.init();
        GCYSMetaTileEntityLoader.init();
    }

    private static void initHandlers() {

    }

    private static void initChains() {
        RareEarthProcessing.init();
        PlatinumGroupProcessing.init();
        TungstenProcessing.init();
        GrapheneChain.init();
        HydrogenPeroxideChain.init();
        NiobiumTantalumChain.init();
    }
}
