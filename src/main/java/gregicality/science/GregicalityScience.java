package gregicality.science;

import gregicality.science.api.GCYSValues;
import gregicality.science.api.sound.GCYSSounds;
import gregicality.science.api.utils.GCYSLog;
import gregicality.science.common.CommonProxy;
import gregicality.science.common.GCYSMetaEntities;
import gregicality.science.common.block.GCYSMetaBlocks;
import gregicality.science.common.items.GCYSMetaItems;
import gregicality.science.common.metatileentities.GCYSMetaTileEntities;
import gregtech.api.GTValues;
import gregtech.api.sound.GTSounds;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import javax.annotation.Nonnull;

@Mod(   modid        = GregicalityScience.MODID,
        name         = GregicalityScience.NAME,
        version      = GregicalityScience.VERSION,
        dependencies = GTValues.MOD_VERSION_DEP + "required-after:gcym")
public class GregicalityScience {

    public static final String MODID = GCYSValues.MODID;
    public static final String NAME = "Gregicality Science";
    public static final String VERSION = "@VERSION@";

    @Mod.Instance(GCYSValues.MODID)
    public static GregicalityScience instance;

    @SidedProxy(modId = MODID, clientSide = "gregicality.science.common.ClientProxy", serverSide = "gregicality.science.common.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void onPreInit(@Nonnull FMLPreInitializationEvent event) {
        GCYSLog.init(event.getModLog());

        GCYSMetaBlocks.init();
        GCYSMetaItems.init();

        GCYSSounds.registerSounds();

        GCYSMetaTileEntities.init();

        GCYSMetaEntities.init();

        proxy.preLoad();
    }
}
