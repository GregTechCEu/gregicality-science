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
        public boolean disableRareEarthProcessing = true;

        @Config.Comment({"Disables electrolyzing of Platinum Group Sludge, requiring Gregicality's process.", "Default: true"})
        public boolean disablePlatinumProcessing = true;

        @Config.Comment({"Disables electrolyzing of Tungstic Acid, requiring Gregicality's process.", "Default: true"})
        public boolean disableTungstenProcessing = true;

        @Config.Comment({"Disables mixing of Graphene, requiring Gregicality's process.", "Default: true"})
        public boolean disableGrapheneProcessing = true;
    }
}
