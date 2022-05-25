package gregicality.science.common.pipelike.axle.tile;

import gregicality.science.api.capability.EnumRotation;
import gregicality.science.api.capability.GCYSTileCapabilities;
import gregicality.science.api.capability.IRotationContainer;
import gregicality.science.common.pipelike.axle.AxlePipeData;
import gregicality.science.common.pipelike.axle.AxlePipeType;
import gregicality.science.common.pipelike.axle.net.AxlePipeNet;
import gregicality.science.common.pipelike.axle.net.WorldAxleNet;
import gregtech.api.pipenet.tile.TileEntityPipeBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;
import java.lang.ref.WeakReference;

public class TileEntityAxlePipe extends TileEntityPipeBase<AxlePipeType, AxlePipeData> {

    private WeakReference<AxlePipeNet> currentPipeNet = new WeakReference<>(null);

    public TileEntityAxlePipe() {
    }

    @Override
    public <T> T getCapabilityInternal(Capability<T> capability, @Nullable EnumFacing facing) {
        if (capability == GCYSTileCapabilities.CAPABILITY_ROTATION_CONTAINER) {
            if (world == null || world.isRemote) {
                return GCYSTileCapabilities.CAPABILITY_ROTATION_CONTAINER.cast(IRotationContainer.EMPTY);
            }
            return GCYSTileCapabilities.CAPABILITY_ROTATION_CONTAINER.cast(getPipeNet());
        }
        return super.getCapabilityInternal(capability, facing);
    }

    public void checkSpeed(long speed) {
        if (speed > getNodeData().getMaxSpeed()) overSpin();
    }

    public void checkPower(int power) {
        if (power > getNodeData().getMaxPower()) overSpin();
    }

    public void checkRotation(EnumRotation rotation) {
        if (getNodeData().getRotation() != EnumRotation.NONE || rotation == EnumRotation.NONE) {
            if (rotation != getNodeData().getRotation()) {
                overSpin();
            }
        }
    }

    public void overSpin() {
        if (!world.isRemote) {
            world.playSound(null, getPipePos(), SoundEvents.ENTITY_ITEM_BREAK, SoundCategory.BLOCKS, 1.0F, 1.0F);
            world.spawnEntity(new EntityItem(world, 0.5F, 0.5F, 0.5F, getPipeBlock().getDropItem(this)));
            world.setBlockToAir(getPipePos());
        }
    }

    @Override
    public Class<AxlePipeType> getPipeTypeClass() {
        return AxlePipeType.class;
    }

    public AxlePipeNet getPipeNet() {
        if (world == null || world.isRemote)
            return null;
        AxlePipeNet currentPipeNet = this.currentPipeNet.get();
        if (currentPipeNet != null && currentPipeNet.isValid() &&
                currentPipeNet.containsNode(getPipePos()))
            return currentPipeNet; //if current net is valid and does contain position, return it
        WorldAxleNet worldPipeNet = (WorldAxleNet) getPipeBlock().getWorldPipeNet(getPipeWorld());
        currentPipeNet = worldPipeNet.getNetFromPos(getPipePos());
        if (currentPipeNet != null) {
            this.currentPipeNet = new WeakReference<>(currentPipeNet);
        }
        return currentPipeNet;
    }
}
