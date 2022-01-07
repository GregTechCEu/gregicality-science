package gregicality.science.common.block;

import gregtech.common.blocks.MetaBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GCYSMetaBlocks {

    private GCYSMetaBlocks() {

    }

    public static void init() {

/* TODO Check that all these are set in the respective Materials classes
        GA_CABLE.addCableMaterial(UHVSuperconductorBase, new WireProperties(GAValues.V[GAValues.UHV], 4, 2));
        GA_CABLE.addCableMaterial(UEVSuperconductorBase, new WireProperties(GAValues.V[GAValues.UEV], 4, 2));
        GA_CABLE.addCableMaterial(UIVSuperconductorBase, new WireProperties(GAValues.V[GAValues.UIV], 4, 2));
        GA_CABLE.addCableMaterial(UMVSuperconductorBase, new WireProperties(GAValues.V[GAValues.UMV], 4, 2));
        GA_CABLE.addCableMaterial(UXVSuperconductorBase, new WireProperties(GAValues.V[GAValues.UXV], 4, 2));
        GA_CABLE.addCableMaterial(TungstenTitaniumCarbide, new WireProperties(GAValues.V[GAValues.UHV], 4, 16));
        GA_CABLE.addCableMaterial(AbyssalAlloy, new WireProperties(GAValues.V[GAValues.UHV], 2, 8));
        GA_CABLE.addCableMaterial(EnrichedNaquadahAlloy, new WireProperties(GAValues.V[GAValues.UHV], 1, 4));
        GA_CABLE.addCableMaterial(Pikyonium, new WireProperties(GAValues.V[GAValues.UEV], 4, 32));
        GA_CABLE.addCableMaterial(TitanSteel, new WireProperties(GAValues.V[GAValues.UEV], 2, 16));
        GA_CABLE.addCableMaterial(Cinobite, new WireProperties(GAValues.V[GAValues.UIV], 4, 64));
        GA_CABLE.addCableMaterial(BlackTitanium, new WireProperties(GAValues.V[GAValues.UIV], 2, 32));
        GA_CABLE.addCableMaterial(Neutronium, new WireProperties(GAValues.V[GAValues.UMV], 2, 32));
        GA_CABLE.addCableMaterial(UHVSuperconductor, new WireProperties(GAValues.V[GAValues.UHV], 4, 0));
        GA_CABLE.addCableMaterial(UEVSuperconductor, new WireProperties(GAValues.V[GAValues.UEV], 4, 0));
        GA_CABLE.addCableMaterial(UIVSuperconductor, new WireProperties(GAValues.V[GAValues.UIV], 4, 0));
        GA_CABLE.addCableMaterial(UMVSuperconductor, new WireProperties(GAValues.V[GAValues.UMV], 4, 0));
        GA_CABLE.addCableMaterial(UXVSuperconductor, new WireProperties(GAValues.V[GAValues.UXV], 4, 0));
*/
    }

    @SideOnly(Side.CLIENT)
    public static void registerItemModels() {

    }

    @SideOnly(Side.CLIENT)
    public static void registerItemModel(Block block) {
        for (IBlockState state : block.getBlockState().getValidStates()) {
            //noinspection ConstantConditions
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block),
                    block.getMetaFromState(state),
                    new ModelResourceLocation(block.getRegistryName(),
                            MetaBlocks.statePropertiesToString(state.getProperties())));
        }
    }

    @SuppressWarnings("unchecked")
    private static <T extends Comparable<T>> String getPropertyName(IProperty<T> property, Comparable<?> value) {
        return property.getName((T) value);
    }
}
