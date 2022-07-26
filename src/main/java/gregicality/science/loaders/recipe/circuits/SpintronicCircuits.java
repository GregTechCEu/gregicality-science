package gregicality.science.loaders.recipe.circuits;

import static gregicality.science.api.unification.materials.GCYSMaterials.Lithium6;
import static gregicality.science.api.unification.materials.GCYSMaterials.PlutoniumPhosphide;
import static gregicality.science.common.items.GCYSMetaItems.SPIN_TRANSFER_TORQUE_MEMORY;
import static gregtech.api.GTValues.UEV;
import static gregtech.api.GTValues.VA;
import static gregtech.api.recipes.RecipeMaps.FORMING_PRESS_RECIPES;
import static gregtech.api.unification.ore.OrePrefix.foil;
import static gregtech.api.unification.ore.OrePrefix.plate;

public class SpintronicCircuits {

    public static void init() {
        sttram();
    }

    private static void sttram() {
        FORMING_PRESS_RECIPES.recipeBuilder()
                .input(plate, PlutoniumPhosphide)
                .input(foil, Lithium6)
                .output(SPIN_TRANSFER_TORQUE_MEMORY)
                .duration(200).EUt(VA[UEV]).buildAndRegister();
    }
}
