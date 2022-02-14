package gregicality.science.loaders.recipe.chain;

import gregicality.science.common.GCYSConfigHolder;
import gregicality.science.common.items.GCYSMetaItems;
import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.api.unification.OreDictUnifier;
import gregtech.common.items.MetaItems;

import static gregicality.multiblocks.api.unification.GCYMMaterials.HSLASteel;
import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class GrapheneChain {

    public static void init() {
        // Remove Graphene Mixing
        if (GCYSConfigHolder.chainOverrides.disableGrapheneProcessing) {
            GTRecipeHandler.removeRecipesByInputs(RecipeMaps.MIXER_RECIPES,
                    OreDictUnifier.get(dust, Graphite),
                    OreDictUnifier.get(dust, Carbon, 4),
                    OreDictUnifier.get(dust, Silicon),
                    IntCircuitIngredient.getIntegratedCircuit(1));
        }

        // G -> GO
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Graphite)
                .fluidInputs(NitrationMixture.getFluid(2000))
                .notConsumable(dust, SodiumHydroxide)
                .output(dust, GrapheneOxide)
                .fluidOutputs(DilutedSulfuricAcid.getFluid(1000))
                .fluidOutputs(NitricAcid.getFluid(1000))
                .duration(100).EUt(VA[HV]).buildAndRegister();

        // G -> G
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Graphite)
                .fluidInputs(NitrationMixture.getFluid(2000))
                .notConsumable(GCYSMetaItems.MAGNETRON.getStackForm())
                .output(dust, Graphene)
                .fluidOutputs(DilutedSulfuricAcid.getFluid(1000))
                .fluidOutputs(NitricAcid.getFluid(1000))
                .duration(100).EUt(VA[HV]).buildAndRegister();

        // GO -> G
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, GrapheneOxide)
                .fluidInputs(Hydrazine.getFluid(100))
                .fluidInputs(Argon.getFluid(50))
                .output(dust, Graphene)
                .duration(100).EUt(VA[HV]).buildAndRegister();

        // Peroxide Process

        // 2NH3 + H2O2 -> N2H4 + 2H2O
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Ammonia.getFluid(2000))
                .fluidInputs(HydrogenPeroxide.getFluid(1000))
                .fluidOutputs(Hydrazine.getFluid(1000))
                .fluidOutputs(Water.getFluid(2000))
                .duration(80).EUt(VA[HV]).buildAndRegister();

        // Magnetron

        // Be + O -> BeO
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Beryllium)
                .fluidInputs(Oxygen.getFluid(1000))
                .output(dust, BerylliumOxide, 2)
                .duration(60).EUt(VA[LV]).buildAndRegister();

        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .input(ring, BerylliumOxide, 64)
                .input(ring, BerylliumOxide, 64)
                .input(plate, HSLASteel, 6)
                .inputs(MetaItems.VACUUM_TUBE.getStackForm())
                .outputs(GCYSMetaItems.MAGNETRON.getStackForm())
                .duration(600).EUt(VA[IV]).buildAndRegister();

        // TODO LIG Graphene
    }
}
