package gregicality.science.api.material;

import gregtech.api.unification.material.Material;

import static gregicality.science.api.GCYSMaterials.*;
import static gregicality.science.api.material.GAMaterialFlags.GA_CORE_METAL;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialIconSet.SHINY;

public class GAElementMaterials {

    /*
     * IDs 3000-3499
     */
    public static void register() {


        Helium4 = new Material.Builder(3057, "helium4")
                .fluid(Material.FluidType.GAS)
                .color(0xDDDD22)
                .element(GAElements.He4)
                .build();

        Carbon12 = new Material.Builder(3058, "carbon_12")
                .fluid()
                .color(0x242424)
                .element(GAElements.C12)
                .build();

        Carbon13 = new Material.Builder(3059, "carbon_13")
                .fluid()
                .color(0x151515)
                .element(GAElements.C13)
                .build();

        Nitrogen14 = new Material.Builder(3060, "nitrogen_14")
                .fluid()
                .color(0x00BFC1)
                .element(GAElements.N14)
                .build();

        Nitrogen15 = new Material.Builder(3061, "nitrogen_15")
                .fluid()
                .color(0x00CFD1)
                .element(GAElements.N15)
                .build();

        Calcium44 = new Material.Builder(3062, "calcium_44")
                .fluid()
                .color(0xFFF6F6)
                .element(GAElements.Ca44)
                .build();

        Ytterbium178 = new Material.Builder(3063, "ytterbium_178")
                .fluid()
                .color(0xA8A8A8)
                .element(GAElements.Yb178)
                .build();

        Chromium48 = new Material.Builder(3064, "chromium_48")
                .fluid().plasma()
                .color(0xFFE7E7)
                .element(GAElements.Cr48)
                .build();

        Iron52 = new Material.Builder(3065, "iron_52")
                .fluid().plasma()
                .color(0xC9C9C9)
                .element(GAElements.Fe52)
                .build();

        Nickel56 = new Material.Builder(3066, "nickel_56")
                .fluid().plasma()
                .color(0xC9C9FB)
                .element(GAElements.Ni56)
                .build();

        Titanium44 = new Material.Builder(3067, "titanium_44")
                .fluid().plasma()
                .color(0xC9C9FB)
                .element(GAElements.Ti44)
                .build();

        Titanium50 = new Material.Builder(3068, "titanium_50")
                .fluid()
                .color(0xDDA1F1)
                .element(GAElements.Ti50)
                .build();

        //todo nuclear rework
//        RadioactiveMaterial ThoriumRadioactive = new RadioactiveMaterial(Thorium);
//        Protactinium = new RadioactiveMaterial(824, "protactinium", 0xA78B6D, METALLIC, 3, of(), GA_EXT2_METAL, Pa, 0, 0, 0, 0);
//        UraniumRadioactive = new RadioactiveMaterial(822, "uranium_radioactive", Uranium.materialRGB, METALLIC, 3, of(), GA_EXT2_METAL | GENERATE_ORE, U, 0, 0, 0, 0);
//        Neptunium = new RadioactiveMaterial(818, "neptunium", 0x284D7B, METALLIC, 3, of(), GA_EXT2_METAL, Np, 0, 0, 0, 0);
//        PlutoniumRadioactive = new RadioactiveMaterial(814, "plutonium_radioactive", Plutonium.materialRGB, METALLIC, 3, of(), GA_EXT2_METAL, Pu, 0, 0, 0, 0);
//        RadioactiveMaterial AmericiumRadioactive = new RadioactiveMaterial(Americium);
//        Curium = new RadioactiveMaterial(807, "curium", 0x7B544E, METALLIC, 3, of(), GA_EXT2_METAL, Cm, 0, 0, 0, 0);
//        Berkelium = new RadioactiveMaterial(801, "berkelium", 0x645A88, METALLIC, 3, of(), GA_EXT2_METAL, Bk, 0, 0, 0, 0);
//        Californium = new RadioactiveMaterial(797, "californium", 0xA85A12, METALLIC, 3, of(), GA_EXT2_METAL, Cf, 0, 0, 0, 0);
//        Einsteinium = new RadioactiveMaterial(791, "einsteinium", 0xCE9F00, METALLIC, 3, of(), GA_EXT2_METAL, Es, 0, 0, 0, 0);
//        Fermium = new RadioactiveMaterial(786, "fermium", 0x984ACF, METALLIC, 3, of(), GA_EXT2_METAL, Fm, 0, 0, 0, 0);
//        Mendelevium = new RadioactiveMaterial(780, "mendelevium", 0x1D4ACF, METALLIC, 3, of(), GA_EXT2_METAL, Md, 0, 0, 0, 0);

        // Thorium

        // Protactinium

        // Uranium

        // Neptunium

        // Plutonium

        // Americium
        Americium241 = new Material.Builder(3031, "americium_241")
                .ingot().fluid()
                .color(0xC9C9C9)
                .element(GAElements.Am241)
                .build();

        Americium243 = new Material.Builder(3032, "americium_243")
                .ingot().fluid()
                .color(0xD0D0D0)
                .element(GAElements.Am243)
                .build();

        // Curium

        Curium247 = new Material.Builder(3036, "curium_247")
                .ingot().fluid()
                .color(0x7D5650)
                .element(GAElements.Cm247)
                .build();

        Curium250 = new Material.Builder(3037, "curium_250")
                .ingot().fluid()
                .color(0x7E5751)
                .element(GAElements.Cm250)
                .build();

        // Berkelium

        // Californium

        Californium252 = new Material.Builder(3043, "californium_252")
                .ingot().fluid()
                .color(0xAA5C14)
                .element(GAElements.Cf252)
                .build();

        // Einsteinium

        Einsteinium255 = new Material.Builder(3048, "einsteinium_255")
                .ingot().fluid()
                .color(0xD0A102)
                .element(GAElements.Es255)
                .build();

        // Fermium

        Fermium258 = new Material.Builder(3051, "fermium_258")
                .ingot().fluid()
                .color(0xA04CD1)
                .element(GAElements.Fm258)
                .build();

        // Mendelevium

        Mendelevium261 = new Material.Builder(3056, "mendelevium_261")
                .ingot().fluid()
                .color(0x1F4CD1)
                .element(GAElements.Md261)
                .build();

        // MetaStables
        MetastableOganesson = new Material.Builder(3098, "metastable_oganesson")
                .ingot(7).fluid()
                .color(0xE61C24).iconSet(SHINY)
                .flags(GA_CORE_METAL)
                .components(Oganesson, 1)
                .blastTemp(10380)
                .build();

        MetastableFlerovium = new Material.Builder(3099, "metastable_flerovium")
                .ingot(7).fluid()
                .color(0x521973).iconSet(SHINY)
                .flags(GA_CORE_METAL)
                .components(Flerovium, 1)
                .blastTemp(10990)
                .build();

        MetastableHassium = new Material.Builder(3100, "metastable_hassium")
                .ingot(6).fluid()
                .color(0x2D3A9D).iconSet(SHINY)
                .flags(GA_CORE_METAL)
                .components(Hassium, 1)
                .blastTemp(11240)
                .build();
    }
}
