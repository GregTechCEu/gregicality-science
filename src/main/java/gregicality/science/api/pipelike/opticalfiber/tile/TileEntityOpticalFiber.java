package gregicality.science.api.pipelike.opticalfiber.tile;

import gregicality.science.api.capabilities.GregicalityCapabilities;
import gregicality.science.api.capabilities.IQubitContainer;
import gregicality.science.api.pipelike.opticalfiber.OpticalFiberProperties;
import gregicality.science.api.pipelike.opticalfiber.OpticalFiberSize;
import gregtech.api.pipenet.tile.TileEntityPipeBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;

public class TileEntityOpticalFiber extends TileEntityPipeBase<OpticalFiberSize, OpticalFiberProperties> {

    private IQubitContainer energyContainer;

    private IQubitContainer getEnergyContainer() {
        if (energyContainer == null) {
            energyContainer = new CableQubitContainer(this);
        }
        return energyContainer;
    }

    @Override
    public Class<OpticalFiberSize> getPipeTypeClass() {
        return OpticalFiberSize.class;
    }

    @Override
    public boolean supportsTicking() {
        return false;
    }

    @Nullable
    @Override
    public <T> T getCapabilityInternal(Capability<T> capability, @Nullable EnumFacing facing) {
        if (capability == GregicalityCapabilities.QBIT_CAPABILITY) {
            return (T) getEnergyContainer();
        }
        return super.getCapabilityInternal(capability, facing);
    }

}
