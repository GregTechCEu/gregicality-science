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
        AcidicOsmiumSolution.setFormula("OsO4(HCl)", true);
        IridiumMetalResidue.setFormula("Ir?", true);

        // Disable Decomposition
        if (GCYSConfigHolder.chainOverrides.disablePlatinumProcessing) {
            SulfuricCopperSolution.addFlags(MaterialFlags.DISABLE_DECOMPOSITION);
            SulfuricNickelSolution.addFlags(MaterialFlags.DISABLE_DECOMPOSITION);
        }
        if (GCYSConfigHolder.chainOverrides.disableNiobiumTantalumProcessing) {
            Pyrochlore.addFlags(MaterialFlags.DISABLE_DECOMPOSITION);
            Tantalite.addFlags(MaterialFlags.DISABLE_DECOMPOSITION);
        }
        if (GCYSConfigHolder.chainOverrides.disableMolybdenumExtraction) {
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

        // Rods
        Darmstadtium.addFlags(MaterialFlags.GENERATE_ROD);

        // Frames
        Darmstadtium.addFlags(MaterialFlags.GENERATE_FRAME);

        // Foils
        Nickel.addFlags(MaterialFlags.GENERATE_FOIL);
        Titanium.addFlags(MaterialFlags.GENERATE_FOIL);
    }
}
