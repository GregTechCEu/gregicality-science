package gregicality.science.loaders.recipe;

import gregicality.science.loaders.recipe.chain.*;
import gregicality.science.loaders.recipe.circuits.BiowareCircuits;
import gregicality.science.loaders.recipe.vacuum.VacuumRecipes;

public class GCYSRecipeLoader {

    public static void init() {
        initHandlers();
        initChains();
        initCircuits();
        RecipeConflicts.init();
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
        AcetyleneChain.init();
        TurpentineChain.init();
        EDTAChain.init();
        BiowareCellsChain.init();
    }

    private static void initCircuits() {
        BiowareCircuits.init();
    }
}
