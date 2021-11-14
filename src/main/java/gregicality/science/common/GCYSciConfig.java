package gregicality.science.common;

import gregicality.science.GregicalityScience;
import gregtech.api.GTValues;
import gregtech.common.metatileentities.MetaTileEntities;
import net.minecraftforge.common.config.Config;

@Config(modid = GregicalityScience.MODID)
public class GCYSciConfig {

    @Config.Comment({"Configs for Client Side"})
    public static Client client = new Client();

    public static class Client {
        @Config.Comment("Should use advanced model for casings")
        @Config.Name("Advanced Casing Model")
        @Config.RequiresMcRestart
        public boolean AdvancedCasingModel = true;
    }

    @Config.Comment("Config options for GT5U features")
    public static GT5U GT5U = new GT5U();

    public static class GT5U {
        @Config.Comment("3x3 Crafting Table Recipe Removals")
        @Config.Name("Crafting - Remove 3x3 Block Crafting Recipes from Crafting Table")
        public boolean Remove3x3BlockRecipes = false;
        @Config.Name("Crafting - Remove 3x3 Nugget Crafting Recipes from Crafting Table")
        public boolean Remove3x3NuggetRecipes = false;
        @Config.Name("Crafting - Remove 3x3 Misc Recipes from Crafting Table (all others)")
        public boolean Remove3x3MiscRecipes = false;

        @Config.Comment("1->9 Crafting Table Recipe Removals")
        @Config.Name("Crafting - Remove 1->9 Block Uncrafting Recipes from Crafting Table")
        public boolean Remove1to9BlockRecipes = false;
        @Config.Name("Crafting - Remove 1->9 Nugget Uncrafting Recipes from Crafting Table")
        public boolean Remove1to9NuggetRecipes = false;
        @Config.Name("Crafting - Remove 1-> Misc Recipes from Crafting Table (all others)")
        public boolean Remove1to9MiscRecipes = false;

        @Config.Comment("Set to false to enable Log>Charcoal smelting recipes")
        @Config.Name("All Log to Charcoal smelting recipes will be removed")
        public boolean DisableLogToCharcoalSmelting = true;

