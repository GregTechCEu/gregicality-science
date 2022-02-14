package gregicality.science.loaders.recipe.chain;

import gregtech.api.recipes.RecipeMaps;
import gregicality.science.api.recipes.GCYSRecipeMaps;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.common.items.MetaItems.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregicality.science.common.items.GCYSMetaItems.*;

public class CrystalCircuitsChain {
    public static void init(){
        GCYSRecipeMaps.CRYSTALLIZER_RECIPES.recipeBuilder()
                .input(dust, CubicZirconia, 64)
                .input(dust, Europium, 8)
                .blastFurnaceTemp(3000)
                .output(EU_DOPED_CUBIC_ZIRCONIA_BOULE)
                .duration(120)
                .EUt(60)
                .buildAndRegister();

        GCYSRecipeMaps.CRYSTALLIZER_RECIPES.recipeBuilder()
                .input(dust, CubicZirconia, 64)
                .input(dust, Chrome, 8)
                .blastFurnaceTemp(3000)
                .output(CR_DOPED_CUBIC_ZIRCONIA_BOULE)
                .duration(120)
                .EUt(60)
                .buildAndRegister();

        RecipeMaps.CUTTER_RECIPES.recipeBuilder()
                .input(EU_DOPED_CUBIC_ZIRCONIA_BOULE)
                .output(EU_DOPED_CUBIC_ZIRCONIA_WAFER, 8)
                .duration(100)
                .EUt(20)
                .buildAndRegister();

        RecipeMaps.CUTTER_RECIPES.recipeBuilder()
                .input(CR_DOPED_CUBIC_ZIRCONIA_BOULE)
                .output(CR_DOPED_CUBIC_ZIRCONIA_WAFER, 8)
                .duration(100)
                .EUt(20)
                .buildAndRegister();

        RecipeMaps.CUTTER_RECIPES.recipeBuilder()
                .input(CRYSTAL_INTERFACE_WAFER)
                .output(CRYSTAL_INTERFACE_CHIP, 8)
                .duration(100)
                .EUt(20)
                .buildAndRegister();

        RecipeMaps.CUTTER_RECIPES.recipeBuilder()
                .input(CRYSTAL_CHIP_WAFER)
                .output(RAW_CRYSTAL_CHIP, 8)
                .duration(100)
                .EUt(20)
                .buildAndRegister();

        RecipeMaps.CUTTER_RECIPES.recipeBuilder()
                .input(ENGRAVED_RUBY_CRYSTAL)
                .output(RUBY_CHIP, 8)
                .duration(100)
                .EUt(20)
                .buildAndRegister();

        RecipeMaps.CUTTER_RECIPES.recipeBuilder()
                .input(ENGRAVED_EMERALD_CRYSTAL)
                .output(EMERALD_CHIP, 8)
                .duration(100)
                .EUt(20)
                .buildAndRegister();

        RecipeMaps.CUTTER_RECIPES.recipeBuilder()
                .input(ENGRAVED_SAPPHIRE_CRYSTAL)
                .output(SAPPHIRE_CHIP, 8)
                .duration(100)
                .EUt(20)
                .buildAndRegister();

        RecipeMaps.LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(EU_DOPED_CUBIC_ZIRCONIA_WAFER)
                .notConsumable(lens, Diamond)
                .output(CRYSTAL_INTERFACE_WAFER)
                .duration(20)
                .EUt(100)
                .buildAndRegister();

        RecipeMaps.LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(CR_DOPED_CUBIC_ZIRCONIA_WAFER)
                .notConsumable(lens, Diamond)
                .output(CRYSTAL_CHIP_WAFER)
                .duration(100)
                .EUt(100)
                .buildAndRegister();

        RecipeMaps.LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(RAW_CRYSTAL_CHIP)
                .notConsumable(lens, Diamond)
                .output(ENGRAVED_CRYSTAL_CHIP)
                .duration(100)
                .EUt(100)
                .buildAndRegister();

        RecipeMaps.LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(gemExquisite, Ruby)
                .notConsumable(lens, Ruby)
                .output(ENGRAVED_RUBY_CRYSTAL)
                .duration(100)
                .EUt(100)
                .buildAndRegister();

        RecipeMaps.LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(gemExquisite, Emerald)
                .notConsumable(lens, Emerald)
                .output(ENGRAVED_EMERALD_CRYSTAL)
                .duration(100)
                .EUt(100)
                .buildAndRegister();

        RecipeMaps.LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(gemExquisite, Sapphire)
                .notConsumable(lens, Sapphire)
                .output(ENGRAVED_SAPPHIRE_CRYSTAL)
                .duration(100)
                .EUt(100)
                .buildAndRegister();

        RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(ENGRAVED_CRYSTAL_CHIP)
                .input(CRYSTAL_INTERFACE_CHIP)
                .output(CRYSTAL_CENTRAL_PROCESSING_UNIT)
                .duration(100)
                .EUt(10000)
                .buildAndRegister();

        RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(CRYSTAL_CENTRAL_PROCESSING_UNIT)
                .input(RUBY_CHIP)
                .input(EMERALD_CHIP)
                .input(SAPPHIRE_CHIP)
                .output(CRYSTAL_SYSTEM_ON_CHIP)
                .duration(100)
                .EUt(40000)
                .buildAndRegister();
    }
}
