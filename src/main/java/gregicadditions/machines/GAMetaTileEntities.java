package gregicadditions.machines;

import gregicadditions.GAConfig;
import gregicadditions.GAValues;
import gregicadditions.Gregicality;
import gregicadditions.client.ClientHandler;
import gregicadditions.machines.multi.*;
import gregicadditions.machines.multi.advance.*;
import gregicadditions.machines.multi.advance.hyper.*;
import gregicadditions.machines.multi.impl.MetaTileEntityRotorHolderForNuclearCoolant;
import gregicadditions.machines.multi.miner.MetaTileEntityVoidMiner;
import gregicadditions.machines.multi.multiblockpart.MetaTileEntityQubitHatch;
import gregicadditions.machines.multi.nuclear.*;
import gregicadditions.machines.multi.qubit.*;
import gregicadditions.machines.multi.simple.*;
import gregicadditions.recipes.GARecipeMaps;
import gregtech.api.GTValues;
import gregtech.api.GregTechAPI;
import gregtech.api.metatileentity.SimpleGeneratorMetaTileEntity;
import gregtech.api.metatileentity.SimpleMachineMetaTileEntity;
import gregtech.api.render.Textures;
import net.minecraft.util.ResourceLocation;

import static gregtech.common.metatileentities.MetaTileEntities.registerSimpleMetaTileEntity;

public class GAMetaTileEntities {

    // TODO Nuclear rework
    public static MetaTileEntityNuclearReactor NUCLEAR_REACTOR;
    public static MetaTileEntityNuclearReactor NUCLEAR_BREEDER;
    public static MetaTileEntityGasCentrifuge GAS_CENTRIFUGE;
    public static MetaTileEntityHotCoolantTurbine HOT_COOLANT_TURBINE;
    public static MetaTileEntityRotorHolderForNuclearCoolant[] ROTOR_HOLDER = new MetaTileEntityRotorHolderForNuclearCoolant[4];

    // TODO Organize
    public static SimpleMachineMetaTileEntity[] DEHYDRATOR = new SimpleMachineMetaTileEntity[14];
    public static SimpleMachineMetaTileEntity[] DECAY_CHAMBER = new SimpleMachineMetaTileEntity[14];
    public static SimpleMachineMetaTileEntity[] GREEN_HOUSE = new SimpleMachineMetaTileEntity[14];
    public static SimpleGeneratorMetaTileEntity[] NAQUADAH_REACTOR = new SimpleGeneratorMetaTileEntity[8]; // todo idk what but something needs to be done about this
    public static SimpleGeneratorMetaTileEntity[] ROCKET_GENERATOR = new SimpleGeneratorMetaTileEntity[8];

    public static TileEntityLargeCircuitAssemblyLine LARGE_CIRCUIT_ASSEMBLY_LINE;
    public static MetaTileEntityVoidMiner[] VOID_MINER = new MetaTileEntityVoidMiner[3];
    public static MetaTileEntityLargeRocketEngine LARGE_ROCKET_ENGINE;
    public static MetaTileEntityLargeNaquadahReactor LARGE_NAQUADAH_REACTOR;
    public static MetaTileEntityHyperReactorI HYPER_REACTOR_I;
    public static MetaTileEntityHyperReactorII HYPER_REACTOR_II;
    public static MetaTileEntityHyperReactorIII HYPER_REACTOR_III;
    public static MetaTileEntityAdvFusionReactor ADVANCED_FUSION_REACTOR;
    public static MetaTileEntityStellarForge STELLAR_FORGE;
    public static MetaTileEntityQubitComputer QUBIT_COMPUTER;
    public static MetaTileEntityBioReactor BIO_REACTOR;
    public static MetaTileEntityCosmicRayDetector COSMIC_RAY_DETECTOR;
    public static MetaTileEntityQubitHatch[] QBIT_INPUT_HATCH = new MetaTileEntityQubitHatch[GAValues.QUBIT.length];
    public static MetaTileEntityQubitHatch[] QBIT_OUTPUT_HATCH = new MetaTileEntityQubitHatch[GAValues.QUBIT.length];
    public static MetaTileEntitySteamPump STEAM_PUMP;
    public static MetaTileEntitySteamMixer STEAM_MIXER;
    public static MetaTileEntityPlasmaCondenser PLASMA_CONDENSER;
    public static TileEntitySteamMiner STEAM_MINER;

