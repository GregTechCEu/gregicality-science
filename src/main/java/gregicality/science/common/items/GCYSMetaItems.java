package gregicality.science.common.items;

import gregicality.science.api.unification.materials.GCYSMaterials;
import gregicality.science.common.GCYSConfigHolder;
import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.items.metaitem.StandardMetaItem;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.ItemMaterialInfo;
import gregtech.api.unification.stack.MaterialStack;

import static gregtech.api.GTValues.M;

public class GCYSMetaItems {

    private static StandardMetaItem metaItem1;

    // Circuits
    // Gooware
    public static MetaItem<?>.MetaValueItem GOOWARE_PROCESSOR;
    public static MetaItem<?>.MetaValueItem GOOWARE_ASSEMBLY;
    public static MetaItem<?>.MetaValueItem GOOWARE_COMPUTER;
    public static MetaItem<?>.MetaValueItem GOOWARE_MAINFRAME;

    // Optical
    public static MetaItem<?>.MetaValueItem OPTICAL_PROCESSOR;
    public static MetaItem<?>.MetaValueItem OPTICAL_ASSEMBLY;
    public static MetaItem<?>.MetaValueItem OPTICAL_COMPUTER;
    public static MetaItem<?>.MetaValueItem OPTICAL_MAINFRAME;

    // Spintronic
    public static MetaItem<?>.MetaValueItem SPINTRONIC_PROCESSOR;
    public static MetaItem<?>.MetaValueItem SPINTRONIC_ASSEMBLY;
    public static MetaItem<?>.MetaValueItem SPINTRONIC_COMPUTER;
    public static MetaItem<?>.MetaValueItem SPINTRONIC_MAINFRAME;

    // Cosmic, name TBD
    public static MetaItem<?>.MetaValueItem COSMIC_PROCESSOR;
    public static MetaItem<?>.MetaValueItem COSMIC_ASSEMBLY;
    public static MetaItem<?>.MetaValueItem COSMIC_COMPUTER;
    public static MetaItem<?>.MetaValueItem COSMIC_MAINFRAME;

    // Supra-causal
    public static MetaItem<?>.MetaValueItem SUPRACAUSAL_PROCESSOR;
    public static MetaItem<?>.MetaValueItem SUPRACAUSAL_ASSEMBLY;
    public static MetaItem<?>.MetaValueItem SUPRACAUSAL_COMPUTER;
    public static MetaItem<?>.MetaValueItem SUPRACAUSAL_MAINFRAME;

    // Supra-chronal
    public static MetaItem<?>.MetaValueItem SUPRACHRONAL_ULV;
    public static MetaItem<?>.MetaValueItem SUPRACHRONAL_LV;
    public static MetaItem<?>.MetaValueItem SUPRACHRONAL_MV;
    public static MetaItem<?>.MetaValueItem SUPRACHRONAL_HV;
    public static MetaItem<?>.MetaValueItem SUPRACHRONAL_EV;
    public static MetaItem<?>.MetaValueItem SUPRACHRONAL_IV;
    public static MetaItem<?>.MetaValueItem SUPRACHRONAL_LuV;
    public static MetaItem<?>.MetaValueItem SUPRACHRONAL_ZPM;
    public static MetaItem<?>.MetaValueItem SUPRACHRONAL_UV;
    public static MetaItem<?>.MetaValueItem SUPRACHRONAL_UHV;
    public static MetaItem<?>.MetaValueItem SUPRACHRONAL_UEV;
    public static MetaItem<?>.MetaValueItem SUPRACHRONAL_UIV;
    public static MetaItem<?>.MetaValueItem SUPRACHRONAL_UXV;
    public static MetaItem<?>.MetaValueItem SUPRACHRONAL_OpV;
    public static MetaItem<?>.MetaValueItem SUPRACHRONAL_MAX;

    // Primitive Circuit Components
    public static MetaItem<?>.MetaValueItem VACUUM_TUBE_COMPONENTS;

