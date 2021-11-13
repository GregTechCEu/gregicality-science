package gregicality.science.recipes;

import crafttweaker.annotations.ZenRegister;
import gregicality.science.recipes.impl.*;
import gregicality.science.recipes.impl.nuclear.HotCoolantRecipeMap;
import gregicality.science.recipes.impl.QubitProducerRecipeBuilder;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.widgets.ProgressWidget;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.builders.IntCircuitRecipeBuilder;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;
import gregtech.api.recipes.machines.FuelRecipeMap;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenProperty;

@ZenClass("mods.gtadditions.recipe.GARecipeMaps")
@ZenRegister

public class GARecipeMaps {

    // Simple Recipe Maps ==============================================================================================

    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> CHEMICAL_DEHYDRATOR_RECIPES = new RecipeMap<>("chemical_dehydrator",
            0, 2, 0, 9, 0, 2, 0, 2, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_SIFT, ProgressWidget.MoveType.HORIZONTAL);


    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> DECAY_CHAMBERS_RECIPES = new RecipeMap<>("decay_chamber",
            0, 1, 0, 1, 0, 1, 0, 1, new SimpleRecipeBuilder().EUt(32), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_HAMMER, ProgressWidget.MoveType.VERTICAL);


    @ZenProperty
    public static final RecipeMap<IntCircuitRecipeBuilder> GREEN_HOUSE_RECIPES = new RecipeMap<>("green_house",
            1, 3, 0, 2, 0, 1, 0, 0, new IntCircuitRecipeBuilder().EUt(16), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_HAMMER, ProgressWidget.MoveType.VERTICAL);


    // Multiblock Recipe Maps ==========================================================================================

    @ZenProperty
    public static final RecipeMap<NuclearReactorBuilder> NUCLEAR_REACTOR_RECIPES = new RecipeMap<>("nuclear_reactor",
            1, 3, 1, 2, 0, 0, 0, 0, new NuclearReactorBuilder().EUt(480), false);


    @ZenProperty
    public static final RecipeMap<NuclearReactorBuilder> NUCLEAR_BREEDER_RECIPES = new RecipeMap<>("nuclear_breeder",
            1, 3, 1, 4, 0, 0, 0, 0, new NuclearReactorBuilder().EUt(480), false);


    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> BIO_REACTOR_RECIPES = new RecipeMap<>("bio_reactor",
            0, 3, 0, 3, 0, 5, 0, 2, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressWidget.MoveType.HORIZONTAL);


    @ZenProperty
    public static final RecipeMap<QubitProducerRecipeBuilder> SIMPLE_QUBIT_GENERATOR = new RecipeMap<>("simple_qubit_generator",
            1, 1, 0, 0, 0, 0, 0, 0, new QubitProducerRecipeBuilder(), false);


    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> STELLAR_FORGE_RECIPES = new RecipeMap<>("stellar_forge",
            1, 3, 0, 2, 0, 3, 0, 2, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_BATH, ProgressWidget.MoveType.HORIZONTAL);


    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> PLASMA_CONDENSER_RECIPES = new RecipeMap<>("plasma_condenser",
            1, 2, 0, 2, 1, 2, 0,2, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_BATH, ProgressWidget.MoveType.HORIZONTAL);


    @ZenProperty
    public static final RecipeMap<IntCircuitRecipeBuilder> GAS_CENTRIFUGE_RECIPES = new RecipeMap<>("gas_centrifuge",
            0, 1, 0, 0, 1, 1, 0, 3, new IntCircuitRecipeBuilder(), false)
            .setSlotOverlay(false, false, GuiTextures.CIRCUIT_OVERLAY)
            .setProgressBar(GuiTextures.PROGRESS_BAR_BATH, ProgressWidget.MoveType.VERTICAL_INVERTED);


    @ZenProperty
    public static final RecipeMap<AdvFusionRecipeBuilder> ADV_FUSION_RECIPES = new RecipeMap<>("adv_fusion",
            0, 0, 0, 0, 2, 3, 1, 3, new AdvFusionRecipeBuilder(), false);


    // Fuel Recipe Maps ================================================================================================

    @ZenProperty
    public static final FuelRecipeMap ROCKET_FUEL_RECIPES = new FuelRecipeMap("rocket_fuel");


    @ZenProperty
    public static final FuelRecipeMap NAQUADAH_REACTOR_FUELS = new FuelRecipeMap("naquadah_reactor");


    @ZenProperty
    public static final FuelRecipeMap HYPER_REACTOR_FUELS = new FuelRecipeMap("hyper_reactor");


    @ZenProperty
    public static final HotCoolantRecipeMap HOT_COOLANT_TURBINE_FUELS = new HotCoolantRecipeMap("hot_coolant_turbine");
}
