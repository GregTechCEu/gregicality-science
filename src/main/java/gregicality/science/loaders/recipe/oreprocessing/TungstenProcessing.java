package gregicality.science.loaders.recipe.oreprocessing;

import gregicality.science.api.recipes.GCYSRecipeMaps;
import gregicality.science.common.GCYSConfigHolder;
import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.OreDictUnifier;

import static gregicality.science.api.unification.materials.GCYSMaterials.TungstenTrioxide;
import static gregtech.api.GTValues.EV;
import static gregtech.api.GTValues.VA;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static gregtech.api.unification.ore.OrePrefix.ingotHot;

/**
 * The Tungsten Process
 *
 * <p>
 * Adds extra steps for making Tungsten
 * </p>
 *
 * <p>Main Products: Tungsten</p>
 * <p>Side Products: None</p>
 *
 * <p>Does not modify the original CEu product yields</p>
 */
public class TungstenProcessing {

    public static void init() {
        tungstenChain();
        if (GCYSConfigHolder.chainOverrides.disableTungstenProcessing)
            removeGTCERecipes();
    }

    private static void removeGTCERecipes() {
        // Remove Tungstic Acid -> Tungsten
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ELECTROLYZER_RECIPES, OreDictUnifier.get(dust, TungsticAcid, 7));
    }

    private static void tungstenChain() {
        // H2O(WO3) -> WO3 + H2O
        GCYSRecipeMaps.DRYER_RECIPES.recipeBuilder()
                .input(dust, TungsticAcid, 7)
                .output(dust, TungstenTrioxide, 4)
                .fluidOutputs(Water.getFluid(1000))
                .duration(160).EUt(16).buildAndRegister();

        // 2WO3 + 3C -> 2W + 3CO2
        RecipeMaps.BLAST_RECIPES.recipeBuilder()
                .input(dust, TungstenTrioxide, 8)
                .input(dust, Carbon, 3)
                .output(ingotHot, Tungsten, 2)
                .fluidOutputs(CarbonDioxide.getFluid(3000))
                .blastFurnaceTemp(Tungsten.getBlastTemperature())
                .duration(2400).EUt(VA[EV]).buildAndRegister();

        // WO3 + 6H -> W + 3H2O
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, TungstenTrioxide, 4)
                .fluidInputs(Hydrogen.getFluid(6000))
                .output(dust, Tungsten)
                .fluidOutputs(Water.getFluid(3000))
                .duration(210).EUt(960).buildAndRegister();
    }
}
