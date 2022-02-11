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

        PhthalicAnhydride = new Material.Builder(15006, "phthalic_anhydride")
                .dust()
                .color(0xEEAAEE)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 8, Hydrogen, 4, Oxygen, 3)
                .build()
                .setFormula("C6H4(CO)2O", true);

        Ethylanthraquinone = new Material.Builder(15007, "ethylanthraquinone")
                .fluid()
                .color(0xCC865A)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 16, Hydrogen, 12, Oxygen, 2)
                .build()
                .setFormula("C6H4(CO)2C6H3Et", true);

        Ethylanthrahydroquinone = new Material.Builder(15008, "ethylanthrahydroquinone")
                .fluid()
                .color(0xAD531A)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 16, Hydrogen, 18, Oxygen, 2)
                .build()
                .setFormula("C6H4(CH2OH)2C6H3Et", true);

        Formaldehyde = new Material.Builder(15009, "formaldehyde")
                .fluid()
                .color(0x95A13A)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 1, Hydrogen, 2, Oxygen, 1)
                .build();

        Acetylene = new Material.Builder(15010, "acetylene")
                .fluid()
                .color(0x959C60)
                .components(Carbon, 2, Hydrogen, 2)
                .build();

        PropargylAlcohol = new Material.Builder(15011, "propargyl_alcohol")
                .fluid()
                .color(0x714934)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 3, Hydrogen, 4, Oxygen, 1)
                .build();

        PropargylChloride = new Material.Builder(15012, "propargyl_chloride")
                .fluid()
                .color(0x613924)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 3, Hydrogen, 3, Chlorine, 1)
                .build();

        Turpentine = new Material.Builder(15013, "turpentine")
                .fluid()
                .color(0x93BD46)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 10, Hydrogen, 16)
                .build();

        BetaPinene = new Material.Builder(15014, "beta_pinene")
                .fluid()
                .color(0x61AB6B)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 10, Hydrogen, 16)
                .build();

        Citral = new Material.Builder(15015, "citral")
                .fluid()
                .color(0xF2E541)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 10, Hydrogen, 16, Oxygen, 1)
                .build();

        BetaIonone = new Material.Builder(15016, "beta_ionone")
                .fluid()
                .color(0x8D5C91)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 13, Hydrogen, 20, Oxygen, 1)
                .build();

        Retinol = new Material.Builder(15017, "retinol") // TODO Vitamin A Tooltip
                .fluid()
                .color(0xDC5CE6)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 20, Hydrogen, 30, Oxygen, 1)
                .build();
    }
}
