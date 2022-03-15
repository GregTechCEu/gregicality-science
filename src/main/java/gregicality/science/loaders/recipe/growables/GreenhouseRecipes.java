package gregicality.science.loaders.recipe.growables;

import gregicality.science.api.recipes.GCYSRecipeMaps;
import gregicality.science.api.recipes.growable.GCYSGrowable;
import gregtech.api.recipes.CountableIngredient;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;
import gregtech.common.items.MetaItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import java.util.Map;

import static gregtech.api.GTValues.*;
import static gregicality.science.loaders.recipe.growables.GCYSGrowables.GrowableMap;

public class GreenhouseRecipes {
    public static void init(){
        for(GCYSGrowable growable : GrowableMap.values()){
            for(Map.Entry<FluidStack, Integer> entry : growable.getAtmosphereType().fluidMap.entrySet()){
                FluidStack[] fluidsIn = new FluidStack[]{entry.getKey(), growable.getWaterSource()};
                ItemStack[] outputs = new ItemStack[]{growable.getProduct(), growable.getByproduct()};
                if(growable.isBoostable()){
                    makeRecipeWithStats(growable.getSeed(), growable.getSoil(), fluidsIn, outputs, growable.getWaste(), growable.getDuration()*entry.getValue(), VA[EV], true);
                }
                makeRecipeWithStats(growable.getSeed(), growable.getSoil(), fluidsIn, outputs, growable.getWaste(), 2*growable.getDuration()*entry.getValue(), VA[EV], false);
            }
        }
    }

    private static void makeRecipeWithStats(CountableIngredient seed, CountableIngredient soil, FluidStack[] inputFluids, ItemStack[] outputs, FluidStack waste, int duration, int EUt, boolean boosted) {
        SimpleRecipeBuilder builder = GCYSRecipeMaps.GREENHOUSE_RECIPES.recipeBuilder();
        builder.inputs(seed.setNonConsumable()).inputs(soil.setNonConsumable());
        builder.fluidInputs(inputFluids);
        builder.outputs(outputs);
        if(waste != null){
            builder.fluidOutputs(waste);
        }
        if(boosted){
            builder.inputs(MetaItems.FERTILIZER.getStackForm(1));
        }
        builder.duration(duration);
        builder.EUt(EUt);
        builder.buildAndRegister();
    }
}
