package gregicality.science.loaders.recipe.oreprocessing;

import gregicality.science.common.GCYSConfigHolder;
import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;

import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static gregtech.api.unification.ore.OrePrefix.dustSmall;

/**
 * The Rare Earth Extraction Process
 *
 * <p>
 * Produces Rare Earth Element Oxides from Rare Earth
 * </p>
 *
 * <p>Main Products: All of the REE Oxides</p>
 * <p>Side Products: None</p>
 *
 * <p>4 Rare Earth -> 1 of every REE Oxide</p>
 */
public class RareEarthProcessing {

    public static void init() {
        // Remove Rare Earth Centrifuging
        if (GCYSConfigHolder.chainOverrides.disableRareEarthProcessing) {
            GTRecipeHandler.removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, OreDictUnifier.get(OrePrefix.dust, Materials.RareEarth));
        }

        // Separating Agent Production: Di-(2-ethylhexyl)phosphoric Acid

        // 2C4H8O + 4H -> C8H18O + H2O
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Butyraldehyde.getFluid(2000))
                .fluidInputs(Hydrogen.getFluid(4000))
                .fluidOutputs(Ethylhexanol.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .duration(80).EUt(VA[MV]).buildAndRegister();

        // 5C8H18O + 0.5P4O10 -> 2C16H35O4P + 2C4H10 + 2O (lost)
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Ethylhexanol.getFluid(5000))
                .input(dust, PhosphorusPentoxide, 7)
                .fluidOutputs(DiethylhexylPhosphoricAcid.getFluid(2000))
                .fluidOutputs(Butane.getFluid(2000))
                .duration(600).EUt(16).buildAndRegister();

        // Rare Earth Element Production

        MIXER_RECIPES.recipeBuilder()
                .input(dust, RareEarth)
                .input(dust, SodiumHydroxide, 3)
                .notConsumable(new IntCircuitIngredient(2))
                .fluidInputs(DiethylhexylPhosphoricAcid.getFluid(100))
                .fluidInputs(Water.getFluid(900))
                .fluidOutputs(RareEarthHydroxidesSolution.getFluid(1000))
                .duration(120).EUt(VA[HV]).buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(RareEarthHydroxidesSolution.getFluid(1000))
                .fluidInputs(HydrochloricAcid.getFluid(1000))
                .output(dust, SodiumHydroxide, 3)
                .fluidOutputs(RareEarthChloridesSolution.getFluid(1000))
                .duration(120).EUt(VA[LV]).buildAndRegister();

        // Crude Neodymium Oxide Production, can still be obtained as ore byproducts
        // This is optional for EV Tier (Motors)
        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(RareEarthChloridesSolution.getFluid(1000))
                .notConsumable(new IntCircuitIngredient(1))
                .output(dust, NeodymiumOxide)
                .fluidOutputs(HydrochloricAcid.getFluid(900))
                .duration(200).EUt(VA[LV]).buildAndRegister();

        // Crude Cerium Oxide Production
        // This is optional for ZPM Tier (Pu-241 Fusion)
        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(RareEarthChloridesSolution.getFluid(1000))
                .notConsumable(new IntCircuitIngredient(2))
                .output(dust, CeriumOxide)
                .fluidOutputs(HydrochloricAcid.getFluid(850))
                .duration(200).EUt(3840).buildAndRegister();

        // Crude Samarium Oxide Production
        // This is required for LuV Tier (Magnetic Samarium -> Motors)
        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(RareEarthChloridesSolution.getFluid(1000))
                .notConsumable(new IntCircuitIngredient(3))
                .output(dust, SamariumOxide)
                .fluidOutputs(HydrochloricAcid.getFluid(800))
                .duration(200).EUt(3840).buildAndRegister();

        // Crude Yttrium Oxide Production
        // This is optional for IV Tier (Incoloy-MA956)
        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(RareEarthChloridesSolution.getFluid(1000))
                .notConsumable(new IntCircuitIngredient(4))
                .output(dust, YttriumOxide)
                .fluidOutputs(HydrochloricAcid.getFluid(750))
                .duration(200).EUt(3840).buildAndRegister();

        // Crude Lanthanum Oxide Production
        // This is required for UV Tier (Americium -> Motors)
        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(RareEarthChloridesSolution.getFluid(1000))
                .notConsumable(new IntCircuitIngredient(5))
                .output(dust, LanthanumOxide)
                .fluidOutputs(HydrochloricAcid.getFluid(500))
                .duration(200).EUt(15360).buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(RareEarthChloridesSolution.getFluid(1000))
                .output(dustSmall, Thorium)
                .fluidOutputs(LaPrNdCeOxidesSolution.getFluid(250))
                .fluidOutputs(ScEuGdSmOxidesSolution.getFluid(250))
                .fluidOutputs(YTbDyHoOxidesSolution.getFluid(250))
                .fluidOutputs(ErTmYbLuOxidesSolution.getFluid(250))
                .fluidOutputs(HydrochloricAcid.getFluid(1000))
                .disableDistilleryRecipes()
                .duration(200).EUt(VA[UV]).buildAndRegister();
    }
}
