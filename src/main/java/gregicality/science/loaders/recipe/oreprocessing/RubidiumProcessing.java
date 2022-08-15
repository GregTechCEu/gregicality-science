package gregicality.science.loaders.recipe.oreprocessing;

import static gregicality.science.api.recipes.GCYSRecipeMaps.BURNER_REACTOR_RECIPES;
import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.CHEMICAL_BATH_RECIPES;
import static gregtech.api.recipes.RecipeMaps.CHEMICAL_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;

/**
 * The Rubidium Process
 *
 * <p>
 * Produces Rubidium and Caesium from Pollucite
 * </p>
 *
 * <p>Main Products: Rubidium, Caesium</p>
 * <p>Side Products: Alumina, Silicon Dioxide</p>
 *
 * <p>10 Pollucite -> 2 Caesium + 1 Rubidium</p>
 * <p>Loses 1 Tiny Tin and 111.11 Chlorine</p>
 */
public class RubidiumProcessing {

    public static void init() {
        // (Al2O3)Cs2(SiO2)2(H2O)2O + 3HCl -> RbCl(CsCl)2(H2O)2 + Al2O3 + 2SiO2 + O (lost)
        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, Pollucite, 10)
                .fluidInputs(HydrochloricAcid.getFluid(3000))
                .output(dust, Alumina)
                .output(dust, SiliconDioxide, 4)
                .fluidOutputs(HeavyAlkaliChlorideSolution.getFluid(1000))
                .duration(400).EUt(VA[EV]).buildAndRegister();

        // Sn + 4Cl -> SnCl4
        BURNER_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Tin)
                .fluidInputs(Chlorine.getFluid(4000))
                .fluidOutputs(StannicChloride.getFluid(1000))
                .temperature(388)
                .duration(100).EUt(VA[HV]).buildAndRegister();

        // 2RbCl(CsCl)2(H2O)2 + 3SnCl4 -> Rb2SnCl6 + 2Cs2SnCl6 + 4H2O
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(HeavyAlkaliChlorideSolution.getFluid(1000))
                .fluidInputs(StannicChloride.getFluid(1500))
                .output(dust, RubidiumChlorostannate, 4)
                .output(dust, CaesiumChlorostannate, 9)
                .fluidOutputs(Water.getFluid(2000))
                .duration(400).EUt(VA[EV]).buildAndRegister();
    }
}
