package gregicality.science.common.block.blocks;

import gregtech.api.block.VariantBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.IStringSerializable;

import javax.annotation.Nonnull;

public class BlockGCYSMultiblockCasing extends VariantBlock<BlockGCYSMultiblockCasing.CasingType> {

    public BlockGCYSMultiblockCasing() {
        super(Material.IRON);
        setTranslationKey("multiblock_casing");
        setHardness(5.0f);
        setResistance(10.0f);
        setSoundType(SoundType.METAL);
        setHarvestLevel("wrench", 1);
        setDefaultState(getState(CasingType.SUBSTRATE));
    }

    public enum CasingType implements IStringSerializable {
        SUBSTRATE("substrate"),
        ADVANCED_SUBSTRATE("advanced_substrate"),
        DRILL_HEAD("drill_head");

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
