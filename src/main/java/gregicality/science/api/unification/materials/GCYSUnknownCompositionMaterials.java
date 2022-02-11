package gregicality.science.api.unification.materials;

import gregtech.api.unification.material.Material;

import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.DISABLE_DECOMPOSITION;

public class GCYSUnknownCompositionMaterials {

    /**
     * 18000-19999
     */
    public static void init() {

        RareEarthHydroxidesSolution = new Material.Builder(18000, "rare_earth_hydroxides_solution")
                .fluid()
                .color(0x434327)
                .flags(DISABLE_DECOMPOSITION)
                .components(RareEarth, 1, Oxygen, 1, Hydrogen, 1, Water, 1)
                .build();

        RareEarthChloridesSolution = new Material.Builder(18001, "rare_earth_chlorides_solution")
                .fluid()
                .color(0x838367)
                .flags(DISABLE_DECOMPOSITION)
                .components(RareEarth, 1, Chlorine, 1, Water, 1)
                .build();

        LeachedTurpentine = new Material.Builder(18002, "leached_turpentine")
                .fluid()
                .color(0x330D16)
                .flags(DISABLE_DECOMPOSITION)
                .components(Turpentine, 1, RareEarth, 1)
                .build();

        SteamCrackedTurpentine = new Material.Builder(18003, "steamcracked_turpentine").fluid().color(0x634D56).build();
    }
}