    // Crystal Circuit Components
    public static MetaItem<?>.MetaValueItem EU_DOPED_CUBIC_ZIRCONIA_BOULE;
    public static MetaItem<?>.MetaValueItem EU_DOPED_CUBIC_ZIRCONIA_WAFER;
    public static MetaItem<?>.MetaValueItem CRYSTAL_INTERFACE_WAFER;
    public static MetaItem<?>.MetaValueItem CRYSTAL_INTERFACE_CHIP;
    public static MetaItem<?>.MetaValueItem ENGRAVED_RUBY_CRYSTAL_CHIP;
    public static MetaItem<?>.MetaValueItem ENGRAVED_SAPPHIRE_CRYSTAL_CHIP;
    public static MetaItem<?>.MetaValueItem ENGRAVED_DIAMOND_CRYSTAL_CHIP;
    public static MetaItem<?>.MetaValueItem CRYSTAL_MODULATOR_RUBY;
    public static MetaItem<?>.MetaValueItem CRYSTAL_MODULATOR_DIAMOND;
    public static MetaItem<?>.MetaValueItem CRYSTAL_MODULATOR_SAPPHIRE;
    public static MetaItem<?>.MetaValueItem CRYSTAL_SYSTEM_ON_CHIP_SOCKET;

    // Gooware Circuit Components
    public static MetaItem<?>.MetaValueItem BZ_REACTION_CHAMBER;
    public static MetaItem<?>.MetaValueItem NONLINEAR_CHEMICAL_OSCILLATOR;

    // Optical Circuit Components
    public static MetaItem<?>.MetaValueItem PHASE_CHANGE_MEMORY;
    public static MetaItem<?>.MetaValueItem OPTICAL_FIBER;
    public static MetaItem<?>.MetaValueItem DIELECTRIC_MIRROR;
    public static MetaItem<?>.MetaValueItem EMPTY_LASER_ASSEMBLY;
    public static MetaItem<?>.MetaValueItem HELIUM_NEON_LASER;
    public static MetaItem<?>.MetaValueItem ND_YAG_LASER;
    public static MetaItem<?>.MetaValueItem OPTICAL_LASER_CONTROL_UNIT;

    // Spintronic Circuit Components
    public static MetaItem<?>.MetaValueItem SPIN_TRANSFER_TORQUE_MEMORY;
    public static MetaItem<?>.MetaValueItem TOPOLOGICAL_INSULATOR_TUBE;
    public static MetaItem<?>.MetaValueItem BOSE_EINSTEIN_CONDENSATE_CONTAINMENT_UNIT;
    public static MetaItem<?>.MetaValueItem BOSE_EINSTEIN_CONDENSATE;
    public static MetaItem<?>.MetaValueItem ESR_COMPUTATION_UNIT;

    // Voltage Coils
    public static MetaItem<?>.MetaValueItem VOLTAGE_COIL_UHV;
    public static MetaItem<?>.MetaValueItem VOLTAGE_COIL_UEV;
    public static MetaItem<?>.MetaValueItem VOLTAGE_COIL_UIV;
    public static MetaItem<?>.MetaValueItem VOLTAGE_COIL_UXV;
    public static MetaItem<?>.MetaValueItem VOLTAGE_COIL_OpV;
    public static MetaItem<?>.MetaValueItem VOLTAGE_COIL_MAX;

    // Power Components
    public static MetaItem<?>.MetaValueItem NANO_POWER_IC_WAFER;
    public static MetaItem<?>.MetaValueItem PICO_POWER_IC_WAFER;
    public static MetaItem<?>.MetaValueItem FEMTO_POWER_IC_WAFER;
    public static MetaItem<?>.MetaValueItem NANO_POWER_IC;
    public static MetaItem<?>.MetaValueItem PICO_POWER_IC;
    public static MetaItem<?>.MetaValueItem FEMTO_POWER_IC;

