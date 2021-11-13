package gregicality.science.recipes.categories.machines;

import gregicality.science.GAMaterials;
import gregicality.science.item.GAMetaBlocks;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.blocks.*;
import gregtech.common.metatileentities.MetaTileEntities;

import static gregicality.science.GAMaterials.*;
import static gregicality.science.item.GAMetaItems.*;
import static gregicality.science.item.GAQuantumCasing.CasingType.COMPUTER;
import static gregicality.science.item.fusion.GAFusionCasing.CasingType.*;
import static gregicality.science.machines.GAMetaTileEntities.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLY_LINE_RECIPES;
import static gregtech.api.unification.material.MarkerMaterials.Tier.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.blocks.BlockMetalCasing.MetalCasingType.*;
import static gregtech.common.blocks.BlockMultiblockCasing.MultiblockCasingType.ASSEMBLER_CASING;
import static gregtech.common.items.MetaItems.*;
import static gregtech.common.metatileentities.MetaTileEntities.HULL;

public class MultiblockCraftingRecipes {

    public static void init() {
        largeMultiblockInit();
        otherMultiblockInit();
        multiblockOverride();
    }

    private static void otherMultiblockInit() {

        // Large Rocket Engine
        ASSEMBLY_LINE_RECIPES.recipeBuilder().duration(1200).EUt(30720)
                .fluidInputs(Lubricant.getFluid(L * 16))
                .fluidInputs(SiliconeRubber.getFluid(L * 64))
                .fluidInputs(SolderingAlloy.getFluid(L * 10))
                .input(circuit, Master)
                .input(circuit, Master)
                .input(circuit, Master)
                .input(circuit, Master)
                .input(wireGtSingle, SamariumIronArsenicOxide, 64)
                .input(wireGtSingle, SamariumIronArsenicOxide, 64)
                .input(gear, IncoloyMA956, 16)
                .inputs(ROCKET_GENERATOR[LuV - 1].getStackForm(2))
                .inputs(ELECTRIC_PISTON_LUV.getStackForm(16))
                .outputs(LARGE_ROCKET_ENGINE.getStackForm())
                .buildAndRegister();

        // Void Miner Mk1 todo use CEu's miners
        ASSEMBLY_LINE_RECIPES.recipeBuilder().duration(600).EUt(260000)
                .fluidInputs(HastelloyN.getFluid(L * 8))
                .fluidInputs(Polybenzimidazole.getFluid(L * 32))
                .input(gear, Staballoy, 4)
                .input(screw, Seaborgium, 16)
                .input(bolt, Tritanium, 24)
                .inputs(ELECTRIC_MOTOR_UV.getStackForm(4))
                .inputs(SENSOR_UV.getStackForm())
                .input(wireGtSingle, EnrichedNaquadahTriniumEuropiumDuranide, 64)
                .input(wireGtSingle, EnrichedNaquadahTriniumEuropiumDuranide, 64)
                .input(wireGtSingle, EnrichedNaquadahTriniumEuropiumDuranide, 64)
                .input(wireGtSingle, EnrichedNaquadahTriniumEuropiumDuranide, 64)
                .inputs(LARGE_MINER[0].getStackForm())
                .inputs(LARGE_MINER[1].getStackForm())
                .inputs(LARGE_MINER[2].getStackForm())
                .input(circuit, Superconductor, 4)
                .outputs(VOID_MINER[0].getStackForm())
                .buildAndRegister();

        // Void Miner Mk2
        ASSEMBLY_LINE_RECIPES.recipeBuilder().duration(600).EUt(1000000)
                .fluidInputs(SolderingAlloy.getFluid(L * 27))
                .fluidInputs(Polyetheretherketone.getFluid(2592))
                .inputs(SENSOR_UHV.getStackForm(2))
                .inputs(ELECTRIC_MOTOR_UHV.getStackForm(8))
                .input(wireGtSingle, GAMaterials.StrontiumTaraniumTBCCO, 64)
                .input(wireGtSingle, GAMaterials.StrontiumTaraniumTBCCO, 64)
                .input(wireGtSingle, GAMaterials.StrontiumTaraniumTBCCO, 64)
                .input(wireGtSingle, GAMaterials.StrontiumTaraniumTBCCO, 64)
                .inputs(VOID_MINER[0].getStackForm())
                .input(circuit, Infinite, 4)
                .input(gear, Incoloy813, 4)
                .input(screw, Incoloy813, 64)
                .input(screw, Incoloy813, 64)
                .input(plate, EnrichedNaquadahAlloy, 8)
                .input(plate, Ruridit, 8)
                .input(stick, EnrichedNaquadahAlloy, 16)
                .outputs(VOID_MINER[1].getStackForm())
                .buildAndRegister();

        // Void Miner Mk3
        ASSEMBLY_LINE_RECIPES.recipeBuilder().duration(600).EUt(4000000)
                .fluidInputs(SolderingAlloy.getFluid(L * 54))
                .fluidInputs(Zylon.getFluid(L * 18))
                .inputs(SENSOR_UEV.getStackForm(2))
                .inputs(ELECTRIC_MOTOR_UEV.getStackForm(8))
                .input(wireGtSingle, ActiniumVibraniumBETSSuperhydride, 64)
                .input(wireGtSingle, ActiniumVibraniumBETSSuperhydride, 64)
                .input(wireGtSingle, ActiniumVibraniumBETSSuperhydride, 64)
                .input(wireGtSingle, ActiniumVibraniumBETSSuperhydride, 64)
                .inputs(VOID_MINER[1].getStackForm())
                .input(circuit, Ultra, 4)
                .input(gear, HastelloyX78, 4)
                .input(screw, Lafium, 64)
                .input(screw, Pikyonium, 64)
                .input(plate, HastelloyK243, 8)
                .input(stick, TitanSteel, 16)
                .outputs(VOID_MINER[2].getStackForm())
                .buildAndRegister();

        // Bio Reactor
        ASSEMBLY_LINE_RECIPES.recipeBuilder().EUt(30720).duration(500)
                .fluidInputs(SolderingAlloy.getFluid(L * 9))
                .inputs(SENSOR_LUV.getStackForm(2))
                .inputs(ELECTRIC_PUMP_LUV.getStackForm(2))
                .inputs(ROBOT_ARM_LUV.getStackForm(2))
                .inputs(EMITTER_LUV.getStackForm(2))
                .input(plate, HSSS, 8)
                .input(screw, NaquadahEnriched, 16)
                .input(circuit, Ultimate, 8)
                .input(gear, HastelloyN, 8)
                .input(bolt, Enderium, 32)
                .input(screw, IncoloyMA956, 32)
                .input(plate, Nitinol60, 16)
                .outputs(BIO_REACTOR.getStackForm())
                .buildAndRegister();

        // Cosmic Ray Detector
        ASSEMBLY_LINE_RECIPES.recipeBuilder().duration(410).EUt(24000000)
                .fluidInputs(Cinobite.getFluid(L * 6))
                .fluidInputs(SolderingAlloy.getFluid(L * 9))
                .input(gear, Quantum, 12)
                .input(plateDense, TitanSteel, 8)
                .input(plate, Adamantium, 24)
                .input(foil, FullerenePolymerMatrix, 6)
                .inputs(SENSOR_UIV.getStackForm(4))
                .inputs(SCINTILLATOR.getStackForm(2))
                .inputs(LEPTON_TRAP_CRYSTAL.getStackForm(4))
                .inputs(GAMetaBlocks.FUSION_CASING.getItemVariant(ADV_FUSION_COIL_3, 2))
                .outputs(COSMIC_RAY_DETECTOR.getStackForm())
                .buildAndRegister();

        // Naquadah Reactor
        ASSEMBLY_LINE_RECIPES.recipeBuilder().duration(1000).EUt(90000)
                .fluidInputs(SolderingAlloy.getFluid(L * 20))
                .fluidInputs(Protactinium233.getFluid(L * 2))
                .input(plate, Tritanium, 8)
                .input(foil, EnrichedNaquadahAlloy, 24)
                .input(gear, Duranium, 16)
                .input(plateDense, Naquadria, 4)
                .inputs(FIELD_GENERATOR_UV.getStackForm(1))
                .inputs(ELECTRIC_PUMP_UV.getStackForm(1))
                .inputs(ELECTRIC_PISTON_UV.getStackForm(2))
                .inputs(HIGH_POWER_INTEGRATED_CIRCUIT.getStackForm(32))
                .input(wireGtSingle, UraniumRhodiumDinaquadide, 32)
                .input(circuit, Superconductor)
                .input(circuit, Superconductor)
                .input(circuit, Superconductor)
                .input(circuit, Superconductor)
                .outputs(LARGE_NAQUADAH_REACTOR.getStackForm())
                .buildAndRegister();

        /* TODO fusion with CEu
        // Fusion Reactor Mk1
        ASSEMBLY_LINE_RECIPES.recipeBuilder().duration(1000).EUt(30000)
                .fluidInputs(SolderingAlloy.getFluid(L * 20))
                .inputs(MetaBlocks.WIRE_COIL.getItemVariant(FUSION_COIL))
                .input(plate, Americium, 4)
                .input(plate, NetherStar, 4)
                .inputs(FIELD_GENERATOR_IV.getStackForm(2))
                .inputs(HIGH_POWER_INTEGRATED_CIRCUIT.getStackForm(32))
                .input(wireGtSingle, LEnrichedNaquadahTriniumEuropiumDuranide, 32)
                .input(circuit, Ultimate)
                .input(circuit, Ultimate)
                .input(circuit, Ultimate)
                .input(circuit, Ultimate)
                .outputs(FUSION_REACTOR[0].getStackForm())
                .buildAndRegister();

        // Fusion Reactor Mk2
        ASSEMBLY_LINE_RECIPES.recipeBuilder().duration(1000).EUt(60000)
                .fluidInputs(SolderingAlloy.getFluid(L * 20))
                .inputs(GAMetaBlocks.FUSION_CASING.getItemVariant(FUSION_COIL_2))
                .input(plate, Rutherfordium, 4)
                .input(plate, Curium.getMaterial(), 4)
                .inputs(FIELD_GENERATOR_LUV.getStackForm(2))
                .inputs(HIGH_POWER_INTEGRATED_CIRCUIT.getStackForm(48))
                .input(wireGtDouble, ZPMSuperconductor, 32)
                .input(circuit, Superconductor)
                .input(circuit, Superconductor)
                .input(circuit, Superconductor)
                .input(circuit, Superconductor)
                .outputs(GATileEntities.FUSION_REACTOR[1].getStackForm())
                .buildAndRegister();

        // Fusion Reactor Mk3
        ASSEMBLY_LINE_RECIPES.recipeBuilder().duration(1000).EUt(90000)
                .fluidInputs(SolderingAlloy.getFluid(L * 20))
                .inputs(GAMetaBlocks.FUSION_CASING.getItemVariant(FUSION_COIL_3))
                .input(plate, Dubnium, 4)
                .input(plate, Fermium.getMaterial(), 4)
                .inputs(FIELD_GENERATOR_ZPM.getStackForm(2))
                .inputs(HIGH_POWER_INTEGRATED_CIRCUIT.getStackForm(64))
                .input(wireGtQuadruple, EnrichedNaquadahTriniumEuropiumDuranide, 32)
                .input(circuit, Infinite)
                .input(circuit, Infinite)
                .input(circuit, Infinite)
                .input(circuit, Infinite)
                .outputs(GATileEntities.FUSION_REACTOR[2].getStackForm())
                .buildAndRegister();
         */

        // Hyper Reactor Mk1
        ASSEMBLY_LINE_RECIPES.recipeBuilder().duration(500).EUt(2000000)
                .fluidInputs(SolderingAlloy.getFluid(L * 9))
                .input(plate, Tritanium, 8)
                .input(plate, Naquadria, 32)
                .input(screw, Naquadria, 64)
                .input(screw, Dubnium, 64)
                .input(foil, Polyetheretherketone, 64)
                .inputs(LARGE_NAQUADAH_REACTOR.getStackForm())
                .inputs(UHPIC.getStackForm(16))
                .inputs(ELECTRIC_PUMP_UHV.getStackForm(2))
                .inputs(FIELD_GENERATOR_UHV.getStackForm(2))
                .input(circuit, Infinite, 4)
                .outputs(HYPER_REACTOR_I.getStackForm())
                .buildAndRegister();

        // Hyper Reactor Mk2
        ASSEMBLY_LINE_RECIPES.recipeBuilder().duration(500).EUt(8000000)
                .fluidInputs(SolderingAlloy.getFluid(L * 36))
                .input(plate, Incoloy813, 32)
                .input(plate, EnrichedNaquadahAlloy, 32)
                .input(screw, Ruridit, 64)
                .input(stick, AbyssalAlloy, 16)
                .input(gear, TungstenTitaniumCarbide, 8)
                .input(circuit, Ultra, 4)
                .input(foil, Zylon, 64)
                .inputs(FIELD_GENERATOR_UEV.getStackForm(2))
                .inputs(ELECTRIC_PUMP_UEV.getStackForm(2))
                .inputs(HYPER_REACTOR_I.getStackForm())
                .outputs(HYPER_REACTOR_II.getStackForm())
                .buildAndRegister();

        // Hyper Reactor Mk3
        ASSEMBLY_LINE_RECIPES.recipeBuilder().duration(500).EUt(32000000)
                .fluidInputs(SolderingAlloy.getFluid(L * 144))
                .input(plate, HastelloyX78, 32)
                .input(plate, HastelloyK243, 32)
                .input(screw, Zeron100, 64)
                .input(stick, TitanSteel, 16)
                .input(gear, Pikyonium, 8)
                .input(circuit, Insane, 4)
                .inputs(DEGENERATE_RHENIUM_PLATE.getStackForm(4))
                .input(foil, Zylon, 64)
                .input(foil, Zylon, 64)
                .inputs(FIELD_GENERATOR_UIV.getStackForm(2))
                .inputs(ELECTRIC_PUMP_UIV.getStackForm(2))
                .inputs(HYPER_REACTOR_II.getStackForm())
                .outputs(HYPER_REACTOR_III.getStackForm())
                .buildAndRegister();

        // Stellar Forge
        ASSEMBLY_LINE_RECIPES.recipeBuilder().duration(500).EUt(2000000)
                .fluidInputs(SolderingAlloy.getFluid(L * 144))
                .input(plate, Trinium, 32)
                .input(stick, HDCS, 16)
                .input(gear, TungstenTitaniumCarbide, 16)
                .input(screw, Incoloy813, 32)
                .input(bolt, EnrichedNaquadahAlloy, 64)
                .input(circuit, Superconductor, 4)
                .inputs(SENSOR_UHV.getStackForm(4))
                .inputs(EMITTER_UHV.getStackForm(4))
                .inputs(FIELD_GENERATOR_UHV.getStackForm(2))
                .outputs(STELLAR_FORGE.getStackForm())
                .buildAndRegister();

        // Plasma Condenser
        ASSEMBLY_LINE_RECIPES.recipeBuilder().duration(250).EUt(7680)
                .fluidInputs(SolderingAlloy.getFluid(L * 10))
                .inputs(SENSOR_LUV.getStackForm())
                .inputs(ELECTRIC_MOTOR_LUV.getStackForm(2))
                .inputs(ELECTRIC_PUMP_LUV.getStackForm(2))
                .input(plate, RhodiumPlatedPalladium, 8)
                .input(gear, TungstenCarbide, 4)
                .input(screw, Inconel792, 16)
                .input(circuit, Master, 2)
                .outputs(PLASMA_CONDENSER.getStackForm())
                .buildAndRegister();

        // Qubit Computer
        ASSEMBLY_LINE_RECIPES.recipeBuilder().duration(1000).EUt(8000000)
                .fluidInputs(SolderingAlloy.getFluid(L * 20))
                .fluidInputs(Zylon.getFluid(L * 20))
                .input(frameGt, Bohrium, 16)
                .input(plate, Bohrium, 16)
                .input(gearSmall, Bohrium, 16)
                .input(round, Bohrium, 16)
                .inputs(GAMetaBlocks.QUANTUM_CASING.getItemVariant(COMPUTER, 4))
                .inputs(GAMetaBlocks.QUANTUM_CASING.getItemVariant(COMPUTER, 4))
                .inputs(GAMetaBlocks.QUANTUM_CASING.getItemVariant(COMPUTER, 4))
                .inputs(GAMetaBlocks.QUANTUM_CASING.getItemVariant(COMPUTER, 4))
                .inputs(ROBOT_ARM_UEV.getStackForm(2))
                .inputs(FIELD_GENERATOR_UEV.getStackForm(2))
                .input(wireGtHex, BlackTitanium, 16)
                .input(circuit, Ultra)
                .input(circuit, Ultra)
                .input(circuit, Ultra)
                .input(circuit, Ultra)
                .outputs(QUBIT_COMPUTER.getStackForm()).buildAndRegister();

        // Nuclear Reactor
        //ModHandler.addShapedRecipe("ga_boiling_water_thorium_reactor", NUCLEAR_REACTOR.getStackForm(),
        //        "GCG", "IHI", "PCP",
        //        'H', HULL[EV].getStackForm(),
        //        'C', new UnificationEntry(plateDense, Thorium),
        //        'P', new UnificationEntry(plate, HastelloyN),
        //        'G', new UnificationEntry(gear, HastelloyN),
        //        'I', MetaItems.ROBOT_ARM_EV);

        // Nuclear Breeder Reactor
        //ModHandler.addShapedRecipe("ga_boiling_water_uranium_reactor", NUCLEAR_BREEDER.getStackForm(),
        //        "GCG", "IHI", "PCP",
        //        'H', HULL[IV].getStackForm(),
        //        'C', new UnificationEntry(plateDense, Uranium235),
        //        'P', new UnificationEntry(plate, HastelloyN),
        //        'G', new UnificationEntry(gear, HastelloyN),
        //        'I', ROBOT_ARM_IV);

        // Gas Centrifuge
        //ModHandler.addShapedRecipe("ga_gas_centrifuge", GAS_CENTRIFUGE.getStackForm(),
        //        "PCP", "CHC", "PCP",
        //        'H', HULL[EV].getStackForm(),
        //        'C', ELECTRIC_MOTOR_EV.getStackForm(),
        //        'P', ELECTRIC_PUMP_EV);

        // Hot Coolant Turbine
        //ModHandler.addShapedRecipe("ga_large_hot_coolant_turbine", GATileEntities.HOT_COOLANT_TURBINE.getStackForm(),
        //        "PSP", "SAS", "CSC",
        //        'S', new UnificationEntry(gear, Stellite),
        //        'P', new UnificationEntry(circuit, Advanced),
        //        'A', HULL[EV].getStackForm(),
        //        'C', new UnificationEntry(pipeLarge, Ultimet));
    }

