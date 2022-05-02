package gregicality.science.loaders.recipe.chain;

import gregtech.api.recipes.RecipeMaps;

import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.GTValues.*;

public class GasLiquefactionChain {
    //Other gases to be added in the future
    public static void init(){
        RecipeMaps.VACUUM_RECIPES.recipeBuilder()
                .fluidInputs(Helium.getFluid(1000))
                .fluidOutputs(LiquidHelium.getFluid(1000))
                .duration(300).EUt(VA[EV]).buildAndRegister();
    }
}
