package gregicality.science.api.recipes;

import crafttweaker.annotations.ZenRegister;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.widgets.ProgressWidget;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.builders.BlastRecipeBuilder;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;
import gregtech.api.sound.GTSounds;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenProperty;

@ZenExpansion("mods.gregtech.recipe.RecipeMaps")
@ZenRegister
public class GCYSRecipeMaps {

    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> STEAM_EJECTOR_RECIPES = new RecipeMap<>("vacuum_ejector", 0, 0, 0, 0, 1, 1, 0, 0, new SimpleRecipeBuilder(), true)
            .setSlotOverlay(false, true, true, GuiTextures.EXTRACTOR_OVERLAY)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSounds.CENTRIFUGE);

    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> DRYER_RECIPES = new RecipeMap<>("dryer_recipes", 0, 1, 1, 2, 0, 1, 0, 1, new SimpleRecipeBuilder(), false)
            .setSlotOverlay(false, false, true, GuiTextures.FURNACE_OVERLAY_1)
            .setSlotOverlay(false, true, true, GuiTextures.FURNACE_OVERLAY_2)
            .setSlotOverlay(true, false, false, GuiTextures.DUST_OVERLAY)
            .setSlotOverlay(true, false, true, GuiTextures.DUST_OVERLAY)
            .setSound(GTSounds.FURNACE);

    @ZenProperty
    public static final RecipeMap<BlastRecipeBuilder> CRYSTALLIZER_RECIPES = new RecipeMap<>("crystallization_recipes", 0, 6, 1, 1, 0, 3, 0, 0, new BlastRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_CRYSTALLIZATION, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSounds.FURNACE);

    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> BIO_VAT_RECIPES = new RecipeMap<>("bio_vat_recipes", 0, 3, 0, 3, 0, 4, 0, 4, new SimpleRecipeBuilder(), false)
            .setSound(GTSounds.CHEMICAL_REACTOR);

    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> CATALYTIC_REFORMER_RECIPES = new RecipeMap<>("catalytic_reformer_recipes", 1, 1, 0, 0, 1, 1, 1, 4, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_CRACKING, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSounds.FURNACE);

    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> GREENHOUSE_RECIPES = new RecipeMap<>("greenhouse_recipes", 0, 3, 0, 3, 0, 3, 0, 3, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_BATH, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSounds.BATH);

    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> BUTCHERY_RECIPES = new RecipeMap<>("butchery_recipes", 0, 1, 0, 3, 0, 0, 0, 1, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.CUTTER_OVERLAY, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSounds.CUT);

}
