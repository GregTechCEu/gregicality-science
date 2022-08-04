package gregicality.science.api.unification.materials;

import gregicality.science.api.unification.GCYSElements;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.properties.BlastProperty;

import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregtech.api.unification.material.info.MaterialFlags.GENERATE_FOIL;
import static gregtech.api.unification.material.info.MaterialFlags.GENERATE_PLATE;
import static gregtech.api.unification.material.info.MaterialIconSet.METALLIC;
import static gregtech.api.unification.material.info.MaterialIconSet.SHINY;

public class GCYSElementMaterials {

    /**
     * 3100-3499
     */
    public static void init() {
        Lithium6 = new Material.Builder(3100, "lithium_6")
                .ingot()
                .color(0xE6E1FF)
                .flags(GENERATE_PLATE, GENERATE_FOIL)
                .element(GCYSElements.Li6)
                .build();

        Lithium7 = new Material.Builder(3101, "lithium_7")
                .ingot()
                .color(0xE1DCFF).iconSet(METALLIC)
                .element(GCYSElements.Li7)
                .build();

        Beryllium7 = new Material.Builder(3102, "beryllium_7")
                .ingot().fluid()
                .color(0x6EBE6E)
                .element(GCYSElements.Be7)
                .build();

        Orichalcum = new Material.Builder(3103, "orichalcum")
                .ingot().fluid()
                .color(0x547A38).iconSet(METALLIC)
                .element(GCYSElements.Or)
                .blastTemp(9000, BlastProperty.GasTier.HIGH)
                .build();

        Vibranium = new Material.Builder(3104, "vibranium")
                .ingot().fluid().plasma()
                .color(0xC880FF).iconSet(SHINY)
                .element(GCYSElements.Vb)
                .blastTemp(4852, BlastProperty.GasTier.HIGH)
                .build();

        Adamantium = new Material.Builder(3105, "adamantium")
                .ingot().fluid().plasma()
                .color(0xFF0040).iconSet(METALLIC)
                .element(GCYSElements.Ad)
                .blastTemp(5225, BlastProperty.GasTier.HIGH)
                .build();

        Taranium = new Material.Builder(3106, "taranium")
                .dust()
                .color(0x4F404F).iconSet(METALLIC)
                .element(GCYSElements.Tn)
                .build();
    }
}
