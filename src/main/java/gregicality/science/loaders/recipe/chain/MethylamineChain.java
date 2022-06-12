package gregicality.science.loaders.recipe.chain;

import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.DISTILLATION_RECIPES;
import static gregtech.api.recipes.RecipeMaps.MIXER_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;

public class MethylamineChain {

    public static void init() {
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Kyanite)
                .fluidInputs(Methanol.getFluid(2000))
                .fluidInputs(Ammonia.getFluid(1000))
                .fluidOutputs(MethylamineMixture.getFluid(3000))
                .duration(1000)
                .EUt(VA[HV])
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dust, Alumina)
                .input(dust, SiliconDioxide)
                .fluidInputs(Methanol.getFluid(2000))
                .fluidInputs(Ammonia.getFluid(1000))
                .fluidOutputs(MethylamineMixture.getFluid(3000))
                .duration(1000)
                .EUt(VA[HV])
                .buildAndRegister();

        // 6CH3OH + 3NH3 -> CH3NH2 + (CH3)2NH2 + (CH3)3NH2 + 3H2O
        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(MethylamineMixture.getFluid(9000))
                .fluidOutputs(Methylamine.getFluid(1000))
                .fluidOutputs(Dimethylamine.getFluid(1000))
                .fluidOutputs(Trimethylamine.getFluid(1000))
                .fluidOutputs(Water.getFluid(3000))
                .duration(1000)
                .EUt(VA[LuV])
                .disableDistilleryRecipes()
                .buildAndRegister();
    }
}
