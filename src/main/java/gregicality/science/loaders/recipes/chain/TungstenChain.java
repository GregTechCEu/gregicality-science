package gregicality.science.loaders.recipes.chain;

import static gregicality.science.api.GCYSMaterials.TungstenHexachloride;
import static gregicality.science.api.GCYSMaterials.TungstenTrioxide;
import static gregtech.api.recipes.RecipeMaps.CHEMICAL_RECIPES;
import static gregtech.api.recipes.RecipeMaps.EXTRACTOR_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;

public class TungstenChain { //todo

    public static void init() {

        // H2WO4 -> WO3 + H2O
        EXTRACTOR_RECIPES.recipeBuilder()
                .input(dust, TungsticAcid, 7)
                .output(dust, TungstenTrioxide, 4)
                .fluidOutputs(Water.getFluid(1000))
                .EUt(120)
                .duration(150)
                .buildAndRegister();

        // WO3 + 6H -> W + 3H2O
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, TungstenTrioxide, 4)
                .fluidInputs(Hydrogen.getFluid(6000))
                .output(dust, Tungsten)
                .fluidOutputs(Water.getFluid(3000))
                .EUt(1920)
                .duration(65)
                .buildAndRegister();

        // W + 6Cl -> WCl6
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Tungsten)
                .fluidInputs(Chlorine.getFluid(6000))
                .output(dust, TungstenHexachloride, 7)
                .duration(120)
                .EUt(120)
                .buildAndRegister();

        // WCl6 + CH4 + 2H -> WC + 6HCl
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, TungstenHexachloride, 7)
                .fluidInputs(Methane.getFluid(1000))
                .fluidInputs(Hydrogen.getFluid(2000))
                .output(dust, TungstenCarbide, 2)
                .fluidOutputs(HydrochloricAcid.getFluid(6000))
                .EUt(480)
                .duration(100)
                .buildAndRegister();
    }
}
