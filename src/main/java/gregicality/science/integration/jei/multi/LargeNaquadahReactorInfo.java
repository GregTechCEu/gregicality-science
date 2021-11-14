package gregicality.science.integration.jei.multi;

import gregicality.science.common.block.GAMultiblockCasing;
import gregicality.science.common.block.GCYSciMetaBlocks;
import gregicality.science.common.item.metal.MetalCasing2;
import gregicality.science.common.machine.GCYSciTileEntities;
import gregicality.science.integration.jei.GAMultiblockShapeInfo;
import gregtech.api.metatileentity.multiblock.MultiblockControllerBase;
import gregtech.common.blocks.BlockBoilerCasing;
import gregtech.common.blocks.BlockFusionCoil;
import gregtech.common.blocks.BlockMultiblockCasing;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.metatileentities.MetaTileEntities;
import gregtech.integration.jei.multiblock.MultiblockInfoPage;
import gregtech.integration.jei.multiblock.MultiblockShapeInfo;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.EnumFacing;

import java.util.Collections;
import java.util.List;

import static gregtech.api.unification.material.Materials.Naquadria;


public class LargeNaquadahReactorInfo extends MultiblockInfoPage {

    @Override
    public MultiblockControllerBase getController() {
        return GCYSciTileEntities.LARGE_NAQUADAH_REACTOR;
    }

    @Override
    public List<MultiblockShapeInfo> getMatchingShapes() {
        MultiblockShapeInfo.Builder builder = GAMultiblockShapeInfo.builder()
                .aisle("#CMC#", "#CSC#", "#CCC#", "##C##", "##C##", "#CCC#", "#CGC#", "#CCC#")
                .aisle("CCCCC", "CPAPC", "CgAgC", "#PAP#", "#PAP#", "CgAgC", "CPAPC", "#CCC#")
                .aisle("CCCCf", "GAFAG", "CAFAC", "CAFAC", "CAFAC", "CAFAC", "GAFAG", "#CCC#")
                .aisle("CCCCC", "CPAPC", "CgAgC", "#PAP#", "#PAP#", "CgAgC", "CPAPC", "#CCC#")
                .aisle("#CEC#", "#CGC#", "#CCC#", "##C##", "##C##", "#CCC#", "#CGC#", "#CCC#")
                .where('S', GCYSciTileEntities.LARGE_NAQUADAH_REACTOR, EnumFacing.NORTH)
                .where('M', maintenanceIfEnabled(GCYSciMetaBlocks.METAL_CASING_2.getState(MetalCasing2.CasingType.NAQUADRIA)), EnumFacing.NORTH)
                .where('C', GCYSciMetaBlocks.METAL_CASING_2.getState(MetalCasing2.CasingType.NAQUADRIA))
                .where('f', MetaTileEntities.FLUID_IMPORT_HATCH[4], EnumFacing.EAST)
                .where('E', MetaTileEntities.ENERGY_OUTPUT_HATCH[8], EnumFacing.SOUTH)
                .where('Y', MetaBlocks.FUSION_COIL.getState(BlockFusionCoil.CoilType.FUSION_COIL))
                .where('F', MetaBlocks.FRAMES.get(Naquadria).getDefaultState())
                .where('G', MetaBlocks.MULTIBLOCK_CASING.getState(BlockMultiblockCasing.MultiblockCasingType.GRATE_CASING))
                .where('g', GCYSciMetaBlocks.MUTLIBLOCK_CASING.getState(GAMultiblockCasing.CasingType.TUNGSTENSTEEL_GEARBOX_CASING))
                .where('P', MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.TUNGSTENSTEEL_PIPE))
                .where('T', GCYSciMetaBlocks.MUTLIBLOCK_CASING.getState(GAMultiblockCasing.CasingType.TIERED_HULL_UV));
        return Collections.singletonList(builder.build());

    }

    @Override
    public String[] getDescription() {
        return new String[]{I18n.format("gtadditions.multiblock.large_naquadah_reactor.description")};
    }

    @Override
    public float getDefaultZoom() {
        return 0.6f;
    }
}
