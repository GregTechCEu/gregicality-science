package gregicality.science.common.pipelike.pressure.tile;

import gregicality.science.api.capability.GCYSTileCapabilities;
import gregicality.science.api.capability.IPressureContainer;
import gregicality.science.common.pipelike.pressure.PressurePipeData;
import gregicality.science.common.pipelike.pressure.PressurePipeType;
import gregicality.science.common.pipelike.pressure.net.PressurePipeNet;
import gregicality.science.common.pipelike.pressure.net.WorldPressureNet;
import gregtech.api.metatileentity.IDataInfoProvider;
import gregtech.api.pipenet.tile.IPipeTile;
import gregtech.api.pipenet.tile.TileEntityPipeBase;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

public class TileEntityPressurePipe extends TileEntityPipeBase<PressurePipeType, PressurePipeData> implements IDataInfoProvider {

    private final IFluidHandler defaultTank = new FluidTank(0);

    private WeakReference<PressurePipeNet> currentPipeNet = new WeakReference<>(null);

    public TileEntityPressurePipe() {/**/}

    @Override
    public <T> T getCapabilityInternal(Capability<T> capability, @Nullable EnumFacing facing) {
        if (capability == GCYSTileCapabilities.CAPABILITY_PRESSURE_CONTAINER) {
            if (world == null || world.isRemote) {
                return GCYSTileCapabilities.CAPABILITY_PRESSURE_CONTAINER.cast(IPressureContainer.EMPTY);
            }
            return GCYSTileCapabilities.CAPABILITY_PRESSURE_CONTAINER.cast(getPipeNet());
        } else if (capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY) {
            if (world == null || world.isRemote) {
                return CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY.cast(defaultTank);
            }
            return CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY.cast(getPipeNet().getNetTank());
        }
        return super.getCapabilityInternal(capability, facing);
    }

    public void checkPressure(double pressure) {
        if (pressure > getNodeData().getMaxPressure()) {
            causePressureExplosion(false);
        } else if (!world.isRemote && getPipeNet() != null && pressure > getPipeNet().getMaxTankPressure()) {
            causePressureExplosion(false);
        } else if (pressure < getNodeData().getMinPressure()) {
            causePressureExplosion(true);
        } else if (getPipeNet() != null && getPipeNet().isVacuum() && getPipeNet().hasFluid()) {
            causePressureExplosion(true);
        }
    }

    public void causePressureExplosion(boolean isVacuum) {
        IPressureContainer.causePressureExplosion(isVacuum, getWorld(), getPos());
    }

    @Override
    public void setConnection(EnumFacing side, boolean connected, boolean fromNeighbor) {
        int oldConnections = getConnections();
        super.setConnection(side, connected, fromNeighbor);
        if (!world.isRemote && oldConnections != getConnections() && connected) {
            IBlockState neighbour = world.getBlockState(pos.offset(side));
            if (neighbour.isFullBlock() && neighbour.isOpaqueCube()) {
                return;
            }
            TileEntity te = world.getTileEntity(pos.offset(side));
            if (te instanceof IPipeTile && ((IPipeTile<?, ?>) te).getPipeType().getThickness() >= getPipeType().getThickness() && ((IPipeTile<?, ?>) te).isConnected(side.getOpposite())) {
                return;
            }
            PressurePipeNet net = getPipeNet();
            if (net != null) {
                net.onLeak(); //TODO constantly call when there is an open pipe
                if (!net.isNormalPressure()) {
                    causePressureExplosion(net.isVacuum());
                }
            }
        }
    }

    @Override
    public Class<PressurePipeType> getPipeTypeClass() {
        return PressurePipeType.class;
    }

    @Nullable
    public PressurePipeNet getPipeNet() {
        if (world == null || world.isRemote) return null;
        PressurePipeNet currentPipeNet = this.currentPipeNet.get();
        if (currentPipeNet != null && currentPipeNet.isValid() && currentPipeNet.containsNode(getPipePos())) {
            return currentPipeNet; //if current net is valid and does contain position, return it
        }
        WorldPressureNet worldFluidPipeNet = (WorldPressureNet) getPipeBlock().getWorldPipeNet(getPipeWorld());
        currentPipeNet = worldFluidPipeNet.getNetFromPos(getPipePos());
        if (currentPipeNet != null) {
            this.currentPipeNet = new WeakReference<>(currentPipeNet);
        }
        return currentPipeNet;
    }

    @Override
    public boolean supportsTicking() {
        //return true so adding pump covers doesn't log an exception
        return true;
    }

    @Nonnull
    @Override
    public List<ITextComponent> getDataInfo() {
        //TODO Localize
        return Collections.singletonList(new TextComponentTranslation("Pressure: " + getPipeNet().getPressure() + " Min Pressure: " + getPipeNet().getMinPressure() + " Max Pressure: " + getPipeNet().getMaxPressure()));
    }
}
