package gregicality.science.loaders.recipes.chain;

import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import static gregicality.science.api.GCYSMaterials.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static gregtech.common.items.MetaItems.SHAPE_MOLD_PLATE;

public class GermaniumChain {
    public static void init() {

        // ZnS + C + H2O = [ZnS + C + H2O]
        MIXER_RECIPES.recipeBuilder().duration(50).EUt(120)
                .input(dust, Sphalerite)
                .input(dust, Coke)
                .fluidInputs(DistilledWater.getFluid(1000))
                .output(dust, ZincCokePellets, 3)
                .buildAndRegister();

        // 2[ZnS + C + H2O] + 6O = 2ZnO + Zinc Residual Slag + Zinc Exhaust [Contains: Dark Ash + CO2 + SO2]
        BLAST_RECIPES.recipeBuilder().duration(120).EUt(120).blastFurnaceTemp(1500)
                .input(dust, ZincCokePellets, 6)
                .fluidInputs(Oxygen.getFluid(6000))
                .output(dust, Zincite, 4)
                .output(dust, ZincResidualSlag)
                .fluidOutputs(ZincExhaustMixture.getFluid(1000))
                .buildAndRegister();

        // ZnO + 2H2SO4 = ZnSO4 + ZincLeachingResidue [Contains: (H2O)(H2SO4)]
        CHEMICAL_BATH_RECIPES.recipeBuilder().duration(40).EUt(480)
                .input(dust, Zincite, 2)
                .fluidInputs(SulfuricAcid.getFluid(2000))
                .output(dust, ZincSulfate, 6)
                .output(dust, ZincLeachingResidue)
                .buildAndRegister();

        // Na2CO3 + SO2 = Na2SO3 + CO2
        CHEMICAL_RECIPES.recipeBuilder().duration(70).EUt(30)
                .input(dust, SodaAsh, 6)
                .fluidInputs(SulfurDioxide.getFluid(1000))
                .output(dust, SodiumSulfite, 6)
                .fluidOutputs(CarbonDioxide.getFluid(1000))
                .buildAndRegister();

        // 2 Wood + Na2SO4 + H2O2 + [NaOH + H2O] = 2C6H10O5 + Polyphenol Mix
        // This recipe is close enough
        CHEMICAL_RECIPES.recipeBuilder().duration(90).EUt(30)
                .input(dust, Wood, 2)
                .input(dust, SodiumSulfite, 6)
                .fluidInputs(HydrogenPeroxide.getFluid(1000))
                .fluidInputs(SodiumHydroxideSolution.getFluid(1000))
                .output(dust, Cellulose, 42)
                .fluidOutputs(PolyphenolMix.getFluid(1000))
                .buildAndRegister();

        FORMING_PRESS_RECIPES.recipeBuilder().duration(250).EUt(30)
                .input(dust, Cellulose)
                .notConsumable(SHAPE_MOLD_PLATE)
                .outputs(new ItemStack(Items.PAPER))
                .buildAndRegister();

        // Polyphenol Mix = Acidified Polyphenol Mix
        CHEMICAL_RECIPES.recipeBuilder().duration(200).EUt(30)
                .fluidInputs(PolyphenolMix.getFluid(1000))
                .notConsumable(HydrochloricAcid.getFluid(0))
                .fluidOutputs(AcidifiedPolyphenolMix.getFluid(1000))
                .buildAndRegister();

        // 2C2H5OH = (C2H5)2O + H2O (H2O lost to dehydrator)
        CHEMICAL_RECIPES.recipeBuilder().duration(120).EUt(750)
                .fluidInputs(Ethanol.getFluid(2000))
                .notConsumable(SulfuricAcid.getFluid(0))
                .notConsumable(new IntCircuitIngredient(1))
                .fluidOutputs(Diethylether.getFluid(1000))
                .buildAndRegister();

        // 0.5(C2H5)2O + Acidified Polyphenol Mix = 1 Tannic Acid + 0.5 Wood Tar
        CHEMICAL_RECIPES.recipeBuilder().duration(100).EUt(120)
                .fluidInputs(Diethylether.getFluid(500))
                .fluidInputs(AcidifiedPolyphenolMix.getFluid(1000))
                .fluidOutputs(TannicAcid.getFluid(1000))
                .fluidOutputs(WoodTar.getFluid(500))
                .buildAndRegister();

        // ZincLeachingResidue [Contains: (H2O)(H2SO4)] -> FeSO4 + 0.5H4GeO4
        CHEMICAL_RECIPES.recipeBuilder().duration(100).EUt(480)
                .input(dust, ZincLeachingResidue)
                .notConsumable(TannicAcid.getFluid(1))
                .output(dust, IronSulfate, 6)
                .fluidOutputs(GermanicAcidSolution.getFluid(500))
                .buildAndRegister();

        // H4GeO4 + 4HCl = [GeCl4 + 4H2O]
        CHEMICAL_RECIPES.recipeBuilder().duration(130).EUt(120)
                .fluidInputs(GermanicAcidSolution.getFluid(1000))
                .fluidInputs(HydrochloricAcid.getFluid(1000))
                .fluidOutputs(GermaniumChloride.getFluid(1000))
                .buildAndRegister();

        // [GeCl4 + 4H2O] = 4HCl + GeO2 + 2H2O (lost to dehydrator)
        CENTRIFUGE_RECIPES.recipeBuilder().duration(60).EUt(1920)
                .fluidInputs(GermaniumChloride.getFluid(1000))
                .fluidOutputs(HydrochloricAcid.getFluid(4000))
                .output(dust, GermaniumOxide, 3)
                .buildAndRegister();

        // GeO2 + 4H = Ge + 2H2O
        BLAST_RECIPES.recipeBuilder().duration(220).EUt(120).blastFurnaceTemp(1300)
                .input(dust, GermaniumOxide, 3)
                .fluidInputs(Hydrogen.getFluid(4000))
                .output(dust, Germanium)
                .fluidOutputs(Water.getFluid(2000))
                .buildAndRegister();
    }
}
