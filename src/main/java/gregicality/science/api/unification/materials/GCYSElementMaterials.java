package gregicality.science.api.unification.materials;

import gregicality.science.api.unification.GCYSElements;
import gregtech.api.unification.material.Material;

import static gregicality.science.api.unification.materials.GCYSMaterials.Lithium6;
import static gregicality.science.api.unification.materials.GCYSMaterials.Lithium7;
import static gregtech.api.unification.material.info.MaterialFlags.GENERATE_FOIL;
import static gregtech.api.unification.material.info.MaterialFlags.GENERATE_PLATE;
import static gregtech.api.unification.material.info.MaterialIconSet.METALLIC;

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
    }
}
