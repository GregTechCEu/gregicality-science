package gregicality.science.common;

import gregicality.science.GregicalityScience;
import gregtech.common.metatileentities.MetaTileEntities;
import net.minecraftforge.common.config.Config;

@Config(modid = GregicalityScience.MODID)
public class GCYSciConfig {

    @Config.Comment("Config options for GT5U features")
    public static MachineTiers machineTiers = new MachineTiers();

    public static class MachineTiers {
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
        @Config.Name("Should higher tier Disassemblers be registered?")
        public boolean highTierDisassemblers = true;
        @Config.Name("Should higher tier World Accelerators be registered?")
        public boolean highTierWorldAccelerator = true;
    }

    public static void syncMachineConfigs() {
        setMachineConfigs("macerator", machineTiers.highTierMacerators);
        setMachineConfigs("alloy_smelter", machineTiers.highTierAlloySmelter);
        setMachineConfigs("arc_furnace", machineTiers.highTierArcFurnaces);
        setMachineConfigs("assembler", machineTiers.highTierAssemblers);
        setMachineConfigs("autoclave", machineTiers.highTierAutoclaves);
        setMachineConfigs("bender", machineTiers.highTierBenders);
        setMachineConfigs("brewery", machineTiers.highTierBreweries);
        setMachineConfigs("canner", machineTiers.highTierCanners);
        setMachineConfigs("centrifuge", machineTiers.highTierCentrifuges);
        setMachineConfigs("chemical_bath", machineTiers.highTierChemicalBaths);
        setMachineConfigs("chemical_reactor", machineTiers.highTierChemicalReactors);
        setMachineConfigs("compressor", machineTiers.highTierCompressors);
        setMachineConfigs("cutter", machineTiers.highTierCutters);
        setMachineConfigs("distillery", machineTiers.highTierDistilleries);
        setMachineConfigs("electric_furnace", machineTiers.highTierElectricFurnace);
        setMachineConfigs("electrolyzer", machineTiers.highTierElectrolyzers);
        setMachineConfigs("electromagnetic_separator", machineTiers.highTierElectromagneticSeparators);
        setMachineConfigs("extractor", machineTiers.highTierExtractors);
        setMachineConfigs("extruder", machineTiers.highTierExtruders);
        setMachineConfigs("fermenter", machineTiers.highTierFermenters);
        setMachineConfigs("mass_fabricator", machineTiers.highTierMassFabs);
        setMachineConfigs("replicator", machineTiers.highTierReplicators);
        setMachineConfigs("fluid_heater", machineTiers.highTierFluidHeaters);
        setMachineConfigs("fluid_solidifier", machineTiers.highTierFluidSolidifiers);
        setMachineConfigs("forge_hammer", machineTiers.highTierForgeHammers);
        setMachineConfigs("forming_press", machineTiers.highTierFormingPresses);
        setMachineConfigs("lathe", machineTiers.highTierLathes);
        setMachineConfigs("scanner", machineTiers.highTierScanners);
        setMachineConfigs("mixer", machineTiers.highTierMixers);
        setMachineConfigs("ore_washer", machineTiers.highTierOreWashers);
        setMachineConfigs("packer", machineTiers.highTierPackers);
        setMachineConfigs("unpacker", machineTiers.highTierUnpackers);
        setMachineConfigs("polarizer", machineTiers.highTierPolarizers);
        setMachineConfigs("laser_engraver", machineTiers.highTierLaserEngravers);
        setMachineConfigs("sifter", machineTiers.highTierSifters);
        setMachineConfigs("thermal_centrifuge", machineTiers.highTierThermalCentrifuges);
        setMachineConfigs("wiremill", machineTiers.highTierWiremills);
        setMachineConfigs("world_accelerator", machineTiers.highTierWorldAccelerator);
        setMachineConfigs("disassembler", machineTiers.highTierDisassemblers);
    }

    private static void setMachineConfigs(String key, boolean value) {
        if (value) MetaTileEntities.setHighTier(key, true);
        else MetaTileEntities.setMidTier(key, false);
    }
}
