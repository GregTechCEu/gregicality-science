package gregicality.science.loaders.recipe;

import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.api.unification.OreDictUnifier;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregicality.science.api.unification.materials.GCYSMaterials.Orichalcum;
import static gregtech.api.GTValues.LV;
import static gregtech.api.GTValues.VA;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;

public class RecipeConflicts {

    public static void init() {
        chemistryConflicts();
        mixerConflicts();
    }

    private static void chemistryConflicts() {
        // Conflict between Dichloroethane and Vinyl Chloride
        GTRecipeHandler.removeRecipesByInputs(CHEMICAL_RECIPES, Ethylene.getFluid(1000), Chlorine.getFluid(2000));
        GTRecipeHandler.removeRecipesByInputs(LARGE_CHEMICAL_RECIPES, Ethylene.getFluid(1000), Chlorine.getFluid(2000));
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Ethylene.getFluid(1000))
                .fluidInputs(Chlorine.getFluid(2000))
                .notConsumable(new IntCircuitIngredient(1))
                .fluidOutputs(VinylChloride.getFluid(1000))
                .fluidOutputs(HydrochloricAcid.getFluid(1000))
                .duration(160).EUt(VA[LV]).buildAndRegister();

        // Conflict between 2-Ethylanthraquinone and Styrene
        GTRecipeHandler.removeRecipesByInputs(CHEMICAL_RECIPES, Ethylbenzene.getFluid(1000));
        GTRecipeHandler.removeRecipesByInputs(LARGE_CHEMICAL_RECIPES, Ethylbenzene.getFluid(1000));
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Ethylbenzene.getFluid(1000))
                .notConsumable(dust, Hematite)
                .fluidOutputs(Styrene.getFluid(1000))
                .fluidOutputs(Hydrogen.getFluid(1000))
                .duration(30).EUt(VA[LV]).buildAndRegister();

        // Conflict between Potassium Hydroxide and Rock Salt Electrolysis
        ELECTROLYZER_RECIPES.recipeBuilder()
                .input(dust, RockSalt, 2)
                .notConsumable(new IntCircuitIngredient(1))
                .output(dust, Potassium)
                .fluidOutputs(Chlorine.getFluid(1000))
                .duration(72).EUt(VA[LV]).buildAndRegister();
    }

    private static void mixerConflicts() {
        // Fix orichalcum replacment for ruthenium trinium neutronate
        GTRecipeHandler.removeRecipesByInputs(MIXER_RECIPES,
                new ItemStack[]{OreDictUnifier.get(dust, Ruthenium), OreDictUnifier.get(dust, Trinium, 2),
                        OreDictUnifier.get(dust, Americium), OreDictUnifier.get(dust, Orichalcum, 2),
                        IntCircuitIngredient.getIntegratedCircuit(4)},
                new FluidStack[]{Oxygen.getFluid(8000)});
    }
}
