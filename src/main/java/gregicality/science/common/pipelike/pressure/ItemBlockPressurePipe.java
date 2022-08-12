package gregicality.science.common.pipelike.pressure;

import gregicality.science.api.GCYSValues;
import gregicality.science.api.utils.GCYSUtility;
import gregicality.science.api.utils.NumberFormattingUtil;
import gregtech.api.pipenet.block.ItemBlockPipe;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class ItemBlockPressurePipe extends ItemBlockPipe<PressurePipeType, PressurePipeData> {

    public ItemBlockPressurePipe(BlockPressurePipe block) {
        super(block);
    }

    @Override
    public void addInformation(@Nonnull ItemStack stack, @Nullable World worldIn, @Nonnull List<String> tooltip, @Nonnull ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        PressurePipeData pipeProperties = this.blockPipe.createItemProperties(stack);
        tooltip.add(I18n.format("gcys.universal.tooltip.pressure.minimum", NumberFormattingUtil.formatDoubleToCompactString(pipeProperties.getMinPressure()), GCYSValues.PNF[GCYSUtility.getTierByPressure(pipeProperties.getMinPressure())]));
        tooltip.add(I18n.format("gcys.universal.tooltip.pressure.maximum", NumberFormattingUtil.formatDoubleToCompactString(pipeProperties.getMaxPressure()), GCYSValues.PNF[GCYSUtility.getTierByPressure(pipeProperties.getMaxPressure())]));
        tooltip.add(I18n.format("gcys.pipe.pressure.tooltip.volume", pipeProperties.getVolume()));
    }
}
