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

        BZMedium = new Material.Builder(18004, "bz_medium").fluid().color(0xA2FD35).build(); //TODO "The Belousov-Zhabotinsky Reaction" tooltip

        RichNitrogenMixture = new Material.Builder(18013, "rich_nitrogen_mixture").fluid(FluidTypes.GAS).color(0x6891D8).build();

        RichAmmoniaMixture = new Material.Builder(18014, "rich_ammonia_mixture").fluid().color(0x708ACD).build();

        Brine = new Material.Builder(18015, "brine").fluid().color(0xFCFC8A).build();

        ChlorinatedBrine = new Material.Builder(18016, "chlorinated_brine").fluid().color(0xFAFC8A).build();

        ChalcogenAnodeMud = new Material.Builder(18017, "chalcogen_anode_mud").dust().color(0x8A3324).iconSet(FINE).build();

        MethylamineMixture = new Material.Builder(18018, "methylamine_mixture").fluid().color(0xAA4400).build();

        EPD = new Material.Builder(18019, "epd").fluid().color(0xFBFF17).build();

        PhosphoreneSolution = new Material.Builder(18020, "phosphorene_solution").fluid().color(0x465966).build();

        SodioIndene = new Material.Builder(18021, "sodio_indene").fluid().color(0x1D1C24).build();

        SteamCrackedSodioIndene = new Material.Builder(18022, "steam_cracked_sodio_indene").fluid().color(0x1C1A29).build();

        MolybdenumFlue = new Material.Builder(18023, "molybdenum_flue").fluid(FluidTypes.GAS).color(0x39194A).build();

        TraceRheniumFlue = new Material.Builder(18024, "trace_rhenium_flue").fluid(FluidTypes.GAS).color(0x96D6D5).build();
    }
}
