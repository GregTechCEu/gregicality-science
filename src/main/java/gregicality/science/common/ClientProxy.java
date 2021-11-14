package gregicality.science.common;

import gregicality.science.client.model.ReTexturedModelLoader;
import gregicality.science.client.renderer.OpticalFiberRenderer;
import gregicality.science.common.item.GAMetaBlocks;
import gregicality.science.api.GCYSciLog;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {

    @Override
    public void preLoad() {
        super.preLoad();
        if (!Minecraft.getMinecraft().getFramebuffer().isStencilEnabled()) {
            Minecraft.getMinecraft().getFramebuffer().enableStencil();
        }
        GCYSciLog.logger.info(Minecraft.getMinecraft().getFramebuffer().isStencilEnabled());
        OpticalFiberRenderer.preInit();
        ModelLoaderRegistry.registerLoader(new ReTexturedModelLoader());
        //TextureUtils.addIconRegister(GAMetaFluids::registerSprites);
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        GAMetaBlocks.registerStateMappers();
        GAMetaBlocks.registerItemModels();
    }
}
