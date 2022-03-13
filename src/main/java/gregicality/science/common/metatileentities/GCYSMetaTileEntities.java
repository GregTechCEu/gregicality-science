package gregicality.science.common.metatileentities;

import gregicality.science.GregicalityScience;
import gregicality.science.api.recipes.GCYSRecipeMaps;
import gregicality.science.client.render.GCYSTextures;
import gregicality.science.common.metatileentities.multiblock.MetaTileEntityBioVat;
import gregicality.science.common.metatileentities.multiblock.MetaTileEntityButchery;
import gregicality.science.common.metatileentities.multiblock.MetaTileEntityCrystallizationCrucible;
import gregicality.science.common.metatileentities.multiblock.MetaTileEntityGreenhouse;
import gregicality.science.common.metatileentities.singleblock.MetaTileEntitySteamEjector;
import gregtech.api.GTValues;
import gregtech.api.metatileentity.SimpleMachineMetaTileEntity;
import gregtech.client.renderer.texture.Textures;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;

import static gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity;
import static gregtech.common.metatileentities.MetaTileEntities.registerSimpleMetaTileEntity;

public class GCYSMetaTileEntities {

    public static SimpleMachineMetaTileEntity[] DRYER = new SimpleMachineMetaTileEntity[GTValues.V.length - 1];
    public static MetaTileEntitySteamEjector STEAM_EJECTOR;
    public static MetaTileEntitySteamEjector HP_STEAM_EJECTOR;
    public static MetaTileEntityBioVat BIO_VAT;
    public static MetaTileEntityCrystallizationCrucible CRYSTALLIZATION_CRUCIBLE;
    public static MetaTileEntityGreenhouse GREENHOUSE;
    public static MetaTileEntityButchery BUTCHERY;

    public static void init() {
        registerSimpleMetaTileEntity(DRYER, 2100, "dryer", GCYSRecipeMaps.DRYER_RECIPES, GCYSTextures.DRYER_OVERLAY, true, GCYSMetaTileEntities::gcysId, (tier) -> 16000);




        BIO_VAT = registerMetaTileEntity(4100, new MetaTileEntityBioVat(gcysId("bio_vat")));
        CRYSTALLIZATION_CRUCIBLE = registerMetaTileEntity(4101, new MetaTileEntityCrystallizationCrucible(gcysId("crystallization_crucible")));
        STEAM_EJECTOR = registerMetaTileEntity(4102, new MetaTileEntitySteamEjector(gcysId("steam_ejector"), GCYSRecipeMaps.STEAM_EJECTOR_RECIPES, Textures.AIR_VENT_OVERLAY, true));
        HP_STEAM_EJECTOR = registerMetaTileEntity(4103, new MetaTileEntitySteamEjector(gcysId("hp_steam_ejector"), GCYSRecipeMaps.STEAM_EJECTOR_RECIPES, Textures.AIR_VENT_OVERLAY, true));
        GREENHOUSE = registerMetaTileEntity(4104, new MetaTileEntityGreenhouse(gcysId("greenhouse")));
        BUTCHERY = registerMetaTileEntity(4105, new MetaTileEntityButchery(gcysId("butchery")));
    }

    @Nonnull
    private static ResourceLocation gcysId(String name) {
        return new ResourceLocation(GregicalityScience.MODID, name);
    }
}
