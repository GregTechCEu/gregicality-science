package gregicality.science.loaders.recipe.circuits;

import gregicality.science.api.unification.materials.GCYSMaterials;
import gregicality.science.common.block.GCYSMetaBlocks;
import gregicality.science.common.block.blocks.BlockMultiblockCasing;
import gregicality.science.common.items.GCYSMetaItems;
import gregicality.science.common.metatileentities.GCYSMetaTileEntities;
import gregtech.api.GTValues;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.common.blocks.BlockMachineCasing;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.items.MetaItems;

public class SuprachronalCircuits {

    public static void init() {
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(OrePrefix.plate, GCYSMaterials.ReissnerNordstromMatrix)
                .input(OrePrefix.frameGt, GCYSMaterials.ReissnerNordstromMatrix)
                .input(OrePrefix.stick, GCYSMaterials.ReissnerNordstromMatrix)
                .input(OrePrefix.stick, GCYSMaterials.QCDConfinedMatter)
                .fluidInputs(Materials.Neutronium.getFluid(1296))
                .fluidInputs(GCYSMaterials.SentientMetal.getFluid(1296))
                .outputs(GCYSMetaBlocks.MULTIBLOCK_CASING.getItemVariant(BlockMultiblockCasing.CasingType.SUPRACHRONAL_CASING))
                .duration(200)
                .EUt(GTValues.VA[12])
                .buildAndRegister();

        //TODO Add Teralloy and make its fluid used in this recipe
        //TODO Add Quark-Gluon plasma and make its fluid used in this recipe
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(GCYSMetaBlocks.MULTIBLOCK_CASING.getItemVariant(BlockMultiblockCasing.CasingType.SUPRACHRONAL_CASING))
                .inputs(MetaItems.EMITTER_UXV.getStackForm())
                .inputs(MetaItems.SENSOR_UXV.getStackForm())
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.UXV))
                .inputs(GCYSMetaItems.EIGENFOLDED_KERR_MANIFOLD.getStackForm())
                .input(OrePrefix.plate, GCYSMaterials.QCDConfinedMatter)
                .input(OrePrefix.circuit, MarkerMaterials.Tier.MAX)
                .fluidInputs(GCYSMaterials.Taranium.getFluid(144))
                .fluidInputs(GCYSMaterials.SentientMetal.getFluid(1296))
                .outputs(GCYSMetaTileEntities.SUPRACHRONAL_ASSEMBLER.getStackForm())
                .duration(600)
                .EUt(GTValues.VA[13])
                .buildAndRegister();
    }

}
