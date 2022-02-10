package gregicality.science.loaders.recipe.handlers;

import gregicality.science.api.recipes.GCYSRecipeMaps;
import gregicality.science.api.unification.ore.GCYSOrePrefix;
import gregtech.api.GTValues;
import gregtech.api.recipes.builders.BlastRecipeBuilder;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialFlags;
import gregtech.api.unification.material.properties.GemProperty;
import gregtech.api.unification.material.properties.PropertyKey;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.MaterialStack;
import gregtech.api.recipes.RecipeMaps;

public class GCYSMaterialRecipeHandler {
    public static void register() {
        OrePrefix.gem.addProcessingHandler(PropertyKey.GEM, GCYSMaterialRecipeHandler::processGem);
    }

    public static void processGem(OrePrefix gem, Material material, GemProperty property){

        if(!material.hasFlag(MaterialFlags.CRYSTALLIZABLE)){
            return;
        }

        int n_fluid = 0;
        int n_item = 0;
        int output_amount = 0;
        int temperature = 0;

        BlastRecipeBuilder builder = GCYSRecipeMaps.CRYSTALLIZER_RECIPES.recipeBuilder();

        builder.notConsumable(OrePrefix.gemExquisite, material);

        for(MaterialStack material_stack : material.getMaterialComponents()){
            if(material_stack.material.isSolid() || material_stack.material.hasProperty(PropertyKey.DUST)){
                n_item++;
                builder.input(OrePrefix.dust, material_stack.material, (int) material_stack.amount * 16);
            }else if(material_stack.material.hasFluid()){
                n_fluid++;
                builder.fluidInputs(material_stack.material.getFluid((int) material_stack.amount * 1000 * 16));
            }
            if(material_stack.material.hasProperty(PropertyKey.BLAST)){
                temperature += material_stack.material.getBlastTemperature() * material_stack.amount;
            } else {
                temperature += 1200 * material_stack.amount;
            }
            output_amount += material_stack.amount;
        }

        temperature /= output_amount;

        builder.blastFurnaceTemp(temperature);

        if(temperature <= 2800){
            builder.EUt(GTValues.VA[GTValues.LV]);
        } else {
            builder.EUt(GTValues.VA[GTValues.MV]);
        }

        builder.duration((int) material.getMass() * 4);

        builder.output(GCYSOrePrefix.boule, material, output_amount);

        if(n_fluid <= GCYSRecipeMaps.CRYSTALLIZER_RECIPES.getMaxFluidInputs() && (n_item + 1) <= GCYSRecipeMaps.CRYSTALLIZER_RECIPES.getMaxInputs()){
            builder.buildAndRegister();
        }

        RecipeMaps.CUTTER_RECIPES.recipeBuilder()
                .input(GCYSOrePrefix.boule, material)
                .output(OrePrefix.gemExquisite, material, 4)
                .duration(20)
                .EUt(16)
                .buildAndRegister();
    }
}
