package gregicality.science.client.render;

import gregicality.science.GregicalityScience;
import gregtech.client.renderer.texture.cube.OrientedOverlayRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import net.minecraftforge.fml.relauncher.SideOnly;

import static gregtech.client.renderer.texture.cube.OrientedOverlayRenderer.OverlayFace.*;

@Mod.EventBusSubscriber(modid = GregicalityScience.MODID, value = Side.CLIENT)
public class GCYSTextures {

    public static OrientedOverlayRenderer DRYER_OVERLAY = new OrientedOverlayRenderer("machines/dryer", FRONT, TOP, SIDE);
    public static OrientedOverlayRenderer CRYSTALLIZATION_CRUCIBLE_OVERLAY = new OrientedOverlayRenderer("multiblock/crystallization_crucible", FRONT);
    public static OrientedOverlayRenderer ROASTER_OVERLAY = new OrientedOverlayRenderer("multiblock/roaster", FRONT);
    public static OrientedOverlayRenderer NANOSCALE_FABRICATOR_OVERLAY = new OrientedOverlayRenderer("multiblock/nanoscale_fabricator", FRONT);
    public static OrientedOverlayRenderer CVD_UNIT_OVERLAY = new OrientedOverlayRenderer("multiblock/cvd_unit", FRONT);
    public static OrientedOverlayRenderer BURNER_REACTOR_OVERLAY = new OrientedOverlayRenderer("multiblock/burner_reactor", FRONT);
    public static OrientedOverlayRenderer CRYOGENIC_REACTOR_OVERLAY = new OrientedOverlayRenderer("multiblock/cryogenic_reactor", FRONT);

    public static TextureAtlasSprite PRESSURE_PIPE_SIDE;
    public static TextureAtlasSprite PRESSURE_PIPE_OPEN;

    @SideOnly(Side.CLIENT)
    public static void register(TextureMap textureMap) {
        PRESSURE_PIPE_SIDE = textureMap.registerSprite(new ResourceLocation(GregicalityScience.MODID, "blocks/pipe/pressure_pipe_side"));
        PRESSURE_PIPE_OPEN = textureMap.registerSprite(new ResourceLocation(GregicalityScience.MODID, "blocks/pipe/pressure_pipe_open"));
    }

    public static TextureAtlasSprite PRESSURE_PIPE_SIDE;
    public static TextureAtlasSprite PRESSURE_PIPE_OPEN;
    public static TextureAtlasSprite AXLE_OPEN_CLOCKWISE;
    public static TextureAtlasSprite AXLE_OPEN_COUNTERCLOCKWISE;
    public static TextureAtlasSprite AXLE_OPEN;
    public static TextureAtlasSprite AXLE_SIDE_HORIZONTAL;
    public static TextureAtlasSprite AXLE_SIDE_VERTICAL;
    public static TextureAtlasSprite AXLE_SIDE_UP;
    public static TextureAtlasSprite AXLE_SIDE_DOWN;
    public static TextureAtlasSprite AXLE_SIDE_LEFT;
    public static TextureAtlasSprite AXLE_SIDE_RIGHT;

    @SideOnly(Side.CLIENT)
    public static void register(@Nonnull TextureMap textureMap) {
        PRESSURE_PIPE_SIDE = textureMap.registerSprite(new ResourceLocation(GregicalityScience.MODID, "blocks/pipe/pressure_pipe_side"));
        PRESSURE_PIPE_OPEN = textureMap.registerSprite(new ResourceLocation(GregicalityScience.MODID, "blocks/pipe/pressure_pipe_open"));
        AXLE_OPEN_CLOCKWISE = textureMap.registerSprite(new ResourceLocation(GregicalityScience.MODID, "blocks/pipe/axle_open_clockwise"));
        AXLE_OPEN_COUNTERCLOCKWISE = textureMap.registerSprite(new ResourceLocation(GregicalityScience.MODID, "blocks/pipe/axle_open_counterclockwise"));
        AXLE_OPEN = textureMap.registerSprite(new ResourceLocation(GregicalityScience.MODID, "blocks/pipe/axle_open"));
        AXLE_SIDE_HORIZONTAL = textureMap.registerSprite(new ResourceLocation(GregicalityScience.MODID, "blocks/pipe/axle_side_horizontal"));
        AXLE_SIDE_VERTICAL = textureMap.registerSprite(new ResourceLocation(GregicalityScience.MODID, "blocks/pipe/axle_side_vertical"));
        AXLE_SIDE_UP = textureMap.registerSprite(new ResourceLocation(GregicalityScience.MODID, "blocks/pipe/axle_side_up"));
        AXLE_SIDE_DOWN = textureMap.registerSprite(new ResourceLocation(GregicalityScience.MODID, "blocks/pipe/axle_side_down"));
        AXLE_SIDE_LEFT = textureMap.registerSprite(new ResourceLocation(GregicalityScience.MODID, "blocks/pipe/axle_side_left"));
        AXLE_SIDE_RIGHT = textureMap.registerSprite(new ResourceLocation(GregicalityScience.MODID, "blocks/pipe/axle_side_right"));
    }

}
