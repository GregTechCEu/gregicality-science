package gregicality.science.loaders.recipe.circuits;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;

import static gregicality.science.api.recipes.GCYSRecipeMaps.MOLECULAR_BEAM_RECIPES;
import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregicality.science.common.items.GCYSMetaItems.SPIN_TRANSFER_TORQUE_MEMORY;
import static gregicality.science.common.items.GCYSMetaItems.TOPOLOGICAL_INSULATOR_TUBE;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class SpintronicCircuits {

    public static void init() {
        sttram();
        topologicalIsolators();
    }

    private static void sttram() {
        FORMING_PRESS_RECIPES.recipeBuilder()
                .input(plate, PlutoniumPhosphide)
                .input(foil, Lithium6)
                .output(SPIN_TRANSFER_TORQUE_MEMORY)
                .duration(200).EUt(VA[UEV]).buildAndRegister();
    }

    private static void topologicalIsolators() {
        MOLECULAR_BEAM_RECIPES.recipeBuilder()
                .input(dust, Bismuth)
                .input(dust, Antimony)
                .input(dust, Tellurium, 2)
                .input(dust, Sulfur)
                .notConsumable(plate, CadmiumSulfide)
                .output(dust, BismuthChalcogenide, 5)
                .duration(80).EUt(VA[UV]).buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dust, Cadmium)
                .input(dust, Tellurium, 2)
                .fluidInputs(Mercury.getFluid(2000))
                .output(dust, MercuryCadmiumTelluride, 5)
                .notConsumable(new IntCircuitIngredient(1))
                .duration(400).EUt(VA[UHV]).buildAndRegister();

        CANNER_RECIPES.recipeBuilder()
                .input(wireFine, MercuryCadmiumTelluride, 16)
                .input(spring, CarbonNanotube)
                .output(TOPOLOGICAL_INSULATOR_TUBE)
                .cleanroom(CleanroomType.CLEANROOM)
                .duration(20).EUt(VA[HV]).buildAndRegister();
    }
}
