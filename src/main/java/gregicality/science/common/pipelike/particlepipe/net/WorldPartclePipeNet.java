package gregicality.science.common.pipelike.particlepipe.net;

import gregicality.science.common.pipelike.particlepipe.ParticlePipeType;
import gregtech.api.pipenet.WorldPipeNet;
import net.minecraft.world.World;

public class WorldPartclePipeNet extends WorldPipeNet<ParticleNodeData, ParticlePipeNet> {
    private static final String DATA_ID = "gcym.particle_pipe_net";

    public WorldPartclePipeNet(String name) {
        super(name);
    }

    public static WorldPartclePipeNet getWorldPipeNet(World world) {
        WorldPartclePipeNet netWorldData = (WorldPartclePipeNet) world.loadData(WorldPartclePipeNet.class, DATA_ID);
        if (netWorldData == null) {
            netWorldData = new WorldPartclePipeNet(DATA_ID);
            world.setData(DATA_ID, netWorldData);
        }
        netWorldData.setWorldAndInit(world);
        return netWorldData;
    }

    @Override
    protected ParticlePipeNet createNetInstance() {
        return new ParticlePipeNet(this);
    }
}
