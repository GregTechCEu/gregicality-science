package gregicality.science.common.metatileentities;

import gregicality.science.GregicalityScience;
import gregicality.science.api.GCYSValues;
import gregicality.science.api.recipes.GCYSRecipeMaps;
import gregicality.science.client.render.GCYSTextures;
import gregicality.science.common.metatileentities.multiblock.*;
import gregicality.science.common.metatileentities.multiblockpart.MetaTileEntityPressureHatch;
import gregicality.science.common.metatileentities.singleblock.MetaTileEntityCreativePressurePump;
import gregicality.science.common.metatileentities.singleblock.MetaTileEntitySteamEjector;
import gregicality.science.common.metatileentities.singleblock.MetaTileEntitySteamVacuumChamber;
import gregtech.api.GTValues;
import gregtech.api.metatileentity.SimpleMachineMetaTileEntity;
import gregtech.api.util.GTUtility;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;

import static gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity;
import static gregtech.common.metatileentities.MetaTileEntities.registerSimpleMetaTileEntity;

public class GCYSMetaTileEntities {

    public static MetaTileEntitySteamEjector STEAM_EJECTOR;
    public static MetaTileEntitySteamVacuumChamber SMALL_VACUUM_CHAMBER;
    public static MetaTileEntityCreativePressurePump CREATIVE_PRESSURE;

    public static SimpleMachineMetaTileEntity[] DRYER = new SimpleMachineMetaTileEntity[GTValues.V.length - 1];

    public static MetaTileEntityPressureHatch[] PRESSURE_HATCH = new MetaTileEntityPressureHatch[GCYSValues.P.length];

    public static MetaTileEntityCrystallizationCrucible CRYSTALLIZATION_CRUCIBLE;
    public static MetaTileEntityRoaster ROASTER;
    public static MetaTileEntityNanoscaleFabricator NANOSCALE_FABRICATOR;
    public static MetaTileEntityCVDUnit CVD_UNIT;
    public static MetaTileEntityBurnerReactor BURNER_REACTOR;
    public static MetaTileEntityCryoReactor CRYOGENIC_REACTOR;
    public static MetaTileEntityFracker HYDRAULIC_FRACKER;
    public static MetaTileEntitySonicator SONICATOR;
    public static MetaTileEntityCatalyticReformer CATALYTIC_REFORMER;
    public static MetaTileEntityIndustrialDrill INDUSTRIAL_DRILL;

    public static void init() {
        // GCYM Machines: ID 2000-2099

        // Random Machines: ID 2100-2299
        STEAM_EJECTOR = registerMetaTileEntity(2100, new MetaTileEntitySteamEjector(gcysId("steam_ejector")));
        SMALL_VACUUM_CHAMBER = registerMetaTileEntity(2101, new MetaTileEntitySteamVacuumChamber(gcysId("steam_vacuum_chamber")));
        CREATIVE_PRESSURE = registerMetaTileEntity(2102, new MetaTileEntityCreativePressurePump(gcysId("infinite_pressure_pump")));

        // Simple Machines: ID 2300-3000+
        registerSimpleMetaTileEntity(DRYER, 2200, "dryer", GCYSRecipeMaps.DRYER_RECIPES, GCYSTextures.DRYER_OVERLAY, true, GCYSMetaTileEntities::gcysId, GTUtility.hvCappedTankSizeFunction);

        // Multiblock Hatches: ID 3750-3899
        int startId = 3750;
        for (int i = 0; i < PRESSURE_HATCH.length; i++) {
            double min = GCYSValues.P[GCYSValues.EAP];
            double max = GCYSValues.P[GCYSValues.EAP];
            if (i < GCYSValues.EAP) min = GCYSValues.P[i];
            else if (i > GCYSValues.EAP) max = GCYSValues.P[i];
            else continue;

            //TODO change tiers to appropriate values
            int tier = Math.abs(GCYSValues.EAP - i);
            PRESSURE_HATCH[i] = registerMetaTileEntity(startId + i, new MetaTileEntityPressureHatch(gcysId(String.format("pressure_hatch.%s", GCYSValues.PN[i].toLowerCase())), tier, min, max));
        }

        // Multiblocks: Id 3900-3999
        INDUSTRIAL_DRILL = registerMetaTileEntity(3900, new MetaTileEntityIndustrialDrill(gcysId("industrial_drill")));
        CATALYTIC_REFORMER = registerMetaTileEntity(3901, new MetaTileEntityCatalyticReformer(gcysId("catalytic_reformer")));
        SONICATOR = registerMetaTileEntity(3902, new MetaTileEntitySonicator(gcysId("sonicator")));
        HYDRAULIC_FRACKER = registerMetaTileEntity(3903, new MetaTileEntityFracker(gcysId("fracker"), GTValues.ZPM));
        NANOSCALE_FABRICATOR = registerMetaTileEntity(3904, new MetaTileEntityNanoscaleFabricator(gcysId("nanoscale_fabricator")));
        ROASTER = registerMetaTileEntity(3905, new MetaTileEntityRoaster(gcysId("roaster")));
        CRYSTALLIZATION_CRUCIBLE = registerMetaTileEntity(3907, new MetaTileEntityCrystallizationCrucible(gcysId("crystallization_crucible")));
        CVD_UNIT = registerMetaTileEntity(3908, new MetaTileEntityCVDUnit(gcysId("cvd_unit")));
        BURNER_REACTOR = registerMetaTileEntity(3909, new MetaTileEntityBurnerReactor(gcysId("burner_reactor")));
        CRYOGENIC_REACTOR = registerMetaTileEntity(3910, new MetaTileEntityCryoReactor(gcysId("cryogenic_reactor")));
    }

    @Nonnull
    private static ResourceLocation gcysId(String name) {
        return new ResourceLocation(GregicalityScience.MODID, name);
    }
}
