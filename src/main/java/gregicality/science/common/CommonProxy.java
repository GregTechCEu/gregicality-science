package gregicality.science.common;

import gregicality.science.GregicalityScience;
import gregicality.science.api.utils.GCYSLog;
import gregicality.science.loaders.recipe.GCYSRecipeLoader;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import javax.annotation.Nonnull;
import java.util.Objects;
import java.util.function.Function;

@Mod.EventBusSubscriber(modid = GregicalityScience.MODID)
public class CommonProxy {

    public void preLoad() {

    }

    @SubscribeEvent
    public static void syncConfigValues(@Nonnull ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(GregicalityScience.MODID)) {
            ConfigManager.sync(GregicalityScience.MODID, Config.Type.INSTANCE);
        }
    }

    @SubscribeEvent
    public static void registerBlocks(@Nonnull RegistryEvent.Register<Block> event) {
        GCYSLog.logger.info("Registering blocks...");
        IForgeRegistry<Block> registry = event.getRegistry();
    }

    @SubscribeEvent
    public static void registerItems(@Nonnull RegistryEvent.Register<Item> event) {
        GCYSLog.logger.info("Registering Items...");
        IForgeRegistry<Item> registry = event.getRegistry();
    }

    @Nonnull
    private static <T extends Block> ItemBlock createItemBlock(@Nonnull T block, @Nonnull Function<T, ItemBlock> producer) {
        ItemBlock itemBlock = producer.apply(block);
        itemBlock.setRegistryName(Objects.requireNonNull(block.getRegistryName()));
        return itemBlock;
    }

    @SubscribeEvent()
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {
        GCYSLog.logger.info("Registering recipes");

        // Main recipe registration
        // This is called AFTER GregTech registers recipes, so
        // anything here is safe to call removals in
        GCYSRecipeLoader.init();
    }
}
