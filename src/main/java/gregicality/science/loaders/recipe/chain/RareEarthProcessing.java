package gregicality.science.loaders.recipe.chain;

import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;

import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class RareEarthProcessing {

    public static void init() {
        // Remove Rare Earth Centrifuging
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, OreDictUnifier.get(OrePrefix.dust, Materials.RareEarth));

        // Separating Agent Production: Di-(2-ethylhexyl)phosphoric Acid

        // CO + C3H6 + 2H -> C4H8O
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(CarbonMonoxide.getFluid(1000))
                .fluidInputs(Propene.getFluid(1000))
                .fluidInputs(Hydrogen.getFluid(2000))
                .fluidOutputs(Butyraldehyde.getFluid(1000))
                .duration(160).EUt(VA[LV]).buildAndRegister();

        // 2C4H8O + 4H -> C8H18O + H2O
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Butyraldehyde.getFluid(2000))
                .fluidInputs(Hydrogen.getFluid(4000))
                .fluidOutputs(Ethylhexanol.getFluid(3000))
                .fluidOutputs(Water.getFluid(1000))
                .duration(80).EUt(VA[MV]).buildAndRegister();

        // 5C8H18O + 0.5P4O10 -> 2C16H35O4P + 2C4H10O
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Ethylhexanol.getFluid(5000))
                .input(dust, PhosphorusPentoxide, 7)
                .fluidOutputs(DiethylhexylPhosphoricAcid.getFluid(2000))
                .fluidOutputs(Butanol.getFluid(2000))
                .duration(600).EUt(16).buildAndRegister();

        // Rare Earth Element Production

        MIXER_RECIPES.recipeBuilder()
                .input(dust, RareEarth)
                .fluidInputs(DiethylhexylPhosphoricAcid.getFluid(100))
                .fluidInputs(HydrochloricAcid.getFluid(900))
                .fluidOutputs(RareEarthChloridesSolution.getFluid(1000))
                .duration(120).EUt(VA[HV]).buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(RareEarthChloridesSolution.getFluid(1000))
                .output(dustSmall, Thorium)
                .fluidOutputs(LaPrNdCeOxidesSolution.getFluid(250))
                .fluidOutputs(ScEuGdSmOxidesSolution.getFluid(250))
                .fluidOutputs(YTbDyHoOxidesSolution.getFluid(250))
                .fluidOutputs(ErThYtLuOxidesSolution.getFluid(250))
                .fluidOutputs(HydrochloricAcid.getFluid(450))
                .fluidOutputs(Water.getFluid(50))
                .duration(240).EUt(VA[IV]).buildAndRegister();

        BLAST_RECIPES.recipeBuilder()
                .input(dust, EuropiumOxide, 5)
                .input(dust, Carbon, 3)
                .output(ingotHot, Europium)
                .fluidOutputs(CarbonMonoxide.getFluid(3000))
                .blastFurnaceTemp(9600)
                .duration(120).EUt(VA[UV]).buildAndRegister();
    }
}
