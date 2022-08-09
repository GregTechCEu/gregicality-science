package gregicality.science.loaders.recipe;

import gregicality.science.common.block.GCYSMetaBlocks;
import gregicality.science.common.block.blocks.BlockTransparentCasing;

import static gregicality.science.api.unification.materials.GCYSMaterials.FracturingFluid;
import static gregicality.science.api.unification.materials.GCYSMaterials.PMMA;
import static gregtech.api.GTValues.IV;
import static gregtech.api.GTValues.VA;
import static gregtech.api.recipes.RecipeMaps.COMPRESSOR_RECIPES;
import static gregtech.api.recipes.RecipeMaps.MIXER_RECIPES;
import static gregtech.api.unification.material.Materials.Alumina;
import static gregtech.api.unification.material.Materials.Water;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static gregtech.api.unification.ore.OrePrefix.plate;

/**
 * Use this class to add miscellaneous recipes which have no category otherwise
 */
public class MiscRecipes {

    public static void init() {
        //TODO add Iodine-131 gas or liquid
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Alumina)
                .input("blockSand", 3)
                .fluidInputs(Water.getFluid(1000))
                .fluidOutputs(FracturingFluid.getFluid(1000))
                .duration(100).EUt(VA[IV]).buildAndRegister();

        metaBlockRecipes();
    }

    private static void metaBlockRecipes() {
        COMPRESSOR_RECIPES.recipeBuilder()
                .input(plate, PMMA, 4)
                .outputs(GCYSMetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockTransparentCasing.CasingType.PMMA))
                .duration(400).EUt(2).buildAndRegister();
    }
}
