package gregicality.science.loaders.recipe.chain;

import gregicality.science.common.GCYSConfigHolder;
import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.api.unification.ore.OrePrefix;

import static gregicality.science.api.recipes.GCYSRecipeMaps.*;
import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class C4Chains {
    public static void init() {
        butenes();
        butane_12_23_diol();
        butane_14_diol();
        butadiene();
        new_etbe();
    }

    private static void butenes() {
        // Arbitrary output ratios
        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(Butene.getFluid(1000))
                .fluidOutputs(But1ene.getFluid(250))
                .fluidOutputs(But2ene.getFluid(500))
                .fluidOutputs(Isobutene.getFluid(250))
                .duration(160).EUt(2400)
                .buildAndRegister();
    }

    private static void butane_14_diol() {
        // C2H2 + H2CO -> HO-CH2#CH2-OH; HO-CH2-C#C-CH2-OH + 4H -> HO-C4H8-OH
        BURNER_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Acetylene.getFluid(1000))
                .fluidInputs(Formaldehyde.getFluid(2000))
                .fluidInputs(Hydrogen.getFluid(4000))
                .notConsumable(plate, Nickel) //TODO Raney nickel
                .fluidOutputs(Butane14diol.getFluid(1000))
                .pressure(3E8).temperature(360)
                .duration(400).EUt(VA[HV]).buildAndRegister();
    }

    private static void butane_12_23_diol() {
        // C4H8 + H2O + O (OsO4 cat.) -> C4H10O2
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(But1ene.getFluid(1000))
                .fluidInputs(Water.getFluid(1000))
                .fluidInputs(Oxygen.getFluid(1000))
                .notConsumable(dust, OsmiumTetroxide) // TODO Upjohn/Sharpless dihydroxylation
                .fluidOutputs(Butane12diol.getFluid(1000))
                .duration(300).EUt(VA[EV]).buildAndRegister();

        // C4H8 + H2O + O (OsO4 cat.) -> C4H10O2
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(But2ene.getFluid(1000))
                .fluidInputs(Water.getFluid(1000))
                .fluidInputs(Oxygen.getFluid(1000))
                .notConsumable(dust, OsmiumTetroxide) // TODO Upjohn/Sharpless dihydroxylation
                .fluidOutputs(Butane23diol.getFluid(1000))
                .duration(300).EUt(VA[EV]).buildAndRegister();

        // C4H8 + Cl/H2O + NaOH -> C4H8O + NaCl (55% trans-2,3-butene oxide, 30% cis-2,3-butene oxide, and 15% 1,2-butene oxide)
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Butene.getFluid(1000))
                .fluidInputs(Chlorine.getFluid(1000))
                .fluidInputs(Water.getFluid(1000))
                .input(dust, SodiumHydroxide)
                .fluidOutputs(ButeneOxidesMixture.getFluid(1000))
                .output(dust, Salt, 2)
                .duration(400).EUt(VA[EV]).buildAndRegister();

        // C4H8O + H2O -> C4H10O2 (Large excess of H2O)
        BURNER_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(ButeneOxidesMixture.getFluid(1000))
                .fluidInputs(Water.getFluid(8000))
                .fluidOutputs(Butane23diol.getFluid(850))
                .fluidOutputs(Butane12diol.getFluid(150))
                .pressure(5_000_000).temperature(450)
                .duration(300).EUt(VA[EV]).buildAndRegister();
    }

    private static void butadiene() {
        // C4H10O2 (Al2O3 cat.) -> C4H6 + 2 H2O
        BURNER_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Butane14diol.getFluid(1000))
                .notConsumable(dust, Alumina)
                .fluidOutputs(Butadiene.getFluid(1000))
                .fluidOutputs(Steam.getFluid(2000)) // TODO Superheated Steam
                .temperature(625)
                .duration(150).EUt(VA[HV]).buildAndRegister();

        // C4H10O2 (Al2O3 cat.) -> C4H6 + 2 H2O
        BURNER_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Butane23diol.getFluid(1000))
                .notConsumable(dust, Alumina)
                .fluidOutputs(Butadiene.getFluid(1000))
                .fluidOutputs(Steam.getFluid(2000)) // TODO Superheated Steam
                .temperature(625)
                .duration(150).EUt(VA[HV]).buildAndRegister();
    }

    public static void new_etbe() {
        if (GCYSConfigHolder.chainOverrides.disableETBEProcessing) GTRecipeHandler.removeRecipesByInputs(CHEMICAL_RECIPES, Ethanol.getFluid(1000), Butene.getFluid(1000));

        BURNER_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Ethanol.getFluid(1000))
                .fluidInputs(Isobutene.getFluid(1000))
                .fluidOutputs(EthylTertButylEther.getFluid(1000))
                .pressure(1_000_000).temperature(350)
                .duration(400).EUt(VA[HV]).buildAndRegister();
    }
}
