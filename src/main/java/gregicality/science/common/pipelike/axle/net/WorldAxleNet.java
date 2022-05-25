package gregicality.science.common.pipelike.axle.net;

import gregicality.science.common.pipelike.axle.AxlePipeData;
import gregtech.api.pipenet.WorldPipeNet;
import net.minecraft.world.World;

public class WorldAxleNet extends WorldPipeNet<AxlePipeData, AxlePipeNet> {

    private static final String DATA_ID = "gregtech.axle_pipe_net";

    public WorldAxleNet(String name) {
        super(name);
    }

    public static WorldAxleNet getWorldPipeNet(World world) {
        WorldAxleNet netWorldData = (WorldAxleNet) world.loadData(WorldAxleNet.class, DATA_ID);
        if (netWorldData == null) {
            netWorldData = new WorldAxleNet(DATA_ID);
            world.setData(DATA_ID, netWorldData);
        }
        netWorldData.setWorldAndInit(world);
        return netWorldData;
    }

    @Override
    protected AxlePipeNet createNetInstance() {
        return new AxlePipeNet(this);
    }
}
