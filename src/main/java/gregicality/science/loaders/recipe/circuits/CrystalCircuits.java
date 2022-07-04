package gregicality.science.loaders.recipe.circuits;

import gregicality.science.api.recipes.GCYSRecipeMaps;
import gregicality.science.common.GCYSConfigHolder;
import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.MarkerMaterials;

import static gregicality.science.api.unification.materials.GCYSMaterials.CubicZirconia;
import static gregicality.science.common.items.GCYSMetaItems.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;

public class CrystalCircuits {

    public static void init() {
        crystalInterface();
        crystalModulators();
        crystalSOC();
        if (GCYSConfigHolder.circuitOverrides.harderCrystalCircuits) {
            removeGTCERecipes();
        }
    }

    private static void removeGTCERecipes() {
        GTRecipeHandler.removeRecipesByInputs(LASER_ENGRAVER_RECIPES,
                CRYSTAL_CENTRAL_PROCESSING_UNIT.getStackForm(),
                OreDictUnifier.get(craftingLens, MarkerMaterials.Color.Blue)
        );
    }

    private static void crystalInterface() {
        GCYSRecipeMaps.CRYSTALLIZER_RECIPES.recipeBuilder()
                .input(dust, CubicZirconia, 64)
                .input(dust, Europium, 8)
                .blastFurnaceTemp(3000)
                .output(EU_DOPED_CUBIC_ZIRCONIA_BOULE)
                .duration(120)
                .EUt(60)
                .buildAndRegister();

        RecipeMaps.CUTTER_RECIPES.recipeBuilder()
                .input(EU_DOPED_CUBIC_ZIRCONIA_BOULE)
                .output(EU_DOPED_CUBIC_ZIRCONIA_WAFER, 8)
                .duration(100)
                .EUt(20)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(EU_DOPED_CUBIC_ZIRCONIA_WAFER)
                .notConsumable(lens, Diamond)
                .output(CRYSTAL_INTERFACE_WAFER)
                .duration(20)
                .EUt(100)
                .buildAndRegister();

        RecipeMaps.CUTTER_RECIPES.recipeBuilder()
                .input(CRYSTAL_INTERFACE_WAFER)
                .output(CRYSTAL_INTERFACE_CHIP, 8)
                .duration(100)
                .EUt(20)
                .buildAndRegister();
    }

    private static void crystalModulators() {
        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(gemExquisite, Sapphire)
                .notConsumable(GLASS_LENSES.get(MarkerMaterials.Color.Blue))
                .output(ENGRAVED_SAPPHIRE_CRYSTAL_CHIP)
                .duration(1200).EUt(VA[HV]).buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(gemExquisite, Ruby)
                .notConsumable(GLASS_LENSES.get(MarkerMaterials.Color.Red))
                .output(ENGRAVED_RUBY_CRYSTAL_CHIP)
                .duration(1200).EUt(VA[HV]).buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(gemExquisite, Diamond)
                .notConsumable(GLASS_LENSES.get(MarkerMaterials.Color.LightBlue))
                .output(ENGRAVED_DIAMOND_CRYSTAL_CHIP)
                .duration(1200).EUt(VA[HV]).buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(ENGRAVED_SAPPHIRE_CRYSTAL_CHIP)
                .input(PLASTIC_CIRCUIT_BOARD)
                .input(wireFine, Palladium, 8)
                .input(bolt, Platinum, 4)
                .output(CRYSTAL_MODULATOR_SAPPHIRE, 8)
                .solderMultiplier(1)
                .duration(200).EUt(VA[IV]).buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(ENGRAVED_RUBY_CRYSTAL_CHIP)
                .input(PLASTIC_CIRCUIT_BOARD)
                .input(wireFine, Palladium, 8)
                .input(bolt, Platinum, 4)
                .output(CRYSTAL_MODULATOR_RUBY, 8)
                .duration(200).EUt(VA[IV]).buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(ENGRAVED_DIAMOND_CRYSTAL_CHIP)
                .input(PLASTIC_CIRCUIT_BOARD)
                .input(wireFine, Palladium, 8)
                .input(bolt, Platinum, 4)
                .output(CRYSTAL_MODULATOR_DIAMOND, 8)
                .duration(200).EUt(VA[IV]).buildAndRegister();
    }

    private static void crystalSOC() {
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(CRYSTAL_INTERFACE_CHIP)
                .input(CRYSTAL_MODULATOR_SAPPHIRE)
                .input(CRYSTAL_MODULATOR_RUBY)
                .input(CRYSTAL_MODULATOR_DIAMOND)
                .input(wireFine, Europium, 4)
                .output(CRYSTAL_SYSTEM_ON_CHIP_SOCKET)
                .duration(100).EUt(VA[LuV]).buildAndRegister();

        FORMING_PRESS_RECIPES.recipeBuilder()
                .input(CRYSTAL_SYSTEM_ON_CHIP_SOCKET)
                .input(CRYSTAL_CENTRAL_PROCESSING_UNIT)
                .output(CRYSTAL_SYSTEM_ON_CHIP)
                .duration(100).EUt(VA[ZPM]).buildAndRegister();
    }
}
