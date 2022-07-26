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

        SPINTRONIC_PROCESSOR = addItem(9, "circuit.spintronic_processor").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UHV);
        SPINTRONIC_ASSEMBLY = addItem(10, "circuit.spintronic_assembly").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UEV);
        SPINTRONIC_COMPUTER = addItem(11, "circuit.spintronic_computer").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UIV);
        SPINTRONIC_MAINFRAME = addItem(12, "circuit.spintronic_mainframe").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UXV);

        COSMIC_PROCESSOR = addItem(13, "circuit.cosmic_processor").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UEV);
        COSMIC_ASSEMBLY = addItem(14, "circuit.cosmic_assembly").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UIV);
        COSMIC_COMPUTER = addItem(15, "circuit.cosmic_computer").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UXV);
        COSMIC_MAINFRAME = addItem(16, "circuit.cosmic_mainframe").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.OpV);

        SUPRACAUSAL_PROCESSOR = addItem(17, "circuit.supracausal_processor").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UIV);
        SUPRACAUSAL_ASSEMBLY = addItem(18, "circuit.supracausal_assembly").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UXV);
        SUPRACAUSAL_COMPUTER = addItem(19, "circuit.supracausal_computer").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.OpV);
        SUPRACAUSAL_MAINFRAME = addItem(20, "circuit.supracausal_mainframe").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.MAX);

        CARBON_ALLOTROPE_MIXTURE = addItem(21, "mixture.carbon_allotrope");
        GRAPHENE_ALIGNED_CNT = addItem(22, "cnt.graphene_aligned");

        GOOWARE_BOARD = addItem(28, "board.gooware");
        OPTICAL_BOARD = addItem(29, "board.optical");
        GOOWARE_CIRCUIT_BOARD = addItem(35, "circuit_board.gooware");
        OPTICAL_CIRCUIT_BOARD = addItem(36, "circuit_board.optical");

        BZ_REACTION_CHAMBER = addItem(40, "reaction_chamber.bz");
        NONLINEAR_CHEMICAL_OSCILLATOR = addItem(41, "nonlinear_chemical_oscillator");
        OPTICAL_LASER_CONTROL_UNIT = addItem(42, "optical_laser_control_unit");

        PHASE_CHANGE_MEMORY = addItem(43, "plate.phase_change_memory");
        OPTICAL_FIBER = addItem(44, "optical_fiber");
        DIELECTRIC_MIRROR = addItem(45, "dielectric_mirror");
        EMPTY_LASER_ASSEMBLY = addItem(46, "laser.assembly.empty");
        HELIUM_NEON_LASER = addItem(47, "laser.helium_neon");
        ND_YAG_LASER = addItem(48, "laser.nd_yag");

        MAGNETORESTRICTIVE_MEMORY = addItem(49, "plate.magnetorestrictive_memory");

        EU_DOPED_CUBIC_ZIRCONIA_BOULE = addItem(55, "boule.cubic_zirconia.europium");
        EU_DOPED_CUBIC_ZIRCONIA_WAFER = addItem(56, "wafer.cubic_zirconia.europium");
        CRYSTAL_INTERFACE_WAFER = addItem(57, "wafer.crystal.interface");
        CRYSTAL_INTERFACE_CHIP = addItem(58, "plate.crystal.interface");
        ENGRAVED_RUBY_CRYSTAL_CHIP = addItem(59, "engraved.crystal_chip.ruby");
        ENGRAVED_SAPPHIRE_CRYSTAL_CHIP = addItem(60, "engraved.crystal_chip.sapphire");
        ENGRAVED_DIAMOND_CRYSTAL_CHIP = addItem(61, "engraved.crystal_chip.diamond");
        CRYSTAL_MODULATOR_RUBY = addItem(62, "crystal.modulator.ruby");
        CRYSTAL_MODULATOR_SAPPHIRE = addItem(63, "crystal.modulator.sapphire");
        CRYSTAL_MODULATOR_DIAMOND = addItem(64, "crystal.modulator.diamond");
        CRYSTAL_SYSTEM_ON_CHIP_SOCKET = addItem(65, "crystal.system_on_chip.socket");

        OPTICAL_INTEGRATOR = addItem(66, "component.optical_smd.capacitor");
        OPTICAL_ISOLATOR = addItem(67, "component.optical_smd.diode");
        PHOTORESISTOR = addItem(68, "component.optical_smd.resistor");
        OPTICAL_TRANSISTOR = addItem(69, "component.optical_smd.transistor");
        OPTICAL_POLARIZER = addItem(70, "component.optical_smd.inductor");

//        QUARTZ_CRUCIBLE = addItem(50, "crucible.quartz").addComponents(new CrucibleItemBehavior(2482));
//        TUNGSTEN_CRUCIBLE = addItem(51, "crucible.tungsten").addComponents(new CrucibleItemBehavior(3695));
//        GRAPHITE_CRUCIBLE = addItem(52, "crucible.graphite").addComponents(new CrucibleItemBehavior(4750));
//        BORON_NITRIDE_CRUCIBLE = addItem(53, "crucible.boron_nitride").addComponents(new CrucibleItemBehavior(5328));
    }
}
