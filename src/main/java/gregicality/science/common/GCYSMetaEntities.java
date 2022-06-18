package gregicality.science.common;

import gregicality.science.GregicalityScience;
import gregicality.science.api.GCYSValues;
import gregicality.science.client.render.handler.RocketRenderer;
import gregicality.science.common.entities.RocketEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GCYSMetaEntities {

    public static void init(){
        EntityRegistry.registerModEntity(new ResourceLocation(GCYSValues.MODID, "rocket"), RocketEntity.class, "Rocket", 1, GregicalityScience.instance, 64, 3, true);
    }

     @SideOnly(Side.CLIENT)
    public static void initRenderers(){
         RenderingRegistry.registerEntityRenderingHandler(RocketEntity.class, manager -> new RocketRenderer(manager));
     }

}
