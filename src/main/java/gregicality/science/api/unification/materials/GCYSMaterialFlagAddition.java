package gregicality.science.api.unification.materials;

import gregicality.science.common.GCYSConfigHolder;
import gregtech.api.unification.material.info.MaterialFlags;

import static gregicality.science.api.unification.material.info.GCYSMaterialFlags.DISABLE_CRYSTALLIZATION;
import static gregtech.api.unification.material.Materials.*;

public class GCYSMaterialFlagAddition {

    public static void init() {

        // Formula Changes
        PalladiumRaw.setFormula("PdCl2", true);
        RarestMetalMixture.setFormula("IrOs?", true);
        IridiumMetalResidue.setFormula("Ir2O3", true);

        // Disable Decomposition
        if (GCYSConfigHolder.chainOverrides.disableNiobiumTantalumProcessing) {
            Pyrochlore.addFlags(MaterialFlags.DISABLE_DECOMPOSITION);
            Tantalite.addFlags(MaterialFlags.DISABLE_DECOMPOSITION);
        }
        if (GCYSConfigHolder.chainOverrides.disableMolybdenumProcessing) {
            Molybdenite.addFlags(MaterialFlags.DISABLE_DECOMPOSITION);
            Powellite.addFlags(MaterialFlags.DISABLE_DECOMPOSITION);
            Wulfenite.addFlags(MaterialFlags.DISABLE_DECOMPOSITION);
        }
        RockSalt.addFlags(MaterialFlags.DISABLE_DECOMPOSITION); // Conflict between Potassium Hydroxide and Rock Salt Electrolysis

        // Disable Crystallization
        Monazite.addFlags(DISABLE_CRYSTALLIZATION);

        // Crystallizable
        Sapphire.addFlags(MaterialFlags.CRYSTALLIZABLE);
        Ruby.addFlags(MaterialFlags.CRYSTALLIZABLE);
        Emerald.addFlags(MaterialFlags.CRYSTALLIZABLE);
        Olivine.addFlags(MaterialFlags.CRYSTALLIZABLE);
        Amethyst.addFlags(MaterialFlags.CRYSTALLIZABLE);
        Opal.addFlags(MaterialFlags.CRYSTALLIZABLE);

        // Plates
        Germanium.addFlags(MaterialFlags.GENERATE_PLATE);
        Rhenium.addFlags(MaterialFlags.GENERATE_PLATE);

        // Rods
        Darmstadtium.addFlags(MaterialFlags.GENERATE_ROD);

        // Springs
        Trinium.addFlags(MaterialFlags.GENERATE_SPRING);
        Tritanium.addFlags(MaterialFlags.GENERATE_SPRING);

        // Small Springs
        Europium.addFlags(MaterialFlags.GENERATE_SPRING_SMALL);

        // Frames
        Darmstadtium.addFlags(MaterialFlags.GENERATE_FRAME);

        // Foils
        Nickel.addFlags(MaterialFlags.GENERATE_FOIL);
        Titanium.addFlags(MaterialFlags.GENERATE_FOIL);
        Germanium.addFlags(MaterialFlags.GENERATE_FOIL);
    }
}
