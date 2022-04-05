package gregicality.science.common.pipelike.pressure.net;

import gregicality.science.api.capability.IPressureContainer;
import gregicality.science.api.capability.impl.PressureMedium;
import gregicality.science.common.pipelike.pressure.PressurePipeData;
import gregtech.api.capability.impl.FilteredFluidHandler;
import gregtech.api.pipenet.PipeNet;
import gregtech.api.pipenet.WorldPipeNet;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fluids.FluidTank;

public class PressurePipeNet extends PipeNet<PressurePipeData> implements IPressureContainer {

    private double netPressure = IPressureContainer.ATMOSPHERIC_PRESSURE;
    private final FilteredFluidHandler netTank = new FilteredFluidHandler(0)
            .setFillPredicate(PressureMedium::isValidMedium);

    public PressurePipeNet(WorldPipeNet<PressurePipeData, ? extends PipeNet> world) {
        super(world);
    }

    @Override
    protected void writeNodeData(PressurePipeData pressurePipeData, NBTTagCompound nbt) {
        nbt.setDouble("MaxP", pressurePipeData.getMaxPressure());
    }

    @Override
    protected PressurePipeData readNodeData(NBTTagCompound nbt) {
        return new PressurePipeData(nbt.getDouble("MaxP"));
    }

    @Override
    protected void onNodeConnectionsUpdate() {
        super.onNodeConnectionsUpdate();
    }

    @Override
    protected void onPipeConnectionsUpdate() {
        updateVolume();
    }

    @Override
    public void onNeighbourUpdate(BlockPos fromPos) {
        updateVolume();
    }

    private void updateVolume() {
        this.netTank.setCapacity(getAllNodes().size() * 1000);
    }

    @Override
    public double getPressure() {
        return netPressure;
    }

    @Override
    public double changePressure(double amount) {

        PressureNetWalker.checkPressure(getWorldData(), getAllNodes().keySet().iterator().next(), getPressure());
        return 0;
    }

    public void onLeak() {
        netTank.setFluid(null);
        netPressure = ATMOSPHERIC_PRESSURE;
    }

    @Override
    public double getMaxPressure() {
        return 0;
    }

    public FluidTank getNetTank() {
        return netTank;
    }
}
