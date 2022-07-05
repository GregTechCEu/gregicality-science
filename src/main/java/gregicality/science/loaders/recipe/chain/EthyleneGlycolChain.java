package gregicality.science.loaders.recipe.chain;

import static gregicality.science.api.recipes.GCYSRecipeMaps.BURNER_REACTOR_RECIPES;
import static gregicality.science.api.unification.materials.GCYSMaterials.EthyleneGlycol;
import static gregicality.science.api.unification.materials.GCYSMaterials.EthyleneOxide;
import static gregtech.api.GTValues.HV;
import static gregtech.api.GTValues.VA;
import static gregtech.api.recipes.RecipeMaps.LARGE_CHEMICAL_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;

public class EthyleneGlycolChain {

    public static void init() {
        // 7C2H4 + 12O -> 6C2H4O + 2CO2 + 2H2O
        BURNER_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Silver)
                .fluidInputs(Ethylene.getFluid(7000))
                .fluidOutputs(EthyleneOxide.getFluid(6000))
                .fluidOutputs(CarbonDioxide.getFluid(2000))
                .fluidOutputs(Water.getFluid(2000))
                .temperature(450).pressure(2_500_000)
                .duration(150).EUt(VA[HV]).buildAndRegister();

        // The OMEGA Process (simplified)
        // C2H4O + H2O -> C2H6O2
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(EthyleneOxide.getFluid(1000))
                .fluidInputs(DistilledWater.getFluid(1000))
                .fluidInputs(CarbonDioxide.getFluid(100))
                .fluidOutputs(EthyleneGlycol.getFluid(1000))
                .duration(400).EUt(VA[HV]).buildAndRegister();
    }
}
