package gregicality.science.client.render;

import gregtech.client.renderer.texture.cube.OrientedOverlayRenderer;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;

import static gregicality.science.GregicalityScience.MODID;
import static gregtech.client.renderer.texture.cube.OrientedOverlayRenderer.OverlayFace.*;

@Mod.EventBusSubscriber(modid = MODID, value = Side.CLIENT)
public class GCYSTextures {

    public static OrientedOverlayRenderer DRYER_OVERLAY = new OrientedOverlayRenderer("machines/dryer", FRONT, TOP, SIDE);
    public static OrientedOverlayRenderer CRYSTALLIZATION_CRUCIBLE_OVERLAY = new OrientedOverlayRenderer("multiblock/crystallization_crucible", FRONT);

    public static final ModelResourceLocation PARTICLE_PIPE_MODEL = new ModelResourceLocation(new ResourceLocation(MODID, "particle_pipe_normal"), "normal");

}
