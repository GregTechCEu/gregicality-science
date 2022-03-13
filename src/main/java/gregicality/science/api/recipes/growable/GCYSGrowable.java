package gregicality.science.api.recipes.growable;

import gregtech.api.recipes.CountableIngredient;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import javax.annotation.Nullable;
import java.util.ArrayList;

public class GCYSGrowable {
    protected CountableIngredient seed;
    protected ItemStack product;
    protected ItemStack byproduct;
    protected FluidStack waterSource;
    protected FluidStack waste;
    protected AtmosphereType atmosphereType;
    protected boolean boostable;
    protected CountableIngredient soil;
    protected int duration;

    public GCYSGrowable(CountableIngredient seed, ItemStack product, @Nullable ItemStack byproduct, @Nullable FluidStack waterSource, @Nullable FluidStack waste, AtmosphereType atmosphereType, boolean canBeBoosted, CountableIngredient soil, int duration) {
        this.seed = seed;
        this.product = product;
        this.byproduct = byproduct;
        this.waterSource = waterSource;
        this.waste = waste;
        this.atmosphereType = atmosphereType;
        this.boostable = canBeBoosted;
        this.soil = soil;
        this.duration = duration;
    }

    public GCYSGrowable(ItemStack seed, ItemStack product, @Nullable ItemStack byproduct, @Nullable FluidStack waterSource, @Nullable FluidStack waste, AtmosphereType atmosphereType, boolean canBeBoosted, CountableIngredient soil, int duration){
        this(CountableIngredient.from(seed), product, byproduct, waterSource, waste, atmosphereType, canBeBoosted, soil, duration);
    }

    public CountableIngredient getSeed() {
        return seed;
    }

    public ItemStack getProduct() {
        return product;
    }

    @Nullable
    public ItemStack getByproduct() {
        return byproduct;
    }

    @Nullable
    public FluidStack getWaterSource() {
        return waterSource;
    }

    @Nullable
    public FluidStack getWaste() {
        return waste;
    }

    public AtmosphereType getAtmosphereType() {
        return atmosphereType;
    }

    public boolean isBoostable() {
        return boostable;
    }

    public CountableIngredient getSoil() {
        return soil;
    }

    public int getDuration() {
        return duration;
    }
}
