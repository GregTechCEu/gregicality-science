package gregicality.science.loaders.recipe.chain;

import gregtech.api.unification.ore.OrePrefix;

import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.CHEMICAL_RECIPES;
import static gregtech.api.recipes.RecipeMaps.LARGE_CHEMICAL_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;

public class GrowthMediumChain {

    public static void init() {
        removeGTCERecipes();
        // CEu growth medium will be used for growing bacteria and stem cells
        // gcy growth medium will be used for creating superintelligent organisms for bioware
        vitaminA();
    }

    private static void removeGTCERecipes() {

    }

    private static void vitaminA() {
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
}
