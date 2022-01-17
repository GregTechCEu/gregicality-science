package gregicality.science.api.unification.materials;

import gregtech.api.unification.material.Material;

import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.DISABLE_DECOMPOSITION;

public class GCYSThirdDegreeMaterials {

    public static void init() {
        PlatinumPalladiumLeachate = new Material.Builder(9000, "platinum_palladium_leachate")
                .fluid()
                .color(0xFFFFC5)
                .flags(DISABLE_DECOMPOSITION)
                .components(Platinum, 1, Palladium, 1, AquaRegia, 1)
                .build();

        RhodiumSaltSolution = new Material.Builder(9001, "rhodium_salt_solution")
                .fluid()
                .color(0x667788)
                .flags(DISABLE_DECOMPOSITION)
                .components(RhodiumSalt, 1, Water, 1)
                .build()
                .setFormula("(NaCl)2(RhCl3)2(H2O)", true);
    }
}
