package gregicality.science.common.pipelike.pressure;

import gregtech.api.pipenet.block.ItemBlockPipe;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemBlockPressurePipe extends ItemBlockPipe<PressurePipeType, PressurePipeData> {

    public ItemBlockPressurePipe(BlockPressurePipe block) {
        super(block);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}
