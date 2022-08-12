package gregicality.science.loaders.recipe.chain;

import static gregicality.science.api.recipes.GCYSRecipeMaps.*;
import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class PhosphorusChain {

    public static void init() {
        phosphorus();
        phosphorene();
        phosphorylChloride();
        phosphine();
    }

    private static void phosphorus() {
        // 2Ca3(PO4)2 + 6SiO2 + 5C -> 6CaSiO3 + 5CO2 + P4
        BURNER_REACTOR_RECIPES.recipeBuilder()
                .input(dust, TricalciumPhosphate, 10) //TODO cursed decomp
                .input(dust, SiliconDioxide, 18)
                .input(dust, Carbon, 5)
                .output(dust, Wollastonite, 30)
                .output(gem, WhitePhosphorus)
                .fluidOutputs(CarbonDioxide.getFluid(5000))
                .temperature(1073)
                .duration(200).EUt(VA[MV]).buildAndRegister();

        //TODO find better recipe
        COMPRESSOR_RECIPES.recipeBuilder()
                .input(dust, Phosphorus, 4)
                .output(gem, WhitePhosphorus)
                .duration(800).EUt(VA[HV]).buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, WhitePhosphorus)
                .fluidInputs(Argon.getFluid(50))
                .output(gem, RedPhosphorus)
                .temperature(573)
                .duration(200).EUt(VA[MV]).buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, WhitePhosphorus)
                .fluidInputs(Lead.getFluid(L * 2))
                .output(gem, VioletPhosphorus)
                .duration(400).EUt(VA[HV]).buildAndRegister();

        //TODO implosion?
        BURNER_REACTOR_RECIPES.recipeBuilder()
                .input(gem, WhitePhosphorus)
                .output(gem, BlackPhosphorus)
                .pressure(1.2159E9).temperature(524)
                .duration(100).EUt(VA[IV]).buildAndRegister();

        MOLECULAR_BEAM_RECIPES.recipeBuilder()
                .notConsumable(foil, Gold) //TODO ultra pure
                .input(gem, BlackPhosphorus)
                .output(dust, BluePhosphorus) //TODO find the pressure for this
                .duration(100).EUt(VA[ZPM]).buildAndRegister();
    }

    private static void phosphorene() {
        MIXER_RECIPES.recipeBuilder()
                .input(dust, SodiumHydroxide, 6)
                .input(gem, BlackPhosphorus, 8)
                .fluidInputs(DistilledWater.getFluid(200)) //TODO ultrapure
                .fluidInputs(NMethylPyrrolidone.getFluid(800))
                .fluidOutputs(PhosphoreneSolution.getFluid(1000))
                .duration(600).EUt(VA[IV]).buildAndRegister();

        SONICATION_RECIPES.recipeBuilder()
                .fluidInputs(PhosphoreneSolution.getFluid(125))
                .fluidInputs(Argon.getFluid(100))
                .output(foil, Phosphorene, 4)
                .fluidOutputs(NMethylPyrrolidone.getFluid(100))
                .duration(100).EUt(VA[LuV]).buildAndRegister();
    }

    private static void phosphorylChloride() {
        // P4 + 12Cl -> 4PCl3
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, WhitePhosphorus)
                .fluidInputs(Chlorine.getFluid(12000))
                .fluidOutputs(PhosphorusTrichloride.getFluid(4000))
                .duration(120).EUt(VA[MV]).buildAndRegister();

        // PCl3 + O -> POCl3
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(PhosphorusTrichloride.getFluid(1000))
                .fluidInputs(Oxygen.getFluid(1000))
                .fluidOutputs(PhosphorylChloride.getFluid(1000))
                .duration(120).EUt(VA[HV]).buildAndRegister();
    }

    private static void phosphine() {
        // P4 + 6H2O -> 4PH3 + 6O (lost)
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, WhitePhosphorus)
                .fluidInputs(Water.getFluid(6000))
                .fluidOutputs(Phosphine.getFluid(4000))
                .duration(200).EUt(16).buildAndRegister();

    }
}
