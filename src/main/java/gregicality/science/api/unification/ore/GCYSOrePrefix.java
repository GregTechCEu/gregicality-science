package gregicality.science.api.unification.ore;

import gregicality.science.api.unification.material.info.GCYSMaterialFlags;
import gregicality.science.api.unification.material.info.GCYSMaterialIconType;
import gregtech.api.unification.material.info.MaterialFlags;
import gregtech.api.unification.ore.OrePrefix;

import static gregicality.science.api.unification.material.info.GCYSMaterialFlags.GENERATE_BOULE;
import static gregtech.api.GTValues.M;
import static gregtech.api.unification.ore.OrePrefix.Conditions.hasGemProperty;
import static gregtech.api.unification.ore.OrePrefix.Flags.ENABLE_UNIFICATION;

public class GCYSOrePrefix {

    public static final OrePrefix seedCrystal = new OrePrefix("seedCrystal", M / 9, null, GCYSMaterialIconType.seedCrystal, ENABLE_UNIFICATION, hasGemProperty.and(mat -> mat.hasFlag(GENERATE_BOULE) || (mat.hasFlag(MaterialFlags.CRYSTALLIZABLE) && !mat.hasFlag(GCYSMaterialFlags.DISABLE_CRYSTALLIZATION))));
    public static final OrePrefix boule = new OrePrefix("boule", M * 4, null, GCYSMaterialIconType.boule, ENABLE_UNIFICATION, hasGemProperty.and(mat -> mat.hasFlag(GENERATE_BOULE) || (mat.hasFlag(MaterialFlags.CRYSTALLIZABLE) && !mat.hasFlag(GCYSMaterialFlags.DISABLE_CRYSTALLIZATION))));
}
