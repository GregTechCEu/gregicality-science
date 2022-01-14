package gregicality.science.loaders.recipe.chain;

import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Materials;
import gregtech.common.items.MetaItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;

public class PlatinumGroupProcessing {

    public static void init() {
        removeGTCERecipes();
        platinumProcess();
        palladiumProcess();
    }

    private static void removeGTCERecipes() {
        // Remove Raw Platinum -> Platinum
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ELECTROLYZER_RECIPES, OreDictUnifier.get(dust, Materials.PlatinumRaw, 3));

        // Remove Raw Palladium -> Palladium
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.CHEMICAL_RECIPES,
                new ItemStack[]{OreDictUnifier.get(dust, PalladiumRaw, 5)},
                new FluidStack[]{HydrochloricAcid.getFluid(1000)});
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.LARGE_CHEMICAL_RECIPES,
                new ItemStack[]{OreDictUnifier.get(dust, PalladiumRaw, 5)},
                new FluidStack[]{HydrochloricAcid.getFluid(1000)});

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
}
