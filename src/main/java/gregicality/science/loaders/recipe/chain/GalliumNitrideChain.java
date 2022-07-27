package gregicality.science.loaders.recipe.chain;

import static gregicality.science.api.recipes.GCYSRecipeMaps.CVD_RECIPES;
import static gregicality.science.api.recipes.GCYSRecipeMaps.DRYER_RECIPES;
import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.CHEMICAL_BATH_RECIPES;
import static gregtech.api.recipes.RecipeMaps.CHEMICAL_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static gregtech.api.unification.ore.OrePrefix.plate;

public class GalliumNitrideChain {

    public static void init() {
        // Al + 3Na + 3CH3Cl -> 0.5 Al2(CH3)6 + 3NaCl
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Aluminium)
                .input(dust, Sodium, 3)
                .fluidInputs(Chloromethane.getFluid(3000))
                .fluidOutputs(Trimethylaluminium.getFluid(500))
                .output(dust, Salt, 6)
                .duration(150).EUt(VA[EV]).buildAndRegister();

        // Ga + 3Cl -> GaCl3
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Gallium)
                .fluidInputs(Chlorine.getFluid(3000))
                .output(dust, GalliumTrichloride, 4)
                .duration(100).EUt(VA[LV]).buildAndRegister();

        // GaCl3 + 0.5 Al2(CH3)6 -> Ga(CH3)3 + AlCl3
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, GalliumTrichloride, 4)
                .fluidInputs(Trimethylaluminium.getFluid(500))
                .output(dust, AluminiumTrichloride, 4)
                .fluidOutputs(Trimethylgallium.getFluid(1000))
                .duration(300).EUt(VA[HV]).buildAndRegister();

        // AlCl3 + 3H2O -> Al(OH)3 + 3HCl
        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, AluminiumTrichloride, 4)
                .fluidInputs(Water.getFluid(3000))
                .output(dust, AluminiumHydroxide, 7)
                .fluidOutputs(HydrochloricAcid.getFluid(3000))
                .duration(60).EUt(VA[LV]).buildAndRegister();

        // 2Al(OH)3 -> Al2O3 + 3H2O
        DRYER_RECIPES.recipeBuilder()
                .input(dust, AluminiumHydroxide, 14)
                .output(dust, Alumina, 5)
                .fluidOutputs(Water.getFluid(3000))
                .duration(60).EUt(16).buildAndRegister();

        // 2Ga(CH3)3 + 3H2O -> Ga2O3 + 3CH4 + 3H (H lost)
        CVD_RECIPES.recipeBuilder()
                .input(plate, Sapphire)
                .fluidInputs(Trimethylgallium.getFluid(2000))
                .fluidInputs(Water.getFluid(3000))
                .output(dust, GalliumTrioxide, 5)
                .fluidOutputs(Methane.getFluid(3000))
                .temperature(923)
                .duration(160).EUt(VA[HV]).buildAndRegister();

        // Ga2O3 + 2NH3 -> 2GaN + 3H2O
        CVD_RECIPES.recipeBuilder()
                .fluidInputs(GalliumTrioxide.getFluid(L * 5))
                .fluidInputs(Ammonia.getFluid(2000))
                .output(plate, GalliumNitride, 4)
                .fluidOutputs(Steam.getFluid(3000))
                .temperature(1023).pressure(10_132_500)
                .duration(250).EUt(VA[LuV]).buildAndRegister();
    }
}
