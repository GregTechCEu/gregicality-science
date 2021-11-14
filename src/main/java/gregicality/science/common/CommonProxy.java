package gregicality.science.common;

import gregicality.science.GregicalityScience;
import gregicality.science.api.GCYSciLog;
import gregicality.science.api.GCYSciMaterials;
import gregicality.science.api.material.GAOrePrefix;
import gregicality.science.api.pipelike.opticalfiber.ItemBlockOpticalFiber;
import gregicality.science.common.block.GAHeatingCoil;
import gregicality.science.common.block.GCYSciMetaBlocks;
import gregicality.science.common.item.GCYSciMetaItems;
import gregicality.science.loaders.recipes.RecipeHandler;
import gregicality.science.loaders.recipes.categories.handlers.FuelHandler;
import gregicality.science.loaders.recipes.categories.handlers.VoidMinerHandler;
import gregicality.science.loaders.recipes.categories.handlers.WireRecipeHandler;
import gregicality.science.loaders.recipes.helper.GCYSciComponents;
import gregtech.api.GregTechAPI;
import gregtech.api.recipes.recipeproperties.BlastTemperatureProperty;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.common.blocks.VariantItemBlock;
import gregtech.loaders.recipe.CraftingComponent;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.text.TextFormatting;
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

import static gregicality.science.common.block.GCYSciMetaBlocks.OPTICAL_FIBER;

@Mod.EventBusSubscriber(modid = GregicalityScience.MODID)
public class CommonProxy {

    public void preLoad() {
        GCYSciMetaItems.init();
    }

    public void onLoad() {
        setRemovedMaterialTooltips();
    }

    // This method is used to set tooltips for materials to be removed in the future.
    // If we want to staggered-remove a material, apply a warning to it here.
    private static final String REMOVED_MAT_TOOLTIP = TextFormatting.RED + "This will be removed in next release!";
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
        GCYSciLog.logger.info("Registering blocks...");
        IForgeRegistry<Block> registry = event.getRegistry();
        registry.register(GCYSciMetaBlocks.MUTLIBLOCK_CASING);
        registry.register(GCYSciMetaBlocks.MUTLIBLOCK_CASING2);
        registry.register(GCYSciMetaBlocks.SIMPLE_BLOCK);
        registry.register(GCYSciMetaBlocks.EXPLOSIVE);
        registry.register(GCYSciMetaBlocks.QUANTUM_CASING);
        registry.register(GCYSciMetaBlocks.REACTOR_CASING);
        registry.register(GCYSciMetaBlocks.FUSION_CASING);
        registry.register(GCYSciMetaBlocks.VACUUM_CASING);

        registry.register(GCYSciMetaBlocks.HEATING_COIL);
        registry.register(GCYSciMetaBlocks.DIVERTOR_CASING);
        registry.register(GCYSciMetaBlocks.CRYOSTAT_CASING);
        registry.register(GCYSciMetaBlocks.TRANSPARENT_CASING);
        registry.register(GCYSciMetaBlocks.CONVEYOR_CASING);
        registry.register(GCYSciMetaBlocks.FIELD_GEN_CASING);
        registry.register(GCYSciMetaBlocks.MOTOR_CASING);
        registry.register(GCYSciMetaBlocks.PISTON_CASING);
        registry.register(GCYSciMetaBlocks.PUMP_CASING);
        registry.register(GCYSciMetaBlocks.ROBOT_ARM_CASING);
        registry.register(GCYSciMetaBlocks.SENSOR_CASING);
        registry.register(GCYSciMetaBlocks.EMITTER_CASING);
        registry.register(OPTICAL_FIBER);
    }


    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        GCYSciLog.logger.info("Registering Items...");
        IForgeRegistry<Item> registry = event.getRegistry();

        registry.register(createItemBlock(GCYSciMetaBlocks.OPTICAL_FIBER, ItemBlockOpticalFiber::new));
        registry.register(createItemBlock(GCYSciMetaBlocks.MUTLIBLOCK_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(GCYSciMetaBlocks.MUTLIBLOCK_CASING2, VariantItemBlock::new));
        registry.register(createItemBlock(GCYSciMetaBlocks.SIMPLE_BLOCK, VariantItemBlock::new));
        registry.register(createItemBlock(GCYSciMetaBlocks.EXPLOSIVE, VariantItemBlock::new));
        registry.register(createItemBlock(GCYSciMetaBlocks.QUANTUM_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(GCYSciMetaBlocks.REACTOR_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(GCYSciMetaBlocks.FUSION_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(GCYSciMetaBlocks.VACUUM_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(GCYSciMetaBlocks.HEATING_COIL, VariantItemBlock::new));
        registry.register(createItemBlock(GCYSciMetaBlocks.DIVERTOR_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(GCYSciMetaBlocks.CRYOSTAT_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(GCYSciMetaBlocks.TRANSPARENT_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(GCYSciMetaBlocks.CONVEYOR_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(GCYSciMetaBlocks.FIELD_GEN_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(GCYSciMetaBlocks.MOTOR_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(GCYSciMetaBlocks.PISTON_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(GCYSciMetaBlocks.PUMP_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(GCYSciMetaBlocks.ROBOT_ARM_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(GCYSciMetaBlocks.SENSOR_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(GCYSciMetaBlocks.EMITTER_CASING, VariantItemBlock::new));
    }

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void registerMaterials(GregTechAPI.MaterialEvent event) {
        GCYSciMaterials.register();
        GAOrePrefix.initPrefixes();
    }

    @SubscribeEvent
    public static void registerComponents(GregTechAPI.RegisterEvent<CraftingComponent> event) {
        GCYSciComponents.register();
    }

    @SubscribeEvent(priority = EventPriority.LOW)
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {
        GCYSciLog.logger.info("Registering recipe low...");

        for (GAHeatingCoil.CoilType values : GAHeatingCoil.CoilType.values()) {
            BlastTemperatureProperty.registerCoilType(values.getCoilTemperature(), null,
                    "tile.ga_heating_coil." + values.getName() + ".name");
        }

        // Main recipe registration
        // This is called AFTER GregTech registers recipes, so
        // anything here is safe to call removals in
        RecipeHandler.initRecipes();

        // Run some late recipe addition that depends on other
        // recipes of ours already being added
        VoidMinerHandler.addWhitelist();
    }

    @SubscribeEvent
    public static void registerOrePrefix(RegistryEvent.Register<IRecipe> event) {
        GCYSciLog.logger.info("Registering ore prefix...");

        // Register GTCE Material Handlers
        RecipeHandler.register();
        WireRecipeHandler.register();
        VoidMinerHandler.register();

        // Register OreDictionary Entries
        GCYSciMetaItems.registerOreDict();
        GCYSciMetaBlocks.registerOreDict();

        // Run GTCE Material Handlers
        OrePrefix.runMaterialHandlers();

        // Run some early recipe addition
        // These do not need to be here, but since they do not remove
        // any recipes, they are fine to be run early
        RecipeHandler.initChains();
        FuelHandler.init();
    }

    private static <T extends Block> ItemBlock createItemBlock(T block, Function<T, ItemBlock> producer) {
        ItemBlock itemBlock = producer.apply(block);
        itemBlock.setRegistryName(Objects.requireNonNull(block.getRegistryName()));
        return itemBlock;
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void registerRecipesLowest(RegistryEvent.Register<IRecipe> event) {
        RecipeHandler.runRecipeGeneration();
        RecipeHandler.generatedRecipes();
    }
}
