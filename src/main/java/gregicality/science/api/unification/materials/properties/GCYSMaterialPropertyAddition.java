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
        Zirconium.setProperty(PropertyKey.DUST, new DustProperty());
        Tellurium.setProperty(PropertyKey.DUST, new DustProperty());
        Selenium.setProperty(PropertyKey.DUST, new DustProperty());
        Rubidium.setProperty(PropertyKey.DUST, new DustProperty());
        Thallium.setProperty(PropertyKey.DUST, new DustProperty());

        // Ingots
        Germanium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Rhenium.setProperty(PropertyKey.INGOT, new IngotProperty());

        // Blast
        Germanium.setProperty(PropertyKey.BLAST, new BlastProperty(1211, BlastProperty.GasTier.HIGH, GTValues.VA[GTValues.EV], 1200));

        // Fluids
        Bromine.setProperty(PropertyKey.FLUID, new FluidProperty());
        Bromine.setMaterialIconSet(MaterialIconSet.FLUID);
        Germanium.setProperty(PropertyKey.FLUID, new FluidProperty());
        FluidProperty prop = new FluidProperty();
        prop.setFluidTemperature(332);
        SodiumBisulfate.setProperty(PropertyKey.FLUID, prop);

        // Ore Byproducts
        //TODO Fix ore byproduct changes
        Pollucite.getProperty(PropertyKey.ORE).setOreByProducts(Aluminium, Potassium, Caesium, Pollucite);

        // Cable Properties
        WireProperties wireProp = RutheniumTriniumAmericiumNeutronate.getProperty(PropertyKey.WIRE);
        wireProp.setSuperconductor(false);
        wireProp.setLossPerBlock(32);
        wireProp.setVoltage((int) GTValues.V[GTValues.UIV]);
    }
}
