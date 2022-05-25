package gregicality.science.common.pipelike.axle;

import gregicality.science.api.capability.GCYSTileCapabilities;
import gregicality.science.client.render.pipe.AxlePipeRenderer;
import gregicality.science.common.pipelike.axle.net.WorldAxleNet;
import gregicality.science.common.pipelike.axle.tile.TileEntityAxlePipe;
import gregicality.science.common.pipelike.pressure.ItemBlockPressurePipe;
import gregtech.api.pipenet.block.simple.BlockSimplePipe;
import gregtech.api.pipenet.tile.IPipeTile;
import gregtech.api.pipenet.tile.TileEntityPipeBase;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.apache.commons.lang3.tuple.Pair;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class BlockAxlePipe extends BlockSimplePipe<AxlePipeType, AxlePipeData, WorldAxleNet> {

    private static final String TRANSLATION_KEY = "gcys.pipe.axle_normal";

    public BlockAxlePipe() {
        setHarvestLevel("wrench", 1);
    }

    @Override
    protected AxlePipeData createProperties(@Nonnull AxlePipeType axlePipeType) {
        return axlePipeType.modifyProperties(AxlePipeData.EMPTY);
    }

    @Override
    public Class<AxlePipeType> getPipeTypeClass() {
        return AxlePipeType.class;
    }

    @Override
    public WorldAxleNet getWorldPipeNet(World world) {
        return WorldAxleNet.getWorldPipeNet(world);
    }

    @Override
    public TileEntityPipeBase<AxlePipeType, AxlePipeData> createNewTileEntity(boolean b) {
        return new TileEntityAxlePipe();
    }

    @Override
    protected AxlePipeData getFallbackType() {
        return AxlePipeData.EMPTY;
    }

    @Override
    public void getSubBlocks(@Nonnull CreativeTabs creativeTabs, @Nonnull NonNullList<ItemStack> items) {
        for (AxlePipeType type : AxlePipeType.values()) {
            items.add(new ItemStack(this, 1, type.ordinal()));
        }
    }

    @Override
    public boolean canPipesConnect(IPipeTile<AxlePipeType, AxlePipeData> iPipeTile, EnumFacing enumFacing, IPipeTile<AxlePipeType, AxlePipeData> iPipeTile1) {
        return iPipeTile1 instanceof TileEntityAxlePipe;
    }

    @Override
    public boolean canPipeConnectToBlock(IPipeTile<AxlePipeType, AxlePipeData> iPipeTile, EnumFacing enumFacing, @Nullable TileEntity tileEntity) {
        return tileEntity != null && tileEntity.hasCapability(GCYSTileCapabilities.CAPABILITY_PRESSURE_CONTAINER, enumFacing);
    }

    @Override
    public boolean isHoldingPipe(EntityPlayer player) {
        if (player == null) {
            return false;
        }
        ItemStack stack = player.getHeldItemMainhand();
        return stack != ItemStack.EMPTY && stack.getItem() instanceof ItemBlockPressurePipe;
    }

    @Override
    protected Pair<TextureAtlasSprite, Integer> getParticleTexture(World world, BlockPos blockPos) {
        return AxlePipeRenderer.INSTANCE.getParticleTexture(getPipeTileEntity(world, blockPos));
    }

    @Nonnull
    @Override
    public EnumBlockRenderType getRenderType(@Nonnull IBlockState state) {
        return AxlePipeRenderer.INSTANCE.getBlockRenderType();
    }

    @Nonnull
    @Override
    public String getTranslationKey() {
        return TRANSLATION_KEY;
    }
}
