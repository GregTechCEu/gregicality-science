package gregicality.science.loaders.recipe.chain;

import gregtech.api.recipes.ingredients.IntCircuitIngredient;

import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.CHEMICAL_RECIPES;
import static gregtech.api.recipes.RecipeMaps.LARGE_CHEMICAL_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;

public class KaptonChain {

    public static void init() {
        pmda();
        oda();
        bpda();
        ppd();
        kapton();
    }

    private static void pmda() {
        // C6H4(CH3)2 + 2CH3Cl -> C6H2(CH3)4 + 2HCl
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(ParaXylene.getFluid(1000))
                .fluidInputs(Chloromethane.getFluid(2000))
                .output(dust, Durene, 24)
                .fluidOutputs(HydrochloricAcid.getFluid(2000))
                .duration(120).EUt(VA[MV]).buildAndRegister();

        // C6H2(CH3)4 + 12O → C6H2(C2O3)2 + 6H2O
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Durene, 4)
                .fluidInputs(Oxygen.getFluid(2000))
                .output(dust, PyromelliticDianhydride, 3)
                .fluidOutputs(Water.getFluid(1000))
                .duration(30).EUt(VA[HV]).buildAndRegister();
    }

    private static void oda() {
        // C6H5NO2 + 4H -> HOC6H4NH2 + H2O
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Nitrobenzene.getFluid(1000))
                .fluidInputs(Hydrogen.getFluid(4000))
                .notConsumable(new IntCircuitIngredient(1))
                .fluidOutputs(Aminophenol.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .duration(300).EUt(VA[LV]).buildAndRegister();

        // 2C6H5NH2 + C2H5OH -> C12H12N2O + 2CH4
        CHEMICAL_RECIPES.recipeBuilder()
                .notConsumable(dust, Tin)
                .fluidInputs(Aniline.getFluid(2000))
                .fluidInputs(Phenol.getFluid(1000))
                .notConsumable(HydrochloricAcid.getFluid())
                .output(dust, Oxydianiline, 27)
                .fluidOutputs(Methane.getFluid(2000))
                .duration(100).EUt(VA[ZPM]).buildAndRegister();

        // HOC6H4NH2 + ClC6H4NO2 + H2O -> C12H12N2O + 3O + HCl
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .notConsumable(dust, Saltpeter)
                .fluidInputs(Aminophenol.getFluid(1000))
                .fluidInputs(Nitrochlorobenzene.getFluid(1000))
                .fluidInputs(Water.getFluid(1000))
                .notConsumable(Dimethylformamide.getFluid())
                .output(dust, Oxydianiline, 27)
                .fluidOutputs(Oxygen.getFluid(3000))
                .fluidOutputs(HydrochloricAcid.getFluid(1000))
                .duration(200).EUt(VA[LV]).buildAndRegister();
    }

    private static void bpda() {
        // C8H4O3 -> C16H6O6 + 2H
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, PhthalicAnhydride, 13)
                .notConsumable(dust, Palladium)
                .output(dust, BiphenylTetracarboxylicAcidDianhydride, 28)
                .fluidOutputs(Hydrogen.getFluid(2000))
                .duration(200).EUt(VA[HV]).buildAndRegister();
    }

    private static void ppd() {
        // ClC6H4NO2 + 2NH3 -> H2NC6H4NO2 + NH4Cl
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Nitrochlorobenzene.getFluid(1000))
                .fluidInputs(Ammonia.getFluid(2000))
                .fluidOutputs(Nitroaniline.getFluid(1000))
                .output(dust, AmmoniumChloride, 2)
                .duration(100).EUt(VA[HV]).buildAndRegister();

        // H2NC6H4NO2 + 6H -> H2NC6H4NH2 + 2H2O
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Nitroaniline.getFluid(1000))
                .fluidInputs(Hydrogen.getFluid(6000))
                .output(dust, ParaPhenylenediamine, 16)
                .fluidOutputs(Water.getFluid(2000))
                .duration(200).EUt(VA[IV]).buildAndRegister();
    }

    private static void kapton() {
        // 2C6H2(C2O3)2 + C12H12N2O -> C22H10N2O5 + 10C + 6H + 2O (lossy)
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, PyromelliticDianhydride, 2)
                .input(dust, Oxydianiline, 3)
                .fluidOutputs(KaptonK.getFluid(L))
                .duration(30).EUt(VA[IV]).buildAndRegister();

        // 2C6H2(C2O3)2 + C12H12N2O + C16H6O6 + H2NC6H4NH2 -> C24H18N2O5 + 30C + 12H + 14O + 2N (lossy)
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, BiphenylTetracarboxylicAcidDianhydride, 2)
                .input(dust, ParaPhenylenediamine)
                .fluidInputs(KaptonK.getFluid(L))
                .fluidOutputs(KaptonE.getFluid(L))
                .duration(30).EUt(VA[ZPM]).buildAndRegister();
    }
}
