package gregicality.science.loaders.recipe.chain;

import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregtech.api.GTValues.L;
import static gregtech.api.recipes.RecipeMaps.CHEMICAL_RECIPES;
import static gregtech.api.recipes.RecipeMaps.MIXER_RECIPES;
import static gregtech.api.unification.material.Materials.*;

/**
 * Cyanohydrin Route
 */
public class PMMAChain {

    public static void init() {
        // (CH3)2CO + HCN -> C4H7NO
        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Acetone.getFluid(1000))
                .fluidInputs(HydrogenCyanide.getFluid(1000))
                .fluidOutputs(AcetoneCyanohydrin.getFluid(2000))
                .duration(150).EUt(240).buildAndRegister();

        // C4H7NO + CH3OH -> C5H8O2 + NH3
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(AcetoneCyanohydrin.getFluid(2000))
                .fluidInputs(Methanol.getFluid(1000))
                .fluidOutputs(PMMA.getFluid(L * 4))
                .fluidOutputs(Ammonia.getFluid(1000))
                .duration(200).EUt(240).buildAndRegister();
    }
}
