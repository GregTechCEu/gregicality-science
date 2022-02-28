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
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import javax.annotation.Nonnull;
import java.util.ArrayList;
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

        BlastRecipeBuilder builder = GCYSRecipeMaps.CRYSTALLIZER_RECIPES.recipeBuilder();

        builder.input(GCYSOrePrefix.seedCrystal, material);

        // if there are too many components to fit in the crystallizer, do not make a recipe
        // -1 for the not consumable input
        if (material.getMaterialComponents().size() > GCYSRecipeMaps.CRYSTALLIZER_RECIPES.getMaxInputs() - 1 + GCYSRecipeMaps.CRYSTALLIZER_RECIPES.getMaxFluidInputs())
            return;

        int componentAmount = 0;
        int temperature = 0;
        List<ItemStack> inputs = new ArrayList<>();
        List<FluidStack> fluidInputs = new ArrayList<>();

        for (MaterialStack materialStack : material.getMaterialComponents()) {
            Material componentMaterial = materialStack.material;
            int amount = (int) materialStack.amount;

            if (componentMaterial.isSolid() || componentMaterial.hasProperty(PropertyKey.DUST)) {
                componentAmount += amount;
                temperature += componentMaterial.getBlastTemperature() * amount;

                // if there are too many item inputs, do not make a recipe
                if (inputs.size() > GCYSRecipeMaps.CRYSTALLIZER_RECIPES.getMaxInputs() - 1)
                    return;
                inputs.add(OreDictUnifier.get(OrePrefix.dust, componentMaterial, amount));
            } else if (componentMaterial.hasProperty(PropertyKey.FLUID)) {
                componentAmount += amount;
                if (fluidInputs.size() > GCYSRecipeMaps.CRYSTALLIZER_RECIPES.getMaxFluidInputs())
                    return;
                fluidInputs.add(componentMaterial.getFluid(amount * 1000));
            }

            // materials with no blast temperature are treated as having 1200K
            if (!componentMaterial.hasProperty(PropertyKey.BLAST)) {
                temperature += 1200 * amount;
            }
        }

        // just in case, prevent division by zero
        if (componentAmount == 0)
            return;

        // Average Temperature for the recipe
        temperature /= componentAmount;

        builder.blastFurnaceTemp(temperature);

        // use temperature to determine the EUt
        builder.EUt(VA[temperature <= 2800 ? HV : GTValues.EV]);

        boolean shouldMultiply = false;

        if (componentAmount % 4 == 0) {
            // since boules are equivalent to 4 items, output doesn't need multiplication
            builder.output(GCYSOrePrefix.boule, material, componentAmount / 4);
        } else {
            // Multiplying the entire recipe by 4 for even amounts of boules
            builder.output(GCYSOrePrefix.boule, material, componentAmount);
            shouldMultiply = true;
        }

        if (shouldMultiply) {
            for (ItemStack stack : inputs) {
                stack.setCount(stack.getCount() * 4);
            }
            for (FluidStack stack : fluidInputs) {
                stack.amount *= 4;
            }

            builder.duration((int) (material.getMass() * 4 * 4));
        } else {
            builder.duration((int) (material.getMass() * 4));
        }

        // Add the fluid and item inputs, then build the recipe
        if (!inputs.isEmpty())
            builder.inputs(inputs);
        if (!fluidInputs.isEmpty())
            builder.fluidInputs(fluidInputs);
        builder.buildAndRegister();

        // Cut boules into one exquisite gem
        RecipeMaps.CUTTER_RECIPES.recipeBuilder()
                .input(GCYSOrePrefix.boule, material)
                .output(OrePrefix.gemExquisite, material)
                .output(GCYSOrePrefix.seedCrystal, material)
                .duration((int) (material.getMass() * 4))
                .EUt(16)
                .buildAndRegister();

        // Create Seed Crystals in an autoclave
        RecipeMaps.AUTOCLAVE_RECIPES.recipeBuilder()
                .input(OrePrefix.gemExquisite, material)
                .fluidInputs(Materials.DistilledWater.getFluid(8000))
                .output(GCYSOrePrefix.seedCrystal, material)
                .duration((int) (material.getMass() * 9))
                .EUt(VA[HV])
                .buildAndRegister();
    }
}
