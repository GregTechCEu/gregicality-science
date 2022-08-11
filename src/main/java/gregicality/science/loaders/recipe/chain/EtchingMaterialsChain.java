package gregicality.science.loaders.recipe.chain;

import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregtech.api.GTValues.IV;
import static gregtech.api.GTValues.VA;
import static gregtech.api.recipes.RecipeMaps.CHEMICAL_RECIPES;
import static gregtech.api.recipes.RecipeMaps.MIXER_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;

public class EtchingMaterialsChain {

    public static void init() {
        tmah();
        edp();
    }

    private static void tmah() {
        // N(CH3)3 + CH3Cl -> N(CH3)4Cl
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Trimethylamine.getFluid(1000))
                .fluidInputs(Chloromethane.getFluid(1000))
                .notConsumable(Ethanol.getFluid(4000))
                .output(dust, TetramethylammoniumChloride, 6)
                .duration(200).EUt(VA[IV]).buildAndRegister();

        // N(CH3)4Cl + KOH -> N(CH3)4OH + KCl
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, TetramethylammoniumChloride, 6)
                .input(dust, PotassiumHydroxide, 3)
                .fluidInputs(Water.getFluid(5000))
                .output(dust, RockSalt, 2)
                .fluidOutputs(TetramethylammoniumHydroxide.getFluid(5000))
                .duration(200).EUt(VA[IV]).buildAndRegister();
    }

    private static void edp() {
        // C6H5OH + H2O2 → C6H4(OH)2 + H2O
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Phenol.getFluid(1000))
                .fluidInputs(HydrogenPeroxide.getFluid(1000))
                .output(dust, Pyrocatechol, 12)
                .fluidOutputs(Water.getFluid(1000))
                .duration(200).EUt(VA[IV]).buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dust, Pyrocatechol, 3)
                .fluidInputs(DistilledWater.getFluid(500))
                .fluidInputs(Ethylenediamine.getFluid(500))
                .fluidOutputs(EDP.getFluid(1000))
                .duration(200).EUt(VA[IV]).buildAndRegister();
    }
}
