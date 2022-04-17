package gregicality.science.api.unification;

import gregicality.science.api.unification.ore.GCYSOrePrefix;
import gregtech.common.items.MetaItems;

public class OrePrefixAdditions {
    public static void init(){
        MetaItems.addOrePrefix(GCYSOrePrefix.seedCrystal);
        MetaItems.addOrePrefix(GCYSOrePrefix.boule);
        MetaItems.addOrePrefix(GCYSOrePrefix.superconductorAssembly);
        MetaItems.addOrePrefix(GCYSOrePrefix.cannedSuperconductorMix);
        MetaItems.addOrePrefix(GCYSOrePrefix.superconductorWireBase);
    }
}
