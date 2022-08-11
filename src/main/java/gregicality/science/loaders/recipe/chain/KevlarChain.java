package gregicality.science.loaders.recipe.chain;

import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static gregtech.api.unification.ore.OrePrefix.foil;

public class KevlarChain {

    public static void init() {
        // C6H4(CH3)2 + 6O -> C6H4(CO2H)2 + 2H2O
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(ParaXylene.getFluid(1000))
                .fluidInputs(Chlorine.getFluid(6000))
                .fluidOutputs(Bistrichloromethylbenzene.getFluid(1000))
                .fluidOutputs(Hydrogen.getFluid(6000))
                .duration(200)
                .EUt(VA[EV])
                .buildAndRegister();

        // Amoco Process for Terephthalic Acid

        // 4Br + C2H2 -> C2H2Br4
        // TODO Vacuum
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Bromine.getFluid(4000))
                .fluidInputs(Acetylene.getFluid(1000))
                .fluidOutputs(Tetrabromoethane.getFluid(1000))
                .duration(80)
                .EUt(VA[LV])
                .buildAndRegister();

        // C6H4(CH3)2 + 6O -> C6H4(CO2H)2 + 2H2O
        LARGE_CHEMICAL_RECIPES.recipeBuilder() // TODO corrosion proof reactor
                .input(foil, Titanium, 10)
                .notConsumable(dust, Manganese)
                .notConsumable(dust, Cobalt)
                .notConsumable(Acetone.getFluid())
                .fluidInputs(ParaXylene.getFluid(1000))
                .fluidInputs(Tetrabromoethane.getFluid(50))
                .fluidInputs(Air.getFluid(12000)) // TODO compressed air
                .output(dust, TerephthalicAcid, 3)
                .fluidOutputs(Water.getFluid(2000))
                .duration(240)
                .EUt(VA[ZPM])
                .buildAndRegister();

        // C6H4(CCl3)2 + C6H4(CO2H)2 -> 2 C6H4(COCl)2 + 2 HCl
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, TerephthalicAcid, 3)
                .fluidInputs(Bistrichloromethylbenzene.getFluid(1000))
                .output(dust, TerephthaloylChloride, 6)
                .fluidOutputs(HydrochloricAcid.getFluid(2000))
                .duration(100)
                .EUt(240)
                .buildAndRegister();

        // C4H8 + HClO + H2O -> C4H10O2 + HCl
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Butene.getFluid(1000))
                .fluidInputs(HypochlorousAcid.getFluid(1000))
                .fluidInputs(Water.getFluid(1000))
                .fluidOutputs(Butanediol.getFluid(1000))
                .fluidOutputs(HydrochloricAcid.getFluid(1000))
                .duration(60)
                .EUt(VA[HV])
                .buildAndRegister();

        // C4H10O2 -> C4H6O2 + 4H (4H lost)
        BREWING_RECIPES.recipeBuilder()
                .input(dust, Copper)
                .fluidInputs(Butanediol.getFluid(1000))
                .fluidOutputs(GammaButyrolactone.getFluid(1000))
                .duration(120)
                .EUt(VA[EV])
                .buildAndRegister();

        // CH3NH2 + C4H6O2 -> C5H9NO + H2O
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Methylamine.getFluid(1000))
                .fluidInputs(GammaButyrolactone.getFluid(1000))
                .fluidOutputs(NMethylPyrrolidone.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .duration(240)
                .EUt(VA[IV])
                .buildAndRegister();

        // Ca + 2Cl -> CaCl2
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Calcium)
                .fluidInputs(Chlorine.getFluid(2000))
                .output(dust, CalciumChloride, 3)
                .duration(80).EUt(VA[LV]).buildAndRegister();

        // C6H4(NH2)2 + C6H4(COCl)2 -> [-CO-C6H4-CO-NH-C6H4-NH-]n + 2HCl
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, CalciumChloride)
                .input(dust, ParaPhenylenediamine, 8)
                .input(dust, TerephthaloylChloride, 3)
                .fluidInputs(NMethylPyrrolidone.getFluid(100))
                .fluidInputs(SulfuricAcid.getFluid(500))
                .output(dust, Kevlar, 4)
                .fluidOutputs(HydrochloricAcid.getFluid(1000))
                .duration(400)
                .EUt(VA[UV]).buildAndRegister();
    }
}
