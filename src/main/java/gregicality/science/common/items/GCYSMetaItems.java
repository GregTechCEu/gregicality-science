package gregicality.science.common.items;

import gregtech.api.items.metaitem.MetaItem;

public class GCYSMetaItems {


    public static MetaItem<?>.MetaValueItem MAGNETRON;

    // Circuits
    public static MetaItem<?>.MetaValueItem GOOWARE_PROCESSOR;
    public static MetaItem<?>.MetaValueItem GOOWARE_ASSEMBLY;
    public static MetaItem<?>.MetaValueItem GOOWARE_COMPUTER;
    public static MetaItem<?>.MetaValueItem GOOWARE_MAINFRAME;

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
    public static MetaItem<?>.MetaValueItem GOOWARE_BOARD;
    public static MetaItem<?>.MetaValueItem GOOWARE_CIRCUIT_BOARD;

    // Processing Units
    public static MetaItem<?>.MetaValueItem BZ_REACTION_CHAMBER;
    public static MetaItem<?>.MetaValueItem NONLINEAR_CHEMICAL_OSCILLATOR;

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

    // Gooware Stuff

    public static void init() {
        GCYSMetaItem1 metaItem1 = new GCYSMetaItem1();
        metaItem1.setRegistryName("meta_item_1");

        // Modifying CEu MetaItems
        // TODO
//        MetaItems.STEM_CELLS.addComponents(new HeldItemDestroyBehavior(MetaItems.FERTILIZER));
    }
}
