package gregicality.science.api.unification.materials;

import gregtech.api.fluids.fluidType.FluidTypes;
import gregtech.api.unification.material.Material;

import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.DISABLE_DECOMPOSITION;
import static gregtech.api.unification.material.info.MaterialIconSet.FINE;
import static gregtech.api.unification.material.info.MaterialIconSet.ROUGH;

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

        EDP = new Material.Builder(18019, "edp").fluid().color(0xFBFF17).build();

        PhosphoreneSolution = new Material.Builder(18020, "phosphorene_solution").fluid().color(0x465966).build();

        SodioIndene = new Material.Builder(18021, "sodio_indene").fluid().color(0x1D1C24).build();

        SteamCrackedSodioIndene = new Material.Builder(18022, "steam_cracked_sodio_indene").fluid().fluidTemp(1105).color(0x1C1A29).build();

        MolybdenumFlue = new Material.Builder(18023, "molybdenum_flue").fluid(FluidTypes.GAS).color(0x39194A).build();

        TraceRheniumFlue = new Material.Builder(18024, "trace_rhenium_flue").fluid(FluidTypes.GAS).color(0x96D6D5).build();

        FracturingFluid = new Material.Builder(18025, "fracturing_fluid").fluid().color(0x96D6D5).build();

        BedrockSmoke = new Material.Builder(18026, "bedrock_smoke").fluid(FluidTypes.GAS).color(0x525252).build();

        // FREE ID 18027

        Bedrock = new Material.Builder(18028, "bedrock").dust().color(0x404040).iconSet(ROUGH).build();

        BedrockSootSolution = new Material.Builder(18029, "bedrock_soot_solution").fluid().color(0x1E2430).build();

        CleanBedrockSolution = new Material.Builder(18030, "clean_bedrock_solution").fluid().color(0xA89F9E).build();

        HeavyBedrockSmoke = new Material.Builder(18031, "heavy_bedrock_smoke").fluid(FluidTypes.GAS).color(0x242222).build();

        MediumBedrockSmoke = new Material.Builder(18032, "medium_bedrock_smoke").fluid(FluidTypes.GAS).color(0x2E2C2C).build();

        LightBedrockSmoke = new Material.Builder(18033, "light_bedrock_smoke").fluid(FluidTypes.GAS).color(0x363333).build();

        UltralightBedrockSmoke = new Material.Builder(18034, "ultralight_bedrock_smoke").fluid(FluidTypes.GAS).color(0x403D3D).build();

        HeavyTaraniumGas = new Material.Builder(18035, "heavy_taranium_gas").fluid(FluidTypes.GAS).color(0x262626).build();

        MediumTaraniumGas = new Material.Builder(18036, "medium_taranium_gas").fluid(FluidTypes.GAS).color(0x313131).build();

        LightTaraniumGas = new Material.Builder(18037, "light_taranium_gas").fluid(FluidTypes.GAS).color(0x404040).build();

        BedrockGas = new Material.Builder(18038, "bedrock_gas").fluid(FluidTypes.GAS).color(0x575757).build();

        CrackedHeavyTaranium = new Material.Builder(18039, "cracked_heavy_taranium").fluid().color(0x1F2B2E).build();

        CrackedMediumTaranium = new Material.Builder(18040, "cracked_medium_taranium").fluid().color(0x29393D).build();

        CrackedLightTaranium = new Material.Builder(18041, "cracked_light_taranium").fluid().color(0x374C52).build();

        EnrichedBedrockSootSolution = new Material.Builder(18042, "enriched_bedrock_soot_solution").fluid().color(0x280C26).build();

        CleanEnrichedBedrockSolution = new Material.Builder(18043, "clean_enriched_bedrock_solution").fluid().color(0x828C8C).build();

        HeavyEnrichedBedrockSmoke = new Material.Builder(18044, "heavy_enriched_bedrock_smoke").fluid(FluidTypes.GAS).color(0x1A2222).build();

        MediumEnrichedBedrockSmoke = new Material.Builder(18045, "medium_enriched_bedrock_smoke").fluid(FluidTypes.GAS).color(0x1E2C2C).build();

        LightEnrichedBedrockSmoke = new Material.Builder(18046, "light_enriched_bedrock_smoke").fluid(FluidTypes.GAS).color(0x163333).build();

        HeavyEnrichedTaraniumGas = new Material.Builder(18047, "heavy_enriched_taranium_gas").fluid(FluidTypes.GAS).color(0x1F2626).build();

        MediumEnrichedTaraniumGas = new Material.Builder(18048, "medium_enriched_taranium_gas").fluid(FluidTypes.GAS).color(0x1F3131).build();

        LightEnrichedTaraniumGas = new Material.Builder(18049, "light_enriched_taranium_gas").fluid(FluidTypes.GAS).color(0x1F4040).build();

        CrackedHeavyEnrichedTaranium = new Material.Builder(18050, "cracked_heavy_enriched_taranium").fluid().color(0x2E1F2E).build();

        CrackedMediumEnrichedTaranium = new Material.Builder(18051, "cracked_medium_enriched_taranium").fluid().color(0x29393D).build();

        CrackedLightEnrichedTaranium = new Material.Builder(18052, "cracked_light_enriched_taranium").fluid().color(0x374C52).build();

        EnergeticNaquadria = new Material.Builder(18053, "energetic_naquadria").fluid().color(0x202020).build();

        LightHyperFuel = new Material.Builder(18054, "light_hyper_fuel").fluid().color(0x8C148C).build();

        MediumHyperFuel = new Material.Builder(18055, "medium_hyper_fuel").fluid().color(0xDC0A0A).build();

        HeavyHyperFuel = new Material.Builder(18056, "heavy_hyper_fuel").fluid().color(0x1E5064).build();
    }
}
