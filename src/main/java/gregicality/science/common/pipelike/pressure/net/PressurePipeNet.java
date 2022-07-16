package gregicality.science.common.pipelike.pressure.net;

import gregicality.science.api.capability.IPressureContainer;
import gregicality.science.common.pipelike.pressure.PressurePipeData;
import gregtech.api.pipenet.PipeNet;
import gregtech.api.pipenet.WorldPipeNet;
import net.minecraft.nbt.NBTTagCompound;

import javax.annotation.Nonnull;

public class PressurePipeNet extends PipeNet<PressurePipeData> implements IPressureContainer {

    private double netPressure = IPressureContainer.ATMOSPHERIC_PRESSURE;
    private double minNetPressure = Double.MAX_VALUE;
    private double maxNetPressure = Double.MIN_VALUE;

    public PressurePipeNet(WorldPipeNet<PressurePipeData, ? extends PipeNet> world) {
        super(world);
    }

    @Override
    protected void writeNodeData(@Nonnull PressurePipeData pressurePipeData, @Nonnull NBTTagCompound nbt) {
        nbt.setDouble("MinP", pressurePipeData.getMinPressure());
        nbt.setDouble("MaxP", pressurePipeData.getMaxPressure());
    }

    @Override
    public NBTTagCompound serializeNBT() {
        NBTTagCompound compound = super.serializeNBT();
        compound.setDouble("minNetP", minNetPressure);
        compound.setDouble("maxNetP", maxNetPressure);
        return compound;
    }

    @Override
    protected PressurePipeData readNodeData(@Nonnull NBTTagCompound nbt) {
        return new PressurePipeData(nbt.getDouble("MinP"), nbt.getDouble("MaxP"));
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt) {
        super.deserializeNBT(nbt);
        this.minNetPressure = nbt.getDouble("minNetP");
        this.maxNetPressure = nbt.getDouble("maxNetP");
    }

    @Override
    protected void onNodeConnectionsUpdate() {
        super.onNodeConnectionsUpdate();
        this.minNetPressure = getAllNodes().values().stream().distinct().map(node -> node.data.getMinPressure()).max(Double::compare).orElse(Double.MAX_VALUE);
        this.maxNetPressure = getAllNodes().values().stream().distinct().map(node -> node.data.getMaxPressure()).min(Double::compare).orElse(Double.MIN_VALUE);
    }

    @Override
    public double getPressure() {
        return netPressure;
    }

    @Override
    public double setPressure(double amount) {
        // P = (P1 + P2) / (V1 + V2)
        this.netPressure = (this.netPressure + amount) / 2;
        PressureNetWalker.checkPressure(getWorldData(), getAllNodes().keySet().iterator().next(), getPressure());
        return amount;
    }

    public void onLeak() {
        if (getPressure() < IPressureContainer.ATMOSPHERIC_PRESSURE) changePressure(+10);
        else if (getPressure() > IPressureContainer.ATMOSPHERIC_PRESSURE) changePressure(-10);
    }

    @Override
    public double getMinPressure() {
        return minNetPressure;
    }

    @Override
    public double getMaxPressure() {
        return maxNetPressure;
    }
}
