package gregicality.science.loaders.recipe.chain;

import gregtech.api.GTValues;

import static gregicality.multiblocks.api.recipes.GCYMRecipeMaps.ALLOY_BLAST_RECIPES;
import static gregicality.science.api.recipes.GCYSRecipeMaps.BURNER_REACTOR_RECIPES;
import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregicality.science.api.unification.ore.GCYSOrePrefix.seedCrystal;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class MagneticsChain {

    public static void init() {
        plutoniumPhosphide();
        neptuniumAluminide();
        bismuthFerrite();
        thalliumCopperChloride();
    }

    private static void plutoniumPhosphide() {
        //TODO radioactive safe reactor?
        // Pu + 3H -> PuH3
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Plutonium239)
                .fluidInputs(Hydrogen.getFluid(3000))
                .output(dust, PlutoniumTrihydride, 4)
                .duration(60).EUt(VA[IV]).buildAndRegister();

        // Pu + PH3 -> PuP + 6H
        BURNER_REACTOR_RECIPES.recipeBuilder()
                .input(dust, PlutoniumTrihydride, 4)
                .fluidInputs(Phosphine.getFluid(1000))
                .output(ingot, PlutoniumPhosphide, 2)
                .fluidOutputs(Hydrogen.getFluid(6000))
                .duration(60).EUt(VA[IV]).buildAndRegister();
    }

    private static void neptuniumAluminide() {
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Neptunium)
                .input(dust, Aluminium, 3)
                .output(dust, NeptuniumAluminide, 4)
                .duration(400).EUt(VA[IV]).buildAndRegister();
    }

    private static void bismuthFerrite() {
        // 2Bi + 3H2O -> Bi2O3 + 6H
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Bismuth, 2)
                .fluidInputs(Water.getFluid(3000))
                .output(dust, BismuthTrioxide, 5)
                .fluidOutputs(Hydrogen.getFluid(6000))
                .duration(50).EUt(60).buildAndRegister();

        // 2Fe + 3O -> Fe2O3
        BURNER_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Iron, 2)
                .fluidInputs(Oxygen.getFluid(3000))
                .output(dust, FerricOxide, 5)
                .temperature(473)
                .duration(50).EUt(120).buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .input(dust, Hematite)
                .output(dust, FerricOxide)
                .duration(200).EUt(8).buildAndRegister();

        AUTOCLAVE_RECIPES.recipeBuilder()
                .input(dust, BismuthTrioxide, 20)
                .input(dust, BoronTrioxide, 5)
                .fluidInputs(DistilledWater.getFluid(8000))
                .output(seedCrystal, BismuthFerrite)
                .duration(1000).EUt(VA[LuV]).buildAndRegister();

        COMPRESSOR_RECIPES.recipeBuilder()
                .input(dust, BismuthFerrite)
                .output(plate, BismuthFerrite)
                .duration(400).EUt(2).buildAndRegister();
    }

    private static void thalliumCopperChloride() {
        // Tl + Cu + 3Cl -> TlCuCl3
        ALLOY_BLAST_RECIPES.recipeBuilder()
                .input(dust, Thallium)
                .input(dust, Copper)
                .fluidInputs(Chlorine.getFluid(3000))
                .fluidOutputs(ThalliumCopperChloride.getFluid(GTValues.L * 5))
                .blastFurnaceTemp(1570)
                .duration(700).EUt(VA[EV]).buildAndRegister();
    }
}
