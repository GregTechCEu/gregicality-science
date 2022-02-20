package gregicality.science.loaders.recipe.chain;

import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.api.unification.ore.OrePrefix;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import static gregicality.science.api.recipes.GCYSRecipeMaps.BIO_VAT_RECIPES;
import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregicality.science.common.items.GCYSMetaItems.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static gregtech.api.unification.ore.OrePrefix.dustTiny;
import static gregtech.common.items.MetaItems.PETRI_DISH;
import static gregtech.common.items.MetaItems.STEM_CELLS;

public class BiowareCellsChain {

    public static void init() {
        retinol();
        b27Supplement();
        bacteriaCultures();
        sulfanilamide();
        growthMedium();
        biocells();
    }

    private static void retinol() {
        // CH3OH + O -> CH2O + H2O
        CHEMICAL_RECIPES.recipeBuilder()
                .input(OrePrefix.dustTiny, Silver)
                .fluidInputs(Methanol.getFluid(1000))
                .fluidInputs(Oxygen.getFluid(1000))
                .fluidOutputs(Formaldehyde.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .duration(320).EUt(VA[HV]).buildAndRegister();

        // CH2O + C2H2 -> C3H4O
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Formaldehyde.getFluid(1000))
                .fluidInputs(Acetylene.getFluid(1000))
                .notConsumable(dust, Copper)
                .fluidOutputs(PropargylAlcohol.getFluid(1000))
                .duration(100).EUt(VA[HV]).buildAndRegister();

        // C3H4O + Cl -> C3H3Cl + HClO
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(PropargylAlcohol.getFluid(1000))
                .fluidInputs(Chlorine.getFluid(1000))
                .fluidOutputs(PropargylChloride.getFluid(1000))
                .fluidOutputs(HypochlorousAcid.getFluid(1000))
                .duration(100).EUt(VA[HV]).buildAndRegister();

        // C10H16 -> C10H16
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Turpentine.getFluid(1000))
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .fluidOutputs(BetaPinene.getFluid(1000))
                .fluidOutputs(DilutedSulfuricAcid.getFluid(1000))
                .duration(100).EUt(VA[HV]).buildAndRegister();

        // TODO Citral Route from Crops
        // TODO This recipe conflicts with Isoprene + Oxygen -> Raw Rubber
        // C10H16 + 2C5H8 + 2O -> 2C10H16O
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(BetaPinene.getFluid(1000))
                .fluidInputs(Isoprene.getFluid(2000))
                .fluidInputs(Oxygen.getFluid(2000))
                .fluidOutputs(Citral.getFluid(2000))
                .duration(160).EUt(VA[IV]).buildAndRegister();

