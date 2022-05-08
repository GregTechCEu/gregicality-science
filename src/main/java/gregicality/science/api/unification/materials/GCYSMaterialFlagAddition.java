package gregicality.science.api.unification.materials;

import gregicality.science.common.GCYSConfigHolder;
import gregtech.api.unification.material.info.MaterialFlags;

import static gregicality.science.api.unification.material.info.GCYSMaterialFlags.DISABLE_CRYSTALLIZATION;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.CRYSTALLIZABLE;

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

        // Disable Crystallization
        Monazite.addFlags(DISABLE_CRYSTALLIZATION);

        // Crystallizable
        Sapphire.addFlags(CRYSTALLIZABLE);
        Ruby.addFlags(CRYSTALLIZABLE);
        Emerald.addFlags(CRYSTALLIZABLE);
        Olivine.addFlags(CRYSTALLIZABLE);
        Amethyst.addFlags(CRYSTALLIZABLE);
        Opal.addFlags(CRYSTALLIZABLE);

        // Rods
        Darmstadtium.addFlags(MaterialFlags.GENERATE_ROD);

        // Frames
        Darmstadtium.addFlags(MaterialFlags.GENERATE_FRAME);

        // Foils
        Titanium.addFlags(MaterialFlags.GENERATE_FOIL);
    }
}
