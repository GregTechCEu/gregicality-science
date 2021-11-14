package gregicality.science.common.machine;

import gregicality.science.GregicalityScience;
import gregicality.science.client.GCYSciTextures;
import gregicality.science.common.GCYSciConfig;
import gregicality.science.common.machine.multi.*;
import gregicality.science.common.machine.multiblockpart.MetaTileEntityQubitHatch;
import gregicality.science.loaders.recipes.GCYSciRecipeMaps;
import gregtech.api.GTValues;
import gregtech.api.metatileentity.SimpleGeneratorMetaTileEntity;
import gregtech.api.metatileentity.SimpleMachineMetaTileEntity;
import gregtech.api.render.Textures;
import net.minecraft.util.ResourceLocation;

import static gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity;
import static gregtech.common.metatileentities.MetaTileEntities.registerSimpleMetaTileEntity;

public class GCYSciTileEntities {

    // TODO Organize
    public static SimpleMachineMetaTileEntity[] DEHYDRATOR = new SimpleMachineMetaTileEntity[14];
    public static SimpleMachineMetaTileEntity[] DECAY_CHAMBER = new SimpleMachineMetaTileEntity[14];
    public static SimpleMachineMetaTileEntity[] GREEN_HOUSE = new SimpleMachineMetaTileEntity[14];
    public static SimpleGeneratorMetaTileEntity[] NAQUADAH_REACTOR = new SimpleGeneratorMetaTileEntity[8]; // todo idk what but something needs to be done about this
    public static SimpleGeneratorMetaTileEntity[] ROCKET_GENERATOR = new SimpleGeneratorMetaTileEntity[8];

    public static MetaTileEntityVoidMiner[] VOID_MINER = new MetaTileEntityVoidMiner[3];
    public static MetaTileEntityHyperReactor[] HYPER_REACTOR = new MetaTileEntityHyperReactor[3];
    public static MetaTileEntityLargeRocketEngine LARGE_ROCKET_ENGINE;
    public static MetaTileEntityLargeNaquadahReactor LARGE_NAQUADAH_REACTOR;
    public static MetaTileEntityAdvFusionReactor ADVANCED_FUSION_REACTOR;
    public static MetaTileEntityStellarForge STELLAR_FORGE;
    public static MetaTileEntityQubitComputer QUBIT_COMPUTER;
    public static MetaTileEntityBioReactor BIO_REACTOR;
    public static MetaTileEntityCosmicRayDetector COSMIC_RAY_DETECTOR;
    public static MetaTileEntityQubitHatch[] QBIT_INPUT_HATCH = new MetaTileEntityQubitHatch[MetaTileEntityQubitHatch.QUBIT.length];
    public static MetaTileEntityQubitHatch[] QBIT_OUTPUT_HATCH = new MetaTileEntityQubitHatch[MetaTileEntityQubitHatch.QUBIT.length];
    public static MetaTileEntityPlasmaCondenser PLASMA_CONDENSER;

