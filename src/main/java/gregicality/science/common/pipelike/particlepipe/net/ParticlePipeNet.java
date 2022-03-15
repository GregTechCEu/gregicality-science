package gregicality.science.common.pipelike.particlepipe.net;

import gregtech.api.pipenet.Node;
import gregtech.api.pipenet.PipeNet;
import gregtech.api.pipenet.WorldPipeNet;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParticlePipeNet extends PipeNet<ParticleNodeData> {


    private final Map<BlockPos, List<ParticleInventory>> NET_DATA = new HashMap<>();

    public ParticlePipeNet(WorldPipeNet<ParticleNodeData, ? extends PipeNet> worldPipeNet) {
        super(worldPipeNet);
    }

    public List<ParticleInventory> getNetData(BlockPos pipePos, EnumFacing facing) {
        List<ParticleInventory> data = NET_DATA.get(pipePos);
        if (data == null) {
            // TODO
        }
        return data;
    }

    public void nodeNeighbourChanged(BlockPos pos) {
        NET_DATA.clear();
    }

    @Override
    protected void updateBlockedConnections(BlockPos nodePos, EnumFacing facing, boolean isBlocked) {
        super.updateBlockedConnections(nodePos, facing, isBlocked);
        NET_DATA.clear();
    }

    @Override
    protected void transferNodeData(Map<BlockPos, Node<ParticleNodeData>> transferredNodes, PipeNet<ParticleNodeData> parentNet) {
        super.transferNodeData(transferredNodes, parentNet);
        NET_DATA.clear();
        ((ParticlePipeNet) parentNet).NET_DATA.clear();
    }

    @Override
    protected void writeNodeData(ParticleNodeData particleNodeData, NBTTagCompound nbtTagCompound) {

    }

    @Override
    protected ParticleNodeData readNodeData(NBTTagCompound nbtTagCompound) {
        return new ParticleNodeData();
    }

    public static class ParticleInventory {
        private final BlockPos pipePos;
        private final EnumFacing faceToHandler;
        private final int distance;
        private final ParticleNodeData properties;

        public ParticleInventory(BlockPos pipePos, EnumFacing facing, int distance, ParticleNodeData properties) {
            this.pipePos = pipePos;
            this.faceToHandler = facing;
            this.distance = distance;
            this.properties = properties;
        }

        public BlockPos getPipePos() {
            return pipePos;
        }

        public EnumFacing getFaceToHandler() {
            return faceToHandler;
        }

        public int getDistance() {
            return distance;
        }

        public ParticleNodeData getProperties() {
            return properties;
        }

        public BlockPos getHandlerPos() {
            return pipePos.offset(faceToHandler);
        }
    }
}
