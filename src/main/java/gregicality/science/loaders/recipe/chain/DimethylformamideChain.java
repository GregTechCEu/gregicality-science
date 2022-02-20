package gregicality.science.loaders.recipe.chain;

import static gregicality.science.api.unification.materials.GCYSMaterials.Dimethylformamide;
import static gregtech.api.GTValues.IV;
import static gregtech.api.GTValues.VA;
import static gregtech.api.recipes.RecipeMaps.LARGE_CHEMICAL_RECIPES;
import static gregtech.api.unification.material.Materials.CarbonMonoxide;
import static gregtech.api.unification.material.Materials.Dimethylamine;

public class DimethylformamideChain {

    public static void init() {
        // TODO Full DMF Processing via Dimethylamine Hydrochloride and Potassium Formate

        // (CH3)2NH + CO -> (CH3)2NC(O)H
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Dimethylamine.getFluid(1000))
                .fluidInputs(CarbonMonoxide.getFluid(1000))
                .fluidOutputs(Dimethylformamide.getFluid(1000))
                .duration(400).EUt(VA[IV]).buildAndRegister();
    }
}
