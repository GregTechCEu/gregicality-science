package gregicality.science.loaders.recipe;

import gregicality.science.loaders.recipe.chain.*;
import gregicality.science.loaders.recipe.circuits.CrystalCircuits;
import gregicality.science.loaders.recipe.circuits.GoowareCircuits;
import gregicality.science.loaders.recipe.circuits.OpticalCircuits;
import gregicality.science.loaders.recipe.circuits.SpintronicCircuits;
import gregicality.science.loaders.recipe.handlers.BouleRecipeHandler;
import gregicality.science.loaders.recipe.oreprocessing.GermaniumProcessing;
import gregicality.science.loaders.recipe.oreprocessing.PlatinumGroupProcessing;
import gregicality.science.loaders.recipe.oreprocessing.RareEarthProcessing;
import gregicality.science.loaders.recipe.oreprocessing.TungstenProcessing;
import gregicality.science.loaders.recipe.vacuum.VacuumRecipes;

public class GCYSRecipeLoader {

    public static void init() {
        initHandlers();
        initChains();
        initOreProcessing();
        initCircuits();
        RecipeConflicts.init();
        VacuumRecipes.init();
        GCYSMetaTileEntityLoader.init();
    }

    private static void initHandlers() {
        BouleRecipeHandler.register();
    }

    private static void initChains() {
        RareEarthProcessing.init();
        TungstenProcessing.init();
        GrapheneChain.init();
        HydrogenPeroxideChain.init();
        NiobiumTantalumChain.init();
        AcetyleneChain.init();
        TurpentineChain.init();
        EDTAChain.init();
        EtchingMaterialsChain.init();
        OilProcessing.init();
        DimethylformamideChain.init();
        KaptonChain.init();
        AmmoniaChain.init();
        MolybdenumChain.init();
        BrineChain.init();
        SeleniumTelluriumChain.init();
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
    }

    private static void initOreProcessing() {
        PlatinumGroupProcessing.init();
        GermaniumProcessing.init();
    }

    private static void initCircuits() {
        CrystalCircuits.init();
        GoowareCircuits.init();
        OpticalCircuits.init();
        SpintronicCircuits.init();
    }
}
