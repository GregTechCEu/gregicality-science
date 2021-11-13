package gregicality.science.jei;

import com.google.common.collect.ImmutableMap;
import gregicality.science.jei.multi.*;
import gregicality.science.jei.multi.advance.*;
import gregicality.science.jei.multi.miner.*;
import gregicality.science.jei.multi.quantum.*;
import gregtech.integration.jei.multiblock.MultiblockInfoRecipeWrapper;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.gui.recipes.RecipeLayout;
import net.minecraft.client.resources.I18n;

public class GAMultiblockInfoCategory implements IRecipeCategory<MultiblockInfoRecipeWrapper> {
    private final IDrawable background;
    private final IGuiHelper guiHelper;
    private static ImmutableMap<String, MultiblockInfoRecipeWrapper> multiblockRecipes;

    public GAMultiblockInfoCategory(IJeiHelpers helpers) {
        this.guiHelper = helpers.getGuiHelper();
        this.background = guiHelper.createBlankDrawable(176, 166);
    }

    public static ImmutableMap<String, MultiblockInfoRecipeWrapper> getRecipes() {
        if(multiblockRecipes == null) {
            multiblockRecipes = new ImmutableMap.Builder<String, MultiblockInfoRecipeWrapper>()
                    //.put("hot_coolant_turbine", new MultiblockInfoRecipeWrapper(new HotCoolantTurbineInfo(GATileEntities.HOT_COOLANT_TURBINE)))
                    //.put("nuclear_reactor", new MultiblockInfoRecipeWrapper(new NuclearReactorInfo(GATileEntities.NUCLEAR_REACTOR)))
                    //.put("nuclear_breeder", new MultiblockInfoRecipeWrapper(new NuclearReactorInfo(GATileEntities.NUCLEAR_BREEDER)))
                    //.put("gas_centrifuge", new MultiblockInfoRecipeWrapper(new GasCentrifugeInfo()))
                    .put("void_miner", new MultiblockInfoRecipeWrapper(new VoidMinerInfo()))
                    .put("large_rocket_engine", new MultiblockInfoRecipeWrapper(new LargeRocketEngineInfo()))
                    .put("large_naquadah_reactor", new MultiblockInfoRecipeWrapper(new LargeNaquadahReactorInfo()))
                    .put("hyper_reactor_1", new MultiblockInfoRecipeWrapper(new HyperReactor1Info()))
                    .put("hyper_reactor_2", new MultiblockInfoRecipeWrapper(new HyperReactor2Info()))
                    .put("hyper_reactor_3", new MultiblockInfoRecipeWrapper(new HyperReactor3Info()))
                    .put("fusion_reactor_4", new MultiblockInfoRecipeWrapper(new FusionReactor4Info()))
                    .put("qubit_computer", new MultiblockInfoRecipeWrapper(new QubitComputerInfo()))
                    .put("stellar_forge", new MultiblockInfoRecipeWrapper(new StellarForgeInfo()))
                    .put("void_miner_2", new MultiblockInfoRecipeWrapper(new VoidMinerInfo2()))
                    .put("void_miner_3", new MultiblockInfoRecipeWrapper(new VoidMinerInfo3()))
                    .put("bio_reactor", new MultiblockInfoRecipeWrapper(new BioReactorInfo()))
                    .put("plasma_condenser", new MultiblockInfoRecipeWrapper(new PlasmaCondenserInfo()))
                    .put("cosmic_ray_detector", new MultiblockInfoRecipeWrapper(new CosmicRayDetectorInfo()))
                    .build();
        }

        return multiblockRecipes;
    }

    public static void registerRecipes(IModRegistry registry) {
        registry.addRecipes(getRecipes().values(), "gregtech:multiblock_info");
    }

    @Override
    public String getUid() {
        return "gregicality:multiblock_info2";
    }

    @Override
    public String getTitle() {
        return I18n.format("gregtech.multiblock.title");
    }

    @Override
    public String getModName() {
        return "gregicality";
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public void setRecipe(IRecipeLayout recipeLayout, MultiblockInfoRecipeWrapper recipeWrapper, IIngredients ingredients) {
        recipeWrapper.setRecipeLayout((RecipeLayout) recipeLayout, guiHelper);

        IGuiItemStackGroup itemStackGroup = recipeLayout.getItemStacks();
        itemStackGroup.addTooltipCallback(recipeWrapper::addBlockTooltips);
    }
}
