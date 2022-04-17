package gregicality.science.api.unification.ore;

import gregicality.science.api.unification.material.info.GCYSMaterialFlags;
import gregicality.science.api.unification.material.info.GCYSMaterialIconType;
import gregtech.api.unification.material.info.MaterialFlags;
import gregtech.api.unification.material.properties.PropertyKey;
import gregtech.api.unification.ore.OrePrefix;

import static gregtech.api.GTValues.M;
import static gregtech.api.unification.ore.OrePrefix.Conditions.hasGemProperty;
import static gregtech.api.unification.ore.OrePrefix.Conditions.hasIngotProperty;
import static gregtech.api.unification.ore.OrePrefix.Flags.ENABLE_UNIFICATION;

public class GCYSOrePrefix {

    public static final OrePrefix seedCrystal = new OrePrefix("seedCrystal", M / 9, null, GCYSMaterialIconType.seedCrystal, ENABLE_UNIFICATION, hasGemProperty.and(mat -> mat.hasFlag(MaterialFlags.CRYSTALLIZABLE) && !mat.hasFlag(GCYSMaterialFlags.DISABLE_CRYSTALLIZATION)));
    public static final OrePrefix boule = new OrePrefix("boule", M * 4, null, GCYSMaterialIconType.boule, ENABLE_UNIFICATION, hasGemProperty.and(mat -> mat.hasFlag(MaterialFlags.CRYSTALLIZABLE) && !mat.hasFlag(GCYSMaterialFlags.DISABLE_CRYSTALLIZATION)));
    public static final OrePrefix superconductorAssembly = new OrePrefix("superconductorAssembly", M, null, GCYSMaterialIconType.superconductorAssembly, ENABLE_UNIFICATION, hasIngotProperty.and(mat -> mat.hasProperty(PropertyKey.WIRE) && mat.getProperty(PropertyKey.WIRE).isSuperconductor()));
    public static final OrePrefix cannedSuperconductorMix = new OrePrefix("cannedSuperconductorMix", M, null, GCYSMaterialIconType.cannedSuperconductorMix, ENABLE_UNIFICATION, hasIngotProperty.and(mat -> mat.hasProperty(PropertyKey.WIRE) && mat.getProperty(PropertyKey.WIRE).isSuperconductor()));
    public static final OrePrefix superconductorWireBase = new OrePrefix("superconductorWireBase", M, null, GCYSMaterialIconType.superconductorWireBase, ENABLE_UNIFICATION, hasIngotProperty.and(mat -> mat.hasProperty(PropertyKey.WIRE) && mat.getProperty(PropertyKey.WIRE).isSuperconductor()));
}
