package gregicality.science.common.items;

import gregicality.science.api.unification.materials.GCYSMaterials;
import gregtech.api.items.metaitem.StandardMetaItem;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.ItemMaterialInfo;
import gregtech.api.unification.stack.MaterialStack;

import static gregicality.science.common.items.GCYSMetaItems.*;
import static gregtech.api.GTValues.M;

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

        VOLTAGE_COIL_UHV = addItem(21, "voltage_coil.uhv").setMaterialInfo(new ItemMaterialInfo(new MaterialStack(GCYSMaterials.MercuryCadmiumTelluride, M * 2), new MaterialStack(GCYSMaterials.ChromiumGermaniumTellurideMagnetic, M / 2)));
        VOLTAGE_COIL_UEV = addItem(22, "voltage_coil.uev").setMaterialInfo(new ItemMaterialInfo(new MaterialStack(GCYSMaterials.MercuryCadmiumTelluride, M * 2), new MaterialStack(GCYSMaterials.ChromiumGermaniumTellurideMagnetic, M / 2)));
        VOLTAGE_COIL_UIV = addItem(23, "voltage_coil.uiv").setMaterialInfo(new ItemMaterialInfo(new MaterialStack(GCYSMaterials.MercuryCadmiumTelluride, M * 2), new MaterialStack(GCYSMaterials.ChromiumGermaniumTellurideMagnetic, M / 2)));
        VOLTAGE_COIL_UXV = addItem(24, "voltage_coil.uxv").setMaterialInfo(new ItemMaterialInfo(new MaterialStack(GCYSMaterials.MercuryCadmiumTelluride, M * 2), new MaterialStack(GCYSMaterials.ChromiumGermaniumTellurideMagnetic, M / 2)));
        VOLTAGE_COIL_OpV = addItem(25, "voltage_coil.opv").setMaterialInfo(new ItemMaterialInfo(new MaterialStack(GCYSMaterials.MercuryCadmiumTelluride, M * 2), new MaterialStack(GCYSMaterials.ChromiumGermaniumTellurideMagnetic, M / 2)));
        VOLTAGE_COIL_MAX = addItem(26, "voltage_coil.max").setMaterialInfo(new ItemMaterialInfo(new MaterialStack(GCYSMaterials.MercuryCadmiumTelluride, M * 2), new MaterialStack(GCYSMaterials.ChromiumGermaniumTellurideMagnetic, M / 2)));

        CARBON_ALLOTROPE_MIXTURE = addItem(27, "mixture.carbon_allotrope");
        GRAPHENE_ALIGNED_CNT = addItem(28, "cnt.graphene_aligned");
        COMPONENT_GRINDER_BORON_NITRIDE = addItem(29, "component.grinder.boron_nitride")
                .setMaterialInfo(new ItemMaterialInfo(new MaterialStack(GCYSMaterials.CubicBoronNitride, M * 4), new MaterialStack(GCYSMaterials.Vibranium, M * 8), new MaterialStack(GCYSMaterials.CubicHeterodiamond, M)));

        GOOWARE_BOARD = addItem(30, "board.gooware");
        OPTICAL_BOARD = addItem(31, "board.optical");
        SPINTRONIC_BOARD = addItem(32, "board.spintronic");
        GOOWARE_CIRCUIT_BOARD = addItem(37, "circuit_board.gooware");
        OPTICAL_CIRCUIT_BOARD = addItem(38, "circuit_board.optical");
        SPINTRONIC_CIRCUIT_BOARD = addItem(39, "circuit_board.spintronic");

        BZ_REACTION_CHAMBER = addItem(42, "reaction_chamber.bz");
        NONLINEAR_CHEMICAL_OSCILLATOR = addItem(43, "nonlinear_chemical_oscillator");
        OPTICAL_LASER_CONTROL_UNIT = addItem(44, "optical_laser_control_unit");
        ESR_COMPUTATION_UNIT = addItem(45, "esr_computation_unit");

        PHASE_CHANGE_MEMORY = addItem(46, "plate.phase_change_memory");
        OPTICAL_FIBER = addItem(47, "optical_fiber");
        DIELECTRIC_MIRROR = addItem(48, "dielectric_mirror");
        EMPTY_LASER_ASSEMBLY = addItem(49, "laser.assembly.empty");
        HELIUM_NEON_LASER = addItem(50, "laser.helium_neon");
        ND_YAG_LASER = addItem(51, "laser.nd_yag");

        SPIN_TRANSFER_TORQUE_MEMORY = addItem(52, "plate.spin_transfer_torque_memory");
        TOPOLOGICAL_INSULATOR_TUBE = addItem(53, "tube.topological_insulator");
        BOSE_EINSTEIN_CONDENSATE_CONTAINMENT_UNIT = addItem(54, "containment_unit.bose_einstein_condensate");
        BOSE_EINSTEIN_CONDENSATE = addItem(55, "bose_einstein_condensate");

        EU_DOPED_CUBIC_ZIRCONIA_BOULE = addItem(58, "boule.cubic_zirconia.europium");
        EU_DOPED_CUBIC_ZIRCONIA_WAFER = addItem(59, "wafer.cubic_zirconia.europium");
        CRYSTAL_INTERFACE_WAFER = addItem(60, "wafer.crystal.interface");
        CRYSTAL_INTERFACE_CHIP = addItem(61, "plate.crystal.interface");
        ENGRAVED_RUBY_CRYSTAL_CHIP = addItem(62, "engraved.crystal_chip.ruby");
        ENGRAVED_SAPPHIRE_CRYSTAL_CHIP = addItem(63, "engraved.crystal_chip.sapphire");
        ENGRAVED_DIAMOND_CRYSTAL_CHIP = addItem(64, "engraved.crystal_chip.diamond");
        CRYSTAL_MODULATOR_RUBY = addItem(65, "crystal.modulator.ruby");
        CRYSTAL_MODULATOR_SAPPHIRE = addItem(66, "crystal.modulator.sapphire");
        CRYSTAL_MODULATOR_DIAMOND = addItem(67, "crystal.modulator.diamond");
        CRYSTAL_SYSTEM_ON_CHIP_SOCKET = addItem(68, "crystal.system_on_chip.socket");

        OPTICAL_CAPACITOR = addItem(69, "component.optical_smd.capacitor");
        OPTICAL_DIODE = addItem(70, "component.optical_smd.diode");
        OPTICAL_RESISTOR = addItem(71, "component.optical_smd.resistor");
        OPTICAL_TRANSISTOR = addItem(72, "component.optical_smd.transistor");
        OPTICAL_INDUCTOR = addItem(73, "component.optical_smd.inductor");

        SPINTRONIC_CAPACITOR = addItem(74, "component.spintronic_smd.capacitor");
        SPINTRONIC_DIODE = addItem(75, "component.spintronic_smd.diode");
        SPINTRONIC_RESISTOR = addItem(76, "component.spintronic_smd.resistor");
        SPINTRONIC_TRANSISTOR = addItem(77, "component.spintronic_smd.transistor");
        SPINTRONIC_INDUCTOR = addItem(78, "component.spintronic_smd.inductor");
    }
}
