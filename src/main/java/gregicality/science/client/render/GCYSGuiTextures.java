package gregicality.science.client.render;

import gregicality.science.GregicalityScience;
import gregtech.api.gui.resources.TextureArea;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(modid = GregicalityScience.MODID, value = Side.CLIENT)
public class GCYSGuiTextures {

    public static TextureArea PROGRESS_BAR_NANOSCALE = TextureArea.fullImage("textures/gui/progress_bar/progress_bar_nanoscale.png");


    public static final TextureArea NANOSCALE_OVERLAY_1 = TextureArea.fullImage("textures/gui/overlay/nanoscale_overlay_1.png");
    public static final TextureArea NANOSCALE_OVERLAY_2 = TextureArea.fullImage("textures/gui/overlay/nanoscale_overlay_2.png");
    public static final TextureArea FOIL_OVERLAY = TextureArea.fullImage("textures/gui/overlay/foil_overlay.png");

}
