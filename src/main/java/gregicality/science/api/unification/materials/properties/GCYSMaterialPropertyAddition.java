package gregicality.science.api.unification.materials.properties;


import gregtech.api.GTValues;
import gregtech.api.unification.material.info.MaterialIconSet;
import gregtech.api.unification.material.properties.*;

import static gregtech.api.unification.material.Materials.*;

public class GCYSMaterialPropertyAddition {

    public static void init() {

        // Dusts
        Praseodymium.setProperty(PropertyKey.DUST, new DustProperty());
        Scandium.setProperty(PropertyKey.DUST, new DustProperty());
        Gadolinium.setProperty(PropertyKey.DUST, new DustProperty());
        Terbium.setProperty(PropertyKey.DUST, new DustProperty());
        Dysprosium.setProperty(PropertyKey.DUST, new DustProperty());
        Holmium.setProperty(PropertyKey.DUST, new DustProperty());
        Erbium.setProperty(PropertyKey.DUST, new DustProperty());
        Thulium.setProperty(PropertyKey.DUST, new DustProperty());
        Ytterbium.setProperty(PropertyKey.DUST, new DustProperty());
        RhodiumSulfate.setProperty(PropertyKey.DUST, new DustProperty());
        RhodiumSulfate.setMaterialIconSet(MaterialIconSet.ROUGH);
        Zirconium.setProperty(PropertyKey.DUST, new DustProperty());
        Tellurium.setProperty(PropertyKey.DUST, new DustProperty());
        Selenium.setProperty(PropertyKey.DUST, new DustProperty());
        Rubidium.setProperty(PropertyKey.DUST, new DustProperty());

        // Ingots
        Germanium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Rhenium.setProperty(PropertyKey.INGOT, new IngotProperty());

        // Blast
        Germanium.setProperty(PropertyKey.BLAST, new BlastProperty(1211, BlastProperty.GasTier.HIGH, GTValues.VA[GTValues.EV], 1200));

        // Fluids
        Bromine.setProperty(PropertyKey.FLUID, new FluidProperty());
        Bromine.setMaterialIconSet(MaterialIconSet.FLUID);
        Germanium.setProperty(PropertyKey.FLUID, new FluidProperty());
    }
}
