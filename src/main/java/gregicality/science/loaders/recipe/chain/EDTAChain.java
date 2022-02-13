package gregicality.science.loaders.recipe.chain;

import gregtech.api.recipes.ingredients.IntCircuitIngredient;

import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.CHEMICAL_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;

public class EDTAChain {

    public static void init() {
        // C2H4 + 2Cl -> C2H4Cl2
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Ethylene.getFluid(1000))
                .fluidInputs(Chlorine.getFluid(2000))
                .notConsumable(Iron3Chloride.getFluid(1))
                .fluidOutputs(Dichloroethane.getFluid(1000))
                .duration(80).EUt(VA[LV]).buildAndRegister();

        // C2H4Cl2 -> C2H3Cl + HCl
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Dichloroethane.getFluid(1000))
                .notConsumable(new IntCircuitIngredient(1))
                .fluidOutputs(VinylChloride.getFluid(1000))
                .fluidOutputs(HydrochloricAcid.getFluid(1000))
                .duration(40).EUt(VA[ULV]).buildAndRegister();

        // C2H4Cl2 + 2NH3 -> C2H4(NH2)2 + 2HCl
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Dichloroethane.getFluid(1000))
                .fluidInputs(Ammonia.getFluid(2000))
                .fluidOutputs(Ethylenediamine.getFluid(1000))
                .fluidOutputs(HydrochloricAcid.getFluid(2000))
                .duration(80).EUt(VA[HV]).buildAndRegister();

        // CH4 + NH3 + 3O -> HCN + 3H2O
        // TODO This should use 1473K
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Methane.getFluid(1000))
                .fluidInputs(Ammonia.getFluid(1000))
                .fluidInputs(Oxygen.getFluid(1000))
                .notConsumable(dust, Platinum)
                .fluidOutputs(HydrogenCyanide.getFluid(1000))
                .fluidOutputs(Water.getFluid(3000))
                .duration(120).EUt(VA[MV]).buildAndRegister();

        // NaOH + HCN -> NaCN + H2O
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, SodiumHydroxide, 3)
                .fluidInputs(HydrogenCyanide.getFluid(1000))
                .output(dust, SodiumCyanide, 3)
                .fluidOutputs(Water.getFluid(1000))
                .duration(120).EUt(VA[LV]).buildAndRegister();

        // C2H4(NH2)2 + 4CH2O + 4NaCN + 6H2O -> C10H12Na4N2O8 + 4NH3 + 2O
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, SodiumCyanide, 12)
                .fluidInputs(Ethylenediamine.getFluid(1000))
                .fluidInputs(Formaldehyde.getFluid(4000))
                .fluidInputs(Water.getFluid(4000))
                .output(dust, TetrasodiumEDTA)
                .fluidOutputs(Ammonia.getFluid(4000))
                .fluidOutputs(Oxygen.getFluid(2000))
                .duration(120).EUt(VA[HV]).buildAndRegister();

        // C10H12Na4N2O8 + 4 HCl -> C10H16N2O8 + 4NaCl
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, TetrasodiumEDTA)
                .fluidInputs(HydrochloricAcid.getFluid(4000))
                .output(dust, EthylenediaminetetraaceticAcid, 32)
                .output(dust, Salt, 8)
                .duration(100).EUt(VA[IV]).buildAndRegister();
    }
}
