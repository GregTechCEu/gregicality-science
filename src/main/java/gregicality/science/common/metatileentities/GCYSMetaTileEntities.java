package gregicality.science.common.metatileentities;

import gregicality.science.GregicalityScience;
import gregicality.science.api.recipes.GCYSRecipeMaps;
import gregicality.science.client.render.GCYSTextures;
import gregicality.science.common.metatileentities.multiblock.*;
import gregicality.science.common.metatileentities.singleblock.MetaTileEntitySteamEjector;
import gregtech.api.GTValues;
import gregtech.api.metatileentity.SimpleMachineMetaTileEntity;
import gregtech.api.util.GTUtility;
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
    public static MetaTileEntityRoaster ROASTER;
    public static MetaTileEntityNanoscaleFabricator NANOSCALE_FABRICATOR;
    public static MetaTileEntityCVDUnit CVD_UNIT;
    public static MetaTileEntityBurnerReactor BURNER_REACTOR;
    public static MetaTileEntityCryoReactor CRYOGENIC_REACTOR;
    public static MetaTileEntityFracker HYDRAULIC_FRACKER;
    public static MetaTileEntitySonicator SONICATOR;
    public static MetaTileEntityCatalyticReformer CATALYTIC_REFORMER;

    public static void init() {
        registerSimpleMetaTileEntity(DRYER, 2100, "dryer", GCYSRecipeMaps.DRYER_RECIPES, GCYSTextures.DRYER_OVERLAY, true, GCYSMetaTileEntities::gcysId, GTUtility.hvCappedTankSizeFunction);

        CATALYTIC_REFORMER = registerMetaTileEntity(4095, new MetaTileEntityCatalyticReformer(gcysId("catalytic_reformer")));
        SONICATOR = registerMetaTileEntity(4096, new MetaTileEntitySonicator(gcysId("sonicator")));
        HYDRAULIC_FRACKER = registerMetaTileEntity(4097, new MetaTileEntityFracker(gcysId("fracker"), GTValues.ZPM));
        NANOSCALE_FABRICATOR = registerMetaTileEntity(4098, new MetaTileEntityNanoscaleFabricator(gcysId("nanoscale_fabricator")));
        ROASTER = registerMetaTileEntity(4099, new MetaTileEntityRoaster(gcysId("roaster")));
        BIO_VAT = registerMetaTileEntity(4100, new MetaTileEntityBioVat(gcysId("bio_vat")));
        CRYSTALLIZATION_CRUCIBLE = registerMetaTileEntity(4101, new MetaTileEntityCrystallizationCrucible(gcysId("crystallization_crucible")));
        CVD_UNIT = registerMetaTileEntity(4102, new MetaTileEntityCVDUnit(gcysId("cvd_unit")));
        BURNER_REACTOR = registerMetaTileEntity(4103, new MetaTileEntityBurnerReactor(gcysId("burner_reactor")));
        CRYOGENIC_REACTOR = registerMetaTileEntity(4104, new MetaTileEntityCryoReactor(gcysId("cryogenic_reactor")));
        STEAM_EJECTOR = registerMetaTileEntity(4105, new MetaTileEntitySteamEjector(gcysId("steam_ejector"), GCYSRecipeMaps.STEAM_EJECTOR_RECIPES, Textures.AIR_VENT_OVERLAY, true));
        HP_STEAM_EJECTOR = registerMetaTileEntity(4106, new MetaTileEntitySteamEjector(gcysId("hp_steam_ejector"), GCYSRecipeMaps.STEAM_EJECTOR_RECIPES, Textures.AIR_VENT_OVERLAY, true));
    }

    @Nonnull
    private static ResourceLocation gcysId(String name) {
        return new ResourceLocation(GregicalityScience.MODID, name);
    }
}
