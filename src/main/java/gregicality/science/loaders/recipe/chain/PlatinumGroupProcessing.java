package gregicality.science.loaders.recipe.chain;

import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.OreDictUnifier;
import gregtech.common.items.MetaItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;

public class PlatinumGroupProcessing {

    /**
     * Balancing this chain
     *
     * This chain is chemically balanced such that the material sludges and mixtures for the target outputs
     * are not part of the chemical reaction. Therefore, to adjust balance one simply needs to adjust the output
     * amount of each of the sludges/residues.
     *
     * This however excludes the Palladium byproduct produced from Platinum.
     */
    public static void init() {
        removeGTCERecipes();
        platinumProcess();
        palladiumProcess();
        rhodiumProcess();
        rutheniumProcess();
    }

    private static void removeGTCERecipes() {
        // Remove Raw Platinum -> Platinum
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ELECTROLYZER_RECIPES, OreDictUnifier.get(dust, PlatinumRaw, 3));

        // Remove Raw Palladium -> Palladium
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.CHEMICAL_RECIPES,
                new ItemStack[]{OreDictUnifier.get(dust, PalladiumRaw, 5)},
                new FluidStack[]{HydrochloricAcid.getFluid(1000)});
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.LARGE_CHEMICAL_RECIPES,
                new ItemStack[]{OreDictUnifier.get(dust, PalladiumRaw, 5)},
                new FluidStack[]{HydrochloricAcid.getFluid(1000)});

        // Remove Inert Metal Residue -> Ruthenium Tetroxide + Rhodium Sulfate + Hydrogen
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.CHEMICAL_RECIPES,
                new ItemStack[]{OreDictUnifier.get(dust, InertMetalMixture, 6)},
                new FluidStack[]{SulfuricAcid.getFluid(1500)});
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.LARGE_CHEMICAL_RECIPES,
                new ItemStack[]{OreDictUnifier.get(dust, InertMetalMixture, 6)},
                new FluidStack[]{SulfuricAcid.getFluid(1500)});

        // Remove Rhodium Sulfate -> Rhodium
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ELECTROLYZER_RECIPES, RhodiumSulfate.getFluid(1000));

        // Remove Ruthenium Tetroxide -> Ruthenium
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.CHEMICAL_RECIPES, OreDictUnifier.get(dust, RutheniumTetroxide, 5), OreDictUnifier.get(dust, Carbon, 2));
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.LARGE_CHEMICAL_RECIPES, OreDictUnifier.get(dust, RutheniumTetroxide, 5), OreDictUnifier.get(dust, Carbon, 2));

    }

    private static void platinumProcess() {

        // HNO3(HCl) + PtPd? -> PtPd(HNO3)(HCl) + ?
        RecipeMaps.CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, PlatinumGroupSludge)
                .fluidInputs(AquaRegia.getFluid(2000))
                .output(dust, PlatinumGroupResidue)
                .fluidOutputs(PlatinumPalladiumLeachate.getFluid(1000))
                .duration(250).EUt(VA[LV]).buildAndRegister();

        // HNO3(HCl) + PtPd? -> PtPd(HNO3)(HCl) + ?(HNO3)
        RecipeMaps.CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, PlatinumMetallic, 2)
                .fluidInputs(AquaRegia.getFluid(2000))
                .output(dust, PlatinumGroupResidue)
                .fluidOutputs(PlatinumPalladiumLeachate.getFluid(1000))
                .duration(250).EUt(VA[LV]).buildAndRegister();

        // NH3 + HCl -> NH4Cl
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Ammonia.getFluid(1000))
                .fluidInputs(HydrochloricAcid.getFluid(1000))
                .output(dust, AmmoniumChloride, 2)
                .duration(60).EUt(VA[ULV]).buildAndRegister();

        // 4NH4Cl + PtPd(HNO3)(HCl) -> Pt? + (NH4)2PtCl6 + PdCl2(NH3)2
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, AmmoniumChloride, 8)
                .fluidInputs(PlatinumPalladiumLeachate.getFluid(1000))
                .output(dust, AmmoniumHexachloroplatinate, 9)
                .output(dust, CrudePlatinumResidue)
                .fluidOutputs(PalladiumRichAmmonia.getFluid(1000))
                .duration(1200).EUt(VA[LV]).buildAndRegister();

        // (NH4)2PtCl6 -> 2NH3 + H2PtCl6
        RecipeMaps.ELECTROLYZER_RECIPES.recipeBuilder()
                .input(dust, AmmoniumHexachloroplatinate, 9)
                .fluidOutputs(Ammonia.getFluid(2000))
                .fluidOutputs(ChloroplatinicAcid.getFluid(1000))
                .duration(30).EUt(VA[LV]).buildAndRegister();

        // H2PtCl6 -> PtCl2 + 4HCl
        // gain in 2H comes from missing 2H in producing PdCl2(NH3)2 two steps above
        RecipeMaps.DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(ChloroplatinicAcid.getFluid(1000))
                .output(dust, PlatinumRaw, 2)
                .fluidOutputs(HydrochloricAcid.getFluid(4000))
                .duration(120).EUt(VA[LV]).buildAndRegister();

        // PtCl2 + Ca -> Pt + CaCl2
        RecipeMaps.AUTOCLAVE_RECIPES.recipeBuilder()
                .input(dust, PlatinumRaw, 3)
                .input(dust, Calcium)
                .fluidInputs(Steam.getFluid(3840))
                .output(dust, Platinum)
                .output(dust, CalciumChloride, 3)
                .fluidOutputs(DistilledWater.getFluid(24))
                .duration(30).EUt(VA[LV]).buildAndRegister();

        // Pt? -> Pt
        RecipeMaps.SIFTER_RECIPES.recipeBuilder()
                .input(dust, CrudePlatinumResidue)
                .chancedOutput(OreDictUnifier.get(dust, PlatinumMetallic), 9500, 0)
                .duration(600).EUt(VA[LV]).buildAndRegister();
    }

    private static void palladiumProcess() {

        // Pd + 2NH3 + 2Cl -> PdCl2(NH3)2
        RecipeMaps.MIXER_RECIPES.recipeBuilder()
                .input(dust, PalladiumMetallic, 2)
                .fluidInputs(Ammonia.getFluid(2000))
                .fluidInputs(Chlorine.getFluid(2000))
                .fluidOutputs(PalladiumRichAmmonia.getFluid(1000))
                .duration(250).EUt(VA[LV]).buildAndRegister();

        // PdCl2(NH3)2 -> Pd
        RecipeMaps.FLUID_SOLIDFICATION_RECIPES.recipeBuilder()
                .fluidInputs(PalladiumRichAmmonia.getFluid(500))
                .notConsumable(MetaItems.SHAPE_MOLD_BALL.getStackForm())
                .output(dust, CrudePalladiumResidue)
                .duration(125).EUt(VA[LV]).buildAndRegister();

        // Pd + PdCl2(NH3)2 -> Pd? + PdCl2 + 2NH3
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, PalladiumMetallic, 2)
                .fluidInputs(PalladiumRichAmmonia.getFluid(1000))
                .output(dust, PalladiumRaw, 3)
                .output(dust, CrudePalladiumResidue)
                .fluidOutputs(Ammonia.getFluid(2000))
                .duration(250).EUt(VA[LV]).buildAndRegister();

        // CH3OH + CO2 -> H2CO2CH3
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .notConsumable(dust, SodiumHydroxide)
                .fluidInputs(Methanol.getFluid(1000))
                .fluidInputs(CarbonDioxide.getFluid(1000))
                .fluidOutputs(MethylFormate.getFluid(1000))
                .duration(16).EUt(VA[LV]).buildAndRegister();

        // H2CO2CH3 + H2O -> HCOOH + CH3OH
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(MethylFormate.getFluid(1000))
                .fluidInputs(Water.getFluid(1000))
                .fluidOutputs(FormicAcid.getFluid(1000))
                .fluidOutputs(Methanol.getFluid(1000))
                .duration(16).EUt(VA[LV]).buildAndRegister();

        // PdCl2 + HCOOH -> Pd + 2HCl + CO2
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, PalladiumRaw, 3)
                .fluidInputs(FormicAcid.getFluid(1000))
                .output(dust, Palladium)
                .fluidOutputs(HydrochloricAcid.getFluid(2000))
                .fluidOutputs(CarbonDioxide.getFluid(1000))
                .duration(250).EUt(VA[LV]).buildAndRegister();

        // Pd? -> Pd
        RecipeMaps.SIFTER_RECIPES.recipeBuilder()
                .input(dust, CrudePalladiumResidue)
                .chancedOutput(OreDictUnifier.get(dust, PalladiumMetallic), 9500, 0)
                .duration(600).EUt(VA[LV]).buildAndRegister();

    }

    private static void rhodiumProcess() {

        // KCl + H2SO4 -> KHSO4 + HCl
        RecipeMaps.CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, RockSalt, 2)
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .output(dust, PotassiumBisulfate, 7)
                .fluidOutputs(HydrochloricAcid.getFluid(1000))
                .duration(60).EUt(VA[LV]).buildAndRegister();

        // KNO3 + H2SO4 -> KHSO4 + HNO3
        RecipeMaps.CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, Saltpeter, 5)
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .output(dust, PotassiumBisulfate, 7)
                .fluidOutputs(NitricAcid.getFluid(1000))
                .duration(60).EUt(VA[LV]).buildAndRegister();

        // 2KHSO4 -> K2S2O7 + H2O
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, PotassiumBisulfate, 14)
                .output(dust, PotassiumPyrosulfate, 11)
                .fluidOutputs(Water.getFluid(1000))
                .duration(30).EUt(64).buildAndRegister();

        // K2SO4 + SO3 -> K2S2O7
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, PotassiumSulfate, 7)
                .fluidInputs(SulfurTrioxide.getFluid(1000))
                .output(dust, PotassiumPyrosulfate, 11)
                .duration(30).EUt(64).buildAndRegister();

        // TODO high efficiency roaster recipe
        // IrOsRuRh + 2K2S2O7 -> 1/3 Rh2(SO4)3 + 2K2SO4 + IrOsRu
        RecipeMaps.BLAST_RECIPES.recipeBuilder()
                .input(dust, PlatinumGroupResidue)
                .input(dust, PotassiumPyrosulfate, 11)
                .output(dust, RhodiumSulfate)
                .output(dust, PotassiumSulfate, 14)
                .output(dust, IridiumGroupSludge)
                .blastFurnaceTemp(1048)
                .duration(200).EUt(VA[MV]).buildAndRegister();

        // 2Rh2(SO4)3 + 2H2O -> 2H2O(Rh2(SO4)3) + IrOsRu
        RecipeMaps.CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, RhodiumSulfate, 6)
                .fluidInputs(Water.getFluid(2000))
                .output(dust, IridiumGroupSludge)
                .fluidOutputs(RhodiumSulfateSolution.getFluid(2000))
                .duration(300).EUt(VA[LV]).buildAndRegister();

        // H2O(Rh2(SO4)3) + 3Zn -> Rh2(H2O) + 3ZnSO4
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Zinc, 3)
                .fluidInputs(RhodiumSulfateSolution.getFluid(1000))
                .output(dust, ZincSulfate, 18)
                .output(dust, CrudeRhodiumResidue)
                .duration(300).EUt(VA[LV]).buildAndRegister();

        // todo equal efficiency roaster recipe
        // Rh2(H2O) + 2NaCl + 6Cl -> (NaCl)2(RhCl3)2 + H2O
        RecipeMaps.BLAST_RECIPES.recipeBuilder()
                .input(dust, CrudeRhodiumResidue)
                .input(dust, Salt, 4)
                .fluidInputs(Chlorine.getFluid(6000))
                .output(dust, RhodiumSalt)
                .fluidOutputs(Steam.getFluid(9600))
                .blastFurnaceTemp(848)
                .duration(300).EUt(VA[MV]).buildAndRegister();

        // (NaCl)2(RhCl3)2 + H2O -> (NaCl)2(RhCl3)2(H2O)
        RecipeMaps.MIXER_RECIPES.recipeBuilder()
                .input(dust, RhodiumSalt)
                .fluidInputs(Water.getFluid(1000))
                .fluidOutputs(RhodiumSaltSolution.getFluid(1000))
                .duration(30).EUt(VA[LV]).buildAndRegister();

        // NaOH + HNO3 -> NaNO3 + H2O
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, SodiumHydroxide, 3)
                .fluidInputs(NitricAcid.getFluid(1000))
                .output(dust, SodiumNitrate, 5)
                .fluidOutputs(Water.getFluid(1000))
                .duration(5).EUt(60).buildAndRegister();

        // 6NaNO3 + (NaCl)2(RhCl3)2(H2O) -> 2Rh(NO3)3 + 8NaCl + H2O
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, SodiumNitrate, 30)
                .fluidInputs(RhodiumSaltSolution.getFluid(1000))
                .output(dust, RhodiumNitrate, 26)
                .output(dust, Salt, 16)
                .fluidOutputs(Water.getFluid(1000))
                .duration(300).EUt(VA[LV]).buildAndRegister();

        // Rh(NO3)3 + 3K -> Rh + 3KNO3
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, RhodiumNitrate, 13)
                .input(dust, Potassium, 3)
                .output(dust, Rhodium)
                .output(dust, Saltpeter, 15)
                .duration(300).EUt(VA[LV]).buildAndRegister();

    }

    public static void rutheniumProcess() {

        // todo high efficiency roaster recipe
        // IrOsRu + 1/7 Na2CO3 -> 1/7 Na2RuO4 + 1/7 C + IrOs
        RecipeMaps.BLAST_RECIPES.recipeBuilder()
                .input(dust, IridiumGroupSludge)
                .input(dust, SodaAsh)
                .output(dust, SodiumRuthenate)
                .output(dust, Ash)
                .output(dust, RarestMetalMixture)
                .blastFurnaceTemp(1023)
                .duration(200).EUt(VA[MV]).buildAndRegister();

        // Na2RuO4 + 2Cl -> Na2RuO4(H2O)Cl2
        RecipeMaps.MIXER_RECIPES.recipeBuilder()
                .input(dust, SodiumRuthenate, 6)
                .fluidInputs(Chlorine.getFluid(2000))
                .fluidInputs(Water.getFluid(2000))
                .fluidOutputs(SodiumRuthenateChlorineSolution.getFluid(4000))
                .duration(300).EUt(VA[LV]).buildAndRegister();

        // Na2RuO4(Cl2) -> 2NaCl(H2O) + RuO4
        RecipeMaps.DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(SodiumRuthenateChlorineSolution.getFluid(4000))
                .output(dust, RutheniumTetroxide, 5)
                .fluidOutputs(SaltWater.getFluid(2000))
                .duration(1500).EUt(VA[HV]).buildAndRegister();

        // 2C + RuO4 -> Ru + 2CO2
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, RutheniumTetroxide, 5)
                .input(dust, Carbon, 2)
                .output(dust, Ruthenium)
                .fluidOutputs(CarbonDioxide.getFluid(2000))
                .duration(300).EUt(VA[LV]).buildAndRegister();
    }
}