        // C3H6O + C10H16O -> C13H20O + H2O
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Acetone.getFluid(1000))
                .fluidInputs(Citral.getFluid(1000))
                .notConsumable(dust, Quicklime)
                .fluidOutputs(BetaIonone.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .duration(80).EUt(VA[IV]).buildAndRegister();

        // 3C3H3Cl + C13H20O + 4H -> C20H30O + 2C + 3HCl
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(PropargylChloride.getFluid(3000))
                .fluidInputs(BetaIonone.getFluid(1000))
                .fluidInputs(Hydrogen.getFluid(4000))
                .output(dust, Carbon, 2)
                .fluidOutputs(Retinol.getFluid(1000))
                .fluidOutputs(HydrochloricAcid.getFluid(3000))
                .duration(100).EUt(VA[ZPM]).buildAndRegister();
    }

    private static void b27Supplement() {
        EXTRACTOR_RECIPES.recipeBuilder()
                .input(dust, Meat)
                .fluidOutputs(Blood.getFluid(1000))
                .duration(100).EUt(VA[ULV]).buildAndRegister();

        BREWING_RECIPES.recipeBuilder()
                .fluidInputs(Blood.getFluid(5000))
                .input(dust, EthylenediaminetetraaceticAcid)
                .fluidOutputs(NonCoagulatingBlood.getFluid(5000))
                .duration(400).EUt(VA[HV]).buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(NonCoagulatingBlood.getFluid(5000))
                .fluidOutputs(Catalase.getFluid(1000))
                .fluidOutputs(BasicFibroblastGrowthFactor.getFluid(1000))
                .fluidOutputs(EpidermalGrowthFactor.getFluid(1000))
                .chancedOutput(dustTiny, Iron, 100, 0)
                .duration(400).EUt(VA[HV]).buildAndRegister();

        BIO_VAT_RECIPES.recipeBuilder()
                .notConsumable(CUPRIAVIDUS_NECATOR)
                .fluidInputs(Nitrogen.getFluid(1000))
                .fluidInputs(Hydrogen.getFluid(1000))
                .input(dust, Sugar, 4)
                .fluidOutputs(Biotin.getFluid(1000))
                .duration(40).EUt(VA[HV]).buildAndRegister();

        BIO_VAT_RECIPES.recipeBuilder()
                .notConsumable(ULTRASONIC_HOMOGENZIER)
                .input(dust, Yeast)
                .fluidOutputs(LinoleicAcid.getFluid(1000))
                .duration(100).EUt(VA[HV]).buildAndRegister();

        BIO_VAT_RECIPES.recipeBuilder()
                .fluidInputs(Biotin.getFluid(1000))
                .fluidInputs(LinoleicAcid.getFluid(1000))
                .fluidInputs(Retinol.getFluid(1000))
                .fluidInputs(Catalase.getFluid(1000))
                .fluidOutputs(B27Supplement.getFluid(4000))
                .duration(200).EUt(VA[LuV]).buildAndRegister();
    }

    private static void bacteriaCultures() {
        AUTOCLAVE_RECIPES.recipeBuilder()
                .input(PETRI_DISH)
                .fluidInputs(Ethanol.getFluid(1000))
                .output(STERILE_PETRI_DISH)
                .duration(200).EUt(VA[IV]).buildAndRegister();

        CANNER_RECIPES.recipeBuilder()
                .input(dust, Agar, 2)
                .input(STERILE_PETRI_DISH)
                .output(CLEAN_CULTURE)
                .duration(100).EUt(VA[HV]).buildAndRegister();

        BIO_VAT_RECIPES.recipeBuilder()
                .inputs(new ItemStack(Blocks.DIRT, 1, 1))
                .input(CLEAN_CULTURE)
                .fluidInputs(SterileGrowthMedium.getFluid(1000))
                .chancedOutput(CUPRIAVIDUS_NECATOR, 500, 100)
                .fluidOutputs(BacterialSludge.getFluid(100))
                .duration(100).EUt(VA[UV]).buildAndRegister();

        BIO_VAT_RECIPES.recipeBuilder()
                .notConsumable(CUPRIAVIDUS_NECATOR)
                .input(CLEAN_CULTURE)
                .fluidInputs(SterileGrowthMedium.getFluid(100))
                .output(CUPRIAVIDUS_NECATOR)
                .fluidOutputs(BacterialSludge.getFluid(100))
                .duration(100).EUt(VA[HV]).buildAndRegister();

        BIO_VAT_RECIPES.recipeBuilder()
                .inputs(new ItemStack(Blocks.DIRT, 1, 0))
                .input(CLEAN_CULTURE)
                .fluidInputs(SterileGrowthMedium.getFluid(1000))
                .chancedOutput(BREVIBACTERIUM_FLAVUM, 500, 100)
                .fluidOutputs(BacterialSludge.getFluid(100))
                .duration(100).EUt(VA[UV]).buildAndRegister();

        BIO_VAT_RECIPES.recipeBuilder()
                .notConsumable(BREVIBACTERIUM_FLAVUM)
                .fluidInputs(SterileGrowthMedium.getFluid(100))
                .output(BREVIBACTERIUM_FLAVUM)
                .input(CLEAN_CULTURE)
                .fluidOutputs(BacterialSludge.getFluid(100))
                .duration(100).EUt(VA[HV]).buildAndRegister();

        MACERATOR_RECIPES.recipeBuilder()
                .inputs(new ItemStack(Items.APPLE))
                .chancedOutput(dust, Yeast, 500, 2500)
                .duration(100).EUt(VA[IV]).buildAndRegister();

        BIO_VAT_RECIPES.recipeBuilder()
                .notConsumable(dust, Yeast)
                .fluidInputs(SterileGrowthMedium.getFluid(100))
                .output(dust, Yeast, 8)
                .fluidOutputs(BacterialSludge.getFluid(100))
                .duration(100).EUt(VA[HV]).buildAndRegister();
    }

    private static void sulfanilamide() {
        // C6H5NO2 + 6H -> C6H5NH2 + 2H2O
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Nitrobenzene.getFluid(1000))
                .fluidInputs(Hydrogen.getFluid(6000))
                .notConsumable(dust, Platinum)
                .fluidOutputs(Aniline.getFluid(1000))
                .fluidOutputs(Water.getFluid(2000))
                .duration(200).EUt(VA[HV]).buildAndRegister();

        // C6H6O + NH3 -> C6H5NH2 + H2O
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Phenol.getFluid(1000))
                .fluidInputs(Ammonia.getFluid(1000))
                .notConsumable(dust, Platinum)
                .fluidOutputs(Aniline.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .duration(200).EUt(VA[HV]).buildAndRegister();

        // HCl + SO3 -> HClSO3
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(HydrochloricAcid.getFluid(1000))
                .fluidInputs(SulfurTrioxide.getFluid(1000))
                .fluidOutputs(ChlorosulfuricAcid.getFluid(1000))
                .duration(80).EUt(VA[LV]).buildAndRegister();

        // CH3CO2CH3 + CO -> (CH3CO)2O
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(MethylAcetate.getFluid(1000))
                .fluidInputs(CarbonMonoxide.getFluid(1000))
                .fluidOutputs(AceticAnhydride.getFluid(1000))
                .duration(80).EUt(VA[LV]).buildAndRegister();

        // C2H2O2 + CH3COOH -> (CH3CO)2O
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Ethenone.getFluid(1000))
                .fluidInputs(AceticAcid.getFluid(1000))
                .fluidOutputs(AceticAnhydride.getFluid(1000))
                .duration(80).EUt(VA[LV]).buildAndRegister();

        // (CH3CO)2O -> C2H2O2 + CH3COOH
        CHEMICAL_RECIPES.recipeBuilder()
                .notConsumable(new IntCircuitIngredient(1))
                .fluidInputs(AceticAnhydride.getFluid(1000))
                .fluidOutputs(Ethenone.getFluid(1000))
                .fluidOutputs(AceticAcid.getFluid(1000))
                .duration(80).EUt(VA[LV]).buildAndRegister();

        // C6H5NH2 + (CH3CO)2O + HSO3Cl -> C8H8ClNO3S + H2O + CH3COOH
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Aniline.getFluid(1000))
                .fluidInputs(AceticAnhydride.getFluid(1000))
                .fluidInputs(ChlorosulfuricAcid.getFluid(1000))
                .fluidOutputs(AcetylsulfanilylChloride.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .fluidOutputs(AceticAcid.getFluid(1000))
                .duration(200).EUt(VA[HV]).buildAndRegister();

        // Na2CO3 + CO2 + H2O -> 2NaHCO3
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, SodaAsh, 6)
                .fluidInputs(CarbonDioxide.getFluid(1000))
                .fluidInputs(Water.getFluid(1000))
                .output(dust, SodiumBicarbonate, 12)
                .duration(80).EUt(VA[LV]).buildAndRegister();

        // NaCl + CO2 + H2O + NH3 -> NaHCO3 + NH4Cl
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Salt, 2)
                .fluidInputs(CarbonDioxide.getFluid(1000))
                .fluidInputs(Water.getFluid(1000))
                .fluidInputs(Ammonia.getFluid(1000))
                .output(dust, SodiumBicarbonate, 12)
                .output(dust, AmmoniumChloride, 6)
                .duration(80).EUt(VA[LV]).buildAndRegister();

        // NaHCO3 + C8H8ClNO3S + NH3 -> NaCl + C6H8N2O2S + CO2 + CH3COOH
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, SodiumBicarbonate, 6)
                .fluidInputs(AcetylsulfanilylChloride.getFluid(1000))
                .fluidInputs(Ammonia.getFluid(1000))
                .output(dust, Salt, 2)
                .fluidOutputs(Sulfanilamide.getFluid(1000))
                .fluidOutputs(CarbonDioxide.getFluid(1000))
                .fluidOutputs(AceticAcid.getFluid(1000))
                .duration(200).EUt(VA[IV]).buildAndRegister();
    }

    private static void growthMedium() {
        // NH3 + HNO3 -> NH4NO3
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Ammonia.getFluid(1000))
                .fluidInputs(NitricAcid.getFluid(1000))
                .output(dust, AmmoniumNitrate, 2)
                .duration(100).EUt(VA[LV]).buildAndRegister();

        BIO_VAT_RECIPES.recipeBuilder()
                .notConsumable(BREVIBACTERIUM_FLAVUM)
                .fluidInputs(Ammonia.getFluid(1000))
                .fluidInputs(DistilledWater.getFluid(1000))
                .output(dust, Glutamine)
                .duration(100).EUt(VA[HV]).buildAndRegister();

        BIO_VAT_RECIPES.recipeBuilder()
                .input(dust, AmmoniumNitrate, 2)
                .input(dust, Glutamine)
                .fluidInputs(B27Supplement.getFluid(1000))
                .fluidInputs(BasicFibroblastGrowthFactor.getFluid(1000))
                .fluidInputs(EpidermalGrowthFactor.getFluid(1000))
                .fluidInputs(Bacteria.getFluid(1000))
                .fluidOutputs(RawEvolutionaryMedium.getFluid(4000))
                .duration(1200).EUt(VA[UV]).buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(RawEvolutionaryMedium.getFluid(4000))
                .fluidInputs(Sulfanilamide.getFluid(1000))
                .fluidOutputs(EvolutionaryMedium.getFluid(5000))
                .duration(400).EUt(VA[UV]).buildAndRegister();

        BIO_VAT_RECIPES.recipeBuilder()
                .notConsumable(STEM_CELLS)
                .fluidInputs(SterileGrowthMedium.getFluid(500))
                .output(STEM_CELLS, 64)
                .fluidOutputs(BacterialSludge.getFluid(500))
                .duration(100).EUt(VA[HV]).buildAndRegister();

        BIO_VAT_RECIPES.recipeBuilder()
                .input(dust, Salt, 4)
                .input(dust, Calcium, 4)
                .input(dust, Agar, 4)
                .fluidInputs(Mutagen.getFluid(4000))
                .fluidOutputs(RawGrowthMedium.getFluid(5000))
                .duration(1200).EUt(VA[IV]).buildAndRegister();
    }

    private static void biocells() {
        BIO_VAT_RECIPES.recipeBuilder()
                .input(dust, Naquadria)
                .fluidInputs(Bacteria.getFluid(1000))
                .fluidOutputs(Mutagen.getFluid(1000))
                .duration(100).EUt(VA[IV]).buildAndRegister();

        BIO_VAT_RECIPES.recipeBuilder()
                .input(dust, Naquadria, 16)
                .input(STEM_CELLS, 64)
                .fluidInputs(Mutagen.getFluid(1000))
                .output(RAPIDLY_REPLICATING_CELLS, 64)
                .duration(400).EUt(VA[IV]).buildAndRegister();

        BIO_VAT_RECIPES.recipeBuilder()
                .input(RAPIDLY_REPLICATING_CELLS)
                .fluidInputs(EvolutionaryMedium.getFluid(500))
                .output(SUPERINTELLGENT_ORGANISM)
                .fluidOutputs(BacterialSludge.getFluid(500))
                .duration(600).EUt(VA[ZPM]).buildAndRegister();
    }
}
