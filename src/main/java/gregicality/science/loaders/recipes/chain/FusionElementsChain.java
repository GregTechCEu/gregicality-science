package gregicality.science.loaders.recipes.chain;

import gregtech.api.recipes.ingredients.IntCircuitIngredient;

import static gregicality.science.api.GCYSMaterials.*;
import static gregicality.science.loaders.recipes.GCYSRecipeMaps.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.SHAPE_MOLD_INGOT;

public class FusionElementsChain {
    public static void init() { //todo

        advFusionRecipes();
        fusionRecipes();

        // Li + 2H2O -> H + LiOH(H2O)
        CHEMICAL_RECIPES.recipeBuilder().duration(140).EUt(120)
                .input(dust, Lithium)
                .fluidInputs(Water.getFluid(2000))
                .fluidOutputs(Hydrogen.getFluid(1000))
                .fluidOutputs(LithiumHydroxideSolution.getFluid(1000))
                .buildAndRegister();

        // 2LiOH(H2O) + H2O2 -> Li2O2(H2O) + 3H2O (H2O lost to Dehydrator)
        CHEMICAL_RECIPES.recipeBuilder().duration(180).EUt(120)
                .fluidInputs(LithiumHydroxideSolution.getFluid(2000))
                .fluidInputs(HydrogenPeroxide.getFluid(1000))
                .fluidOutputs(LithiumPeroxideSolution.getFluid(1000))
                .buildAndRegister();

        // CO + Li2O2(H2O) -> Li2CO3(H2O)
        MIXER_RECIPES.recipeBuilder().duration(240).EUt(30)
                .fluidInputs(CarbonMonoxide.getFluid(1000))
                .fluidInputs(LithiumPeroxideSolution.getFluid(1000))
                .fluidOutputs(LithiumCarbonateSolution.getFluid(1000))
                .buildAndRegister();

        // 6O -> 2O3
        ELECTROLYZER_RECIPES.recipeBuilder().duration(120).EUt(480)
                .fluidInputs(Oxygen.getFluid(6000))
                .fluidOutputs(Ozone.getFluid(2000))
                .buildAndRegister();

        // 6NO2 + O3 -> 3N2O5
        CHEMICAL_RECIPES.recipeBuilder().duration(240).EUt(480)
                .fluidInputs(NitrogenDioxide.getFluid(6000))
                .fluidInputs(Ozone.getFluid(1000))
                .fluidOutputs(NitrogenPentoxide.getFluid(3000))
                .buildAndRegister();

        // 2N2O5 + TiCl4 + 2O -> 4Cl + Ti(NO3)4
        CHEMICAL_RECIPES.recipeBuilder().duration(230).EUt(480)
                .fluidInputs(NitrogenPentoxide.getFluid(2000))
                .fluidInputs(TitaniumTetrachloride.getFluid(1000))
                .fluidInputs(Oxygen.getFluid(2000))
                .fluidOutputs(Chlorine.getFluid(4000))
                .output(dust, TitaniumNitrate, 17)
                .buildAndRegister();

        // Ti(NO3)4 + 2NaOH + Li2CO3(H2O) -> 4HNO3 + Li2TiO3 + Na2CO3
        BLAST_RECIPES.recipeBuilder().duration(320).EUt(120).blastFurnaceTemp(3100)
                .input(dust, TitaniumNitrate, 17)
                .input(dust, SodiumHydroxide, 6)
                .fluidInputs(LithiumCarbonateSolution.getFluid(1000))
                .fluidOutputs(NitricAcid.getFluid(4000))
                .output(ingot, LithiumTitanate, 6)
                .output(dust, SodaAsh, 6)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder().duration(340).EUt(7680)
                .fluidInputs(Carbon.getFluid(10000))
                .fluidOutputs(Carbon12.getFluid(9893))
                .fluidOutputs(Carbon13.getFluid(107))
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder().duration(3400).EUt(7680)
                .fluidInputs(Nitrogen.getFluid(100000))
                .fluidOutputs(Nitrogen14.getFluid(99636))
                .fluidOutputs(Nitrogen15.getFluid(364))
                .buildAndRegister();

        LARGE_CHEMICAL_RECIPES.recipeBuilder().duration(250).EUt(7680)
                .fluidInputs(Carbon12.getFluid(1000))
                .fluidInputs(Carbon13.getFluid(1000))
                .fluidInputs(Nitrogen14.getFluid(1000))
                .fluidInputs(Nitrogen15.getFluid(1000))
                .fluidOutputs(CNOcatalyst.getFluid(4000))
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder().duration(150).EUt(7680)
                .fluidInputs(HeliumCNO.getFluid(800))
                .fluidOutputs(Helium.getFluid(640))
                .fluidOutputs(CNOcatalyst.getFluid(160))
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder().duration(180).EUt(480)
                .input(dust, Radium)
                .fluidOutputs(Radon.getFluid(1000))
                .buildAndRegister();

        FERMENTING_RECIPES.recipeBuilder().duration(180).EUt(7680)
                .fluidInputs(Titanium44.getFluid(144))
                .fluidOutputs(Calcium44.getFluid(144))
                .buildAndRegister();

        FERMENTING_RECIPES.recipeBuilder().duration(180).EUt(7680)
                .fluidInputs(Chromium48.getFluid(144))
                .fluidOutputs(Titanium.getFluid(144))
                .buildAndRegister();

        FERMENTING_RECIPES.recipeBuilder().duration(180).EUt(7680)
                .fluidInputs(Iron52.getFluid(144))
                .fluidOutputs(Chrome.getFluid(144))
                .buildAndRegister();

        FERMENTING_RECIPES.recipeBuilder().duration(180).EUt(7680)
                .fluidInputs(Nickel56.getFluid(144))
                .fluidOutputs(Iron.getFluid(144))
                .buildAndRegister();

        FERMENTING_RECIPES.recipeBuilder().duration(160).EUt(122880)
                .fluidInputs(QuassifissioningPlasma.getFluid(1000))
                .fluidOutputs(FlYbPlasma.getFluid(1000))
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder().duration(290).EUt(1920)
                .fluidInputs(FlYbPlasma.getFluid(1000))
                .fluidOutputs(MetastableFlerovium.getFluid(288))
                .fluidOutputs(Ytterbium178.getFluid(288))
                .buildAndRegister();

        FERMENTING_RECIPES.recipeBuilder().duration(120).EUt(30720)
                .fluidInputs(Ytterbium178.getFluid(144))
                .fluidOutputs(Hafnium.getFluid(144))
                .buildAndRegister();

        // Ti + 4HF -> TiF4 + 4H
        CHEMICAL_RECIPES.recipeBuilder().duration(300).EUt(120)
                .input(dust, Titanium)
                .fluidInputs(HydrofluoricAcid.getFluid(4000))
                .fluidOutputs(TitaniumTetrafluoride.getFluid(1000))
                .fluidOutputs(Hydrogen.getFluid(4000))
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder().duration(210).EUt(30720)
                .notConsumable(new IntCircuitIngredient(1))
                .fluidInputs(TitaniumTetrafluoride.getFluid(10000))
                .fluidOutputs(Titanium50Tetrafluoride.getFluid(518))
                .fluidOutputs(Fluorine.getFluid(9482))
                .buildAndRegister();

        BLAST_RECIPES.recipeBuilder().duration(340).EUt(120)
                .blastFurnaceTemp(Titanium.getBlastTemperature())
                .fluidInputs(Titanium50Tetrafluoride.getFluid(1000))
                .input(dust, Sodium, 4)
                .output(ingotHot, Titanium50)
                .output(dust, SodiumFluoride, 8)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder().duration(120).EUt(7680)
                .fluidInputs(Titanium50.getFluid(288))
                .fluidInputs(Californium252.getFluid(288))
                .fluidOutputs(OgannesonBreedingBase.getFluid(2000))
                .buildAndRegister();

        ADV_FUSION_RECIPES.recipeBuilder().duration(100).EUt(600000)
                .fluidInputs(Curium250.getFluid(36))
                .fluidInputs(OgannesonBreedingBase.getFluid(125))
                .fluidOutputs(HotMetastableOganesson.getFluid(125))

                .buildAndRegister();

        VACUUM_RECIPES.recipeBuilder().duration(3800).EUt(120)
                .notConsumable(SHAPE_MOLD_INGOT)
                .fluidInputs(HotMetastableOganesson.getFluid(125))
                .output(ingotHot, MetastableOganesson)
                .buildAndRegister();

        BLAST_RECIPES.recipeBuilder().duration(350).EUt(120).blastFurnaceTemp(3000)
                .input(dust, Hafnium)
                .input(dust, Graphite)
                .output(dust, HafniumCarbide, 2)
                .buildAndRegister();

        BLAST_RECIPES.recipeBuilder().duration(260).EUt(120).blastFurnaceTemp(2500)
                .input(dust, Tantalum)
                .input(dust, Graphite)
                .output(dust, TantalumCarbide, 2)
                .buildAndRegister();

        // NaSgO3 + Cl + 4C -> SgC + NaCl + 3CO
        BLAST_RECIPES.recipeBuilder().duration(280).EUt(120).blastFurnaceTemp(3000)
                .input(dust, SodiumSeaborgate, 5)
                .fluidInputs(Chlorine.getFluid(1000))
                .input(dust, Carbon, 4)
                .output(dust, SeaborgiumCarbide, 2)
                .output(dust, Salt, 2)
                .fluidOutputs(CarbonMonoxide.getFluid(3000))
                .buildAndRegister();

        // 12TaC + 3HfC + SgC -> Ta12Hf3SgC16
        BLAST_RECIPES.recipeBuilder().duration(340).EUt(120).blastFurnaceTemp(6200)
                .input(dust, TantalumCarbide, 24)
                .input(dust, HafniumCarbide, 6)
                .input(dust, SeaborgiumCarbide, 2)
                .output(ingotHot, TantalumHafniumSeaborgiumCarbide, 32)
                .buildAndRegister();
    }

