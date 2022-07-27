package gregicality.science.api.unification.materials;

import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialIconSet;

import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;

public class GCYSSecondDegreeMaterials {

    /**
     * 6000-8999
     */
    public static void init() {
        LaPrNdCeOxidesSolution = new Material.Builder(6000, "la_pr_nd_ce_oxides_solution")
                .fluid()
                .color(0x9CE3DB)
                .flags(DECOMPOSITION_BY_CENTRIFUGING)
                .components(LanthanumOxide, 1, PraseodymiumOxide, 1, NeodymiumOxide, 1, CeriumOxide, 1)
                .build();

        ScEuGdSmOxidesSolution = new Material.Builder(6001, "sc_eu_gd_sm_oxides_solution")
                .fluid()
                .color(0xFFFF99)
                .flags(DECOMPOSITION_BY_CENTRIFUGING)
                .components(ScandiumOxide, 1, EuropiumOxide, 1, GadoliniumOxide, 1, SamariumOxide, 1)
                .build();

        YTbDyHoOxidesSolution = new Material.Builder(6002, "y_tb_dy_ho_oxides_solution")
                .fluid()
                .color(0x99FF99)
                .flags(DECOMPOSITION_BY_CENTRIFUGING)
                .components(YttriumOxide, 1, TerbiumOxide, 1, DysprosiumOxide, 1, HolmiumOxide, 1)
                .build();

        ErTmYbLuOxidesSolution = new Material.Builder(6003, "er_tm_yb_lu_oxides_solution")
                .fluid()
                .color(0xFFB3FF)
                .flags(DECOMPOSITION_BY_CENTRIFUGING)
                .components(ErbiumOxide, 1, ThuliumOxide, 1, YtterbiumOxide, 1, LutetiumOxide, 1)
                .build();

        PlatinumGroupResidue = new Material.Builder(6004, "platinum_group_residue")
                .dust()
                .color(0x64632E)
                .iconSet(MaterialIconSet.ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Iridium, 1, Osmium, 1, Rhodium, 1, Ruthenium, 1, RareEarth, 1)
                .build();

        PalladiumRichAmmonia = new Material.Builder(6005, "palladium_rich_ammonia")
                .fluid()
                .color(0x808080)
                .flags(DISABLE_DECOMPOSITION)
                .components(Ammonia, 2, Palladium, 1, Chlorine, 2)
                .build();

        CrudePlatinumResidue = new Material.Builder(6006, "crude_platinum_residue")
                .dust()
                .color(0xFFFBC5)
                .flags(DISABLE_DECOMPOSITION)
                .components(PlatinumRaw, 1)
                .build();

        CrudePalladiumResidue = new Material.Builder(6007, "crude_palladium_residue")
                .dust()
                .color(0x808080)
                .flags(DISABLE_DECOMPOSITION)
                .components(PalladiumRaw, 1)
                .build()
                .setFormula("PdCl2", true);

        IridiumGroupSludge = new Material.Builder(6008, "iridium_group_sludge")
                .dust()
                .color(0x644629)
                .flags(DISABLE_DECOMPOSITION)
                .components(Iridium, 1, Osmium, 1, Ruthenium, 1, RareEarth, 1)
                .build();

        RhodiumSulfateSolution = new Material.Builder(6009, "rhodium_sulfate_solution")
                .fluid()
                .color(0xFFBB66)
                .flags(DISABLE_DECOMPOSITION)
                .components(RhodiumSulfate, 1, Water, 1)
                .build()
                .setFormula("RH2(SO4)3(H2O)", true);

        CrudeRhodiumResidue = new Material.Builder(6010, "crude_rhodium_residue")
                .dust()
                .color(0x666666)
                .iconSet(MaterialIconSet.DULL)
                .flags(DISABLE_DECOMPOSITION)
                .components(Rhodium, 2, Water, 1)
                .build();

        RhodiumSalt = new Material.Builder(6011, "rhodium_salt")
                .dust()
                .color(0x848484)
                .iconSet(MaterialIconSet.SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Salt, 2, Rhodium, 2, Chlorine, 6)
                .build()
                .setFormula("(NaCl)2(RhCl3)2", true);

        AcidicSodiumRuthenateSolution = new Material.Builder(6012, "acidic_sodium_ruthenate_solution")
                .fluid()
                .color(0xC7C7C7)
                .flags(DISABLE_DECOMPOSITION)
                .components(SodiumRuthenate, 1, Water, 2, Chlorine, 2)
                .build();

        AcidicIridiumDioxideSolution = new Material.Builder(6013, "acidic_iridium_dioxide_solution")
                .fluid()
                .color(0x27284E)
                .flags(DISABLE_DECOMPOSITION)
                .components(IridiumDioxideResidue, 1, HydrochloricAcid, 4)
                .build();

        GrapheneOxide = new Material.Builder(6014, "graphene_oxide")
                .dust()
                .color(0x777777)
                .iconSet(MaterialIconSet.ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Graphene, 1, Oxygen, 1)
                .build();

        AmmoniumNitrate = new Material.Builder(6015, "ammonium_nitrate")
                .dust()
                .color(0xA59ED7)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Ammonia, 1, NitricAcid, 1)
                .build()
                .setFormula("NH4NO3", true);

