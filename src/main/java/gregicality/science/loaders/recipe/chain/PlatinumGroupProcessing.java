package gregicality.science.loaders.recipe.chain;

import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;

import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;

public class PlatinumGroupProcessing {

    public static void init() {
        platinumProcess();
        palladiumProcess();
    }

    private static void platinumProcess() {

        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ELECTROLYZER_RECIPES, OreDictUnifier.get(OrePrefix.dust, Materials.PlatinumRaw, 3));

        // HNO3(HCl) + PtPd? -> PtPd(HNO3)(HCl) + ?
        RecipeMaps.CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, PlatinumGroupSludge)
                .fluidInputs(AquaRegia.getFluid(1000))
                .output(dust, PlatinumGroupResidue)
                .fluidOutputs(PlatinumPalladiumLeachate.getFluid(1000))
                .duration(250).EUt(VA[LV]).buildAndRegister();

        // HNO3(HCl) + PtPd? -> PtPd(HNO3)(HCl) + ?(HNO3)
        RecipeMaps.CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, PlatinumMetallic, 2)
                .fluidInputs(AquaRegia.getFluid(1000))
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
                .output(dust, CrudePlatinumResidue, 10)
                .fluidOutputs(PalladiumRichAmmonia.getFluid(1000))
                .duration(1200).EUt(VA[LV]).buildAndRegister();

        // (NH4)2PtCl6 -> 2NH3 + H2PtCl6
        RecipeMaps.ELECTROLYZER_RECIPES.recipeBuilder()
                .input(dust, AmmoniumHexachloroplatinate, 9)
                .fluidOutputs(Ammonia.getFluid(2000))
                .fluidOutputs(ChloroplatinicAcid.getFluid(1000))
                .duration(30).EUt(VA[LV]).buildAndRegister();

        // H2PtCl6 -> PtCl2 + 4HCl (intentionally gains H)
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
                .input(dust, CrudePlatinumResidue, 10)
                .output(dust, PlatinumMetallic)
                .chancedOutput(OreDictUnifier.get(dust, PlatinumMetallic), 7500, 0)
                .duration(600).EUt(VA[LV]).buildAndRegister();
    }

    private static void palladiumProcess() {

    }
}
