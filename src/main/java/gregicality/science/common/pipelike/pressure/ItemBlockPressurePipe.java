package gregicality.science.common.pipelike.pressure;

import gregtech.api.pipenet.block.BlockPipe;
import gregtech.api.pipenet.block.ItemBlockPipe;

public class ItemBlockPressurePipe extends ItemBlockPipe<PressurePipeType, PressurePipeData> {

    public ItemBlockPressurePipe(BlockPipe<PressurePipeType, PressurePipeData, ?> block) {
        super(block);
    }
}
