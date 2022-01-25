package gregicality.science.loaders.recipe;

import gregicality.science.common.metatileentities.GCYSMetaTileEntities;
import gregtech.loaders.recipe.CraftingComponent;
import gregtech.loaders.recipe.MetaTileEntityLoader;

public class GCYSMetaTileEntityLoader {

    public static void init() {
        MetaTileEntityLoader.registerMachineRecipe(GCYSMetaTileEntities.DRYER, "WCW", "SHS", "WCW", 'W', CraftingComponent.CABLE, 'C', CraftingComponent.CIRCUIT, 'S', CraftingComponent.SPRING, 'H', CraftingComponent.HULL);
    }
}
