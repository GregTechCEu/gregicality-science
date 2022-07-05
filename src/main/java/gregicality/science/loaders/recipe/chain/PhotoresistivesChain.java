package gregicality.science.loaders.recipe.chain;

import static gregicality.science.api.recipes.GCYSRecipeMaps.CVD_RECIPES;
import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;

public class PhotoresistivesChain {

    public static void init() {
        grignardReagent();
        dimethylcadmium();
        cadmiumSulfide();
        cadmiumSelenide();
    }

    private static void grignardReagent() {
        // C2H4 + 2Br -> C2H4Br2
        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Ethylene.getFluid(1000))
                .fluidInputs(Bromine.getFluid(2000))
                .fluidOutputs(EthyleneDibromide.getFluid(3000))
                .duration(100).EUt(VA[MV]).buildAndRegister();

        // Mg + C2H4Br2 -> CH3MgBr + HBr + C (C lost)
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Magnesium)
                .fluidInputs(EthyleneDibromide.getFluid(3000))
                .fluidOutputs(GrignardReagent.getFluid(1000))
                .fluidOutputs(HydrobromicAcid.getFluid(1000))
                .duration(100).EUt(VA[LV]).buildAndRegister();
    }

    private static void dimethylcadmium() {
        // Cd + 2Br -> CdBr2
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Cadmium)
                .fluidInputs(Bromine.getFluid(2000))
                .output(dust, CadmiumBromide, 3)
                .duration(100).EUt(16).buildAndRegister();

        // CdBr2 + 2CH3MgBr -> (CH3)2Cd + 2MgBr2
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, CadmiumBromide, 3)
                .fluidInputs(GrignardReagent.getFluid(2000))
                .output(dust, MagnesiumBromide, 6)
                .fluidOutputs(Dimethylcadmium.getFluid(1000))
                .duration(100).EUt(VA[IV]).buildAndRegister();
    }

    private static void cadmiumSulfide() {
        // 2C2H4 + H2S -> C4H10S
        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Ethylene.getFluid(2000))
                .fluidInputs(HydrogenSulfide.getFluid(1000))
                .fluidOutputs(DiethylSuflide.getFluid(3000))
                .duration(150).EUt(16).buildAndRegister();

        // C4H10S -> 2C2H4 + H2S
        ELECTROLYZER_RECIPES.recipeBuilder()
                .fluidInputs(DiethylSuflide.getFluid(3000))
                .fluidOutputs(Ethylene.getFluid(2000))
                .fluidOutputs(HydrogenSulfide.getFluid(1000))
                .duration(340).EUt(7).buildAndRegister();

        // Cd(CH3)2 + C4H10S -> CdS + C2H6 + C4H10
        CVD_RECIPES.recipeBuilder()
                .fluidInputs(Dimethylcadmium.getFluid(1000))
                .fluidInputs(DiethylSuflide.getFluid(3000))
                .output(dust, CadmiumSulfide, 2)
                .fluidOutputs(Ethane.getFluid(1000))
                .fluidOutputs(Butane.getFluid(1000))
                .duration(100).EUt(VA[LuV]).buildAndRegister();
    }

    //TODO implement
    private static void cadmiumSelenide() {

    }
}
