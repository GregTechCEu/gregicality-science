package gregicality.science;

import gregicality.science.api.utils.GCYSLog;
import gregicality.science.common.CommonProxy;
import gregicality.science.common.block.GCYSMetaBlocks;
import gregicality.science.common.metatileentities.GCYSMetaTileEntities;
import gregtech.api.GTValues;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(   modid        = GregicalityScience.MODID,
        name         = GregicalityScience.NAME,
        version      = GregicalityScience.VERSION,
        dependencies = GTValues.MOD_VERSION_DEP + "required-after:gcym")
public class GregicalityScience {

    public static final String MODID = "gcys";
    public static final String NAME = "Gregicality Science";
    public static final String VERSION = "@VERSION@";

    @SidedProxy(modId = MODID, clientSide = "gregicality.science.common.ClientProxy", serverSide = "gregicality.science.common.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent event) {
        GCYSLog.init(event.getModLog());

        GCYSMetaBlocks.init();
        GCYSMetaTileEntities.init();

        proxy.preLoad();
    }
}
