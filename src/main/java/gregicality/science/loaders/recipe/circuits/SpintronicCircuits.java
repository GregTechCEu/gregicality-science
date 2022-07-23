package gregicality.science.loaders.recipe.circuits;

import static gregicality.science.api.unification.materials.GCYSMaterials.PlutoniumPhosphide;
import static gregicality.science.common.items.GCYSMetaItems.MAGNETORESTRICTIVE_MEMORY;
import static gregtech.api.GTValues.UEV;
import static gregtech.api.GTValues.VA;
import static gregtech.api.recipes.RecipeMaps.FORMING_PRESS_RECIPES;
import static gregtech.api.unification.material.Materials.Magnesia;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static gregtech.api.unification.ore.OrePrefix.plate;

public class SpintronicCircuits {

    public static void init() {
        mram();
    }

    private static void mram() {
        FORMING_PRESS_RECIPES.recipeBuilder()
                .input(plate, PlutoniumPhosphide, 2)
                .input(dust, Magnesia)
                .output(MAGNETORESTRICTIVE_MEMORY)
                .duration(200).EUt(VA[UEV]).buildAndRegister();
    }
}
