package gregicadditions;

import gregtech.api.metatileentity.MetaTileEntityHolder;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class GAEventHandler {

    // TODO is this needed?
    @SubscribeEvent
    public void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        if (event.getWorld().getTileEntity(event.getPos()) instanceof MetaTileEntityHolder) {
            event.setUseBlock(Event.Result.ALLOW);
        }
    }
}
