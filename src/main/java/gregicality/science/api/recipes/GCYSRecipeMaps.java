package gregicality.science.api.recipes;

import crafttweaker.annotations.ZenRegister;
import gregicality.science.api.recipes.builders.NoCoilTemperatureRecipeBuilder;
import gregicality.science.api.recipes.builders.PressureRecipeBuilder;
import gregicality.science.api.recipes.builders.TemperaturePressureRecipeBuilder;
import gregicality.science.client.render.GCYSGuiTextures;
import gregtech.api.GTValues;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.widgets.ProgressWidget;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.builders.BlastRecipeBuilder;
import gregtech.api.recipes.builders.FuelRecipeBuilder;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;
import gregtech.api.sound.GTSounds;
import stanhebben.zenscript.annotations.ZenExpansion;

@ZenExpansion("mods.gregtech.recipe.RecipeMaps")
@ZenRegister
public class GCYSRecipeMaps {

    // Machines

    public static final RecipeMap<SimpleRecipeBuilder> DRYER_RECIPES = new RecipeMap<>("dryer_recipes", 0, 1, 0, 2, 0, 1, 0, 1, new SimpleRecipeBuilder(), false)
            .setSlotOverlay(false, false, true, GuiTextures.FURNACE_OVERLAY_1)
            .setSlotOverlay(false, true, true, GuiTextures.FURNACE_OVERLAY_2)
            .setSlotOverlay(true, false, false, GuiTextures.DUST_OVERLAY)
            .setSlotOverlay(true, false, true, GuiTextures.DUST_OVERLAY)
            .setSound(GTSounds.FURNACE);

    public static final RecipeMap<BlastRecipeBuilder> CRYSTALLIZER_RECIPES = new RecipeMap<>("crystallization_recipes", 0, 6, 1, 1, 0, 3, 0, 0, new BlastRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_CRYSTALLIZATION, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSounds.FURNACE);

    public static final RecipeMap<NoCoilTemperatureRecipeBuilder> ROASTER_RECIPES = new RecipeMap<>("roaster_recipes", 0, 3, 0, 3, 0, 3, 0, 3, new NoCoilTemperatureRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSounds.FURNACE);

    public static final RecipeMap<PressureRecipeBuilder> PRESSURE_CHAMBER_RECIPES = new RecipeMap<>("pressure_chamber_recipes", 1, 4, 1, 1, 0, 0, 0, 0, new PressureRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_COMPRESS, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSounds.COMPRESSOR);

    public static final RecipeMap<SimpleRecipeBuilder> CATALYTIC_REFORMER_RECIPES = new RecipeMap<>("catalytic_reformer_recipes", 1, 1, 0, 0, 1, 1, 1, 4, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_CRACKING, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSounds.FURNACE);

    public static final RecipeMap<TemperaturePressureRecipeBuilder> BURNER_REACTOR_RECIPES = new RecipeMap<>("burner_reactor_recipes", 0, 3, 0, 2, 0, 3, 0, 3, new TemperaturePressureRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARC_FURNACE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSounds.ARC);

    public static final RecipeMap<NoCoilTemperatureRecipeBuilder> CRYOGENIC_REACTOR_RECIPES = new RecipeMap<>("cryogenic_reactor_recipes", 0, 3, 0, 2, 0, 2, 0, 2, new NoCoilTemperatureRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSounds.COOLING);

    public static final RecipeMap<TemperaturePressureRecipeBuilder> CVD_RECIPES = new RecipeMap<>("cvd_recipes", 0, 2, 0, 2, 0, 3, 0, 3, new TemperaturePressureRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSounds.COOLING);

    public static final RecipeMap<TemperaturePressureRecipeBuilder> PLASMA_CVD_RECIPES = new RecipeMap<>("plasma_cvd_recipes", 0, 2, 0, 2, 0, 4, 0, 4, new TemperaturePressureRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSounds.COOLING);