        @Config.Comment("Set these to false to disable the higher tier versions of machines")
        @Config.Name("Should higher tier Alloy Smelters be registered?")
        public boolean highTierAlloySmelter = true;
        @Config.Name("Should higher tier Arc Furnaces be registered?")
        public boolean highTierArcFurnaces = true;
        @Config.Name("Should higher tier Assembling Machines be registered?")
        public boolean highTierAssemblers = true;
        @Config.Name("Should higher tier Autoclaves be registered?")
        public boolean highTierAutoclaves = true;
        @Config.Name("Should higher tier Bending Machines be registered?")
        public boolean highTierBenders = true;
        @Config.Name("Should higher tier Breweries be registered?")
        public boolean highTierBreweries = true;
        @Config.Name("Should higher tier Canning Machines be registered?")
        public boolean highTierCanners = true;
        @Config.Name("Should higher tier Centrifuges be registered?")
        public boolean highTierCentrifuges = true;
        @Config.Name("Should higher tier Chemical Baths be registered?")
        public boolean highTierChemicalBaths = true;
        @Config.Name("Should higher tier Chemical Reactors be registered?")
        public boolean highTierChemicalReactors = true;
        @Config.Name("Should higher tier Compressors be registered?")
        public boolean highTierCompressors = true;
        @Config.Name("Should higher tier Cutting Machines be registered?")
        public boolean highTierCutters = true;
        @Config.Name("Should higher tier Distilleries be registered?")
        public boolean highTierDistilleries = true;
        @Config.Name("Should higher tier Electric Furnaces be registered?")
        public boolean highTierElectricFurnace = true;
        @Config.Name("Should higher tier Electrolyzers be registered?")
        public boolean highTierElectrolyzers = true;
        @Config.Name("Should higher tier Electromagnetic Separators be registered?")
        public boolean highTierElectromagneticSeparators = true;
        @Config.Name("Should higher tier Extractors be registered?")
        public boolean highTierExtractors = true;
        @Config.Name("Should higher tier Extruders be registered?")
        public boolean highTierExtruders = true;
        @Config.Name("Should higher tier Fermenters be registered?")
        public boolean highTierFermenters = true;
        @Config.Name("Should higher tier Fluid Heaters be registered?")
        public boolean highTierFluidHeaters = true;
        @Config.Name("Should higher tier Fluid Heaters be registered?")
        public boolean highTierFluidSolidifiers = true;
        @Config.Name("Should higher tier Forge Hammers be registered?")
        public boolean highTierForgeHammers = true;
        @Config.Name("Should higher tier Forming Presses be registered?")
        public boolean highTierFormingPresses = true;
        @Config.Name("Should higher tier Lathes be registered?")
        public boolean highTierLathes = true;
        @Config.Name("Should higher tier Mixers be registered?")
        public boolean highTierMixers = true;
        @Config.Name("Should higher tier Ore Washers be registered?")
        public boolean highTierOreWashers = true;
        @Config.Name("Should higher tier Packagers be registered?")
        public boolean highTierPackers = true;
        @Config.Name("Should higher tier Polarizers be registered?")
        public boolean highTierPolarizers = true;
        @Config.Name("Should higher tier Precision Laser Engravers be registered?")
        public boolean highTierLaserEngravers = true;
        @Config.Name("Should higher tier Replicators be registered?")
        public boolean highTierReplicators = true;
        @Config.Name("Should higher tier Sifting Machines be registered?")
        public boolean highTierSifters = true;
        @Config.Name("Should higher tier Thermal Centrifuges be registered?")
        public boolean highTierThermalCentrifuges = true;
        @Config.Name("Should higher tier Macerators be registered?")
        public boolean highTierMacerators = true;
        @Config.Name("Should higher tier Mass Fabricators be registered?")
        public boolean highTierMassFabs = true;
        @Config.Name("Should higher tier Unpackagers be registered?")
        public boolean highTierUnpackers = true;
        @Config.Name("Should higher tier Wiremills be registered?")
        public boolean highTierWiremills = true;
        @Config.Name("Should higher tier Scanners be registered?")
        public boolean highTierScanners = true;
        @Config.Name("Should higher tier Chemical Dehydrators be registered?")
        public boolean highTierChemicalDehydrator = true;
        @Config.Name("Should higher tier Decay Chambers be registered?")
        public boolean highTierDecayChamber = true;
        @Config.Name("Should higher tier Green Houses be registered?")
        public boolean highTierGreenHouse = true;
        @Config.Name("Should higher tier Disassemblers be registered?")
        public boolean highTierDisassemblers = true;
        @Config.Name("Should higher tier World Accelerators be registered?")
        public boolean highTierWorldAccelerator = true;
    }

    public static Multis multis = new Multis();

    public static class Multis {

        public VoidMiner voidMiner = new VoidMiner();
        public AdvFusion advFusion = new AdvFusion();
        public HyperReactors hyperReactors = new HyperReactors();
    }

    public static class AdvFusion {
        @Config.Comment("The percentage per tier above the tier required by the recipe to decrease the recipe duration.")
        @Config.Name("Advanced Fusion Coil duration discount")
        @Config.RangeDouble(min = 0.0, max = 0.99)
        @Config.RequiresMcRestart
        public double coilDurationDiscount = 0.05;

        @Config.Comment("The percentage per tier above the tier required by the recipe to increase the amount of coolant.")
        @Config.Name("Advanced Fusion Coil duration discount")
        @Config.RangeDouble(min = 0.0, max = 0.99)
        @Config.RequiresMcRestart
        public double vacuumCoolantIncrease = 0.05;

        @Config.Comment("The percentage per tier above the tier required by the recipe to decrease the EU/t.")
        @Config.Name("Advanced Fusion Coil duration discount")
        @Config.RangeDouble(min = 0.0, max = 0.99)
        @Config.RequiresMcRestart
        public double vacuumEnergyDecrease = 0.15;

