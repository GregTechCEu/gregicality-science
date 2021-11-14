package gregicality.science.integration.jei.multi;

import com.google.common.collect.Lists;
import gregicality.science.common.block.GCYSciMetaBlocks;
import gregicality.science.common.block.GAQuantumCasing;
import gregicality.science.common.machine.GCYSciTileEntities;
import gregtech.api.metatileentity.multiblock.MultiblockControllerBase;
import gregtech.common.metatileentities.MetaTileEntities;
import gregtech.integration.jei.multiblock.MultiblockInfoPage;
import gregtech.integration.jei.multiblock.MultiblockShapeInfo;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.EnumFacing;

import java.util.List;

public class QubitComputerInfo extends MultiblockInfoPage {

    @Override
    public MultiblockControllerBase getController() {
        return GCYSciTileEntities.QUBIT_COMPUTER;
    }

    @Override
    public List<MultiblockShapeInfo> getMatchingShapes() {
        return Lists.newArrayList(MultiblockShapeInfo.builder()
                .aisle("CC", "IC", "CC", "CC")
                .aisle("OC", "SC", "CC", "CC")
                .aisle("EC", "MC", "CC", "CC")
                .aisle("CC", "CC", "CC", "CC")
                .where('S', GCYSciTileEntities.QUBIT_COMPUTER, EnumFacing.WEST)
                .where('M', maintenanceIfEnabled(GCYSciMetaBlocks.QUANTUM_CASING.getState(GAQuantumCasing.CasingType.COMPUTER)), EnumFacing.WEST)
                .where('C', GCYSciMetaBlocks.QUANTUM_CASING.getState(GAQuantumCasing.CasingType.COMPUTER))
                .where('I', MetaTileEntities.ITEM_IMPORT_BUS[4], EnumFacing.WEST)
                .where('O', GCYSciTileEntities.QBIT_OUTPUT_HATCH[0], EnumFacing.WEST)
                .where('E', MetaTileEntities.ENERGY_INPUT_HATCH[4], EnumFacing.WEST)
                .build());
    }

    @Override
    public String[] getDescription() {
        return new String[] {I18n.format("gtadditions.multiblock.qubit_computer.description")};
    }


    @Override
    public float getDefaultZoom() {
        return 1.1f;
    }
}
