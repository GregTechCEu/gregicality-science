package gregicality.science.api.unification.materials;

import gregtech.api.unification.material.Material;

import static gregicality.science.api.unification.materials.GCYSMaterials.PlatinumPalladiumLeachate;
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
    }
}