        @Config.Comment("The percentage per tier above the tier required by the recipe to decrease the EU/t.")
        @Config.Name("Advanced Fusion Coil duration discount")
        @Config.RangeDouble(min = 0.0, max = 0.99)
        @Config.RequiresMcRestart
        public double divertorOutputIncrease = 0.10;

    }

    public static class VoidMiner {
        @Config.Comment("The maximum temperature the void miner can reach before overheating. Every second the void miner will generate 10 different ores with amount between 1 and (temperature/1000)^2 ores. default: [9000]")
        @Config.RangeInt(min = 1000)
        @Config.RequiresMcRestart
        @Config.Name("Void Miner I max temperature")
        public int maxTemp = 9000;

        @Config.Comment("The maximum temperature the void miner can reach before overheating. Every second the void miner will generate 10 different ores with amount between 1 and (temperature/1000)^2 ores. default: [9000]")
        @Config.RangeInt(min = 1000)
        @Config.RequiresMcRestart
        @Config.Name("Void Miner II max temperature")
        public int maxTempUHV = 16000;

        @Config.Comment("The maximum temperature the void miner can reach before overheating. Every second the void miner will generate 10 different ores with amount between 1 and (temperature/1000)^2 ores. default: [9000]")
        @Config.RangeInt(min = 1000)
        @Config.RequiresMcRestart
        @Config.Name("Void Miner III max temperature")
        public int maxTempUEV = 25000;

        @Config.Comment("Whether or not to add all ore variants to the Void Miner's ore table. If false only the first ore in the material's ore dictionary will be added.")
        @Config.RequiresMcRestart
        @Config.Name("Void miner ore variants")
        public boolean oreVariants = true;

        @Config.Comment("The name of the ores to blacklist for the MK1 Void Miner")
        @Config.RequiresMcRestart
        @Config.Name("MK1 Void Miner Blacklist")
        public String[] oreBlacklist = new String[]{"trinium"};

        @Config.Comment("The name of the ores to blacklist for the MK2 Void Miner")
        @Config.RequiresMcRestart
        @Config.Name("MK2 Void Miner Blacklist")
        public String[] oreBlacklistUHV = new String[]{""};

        @Config.Comment("The name of the ores to blacklist for the MK3 Void Miner")
        @Config.RequiresMcRestart
        @Config.Name("MK3 Void Miner Blacklist")
        public String[] oreBlacklistUEV = new String[]{""};

        @Config.Comment("The name of items you wish to add to the MK1 Void Miner. Example: \"minecraft:wool:2\"")
        @Config.RequiresMcRestart
        @Config.Name("MK1 Void Miner Whitelist")
        public String[] oreWhitelist = new String[]{""};

        @Config.Comment("The name of items you wish to add to the MK2 Void Miner")
        @Config.RequiresMcRestart
        @Config.Name("MK2 Void Miner Whitelist")
        public String[] oreWhitelistUHV = new String[]{""};

        @Config.Comment("The name of items you wish to add to the MK3 Void Miner")
        @Config.RequiresMcRestart
        @Config.Name("MK3 Void Miner Whitelist")
        public String[] oreWhitelistUEV = new String[]{""};
    }

    public static class HyperReactors {
        @Config.Comment("The base EU/t production of the Hyper Reactor.")
        @Config.RequiresMcRestart
        @Config.Name("Hyper Reactor EU/t generation")
        @Config.RangeInt(min = 1)
        public int[] euGeneration = {(int) GTValues.V[GTValues.UHV], (int) GTValues.V[GTValues.UEV], (int) GTValues.V[GTValues.UIV]};

        @Config.Comment("The fuel multiplier when the Reactor is boosted.")
        @Config.RequiresMcRestart
        @Config.Name("Hyper Reactor boosted fuel amount multiplier")
        @Config.RangeInt(min = 1)
        public int[] boostedFuelAmount = {2, 2, 2};

        @Config.Comment("The EU/t multiplier when the Reactor is boosted.")
        @Config.RequiresMcRestart
        @Config.Name("Hyper Reactor boosted EU/t multiplier")
        @Config.RangeInt(min = 1)
        public int[] boostedEuAmount = {3, 3, 3};

