package gregicadditions;

import gregicadditions.capabilities.GregicalityCapabilities;
import gregicadditions.covers.CoverBehaviors;
import gregicadditions.item.GAMetaBlocks;
import gregicadditions.machines.GAMetaTileEntities;
import gregicadditions.theoneprobe.TheOneProbeCompatibility;
import gregicadditions.utils.GALog;
import gregtech.api.GTValues;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.*;

import java.io.IOException;

@Mod(   modid        = Gregicality.MODID,
        name         = Gregicality.NAME,
        version      = Gregicality.VERSION,
        dependencies = "required-after:gregtech@[2.0,);")
public class Gregicality {

    public static final String MODID = "gcys";
    public static final String NAME = "Gregicality: Science";
    public static final String VERSION = "@VERSION@";

    @SidedProxy(modId = MODID, clientSide = "gregicadditions.ClientProxy", serverSide = "gregicadditions.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void onConstruction(FMLConstructionEvent event) {
        GAEnums.onConstruction();
        GAConfig.syncMachineConfigs();
        GTValues.HT = true; // force GTCEu to register UHV+ Hulls, Casings, Basic Electric Pieces like Transformers, Bat Buffers, etc.
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        GALog.init(event.getModLog());
        proxy.preLoad();
        GregicalityCapabilities.init();
        MinecraftForge.EVENT_BUS.register(new GAEventHandler());

        GAMetaBlocks.init();
        GAMetaTileEntities.init();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) throws IOException {
        proxy.onLoad();
        if (GTValues.isModLoaded(GTValues.MODID_TOP)) {
            GALog.logger.info("TheOneProbe found. Enabling integration...");
            TheOneProbeCompatibility.registerCompatibility();
        }
        CoverBehaviors.init();
    }
}
