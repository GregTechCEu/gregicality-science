package gregicality.science.loaders.recipe.growables;

import gregicality.science.api.recipes.growable.GCYSGrowable;
import gregtech.api.recipes.CountableIngredient;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreIngredient;

import java.util.ArrayList;
import java.util.HashMap;

public class GCYSGrowables {

    private static final CountableIngredient dirtIngredient = CountableIngredient.from("dirt", 1).setNonConsumable();

    public static final GCYSGrowable Oak = new GCYSGrowable(
            new ItemStack(Blocks.SAPLING, 1, 0),       //seed
            new ItemStack(Blocks.LOG, 8, 0),            //product
            new ItemStack(Blocks.LEAVES, 8, 0),         //byproduct
            Materials.Water.getFluid(1000),                  //water source
            null,                                              //waste
            AtmosphereTypes.Overworld,                               //atmosphere type
            true,                                         //can fertilizer be used to boost growth?
            dirtIngredient,
            200
            );

    public static final GCYSGrowable Spruce = new GCYSGrowable(
            new ItemStack(Blocks.SAPLING, 1, 1),
            new ItemStack(Blocks.LOG, 8, 1),
            new ItemStack(Blocks.LEAVES, 8, 1),
            Materials.Water.getFluid(1000),
            null,
            AtmosphereTypes.Overworld,
            true,
            dirtIngredient,
            200
    );

    public static final GCYSGrowable Birch = new GCYSGrowable(
            new ItemStack(Blocks.SAPLING, 1, 2),
            new ItemStack(Blocks.LOG, 8, 2),
            new ItemStack(Blocks.LEAVES, 8, 2),
            Materials.Water.getFluid(1000),
            null,
            AtmosphereTypes.Overworld,
            true,
            dirtIngredient,
            200
    );

    public static final GCYSGrowable Jungle = new GCYSGrowable(
            new ItemStack(Blocks.SAPLING, 1, 3),
            new ItemStack(Blocks.LOG, 8, 3),
            new ItemStack(Blocks.LEAVES, 8, 3),
            Materials.Water.getFluid(1000),
            null,
            AtmosphereTypes.Overworld,
            true,
            dirtIngredient,
            200
    );

    public static final GCYSGrowable Acacia = new GCYSGrowable(
            new ItemStack(Blocks.SAPLING, 1, 4),
            new ItemStack(Blocks.LOG2, 8, 0),
            new ItemStack(Blocks.LEAVES2, 8, 0),
            Materials.Water.getFluid(1000),
            null,
            AtmosphereTypes.Overworld,
            true,
            dirtIngredient,
            200
    );

    public static final GCYSGrowable DarkOak = new GCYSGrowable(
            new ItemStack(Blocks.SAPLING, 1, 5),
            new ItemStack(Blocks.LOG2, 8, 1),
            new ItemStack(Blocks.LEAVES2, 8, 1),
            Materials.Water.getFluid(1000),
            null,
            AtmosphereTypes.Overworld,
            true,
            dirtIngredient,
            200
    );

    public static HashMap<String, GCYSGrowable> GrowableMap = new HashMap<String, GCYSGrowable>() {{
        put("oak", Oak);
        put("spruce", Spruce);
        put("birch", Birch);
        put("jungle", Jungle);
        put("acacia", Acacia);
        put("dark_oak", DarkOak);
    }};
}
