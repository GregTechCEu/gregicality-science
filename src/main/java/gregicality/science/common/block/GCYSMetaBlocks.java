package gregicality.science.common.block;

import gregicality.multiblocks.api.GCYMValues;
import gregicality.science.client.render.pipe.ParticlePipeRender;
import gregicality.science.common.pipelike.particlepipe.BlockParticlePipe;
import gregicality.science.common.pipelike.particlepipe.ParticlePipeType;
import gregicality.science.common.pipelike.particlepipe.tile.TileEntityParticlePipe;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GCYSMetaBlocks {

    private GCYSMetaBlocks() {
    }

    public static final BlockParticlePipe[] PARTICLE_PIPES = new BlockParticlePipe[1];

    public static void init() {
        for (ParticlePipeType type : ParticlePipeType.values()) {
            PARTICLE_PIPES[type.ordinal()] = new BlockParticlePipe();
            PARTICLE_PIPES[type.ordinal()].setRegistryName(String.format("particle_pipe_%s", type.name));
        }

        GameRegistry.registerTileEntity(TileEntityParticlePipe.class, new ResourceLocation(GCYMValues.GCYS_MODID));
    }

    @SideOnly(Side.CLIENT)
    public static void registerItemModels() {
        for (BlockParticlePipe pipe: PARTICLE_PIPES) {
            ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(pipe), stack -> ParticlePipeRender.INSTANCE.getModelLocation());
        }
    }

    @SideOnly(Side.CLIENT)
    private static void registerItemModel(@Nonnull Block block) {
        for (IBlockState state : block.getBlockState().getValidStates()) {
            //noinspection ConstantConditions
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block),
                    block.getMetaFromState(state),
                    new ModelResourceLocation(block.getRegistryName(),
                            statePropertiesToString(state.getProperties())));
        }
    }

    @Nonnull
    private static String statePropertiesToString(@Nonnull Map<IProperty<?>, Comparable<?>> properties) {
        StringBuilder stringbuilder = new StringBuilder();
        List<Map.Entry<IProperty<?>, Comparable<?>>> entries = properties.entrySet().stream().sorted(Comparator.comparing((c) -> c.getKey().getName())).collect(Collectors.toList());

        for (Map.Entry<IProperty<?>, Comparable<?>> iPropertyComparableEntry : entries) {
            if (stringbuilder.length() != 0) {
                stringbuilder.append(",");
            }

            IProperty<?> property = (IProperty<?>) ((Map.Entry<?, ?>) iPropertyComparableEntry).getKey();
            stringbuilder.append(property.getName());
            stringbuilder.append("=");
            stringbuilder.append(getPropertyName(property, (Comparable<?>) ((Map.Entry<?, ?>) iPropertyComparableEntry).getValue()));
        }

        if (stringbuilder.length() == 0) {
            stringbuilder.append("normal");
        }

        return stringbuilder.toString();
    }

    @Nonnull
    @SuppressWarnings("unchecked")
    private static <T extends Comparable<T>> String getPropertyName(@Nonnull IProperty<T> property, Comparable<?> value) {
        return property.getName((T) value);
    }
}