    // Circuit Boards
    public static MetaItem<?>.MetaValueItem GOOWARE_BOARD;
    public static MetaItem<?>.MetaValueItem OPTICAL_BOARD;
    public static MetaItem<?>.MetaValueItem SPINTRONIC_BOARD;
    public static MetaItem<?>.MetaValueItem GOOWARE_CIRCUIT_BOARD;
    public static MetaItem<?>.MetaValueItem OPTICAL_CIRCUIT_BOARD;
    public static MetaItem<?>.MetaValueItem SPINTRONIC_CIRCUIT_BOARD;

    // SMDs
    public static MetaItem<?>.MetaValueItem OPTICAL_CAPACITOR;
    public static MetaItem<?>.MetaValueItem OPTICAL_DIODE;
    public static MetaItem<?>.MetaValueItem OPTICAL_RESISTOR;
    public static MetaItem<?>.MetaValueItem OPTICAL_TRANSISTOR;
    public static MetaItem<?>.MetaValueItem OPTICAL_INDUCTOR;
    public static MetaItem<?>.MetaValueItem SPINTRONIC_CAPACITOR;
    public static MetaItem<?>.MetaValueItem SPINTRONIC_DIODE;
    public static MetaItem<?>.MetaValueItem SPINTRONIC_RESISTOR;
    public static MetaItem<?>.MetaValueItem SPINTRONIC_TRANSISTOR;
    public static MetaItem<?>.MetaValueItem SPINTRONIC_INDUCTOR;

    // Crafting Components
    public static MetaItem<?>.MetaValueItem COMPONENT_GRINDER_BORON_NITRIDE;

    // Process-Specific Components
    public static MetaItem<?>.MetaValueItem MAGNETRON;

    // Process Intermediary Items
    // Nanotubes
    public static MetaItem<?>.MetaValueItem CARBON_ALLOTROPE_MIXTURE;
    public static MetaItem<?>.MetaValueItem GRAPHENE_ALIGNED_CNT;


    public static void initMetaItems() {
        metaItem1 = new StandardMetaItem();
        metaItem1.setRegistryName("meta_item_1");
    }

    public static void initSubitems() {
        initMetaItem1();
    }

