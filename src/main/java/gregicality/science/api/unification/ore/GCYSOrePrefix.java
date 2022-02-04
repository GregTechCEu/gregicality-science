package gregicality.science.api.unification.ore;

import gregtech.api.unification.material.info.MaterialIconType;
import gregtech.api.unification.material.info.MaterialFlags;
import gregicality.science.api.unification.material.info.GCYSMaterialIconType;
import gregtech.api.unification.ore.OrePrefix;

import static gregtech.api.GTValues.M;
import static gregtech.api.unification.ore.OrePrefix.Conditions.*;
import static gregtech.api.unification.ore.OrePrefix.Flags.ENABLE_UNIFICATION;

public class GCYSOrePrefix {
    public static final OrePrefix boule = new OrePrefix("boule", M, null, GCYSMaterialIconType.boule, ENABLE_UNIFICATION, hasGemProperty.and(mat -> mat.hasFlag(MaterialFlags.CRYSTALLIZABLE)));
}
