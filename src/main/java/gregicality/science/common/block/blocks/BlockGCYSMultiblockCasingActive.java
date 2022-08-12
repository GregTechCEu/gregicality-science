package gregicality.science.common.block.blocks;

import gregtech.api.block.VariantActiveBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.IStringSerializable;

import javax.annotation.Nonnull;

public class BlockGCYSMultiblockCasingActive extends VariantActiveBlock<BlockGCYSMultiblockCasingActive.CasingType> {

    public BlockGCYSMultiblockCasingActive() {
        super(Material.IRON);
        setTranslationKey("multiblock_casing_active");
        setHardness(5.0f);
        setResistance(10.0f);
        setSoundType(SoundType.METAL);
        setHarvestLevel("wrench", 1);
        setDefaultState(getState(CasingType.AIRFOIL));
    }

    public enum CasingType implements IStringSerializable {
        AIRFOIL("airfoil"),
        ADVANCED_AIRFOIL("advanced_airfoil");

        private final String name;

        @Nonnull
        @Override
        public String getName() {
            return name;
        }

        CasingType(String name) {
            this.name = name;
        }
    }
}