        @Config.Comment("The liquid that boosts the Reactor.")
        @Config.RequiresMcRestart
        @Config.Name("Hyper Reactor boosters")
        public String[] boosterFluid = {"plasma.helium", "plasma.radon", "plasma.degenerate_rhenium_plasma"};

        @Config.Comment("The amount of liquid that boosts the Reactor.")
        @Config.RequiresMcRestart
        @Config.Name("Hyper Reactor booster amount")
        public int[] boosterFluidAmounts = {10, 15, 2};
    }

    public static void syncMachineConfigs() {
        setMachineConfigs("macerator", GT5U.highTierMacerators);
        setMachineConfigs("alloy_smelter", GT5U.highTierAlloySmelter);
        setMachineConfigs("arc_furnace", GT5U.highTierArcFurnaces);
        setMachineConfigs("assembler", GT5U.highTierAssemblers);
        setMachineConfigs("autoclave", GT5U.highTierAutoclaves);
        setMachineConfigs("bender", GT5U.highTierBenders);
        setMachineConfigs("brewery", GT5U.highTierBreweries);
        setMachineConfigs("canner", GT5U.highTierCanners);
        setMachineConfigs("centrifuge", GT5U.highTierCentrifuges);
        setMachineConfigs("chemical_bath", GT5U.highTierChemicalBaths);
        setMachineConfigs("chemical_reactor", GT5U.highTierChemicalReactors);
        setMachineConfigs("compressor", GT5U.highTierCompressors);
        setMachineConfigs("cutter", GT5U.highTierCutters);
        setMachineConfigs("distillery", GT5U.highTierDistilleries);
        setMachineConfigs("electric_furnace", GT5U.highTierElectricFurnace);
        setMachineConfigs("electrolyzer", GT5U.highTierElectrolyzers);
        setMachineConfigs("electromagnetic_separator", GT5U.highTierElectromagneticSeparators);
        setMachineConfigs("extractor", GT5U.highTierExtractors);
        setMachineConfigs("extruder", GT5U.highTierExtruders);
        setMachineConfigs("fermenter", GT5U.highTierFermenters);
        setMachineConfigs("mass_fabricator", GT5U.highTierMassFabs);
        setMachineConfigs("replicator", GT5U.highTierReplicators);
        setMachineConfigs("fluid_heater", GT5U.highTierFluidHeaters);
        setMachineConfigs("fluid_solidifier", GT5U.highTierFluidSolidifiers);
        setMachineConfigs("forge_hammer", GT5U.highTierForgeHammers);
        setMachineConfigs("forming_press", GT5U.highTierFormingPresses);
        setMachineConfigs("lathe", GT5U.highTierLathes);
        setMachineConfigs("scanner", GT5U.highTierScanners);
        setMachineConfigs("mixer", GT5U.highTierMixers);
        setMachineConfigs("ore_washer", GT5U.highTierOreWashers);
        setMachineConfigs("packer", GT5U.highTierPackers);
        setMachineConfigs("unpacker", GT5U.highTierUnpackers);
        setMachineConfigs("polarizer", GT5U.highTierPolarizers);
        setMachineConfigs("laser_engraver", GT5U.highTierLaserEngravers);
        setMachineConfigs("sifter", GT5U.highTierSifters);
        setMachineConfigs("thermal_centrifuge", GT5U.highTierThermalCentrifuges);
        setMachineConfigs("wiremill", GT5U.highTierWiremills);
        setMachineConfigs("dehydrator", GT5U.highTierChemicalDehydrator);
        setMachineConfigs("decay_chamber", GT5U.highTierDecayChamber);
        setMachineConfigs("green_house", GT5U.highTierGreenHouse);
        setMachineConfigs("disassembler", GT5U.highTierDisassemblers);
        MetaTileEntities.setMidTier("circuit_assembler", false); // only Circuit Assemblers through IV
    }

    private static void setMachineConfigs(String key, boolean value) {
        if (value) MetaTileEntities.setHighTier(key, true);
        else MetaTileEntities.setMidTier(key, false);
    }
}
