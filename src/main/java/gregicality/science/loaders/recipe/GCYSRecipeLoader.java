package gregicality.science.loaders.recipe;

import gregicality.science.loaders.recipe.chain.*;
import gregicality.science.loaders.recipe.circuits.*;
import gregicality.science.loaders.recipe.component.GCYSComponentRecipes;
import gregicality.science.loaders.recipe.handlers.BouleRecipeHandler;
import gregicality.science.loaders.recipe.oreprocessing.*;

public class GCYSRecipeLoader {

    public static void init() {
        initChains();
        initOreProcessing();
        initCircuits();
        MiscRecipes.init();
        RecipeConflicts.init();
        GCYSComponentRecipes.init();
        GCYSMetaTileEntityLoader.init();
        GCYSBlockRecipeLoader.init();
    }

    public static void initHandlers() {
        BouleRecipeHandler.register();
    }

    private static void initChains() {
        GrapheneChain.init();
        HydrogenPeroxideChain.init();
        AcetyleneChain.init();
        TurpentineChain.init();
        EDTAChain.init();
        EtchingMaterialsChain.init();
        OilProcessing.init();
        DimethylformamideChain.init();
        KaptonChain.init();
        AmmoniaChain.init();
        BrineChain.init();
        MethylamineChain.init();
        KevlarChain.init();
        BoronNitrideChain.init();
        BZChain.init();
        PhosphorusChain.init();
        EthyleneGlycolChain.init();
        PMMAChain.init();
        GalliumNitrideChain.init();
        PhotoresistivesChain.init();
        MagneticsChain.init();
        NanotubesChain.init();
        IsotopesChain.init();
        FullereneChain.init();
        FantasyMaterials.init();
        SimpleMaterials.init();
        PedotChain.init();
    }

    private static void initOreProcessing() {
        PlatinumGroupProcessing.init();
        RareEarthProcessing.init();
        TungstenProcessing.init();
        GermaniumProcessing.init();
        NiobiumTantalumChain.init();
        SeleniumTelluriumChain.init();
        MolybdenumProcessing.init();
        ThalliumProcessing.init();
        TaraniumProcessing.init();
        RubidiumProcessing.init();
    }

    private static void initCircuits() {
        PrimitiveCircuits.init();
        CrystalCircuits.init();
        WetwareCircuits.init();
        GoowareCircuits.init();
        OpticalCircuits.init();
        SpintronicCircuits.init();
    }
}
