package gregicality.science.common.metatileentities;

import gregicality.science.GregicalityScience;
import gregicality.science.api.recipes.GCYSRecipeMaps;
import gregicality.science.common.metatileentities.singleblock.MetaTileEntitySteamEjector;
import gregtech.client.renderer.texture.Textures;
import net.minecraft.util.ResourceLocation;

import static gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity;

public class GCYSMetaTileEntities {

    public static MetaTileEntitySteamEjector STEAM_EJECTOR;

    public static void init() {
        STEAM_EJECTOR = registerMetaTileEntity(2100, new MetaTileEntitySteamEjector(gcysId("steam_ejector"), GCYSRecipeMaps.STEAM_EJECTOR_RECIPES, Textures.AIR_VENT_OVERLAY, true));
    }

    private static ResourceLocation gcysId(String name) {
        return new ResourceLocation(GregicalityScience.MODID, name);
    }
}
