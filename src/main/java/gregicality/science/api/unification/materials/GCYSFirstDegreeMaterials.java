package gregicality.science.api.unification.materials;

import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialIconSet;

import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.DISABLE_DECOMPOSITION;

public class GCYSFirstDegreeMaterials {

    /**
     * 3500-5999
     */
    public static void init() {

        LanthanumOxide = new Material.Builder(3500, "lanthanum_oxide")
                .dust()
                .color(0x5F7777)
                .iconSet(MaterialIconSet.SHINY)
                .components(Lanthanum, 2, Oxygen, 3)
                .build();

        PraseodymiumOxide = new Material.Builder(3501, "praseodymium_oxide")
                .dust()
                .color(0xD0D0D0)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Praseodymium, 2, Oxygen, 3)
                .build();

        NeodymiumOxide = new Material.Builder(3502, "neodymium_oxide")
                .dust()
                .color(0x868686)
                .components(Neodymium, 2, Oxygen, 3)
                .build();

        CeriumOxide = new Material.Builder(3503, "cerium_oxide")
                .dust()
                .color(0x10937F)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Cerium, 1, Oxygen, 2)
                .build();

        ScandiumOxide = new Material.Builder(3504, "scandium_oxide")
                .dust()
                .color(0x43964F)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Scandium, 2, Oxygen, 3)
                .build();

        EuropiumOxide = new Material.Builder(3505, "europium_oxide")
                .dust()
                .color(0x20AAAA)
                .iconSet(MaterialIconSet.SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Europium, 2, Oxygen, 3)
                .build();

        GadoliniumOxide = new Material.Builder(3506, "gadolinium_oxide")
                .dust()
                .color(0xEEEEFF)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Gadolinium, 2, Oxygen, 3)
                .build();

        SamariumOxide = new Material.Builder(3507, "samarium_oxide")
                .dust()
                .color(0xFFFFDD)
                .components(Samarium, 2, Oxygen, 3)
                .build();

        YttriumOxide = new Material.Builder(3508, "yttrium_oxide")
                .dust()
                .color(0x78544E)
                .iconSet(MaterialIconSet.SHINY)
                .components(Yttrium, 2, Oxygen, 3)
                .build();

        TerbiumOxide = new Material.Builder(3509, "terbium_oxide")
                .dust()
                .color(0xA264A2)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Terbium, 2, Oxygen, 3)
                .build();

        DysprosiumOxide = new Material.Builder(3510, "dysprosium_oxide")
                .dust()
                .color(0xD273D2)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Dysprosium, 2, Oxygen, 3)
                .build();

        HolmiumOxide = new Material.Builder(3511, "holmium_oxide")
                .dust()
                .color(0xAF7F2A)
                .iconSet(MaterialIconSet.SHINY)
                .components(Holmium, 2, Oxygen, 3)
                .build();

        ErbiumOxide = new Material.Builder(3512, "erbium_oxide")
                .dust()
                .color(0xE07A32)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Erbium, 2, Oxygen, 3)
                .build();

        ThuliumOxide = new Material.Builder(3513, "thulium_oxide")
                .dust()
                .color(0x3B9E8B)
                .components(Thulium, 2, Oxygen, 3)
                .build();

        YtterbiumOxide = new Material.Builder(3514, "ytterbium_oxide")
                .dust()
                .color(0xA9A9A9)
                .components(Ytterbium, 2, Oxygen, 3)
                .build();

        LutetiumOxide = new Material.Builder(3515, "lutetium_oxide")
                .dust()
                .color(0x11BBFF)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Lutetium, 2, Oxygen, 3)
                .build();
    }
}
