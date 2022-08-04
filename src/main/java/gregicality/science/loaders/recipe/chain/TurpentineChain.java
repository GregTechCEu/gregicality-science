package gregicality.science.loaders.recipe.chain;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.GameRegistry;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.Naphtha;
import static gregtech.api.unification.material.Materials.Steam;

public class TurpentineChain {

    public static void init() {
        CHEMICAL_RECIPES.recipeBuilder()
                .inputStacks(getWoodLogs())
                .fluidInputs(Naphtha.getFluid(1000))
                .fluidOutputs(LeachedTurpentine.getFluid(1000))
                .duration(80).EUt(VA[HV]).buildAndRegister();

        CRACKING_RECIPES.recipeBuilder()
                .fluidInputs(Steam.getFluid(1000))
                .fluidInputs(LeachedTurpentine.getFluid(1000))
                .fluidOutputs(SteamCrackedTurpentine.getFluid(1000))
                .duration(80).EUt(240).buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(SteamCrackedTurpentine.getFluid(1000))
                .fluidOutputs(Turpentine.getFluid(1000))
                .fluidOutputs(Naphtha.getFluid(1000))
                .duration(120).EUt(VA[MV]).buildAndRegister();
    }

    @Nonnull
    private static List<ItemStack> getWoodLogs() {
        List<ItemStack> list = new ArrayList<>();
        if (Loader.isModLoaded(MODID_FR)) {
            // real woods
            ItemStack stack = GameRegistry.makeItemStack("forestry:pine_wood", 0, 4, null);
            if (!stack.isEmpty())
                list.add(stack);
            stack = GameRegistry.makeItemStack("forestry:fir_wood", 0, 4, null);
            if (!stack.isEmpty())
                list.add(stack);
            stack = GameRegistry.makeItemStack("forestry:larch_wood", 0, 4, null);
            if (!stack.isEmpty())
                list.add(stack);
        }
        //TODO BOP woods, other mods too
        if (list.isEmpty()) {
            // spruce log if the real woods do not exist
            list.add(new ItemStack(Blocks.LOG, 4, 1));
        }
        return list;
    }
}
