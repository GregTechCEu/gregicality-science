package gregicality.science.common.pipelike.pressure.net;

import gregicality.science.api.capability.IPressureContainer;
import gregicality.science.api.capability.impl.PressureMedium;
import gregicality.science.common.pipelike.pressure.PressurePipeData;
import gregtech.api.capability.impl.FilteredFluidHandler;
import gregtech.api.pipenet.PipeNet;
import gregtech.api.pipenet.WorldPipeNet;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.FluidTank;

import javax.annotation.Nonnull;

public class PressurePipeNet extends PipeNet<PressurePipeData> implements IPressureContainer {

    private final FilteredFluidHandler netTank = new FilteredFluidHandler(0)
            .setFillPredicate(PressureMedium::isValidMedium);

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
        nbt.setInteger("MaxV", pressurePipeData.getMaxVolume());
    }

    @Override
    public NBTTagCompound serializeNBT() {
        NBTTagCompound compound = super.serializeNBT();
        compound.setDouble("minNetP", minNetPressure);
        compound.setDouble("maxNetP", maxNetPressure);
        compound.setTag("netTank", netTank.writeToNBT(new NBTTagCompound()));
        return compound;
    }

    @Override
    protected PressurePipeData readNodeData(@Nonnull NBTTagCompound nbt) {
        return new PressurePipeData(nbt.getDouble("MinP"), nbt.getDouble("MaxP"), nbt.getInteger("MaxV"));
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt) {
        super.deserializeNBT(nbt);
        this.minNetPressure = nbt.getDouble("minNetP");
        this.maxNetPressure = nbt.getDouble("maxNetP");
        this.netTank.readFromNBT(nbt.getCompoundTag("netTank"));
    }

    @Override
    protected void onNodeConnectionsUpdate() {
        super.onNodeConnectionsUpdate();
        this.minNetPressure = getAllNodes().values().stream().mapToDouble(node -> node.data.getMinPressure()).max().orElse(Double.MAX_VALUE);
        this.maxNetPressure = getAllNodes().values().stream().mapToDouble(node -> node.data.getMaxPressure()).min().orElse(Double.MIN_VALUE);
        this.netTank.setCapacity(getAllNodes().values().stream().mapToInt(node -> node.data.getMaxVolume()).sum());
    }

    @Override
    public double getPressure() {
        return netPressure;
    }

    @Override
    public double setPressure(double amount) {
        // Roughly: P = (P1 + P2) / (V1 + V2)
        this.netPressure = (this.netPressure + amount) / ((netTank.getFluidAmount() / Math.max(1.0F, (float) netTank.getCapacity())) + 1.0F);
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

    @Nonnull
    public FluidTank getNetTank() {
        return netTank;
    }

    public boolean hasFluid() {
        return netTank.getFluid() != null;
    }

    public double getMaxTankPressure() {
        final double pressure = PressureMedium.getMaxPressure(netTank.getFluid());
        if (pressure < 0) return getMaxPressure();
        return pressure;
    }
}
