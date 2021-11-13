package gregicality.science.common;

import gregicality.science.GregicalityScience;
import gregicality.science.api.fluid.GAMetaFluids;
import gregicality.science.common.item.GAHeatingCoil;
import gregicality.science.common.item.GAMetaBlocks;
import gregicality.science.common.item.GAMetaItems;
import gregicality.science.api.pipelike.opticalfiber.ItemBlockOpticalFiber;
import gregicality.science.loaders.recipes.*;
import gregicality.science.loaders.recipes.categories.handlers.*;
import gregicality.science.api.GALog;
import gregtech.api.recipes.recipeproperties.BlastTemperatureProperty;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.common.blocks.VariantItemBlock;
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

import static gregicality.science.common.item.GAMetaBlocks.OPTICAL_FIBER;

@Mod.EventBusSubscriber(modid = GregicalityScience.MODID)
public class CommonProxy {

    public void preLoad() {
        GAMetaItems.init();
        GAMetaFluids.init();
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
        GALog.logger.info("Registering blocks...");
        IForgeRegistry<Block> registry = event.getRegistry();
        registry.register(GAMetaBlocks.MUTLIBLOCK_CASING);
        registry.register(GAMetaBlocks.MUTLIBLOCK_CASING2);
        registry.register(GAMetaBlocks.SIMPLE_BLOCK);
        registry.register(GAMetaBlocks.EXPLOSIVE);
        registry.register(GAMetaBlocks.QUANTUM_CASING);
        registry.register(GAMetaBlocks.REACTOR_CASING);
        registry.register(GAMetaBlocks.FUSION_CASING);
        registry.register(GAMetaBlocks.VACUUM_CASING);

        registry.register(GAMetaBlocks.HEATING_COIL);
        registry.register(GAMetaBlocks.DIVERTOR_CASING);
        registry.register(GAMetaBlocks.CRYOSTAT_CASING);
        registry.register(GAMetaBlocks.TRANSPARENT_CASING);
        registry.register(GAMetaBlocks.CONVEYOR_CASING);
        registry.register(GAMetaBlocks.FIELD_GEN_CASING);
        registry.register(GAMetaBlocks.MOTOR_CASING);
        registry.register(GAMetaBlocks.PISTON_CASING);
        registry.register(GAMetaBlocks.PUMP_CASING);
        registry.register(GAMetaBlocks.ROBOT_ARM_CASING);
        registry.register(GAMetaBlocks.SENSOR_CASING);
        registry.register(GAMetaBlocks.EMITTER_CASING);
        registry.register(GAMetaBlocks.NUCLEAR_CASING);
        registry.register(OPTICAL_FIBER);
    }


    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        GALog.logger.info("Registering Items...");
        IForgeRegistry<Item> registry = event.getRegistry();

        registry.register(createItemBlock(GAMetaBlocks.OPTICAL_FIBER, ItemBlockOpticalFiber::new));
        registry.register(createItemBlock(GAMetaBlocks.MUTLIBLOCK_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(GAMetaBlocks.MUTLIBLOCK_CASING2, VariantItemBlock::new));
        registry.register(createItemBlock(GAMetaBlocks.SIMPLE_BLOCK, VariantItemBlock::new));
        registry.register(createItemBlock(GAMetaBlocks.EXPLOSIVE, VariantItemBlock::new));
        registry.register(createItemBlock(GAMetaBlocks.QUANTUM_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(GAMetaBlocks.REACTOR_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(GAMetaBlocks.FUSION_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(GAMetaBlocks.VACUUM_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(GAMetaBlocks.HEATING_COIL, VariantItemBlock::new));
        registry.register(createItemBlock(GAMetaBlocks.DIVERTOR_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(GAMetaBlocks.CRYOSTAT_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(GAMetaBlocks.TRANSPARENT_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(GAMetaBlocks.CONVEYOR_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(GAMetaBlocks.FIELD_GEN_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(GAMetaBlocks.MOTOR_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(GAMetaBlocks.PISTON_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(GAMetaBlocks.PUMP_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(GAMetaBlocks.ROBOT_ARM_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(GAMetaBlocks.SENSOR_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(GAMetaBlocks.EMITTER_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(GAMetaBlocks.NUCLEAR_CASING, VariantItemBlock::new));
    }

    @SubscribeEvent(priority = EventPriority.LOW)
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {
        GALog.logger.info("Registering recipe low...");

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
        GALog.logger.info("Registering ore prefix...");

        // Register GTCE Material Handlers
        RecipeHandler.register();
        WireRecipeHandler.register();
        NuclearHandler.register();
//        OreRecipeHandler.register(); todo material processing handlers
        VoidMinerHandler.register();

        // Register OreDictionary Entries
        GAMetaItems.registerOreDict();
        GAMetaBlocks.registerOreDict();

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
