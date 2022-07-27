package gregicality.science.loaders.recipe.chain;

import gregtech.api.metatileentity.multiblock.CleanroomType;

import static gregicality.science.api.recipes.GCYSRecipeMaps.PLASMA_CVD_RECIPES;
import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregicality.science.common.items.GCYSMetaItems.CARBON_ALLOTROPE_MIXTURE;
import static gregicality.science.common.items.GCYSMetaItems.GRAPHENE_ALIGNED_CNT;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.SHAPE_EXTRUDER_INGOT;

public class NanotubesChain {

    public static void init() {
        cnt();
    }

    private static void cnt() {
        // 24C2H2 + 16N -> C48 + 16NH3
        PLASMA_CVD_RECIPES.recipeBuilder()
                .input(plateDouble, Rhenium)
                .fluidInputs(Acetylene.getFluid(24000))
                .fluidInputs(Nitrogen.getPlasma(16000))
                .output(stickLong, CarbonNanotube)
                .fluidOutputs(Ammonia.getFluid(16000))
                .temperature(993)
                .duration(1200).EUt(VA[UEV]).buildAndRegister();

        // 6C8 + C48 -> C96
        FORMING_PRESS_RECIPES.recipeBuilder()
                .input(foil, Graphene, 24)
                .input(dust, CarbonNanotube)
                .output(CARBON_ALLOTROPE_MIXTURE)
                .cleanroom(CleanroomType.CLEANROOM)
                .duration(100).EUt(VA[IV]).buildAndRegister();

        // C96 -> C48 + (C6H4)7(C12)
        ELECTROMAGNETIC_SEPARATOR_RECIPES.recipeBuilder()
                .input(CARBON_ALLOTROPE_MIXTURE)
                .output(ingot, CarbonNanotube)
                .output(GRAPHENE_ALIGNED_CNT, 4)
                .cleanroom(CleanroomType.CLEANROOM)
                .duration(200).EUt(VA[UV]).buildAndRegister();

        // (C6H4)7(C12) -> 7C6H4 + 12C
        EXTRACTOR_RECIPES.recipeBuilder()
                .input(GRAPHENE_ALIGNED_CNT)
                .output(dust, Carbon, 3)
                .fluidOutputs(Cycloparaphenylene.getFluid(1750))
                .duration(50).EUt(VA[HV]).buildAndRegister();

        // 3C2H2 + 7C6H4 + 10N -> C48 + 10NH3
        PLASMA_CVD_RECIPES.recipeBuilder()
                .notConsumable(plate, Rhenium)
                .fluidInputs(Acetylene.getFluid(3000))
                .fluidInputs(Cycloparaphenylene.getFluid(7000))
                .fluidInputs(Nitrogen.getPlasma(10000))
                .output(ingot, CarbonNanotube)
                .fluidOutputs(Ammonia.getFluid(10000))
                .temperature(993)
                .duration(100).EUt(VA[UV]).buildAndRegister();

        // Decomposition
        ELECTROLYZER_RECIPES.recipeBuilder()
                .input(dust, CarbonNanotube)
                .output(dust, Carbon, 48)
                .duration((int) Carbon.getMass() * 48).EUt(64)
                .buildAndRegister();

        EXTRUDER_RECIPES.recipeBuilder()
                .input(dust, Fullerene)
                .notConsumable(SHAPE_EXTRUDER_INGOT)
                .output(ingot, Fullerene)
                .duration(400).EUt(240).buildAndRegister();
    }
}