    private static void advFusionRecipes() {

        // Alpha Process
        ADV_FUSION_RECIPES.recipeBuilder().duration(384).EUt(7000)
                .fluidInputs(Helium.getFluid(375))
                .fluidInputs(Helium.getFluid(375))
                .fluidOutputs(Carbon.getPlasma(250))
                .buildAndRegister();

        ADV_FUSION_RECIPES.recipeBuilder().duration(128).EUt(7000)
                .fluidInputs(Carbon.getFluid(125))
                .fluidInputs(Helium.getFluid(125))
                .fluidOutputs(Oxygen.getPlasma(125))
                .buildAndRegister();

        ADV_FUSION_RECIPES.recipeBuilder().duration(128).EUt(7000)
                .fluidInputs(Oxygen.getFluid(125))
                .fluidInputs(Helium.getFluid(125))
                .fluidOutputs(Neon.getPlasma(125))
                .buildAndRegister();

        ADV_FUSION_RECIPES.recipeBuilder().duration(128).EUt(7000)
                .fluidInputs(Neon.getFluid(125))
                .fluidInputs(Helium.getFluid(125))
                .fluidOutputs(Magnesium.getPlasma(125))
                .buildAndRegister();

        ADV_FUSION_RECIPES.recipeBuilder().duration(128).EUt(7000)
                .fluidInputs(Magnesium.getFluid(125))
                .fluidInputs(Helium.getFluid(125))
                .fluidOutputs(Silicon.getPlasma(125))
                .buildAndRegister();

        ADV_FUSION_RECIPES.recipeBuilder().duration(128).EUt(7000)
                .fluidInputs(Silicon.getFluid(125))
                .fluidInputs(Helium.getFluid(125))
                .fluidOutputs(Sulfur.getPlasma(125))
                .buildAndRegister();

        ADV_FUSION_RECIPES.recipeBuilder().duration(128).EUt(7000)
                .fluidInputs(Sulfur.getFluid(125))
                .fluidInputs(Helium.getFluid(125))
                .fluidOutputs(Argon.getPlasma(125))
                .buildAndRegister();

        ADV_FUSION_RECIPES.recipeBuilder().duration(128).EUt(7000)
                .fluidInputs(Argon.getFluid(125))
                .fluidInputs(Helium.getFluid(125))
                .fluidOutputs(Calcium.getPlasma(125))
                .buildAndRegister();

        ADV_FUSION_RECIPES.recipeBuilder().duration(128).EUt(7000)
                .fluidInputs(Calcium.getFluid(125))
                .fluidInputs(Helium.getFluid(125))
                .fluidOutputs(Titanium44.getPlasma(125))
                .buildAndRegister();

        ADV_FUSION_RECIPES.recipeBuilder().duration(128).EUt(7000)
                .fluidInputs(Titanium44.getFluid(125))
                .fluidInputs(Helium.getFluid(125))
                .fluidOutputs(Chromium48.getPlasma(125))
                .buildAndRegister();

        ADV_FUSION_RECIPES.recipeBuilder().duration(128).EUt(7000)
                .fluidInputs(Calcium44.getFluid(125))
                .fluidInputs(Helium.getFluid(125))
                .fluidOutputs(Titanium.getPlasma(125))
                .buildAndRegister();

        ADV_FUSION_RECIPES.recipeBuilder().duration(128).EUt(7000)
                .fluidInputs(Chromium48.getFluid(125))
                .fluidInputs(Helium.getFluid(125))
                .fluidOutputs(Iron52.getPlasma(125))
                .buildAndRegister();

        ADV_FUSION_RECIPES.recipeBuilder().duration(128).EUt(7000)
                .fluidInputs(Iron52.getFluid(125))
                .fluidInputs(Helium.getFluid(125))
                .fluidOutputs(Nickel56.getPlasma(125))
                .buildAndRegister();

        // CNO Cycle
        ADV_FUSION_RECIPES.recipeBuilder().duration(128).EUt(8192)
                .fluidInputs(CNOcatalyst.getFluid(160))
                .fluidInputs(Hydrogen.getFluid(640))
                .fluidOutputs(HeliumCNO.getPlasma(800))
                .buildAndRegister();

        // Flerovium Production
        ADV_FUSION_RECIPES.recipeBuilder().duration(100).EUt(600000)
                .fluidInputs(Uranium238.getFluid(125))
                .fluidInputs(Uranium238.getFluid(125))
                .fluidOutputs(QuassifissioningPlasma.getFluid(125))
                .buildAndRegister();

        // Carbon-Burning Process
        ADV_FUSION_RECIPES.recipeBuilder().duration(100).EUt(600000)
                .fluidInputs(Carbon12.getFluid(125))
                .fluidInputs(Carbon12.getFluid(125))
                .fluidOutputs(Neon.getPlasma(125))
                .fluidOutputs(Helium4.getFluid(125))
                .buildAndRegister();

        // Other Advanced Fusion Materials
        ADV_FUSION_RECIPES.recipeBuilder().duration(50).EUt(1000000)
                .fluidInputs(Curium247.getFluid(144))
                .fluidInputs(Sodium.getFluid(144))
                .fluidOutputs(Bohrium.getFluid(288))
                .buildAndRegister();

//        ADV_FUSION_RECIPES.recipeBuilder().duration(100).EUt(2000000)
//                .fluidInputs(Trinium.getFluid(144))
//                .fluidInputs(Tritanium.getFluid(144))
//                .fluidOutputs(Adamantium.getFluid(288))
//                .buildAndRegister();
//
//        ADV_FUSION_RECIPES.recipeBuilder().duration(100).EUt(8000000)
//                .fluidInputs(Adamantium.getFluid(144))
//                .fluidInputs(Seaborgium.getFluid(144))
//                .fluidOutputs(Vibranium.getFluid(288))
//                .buildAndRegister();

        ADV_FUSION_RECIPES.recipeBuilder().duration(100).EUt(900000)
                .fluidInputs(ScandiumTitanium50Mix.getFluid(36))
                .fluidInputs(RadonRadiumMix.getFluid(144))
                .fluidOutputs(MetastableHassium.getFluid(144))
                .buildAndRegister();

        ADV_FUSION_RECIPES.recipeBuilder().duration(100).EUt(75000)
                .fluidInputs(Americium.getFluid(144))
                .fluidInputs(Titanium.getFluid(144))
                .fluidOutputs(Tennessine.getFluid(288))
                .buildAndRegister();

        ADV_FUSION_RECIPES.recipeBuilder().duration(100).EUt(75000)
                .fluidInputs(Plutonium239.getFluid(144))
                .fluidInputs(Titanium.getFluid(144))
                .fluidOutputs(Livermorium.getFluid(288))
                .buildAndRegister();

        ADV_FUSION_RECIPES.recipeBuilder().duration(100).EUt(75000)
                .fluidInputs(Neptunium.getFluid(144))
                .fluidInputs(Titanium.getFluid(144))
                .fluidOutputs(Moscovium.getFluid(288))
                .buildAndRegister();

        ADV_FUSION_RECIPES.recipeBuilder().duration(100).EUt(75000)
                .fluidInputs(Astatine.getFluid(144))
                .fluidInputs(Nickel.getFluid(144))
                .fluidOutputs(Nihonium.getFluid(288))
                .buildAndRegister();

        ADV_FUSION_RECIPES.recipeBuilder().duration(100).EUt(75000)
                .fluidInputs(Radium.getFluid(144))
                .fluidInputs(Vanadium.getFluid(144))
                .fluidOutputs(Roentgenium.getFluid(288))
                .buildAndRegister();

        ADV_FUSION_RECIPES.recipeBuilder().duration(100).EUt(75000)
                .fluidInputs(Polonium.getFluid(144))
                .fluidInputs(Chrome.getFluid(144))
                .fluidOutputs(Meitnerium.getFluid(288))
                .buildAndRegister();
    }

