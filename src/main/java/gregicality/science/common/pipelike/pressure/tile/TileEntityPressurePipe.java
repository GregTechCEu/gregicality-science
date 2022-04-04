package gregicality.science.common.pipelike.pressure.tile;

import gregicality.science.api.capability.GCYSTileCapabilities;
import gregicality.science.api.capability.IPressureContainer;
import gregicality.science.common.pipelike.pressure.PressurePipeData;
import gregicality.science.common.pipelike.pressure.PressurePipeType;
import gregicality.science.common.pipelike.pressure.net.PressurePipeNet;
import gregicality.science.common.pipelike.pressure.net.WorldPressureNet;
import gregtech.api.pipenet.tile.TileEntityPipeBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;

import javax.annotation.Nullable;
import java.lang.ref.WeakReference;

public class TileEntityPressurePipe extends TileEntityPipeBase<PressurePipeType, PressurePipeData> {

    private WeakReference<PressurePipeNet> currentPipeNet = new WeakReference<>(null);

    private final IFluidHandler defaultTank = new FluidTank(0);

    public TileEntityPressurePipe() {
    }

    @Override
    public <T> T getCapabilityInternal(Capability<T> capability, @Nullable EnumFacing facing) {
        if (capability == GCYSTileCapabilities.CAPABILITY_PRESSURE_CONTAINER) {
            if (world == null || world.isRemote) {
                return GCYSTileCapabilities.CAPABILITY_PRESSURE_CONTAINER.cast(IPressureContainer.EMPTY);
            }
            return GCYSTileCapabilities.CAPABILITY_PRESSURE_CONTAINER.cast(getPipeNet());
        } else if(capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY) {
            if (world == null || world.isRemote) {
                return CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY.cast(defaultTank);
            }
            return CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY.cast(getPipeNet().getNetTank());
        }
        return super.getCapabilityInternal(capability, facing);
    }

    public void checkPressure(double pressure) {
        if (pressure > getNodeData().getMaxPressure()) {
            world.createExplosion(null, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, 5, true);
        } else if (pressure < 1 / getNodeData().getMaxPressure()) {
            //TODO implosion
            world.createExplosion(null, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, 5, true);
        }
    }

    @Override
    public Class<PressurePipeType> getPipeTypeClass() {
        return PressurePipeType.class;
    }

    public PressurePipeNet getPipeNet() {
        if (world == null || world.isRemote)
            return null;
        PressurePipeNet currentPipeNet = this.currentPipeNet.get();
        if (currentPipeNet != null && currentPipeNet.isValid() &&
                currentPipeNet.containsNode(getPipePos()))
            return currentPipeNet; //if current net is valid and does contain position, return it
        WorldPressureNet worldFluidPipeNet = (WorldPressureNet) getPipeBlock().getWorldPipeNet(getPipeWorld());
        currentPipeNet = worldFluidPipeNet.getNetFromPos(getPipePos());
        if (currentPipeNet != null) {
            this.currentPipeNet = new WeakReference<>(currentPipeNet);
        }
        return currentPipeNet;
    }
}
