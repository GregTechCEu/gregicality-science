package gregicality.science.loaders.recipe.oreprocessing;

import static gregicality.science.api.recipes.GCYSRecipeMaps.ROASTER_RECIPES;
import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;

/**
 * The Waelz Process
 *
 * <p>Produces Germanium from Sphalerite</p>
 *
 * <p>Main Products: Germanium</p>
 * <p>Side Products: Zinc, Gallium, Manganese</p>
 *
 * <p>2 Sphalerite -> 1 Germanium</p>
 *
 */
public class GermaniumProcessing {

    public static void init() {
        // ZnS + 5O -> GeO2 + ZnO + SO2
        ROASTER_RECIPES.recipeBuilder()
                .input(dust, Sphalerite, 2)
                .fluidInputs(Oxygen.getFluid(5000))
                .output(dust, RoastedSphalerite, 3)
                .output(dust, ZincOxide, 2)
                .fluidOutputs(SulfurDioxide.getFluid(1000))
                .temperature(1773)
                .duration(200).EUt(VA[HV]).buildAndRegister();

        // GeO2 + 2Zn -> Zn2(GeO2)
        MIXER_RECIPES.recipeBuilder()
                .input(dust, RoastedSphalerite, 3)
                .input(dust, Zinc, 2)
                .output(dust, ZincRichSphalerite, 5)
                .duration(320).EUt(VA[LV]).buildAndRegister();

        // Zn2(GeO2) + H2SO4 -> ZnGeO2 + ZnSO4 + 2H (lost)
        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, ZincRichSphalerite, 5)
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .output(dust, WaelzOxide)
                .output(dust, WaelzSlag, 5)
                .duration(400).EUt(VA[LV]).buildAndRegister();

        // ZnSO4 + H2O -> ZnO + H2SO4
        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, WaelzSlag, 5)
                .fluidInputs(Water.getFluid(1000))
                .output(dust, ZincOxide, 2)
                .chancedOutput(dust, Gallium, 2000, 1000)
                .fluidOutputs(SulfuricAcid.getFluid(1000))
                .duration(160).EUt(VA[HV]).buildAndRegister();

        // ZnGeO2 + H2SO4 -> GeO2 + ZnSO4 + 2H (lost)
        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, WaelzOxide)
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .output(dust, ImpureGermaniumDioxide, 3)
                .output(dust, WaelzSlag, 5)
                .chancedOutput(dust, Manganese, 1000, 1000)
                .duration(200).EUt(VA[HV]).buildAndRegister();

        // GeO2 + 4HCl -> GeCl4 + 2H2O
        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, ImpureGermaniumDioxide, 3)
                .fluidInputs(HydrochloricAcid.getFluid(4000))
                .chancedOutput(dust, Cadmium, 500, 1000)
                .fluidOutputs(GermaniumTetrachloride.getFluid(1000))
                .fluidOutputs(Water.getFluid(2000))
                .duration(300).EUt(VA[HV]).buildAndRegister();

        // GeCl4 + 2H2O -> GeO2 + 4HCl
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(GermaniumTetrachloride.getFluid(1000))
                .fluidInputs(Water.getFluid(2000))
                .output(dust, GermaniumDioxide, 3)
                .fluidOutputs(HydrochloricAcid.getFluid(4000))
                .duration(100).EUt(VA[LV]).buildAndRegister();

        // GeO2 + 4HCl -> GeCl4 + 2H2O
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, GermaniumDioxide, 3)
                .fluidInputs(HydrochloricAcid.getFluid(4000))
                .fluidOutputs(GermaniumTetrachloride.getFluid(1000))
                .fluidOutputs(Water.getFluid(2000))
                .duration(100).EUt(VA[LV]).buildAndRegister();

        // GeO2 + 4H -> Ge + 2H2O
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, GermaniumDioxide, 3)
                .fluidInputs(Hydrogen.getFluid(4000))
                .output(dust, Germanium)
                .fluidOutputs(Water.getFluid(2000))
                .duration(240).EUt(VA[EV]).buildAndRegister();
    }
}
