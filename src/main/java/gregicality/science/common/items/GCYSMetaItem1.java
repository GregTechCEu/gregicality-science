package gregicality.science.common.items;

import gregtech.api.items.metaitem.StandardMetaItem;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.ore.OrePrefix;

import static gregicality.science.common.items.GCYSMetaItems.*;

public class GCYSMetaItem1 extends StandardMetaItem {

    public GCYSMetaItem1() {
        super();
    }

    @Override
    public void registerSubItems() {
        MAGNETRON = addItem(0, "magnetron");

        GOOWARE_PROCESSOR = addItem(1, "circuit.gooware_processor").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.ZPM);
        GOOWARE_ASSEMBLY = addItem(2, "circuit.gooware_assembly").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UV);
        GOOWARE_COMPUTER = addItem(3, "circuit.gooware_computer").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UHV);
        GOOWARE_MAINFRAME = addItem(4, "circuit.gooware_mainframe").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UEV);

        OPTICAL_PROCESSOR = addItem(5,"circuit.optical_processor").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UV);
        OPTICAL_ASSEMBLY = addItem(6,"circuit.optical_assembly").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UHV);
        OPTICAL_COMPUTER = addItem(7,"circuit.optical_computer").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UEV);
        OPTICAL_MAINFRAME = addItem(8,"circuit.optical_mainframe").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UIV);

        EXOTIC_PROCESSOR = addItem(9, "circuit.exotic_processor").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UHV);
        EXOTIC_ASSEMBLY = addItem(10, "circuit.exotic_assembly").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UEV);
        EXOTIC_COMPUTER = addItem(11, "circuit.exotic_computer").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UIV);
        EXOTIC_MAINFRAME = addItem(12, "circuit.exotic_mainframe").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UXV);

        COSMIC_PROCESSOR = addItem(13, "circuit.cosmic_processor").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UEV);
        COSMIC_ASSEMBLY = addItem(14, "circuit.cosmic_assembly").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UIV);
        COSMIC_COMPUTER = addItem(15, "circuit.cosmic_computer").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UXV);
        COSMIC_MAINFRAME = addItem(16, "circuit.cosmic_mainframe").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.OpV);

        SUPRACAUSAL_PROCESSOR = addItem(17, "circuit.supracausal_processor").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UIV);
        SUPRACAUSAL_ASSEMBLY = addItem(18, "circuit.supracausal_assembly").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UXV);
        SUPRACAUSAL_COMPUTER = addItem(19, "circuit.supracausal_computer").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.OpV);
        SUPRACAUSAL_MAINFRAME = addItem(20, "circuit.supracausal_mainframe").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.MAX);

        GOOWARE_BOARD = addItem(28, "board.gooware");
        GOOWARE_CIRCUIT_BOARD = addItem(29, "circuit_board.gooware");

        BZ_REACTION_CHAMBER = addItem(30, "reaction_chamber.bz");
        NONLINEAR_CHEMICAL_OSCILLATOR = addItem(31, "nonlinear_chemical_oscillator");

        PHASE_CHANGE_MEMORY = addItem(32, "plate.phase_change_memory");
        OPTICAL_FIBER = addItem(33, "optical_fiber");

        EU_DOPED_CUBIC_ZIRCONIA_BOULE = addItem(35, "boule.cubic_zirconia.europium");
        EU_DOPED_CUBIC_ZIRCONIA_WAFER = addItem(36, "wafer.cubic_zirconia.europium");
        CRYSTAL_INTERFACE_WAFER = addItem(37, "wafer.crystal.interface");
        CRYSTAL_INTERFACE_CHIP = addItem(38, "plate.crystal.interface");
        ENGRAVED_RUBY_CRYSTAL_CHIP = addItem(39, "engraved.crystal_chip.ruby");
        ENGRAVED_SAPPHIRE_CRYSTAL_CHIP = addItem(40, "engraved.crystal_chip.sapphire");
        ENGRAVED_DIAMOND_CRYSTAL_CHIP = addItem(41, "engraved.crystal_chip.diamond");
        CRYSTAL_MODULATOR_RUBY = addItem(42, "crystal.modulator.ruby");
        CRYSTAL_MODULATOR_SAPPHIRE = addItem(43, "crystal.modulator.sapphire");
        CRYSTAL_MODULATOR_DIAMOND = addItem(44, "crystal.modulator.diamond");
        CRYSTAL_SYSTEM_ON_CHIP_SOCKET = addItem(45, "crystal.system_on_chip.socket");

        INSANE_SMD_CAPACITOR = addItem(46, "component.insane_smd.capacitor");
        INSANE_SMD_DIODE = addItem(47, "component.insane_smd.diode");
        INSANE_SMD_RESISTOR = addItem(48, "component.insane_smd.resistor");
        INSANE_SMD_TRANSISTOR = addItem(49, "component.insane_smd.transistor");
        INSANE_SMD_INDUCTOR = addItem(50, "component.insane_smd.inductor");

//        QUARTZ_CRUCIBLE = addItem(50, "crucible.quartz").addComponents(new CrucibleItemBehavior(2482));
//        TUNGSTEN_CRUCIBLE = addItem(51, "crucible.tungsten").addComponents(new CrucibleItemBehavior(3695));
//        GRAPHITE_CRUCIBLE = addItem(52, "crucible.graphite").addComponents(new CrucibleItemBehavior(4750));
//        BORON_NITRIDE_CRUCIBLE = addItem(53, "crucible.boron_nitride").addComponents(new CrucibleItemBehavior(5328));
    }
}
