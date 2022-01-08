package gregicality.science.api.unification.materials;

import gregtech.api.unification.material.Material;

import static gregicality.science.api.unification.materials.GCYSMaterials.*;

public class GCYSSecondDegreeMaterials {

    /**
     * 6000-8999
     */
    public static void init() {
        LaPrNdCeOxidesSolution = new Material.Builder(6000, "la_pr_nd_ce_oxides_solution")
                .fluid()
                .color(0x9CE3DB)
                .components(LanthanumOxide, 1, PraseodymiumOxide, 1, NeodymiumOxide, 1, CeriumOxide, 1)
                .build();

        ScEuGdSmOxidesSolution = new Material.Builder(6001, "sc_eu_gd_sm_oxides_solution")
                .fluid()
                .color(0xFFFF99)
                .components(ScandiumOxide, 1, EuropiumOxide, 1, GadoliniumOxide, 1, SamariumOxide, 1)
                .build();

        YTbDyHoOxidesSolution = new Material.Builder(6002, "y_tb_dy_ho_oxides_solution")
                .fluid()
                .color(0x99FF99)
                .components(YttriumOxide, 1, TerbiumOxide, 1, DysprosiumOxide, 1, HolmiumOxide, 1)
                .build();

        ErThYtLuOxidesSolution = new Material.Builder(6003, "er_th_yt_lu_oxides_solution")
                .fluid()
                .color(0xFFB3FF)
                .components(ErbiumOxide, 1, ThuliumOxide, 1, YtterbiumOxide, 1, LutetiumOxide, 1)
                .build();
    }
}
