package gregicality.science.common.pipelike.pressure.tile;

import gregicality.science.api.capability.GCYSTileCapabilities;
import gregicality.science.api.capability.IPressureContainer;
import gregicality.science.api.utils.NumberFormattingUtil;
import gregicality.science.common.pipelike.pressure.PressurePipeData;
import gregicality.science.common.pipelike.pressure.PressurePipeType;
import gregicality.science.common.pipelike.pressure.net.PressurePipeNet;
import gregicality.science.common.pipelike.pressure.net.WorldPressureNet;
import gregtech.api.metatileentity.IDataInfoProvider;
import gregtech.api.pipenet.tile.IPipeTile;
import gregtech.api.pipenet.tile.TileEntityPipeBase;
import gregtech.api.util.TaskScheduler;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.*;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

public class TileEntityPressurePipe extends TileEntityPipeBase<PressurePipeType, PressurePipeData> implements IDataInfoProvider {

    private WeakReference<PressurePipeNet> currentPipeNet = new WeakReference<>(null);

    public TileEntityPressurePipe() {/**/}

    @Override
    public <T> T getCapabilityInternal(Capability<T> capability, @Nullable EnumFacing facing) {
        if (capability == GCYSTileCapabilities.CAPABILITY_PRESSURE_CONTAINER) {
            if (world == null || world.isRemote) {
                return GCYSTileCapabilities.CAPABILITY_PRESSURE_CONTAINER.cast(IPressureContainer.EMPTY);
            }
            return GCYSTileCapabilities.CAPABILITY_PRESSURE_CONTAINER.cast(getPipeNet());
        }
        return super.getCapabilityInternal(capability, facing);
    }

    public void checkPressure(double pressure) {
        if (pressure > getNodeData().getMaxPressure()) {
            causePressureExplosion();
        } else if (pressure < getNodeData().getMinPressure()) {
            causePressureExplosion();
        }
    }

    public void causePressureExplosion() {
        PressurePipeNet net = getPipeNet();
        if (net != null) net.causePressureExplosion(getWorld(), getPos());
    }

    @Override
    public void setConnection(EnumFacing side, boolean connected, boolean fromNeighbor) {
        super.setConnection(side, connected, fromNeighbor);
        if (!world.isRemote) {
            BlockPos blockPos = pos.offset(side);
            IBlockState neighbour = world.getBlockState(blockPos);
            if (!neighbour.isFullBlock() || !neighbour.isOpaqueCube()) {
                // check the pipes for unconnected things
                TaskScheduler.scheduleTask(getWorld(), this::updateLeakage);
                return;
            }
            TileEntity te = world.getTileEntity(blockPos);
            if (te instanceof IPipeTile && ((IPipeTile<?, ?>) te).getPipeBlock().getPipeTypeClass() == this.getPipeTypeClass() &&
                    ((IPipeTile<?, ?>) te).getPipeType().getThickness() != getPipeType().getThickness() &&
                    ((IPipeTile<?, ?>) te).isConnected(side.getOpposite())) {
                // mismatched connected pipe sizes leak
                TaskScheduler.scheduleTask(getWorld(), this::updateLeakage);
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

    public boolean updateLeakage() {
        PressurePipeNet net = getPipeNet();
        if (net != null) {
            net.onLeak();
            if (!net.isNormalPressure()) causePressureExplosion();
            return !net.isNormalPressure();
        }
        return true;
    }

    @Override
    public boolean supportsTicking() {
        //return true so adding pump covers doesn't log an exception
        return true;
    }

    @Nonnull
    @Override
    public List<ITextComponent> getDataInfo() {
        if (getPipeNet() == null) return Collections.emptyList();
        List<ITextComponent> list = new ObjectArrayList<>();
        list.add(new TextComponentTranslation("behavior.tricorder.current_pressure", new TextComponentString(NumberFormattingUtil.formatDoubleToCompactString(getPipeNet().getPressure())).setStyle(new Style().setColor(TextFormatting.AQUA))));
        list.add(new TextComponentTranslation("behavior.tricorder.min_pressure", new TextComponentString(NumberFormattingUtil.formatDoubleToCompactString(getPipeNet().getMinPressure())).setStyle(new Style().setColor(TextFormatting.GREEN))));
        list.add(new TextComponentTranslation("behavior.tricorder.max_pressure", new TextComponentString(NumberFormattingUtil.formatDoubleToCompactString(getPipeNet().getMaxPressure())).setStyle(new Style().setColor(TextFormatting.GREEN))));
        return list;
    }
}
