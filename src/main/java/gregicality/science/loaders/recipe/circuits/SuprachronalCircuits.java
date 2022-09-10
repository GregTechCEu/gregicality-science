package gregicality.science.loaders.recipe.circuits;

import gregicality.science.api.recipes.GCYSRecipeMaps;
import gregicality.science.api.unification.materials.GCYSMaterials;
import gregicality.science.common.block.GCYSMetaBlocks;
import gregicality.science.common.block.blocks.BlockMultiblockCasing;
import gregicality.science.common.items.GCYSMetaItems;
import gregicality.science.common.metatileentities.GCYSMetaTileEntities;
import gregtech.api.GTValues;
import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.common.blocks.BlockMachineCasing;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.items.MetaItems;
import net.minecraft.item.ItemStack;

public class SuprachronalCircuits {

    private static final Material[] tierList = {
            MarkerMaterials.Tier.ULV,
            MarkerMaterials.Tier.LV,
            MarkerMaterials.Tier.MV,
            MarkerMaterials.Tier.HV,
            MarkerMaterials.Tier.EV,
            MarkerMaterials.Tier.IV,
            MarkerMaterials.Tier.LuV,
            MarkerMaterials.Tier.ZPM,
            MarkerMaterials.Tier.UV,
            MarkerMaterials.Tier.UHV,
            MarkerMaterials.Tier.UEV,
            MarkerMaterials.Tier.UIV,
            MarkerMaterials.Tier.UXV,
            MarkerMaterials.Tier.OpV,
            MarkerMaterials.Tier.MAX
    };

    private static final ItemStack[] suprachronals = {
            GCYSMetaItems.SUPRACHRONAL_ULV.getStackForm(),
            GCYSMetaItems.SUPRACHRONAL_LV.getStackForm(),
            GCYSMetaItems.SUPRACHRONAL_MV.getStackForm(),
            GCYSMetaItems.SUPRACHRONAL_HV.getStackForm(),
            GCYSMetaItems.SUPRACHRONAL_EV.getStackForm(),
            GCYSMetaItems.SUPRACHRONAL_IV.getStackForm(),
            GCYSMetaItems.SUPRACHRONAL_LuV.getStackForm(),
            GCYSMetaItems.SUPRACHRONAL_ZPM.getStackForm(),
            GCYSMetaItems.SUPRACHRONAL_UV.getStackForm(),
            GCYSMetaItems.SUPRACHRONAL_UHV.getStackForm(),
            GCYSMetaItems.SUPRACHRONAL_UEV.getStackForm(),
            GCYSMetaItems.SUPRACHRONAL_UIV.getStackForm(),
            GCYSMetaItems.SUPRACHRONAL_UXV.getStackForm(),
            GCYSMetaItems.SUPRACHRONAL_OpV.getStackForm(),
            GCYSMetaItems.SUPRACHRONAL_MAX.getStackForm(),
    };

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
                .inputs(MetaItems.EMITTER_OpV.getStackForm())
                .inputs(MetaItems.SENSOR_OpV.getStackForm())
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

        //TODO Add Trinium-Tritanium and use it as a fluid input for this
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaItems.SENSOR_OpV.getStackForm())
                .inputs(MetaItems.ROBOT_ARM_OpV.getStackForm())
                .inputs(MetaItems.FIELD_GENERATOR_OpV.getStackForm())
                .inputs(MetaItems.ELECTRIC_PUMP_OpV.getStackForm())
                .input(OrePrefix.plate, GCYSMaterials.ReissnerNordstromMatrix, 16)
                .input(OrePrefix.circuit, MarkerMaterials.Tier.MAX, 8)
                .input(OrePrefix.battery, MarkerMaterials.Tier.MAX, 2)
                .fluidInputs(Materials.Naquadria.getFluid(1296))
                .fluidInputs(GCYSMaterials.Taranium.getFluid(1296))
                .fluidInputs(GCYSMaterials.SentientMetal.getFluid(1296))
                .outputs(GCYSMetaItems.HYPERDIMENSIONAL_DRONE.getStackForm())
                .duration(600)
                .EUt(GTValues.VA[13])
                .buildAndRegister();

        for(int tier = 0; tier < 15; tier++) {

            GCYSRecipeMaps.SUPRACHRONAL_ASSEMBLER_RECIPES.recipeBuilder()
                    .notConsumable(GCYSMetaItems.HYPERDIMENSIONAL_DRONE.getStackForm())
                    .notConsumable(new IntCircuitIngredient(tier))
                    .outputs(suprachronals[tier])
                    .duration(600)
                    .EUt(GTValues.VA[tier])
                    .buildAndRegister();

        }

    }

}
