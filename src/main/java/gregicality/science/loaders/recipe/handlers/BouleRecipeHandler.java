package gregicality.science.loaders.recipe.handlers;

import gregicality.science.api.recipes.GCYSRecipeMaps;
import gregicality.science.api.unification.material.info.GCYSMaterialFlags;
import gregicality.science.api.unification.ore.GCYSOrePrefix;
import gregtech.api.GTValues;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.builders.BlastRecipeBuilder;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.info.MaterialFlags;
import gregtech.api.unification.material.properties.GemProperty;
import gregtech.api.unification.material.properties.PropertyKey;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.MaterialStack;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import javax.annotation.Nonnull;
import java.util.List;

import static gregtech.api.GTValues.HV;
import static gregtech.api.GTValues.VA;

public class BouleRecipeHandler {

    public static void register() {
        OrePrefix.gem.addProcessingHandler(PropertyKey.GEM, BouleRecipeHandler::processCrystallizer);
    }

    public static void processCrystallizer(OrePrefix gem, @Nonnull Material material, GemProperty property) {
        // Not crystallizable materials cannot be made into boules
        if (!material.hasFlag(MaterialFlags.CRYSTALLIZABLE) || material.hasFlag(GCYSMaterialFlags.DISABLE_CRYSTALLIZATION))
            return;

        // if there are too many components to fit in the crystallizer, do not make a recipe
        // -1 for the not consumable input
        if (material.getMaterialComponents().size() > GCYSRecipeMaps.CRYSTALLIZER_RECIPES.getMaxInputs() - 1 + GCYSRecipeMaps.CRYSTALLIZER_RECIPES.getMaxFluidInputs()) {
            return;
        }

        int componentAmount = 0;
        int temperature = 0;
        List<ItemStack> inputs = new ObjectArrayList<>();
        List<FluidStack> fluidInputs = new ObjectArrayList<>();

        for (MaterialStack materialStack : material.getMaterialComponents()) {
            Material componentMaterial = materialStack.material;
            int amount = (int) materialStack.amount;

            if (componentMaterial.isSolid() || componentMaterial.hasProperty(PropertyKey.DUST)) {
                componentAmount += amount;
                temperature += componentMaterial.getBlastTemperature() * amount;

                // if there are too many item inputs, do not make a recipe
                if (inputs.size() > GCYSRecipeMaps.CRYSTALLIZER_RECIPES.getMaxInputs() - 1) {
                    return;
                }
                inputs.add(OreDictUnifier.get(OrePrefix.dust, componentMaterial, amount));
            } else if (componentMaterial.hasProperty(PropertyKey.FLUID)) {
                componentAmount += amount;
                if (fluidInputs.size() > GCYSRecipeMaps.CRYSTALLIZER_RECIPES.getMaxFluidInputs()) {
                    return;
                }
                fluidInputs.add(componentMaterial.getFluid(amount * 1000));
            }

            // materials with no blast temperature are treated as having 1200K
            if (!componentMaterial.hasProperty(PropertyKey.BLAST)) {
                temperature += 1200 * amount;
            }
        }

        // just in case, prevent division by zero
        if (componentAmount == 0) return;

        // Average Temperature for the recipe
        temperature /= componentAmount;

        BlastRecipeBuilder builder = GCYSRecipeMaps.CRYSTALLIZER_RECIPES.recipeBuilder()
                .blastFurnaceTemp(temperature)
                .EUt(VA[temperature <= 2800 ? HV : GTValues.EV]);

        if (componentAmount == 2) {
            for (ItemStack stack : inputs) {
                stack.setCount(stack.getCount() * 2);
            }
            for (FluidStack stack : fluidInputs) {
                stack.amount *= 2;
            }

            componentAmount = 1;

            builder.duration((int) (material.getMass() * 4 * 2));
        } else if (componentAmount % 4 != 0) {
            for (ItemStack stack : inputs) {
                stack.setCount(stack.getCount() * 4);
            }
            for (FluidStack stack : fluidInputs) {
                stack.amount *= 4;
            }

            builder.duration((int) (material.getMass() * 4 * 4));
        } else {
            componentAmount /= 4;

            builder.duration((int) (material.getMass() * 4));
        }

        builder.input(GCYSOrePrefix.seedCrystal, material, componentAmount)
                .output(GCYSOrePrefix.boule, material, componentAmount);

        // Add the fluid and item inputs, then build the recipe
        if (!inputs.isEmpty()) builder.inputStacks(inputs);
        if (!fluidInputs.isEmpty()) builder.fluidInputs(fluidInputs.toArray(new FluidStack[0]));
        builder.buildAndRegister();

        // Cut boules into one exquisite gem
        RecipeMaps.CUTTER_RECIPES.recipeBuilder().
                input(GCYSOrePrefix.boule, material)
                .output(OrePrefix.gemExquisite, material)
                .output(GCYSOrePrefix.seedCrystal, material)
                .duration((int) (material.getMass() * 4))
                .EUt(16)
                .buildAndRegister();

        // Create Seed Crystals in an autoclave
        RecipeMaps.AUTOCLAVE_RECIPES.recipeBuilder().
                input(OrePrefix.gemExquisite, material)
                .fluidInputs(Materials.DistilledWater.getFluid(8000))
                .output(GCYSOrePrefix.seedCrystal, material)
                .duration((int) (material.getMass() * 9))
                .EUt(VA[HV])
                .buildAndRegister();
    }
}
