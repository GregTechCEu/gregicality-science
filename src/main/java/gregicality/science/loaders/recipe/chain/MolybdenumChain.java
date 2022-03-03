package gregicality.science.loaders.recipe.chain;

import gregicality.science.common.GCYSConfigHolder;
import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.OreDictUnifier;

import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregtech.api.GTValues.EV;
import static gregtech.api.GTValues.VA;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;

public class MolybdenumChain {

    public static void init(){
        // MoS2 + 7O -> MoO3 + 2SO2
        RecipeMaps.BLAST_RECIPES.recipeBuilder()
                .input(dust, Molybdenite, 3)
                .fluidInputs(Oxygen.getFluid(7000))
                .output(dust, MolybdenumTrioxide, 4)
                .fluidOutputs(SulfurDioxide.getFluid(2000))
                .blastFurnaceTemp(1400)
                .duration(2000)
                .EUt(VA[MV])
                .buildAndRegister();

        // MoO3 + 6H -> Mo + 3H2O
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, MolybdenumTrioxide, 4)
                .fluidInputs(Hydrogen.getFluid(6000))
                .output(dust, Molybdenum)
                .fluidOutputs(Water.getFluid(3000))
                .duration(200)
                .EUt(VA[HV])
                .buildAndRegister();

        //CaMoO4 + 2HCl -> MoO3 + H2O + CaCl2
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Powellite, 6)
                .fluidInputs(HydrochloricAcid.getFluid(2000))
                .output(dust, MolybdenumTrioxide, 4)
                .output(dust, CalciumChloride, 3)
                .fluidOutputs(Water.getFluid(1000))
                .duration(200)
                .EUt(200)
                .buildAndRegister();

        //PbMoO4 + 2HCl -> MoO3 + H2O + PbCl2
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Wulfenite, 6)
                .fluidInputs(HydrochloricAcid.getFluid(2000))
                .output(dust, MolybdenumTrioxide, 4)
                .output(dust, LeadChloride, 3)
                .fluidOutputs(Water.getFluid(1000))
                .duration(200)
                .EUt(200)
                .buildAndRegister();
    }
}
