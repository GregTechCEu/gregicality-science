package gregicality.science.api.unification.materials;

import gregicality.science.common.GCYSConfigHolder;
import gregtech.api.unification.material.info.MaterialFlags;

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

        // Rods
        Darmstadtium.addFlags(MaterialFlags.GENERATE_ROD);

        // Frames
        Darmstadtium.addFlags(MaterialFlags.GENERATE_FRAME);
    }
}
