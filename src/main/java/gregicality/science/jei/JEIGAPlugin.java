package gregicality.science.jei;

import gregicality.science.GregicalityScience;
import gregicality.science.machines.multi.impl.HotCoolantRecipeLogic;
import gregicality.science.recipes.impl.nuclear.GTHotCoolantRecipeWrapper;
import gregicality.science.recipes.impl.nuclear.HotCoolantRecipeMap;
import gregicality.science.recipes.impl.nuclear.HotCoolantRecipeMapCategory;
import gregtech.api.GregTechAPI;
import gregtech.api.capability.GregtechTileCapabilities;
import gregtech.api.capability.IControllable;
import gregtech.api.capability.impl.AbstractRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.recipes.RecipeMap;
import gregtech.integration.jei.multiblock.MultiblockInfoPage;
import mezz.jei.api.*;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.*;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.stream.Collectors;

@JEIPlugin
@SuppressWarnings("unused") // handled by the annotation
public class JEIGAPlugin implements IModPlugin {

    @Override
    public void registerCategories(IRecipeCategoryRegistration registry) {
        registry.addRecipeCategories(new GAMultiblockInfoCategory(registry.getJeiHelpers()));
        for (HotCoolantRecipeMap hotCoolantRecipeMap : HotCoolantRecipeMap.getRecipeMaps()) {
            registry.addRecipeCategories(new HotCoolantRecipeMapCategory(hotCoolantRecipeMap, registry.getJeiHelpers().getGuiHelper()));
        }
    }


    @Override
    public void register(@Nonnull IModRegistry registry) {
        GAMultiblockInfoCategory.registerRecipes(registry);

        // Register Hot Coolant RecipeMaps
        for (HotCoolantRecipeMap hotCoolantRecipeMap : HotCoolantRecipeMap.getRecipeMaps()) {
            List<GTHotCoolantRecipeWrapper> recipeList = hotCoolantRecipeMap.getRecipeList().stream()
                    .map(GTHotCoolantRecipeWrapper::new)
                    .collect(Collectors.toList());
            registry.addRecipes(recipeList, GregicalityScience.MODID + ":" + hotCoolantRecipeMap.unlocalizedName);
        }

        // todo clean this up
        // Register something?
        for (ResourceLocation metaTileEntityId : GregTechAPI.META_TILE_ENTITY_REGISTRY.getKeys()) {
            MetaTileEntity metaTileEntity = GregTechAPI.META_TILE_ENTITY_REGISTRY.getObject(metaTileEntityId);
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

        // Register Multiblock Info Pages
        GAMultiblockInfoCategory.getRecipes().values().forEach(v -> {
            MultiblockInfoPage infoPage = v.getInfoPage();
            registry.addIngredientInfo(infoPage.getController().getStackForm(),
                    VanillaTypes.ITEM,
                    infoPage.getDescription());
        });
    }
}
