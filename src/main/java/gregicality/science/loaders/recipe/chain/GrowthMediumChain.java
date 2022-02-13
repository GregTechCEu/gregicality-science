package gregicality.science.loaders.recipe.chain;

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

public class GrowthMediumChain {

    public static void init() {
        removeGTCERecipes();
        // CEu growth medium will be used for growing bacteria and stem cells
        // gcy growth medium will be used for creating superintelligent organisms for bioware
        retinol();
        b27Supplement();
        growthMedium();
        bacteriaCultures();
    }

    private static void removeGTCERecipes() {

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
                .fluidOutputs(B27Supplement.getFluid(1000))
                .duration(200).EUt(VA[LuV]).buildAndRegister();
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
                .input(dust, Naquadria)
                .fluidInputs(B27Supplement.getFluid(1000))
                .fluidInputs(BasicFibroblastGrowthFactor.getFluid(1000))
                .fluidInputs(EpidermalGrowthFactor.getFluid(1000))
                .fluidInputs(Bacteria.getFluid(1000))
                .fluidOutputs(RawEvolutionaryMedium.getFluid(4000))
                .duration(150).EUt(VA[UV]).buildAndRegister();
    }

    private static void bacteriaCultures() {
        AUTOCLAVE_RECIPES.recipeBuilder()
                .input(PETRI_DISH)
                .fluidInputs(Ethanol.getFluid(100))
                .output(STERILE_PETRI_DISH)
                .duration(200).EUt(VA[IV]).buildAndRegister();

        BIO_VAT_RECIPES.recipeBuilder()
                .inputs(new ItemStack(Blocks.DIRT, 1, 1))
                .input(STERILE_PETRI_DISH)
                .fluidInputs(SterileGrowthMedium.getFluid(1000))
                .chancedOutput(CUPRIAVIDUS_NECATOR, 500, 100)
                .fluidOutputs(BacterialSludge.getFluid(100))
                .duration(100).EUt(VA[UV]).buildAndRegister();

        BIO_VAT_RECIPES.recipeBuilder()
                .notConsumable(CUPRIAVIDUS_NECATOR)
                .fluidInputs(SterileGrowthMedium.getFluid(100))
                .output(CUPRIAVIDUS_NECATOR)
                .fluidOutputs(BacterialSludge.getFluid(10))
                .duration(100).EUt(VA[HV]).buildAndRegister();

        BIO_VAT_RECIPES.recipeBuilder()
                .inputs(new ItemStack(Blocks.DIRT, 1, 0))
                .input(STERILE_PETRI_DISH)
                .fluidInputs(SterileGrowthMedium.getFluid(1000))
                .chancedOutput(BREVIBACTERIUM_FLAVUM, 500, 100)
                .fluidOutputs(BacterialSludge.getFluid(100))
                .duration(100).EUt(VA[UV]).buildAndRegister();

        BIO_VAT_RECIPES.recipeBuilder()
                .notConsumable(BREVIBACTERIUM_FLAVUM)
                .fluidInputs(SterileGrowthMedium.getFluid(100))
                .output(BREVIBACTERIUM_FLAVUM)
                .fluidOutputs(BacterialSludge.getFluid(10))
                .duration(100).EUt(VA[HV]).buildAndRegister();

        MACERATOR_RECIPES.recipeBuilder()
                .inputs(new ItemStack(Items.APPLE))
                .chancedOutput(dust, Yeast, 500, 2500)
                .duration(100).EUt(VA[IV]).buildAndRegister();

        BIO_VAT_RECIPES.recipeBuilder()
                .notConsumable(dust, Yeast)
                .fluidInputs(SterileGrowthMedium.getFluid(100))
                .output(dust, Yeast, 8)
                .fluidOutputs(BacterialSludge.getFluid(10))
                .duration(100).EUt(VA[HV]).buildAndRegister();
    }
}
