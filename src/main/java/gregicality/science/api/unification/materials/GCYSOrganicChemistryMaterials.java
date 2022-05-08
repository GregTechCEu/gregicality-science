package gregicality.science.api.unification.materials;

import gregtech.api.fluids.fluidType.FluidTypes;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialIconSet;

import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;

public class GCYSOrganicChemistryMaterials {

    /**
     * IDs: 15000-17999
     */
    public static void init() {

        // FREE ID: 15000

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

        Dichloroethane = new Material.Builder(15018, "dichloroethane")
                .fluid()
                .color(0xDAAED3)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 2, Hydrogen, 4, Chlorine, 2)
                .build();

        Ethylenediamine = new Material.Builder(15019, "ethylenediamine")
                .fluid()
                .color(0xD00ED0)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 2, Hydrogen, 8, Nitrogen, 2)
                .build()
                .setFormula("C2H4(NH2)2", true);

        HydrogenCyanide = new Material.Builder(15020, "hydrogen_cyanide")
                .fluid(FluidTypes.GAS)
                .color(0xB6D1AE)
                .flags(DISABLE_DECOMPOSITION)
                .components(Hydrogen, 1, Carbon, 1, Nitrogen, 1)
                .build();

        TetrasodiumEDTA = new Material.Builder(15021, "tetrasodium_edta")
                .dust()
                .color(0x8890E0)
                .iconSet(MaterialIconSet.SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 10, Hydrogen, 12, Sodium, 4, Nitrogen, 2, Oxygen, 8)
                .build();

        EthylenediaminetetraaceticAcid = new Material.Builder(15022, "ethylenediaminetetraacetic_acid") //TODO EDTA Tooltip
                .dust()
                .color(0x87E6D9)
                .iconSet(MaterialIconSet.ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 10, Hydrogen, 16, Nitrogen, 2, Oxygen, 8)
                .build();

        Biotin = new Material.Builder(15023, "biotin") //TODO Vitamin B7 Tooltip
                .fluid()
                .color(0x68CC6A)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 10, Hydrogen, 16, Nitrogen, 2, Oxygen, 3, Sulfur, 1)
                .build();

        LinoleicAcid = new Material.Builder(15024, "linoleic_acid")
                .fluid()
                .color(0xD5D257)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 18, Hydrogen, 32, Oxygen, 2)
                .build();

        Glutamine = new Material.Builder(15025, "glutamine")
                .dust()
                .color(0xEDE9B4)
                .iconSet(MaterialIconSet.FINE)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 5, Hydrogen, 10, Nitrogen, 2, Oxygen, 3)
                .build();

        Aniline = new Material.Builder(15026, "aniline")
                .fluid()
                .color(0x4C911D)
                .components(Carbon, 6, Hydrogen, 7, Nitrogen, 1)
                .build()
                .setFormula("C6H5NH2", true);

        AceticAnhydride = new Material.Builder(15027, "acetic_anhydride")
                .fluid()
                .color(0xD5DDDF)
                .components(Carbon, 4, Hydrogen, 6, Oxygen, 3)
                .build()
                .setFormula("(CH3CO)2O", true);

        AcetylsulfanilylChloride = new Material.Builder(15028, "acetylsulfanilyl_chloride")
                .fluid()
                .color(0xACD6ED)
                .components(Carbon, 8, Hydrogen, 8, Chlorine, 1, Nitrogen, 1, Oxygen, 3, Sulfur, 1)
                .build();

        Sulfanilamide = new Material.Builder(15029, "sulfanilamide")
                .fluid()
                .color(0x523B0A)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 6, Hydrogen, 8, Nitrogen, 2, Oxygen, 2, Sulfur, 1)
                .build();

        ParaXylene = new Material.Builder(15030, "para_xylene")
                .fluid()
                .color(0x666040)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 8, Hydrogen, 10)
                .build()
                .setFormula("C6H4(CH3)2", true);

        Durene = new Material.Builder(15031, "durene")
                .dust()
                .color(0x336040)
                .iconSet(MaterialIconSet.FINE)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 10, Hydrogen, 14)
                .build()
                .setFormula("C6H2(CH3)4", true);

        PyrometalliticDianhydride = new Material.Builder(15032, "pyromellitic_dianhydride") //TODO PDMA Tooltip
                .dust()
                .color(0xF0EAD6)
                .iconSet(MaterialIconSet.ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 10, Hydrogen, 2, Oxygen, 6)
                .build()
                .setFormula("C6H2(C2O3)2", true);

        Aminophenol = new Material.Builder(15033, "aminophenol")
                .fluid()
                .color(0xFF7F50)
                .components(Carbon, 6, Hydrogen, 7, Nitrogen, 1, Oxygen, 1)
                .build()
                .setFormula("HOC6H4NH2", true);

        Dimethylformamide = new Material.Builder(15034, "dimethylformamide") //TODO DMF Tooltip
                .fluid()
                .color(0x42BDFF)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 3, Hydrogen, 7, Nitrogen, 1, Oxygen, 1)
                .build()
                .setFormula("(CH3)2NC(O)H", true);

        Oxydianiline = new Material.Builder(15035, "oxydianiline") //TODO ODA Tooltip
                .dust()
                .color(0xF0E130)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 12, Hydrogen, 12, Nitrogen, 2, Oxygen, 1)
                .build()
                .setFormula("O(C6H4NH2)2", true);

        KaptonK = new Material.Builder(15036, "kapton_k") //TODO Poly 4,4'-oxydiphenylene-pyromellitimide Tooltip
                .ingot().fluid()
                .color(0xFFCE52)
                .flags(DISABLE_DECOMPOSITION, GENERATE_PLATE, GENERATE_FOIL)
                .components(Carbon, 12, Hydrogen, 12, Nitrogen, 2, Oxygen, 1)
                .build()
                .setFormula("O(C6H4NH2)2", true);

        BiphenylTetracarboxylicAcidDianhydride = new Material.Builder(15037, "biphenyl_tetracarboxylic_acid_dianhydride") //TODO BPDA Tooltip
                .dust()
                .color(0xFF7F50)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 16, Hydrogen, 6, Oxygen, 6)
                .build()
                .setFormula("O(C6H4NH2)2", true);

        Nitroaniline = new Material.Builder(15038, "nitroaniline")
                .fluid()
                .color(0x2A6E68)
                .components(Carbon, 6, Hydrogen, 6, Nitrogen, 6, Oxygen, 2)
                .build()
                .setFormula("H2NC6H4NO2", true);

        ParaPhenylenediamine = new Material.Builder(15039, "para_phenylenediamine")
                .dust()
                .color(0x4A8E7B)
                .iconSet(MaterialIconSet.ROUGH)
                .components(Carbon, 6, Hydrogen, 8, Nitrogen, 2)
                .build()
                .setFormula("H2NC6H4NH2", true);

        KaptonE = new Material.Builder(15040, "kapton_e")
                .ingot().fluid()
                .color(0xFFDF8C)
                .flags(DISABLE_DECOMPOSITION, GENERATE_PLATE)
                .components(Carbon, 12, Hydrogen, 12, Nitrogen, 2, Oxygen, 1)
                .build()
                .setFormula("O(C6H4NH2)2", true);

        Methylamine = new Material.Builder(15041, "methylamine")
                .fluid(FluidTypes.GAS)
                .color(0xAA6600)
                .components(Carbon, 1, Hydrogen, 5, Nitrogen, 1)
                .build()
                .setFormula("(CH3)NH2", true);

        Trimethylamine = new Material.Builder(15042, "trimethylamine")
                .fluid(FluidTypes.GAS)
                .color(0xBB7700)
                .components(Carbon, 3, Hydrogen, 11, Nitrogen, 1)
                .build()
                .setFormula("(CH3)3NH2");

        Bistrichloromethylbenzene = new Material.Builder(15043, "bistrichloromethylbenzene")
                .fluid()
                .color(0xCF8498)
                .components(Carbon, 8, Hydrogen, 4, Chlorine, 6)
                .build()
                .setFormula("C6H4(CCl3)2", true);

        Tetrabromoethane = new Material.Builder(15044, "tetrabromoethane")
                .fluid()
                .color(0x5AAADA)
                .components(Carbon, 2, Hydrogen, 2, Bromine, 4)
                .build();

        TerephthalicAcid = new Material.Builder(15045, "terephthalic_acid")
                .dust()
                .color(0x5ACCDA)
                .iconSet(MaterialIconSet.ROUGH)
                .components(Carbon, 8, Hydrogen, 6, Oxygen, 4)
                .build()
                .setFormula("C6H4(CO2H)2", true);

        TerephthaloylChloride = new Material.Builder(15046, "terephthaloyl_chloride")
                .dust()
                .color(0xFAC4DA)
                .iconSet(MaterialIconSet.SHINY)
                .components(Carbon, 8, Hydrogen, 4, Oxygen, 2, Chlorine, 2)
                .build()
                .setFormula("C6H4(COCl)2", true);

        Butanediol = new Material.Builder(15047, "butanediol")
                .fluid()
                .color(0xAAC4DA)
                .components(Carbon, 4, Hydrogen, 10, Oxygen, 2)
                .build();

        GammaButyrolactone = new Material.Builder(15048, "gamma_butyrolactone") //TODO "GBL" tooltip
                .fluid()
                .color(0xAF04D6)
                .components(Carbon, 4, Hydrogen, 6, Oxygen, 2)
                .build();

        NMethylPyrrolidone = new Material.Builder(15049, "n_methyl_pyrrolidone")
                .fluid()
                .color(0xA504D6)
                .components(Carbon, 5, Hydrogen, 9, Nitrogen, 1, Oxygen, 1)
                .build();

        Kevlar = new Material.Builder(15050, "kevlar")
                .ingot().fluid()
                .color(0xF0F078)
                .flags(DISABLE_DECOMPOSITION, NO_SMASHING, GENERATE_PLATE)
                .components(Carbon, 14, Hydrogen, 10, Nitrogen, 2, Oxygen, 2)
                .build()
                .setFormula("(C6H4)2(CO)2(NH)2", true);
    }
}
