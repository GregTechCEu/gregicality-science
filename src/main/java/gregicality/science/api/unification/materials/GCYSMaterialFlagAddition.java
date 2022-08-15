package gregicality.science.api.unification.materials;

import gregicality.science.common.GCYSConfigHolder;
import gregtech.api.unification.material.properties.OreProperty;
import gregtech.api.unification.material.properties.PropertyKey;

import static gregicality.science.api.unification.material.info.GCYSMaterialFlags.DISABLE_CRYSTALLIZATION;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;

public class GCYSMaterialFlagAddition {

    public static void init() {

        // Formula Changes
        PalladiumRaw.setFormula("PdCl2", true);
        RarestMetalMixture.setFormula("IrOs?", true);
        IridiumMetalResidue.setFormula("Ir2O3", true);

        // Disable Decomposition
        if (GCYSConfigHolder.chainOverrides.disableNiobiumTantalumProcessing) {
            Pyrochlore.addFlags(DISABLE_DECOMPOSITION);
            Tantalite.addFlags(DISABLE_DECOMPOSITION);
        }
        if (GCYSConfigHolder.chainOverrides.disableMolybdenumProcessing) {
            Molybdenite.addFlags(DISABLE_DECOMPOSITION);
            OreProperty oreProp = Molybdenite.getProperty(PropertyKey.ORE);
            oreProp.setDirectSmeltResult(null);
            Powellite.addFlags(DISABLE_DECOMPOSITION);
            Wulfenite.addFlags(DISABLE_DECOMPOSITION);
        }
        RockSalt.addFlags(DISABLE_DECOMPOSITION); // Conflict between Potassium Hydroxide and Rock Salt Electrolysis
        Salt.addFlags(DISABLE_DECOMPOSITION); // Conflict between Sodium Chlorate and Salt Electrolysis
        Pollucite.addFlags(DISABLE_DECOMPOSITION); // for rubidium chain

        // Disable Crystallization
        Monazite.addFlags(DISABLE_CRYSTALLIZATION);

        // Crystallizable
        Sapphire.addFlags(CRYSTALLIZABLE);
        Ruby.addFlags(CRYSTALLIZABLE);
        Emerald.addFlags(CRYSTALLIZABLE);
        Olivine.addFlags(CRYSTALLIZABLE);
        Amethyst.addFlags(CRYSTALLIZABLE);
        Opal.addFlags(CRYSTALLIZABLE);

        // Plates
        Germanium.addFlags(GENERATE_PLATE);
        Rhenium.addFlags(GENERATE_PLATE);

        // Rods
        Darmstadtium.addFlags(GENERATE_ROD);

        // Springs
        Trinium.addFlags(GENERATE_SPRING);
        Tritanium.addFlags(GENERATE_SPRING);

        // Small Springs
        Europium.addFlags(GENERATE_SPRING_SMALL);

        // Frames
        Darmstadtium.addFlags(GENERATE_FRAME);

        // Foils
        Nickel.addFlags(GENERATE_FOIL);
        Titanium.addFlags(GENERATE_FOIL);
        Germanium.addFlags(GENERATE_FOIL);
    }
}
