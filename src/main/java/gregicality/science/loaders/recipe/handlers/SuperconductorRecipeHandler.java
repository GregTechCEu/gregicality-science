package gregicality.science.loaders.recipe.handlers;

import gregicality.science.api.unification.ore.GCYSOrePrefix;
import gregicality.science.api.utils.GCYSLog;
import gregtech.api.GTValues;
import gregtech.api.GregTechAPI;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.properties.IngotProperty;
import gregtech.api.unification.material.properties.PropertyKey;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.common.items.MetaItems;

import javax.annotation.Nonnull;

public class SuperconductorRecipeHandler {

    public static void register(){
        GCYSOrePrefix.superconductorAssembly.addProcessingHandler(PropertyKey.INGOT, SuperconductorRecipeHandler::processSuperconductor);
    }

    public static void processSuperconductor(OrePrefix superconductor, @Nonnull Material material, IngotProperty property) {
        if(!material.getProperty(PropertyKey.WIRE).isSuperconductor()) return;

        RecipeMaps.CANNER_RECIPES.recipeBuilder()
                .input(OrePrefix.dust, material, 1)
                .input(OrePrefix.pipeTinyItem, Materials.Silver, 1)
                .output(GCYSOrePrefix.cannedSuperconductorMix, material, 1)
                .duration(20)
                .EUt(GTValues.LV)
                .buildAndRegister();

        RecipeMaps.BLAST_RECIPES.recipeBuilder()
                .input(GCYSOrePrefix.cannedSuperconductorMix, material, 1)
                .notConsumable(Materials.Argon.getFluid(1000))
                .blastFurnaceTemp(1200)
                .output(GCYSOrePrefix.superconductorAssembly, material, 1)
                .duration(80)
                .EUt(GTValues.MV)
                .buildAndRegister();

        RecipeMaps.EXTRUDER_RECIPES.recipeBuilder()
                .input(GCYSOrePrefix.superconductorAssembly, material, 1)
                .notConsumable(MetaItems.SHAPE_EXTRUDER_ROD)
                .output(GCYSOrePrefix.superconductorWireBase, material, 1)
                .duration(20)
                .EUt(GTValues.LV)
                .buildAndRegister();

        for(Material coolant : GregTechAPI.MaterialRegistry.getAllMaterials()) {
            if(coolant.hasFluid()) {
                if(coolant.getFluid().getTemperature() <= material.getProperty(PropertyKey.WIRE).getSuperconductorCriticalTemperature()) {
                    RecipeMaps.CHEMICAL_BATH_RECIPES.recipeBuilder()
                            .input(GCYSOrePrefix.superconductorWireBase, material, 1)
                            .fluidInputs(coolant.getFluid(1))
                            .output(OrePrefix.wireGtSingle, material, 1)
                            .duration(5)
                            .EUt(GTValues.LV)
                            .buildAndRegister();
                }
            }
        }
    }
}
