package gregicality.science;

import gregicality.science.api.GCYSciLog;
import gregicality.science.api.capability.GCYSciCapabilities;
import gregicality.science.common.CommonProxy;
import gregicality.science.common.GCYSciConfig;
import gregicality.science.common.machine.GCYSciTileEntities;
import gregicality.science.common.block.GCYSciMetaBlocks;
import gregicality.science.common.item.cover.CoverBehaviors;
import gregicality.science.integration.theoneprobe.TheOneProbeCompatibility;
import gregtech.api.GTValues;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.IOException;

@Mod(   modid        = GregicalityScience.MODID,
        name         = GregicalityScience.NAME,
        version      = GregicalityScience.VERSION,
        dependencies = "required-after:gregtech@[2.0,);required-after:gcy_multiblocks")
public class GregicalityScience {

    public static final String MODID = "gcy_science";
    public static final String NAME = "Gregicality: Science";
    public static final String VERSION = "@VERSION@";

    @SidedProxy(modId = MODID, clientSide = "gregicality.science.common.ClientProxy", serverSide = "gregicality.science.common.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void onConstruction(FMLConstructionEvent event) {
        GCYSciConfig.syncMachineConfigs();
        GTValues.HT = true; // force GTCEu to register UHV+ Hulls, Casings, Basic Electric Pieces like Transformers, Bat Buffers, etc.
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        GCYSciLog.init(event.getModLog());
        proxy.preLoad();
        GCYSciCapabilities.init();

        GCYSciMetaBlocks.init();
        GCYSciTileEntities.init();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) throws IOException {
        proxy.onLoad();
        if (GTValues.isModLoaded(GTValues.MODID_TOP)) {
            GCYSciLog.logger.info("TheOneProbe found. Enabling integration...");
            TheOneProbeCompatibility.registerCompatibility();
        }
        CoverBehaviors.init();
    }
}
