package gregicality.science.common.items;

import gregicality.science.common.items.behaviors.HeldItemDestroyBehavior;
import gregtech.api.items.metaitem.StandardMetaItem;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.common.items.MetaItems;

import static gregicality.science.common.items.GCYSMetaItems.*;

public class GCYSMetaItem1 extends StandardMetaItem {

    public GCYSMetaItem1() {
        super();
    }

    @Override
    public void registerSubItems() {
        MAGNETRON = addItem(0, "magnetron");

        BIOWARE_PROCESSOR = addItem(1, "circuit.bioware_processor").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.ZPM);
        BIOWARE_ASSEMBLY = addItem(2, "circuit.bioware_assembly").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UV);
        BIOWARE_COMPUTER = addItem(3, "circuit.bioware_computer").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UHV);
        BIOWARE_MAINFRAME = addItem(4, "circuit.bioware_mainframe").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UEV);

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

        ULTRASONIC_HOMOGENZIER = addItem(21, "ultrasonic_homogenizer");
        STERILE_PETRI_DISH = addItem(22, "petri_dish.sterile").addComponents(new HeldItemDestroyBehavior(MetaItems.PETRI_DISH));
        CLEAN_CULTURE = addItem(23, "culture.clean").addComponents(new HeldItemDestroyBehavior(MetaItems.PETRI_DISH));
        CUPRIAVIDUS_NECATOR = addItem(24, "culture.cupriavidus_necator").addComponents(new HeldItemDestroyBehavior(MetaItems.PETRI_DISH));
        BREVIBACTERIUM_FLAVUM = addItem(25, "culture.brevibacterium_flavum").addComponents(new HeldItemDestroyBehavior(MetaItems.PETRI_DISH));
        RAPIDLY_REPLICATING_CELLS = addItem(26, "rapidly_replicating_cells").addComponents(new HeldItemDestroyBehavior(MetaItems.FERTILIZER));
        SUPERINTELLIGENT_ORGANISM = addItem(27, "superintelligent_organism").addComponents(new HeldItemDestroyBehavior(MetaItems.FERTILIZER));

        BIOWARE_BOARD = addItem(28, "board.bioware");
        BIOWARE_CIRCUIT_BOARD = addItem(29, "circuit_board.bioware");

        SENTIENT_PROCESSOR = addItem(30, "processor.sentient");

        EU_DOPED_CUBIC_ZIRCONIA_BOULE = addItem(31, "boule.cubic_zirconia.europium");
        EU_DOPED_CUBIC_ZIRCONIA_WAFER = addItem(33, "wafer.cubic_zirconia.europium");
        CRYSTAL_INTERFACE_WAFER = addItem(35, "wafer.crystal.interface");
        CRYSTAL_INTERFACE_CHIP = addItem(36, "plate.crystal.interface");
        ENGRAVED_RUBY_CRYSTAL_CHIP = addItem(38, "engraved.crystal_chip.ruby");
        ENGRAVED_SAPPHIRE_CRYSTAL_CHIP = addItem(39, "engraved.crystal_chip.sapphire");
        ENGRAVED_DIAMOND_CRYSTAL_CHIP = addItem(40, "engraved.crystal_chip.diamond");
        CRYSTAL_MODULATOR_RUBY = addItem(41, "crystal.modulator.ruby");
        CRYSTAL_MODULATOR_SAPPHIRE = addItem(42, "crystal.modulator.sapphire");
        CRYSTAL_MODULATOR_DIAMOND = addItem(43, "crystal.modulator.diamond");
        CRYSTAL_SYSTEM_ON_CHIP_SOCKET = addItem(44, "crystal.system_on_chip.socket");

        INSANE_SMD_CAPACITOR = addItem(45, "component.insane_smd.capacitor");
        INSANE_SMD_DIODE = addItem(46, "component.insane_smd.diode");
        INSANE_SMD_RESISTOR = addItem(47, "component.insane_smd.resistor");
        INSANE_SMD_TRANSISTOR = addItem(48, "component.insane_smd.transistor");
        INSANE_SMD_INDUCTOR = addItem(49, "component.insane_smd.inductor");

//        QUARTZ_CRUCIBLE = addItem(50, "crucible.quartz").addComponents(new CrucibleItemBehavior(2482));
//        TUNGSTEN_CRUCIBLE = addItem(51, "crucible.tungsten").addComponents(new CrucibleItemBehavior(3695));
//        GRAPHITE_CRUCIBLE = addItem(52, "crucible.graphite").addComponents(new CrucibleItemBehavior(4750));
//        BORON_NITRIDE_CRUCIBLE = addItem(53, "crucible.boron_nitride").addComponents(new CrucibleItemBehavior(5328));
    }
}
