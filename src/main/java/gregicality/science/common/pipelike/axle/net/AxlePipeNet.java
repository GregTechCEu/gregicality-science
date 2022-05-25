package gregicality.science.common.pipelike.axle.net;

import gregicality.science.api.capability.EnumRotation;
import gregicality.science.api.capability.IRotationContainer;
import gregicality.science.common.pipelike.axle.AxlePipeData;
import gregtech.api.pipenet.PipeNet;
import gregtech.api.pipenet.WorldPipeNet;
import net.minecraft.nbt.NBTTagCompound;

import javax.annotation.Nonnull;
import java.util.stream.Stream;

public class AxlePipeNet extends PipeNet<AxlePipeData> implements IRotationContainer {

    private long netSpeed = 0;
    private int netPower = 0;
    private EnumRotation netRotation = EnumRotation.NONE;

    public AxlePipeNet(WorldPipeNet<AxlePipeData, ? extends PipeNet> world) {
        super(world);
    }

    @Override
    protected void writeNodeData(@Nonnull AxlePipeData axlePipeData, @Nonnull NBTTagCompound nbt) {
        nbt.setLong("MaxS", axlePipeData.getMaxSpeed());
        nbt.setInteger("MaxP", axlePipeData.getMaxPower());
        nbt.setInteger("RotD", axlePipeData.getRotation().ordinal());
    }

    @Override
    protected AxlePipeData readNodeData(@Nonnull NBTTagCompound nbt) {
        return new AxlePipeData(nbt.getLong("MaxS"), nbt.getInteger("MaxP"), EnumRotation.VALUES[nbt.getInteger("RotD")]);
    }

    @Override
    protected void onNodeConnectionsUpdate() {
        super.onNodeConnectionsUpdate();
    }

    @Override
    protected void onPipeConnectionsUpdate() {
        Stream<EnumRotation> stream = getAllNodes().values().stream().map(axlePipeDataNode -> axlePipeDataNode.data.getRotation());
        if (stream.anyMatch(r -> r == EnumRotation.CW) && stream.anyMatch(r -> r == EnumRotation.CCW)) {
            this.netRotation = EnumRotation.NONE;
        }
    }

    @Override
    public long getSpeed() {
        return netSpeed;
    }

    @Override
    public int getPower() {
        return netPower;
    }

    @Override
    public EnumRotation getRotation() {
        return netRotation;
    }

    @Override
    public long changeSpeed(long amount) {
        AxleNetWalker.checkSpeed(getWorldData(), getAllNodes().keySet().iterator().next(), getSpeed() + amount);
        this.netSpeed += amount;
        return amount;
    }

    @Override
    public int changePower(int amount) {
        AxleNetWalker.checkPower(getWorldData(), getAllNodes().keySet().iterator().next(), getPower() + amount);
        return amount;
    }

    @Override
    public EnumRotation changeRotation(EnumRotation rotation) {
        AxleNetWalker.checkRotation(getWorldData(), getAllNodes().keySet().iterator().next(), rotation);
        return EnumRotation.NONE;
    }

    @Override
    public long getMaxSpeed() {
        return 0;
    }
}
