package gregicality.science.loaders.recipe.oreprocessing;

import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import static com.ibm.icu.lang.UCharacter.GraphemeClusterBreak.LV;
import static gregicality.science.api.recipes.GCYSRecipeMaps.*;
import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;

/**
 * <p>Credit to the <a href="https://github.com/GT-IMPACT">GT-IMPACT Modpack</a>.
 * This processing chain was adapted from their Hyper Fuel production process</p>
 *
 *
 * The Taranium Production Process
 *
 * <p>
 * Produces Taranium and Bedrock Dust from Bedrock Smoke
 * </p>
 *
 * <p>Main Products: Taranium Dust, Taranium Fuels, Bedrock Dust</p>
 * <p>Side Products: Platinum, Iridium, Osmium</p>
 *
 */
public class TaraniumProcessing {

    public static void init() {
        // regular
        regularFractions();
        regularFractionCleaning();
        regularFractionCracking();
        regularFractionSeparation();

        // enriched
        enrichedFractions();
        enrichedFractionCleaning();
        enrichedFractionCracking();
        enrichedFractionSeparation();

        fuels();
        generators();
    }

    private static void regularFractions() {
        DRILLING_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(Blocks.BEDROCK))
                .chancedOutput(dust, Bedrock, 100, 0)
                .fluidOutputs(BedrockSmoke.getFluid(100))
                .duration(100).EUt(VA[UHV]).buildAndRegister();

