package gregicality.science.common.pipelike.pressure;

import gregicality.science.api.capability.GCYSTileCapabilities;
import gregicality.science.client.render.pipe.PressurePipeRenderer;
import gregicality.science.common.pipelike.pressure.net.WorldPressureNet;
import gregicality.science.common.pipelike.pressure.tile.TileEntityPressurePipe;
import gregtech.api.pipenet.block.simple.BlockSimplePipe;
import gregtech.api.pipenet.tile.IPipeTile;
import gregtech.api.pipenet.tile.TileEntityPipeBase;
import gregtech.api.util.TaskScheduler;
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

public class BlockPressurePipe extends BlockSimplePipe<PressurePipeType, PressurePipeData, WorldPressureNet> {

    private static final String TRANSLATION_KEY = "gcys.pipe.pressure_pipe_%s";

    private final PressurePipeType pressurePipeType;

    public BlockPressurePipe(PressurePipeType pressurePipeType) {
        setHarvestLevel("pickaxe", 2);
        this.pressurePipeType = pressurePipeType;
    }

    @Override
    protected PressurePipeData createProperties(@Nonnull PressurePipeType pressurePipeType) {
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
    public void getSubBlocks(@Nonnull CreativeTabs creativeTabs, @Nonnull NonNullList<ItemStack> items) {
        items.add(new ItemStack(this, 1, pressurePipeType.ordinal()));
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
    public boolean isHoldingPipe(EntityPlayer player) {
        if (player == null) {
            return false;
        }
        ItemStack stack = player.getHeldItemMainhand();
        return !stack.isEmpty() && stack.getItem() instanceof ItemBlockPressurePipe;
    }

    @Override
    protected Pair<TextureAtlasSprite, Integer> getParticleTexture(World world, BlockPos blockPos) {
        return PressurePipeRenderer.INSTANCE.getParticleTexture(getPipeTileEntity(world, blockPos));
    }

    @SuppressWarnings("deprecation")
    @Nonnull
    @Override
    public EnumBlockRenderType getRenderType(@Nonnull IBlockState state) {
        return PressurePipeRenderer.INSTANCE.getBlockRenderType();
    }

    @Nonnull
    @Override
    public String getTranslationKey() {
        return String.format(TRANSLATION_KEY, this.pressurePipeType.name);
    }

    @Override
    public void breakBlock(@Nonnull World worldIn, @Nonnull BlockPos pos, @Nonnull IBlockState state) {
        TileEntity te = worldIn.getTileEntity(pos);
        if (te instanceof TileEntityPressurePipe) {
            TaskScheduler.scheduleTask(worldIn, ((TileEntityPressurePipe) te)::updateLeakage);
        }
        super.breakBlock(worldIn, pos, state);
    }
}
