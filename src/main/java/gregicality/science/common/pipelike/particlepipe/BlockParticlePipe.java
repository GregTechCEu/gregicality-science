package gregicality.science.common.pipelike.particlepipe;

import gregicality.science.common.pipelike.particlepipe.net.ParticleNodeData;
import gregicality.science.common.pipelike.particlepipe.net.ParticlePipeNet;
import gregicality.science.common.pipelike.particlepipe.net.WorldPartclePipeNet;
import gregicality.science.common.pipelike.particlepipe.tile.TileEntityParticlePipe;
import gregtech.api.pipenet.block.simple.BlockSimplePipe;
import gregtech.api.pipenet.tile.IPipeTile;
import gregtech.api.pipenet.tile.TileEntityPipeBase;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
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

public class BlockParticlePipe extends BlockSimplePipe<ParticlePipeType, ParticleNodeData, WorldPartclePipeNet> {

    public BlockParticlePipe() {
        super();
        setHarvestLevel("wrench", 1);
    }

    @Override
    protected ParticleNodeData createProperties(ParticlePipeType pipeType) {
        return null;
    }

    @Override
    public TileEntityPipeBase<ParticlePipeType, ParticleNodeData> createNewTileEntity(boolean supportsTicking) {
        // TODO
        return new TileEntityParticlePipe();
    }

    @Override
    public void neighborChanged(@Nonnull IBlockState state, @Nonnull World worldIn, @Nonnull BlockPos pos, @Nonnull Block blockIn, @Nonnull BlockPos fromPos) {
        super.neighborChanged(state, worldIn, pos, blockIn, fromPos);
        if (!worldIn.isRemote) {
            ParticlePipeNet particlePipeNet = getWorldPipeNet(worldIn).getNetFromPos(pos);
            if (particlePipeNet != null) {
                particlePipeNet.nodeNeighbourChanged(pos);
            }
        }
    }

    @Override
    public boolean canPipesConnect(IPipeTile<ParticlePipeType, ParticleNodeData> selfTile, EnumFacing enumFacing, IPipeTile<ParticlePipeType, ParticleNodeData> sideTile) {
        return selfTile instanceof TileEntityParticlePipe && sideTile instanceof TileEntityParticlePipe;
    }

    @Override
    public boolean canPipeConnectToBlock(IPipeTile<ParticlePipeType, ParticleNodeData> iPipeTile, EnumFacing enumFacing, @Nullable TileEntity tileEntity) {
        return false; // TODO Capability
    }

    @Override
    public boolean isHoldingPipe(EntityPlayer player) {
        if (player == null) {
            return false;
        }
        ItemStack stack = player.getHeldItemMainhand();
        return stack != ItemStack.EMPTY && stack.getItem() instanceof ItemBlockParticlePipe;
    }

    @Override
    public Class<ParticlePipeType> getPipeTypeClass() {
        return ParticlePipeType.class;
    }

    @Override
    protected ParticleNodeData getFallbackType() {
        return new ParticleNodeData();
    }

    @Override
    public void getSubBlocks(@Nonnull CreativeTabs itemIn, @Nonnull NonNullList<ItemStack> items) {
        for(ParticlePipeType type: ParticlePipeType.values()) {
            items.add(new ItemStack(this, 1, type.ordinal()));
        }
    }

    @Override
    public WorldPartclePipeNet getWorldPipeNet(World world) {
        return WorldPartclePipeNet.getWorldPipeNet(world);
    }

    @Override
    protected Pair<TextureAtlasSprite, Integer> getParticleTexture(World world, BlockPos blockPos) {
        return null; // TODO rendering
    }

}
