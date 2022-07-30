package gregicality.science.common;

import codechicken.lib.texture.TextureUtils;
import gregicality.science.client.render.GCYSTextures;
import gregicality.science.client.render.pipe.PressurePipeRenderer;
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
        TextureUtils.addIconRegister(GCYSTextures::register);
        PressurePipeRenderer.INSTANCE.preInit();
    }


    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        GCYSMetaBlocks.registerItemModels();
    }
}
