package gregicality.science.api.unification.materials;

import gregtech.api.fluids.fluidType.FluidTypes;
import gregtech.api.unification.material.Material;

import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.DISABLE_DECOMPOSITION;
import static gregtech.api.unification.material.info.MaterialIconSet.FINE;

public class GCYSUnknownCompositionMaterials {

    /**
     * 18000-19999
     */
    public static void init() {

        RareEarthHydroxidesSolution = new Material.Builder(18000, "rare_earth_hydroxides_solution")
                .fluid()
                .color(0x434327)
                .flags(DISABLE_DECOMPOSITION)
                .components(RareEarth, 1, Oxygen, 1, Hydrogen, 1, Water, 1)
                .build();

        RareEarthChloridesSolution = new Material.Builder(18001, "rare_earth_chlorides_solution")
                .fluid()
                .color(0x838367)
                .flags(DISABLE_DECOMPOSITION)
                .components(RareEarth, 1, Chlorine, 1, Water, 1)
                .build();

        LeachedTurpentine = new Material.Builder(18002, "leached_turpentine")
                .fluid()
                .color(0x330D16)
                .flags(DISABLE_DECOMPOSITION)
                .components(Turpentine, 1, RareEarth, 1)
                .build();

        SteamCrackedTurpentine = new Material.Builder(18003, "steamcracked_turpentine").fluid().color(0x634D56).build();

        Blood = new Material.Builder(18004, "blood").fluid().color(0xBB0A1E).build();

        NonCoagulatingBlood = new Material.Builder(18005, "non_coagulating_blood").fluid().color(0xCC6A2F).build();

        Catalase = new Material.Builder(18006, "catalase").fluid().color(0xDB6596).build();

        BasicFibroblastGrowthFactor = new Material.Builder(18007, "basic_fibroblast_growth_factor").fluid().color(0xB365E0).build(); //TODO bFGF tooltip

        EpidermalGrowthFactor = new Material.Builder(18008, "epidermal_growth_factor").fluid().color(0xCC6A2F).build(); //TODO EGF tooltip

        Yeast = new Material.Builder(18009, "yeast").dust().color(0xF0E660).iconSet(FINE).build();

        B27Supplement = new Material.Builder(18010, "b_27_supplement").fluid().color(0x386939).build();

        RawEvolutionaryMedium = new Material.Builder(18011, "raw_evolutionary_medium").fluid().color(0x61932E).build();

        EvolutionaryMedium = new Material.Builder(18012, "evolutionary_medium").fluid().color(0xA2FD35).build(); // TODO "Survival of the Fittest" Tooltip

        RichNitrogenMixture = new Material.Builder(18013, "rich_nitrogen_mixture").fluid(FluidTypes.GAS).color(0x6891D8).build();

        RichAmmoniaMixture = new Material.Builder(18014, "rich_ammonia_mixture").fluid().color(0x708ACD).build();

        Brine = new Material.Builder(18015, "brine").fluid().color(0xFCFC8A).build();

        ChlorinatedBrine = new Material.Builder(18016, "chlorinated_brine").fluid().color(0xFAFC8A).build();

        ChalcogenAnodeMud = new Material.Builder(18017, "chalcogen_anode_mud").dust().color(0x8A3324).iconSet(FINE).build();

        MethylamineMixture = new Material.Builder(18018, "methylamine_mixture").fluid().color(0xAA4400).build();
    }
}
