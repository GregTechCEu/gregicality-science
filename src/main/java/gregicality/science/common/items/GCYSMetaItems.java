package gregicality.science.common.items;

import gregtech.api.items.metaitem.MetaItem;

public class GCYSMetaItems {


    public static MetaItem<?>.MetaValueItem MAGNETRON;

    // Circuits
    public static MetaItem<?>.MetaValueItem BIOWARE_PROCESSOR;
    public static MetaItem<?>.MetaValueItem BIOWARE_ASSEMBLY;
    public static MetaItem<?>.MetaValueItem BIOWARE_COMPUTER;
    public static MetaItem<?>.MetaValueItem BIOWARE_MAINFRAME;

    public static MetaItem<?>.MetaValueItem OPTICAL_PROCESSOR;
    public static MetaItem<?>.MetaValueItem OPTICAL_ASSEMBLY;
    public static MetaItem<?>.MetaValueItem OPTICAL_COMPUTER;
    public static MetaItem<?>.MetaValueItem OPTICAL_MAINFRAME;

    public static MetaItem<?>.MetaValueItem EXOTIC_PROCESSOR;
    public static MetaItem<?>.MetaValueItem EXOTIC_ASSEMBLY;
    public static MetaItem<?>.MetaValueItem EXOTIC_COMPUTER;
    public static MetaItem<?>.MetaValueItem EXOTIC_MAINFRAME;

    public static MetaItem<?>.MetaValueItem COSMIC_PROCESSOR;
    public static MetaItem<?>.MetaValueItem COSMIC_ASSEMBLY;
    public static MetaItem<?>.MetaValueItem COSMIC_COMPUTER;
    public static MetaItem<?>.MetaValueItem COSMIC_MAINFRAME;

    public static MetaItem<?>.MetaValueItem SUPRACAUSAL_PROCESSOR;
    public static MetaItem<?>.MetaValueItem SUPRACAUSAL_ASSEMBLY;
    public static MetaItem<?>.MetaValueItem SUPRACAUSAL_COMPUTER;
    public static MetaItem<?>.MetaValueItem SUPRACAUSAL_MAINFRAME;

    // Circuit Boards
    public static MetaItem<?>.MetaValueItem BIOWARE_BOARD;
    public static MetaItem<?>.MetaValueItem BIOWARE_CIRCUIT_BOARD;

    // Processing Units
    public static MetaItem<?>.MetaValueItem SENTIENT_PROCESSOR;

    // SMDS
    public static MetaItem<?>.MetaValueItem INSANE_SMD_CAPACITOR;
    public static MetaItem<?>.MetaValueItem INSANE_SMD_DIODE;
    public static MetaItem<?>.MetaValueItem INSANE_SMD_RESISTOR;
    public static MetaItem<?>.MetaValueItem INSANE_SMD_TRANSISTOR;
    public static MetaItem<?>.MetaValueItem INSANE_SMD_INDUCTOR;

    // Crystal Stuff
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

    // Bioware stuff
    public static MetaItem<?>.MetaValueItem ULTRASONIC_HOMOGENZIER;
    public static MetaItem<?>.MetaValueItem STERILE_PETRI_DISH;
    public static MetaItem<?>.MetaValueItem CLEAN_CULTURE;
    public static MetaItem<?>.MetaValueItem CUPRIAVIDUS_NECATOR;
    public static MetaItem<?>.MetaValueItem BREVIBACTERIUM_FLAVUM;
    public static MetaItem<?>.MetaValueItem RAPIDLY_REPLICATING_CELLS;
    public static MetaItem<?>.MetaValueItem SUPERINTELLIGENT_ORGANISM;

    public static void init() {
        GCYSMetaItem1 metaItem1 = new GCYSMetaItem1();
        metaItem1.setRegistryName("meta_item_1");

        // Modifying CEu MetaItems
        // TODO
//        MetaItems.STEM_CELLS.addComponents(new HeldItemDestroyBehavior(MetaItems.FERTILIZER));
    }
}
