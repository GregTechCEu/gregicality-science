package gregicality.science.common;

import gregicality.science.GregicalityScience;
import gregicality.science.api.GCYSLog;
import gregicality.science.api.GCYSMaterials;
import gregicality.science.common.item.GCYSMetaItems;
import gregicality.science.loaders.recipes.RecipeHandler;
import gregicality.science.loaders.recipes.helper.GCYSComponents;
import gregtech.api.GregTechAPI;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.loaders.recipe.CraftingComponent;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.Objects;
import java.util.function.Function;

@Mod.EventBusSubscriber(modid = GregicalityScience.MODID)
public class CommonProxy {

    public void preLoad() {
        GCYSMetaItems.init();
    }

    public void onLoad() {
        setRemovedMaterialTooltips();
    }

    private static void setRemovedMaterialTooltips() {
    }

    @SubscribeEvent
    public static void syncConfigValues(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(GregicalityScience.MODID)) {
            ConfigManager.sync(GregicalityScience.MODID, Config.Type.INSTANCE);
        }
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        GCYSLog.logger.info("Registering blocks...");
        IForgeRegistry<Block> registry = event.getRegistry();
    }


    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        GCYSLog.logger.info("Registering Items...");
        IForgeRegistry<Item> registry = event.getRegistry();
    }

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void registerMaterials(GregTechAPI.MaterialEvent event) {
        GCYSMaterials.register();
    }

    @SubscribeEvent
    public static void registerComponents(GregTechAPI.RegisterEvent<CraftingComponent> event) {
        GCYSComponents.register();
    }

    @SubscribeEvent(priority = EventPriority.LOW)
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {
        GCYSLog.logger.info("Registering recipe low...");

        // Main recipe registration
        // This is called AFTER GregTech registers recipes, so
        // anything here is safe to call removals in
        RecipeHandler.initRecipes();

        // Run some late recipe addition that depends on other
        // recipes of ours already being added
    }

    @SubscribeEvent
    public static void registerOrePrefix(RegistryEvent.Register<IRecipe> event) {
        GCYSLog.logger.info("Registering ore prefix...");

        // Register GTCE Material Handlers
        RecipeHandler.register();

        // Register OreDictionary Entries
        GCYSMetaItems.registerOreDict();

        // Run some early recipe addition
        // These do not need to be here, but since they do not remove
        // any recipes, they are fine to be run early
        RecipeHandler.initChains();
    }

    private static <T extends Block> ItemBlock createItemBlock(T block, Function<T, ItemBlock> producer) {
        ItemBlock itemBlock = producer.apply(block);
        itemBlock.setRegistryName(Objects.requireNonNull(block.getRegistryName()));
        return itemBlock;
    }
}
