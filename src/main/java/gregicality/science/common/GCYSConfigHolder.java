package gregicality.science.common;

import gregicality.science.GregicalityScience;
import net.minecraftforge.common.config.Config;

@Config(modid = GregicalityScience.MODID)
public class GCYSConfigHolder {

    @Config.Comment("Config options applying to modification of GTCEu Processing Chains")
    @Config.Name("Processing Chain Override Options")
    public static ChainOverrides chainOverrides = new ChainOverrides();

    public static class ChainOverrides {

        @Config.Comment({"Disables centrifuging of Rare Earth, requiring Gregicality's process.", "Default: true"})
        public boolean disableRareEarthCentrifuging = true;
    }
}
