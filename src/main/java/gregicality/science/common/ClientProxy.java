package gregicality.science.common;

import gregicality.science.common.block.GCYSMetaBlocks;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {

    @Override
    public void preLoad() {
        super.preLoad();
        GCYSMetaEntities.initRenderers();
    }


    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        GCYSMetaBlocks.registerItemModels();
    }
}
