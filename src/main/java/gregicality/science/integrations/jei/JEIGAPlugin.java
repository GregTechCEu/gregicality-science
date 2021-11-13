package gregicality.science.integrations.jei;

import gregicality.science.GregicalityScience;
import gregicality.science.api.machines.multi.impl.HotCoolantRecipeLogic;
import gregicality.science.integrations.jei.multi.CosmicRayDetectorInfo;
import gregicality.science.integrations.jei.multi.PlasmaCondenserInfo;
import gregicality.science.integrations.jei.multi.advance.*;
import gregicality.science.integrations.jei.multi.miner.VoidMinerInfo;
import gregicality.science.integrations.jei.multi.miner.VoidMinerInfo2;
import gregicality.science.integrations.jei.multi.miner.VoidMinerInfo3;
import gregicality.science.integrations.jei.multi.quantum.QubitComputerInfo;
import gregicality.science.loaders.recipes.impl.nuclear.HotCoolantRecipeMap;
import gregtech.api.GregTechAPI;
import gregtech.api.capability.GregtechTileCapabilities;
import gregtech.api.capability.IControllable;
import gregtech.api.capability.impl.AbstractRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.recipes.RecipeMap;
import gregtech.integration.jei.multiblock.MultiInfoPageEvent;
import gregtech.integration.jei.multiblock.MultiblockInfoRecipeWrapper;
import mezz.jei.api.*;
import mezz.jei.api.recipe.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import javax.annotation.Nonnull;

@JEIPlugin
@SuppressWarnings("unused") // handled by the annotation
public class JEIGAPlugin implements IModPlugin {

    @Override
    public void registerCategories(IRecipeCategoryRegistration registry) {
        // todo nuclear rework
        //for (HotCoolantRecipeMap hotCoolantRecipeMap : HotCoolantRecipeMap.getRecipeMaps()) {
        //    registry.addRecipeCategories(new HotCoolantRecipeMapCategory(hotCoolantRecipeMap, registry.getJeiHelpers().getGuiHelper()));
        //}
    }

    @Override
    public void register(@Nonnull IModRegistry registry) {
        // Register Hot Coolant RecipeMaps todo nuclear rework
        //for (HotCoolantRecipeMap hotCoolantRecipeMap : HotCoolantRecipeMap.getRecipeMaps()) {
        //    List<GTHotCoolantRecipeWrapper> recipeList = hotCoolantRecipeMap.getRecipeList().stream()
        //            .map(GTHotCoolantRecipeWrapper::new)
        //            .collect(Collectors.toList());
        //    registry.addRecipes(recipeList, GregicalityScience.MODID + ":" + hotCoolantRecipeMap.unlocalizedName);
        //}

        // todo clean this up
        // Register something?
        for (ResourceLocation metaTileEntityId : GregTechAPI.MTE_REGISTRY.getKeys()) {
            MetaTileEntity metaTileEntity = GregTechAPI.MTE_REGISTRY.getObject(metaTileEntityId);
            //noinspection ConstantConditions
            if (metaTileEntity.getCapability(GregtechTileCapabilities.CAPABILITY_CONTROLLABLE, null) != null) {
                IControllable workableCapability = metaTileEntity.getCapability(GregtechTileCapabilities.CAPABILITY_CONTROLLABLE, null);
                if (workableCapability instanceof HotCoolantRecipeLogic) {
                    HotCoolantRecipeMap recipeMap = ((HotCoolantRecipeLogic) workableCapability).recipeMap;
                    registry.addRecipeCatalyst(metaTileEntity.getStackForm(), GregicalityScience.MODID + ":" + recipeMap.unlocalizedName);
                } else if (workableCapability instanceof AbstractRecipeLogic) {
                    RecipeMap<?> recipeMap = ((AbstractRecipeLogic) workableCapability).recipeMap;
                    registry.addRecipeCatalyst(metaTileEntity.getStackForm(), GregicalityScience.MODID + ":" + recipeMap.unlocalizedName);
                }
            }
        }
    }

    @SubscribeEvent
    public static void registerInfoPages(MultiInfoPageEvent event) {
        event.register("void_miner", new MultiblockInfoRecipeWrapper(new VoidMinerInfo()));
        event.register("void_miner_2", new MultiblockInfoRecipeWrapper(new VoidMinerInfo2()));
        event.register("void_miner_3", new MultiblockInfoRecipeWrapper(new VoidMinerInfo3()));
        event.register("large_rocket_engine", new MultiblockInfoRecipeWrapper(new LargeRocketEngineInfo()));
        event.register("large_naquadah_reactor", new MultiblockInfoRecipeWrapper(new LargeNaquadahReactorInfo()));
        event.register("hyper_reactor_1", new MultiblockInfoRecipeWrapper(new HyperReactor1Info()));
        event.register("hyper_reactor_2", new MultiblockInfoRecipeWrapper(new HyperReactor2Info()));
        event.register("hyper_reactor_3", new MultiblockInfoRecipeWrapper(new HyperReactor3Info()));
        event.register("fusion_reactor_4", new MultiblockInfoRecipeWrapper(new FusionReactor4Info()));
        event.register("qubit_computer", new MultiblockInfoRecipeWrapper(new QubitComputerInfo()));
        event.register("stellar_forge", new MultiblockInfoRecipeWrapper(new StellarForgeInfo()));
        event.register("bio_reactor", new MultiblockInfoRecipeWrapper(new BioReactorInfo()));
        event.register("plasma_condenser", new MultiblockInfoRecipeWrapper(new PlasmaCondenserInfo()));
        event.register("cosmic_ray_detector", new MultiblockInfoRecipeWrapper(new CosmicRayDetectorInfo()));
    }
}
