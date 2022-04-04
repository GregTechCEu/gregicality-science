package gregicality.science.common.pipelike.pressure;

import gregicality.science.api.capability.GCYSTileCapabilities;
import gregicality.science.common.pipelike.pressure.net.WorldPressureNet;
import gregicality.science.common.pipelike.pressure.tile.TileEntityPressurePipe;
import gregtech.api.pipenet.block.simple.BlockSimplePipe;
import gregtech.api.pipenet.tile.IPipeTile;
import gregtech.api.pipenet.tile.TileEntityPipeBase;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.apache.commons.lang3.tuple.Pair;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class BlockPressurePipe extends BlockSimplePipe<PressurePipeType, PressurePipeData, WorldPressureNet> {

    @Override
    protected PressurePipeData createProperties(PressurePipeType pressurePipeType) {
        return pressurePipeType.modifyProperties(PressurePipeData.EMPTY);
    }

    @Override
    public Class<PressurePipeType> getPipeTypeClass() {
        return PressurePipeType.class;
    }

    @Override
    public WorldPressureNet getWorldPipeNet(World world) {
        return WorldPressureNet.getWorldPipeNet(world);
    }

    @Override
    public TileEntityPipeBase<PressurePipeType, PressurePipeData> createNewTileEntity(boolean b) {
        return new TileEntityPressurePipe();
    }

    @Override
    protected PressurePipeData getFallbackType() {
        return PressurePipeData.EMPTY;
    }

    @Override
    public void getSubBlocks(@Nonnull CreativeTabs creativeTabs, @Nonnull NonNullList<ItemStack> nonNullList) {

    }

    @Override
    public boolean canPipesConnect(IPipeTile<PressurePipeType, PressurePipeData> iPipeTile, EnumFacing enumFacing, IPipeTile<PressurePipeType, PressurePipeData> iPipeTile1) {
        return iPipeTile1 instanceof TileEntityPressurePipe;
    }

    @Override
    public boolean canPipeConnectToBlock(IPipeTile<PressurePipeType, PressurePipeData> iPipeTile, EnumFacing enumFacing, @Nullable TileEntity tileEntity) {
        return tileEntity != null && tileEntity.hasCapability(GCYSTileCapabilities.CAPABILITY_PRESSURE_CONTAINER, enumFacing);
    }

    @Override
    public boolean isHoldingPipe(EntityPlayer entityPlayer) {
        return false;
    }

    @Override
    protected Pair<TextureAtlasSprite, Integer> getParticleTexture(World world, BlockPos blockPos) {
        return null;
    }
}
