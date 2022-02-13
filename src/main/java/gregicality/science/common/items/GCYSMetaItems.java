package gregicality.science.common.items;

import gregtech.api.items.metaitem.MetaItem;

public class GCYSMetaItems {


    public static MetaItem<?>.MetaValueItem MAGNETRON;

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

    public static MetaItem<?>.MetaValueItem ULTRASONIC_HOMOGENZIER;
    public static MetaItem<?>.MetaValueItem STERILE_PETRI_DISH;
    public static MetaItem<?>.MetaValueItem CUPRIAVIDUS_NECATOR;
    public static MetaItem<?>.MetaValueItem BREVIBACTERIUM_FLAVUM;


    public static void init() {
        GCYSMetaItem1 metaItem1 = new GCYSMetaItem1();
        metaItem1.setRegistryName("meta_item_1");
    }
}