    public static final RecipeMap<NoCoilTemperatureRecipeBuilder> MOLECULAR_BEAM_RECIPES = new RecipeMap<>("molecular_beam_recipes", 1, 5, 1, 1, 0, 2, 0, 1, new NoCoilTemperatureRecipeBuilder(), false)
            .setSlotOverlay(false, false, false, GCYSGuiTextures.NANOSCALE_OVERLAY_1)
            .setSlotOverlay(false, false, true, GCYSGuiTextures.NANOSCALE_OVERLAY_1)
            .setSlotOverlay(false, true, false, GCYSGuiTextures.NANOSCALE_OVERLAY_2)
            .setSlotOverlay(false, true, true, GCYSGuiTextures.NANOSCALE_OVERLAY_2)
            .setSlotOverlay(true, false, true, GCYSGuiTextures.NANOSCALE_OVERLAY_1)
            .setSlotOverlay(true, true, true, GCYSGuiTextures.NANOSCALE_OVERLAY_2)
            .setProgressBar(GCYSGuiTextures.PROGRESS_BAR_NANOSCALE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSounds.ELECTROLYZER);

    public static final RecipeMap<SimpleRecipeBuilder> SONICATION_RECIPES = new RecipeMap<>("sonication_recipes", 0, 0, 0, 1, 2, 2, 1, 1, new SimpleRecipeBuilder(), false)
            .setSlotOverlay(false, true, false, GuiTextures.BREWER_OVERLAY)
            .setSlotOverlay(false, true, true, GuiTextures.MOLECULAR_OVERLAY_3)
            .setSlotOverlay(true, true, true, GuiTextures.MOLECULAR_OVERLAY_4)
            .setSlotOverlay(true, false, true, GCYSGuiTextures.FOIL_OVERLAY)
            .setProgressBar(GuiTextures.PROGRESS_BAR_EXTRACT, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSounds.CENTRIFUGE);

    public static final RecipeMap<SimpleRecipeBuilder> ION_IMPLANTATOR_RECIPES = new RecipeMap<>("ion_implanter_recipes", 1, 3, 1, 1, 0, 1, 0, 0, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSounds.ELECTROLYZER);

    public static final RecipeMap<SimpleRecipeBuilder> SUPERHEAVY_RECIPES = new RecipeMap<>("superheavy_reactor_recipes", 0, 2, 0, 4, 0, 4, 0, 2, new SimpleRecipeBuilder(), false)
            .setSlotOverlay(false, false, false, GuiTextures.MOLECULAR_OVERLAY_1)
            .setSlotOverlay(false, false, true, GuiTextures.MOLECULAR_OVERLAY_2)
            .setSlotOverlay(false, true, false, GuiTextures.MOLECULAR_OVERLAY_3)
            .setSlotOverlay(false, true, true, GuiTextures.MOLECULAR_OVERLAY_4)
            .setSlotOverlay(true, false, GuiTextures.VIAL_OVERLAY_1)
            .setSlotOverlay(true, true, GuiTextures.VIAL_OVERLAY_2)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTValues.FOOLS.get() ? GTSounds.SCIENCE : GTSounds.CHEMICAL_REACTOR);

    public static final RecipeMap<SimpleRecipeBuilder> DRILLING_RECIPES = new RecipeMap<>("drill_recipes", 1, 1, 0, 1, 0, 0, 0, 1, new SimpleRecipeBuilder(), false)
            .setSlotOverlay(false, false, true, GuiTextures.CRUSHED_ORE_OVERLAY)
            .setSlotOverlay(true, false, true, GuiTextures.DUST_OVERLAY)
            .setSound(GTSounds.MACERATOR);

    // Generators

    public static final RecipeMap<FuelRecipeBuilder> TARANIUM_REACTOR_MK1_RECIPES = new RecipeMap<>("taranium_reactor_mk1_recipes", 0, 0, 0, 0, 1, 1, 0, 0, new FuelRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSounds.ARC);

    public static final RecipeMap<FuelRecipeBuilder> TARANIUM_REACTOR_MK2_RECIPES = new RecipeMap<>("taranium_reactor_mk2_recipes", 0, 0, 0, 0, 1, 1, 0, 0, new FuelRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSounds.ARC);

    public static final RecipeMap<FuelRecipeBuilder> TARANIUM_REACTOR_MK3_RECIPES = new RecipeMap<>("taranium_reactor_mk3_recipes", 0, 0, 0, 0, 1, 1, 0, 0, new FuelRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSounds.ARC);

    // Other

    public static final RecipeMap<SimpleRecipeBuilder> STEAM_EJECTOR_RECIPES = new RecipeMap<>("vacuum_ejector", 0, 0, 0, 0, 1, 1, 0, 0, new SimpleRecipeBuilder(), true)
            .setSlotOverlay(false, true, true, GuiTextures.EXTRACTOR_OVERLAY)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSounds.CENTRIFUGE);
}
