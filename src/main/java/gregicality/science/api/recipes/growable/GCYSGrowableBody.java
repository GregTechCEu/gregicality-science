package gregicality.science.api.recipes.growable;

import gregtech.api.recipes.CountableIngredient;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregicality.science.loaders.recipe.growables.AtmosphereTypes.*;

import javax.annotation.Nullable;

public class GCYSGrowableBody extends GCYSGrowable{
    private static final CountableIngredient dirtIngredient = CountableIngredient.from("dirt", 1); //placeholder
    public GCYSGrowableBody(CountableIngredient seed, ItemStack product, @Nullable ItemStack byproduct, @Nullable FluidStack waste, int duration) {
        super(seed, product, byproduct, null, waste, AmnioticFluid, false, dirtIngredient, duration);
    }
}