        Wollastonite = new Material.Builder(6016, "wollastonite")
                .dust()
                .color(0xF0F0F0)
                .flags(DECOMPOSITION_BY_CENTRIFUGING)
                .components(Quicklime, 2, SiliconDioxide, 3)
                .build()
                .setFormula("CaSiO3", true);

        RoastedSphalerite = new Material.Builder(6017, "roasted_sphalerite")
                .dust()
                .color(0xAC8B5C)
                .iconSet(MaterialIconSet.FINE)
                .flags(DISABLE_DECOMPOSITION)
                .components(GermaniumDioxide, 1)
                .build()
                .setFormula("GaGeO2", true);

        WaelzOxide = new Material.Builder(6018, "waelz_oxide")
                .dust()
                .color(0xB8B8B8)
                .iconSet(MaterialIconSet.FINE)
                .flags(DISABLE_DECOMPOSITION)
                .components(Zinc, 1, GermaniumDioxide, 1)
                .build();

        WaelzSlag = new Material.Builder(6019, "waelz_slag")
                .dust()
                .color(0xAC8B5C)
                .iconSet(MaterialIconSet.ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(ZincSulfate, 1)
                .build()
                .setFormula("GaZnSO4", true);

        ImpureGermaniumDioxide = new Material.Builder(6020, "impure_germanium_dioxide")
                .dust()
                .color(0x666666)
                .iconSet(MaterialIconSet.ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(GermaniumDioxide, 1)
                .build()
                .setFormula("GeO2?", true);

        ErbiumDopedZBLANGlass = new Material.Builder(6021, "erbium_doped_zblan_glass")
                .ingot()
                .color(0x505444)
                .iconSet(MaterialIconSet.BRIGHT)
                .flags(NO_SMASHING, NO_WORKING, DISABLE_DECOMPOSITION, GENERATE_PLATE)
                .components(ZBLANGlass, 1, Erbium, 1)
                .build()
                .setFormula("(ZrF4)5(BaF2)2(LaF3)(AlF3)(NaF)2Er", true);

        PraseodymiumDopedZBLANGlass = new Material.Builder(6022, "praseodymium_doped_zblan_glass")
                .ingot()
                .color(0xC5C88D)
                .iconSet(MaterialIconSet.BRIGHT)
                .flags(NO_SMASHING, NO_WORKING, DISABLE_DECOMPOSITION, GENERATE_PLATE)
                .components(ZBLANGlass, 1, Praseodymium, 1)
                .build()
                .setFormula("(ZrF4)5(BaF2)2(LaF3)(AlF3)(NaF)2Pr", true);

        NdYAG = new Material.Builder(6023, "nd_yag") //TODO "Yttrium-Aluminium-Garnet" Tooltip
                .gem()
                .color(0xD99DE4)
                .iconSet(MaterialIconSet.GEM_VERTICAL)
                .flags(CRYSTALLIZABLE, DECOMPOSITION_BY_CENTRIFUGING)
                .components(YttriumOxide, 2, NeodymiumOxide, 1, Alumina, 5)
                .build()
                .setFormula("NdY2Al5O12", true);

        BismuthFerrite = new Material.Builder(6024, "bismuth_ferrite") //TODO "Multiferroic!" tooltip
                .gem()
                .color(0x43634B)
                .iconSet(MaterialIconSet.MAGNETIC)
                .flags(CRYSTALLIZABLE, GENERATE_PLATE)
                .components(BismuthTrioxide, 2, FerricOxide, 2)
                .build()
                .setFormula("BiFeO3", true);
    }
}
