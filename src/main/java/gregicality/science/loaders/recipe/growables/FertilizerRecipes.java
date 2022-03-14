package gregicality.science.loaders.recipe.growables;

import gregicality.science.api.unification.materials.GCYSMaterials;
import gregtech.api.recipes.CountableIngredient;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.common.items.MetaItems;

import java.util.ArrayList;

public class FertilizerRecipes {

    public static ArrayList<CountableIngredient> NitrogenFertilizers = new ArrayList<CountableIngredient>();
    public static ArrayList<CountableIngredient> PhosphateFertilizers = new ArrayList<CountableIngredient>();
    public static ArrayList<CountableIngredient> PotassiumFertilizers = new ArrayList<CountableIngredient>();

    public static void fillArrays(){
        NitrogenFertilizers.add(CountableIngredient.from(OrePrefix.dust, GCYSMaterials.AmmoniumNitrate, 1));

        PhosphateFertilizers.add(CountableIngredient.from(OrePrefix.dust, Materials.TricalciumPhosphate, 1));

        PotassiumFertilizers.add(CountableIngredient.from(OrePrefix.dust, GCYSMaterials.PotassiumSulfate, 1));
        PotassiumFertilizers.add(CountableIngredient.from(OrePrefix.dust, Materials.Potash, 2));
    }

    public static void init(){
        fillArrays();
        for(CountableIngredient i : NitrogenFertilizers){
            for(CountableIngredient j : PhosphateFertilizers){
                for(CountableIngredient k : PotassiumFertilizers){
                    RecipeMaps.MIXER_RECIPES.recipeBuilder()
                            .inputs(i)
                            .inputs(j)
                            .inputs(k)
                            .outputs(MetaItems.FERTILIZER.getStackForm(i.getCount() + j.getCount() + k.getCount()))
                            .duration(20)
                            .EUt(20)
                            .buildAndRegister();
                }
            }
        }
    }
}
