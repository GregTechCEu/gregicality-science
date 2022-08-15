package gregicality.science.common;

import gregicality.science.GregicalityScience;
import net.minecraftforge.common.config.Config;

@Config(modid = GregicalityScience.MODID)
public class GCYSConfigHolder {

    @Config.Comment("Config options for modification of GTCEu Processing Chains")
    @Config.Name("Processing Chain Override Options")
    public static ChainOverrides chainOverrides = new ChainOverrides();

    @Config.Comment("Config options for modification of GTCEu Circuit Recipes")
    @Config.Name("Circuit Recipe Override Options")
    public static CircuitOverrides circuitOverrides = new CircuitOverrides();

    public static class ChainOverrides {

        @Config.Comment({"Disables centrifuging of Rare Earth, requiring Gregicality's process.", "Default: true"})
        public boolean disableRareEarthProcessing = true;

        @Config.Comment({"Disables electrolyzing of Platinum Group Sludge, requiring Gregicality's process.", "Default: true"})
        public boolean disablePlatinumProcessing = true;

        @Config.Comment({"Disables electrolyzing of Tungstic Acid, requiring Gregicality's process.", "Default: true"})
        public boolean disableTungstenProcessing = true;

        @Config.Comment({"Disables mixing of Graphene, requiring Gregicality's process.", "Default: true"})
        public boolean disableGrapheneProcessing = true;

        @Config.Comment({"Disables electrolysis of Tantalite and Pyrochlore, requiring Gregicality's processes for Niobium and Tantalum.", "Default: true"})
        public boolean disableNiobiumTantalumProcessing = true;

        @Config.Comment({"Disables production of Ammonia from Nitrogen and Hydrogen, requiring Gregicality's process.", "Default: false"})
        public boolean disableAmmoniaProcessing = false;

        @Config.Comment({"Disables electrolysis of Molybdenite, Powellite, and Wulfenite, requiring Gregicality's processes for Molybdenum.", "Default: true"})
        public boolean disableMolybdenumProcessing = true;
    }

    public static class CircuitOverrides {

        @Config.Comment({"Requires Steam-Tier Vacuum Equipment in order to produce Vacuum Tubes, instead of just crafting.", "Default: true"})
        public boolean harderVacuumTubes = true;

        @Config.Comment({"Requires Cubic Zirconia and more components in order to produce Crystal SOCs, instead of just Crystal CPUs.", "Default: true"})
        public boolean harderCrystalCircuits = true;

        @Config.Comment({"Requires Kapton K in order to produce Wetware Circuit Boards, instead of Multi-layer Epoxy.", "Default: true"})
        public boolean harderWetwareCircuits = true;
    }
}