    public static void fusionRecipes() {
        // Fusion Recipes

        FUSION_RECIPES.recipeBuilder().duration(128).EUt(49152).EUToStart(480000000)
                .fluidInputs(Nickel.getFluid(16))
                .fluidInputs(Polonium.getFluid(16))
                .fluidOutputs(Copernicium.getFluid(16))
                .buildAndRegister();

        FUSION_RECIPES.recipeBuilder().duration(64).EUt(32768).EUToStart(200000000)
                .fluidInputs(Gold.getFluid(16))
                .fluidInputs(Mercury.getFluid(16))
                .fluidOutputs(Radon.getPlasma(125))
                .buildAndRegister();

        // Should technically be Pu242
        FUSION_RECIPES.recipeBuilder().duration(64).EUt(24576).EUToStart(150000000)
                .fluidInputs(Plutonium241.getFluid(16))
                .fluidInputs(Neon.getFluid(16))
                .fluidOutputs(Rutherfordium.getFluid(16))
                .buildAndRegister();

        FUSION_RECIPES.recipeBuilder().duration(96).EUt(49152).EUToStart(200000000)
                .fluidInputs(Americium.getFluid(16))
                .fluidInputs(Neon.getFluid(16))
                .fluidOutputs(Dubnium.getFluid(16))
                .buildAndRegister();

        FUSION_RECIPES.recipeBuilder().duration(100).EUt(75000).EUToStart(400000000)
                .fluidInputs(Plutonium239.getFluid(144))
                .fluidInputs(Calcium.getFluid(144))
                .fluidOutputs(Seaborgium.getFluid(288))
                .buildAndRegister();
    }
}
