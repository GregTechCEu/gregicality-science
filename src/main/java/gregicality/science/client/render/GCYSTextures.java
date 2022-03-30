package gregicality.science.client.render;

import gregicality.science.GregicalityScience;
import gregtech.client.renderer.texture.cube.OrientedOverlayRenderer;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;

import static gregtech.client.renderer.texture.cube.OrientedOverlayRenderer.OverlayFace.*;

@Mod.EventBusSubscriber(modid = GregicalityScience.MODID, value = Side.CLIENT)
public class GCYSTextures {

    public static OrientedOverlayRenderer DRYER_OVERLAY = new OrientedOverlayRenderer("machines/dryer", FRONT, TOP, SIDE);
    public static OrientedOverlayRenderer CRYSTALLIZATION_CRUCIBLE_OVERLAY = new OrientedOverlayRenderer("multiblock/crystallization_crucible", FRONT);
    public static OrientedOverlayRenderer ROASTER_OVERLAY = new OrientedOverlayRenderer("multiblock/roaster", FRONT);
    public static OrientedOverlayRenderer NANOSCALE_FABRICATOR_OVERLAY = new OrientedOverlayRenderer("multiblock/nanoscale_fabricator", FRONT);

}