    private static void largeMultiblockInit() {
        // Large Circuit Assembler
        ModHandler.addShapedRecipe("ga_large_circuit_assembly", LARGE_CIRCUIT_ASSEMBLY_LINE.getStackForm(),
                "CRC", "SAS", "CRC",
                'A', HULL[LuV].getStackForm(),
                'R', ROBOT_ARM_LUV,
                'C', MetaBlocks.MULTIBLOCK_CASING.getItemVariant(ASSEMBLER_CASING),
                'S', new UnificationEntry(circuit, Ultimate));
    }

    private static void multiblockOverride() {

        // Primitive Blast Furnace (PBF) todo are these still needed with CEu?
        ModHandler.removeRecipeByName("gregtech:bronze_primitive_blast_furnace");
        ModHandler.addShapedRecipe("ga_primitive_blast_furnace", MetaTileEntities.PRIMITIVE_BLAST_FURNACE.getStackForm(),
                "hRS", "PBR", "dRS",
                'R', new UnificationEntry(stick, Iron),
                'S', new UnificationEntry(screw, Iron),
                'P', new UnificationEntry(plate, Iron),
                'B', MetaBlocks.METAL_CASING.getItemVariant(PRIMITIVE_BRICKS));

        // Large Bronze Boiler
        ModHandler.removeRecipeByName("gregtech:large_bronze_boiler");
        ModHandler.addShapedRecipe("ga_large_bronze_boiler", MetaTileEntities.LARGE_BRONZE_BOILER.getStackForm(),
                "PSP", "SAS", "PSP",
                'P', new UnificationEntry(cableGtSingle, Tin),
                'S', new UnificationEntry(circuit, Basic),
                'A', MetaBlocks.METAL_CASING.getItemVariant(BRONZE_BRICKS));

        // Large Steel Boiler
        ModHandler.removeRecipeByName("gregtech:large_steel_boiler");
        ModHandler.addShapedRecipe("ga_large_steel_boiler", MetaTileEntities.LARGE_STEEL_BOILER.getStackForm(),
                "PSP", "SAS", "PSP",
                'P', new UnificationEntry(cableGtSingle, Copper),
                'S', new UnificationEntry(circuit, Advanced),
                'A', MetaBlocks.METAL_CASING.getItemVariant(STEEL_SOLID));

        // Large Titanium Boiler
        ModHandler.removeRecipeByName("gregtech:large_titanium_boiler");
        ModHandler.addShapedRecipe("ga_large_titanium_boiler", MetaTileEntities.LARGE_TITANIUM_BOILER.getStackForm(),
                "PSP", "SAS", "PSP",
                'P', new UnificationEntry(cableGtSingle, Gold),
                'S', new UnificationEntry(circuit, Elite),
                'A', MetaBlocks.METAL_CASING.getItemVariant(TITANIUM_STABLE));

        // Large Tungstensteel Boiler
        ModHandler.removeRecipeByName("gregtech:large_tungstensteel_boiler");
        ModHandler.addShapedRecipe("ga_large_tungstensteel_boiler", MetaTileEntities.LARGE_TUNGSTENSTEEL_BOILER.getStackForm(),
                "PSP", "SAS", "PSP",
                'P', new UnificationEntry(cableGtSingle, Aluminium),
                'S', new UnificationEntry(circuit, Master),
                'A', MetaBlocks.METAL_CASING.getItemVariant(TUNGSTENSTEEL_ROBUST));
    }
}
