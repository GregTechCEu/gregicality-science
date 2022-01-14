package gregicality.science.api.unification.materials;

import gregtech.api.unification.material.Material;

import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.DISABLE_DECOMPOSITION;

public class GCYSOrganicChemistryMaterials {

    /**
     * IDs: 15000-17999
     */
    public static void init() {

        Butyraldehyde = new Material.Builder(15000, "butyraldehyde")
                .fluid()
                .color(0xE7CF6E)
                .components(Carbon, 8, Hydrogen, 18, Oxygen, 1)
                .build()
                .setFormula("CH3(CH2)3CH(CH2CH3)CH2OH", true);

        Ethylhexanol = new Material.Builder(15001,"ethylhexanol")
                .fluid()
                .color(0xFEEA9A)
                .components(Carbon, 8, Hydrogen, 10, Oxygen, 1)
                .build();

        DiethylhexylPhosphoricAcid = new Material.Builder(15002, "diethylhexyl_phosphoric_acid")
                .fluid()
                .color(0xFFFF99)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 16, Hydrogen, 35, Oxygen, 4, Phosphorus, 1)
                .build()
                .setFormula("(C8H7O)2PO2H", true);

        Butanol = new Material.Builder(15003, "butanol")
                .fluid()
                .color(0xC7AF2E)
                .components(Carbon, 4, Hydrogen, 10, Oxygen, 1)
                .build()
                .setFormula("C4H9OH", true);

        MethylFormate = new Material.Builder(15004, "methyl_formate")
                .fluid()
                .color(0xFFAAAA)
                .flags(DISABLE_DECOMPOSITION)
                .components(Hydrogen, 4, Carbon, 2, Oxygen, 2)
                .build()
                .setFormula("HCO2CH3", true);

        FormicAcid = new Material.Builder(15005, "formic_acid")
                .fluid()
                .color(0xFFAA77)
                .flags(DISABLE_DECOMPOSITION)
                .components(Hydrogen, 2, Carbon, 1, Oxygen, 2)
                .build()
                .setFormula("HCOOH", true);
    }
}