    private static void initMetaItem1()  {
        // Circuits: ID 0-49
        GOOWARE_PROCESSOR = metaItem1.addItem(0, "circuit.gooware_processor").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.ZPM);
        GOOWARE_ASSEMBLY = metaItem1.addItem(1, "circuit.gooware_assembly").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UV);
        GOOWARE_COMPUTER = metaItem1.addItem(2, "circuit.gooware_computer").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UHV);
        GOOWARE_MAINFRAME = metaItem1.addItem(3, "circuit.gooware_mainframe").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UEV);

        OPTICAL_PROCESSOR = metaItem1.addItem(4,"circuit.optical_processor").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UV);
        OPTICAL_ASSEMBLY = metaItem1.addItem(5,"circuit.optical_assembly").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UHV);
        OPTICAL_COMPUTER = metaItem1.addItem(6,"circuit.optical_computer").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UEV);
        OPTICAL_MAINFRAME = metaItem1.addItem(7,"circuit.optical_mainframe").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UIV);

        SPINTRONIC_PROCESSOR = metaItem1.addItem(8, "circuit.spintronic_processor").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UHV);
        SPINTRONIC_ASSEMBLY = metaItem1.addItem(9, "circuit.spintronic_assembly").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UEV);
        SPINTRONIC_COMPUTER = metaItem1.addItem(10, "circuit.spintronic_computer").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UIV);
        SPINTRONIC_MAINFRAME = metaItem1.addItem(11, "circuit.spintronic_mainframe").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UXV);

        COSMIC_PROCESSOR = metaItem1.addItem(12, "circuit.cosmic_processor").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UEV);
        COSMIC_ASSEMBLY = metaItem1.addItem(13, "circuit.cosmic_assembly").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UIV);
        COSMIC_COMPUTER = metaItem1.addItem(14, "circuit.cosmic_computer").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UXV);
        COSMIC_MAINFRAME = metaItem1.addItem(15, "circuit.cosmic_mainframe").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.OpV);

        SUPRACAUSAL_PROCESSOR = metaItem1.addItem(16, "circuit.supracausal_processor").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UIV);
        SUPRACAUSAL_ASSEMBLY = metaItem1.addItem(17, "circuit.supracausal_assembly").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UXV);
        SUPRACAUSAL_COMPUTER = metaItem1.addItem(18, "circuit.supracausal_computer").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.OpV);
        SUPRACAUSAL_MAINFRAME = metaItem1.addItem(19, "circuit.supracausal_mainframe").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.MAX);

        SUPRACHRONAL_ULV = metaItem1.addItem(20, "circuit.suprachronal.ulv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.ULV);
        SUPRACHRONAL_LV = metaItem1.addItem(21, "circuit.suprachronal.lv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.LV);
        SUPRACHRONAL_MV = metaItem1.addItem(22, "circuit.suprachronal.mv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.MV);
        SUPRACHRONAL_HV = metaItem1.addItem(23, "circuit.suprachronal.hv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.HV);
        SUPRACHRONAL_EV = metaItem1.addItem(24, "circuit.suprachronal.ev").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.EV);
        SUPRACHRONAL_IV = metaItem1.addItem(25, "circuit.suprachronal.iv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.IV);
        SUPRACHRONAL_LuV = metaItem1.addItem(26, "circuit.suprachronal.luv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.LuV);
        SUPRACHRONAL_ZPM = metaItem1.addItem(27, "circuit.suprachronal.zpm").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.ZPM);
        SUPRACHRONAL_UV = metaItem1.addItem(28, "circuit.suprachronal.uv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UV);
        SUPRACHRONAL_UHV = metaItem1.addItem(29, "circuit.suprachronal.uhv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UHV);
        SUPRACHRONAL_UEV = metaItem1.addItem(30, "circuit.suprachronal.uev").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UEV);
        SUPRACHRONAL_UIV = metaItem1.addItem(31, "circuit.suprachronal.uiv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UIV);
        SUPRACHRONAL_UXV = metaItem1.addItem(32, "circuit.suprachronal.uxv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UXV);
        SUPRACHRONAL_OpV = metaItem1.addItem(33, "circuit.suprachronal.opv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.OpV);
        SUPRACHRONAL_MAX = metaItem1.addItem(34, "circuit.suprachronal.max").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.MAX);

        // Primitive Circuit Components: ID 50-59
        VACUUM_TUBE_COMPONENTS = metaItem1.addItem(51, "vacuum_tube.components").setInvisible(GCYSConfigHolder.circuitOverrides.harderVacuumTubes);

        // Electronic Circuit Components: ID 60-69


        // Micro Circuit Components: ID 70-89


        // Nano Circuit Components: ID 90-109


        // Quantum Circuit Components: ID 110-129


        // Crystal Circuit Components: ID 130-159
        EU_DOPED_CUBIC_ZIRCONIA_BOULE = metaItem1.addItem(130, "boule.cubic_zirconia.europium");
        EU_DOPED_CUBIC_ZIRCONIA_WAFER = metaItem1.addItem(131, "wafer.cubic_zirconia.europium");
        CRYSTAL_INTERFACE_WAFER = metaItem1.addItem(132, "wafer.crystal.interface");
        CRYSTAL_INTERFACE_CHIP = metaItem1.addItem(133, "plate.crystal.interface");
        ENGRAVED_RUBY_CRYSTAL_CHIP = metaItem1.addItem(134, "engraved.crystal_chip.ruby");
        ENGRAVED_SAPPHIRE_CRYSTAL_CHIP = metaItem1.addItem(135, "engraved.crystal_chip.sapphire");
        ENGRAVED_DIAMOND_CRYSTAL_CHIP = metaItem1.addItem(136, "engraved.crystal_chip.diamond");
        CRYSTAL_MODULATOR_RUBY = metaItem1.addItem(137, "crystal.modulator.ruby");
        CRYSTAL_MODULATOR_SAPPHIRE = metaItem1.addItem(138, "crystal.modulator.sapphire");
        CRYSTAL_MODULATOR_DIAMOND = metaItem1.addItem(139, "crystal.modulator.diamond");
        CRYSTAL_SYSTEM_ON_CHIP_SOCKET = metaItem1.addItem(140, "crystal.system_on_chip.socket");

        // Wetware Circuit Components: ID 160-179


        // Gooware Circuit Components: ID 180-199
        BZ_REACTION_CHAMBER = metaItem1.addItem(180, "reaction_chamber.bz");
        NONLINEAR_CHEMICAL_OSCILLATOR = metaItem1.addItem(181, "nonlinear_chemical_oscillator");

        // Optical Circuit Components: ID 200-219
        PHASE_CHANGE_MEMORY = metaItem1.addItem(200, "plate.phase_change_memory");
        OPTICAL_FIBER = metaItem1.addItem(201, "optical_fiber");
        DIELECTRIC_MIRROR = metaItem1.addItem(202, "dielectric_mirror");
        EMPTY_LASER_ASSEMBLY = metaItem1.addItem(203, "laser.assembly.empty");
        HELIUM_NEON_LASER = metaItem1.addItem(204, "laser.helium_neon");
        ND_YAG_LASER = metaItem1.addItem(205, "laser.nd_yag");
        OPTICAL_LASER_CONTROL_UNIT = metaItem1.addItem(206, "optical_laser_control_unit");

        // Spintronic Circuit Components: ID 220-239
        SPIN_TRANSFER_TORQUE_MEMORY = metaItem1.addItem(220, "plate.spin_transfer_torque_memory");
        TOPOLOGICAL_INSULATOR_TUBE = metaItem1.addItem(221, "tube.topological_insulator");
        BOSE_EINSTEIN_CONDENSATE_CONTAINMENT_UNIT = metaItem1.addItem(222, "containment_unit.bose_einstein_condensate");
        BOSE_EINSTEIN_CONDENSATE = metaItem1.addItem(223, "bose_einstein_condensate");
        ESR_COMPUTATION_UNIT = metaItem1.addItem(224, "esr_computation_unit");

        // Cosmic Circuit Components: ID 240-259


        // Supra-Causal Circuit Components: ID 260-299


        // Supra-Chronal Circuit Components: ID 300-349


        // Voltage Coils: ID 350-355
        VOLTAGE_COIL_UHV = metaItem1.addItem(350, "voltage_coil.uhv").setMaterialInfo(new ItemMaterialInfo(new MaterialStack(GCYSMaterials.MercuryCadmiumTelluride, M * 2), new MaterialStack(GCYSMaterials.ChromiumGermaniumTellurideMagnetic, M / 2)));
        VOLTAGE_COIL_UEV = metaItem1.addItem(351, "voltage_coil.uev").setMaterialInfo(new ItemMaterialInfo(new MaterialStack(GCYSMaterials.MercuryCadmiumTelluride, M * 2), new MaterialStack(GCYSMaterials.ChromiumGermaniumTellurideMagnetic, M / 2)));
        VOLTAGE_COIL_UIV = metaItem1.addItem(352, "voltage_coil.uiv").setMaterialInfo(new ItemMaterialInfo(new MaterialStack(GCYSMaterials.MercuryCadmiumTelluride, M * 2), new MaterialStack(GCYSMaterials.ChromiumGermaniumTellurideMagnetic, M / 2)));
        VOLTAGE_COIL_UXV = metaItem1.addItem(353, "voltage_coil.uxv").setMaterialInfo(new ItemMaterialInfo(new MaterialStack(GCYSMaterials.MercuryCadmiumTelluride, M * 2), new MaterialStack(GCYSMaterials.ChromiumGermaniumTellurideMagnetic, M / 2)));
        VOLTAGE_COIL_OpV = metaItem1.addItem(354, "voltage_coil.opv").setMaterialInfo(new ItemMaterialInfo(new MaterialStack(GCYSMaterials.MercuryCadmiumTelluride, M * 2), new MaterialStack(GCYSMaterials.ChromiumGermaniumTellurideMagnetic, M / 2)));
        VOLTAGE_COIL_MAX = metaItem1.addItem(355, "voltage_coil.max").setMaterialInfo(new ItemMaterialInfo(new MaterialStack(GCYSMaterials.MercuryCadmiumTelluride, M * 2), new MaterialStack(GCYSMaterials.ChromiumGermaniumTellurideMagnetic, M / 2)));

        // Power Components: ID 356-379
        NANO_POWER_IC_WAFER = metaItem1.addItem(356, "wafer.nano_power_integrated_circuit");
        PICO_POWER_IC_WAFER = metaItem1.addItem(357, "wafer.pico_power_integrated_circuit");
        FEMTO_POWER_IC_WAFER = metaItem1.addItem(358, "wafer.femto_power_integrated_circuit");
        NANO_POWER_IC = metaItem1.addItem(368, "plate.nano_power_integrated_circuit");
        PICO_POWER_IC = metaItem1.addItem(369, "plate.pico_power_integrated_circuit");
        FEMTO_POWER_IC = metaItem1.addItem(370, "plate.femto_power_integrated_circuit");

        // Circuit Boards: ID 380-419
        GOOWARE_BOARD = metaItem1.addItem(380, "board.gooware");
        OPTICAL_BOARD = metaItem1.addItem(381, "board.optical");
        SPINTRONIC_BOARD = metaItem1.addItem(382, "board.spintronic");
        GOOWARE_CIRCUIT_BOARD = metaItem1.addItem(400, "circuit_board.gooware");
        OPTICAL_CIRCUIT_BOARD = metaItem1.addItem(401, "circuit_board.optical");
        SPINTRONIC_CIRCUIT_BOARD = metaItem1.addItem(402, "circuit_board.spintronic");

        // SMDs: ID 420-479
        OPTICAL_CAPACITOR = metaItem1.addItem(420, "component.optical_smd.capacitor");
        OPTICAL_DIODE = metaItem1.addItem(421, "component.optical_smd.diode");
        OPTICAL_RESISTOR = metaItem1.addItem(422, "component.optical_smd.resistor");
        OPTICAL_TRANSISTOR = metaItem1.addItem(423, "component.optical_smd.transistor");
        OPTICAL_INDUCTOR = metaItem1.addItem(424, "component.optical_smd.inductor");

        SPINTRONIC_CAPACITOR = metaItem1.addItem(425, "component.spintronic_smd.capacitor");
        SPINTRONIC_DIODE = metaItem1.addItem(426, "component.spintronic_smd.diode");
        SPINTRONIC_RESISTOR = metaItem1.addItem(427, "component.spintronic_smd.resistor");
        SPINTRONIC_TRANSISTOR = metaItem1.addItem(428, "component.spintronic_smd.transistor");
        SPINTRONIC_INDUCTOR = metaItem1.addItem(429, "component.spintronic_smd.inductor");

        // Simple Machine Crafting Components: ID 480-499
        COMPONENT_GRINDER_BORON_NITRIDE = metaItem1.addItem(480, "component.grinder.boron_nitride")
                .setMaterialInfo(new ItemMaterialInfo(new MaterialStack(GCYSMaterials.CubicBoronNitride, M * 4), new MaterialStack(GCYSMaterials.Vibranium, M * 8), new MaterialStack(GCYSMaterials.CubicHeterodiamond, M)));

        // Process-Specific Components: ID 500-999
        MAGNETRON = metaItem1.addItem(500, "magnetron");

        // Process Intermediary Items: ID 1000-1999
        CARBON_ALLOTROPE_MIXTURE = metaItem1.addItem(1000, "mixture.carbon_allotrope");
        GRAPHENE_ALIGNED_CNT = metaItem1.addItem(1001, "cnt.graphene_aligned");
    }
}