        // NH3 + HNO3 -> NH4NO3
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Ammonia.getFluid(1000))
                .fluidInputs(NitricAcid.getFluid(1000))
                .output(dust, AmmoniumNitrate, 2)
                .duration(60).EUt(VA[LV]).buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dust, Naquadah)
                .input(dust, AmmoniumNitrate, 2)
                .fluidInputs(BedrockSmoke.getFluid(1000))
                .fluidInputs(Water.getFluid(1000))
                .fluidOutputs(BedrockSootSolution.getFluid(1000))
                .duration(600).EUt(1024).buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(BedrockSootSolution.getFluid(2000))
                .chancedOutput(dust, Platinum, 5, 1000, 0)
                .chancedOutput(dust, Iridium, 3, 1000, 0)
                .chancedOutput(dust, Naquadah, 1000, 0)
                .fluidOutputs(CleanBedrockSolution.getFluid(1000))
                .duration(600).EUt(4096).buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(CleanBedrockSolution.getFluid(1000))
                .output(dust, Bedrock, 3)
                .fluidOutputs(HeavyBedrockSmoke.getFluid(440))
                .fluidOutputs(MediumBedrockSmoke.getFluid(320))
                .fluidOutputs(LightBedrockSmoke.getFluid(180))
                .fluidOutputs(UltralightBedrockSmoke.getFluid(150))
                .duration(90).EUt(VA[IV]).buildAndRegister();
    }

    private static void regularFractionCleaning() {
        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(HeavyBedrockSmoke.getFluid(2000))
                .output(dust, Iridium)
                .output(dust, Bedrock, 3)
                .fluidOutputs(HeavyTaraniumGas.getFluid(1000))
                .duration(200).EUt(VA[LuV]).buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(MediumBedrockSmoke.getFluid(2000))
                .output(dust, Iridium)
                .output(dust, Bedrock, 2)
                .fluidOutputs(MediumTaraniumGas.getFluid(1000))
                .duration(140).EUt(VA[LuV]).buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(LightBedrockSmoke.getFluid(2000))
                .output(dust, Iridium)
                .output(dust, Bedrock)
                .fluidOutputs(LightTaraniumGas.getFluid(1000))
                .duration(90).EUt(VA[LuV]).buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(UltralightBedrockSmoke.getFluid(2000))
                .output(dust, Iridium)
                .chancedOutput(dust, Bedrock, 5000, 0)
                .fluidOutputs(BedrockGas.getFluid(1000))
                .duration(50).EUt(VA[LuV]).buildAndRegister();
    }

    private static void regularFractionCracking() {
        CRACKING_RECIPES.recipeBuilder()
                .notConsumable(new IntCircuitIngredient(1))
                .fluidInputs(Fluorine.getFluid(6000))
                .fluidInputs(HeavyTaraniumGas.getFluid(1000))
                .fluidOutputs(CrackedHeavyTaranium.getFluid(2000))
                .duration(300).EUt(9216).buildAndRegister();

        CRACKING_RECIPES.recipeBuilder()
                .notConsumable(new IntCircuitIngredient(1))
                .fluidInputs(Fluorine.getFluid(4000))
                .fluidInputs(MediumTaraniumGas.getFluid(1000))
                .fluidOutputs(CrackedMediumTaranium.getFluid(1600))
                .duration(250).EUt(9216).buildAndRegister();

        CRACKING_RECIPES.recipeBuilder()
                .notConsumable(new IntCircuitIngredient(1))
                .fluidInputs(Fluorine.getFluid(2000))
                .fluidInputs(LightTaraniumGas.getFluid(1000))
                .fluidOutputs(CrackedLightTaranium.getFluid(1200))
                .duration(200).EUt(9216).buildAndRegister();
    }

    private static void regularFractionSeparation() {
        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(CrackedHeavyTaranium.getFluid(1000))
                .output(dust, Taranium)
                .fluidOutputs(Fluorine.getFluid(250))
                .fluidOutputs(HeavyTaraniumFuel.getFluid(400))
                .fluidOutputs(MediumTaraniumFuel.getFluid(200))
                .fluidOutputs(LightTaraniumFuel.getFluid(100))
                .fluidOutputs(BedrockGas.getFluid(50))
                .duration(160).EUt(16384).buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(CrackedMediumTaranium.getFluid(1000))
                .output(dust, Taranium)
                .fluidOutputs(Fluorine.getFluid(150))
                .fluidOutputs(HeavyTaraniumFuel.getFluid(100))
                .fluidOutputs(MediumTaraniumFuel.getFluid(400))
                .fluidOutputs(LightTaraniumFuel.getFluid(200))
                .fluidOutputs(BedrockGas.getFluid(150))
                .duration(140).EUt(16384).buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(CrackedLightTaranium.getFluid(1000))
                .output(dust, Taranium)
                .fluidOutputs(Fluorine.getFluid(50))
                .fluidOutputs(HeavyTaraniumFuel.getFluid(50))
                .fluidOutputs(MediumTaraniumFuel.getFluid(150))
                .fluidOutputs(LightTaraniumFuel.getFluid(400))
                .fluidOutputs(BedrockGas.getFluid(350))
                .duration(120).EUt(16384).buildAndRegister();
    }

    private static void enrichedFractions() {
        MIXER_RECIPES.recipeBuilder()
                .input(dust, NaquadahEnriched)
                .fluidInputs(SulfuricAcid.getFluid(900))
                .fluidInputs(BedrockGas.getFluid(100))
                .fluidOutputs(EnrichedBedrockSootSolution.getFluid(1000))
                .duration(200).EUt(VA[LuV]).buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(EnrichedBedrockSootSolution.getFluid(2000))
                .chancedOutput(dust, Platinum, 5, 1000, 0)
                .chancedOutput(dust, Osmium, 3, 1000, 0)
                .chancedOutput(dust, NaquadahEnriched, 1000, 0)
                .fluidOutputs(CleanEnrichedBedrockSolution.getFluid(1000))
                .duration(300).EUt(98304).buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(CleanEnrichedBedrockSolution.getFluid(1000))
                .output(dust, Bedrock, 4)
                .fluidOutputs(HeavyEnrichedBedrockSmoke.getFluid(440))
                .fluidOutputs(MediumEnrichedBedrockSmoke.getFluid(320))
                .fluidOutputs(LightEnrichedBedrockSmoke.getFluid(180))
                .fluidOutputs(UltralightBedrockSmoke.getFluid(150))
                .duration(140).EUt(40960).buildAndRegister();
    }

    private static void enrichedFractionCleaning() {
        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(HeavyEnrichedBedrockSmoke.getFluid(8000))
                .output(dust, Bedrock, 5)
                .output(dust, Naquadria)
                .output(dust, Iridium, 2)
                .output(dust, Osmium, 3)
                .fluidOutputs(HeavyEnrichedTaraniumGas.getFluid(4000))
                .duration(1200).EUt(VA[ZPM]).buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(MediumEnrichedBedrockSmoke.getFluid(8000))
                .output(dust, Bedrock, 4)
                .output(dust, Naquadria)
                .output(dust, Iridium, 2)
                .output(dust, Osmium, 3)
                .fluidOutputs(MediumEnrichedTaraniumGas.getFluid(4000))
                .duration(960).EUt(VA[ZPM]).buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(LightEnrichedBedrockSmoke.getFluid(8000))
                .output(dust, Bedrock, 3)
                .output(dust, Naquadria)
                .output(dust, Iridium, 2)
                .output(dust, Osmium, 3)
                .fluidOutputs(LightEnrichedTaraniumGas.getFluid(4000))
                .duration(600).EUt(VA[ZPM]).buildAndRegister();
    }

    private static void enrichedFractionCracking() {
        CRACKING_RECIPES.recipeBuilder()
                .notConsumable(new IntCircuitIngredient(1))
                .fluidInputs(Radon.getFluid(6000))
                .fluidInputs(HeavyEnrichedTaraniumGas.getFluid(1000))
                .fluidOutputs(CrackedHeavyEnrichedTaranium.getFluid(2000))
                .duration(300).EUt(49152).buildAndRegister();

        CRACKING_RECIPES.recipeBuilder()
                .notConsumable(new IntCircuitIngredient(1))
                .fluidInputs(Radon.getFluid(4000))
                .fluidInputs(MediumEnrichedTaraniumGas.getFluid(1000))
                .fluidOutputs(CrackedMediumEnrichedTaranium.getFluid(1600))
                .duration(250).EUt(49152).buildAndRegister();

        CRACKING_RECIPES.recipeBuilder()
                .notConsumable(new IntCircuitIngredient(1))
                .fluidInputs(Radon.getFluid(2000))
                .fluidInputs(LightEnrichedTaraniumGas.getFluid(1000))
                .fluidOutputs(CrackedLightEnrichedTaranium.getFluid(1200))
                .duration(200).EUt(49152).buildAndRegister();
    }

    private static void enrichedFractionSeparation() {
        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(CrackedHeavyEnrichedTaranium.getFluid(1000))
                .output(dust, Taranium, 2)
                .fluidOutputs(Radon.getFluid(250))
                .fluidOutputs(HeavyEnrichedTaraniumFuel.getFluid(400))
                .fluidOutputs(MediumEnrichedTaraniumFuel.getFluid(200))
                .fluidOutputs(LightEnrichedTaraniumFuel.getFluid(100))
                .fluidOutputs(BedrockGas.getFluid(50))
                .duration(160).EUt(98304).buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(CrackedMediumEnrichedTaranium.getFluid(1000))
                .output(dust, Taranium, 2)
                .fluidOutputs(Radon.getFluid(150))
                .fluidOutputs(HeavyEnrichedTaraniumFuel.getFluid(100))
                .fluidOutputs(MediumEnrichedTaraniumFuel.getFluid(400))
                .fluidOutputs(LightEnrichedTaraniumFuel.getFluid(200))
                .fluidOutputs(BedrockGas.getFluid(150))
                .duration(140).EUt(98304).buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(CrackedLightEnrichedTaranium.getFluid(1000))
                .output(dust, Taranium, 2)
                .fluidOutputs(Radon.getFluid(50))
                .fluidOutputs(HeavyEnrichedTaraniumFuel.getFluid(50))
                .fluidOutputs(MediumEnrichedTaraniumFuel.getFluid(150))
                .fluidOutputs(LightEnrichedTaraniumFuel.getFluid(400))
                .fluidOutputs(BedrockGas.getFluid(350))
                .duration(120).EUt(98304).buildAndRegister();
    }

    private static void fuels() {
        SUPERHEAVY_RECIPES.recipeBuilder()
                .input(dust, Naquadria)
                .fluidInputs(NitrogenDioxide.getFluid(500))
                .fluidInputs(SulfuricAcid.getFluid(500))
                .output(dust, Lutetium)
                .output(dust, Uranium238)
                .output(dust, Plutonium241)
                .output(dust, NaquadahEnriched)
                .fluidOutputs(EnergeticNaquadria.getFluid(1000))
                .duration(300).EUt(65536).buildAndRegister();

        SUPERHEAVY_RECIPES.recipeBuilder()
                .input(dust, Europium)
                .fluidInputs(LightTaraniumFuel.getFluid(500))
                .fluidInputs(LightEnrichedTaraniumFuel.getFluid(300))
                .fluidInputs(EnergeticNaquadria.getFluid(200))
                .fluidInputs(Uranium238.getFluid(L))
                .output(dust, Naquadah)
                .fluidOutputs(LightHyperFuel.getFluid(2000))
                .duration(460).EUt(196608).buildAndRegister();

        SUPERHEAVY_RECIPES.recipeBuilder()
                .input(dust, Americium)
                .fluidInputs(MediumTaraniumFuel.getFluid(400))
                .fluidInputs(MediumEnrichedTaraniumFuel.getFluid(350))
                .fluidInputs(EnergeticNaquadria.getFluid(250))
                .fluidInputs(Uranium235.getFluid(L))
                .output(dust, NaquadahEnriched)
                .fluidOutputs(MediumHyperFuel.getFluid(2000))
                .duration(520).EUt(VA[UV]).buildAndRegister();

        SUPERHEAVY_RECIPES.recipeBuilder()
                .input(dust, Orichalcum)
                .fluidInputs(HeavyTaraniumFuel.getFluid(300))
                .fluidInputs(HeavyEnrichedTaraniumFuel.getFluid(400))
                .fluidInputs(EnergeticNaquadria.getFluid(300))
                .fluidInputs(Plutonium239.getFluid(L))
                .output(dust, NaquadahEnriched)
                .fluidOutputs(HeavyHyperFuel.getFluid(2000))
                .duration(580).EUt(VA[UV] * 3).buildAndRegister();
    }

    private static void generators() {
        TARANIUM_REACTOR_MK1_RECIPES.recipeBuilder()
                .fluidInputs(LightTaraniumFuel.getFluid(1))
                .duration(4).EUt((int) V[LuV]).buildAndRegister();

        TARANIUM_REACTOR_MK1_RECIPES.recipeBuilder()
                .fluidInputs(MediumTaraniumFuel.getFluid(1))
                .duration(2).EUt((int) V[LuV]).buildAndRegister();

        TARANIUM_REACTOR_MK1_RECIPES.recipeBuilder()
                .fluidInputs(HeavyTaraniumFuel.getFluid(1))
                .duration(1).EUt((int) V[LuV]).buildAndRegister();

        TARANIUM_REACTOR_MK2_RECIPES.recipeBuilder()
                .fluidInputs(LightEnrichedTaraniumFuel.getFluid(1))
                .duration(1).EUt((int) V[ZPM]).buildAndRegister();

        TARANIUM_REACTOR_MK2_RECIPES.recipeBuilder()
                .fluidInputs(MediumEnrichedTaraniumFuel.getFluid(1))
                .duration(2).EUt((int) V[ZPM]).buildAndRegister();

        TARANIUM_REACTOR_MK2_RECIPES.recipeBuilder()
                .fluidInputs(HeavyEnrichedTaraniumFuel.getFluid(1))
                .duration(4).EUt((int) V[ZPM]).buildAndRegister();

        TARANIUM_REACTOR_MK3_RECIPES.recipeBuilder()
                .fluidInputs(LightHyperFuel.getFluid(1))
                .duration(1).EUt((int) V[UV]).buildAndRegister();

        TARANIUM_REACTOR_MK3_RECIPES.recipeBuilder()
                .fluidInputs(MediumHyperFuel.getFluid(1))
                .duration(2).EUt((int) V[UV]).buildAndRegister();

        TARANIUM_REACTOR_MK3_RECIPES.recipeBuilder()
                .fluidInputs(HeavyHyperFuel.getFluid(1))
                .duration(4).EUt((int) V[UV]).buildAndRegister();
    }
}
