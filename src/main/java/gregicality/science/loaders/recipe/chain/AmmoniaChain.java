package gregicality.science.loaders.recipe.chain;

import gregicality.science.common.GCYSConfigHolder;
import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregicality.science.api.unification.materials.GCYSMaterials.RichAmmoniaMixture;
import static gregicality.science.api.unification.materials.GCYSMaterials.RichNitrogenMixture;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.BREWING_RECIPES;
import static gregtech.api.recipes.RecipeMaps.CHEMICAL_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;

public class AmmoniaChain {

    public static void init() {
        // Minimized Haber-Bosch Process

        // CH4 + N -> CH4N
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Methane.getFluid(1000))
                .fluidInputs(Air.getFluid(1000))
                .fluidInputs(Steam.getFluid(960))
                .fluidOutputs(RichNitrogenMixture.getFluid(2000))
                .duration(80).EUt(VA[MV]).buildAndRegister();

        // CH4N + 2H2O -> NH4 + CH4 + O2 (lossy)
        CHEMICAL_RECIPES.recipeBuilder()
                .notConsumable(dust, GCYSConfigHolder.chainOverrides.disableAmmoniaProcessing ? Chrome : Ruthenium)
                .fluidInputs(RichNitrogenMixture.getFluid(2000))
                .fluidInputs(Water.getFluid(1000))
                .fluidOutputs(RichAmmoniaMixture.getFluid(GCYSConfigHolder.chainOverrides.disableAmmoniaProcessing ? 1000 : 3000))
                .fluidOutputs(Methane.getFluid(1000))
                .duration(80).EUt(VA[MV]).buildAndRegister();

        // NH4 -> NH3 + H (lossy)
        BREWING_RECIPES.recipeBuilder()
                .notConsumable(dust, Magnetite)
                .fluidInputs(RichAmmoniaMixture.getFluid(1000))
                .fluidOutputs(Ammonia.getFluid(1000))
                .duration(160).EUt(VA[LV]).buildAndRegister();

        if (GCYSConfigHolder.chainOverrides.disableAmmoniaProcessing) {
            GTRecipeHandler.removeRecipesByInputs(CHEMICAL_RECIPES,
                    new ItemStack[]{IntCircuitIngredient.getIntegratedCircuit(1)},
                    new FluidStack[]{Nitrogen.getFluid(1000), Hydrogen.getFluid(3000)}
            );
        }
    }
}