    public static void init() {

        // todo REORGANIZE IDs, there will be conflicts, and it is also a total mess right now

        // todo rename everything to start with "MetaTileEntity"

        // todo get rid of all of the dumb overrides for base classes. GAWorkableTieredMetaTileEntity, GATieredMetaTileEntity, etc etc etc

        // todo comment this better for ID range clarity

        // Simple Machines
        registerSimpleMetaTileEntity(DEHYDRATOR, 2000, "dehydrator", GCYSciRecipeMaps.CHEMICAL_DEHYDRATOR_RECIPES, Textures.SIFTER_OVERLAY, true, GCYSciTileEntities::location);
        registerSimpleMetaTileEntity(DECAY_CHAMBER, 2015, "decay_chamber", GCYSciRecipeMaps.DECAY_CHAMBERS_RECIPES, Textures.REPLICATOR_OVERLAY, true, GCYSciTileEntities::location);
        registerSimpleMetaTileEntity(GREEN_HOUSE, 2030, "green_house", GCYSciRecipeMaps.GREEN_HOUSE_RECIPES, Textures.FERMENTER_OVERLAY, true, GCYSciTileEntities::location);

        // Simple Generators
        NAQUADAH_REACTOR[4] = registerMetaTileEntity(2051, new SimpleGeneratorMetaTileEntity(location("naquadah_reactor.mk2"), GCYSciRecipeMaps.NAQUADAH_REACTOR_FUELS, GCYSciTextures.NAQUADAH_OVERLAY, 5));
        NAQUADAH_REACTOR[5] = registerMetaTileEntity(2052, new SimpleGeneratorMetaTileEntity(location("naquadah_reactor.mk3"), GCYSciRecipeMaps.NAQUADAH_REACTOR_FUELS, GCYSciTextures.NAQUADAH_OVERLAY, 6));
        NAQUADAH_REACTOR[6] = registerMetaTileEntity(2053, new SimpleGeneratorMetaTileEntity(location("naquadah_reactor.mk4"), GCYSciRecipeMaps.NAQUADAH_REACTOR_FUELS, GCYSciTextures.NAQUADAH_OVERLAY, 7));

        ROCKET_GENERATOR[3] = registerMetaTileEntity(2065, new SimpleGeneratorMetaTileEntity(location("rocket_generator.mk1"), GCYSciRecipeMaps.ROCKET_FUEL_RECIPES, GCYSciTextures.ROCKET_OVERLAY, 4));
        ROCKET_GENERATOR[4] = registerMetaTileEntity(2066, new SimpleGeneratorMetaTileEntity(location("rocket_generator.mk2"), GCYSciRecipeMaps.ROCKET_FUEL_RECIPES, GCYSciTextures.ROCKET_OVERLAY, 5));
        ROCKET_GENERATOR[5] = registerMetaTileEntity(2067, new SimpleGeneratorMetaTileEntity(location("rocket_generator.mk3"), GCYSciRecipeMaps.ROCKET_FUEL_RECIPES, GCYSciTextures.ROCKET_OVERLAY, 6));

        // Multiblocks
        LARGE_ROCKET_ENGINE = registerMetaTileEntity(3015, new MetaTileEntityLargeRocketEngine(location("large_rocket_engine")));
        LARGE_NAQUADAH_REACTOR = registerMetaTileEntity(3018, new MetaTileEntityLargeNaquadahReactor(location("large_naquadah_reactor")));

        VOID_MINER[0] = registerMetaTileEntity(3201, new MetaTileEntityVoidMiner(location("void_miner"), GTValues.UV, GCYSciConfig.multis.voidMiner.maxTemp));
        VOID_MINER[1] = registerMetaTileEntity(3202, new MetaTileEntityVoidMiner(location("void_miner.uhv"), GTValues.UHV, GCYSciConfig.multis.voidMiner.maxTempUHV));
        VOID_MINER[2] = registerMetaTileEntity(3203, new MetaTileEntityVoidMiner(location("void_miner.uev"), GTValues.UEV, GCYSciConfig.multis.voidMiner.maxTempUEV));

        HYPER_REACTOR[0] = registerMetaTileEntity(3204, new MetaTileEntityHyperReactor(location("hyper_reactor.i"), 0));
        HYPER_REACTOR[1] = registerMetaTileEntity(3205, new MetaTileEntityHyperReactor(location("hyper_reactor.ii"), 1));
        HYPER_REACTOR[2] = registerMetaTileEntity(3206, new MetaTileEntityHyperReactor(location("hyper_reactor.iii"), 2));

        STELLAR_FORGE = registerMetaTileEntity(3207, new MetaTileEntityStellarForge(location("stellar_forge")));
        ADVANCED_FUSION_REACTOR = registerMetaTileEntity(3208, new MetaTileEntityAdvFusionReactor(location("advanced_fusion_reactor")));
        QUBIT_COMPUTER = registerMetaTileEntity(3209, new MetaTileEntityQubitComputer(location("qubit_computer")));
        BIO_REACTOR = registerMetaTileEntity(3210, new MetaTileEntityBioReactor(location("bio_reactor")));
        PLASMA_CONDENSER = registerMetaTileEntity(3211, new MetaTileEntityPlasmaCondenser(location("plasma_condenser")));
        COSMIC_RAY_DETECTOR = registerMetaTileEntity(3212, new MetaTileEntityCosmicRayDetector(location("cosmic_ray_detector")));

        // Misc MTEs
        QBIT_INPUT_HATCH[0] = registerMetaTileEntity(3603, new MetaTileEntityQubitHatch(location("qubit_hatch.input.16"), 0, 16, false));
        QBIT_OUTPUT_HATCH[0] = registerMetaTileEntity(3604, new MetaTileEntityQubitHatch(location("qubit_hatch.output.1"), 0, 1, true));
    }

    public static ResourceLocation location(String name) {
        return new ResourceLocation(GregicalityScience.MODID, name);
    }
}
