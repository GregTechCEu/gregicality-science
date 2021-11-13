package gregicality.science.integrations.jei;

import gregicality.science.integrations.jei.multi.*;
import gregtech.integration.jei.multiblock.MultiInfoPageEvent;
import gregtech.integration.jei.multiblock.MultiblockInfoRecipeWrapper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class JEIEventHandler {

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