    public static void init() {

        // todo REORGANIZE IDs, there will be conflicts, and it is also a total mess right now

        // todo rename everything to start with "MetaTileEntity"

        // todo get rid of all of the dumb overrides for base classes. GAWorkableTieredMetaTileEntity, GATieredMetaTileEntity, etc etc etc

        // todo comment this better for ID range clarity

        // Simple Machines
        registerSimpleMetaTileEntity(DEHYDRATOR, 2000, "dehydrator", GARecipeMaps.CHEMICAL_DEHYDRATOR_RECIPES, Textures.SIFTER_OVERLAY, true, GAMetaTileEntities::location);
        registerSimpleMetaTileEntity(DECAY_CHAMBER, 2015, "decay_chamber", GARecipeMaps.DECAY_CHAMBERS_RECIPES, Textures.REPLICATOR_OVERLAY, true, GAMetaTileEntities::location);
        registerSimpleMetaTileEntity(GREEN_HOUSE, 2030, "green_house", GARecipeMaps.GREEN_HOUSE_RECIPES, Textures.FERMENTER_OVERLAY, true, GAMetaTileEntities::location);

        // Simple Generators
        NAQUADAH_REACTOR[4] = GregTechAPI.registerMetaTileEntity(2051, new SimpleGeneratorMetaTileEntity(location("naquadah_reactor.mk2"), GARecipeMaps.NAQUADAH_REACTOR_FUELS, ClientHandler.NAQADAH_OVERLAY, 5));
        NAQUADAH_REACTOR[5] = GregTechAPI.registerMetaTileEntity(2052, new SimpleGeneratorMetaTileEntity(location("naquadah_reactor.mk3"), GARecipeMaps.NAQUADAH_REACTOR_FUELS, ClientHandler.NAQADAH_OVERLAY, 6));
        NAQUADAH_REACTOR[6] = GregTechAPI.registerMetaTileEntity(2053, new SimpleGeneratorMetaTileEntity(location("naquadah_reactor.mk4"), GARecipeMaps.NAQUADAH_REACTOR_FUELS, ClientHandler.NAQADAH_OVERLAY, 7));

        ROCKET_GENERATOR[3] = GregTechAPI.registerMetaTileEntity(2065, new SimpleGeneratorMetaTileEntity(location("rocket_generator.mk1"), GARecipeMaps.ROCKET_FUEL_RECIPES, ClientHandler.ROCKET_OVERLAY, 4));
        ROCKET_GENERATOR[4] = GregTechAPI.registerMetaTileEntity(2066, new SimpleGeneratorMetaTileEntity(location("rocket_generator.mk2"), GARecipeMaps.ROCKET_FUEL_RECIPES, ClientHandler.ROCKET_OVERLAY, 5));
        ROCKET_GENERATOR[5] = GregTechAPI.registerMetaTileEntity(2067, new SimpleGeneratorMetaTileEntity(location("rocket_generator.mk3"), GARecipeMaps.ROCKET_FUEL_RECIPES, ClientHandler.ROCKET_OVERLAY, 6));

        // Steam Machines
        STEAM_PUMP = GregTechAPI.registerMetaTileEntity(2075, new MetaTileEntitySteamPump(location("pump.steam")));
        STEAM_MIXER = GregTechAPI.registerMetaTileEntity(2077, new MetaTileEntitySteamMixer(location("steam_mixer")));
        STEAM_MINER = GregTechAPI.registerMetaTileEntity(2079, new TileEntitySteamMiner(location("steam_miner")));

        // Multiblocks

        // "Upgraded Versions"
        LARGE_CIRCUIT_ASSEMBLY_LINE = GregTechAPI.registerMetaTileEntity(3000, new TileEntityLargeCircuitAssemblyLine(location("large_circuit_assembly")));
        LARGE_ROCKET_ENGINE = GregTechAPI.registerMetaTileEntity(3015, new MetaTileEntityLargeRocketEngine(location("large_rocket_engine")));
        LARGE_NAQUADAH_REACTOR = GregTechAPI.registerMetaTileEntity(3018, new MetaTileEntityLargeNaquadahReactor(location("large_naquadah_reactor")));

        // Totally new Multis
        VOID_MINER[0] = GregTechAPI.registerMetaTileEntity(3201, new MetaTileEntityVoidMiner(location("void_miner"), GTValues.UV, GAConfig.multis.voidMiner.maxTemp));
        VOID_MINER[1] = GregTechAPI.registerMetaTileEntity(3202, new MetaTileEntityVoidMiner(location("void_miner.uhv"), GTValues.UHV, GAConfig.multis.voidMiner.maxTempUHV));
        VOID_MINER[2] = GregTechAPI.registerMetaTileEntity(3203, new MetaTileEntityVoidMiner(location("void_miner.uev"), GTValues.UEV, GAConfig.multis.voidMiner.maxTempUEV));
        HYPER_REACTOR_I = GregTechAPI.registerMetaTileEntity(3204, new MetaTileEntityHyperReactorI(location("hyper_reactor.i"), GAConfig.multis.hyperReactors.euGeneration[0]));
        HYPER_REACTOR_II = GregTechAPI.registerMetaTileEntity(3205, new MetaTileEntityHyperReactorII(location("hyper_reactor.ii"), GAConfig.multis.hyperReactors.euGeneration[1]));
        HYPER_REACTOR_III = GregTechAPI.registerMetaTileEntity(3206, new MetaTileEntityHyperReactorIII(location("hyper_reactor.iii"), GAConfig.multis.hyperReactors.euGeneration[2]));
        STELLAR_FORGE = GregTechAPI.registerMetaTileEntity(3207, new MetaTileEntityStellarForge(location("stellar_forge")));
        ADVANCED_FUSION_REACTOR = GregTechAPI.registerMetaTileEntity(3208, new MetaTileEntityAdvFusionReactor(location("advanced_fusion_reactor")));
        QUBIT_COMPUTER = GregTechAPI.registerMetaTileEntity(3209, new MetaTileEntityQubitComputer(location("qubit_computer")));
        BIO_REACTOR = GregTechAPI.registerMetaTileEntity(3210, new MetaTileEntityBioReactor(location("bio_reactor")));
        PLASMA_CONDENSER = GregTechAPI.registerMetaTileEntity(3211, new MetaTileEntityPlasmaCondenser(location("plasma_condenser")));
        COSMIC_RAY_DETECTOR = GregTechAPI.registerMetaTileEntity(3212, new MetaTileEntityCosmicRayDetector(location("cosmic_ray_detector")));

        // Misc MTEs
        QBIT_INPUT_HATCH[0] = GregTechAPI.registerMetaTileEntity(3603, new MetaTileEntityQubitHatch(location("qubit_hatch.input.16"), 0, 16, false));
        QBIT_OUTPUT_HATCH[0] = GregTechAPI.registerMetaTileEntity(3604, new MetaTileEntityQubitHatch(location("qubit_hatch.output.1"), 0, 1, true));

        // TODO Nuclear Rework
        //GAS_CENTRIFUGE = GregTechAPI.registerMetaTileEntity(4020, new MetaTileEntityGasCentrifuge(location("gas_centrifuge")));
        //HOT_COOLANT_TURBINE = GregTechAPI.registerMetaTileEntity(2544, new MetaTileEntityHotCoolantTurbine(location("large_turbine.hot_coolant"), MetaTileEntityHotCoolantTurbine.TurbineType.HOT_COOLANT));
        //NUCLEAR_REACTOR = GregTechAPI.registerMetaTileEntity(2545, new MetaTileEntityNuclearReactor(location("nuclear_reactor"), GARecipeMaps.NUCLEAR_REACTOR_RECIPES));
        //NUCLEAR_BREEDER = GregTechAPI.registerMetaTileEntity(2546, new MetaTileEntityNuclearReactor(location("nuclear_breeder"), GARecipeMaps.NUCLEAR_BREEDER_RECIPES));
        //ROTOR_HOLDER[0] = GregTechAPI.registerMetaTileEntity(3600, new MetaTileEntityRotorHolderForNuclearCoolant(location("rotor_holder.hv"), GTValues.HV, 1.1f));
        //ROTOR_HOLDER[1] = GregTechAPI.registerMetaTileEntity(3601, new MetaTileEntityRotorHolderForNuclearCoolant(location("rotor_holder.luv"), GTValues.LuV, 1.35f));
        //ROTOR_HOLDER[2] = GregTechAPI.registerMetaTileEntity(3602, new MetaTileEntityRotorHolderForNuclearCoolant(location("rotor_holder.uhv"), GTValues.UHV, 1.7f));
    }

    public static ResourceLocation location(String name) {
        return new ResourceLocation(Gregicality.MODID, name);
    }
}
