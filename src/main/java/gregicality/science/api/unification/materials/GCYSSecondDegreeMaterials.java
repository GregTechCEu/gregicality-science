package gregicality.science.api.unification.materials;

import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialIconSet;

import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.DECOMPOSITION_BY_CENTRIFUGING;
import static gregtech.api.unification.material.info.MaterialFlags.DISABLE_DECOMPOSITION;

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

        ErThYtLuOxidesSolution = new Material.Builder(6003, "er_th_yt_lu_oxides_solution")
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
                .build()
                .setFormula("(NH3)2PtCl6", true);

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

        SodiumRuthenateChlorineSolution = new Material.Builder(6012, "sodium_ruthenate_chlorine_solution")
                .fluid()
                .color(0xC7C7C7)
                .flags(DISABLE_DECOMPOSITION)
                .components(SodiumRuthenate, 1, Water, 2, Chlorine, 2)
                .build();
    }
}
