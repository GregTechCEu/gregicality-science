package gregicality.science.common.pipelike.axle;

import gregtech.api.pipenet.block.ItemBlockPipe;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class ItemBlockAxlePipe extends ItemBlockPipe<AxlePipeType, AxlePipeData> {

    public ItemBlockAxlePipe(BlockAxlePipe block) {
        super(block);
    }

    @Override
    public void addInformation(@Nonnull ItemStack stack, @Nullable World worldIn, @Nonnull List<String> tooltip, @Nonnull ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}
