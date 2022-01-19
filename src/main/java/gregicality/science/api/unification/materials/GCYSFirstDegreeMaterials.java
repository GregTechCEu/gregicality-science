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

        PlatinumMetallic = new Material.Builder(3516, "platinum_metallic")
                .dust()
                .color(0xFFFBC5)
                .flags(DISABLE_DECOMPOSITION)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Platinum, 1, RareEarth, 1)
                .build();

        PalladiumMetallic = new Material.Builder(3517, "palladium_metallic")
                .dust()
                .color(0x808080)
                .flags(DISABLE_DECOMPOSITION)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Platinum, 1, RareEarth, 1)
                .build();

        AmmoniumHexachloroplatinate = new Material.Builder(3518, "ammonium_hexachloroplatinate")
                .dust()
                .color(0xFEF0C2)
                .flags(DISABLE_DECOMPOSITION)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Nitrogen, 2, Hydrogen, 8, Platinum, 1, Chlorine, 6)
                .build()
                .setFormula("(NH4)2PtCl6", true);

        ChloroplatinicAcid = new Material.Builder(3519, "chloroplatinic_acid")
                .fluid()
                .color(0xFEF0C2)
                .flags(DISABLE_DECOMPOSITION)
                .components(Hydrogen, 2, Platinum, 1, Chlorine, 6)
                .build();

        PotassiumBisulfate = new Material.Builder(3520, "potassium_bisulfate")
                .dust()
                .color(0xFDBD68)
                .components(Potassium, 1, Hydrogen, 1, Sulfur, 1, Oxygen, 4)
                .build();

        PotassiumPyrosulfate = new Material.Builder(3521, "potassium_pyrosulfate")
                .dust()
                .color(0xFBBB66)
                .iconSet(MaterialIconSet.SHINY)
                .components(Potassium, 2, Sulfur, 2, Oxygen, 7)
                .build();

        PotassiumSulfate = new Material.Builder(3522, "potassium_sulfate")
                .dust()
                .color(0xF0B064)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Potassium, 2, Sulfur, 1, Oxygen, 4)
                .build();

        ZincSulfate = new Material.Builder(3523, "zinc_sulfate")
                .dust()
                .color(0x846649)
                .iconSet(MaterialIconSet.FINE)
                .components(Zinc, 1, Sulfur, 1, Oxygen, 4)
                .build();

        SodiumNitrate = new Material.Builder(3524, "sodium_nitrate")
                .dust()
                .color(0x846684)
                .iconSet(MaterialIconSet.ROUGH)
                .components(Sodium, 1, Nitrogen, 3, Oxygen, 9)
                .build()
                .setFormula("Na(NO3)3", true);

        RhodiumNitrate = new Material.Builder(3525, "rhodium_nitrate")
                .dust()
                .color(0x776649)
                .iconSet(MaterialIconSet.FINE)
                .flags(DISABLE_DECOMPOSITION)
                .components(Rhodium, 1, Nitrogen, 3, Oxygen, 9)
                .build()
                .setFormula("Rh(NO3)3", true);

        SodiumRuthenate = new Material.Builder(3526, "sodium_ruthenate")
                .dust()
                .color(0x3A40CB)
                .iconSet(MaterialIconSet.SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Sodium, 2, Ruthenium, 1, Oxygen, 4)
                .build();

        SodiumPeroxide = new Material.Builder(3527, "sodium_peroxide")
                .dust()
                .color(0xECFF80)
                .iconSet(MaterialIconSet.ROUGH)
                .components(Sodium, 2, Oxygen, 2)
                .build();

        IridiumDioxideResidue = new Material.Builder(3528, "iridium_dioxide_residue")
                .dust()
                .color(0x17182E)
                .iconSet(MaterialIconSet.ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Iridium, 1, Oxygen, 2, RareEarth, 1)
                .build();

        AmmoniumHexachloroIridiate = new Material.Builder(3529, "ammonium_hexachloroiridiate")
                .dust()
                .color(0x644629)
                .iconSet(MaterialIconSet.ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Nitrogen, 2, Hydrogen, 8, Iridium, 1, Chlorine, 6)
                .build()
                .setFormula("(NH4)2IrCl6", true);
    }
}
