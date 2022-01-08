package gregicality.science.api.unification.materials;

import gregtech.api.unification.material.Material;

import static gregicality.science.api.unification.materials.GCYSMaterials.RareEarthChloridesSolution;
import static gregtech.api.unification.material.Materials.Chlorine;
import static gregtech.api.unification.material.Materials.RareEarth;
import static gregtech.api.unification.material.info.MaterialFlags.DISABLE_DECOMPOSITION;

public class GCYSUnknownCompositionMaterials {

    /**
     * 18000-19999
     */
    public static void init() {

        RareEarthChloridesSolution = new Material.Builder(18000, "rare_earth_chlorides_solution")
                .fluid()
                .color(0x838367)
                .flags(DISABLE_DECOMPOSITION)
                .components(RareEarth, 1, Chlorine, 1)
                .build();

    }
}
