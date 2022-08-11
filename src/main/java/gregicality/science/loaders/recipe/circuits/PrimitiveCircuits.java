package gregicality.science.loaders.recipe.circuits;

import static gregicality.science.api.recipes.GCYSRecipeMaps.PRESSURE_CHAMBER_RECIPES;
import static gregtech.common.items.MetaItems.GLASS_TUBE;
import static gregtech.common.items.MetaItems.VACUUM_TUBE;

public class PrimitiveCircuits {

    public static void init() {
        //TODO
        PRESSURE_CHAMBER_RECIPES.recipeBuilder()
                .input(GLASS_TUBE)
                .output(VACUUM_TUBE)
                .pressure(13E-5)
                .duration(100).EUt(16).buildAndRegister();
    }
}
