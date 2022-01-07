package gregicality.science.loaders.recipes.chain;

import gregtech.api.recipes.ingredients.IntCircuitIngredient;

import static gregicality.science.api.GCYSMaterials.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;

public class NaquadahChain {

    public static void init() { //todo

        // Nq + 2[HNO3 + HCl] -> Naquadric Solution [Nq + NO2] + [H2O + HNO3] + HCl + Cl
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, NaquadricCompound)
                .fluidInputs(AquaRegia.getFluid(4000))
                .fluidOutputs(NaquadricSolution.getFluid(1000))
                .fluidOutputs(DiluteNitricAcid.getFluid(2000))
                .fluidOutputs(HydrochloricAcid.getFluid(1000))
                .fluidOutputs(Chlorine.getFluid(1000))
                .EUt(480)
                .duration(100)
                .buildAndRegister();

        // SbF3 + 2F = SbF5
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, AntimonyTrifluoride, 4)
                .fluidInputs(Fluorine.getFluid(2000))
                .fluidOutputs(AntimonyPentafluoride.getFluid(1000))
                .EUt(480)
                .duration(100)
                .buildAndRegister();

        // SbF5 + 2HF = H2SbF7
        CHEMICAL_RECIPES.recipeBuilder()
                .notConsumable(new IntCircuitIngredient(0))
                .fluidInputs(AntimonyPentafluoride.getFluid(1000))
                .fluidInputs(HydrofluoricAcid.getFluid(2000))
                .fluidOutputs(FluoroantimonicAcid.getFluid(1000))
                .EUt(480)
                .duration(200)
                .buildAndRegister();

        // Naquadric Solution [Nq + NO2] + H2SbF7 = SbF3 + Fluoronaquadric Acid [H2NqF4] + NO2
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(NaquadricSolution.getFluid(1000))
                .fluidInputs(FluoroantimonicAcid.getFluid(1000))
                .output(dust, AntimonyTrifluoride, 4)
                .fluidOutputs(FluoronaquadricAcid.getFluid(1000))
                .fluidOutputs(NitrogenDioxide.getFluid(1000))
                .EUt(480)
                .duration(200)
                .buildAndRegister();

        // Fluoronaquadric Acid [H2NqF4] = 2HF + Naquadah Difluoride [NqF2]
        ELECTROLYZER_RECIPES.recipeBuilder()
                .fluidInputs(FluoronaquadricAcid.getFluid(1000))
                .fluidOutputs(HydrofluoricAcid.getFluid(2000))
                .fluidOutputs(NaquadahDifluoride.getFluid(1000))
                .EUt(7680)
                .duration(100)
                .buildAndRegister();

        // 3 Naquadah Difluoride [NqF2] + 2In = 2InF3 + 3 Naquadah Concentrate [Nq]
        BLAST_RECIPES.recipeBuilder()
                .fluidInputs(NaquadahDifluoride.getFluid(3000))
                .input(dust, Indium, 2)
                .output(dust, IndiumTrifluoride, 8)
                .output(dust, NaquadahConcentrate, 3)
                .EUt(30720)
                .duration(100)
                .blastFurnaceTemp(4500)
                .buildAndRegister();

        // HF + KHSO5 + Nq = H2O + KF + NqSO4
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(HydrofluoricAcid.getFluid(1000))
                .input(dust, PotassiumPeroxymonosulfate, 8)
                .input(dust, NaquadahConcentrate)
                .fluidOutputs(Water.getFluid(1000))
                .output(dust, PotassiumFluoride, 2)
                .fluidOutputs(NaquadahSulfate.getFluid(1000))
                .EUt(480)
                .duration(200)
                .buildAndRegister();

        // NqSO4 + 2H = H2SO4 + Nq
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(NaquadahSulfate.getFluid(1000))
                .fluidInputs(Hydrogen.getFluid(2000))
                .fluidOutputs(SulfuricAcid.getFluid(1000))
                .output(dust, Naquadah)
                .EUt(7680)
                .duration(200)
                .buildAndRegister();

        // 2InF3 + 3H2O = In2O3 + 6HF
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, IndiumTrifluoride, 8)
                .fluidInputs(Water.getFluid(3000))
                .output(dust, IndiumTrioxide, 5)
                .fluidOutputs(HydrofluoricAcid.getFluid(6000))
                .EUt(480)
                .duration(200)
                .buildAndRegister();

        // In2O3 + 3C = 2In + 3CO
        BLAST_RECIPES.recipeBuilder()
                .input(dust, IndiumTrioxide, 5)
                .input(dust, Carbon, 3)
                .output(dust, Indium, 2)
                .fluidOutputs(CarbonMonoxide.getFluid(3000))
                .EUt(480)
                .duration(100)
                .blastFurnaceTemp(4500)
                .buildAndRegister();
    }
}
