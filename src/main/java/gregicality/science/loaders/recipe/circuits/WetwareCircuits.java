package gregicality.science.loaders.recipe.circuits;

import gregicality.science.api.unification.materials.GCYSMaterials;
import gregtech.api.recipes.GTRecipeHandler;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.AUTOCLAVE_RECIPES;
import static gregtech.api.unification.material.Materials.Neutronium;
import static gregtech.common.items.MetaItems.GRAVI_STAR;
import static gregtech.common.items.MetaItems.QUANTUM_STAR;

public class WetwareCircuits {

    public static void init() {

        GTRecipeHandler.removeRecipesByInputs(AUTOCLAVE_RECIPES,
                new ItemStack[]{QUANTUM_STAR.getStackForm()},
                new FluidStack[]{Neutronium.getFluid(L * 2)});
        AUTOCLAVE_RECIPES.recipeBuilder()
                .input(QUANTUM_STAR)
                .fluidInputs(GCYSMaterials.Orichalcum.getFluid(L * 2))
                .output(GRAVI_STAR)
                .duration(480).EUt(VA[IV]).buildAndRegister();
    }
}
