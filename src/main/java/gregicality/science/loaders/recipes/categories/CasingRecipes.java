package gregicality.science.loaders.recipes.categories;

import gregicality.science.common.block.GCYSciMetaBlocks;
import gregicality.science.common.block.GAMultiblockCasing2;
import gregicality.science.common.item.metal.MetalCasing2;
import gregtech.api.GTValues;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.blocks.*;
import gregtech.common.metatileentities.MetaTileEntities;
import gregtech.loaders.recipe.CraftingComponent;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;

import java.util.Arrays;

import static gregicality.science.api.GCYSciMaterials.*;
import static gregicality.science.common.item.CellCasing.CellType.*;
import static gregicality.science.common.block.GAHeatingCoil.CoilType.*;
import static gregicality.science.common.item.GCYSciMetaItems.*;
import static gregicality.science.common.block.GAMultiblockCasing.CasingType.*;
import static gregicality.science.common.block.GAMultiblockCasing2.CasingType.*;
import static gregicality.science.common.block.GAQuantumCasing.CasingType.COMPUTER;
import static gregicality.science.common.block.GAReactorCasing.CasingType.*;
import static gregicality.science.common.block.fusion.GAFusionCasing.CasingType.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.MarkerMaterials.Tier.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregicality.science.common.block.GATransparentCasing.CasingType.*;
import static gregtech.common.blocks.BlockFusionCoil.CoilType.FUSION_COIL;
import static gregtech.common.blocks.BlockMultiblockCasing.MultiblockCasingType.*;
import static gregtech.common.items.MetaItems.*;

public class CasingRecipes {

    public static void init() {
        //componentCasings(); // todo fix
        multiblockCasings();
        coilCasings();
        tieredCasings();
        tieredGlass();
    }

    private static void tieredCasings() {

        // Integral Frameworks
        ASSEMBLER_RECIPES.recipeBuilder().duration(100).EUt(16)
                .input(circuit, Primitive, 2)
                .input(gear, Potin, 8)
                .input(plate, Potin, 8)
                .input(cableGtOctal, Tin)
                .inputs(MetaTileEntities.HULL[ULV].getStackForm())
                .fluidInputs(Steel.getFluid(L * 10))
                .outputs(GCYSciMetaBlocks.MUTLIBLOCK_CASING.getItemVariant(TIERED_HULL_ULV))
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder().duration(100).EUt(32)
                .input(circuit, Basic, 2)
                .input(gear, Magnalium, 8)
                .input(plate, Magnalium, 8)
                .input(cableGtOctal, Cobalt)
                .inputs(MetaTileEntities.HULL[LV].getStackForm())
                .fluidInputs(Silicon.getFluid(L * 10))
                .outputs(GCYSciMetaBlocks.MUTLIBLOCK_CASING.getItemVariant(TIERED_HULL_LV))
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder().duration(100).EUt(64)
                .input(circuit, Good, 2)
                .input(gear, EglinSteel, 8)
                .input(plate, EglinSteel, 8)
                .input(cableGtOctal, AnnealedCopper)
                .inputs(MetaTileEntities.HULL[MV].getStackForm())
                .fluidInputs(BabbittAlloy.getFluid(L * 10))
                .outputs(GCYSciMetaBlocks.MUTLIBLOCK_CASING.getItemVariant(TIERED_HULL_MV))
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder().duration(100).EUt(128)
                .input(circuit, Advanced, 2)
                .input(gear, Inconel625, 8)
                .input(plate, Inconel625, 8)
                .input(cableGtOctal, Gold)
                .inputs(MetaTileEntities.HULL[HV].getStackForm())
                .fluidInputs(Inconel625.getFluid(L * 10))
                .outputs(GCYSciMetaBlocks.MUTLIBLOCK_CASING.getItemVariant(TIERED_HULL_HV))
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder().duration(100).EUt(256)
                .input(circuit, Extreme, 2)
                .input(gear, TungstenCarbide, 8)
                .input(plate, TungstenCarbide, 8)
                .input(cableGtOctal, Titanium)
                .inputs(MetaTileEntities.HULL[EV].getStackForm())
                .fluidInputs(Stellite.getFluid(L * 10))
                .outputs(GCYSciMetaBlocks.MUTLIBLOCK_CASING.getItemVariant(TIERED_HULL_EV))
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder().duration(100).EUt(512)
                .input(circuit, Elite, 2)
                .input(gear, Nitinol60, 8)
                .input(plate, Nitinol60, 8)
                .input(cableGtOctal, Nichrome)
                .inputs(MetaTileEntities.HULL[IV].getStackForm())
                .fluidInputs(Thorium.getFluid(L * 10))
                .outputs(GCYSciMetaBlocks.MUTLIBLOCK_CASING.getItemVariant(TIERED_HULL_IV))
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder().duration(100).EUt(1024)
                .input(circuit, Master, 2)
                .input(gear, IncoloyMA956, 8)
                .input(plate, IncoloyMA956, 8)
                .input(cableGtOctal, Platinum)
                .inputs(MetaTileEntities.HULL[LuV].getStackForm())
                .fluidInputs(Uranium238.getFluid(L * 10))
                .outputs(GCYSciMetaBlocks.MUTLIBLOCK_CASING.getItemVariant(TIERED_HULL_LUV))
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder().duration(100).EUt(2048)
                .input(circuit, Ultimate, 2)
                .input(gear, BabbittAlloy, 8)
                .input(plate, BabbittAlloy, 8)
                .input(cableGtOctal, NiobiumTitanium)
                .inputs(MetaTileEntities.HULL[GTValues.ZPM].getStackForm())
                .fluidInputs(Plutonium244.getFluid(L * 10))
                .outputs(GCYSciMetaBlocks.MUTLIBLOCK_CASING.getItemVariant(TIERED_HULL_ZPM))
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder().duration(100).EUt(4096)
                .input(circuit, Superconductor, 2)
                .input(gear, HG1223, 8)
                .input(plate, HG1223, 8)
                .input(cableGtOctal, YttriumBariumCuprate)
                .inputs(MetaTileEntities.HULL[UV].getStackForm())
                .fluidInputs(NaquadahEnriched.getFluid(L * 10))
                .outputs(GCYSciMetaBlocks.MUTLIBLOCK_CASING.getItemVariant(TIERED_HULL_UV))
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder().duration(100).EUt(8192)
                .input(circuit, Infinite, 2)
                .input(gear, AbyssalAlloy, 8)
                .input(plate, AbyssalAlloy, 8)
                .input(cableGtSingle, TungstenTitaniumCarbide, 16)
                .inputs(MetaTileEntities.HULL[UHV].getStackForm())
                .fluidInputs(Naquadria.getFluid(L * 10))
                .outputs(GCYSciMetaBlocks.MUTLIBLOCK_CASING2.getItemVariant(TIERED_HULL_UHV))
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder().duration(100).EUt(8192)
                .input(circuit, MarkerMaterials.Tier.Ultra, 2)
                .input(gear, TitanSteel, 8)
                .input(plate, TitanSteel, 8)
                .input(cableGtSingle, Pikyonium, 16)
                .inputs(MetaTileEntities.HULL[UEV].getStackForm())
                .fluidInputs(Naquadria.getFluid(L * 10))
                .outputs(GCYSciMetaBlocks.MUTLIBLOCK_CASING2.getItemVariant(TIERED_HULL_UEV))
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder().duration(100).EUt(8192)
                .input(circuit, MarkerMaterials.Tier.Insane, 2)
                .input(gear, BlackTitanium, 8)
                .input(plate, BlackTitanium, 8)
                .input(cableGtSingle, Cinobite, 16)
                .inputs(MetaTileEntities.HULL[UIV].getStackForm())
                .fluidInputs(Naquadria.getFluid(L * 10))
                .outputs(GCYSciMetaBlocks.MUTLIBLOCK_CASING2.getItemVariant(TIERED_HULL_UIV))
                .buildAndRegister();
    }

    private static void tieredGlass() {

        // Reinforced Glass
        ALLOY_SMELTER_RECIPES.recipeBuilder().duration(400).EUt(4)
                .inputs(ADVANCED_ALLOY_PLATE.getStackForm())
                .input(dust, Glass, 3)
                .outputs(GCYSciMetaBlocks.TRANSPARENT_CASING.getItemVariant(REINFORCED_GLASS, 4))
                .buildAndRegister();

        ALLOY_SMELTER_RECIPES.recipeBuilder().duration(400).EUt(4)
                .inputs(ADVANCED_ALLOY_PLATE.getStackForm())
                .inputs(new ItemStack(Blocks.GLASS, 3))
                .outputs(GCYSciMetaBlocks.TRANSPARENT_CASING.getItemVariant(REINFORCED_GLASS, 4))
                .buildAndRegister();

        FLUID_SOLIDFICATION_RECIPES.recipeBuilder().duration(400).EUt(16)
                .inputs(GCYSciMetaBlocks.TRANSPARENT_CASING.getItemVariant(REINFORCED_GLASS))
                .fluidInputs(BorosilicateGlass.getFluid(L))
                .outputs(GCYSciMetaBlocks.TRANSPARENT_CASING.getItemVariant(BOROSILICATE_GLASS))
                .buildAndRegister();

        FLUID_SOLIDFICATION_RECIPES.recipeBuilder().duration(400).EUt(64)
                .inputs(GCYSciMetaBlocks.TRANSPARENT_CASING.getItemVariant(BOROSILICATE_GLASS))
                .fluidInputs(Nickel.getFluid(L))
                .outputs(GCYSciMetaBlocks.TRANSPARENT_CASING.getItemVariant(NICKEL_GLASS))
                .buildAndRegister();

        FLUID_SOLIDFICATION_RECIPES.recipeBuilder().duration(400).EUt(256)
                .inputs(GCYSciMetaBlocks.TRANSPARENT_CASING.getItemVariant(NICKEL_GLASS))
                .fluidInputs(Chrome.getFluid(L))
                .outputs(GCYSciMetaBlocks.TRANSPARENT_CASING.getItemVariant(CHROME_GLASS))
                .buildAndRegister();

        FLUID_SOLIDFICATION_RECIPES.recipeBuilder().duration(400).EUt(1024)
                .inputs(GCYSciMetaBlocks.TRANSPARENT_CASING.getItemVariant(CHROME_GLASS))
                .fluidInputs(Tungsten.getFluid(L))
                .outputs(GCYSciMetaBlocks.TRANSPARENT_CASING.getItemVariant(TUNGSTEN_GLASS))
                .buildAndRegister();

        FLUID_SOLIDFICATION_RECIPES.recipeBuilder().duration(400).EUt(4096)
                .inputs(GCYSciMetaBlocks.TRANSPARENT_CASING.getItemVariant(TUNGSTEN_GLASS))
                .fluidInputs(Iridium.getFluid(L))
                .outputs(GCYSciMetaBlocks.TRANSPARENT_CASING.getItemVariant(IRIDIUM_GLASS))
                .buildAndRegister();

        FLUID_SOLIDFICATION_RECIPES.recipeBuilder().duration(400).EUt(16384)
                .inputs(GCYSciMetaBlocks.TRANSPARENT_CASING.getItemVariant(IRIDIUM_GLASS))
                .fluidInputs(Osmiridium.getFluid(L))
                .outputs(GCYSciMetaBlocks.TRANSPARENT_CASING.getItemVariant(OSMIRIDIUM_GLASS))
                .buildAndRegister();
    }

    private static void coilCasings() {
        //todo fusion materials

        // Fusion Coil Recipes
        ASSEMBLY_LINE_RECIPES.recipeBuilder().EUt(30720).duration(400)
                .inputs(NEUTRON_REFLECTOR.getStackForm(2))
                .inputs(FIELD_GENERATOR_LUV.getStackForm())
                .input(cableGtQuadruple, IndiumTinBariumTitaniumCuprate, 4)
                .input(plate, Osmiridium, 2)
                .input(circuit, Master)
                .fluidInputs(Helium.getFluid(4000))
                .outputs(MetaBlocks.FUSION_COIL.getItemVariant(FUSION_COIL))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder().EUt(122880).duration(400)
                .inputs(NEUTRON_REFLECTOR.getStackForm(4))
                .inputs(FIELD_GENERATOR_ZPM.getStackForm())
                .input(cableGtQuadruple, UraniumRhodiumDinaquadide, 4)
                .input(plate, Rutherfordium, 2)
                .input(circuit, Ultimate)
                .fluidInputs(Helium.getFluid(4000))
                .outputs(GCYSciMetaBlocks.FUSION_CASING.getItemVariant(FUSION_COIL_2))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder().EUt(491520).duration(400)
                .inputs(NEUTRON_REFLECTOR.getStackForm(6))
                .inputs(FIELD_GENERATOR_ZPM.getStackForm(2))
                .input(cableGtQuadruple, EnrichedNaquadahTriniumEuropiumDuranide, 4)
                .input(plate, Tritanium, 2)
                .input(circuit, Superconductor)
                .fluidInputs(Helium.getFluid(4000))
                .outputs(GCYSciMetaBlocks.FUSION_CASING.getItemVariant(FUSION_COIL_3))
                .buildAndRegister();

        // Coils todo coils with CEu
        ASSEMBLER_RECIPES.recipeBuilder().duration(200).EUt(500000)
                .input(wireGtDouble, TitanSteel, 8)
//                .inputs(MICA_INSULATOR_FOIL.getStackForm(8))
                .fluidInputs(Tritanium.getFluid(L))
                .outputs(GCYSciMetaBlocks.HEATING_COIL.getItemVariant(TITAN_STEEL_COIL))
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder().duration(200).EUt(2000000)
                .input(wireGtDouble, Pikyonium, 8)
//                .inputs(MICA_INSULATOR_FOIL.getStackForm(8))
                .fluidInputs(Adamantium.getFluid(L))
                .outputs(GCYSciMetaBlocks.HEATING_COIL.getItemVariant(PIKYONIUM_COIL))
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder().duration(200).EUt(8000000)
                .input(wireGtDouble, BlackTitanium, 8)
//                .inputs(MICA_INSULATOR_FOIL.getStackForm(8))
                .fluidInputs(Vibranium.getFluid(L))
                .outputs(GCYSciMetaBlocks.HEATING_COIL.getItemVariant(BLACK_TITANIUM_COIL))
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder().duration(200).EUt(32000000)
                .input(wireGtDouble, Neutronium, 8)
//                .inputs(MICA_INSULATOR_FOIL.getStackForm(8))
                .fluidInputs(Cinobite.getFluid(L))
                .outputs(GCYSciMetaBlocks.HEATING_COIL.getItemVariant(NEUTRONIUM_COIL))
                .buildAndRegister();
    }

    private static void multiblockCasings() {

        // Reactor Casing
        FORMING_PRESS_RECIPES.recipeBuilder().duration(1500).EUt(500)
                .input(plateDense, Lead, 9)
                .input(plateDense, Lead, 9)
                .input(plateDense, ReactorSteel, 4)
                .input(plateDense, StainlessSteel, 2)
                .outputs(GCYSciMetaBlocks.MUTLIBLOCK_CASING.getItemVariant(CLADDED_REACTOR_CASING, 4))
                .buildAndRegister();

        // Fusion Casing Recipes
        //todo fusion materials
        ModHandler.addShapedRecipe("fusion_casing_2", MetaBlocks.MULTIBLOCK_CASING.getItemVariant(FUSION_CASING_MK2),
                "PhP", "PHP", "PwP",
                'P', new UnificationEntry(plate, Rutherfordium),
                'H', MetaBlocks.MULTIBLOCK_CASING.getItemVariant(FUSION_CASING));

        ASSEMBLER_RECIPES.recipeBuilder().EUt(16).duration(50)
                .inputs(MetaBlocks.MULTIBLOCK_CASING.getItemVariant(FUSION_CASING))
                .input(plate, Rutherfordium, 6)
                .outputs(MetaBlocks.MULTIBLOCK_CASING.getItemVariant(FUSION_CASING_MK2))
                .buildAndRegister();

        ModHandler.addShapedRecipe("fusion_casing_3", GCYSciMetaBlocks.FUSION_CASING.getItemVariant(FUSION_3),
                "PhP", "PHP", "PwP",
                'P', new UnificationEntry(plate, Dubnium),
                'H', MetaBlocks.MULTIBLOCK_CASING.getItemVariant(FUSION_CASING_MK2));

        ASSEMBLER_RECIPES.recipeBuilder().EUt(16).duration(50)
                .inputs(MetaBlocks.MULTIBLOCK_CASING.getItemVariant(FUSION_CASING_MK2))
                .input(plate, Dubnium, 6)
                .outputs(GCYSciMetaBlocks.FUSION_CASING.getItemVariant(FUSION_3))
                .buildAndRegister();

        // Stellar Containment Casing
        ASSEMBLER_RECIPES.recipeBuilder().duration(150).EUt(500000)
                .fluidInputs(SolderingAlloy.getFluid(L * 4))
                .input(frameGt, Trinium)
                .input(plate, HDCS, 6)
                .input(stick, EnrichedNaquadahAlloy, 4)
                .input(screw, Trinium, 8)
                .outputs(GCYSciMetaBlocks.MUTLIBLOCK_CASING2.getItemVariant(STELLAR_CONTAINMENT, 4))
                .buildAndRegister();

        // Hyper Reactor Casing
        ASSEMBLER_RECIPES.recipeBuilder().duration(150).EUt(500000)
                .fluidInputs(SolderingAlloy.getFluid(L * 4))
                .input(frameGt, Naquadria)
                .input(screw, EnrichedNaquadahAlloy, 16)
                .input(plate, Incoloy813, 8)
                .outputs(GCYSciMetaBlocks.REACTOR_CASING.getItemVariant(HYPER_CASING, 4))
                .buildAndRegister();

        // Hyper Reactor Casing 2
        ASSEMBLER_RECIPES.recipeBuilder().duration(150).EUt(2000000)
                .fluidInputs(SolderingAlloy.getFluid(L * 4))
                .inputs(GCYSciMetaBlocks.REACTOR_CASING.getItemVariant(HYPER_CASING))
                .input(screw, Pikyonium, 16)
                .input(plate, TitanSteel, 8)
                .outputs(GCYSciMetaBlocks.REACTOR_CASING.getItemVariant(HYPER_CASING_2, 4))
                .buildAndRegister();

        // Hyper Core
        ASSEMBLER_RECIPES.recipeBuilder().duration(150).EUt(500000)
                .inputs(FIELD_GENERATOR_UV.getStackForm(2))
                .inputs(SENSOR_UV.getStackForm())
                .inputs(EMITTER_UV.getStackForm())
                .input(frameGt, Naquadria, 4)
                .input(screw, Dubnium, 16)
                .input(plate, Naquadria, 4)
                .input(circuit, Superconductor)
                .outputs(GCYSciMetaBlocks.REACTOR_CASING.getItemVariant(HYPER_CORE, 4))
                .buildAndRegister();

        // Hyper Core 2
        ASSEMBLER_RECIPES.recipeBuilder().duration(150).EUt(2000000)
                .inputs(FIELD_GENERATOR_UHV.getStackForm(2))
                .inputs(SENSOR_UHV.getStackForm())
                .inputs(EMITTER_UHV.getStackForm())
                .inputs(GCYSciMetaBlocks.REACTOR_CASING.getItemVariant(HYPER_CASING, 2))
                .input(screw, Rutherfordium, 16)
                .input(plate, TungstenTitaniumCarbide, 4)
                .input(circuit, Infinite)
                .outputs(GCYSciMetaBlocks.REACTOR_CASING.getItemVariant(HYPER_CORE_2, 4))
                .buildAndRegister();

        // Hyper Core 3
        ASSEMBLER_RECIPES.recipeBuilder().duration(150).EUt(8000000)
                .inputs(FIELD_GENERATOR_UEV.getStackForm(2))
                .inputs(SENSOR_UEV.getStackForm())
                .inputs(EMITTER_UEV.getStackForm())
                .inputs(GCYSciMetaBlocks.REACTOR_CASING.getItemVariant(HYPER_CASING_2, 2))
                .input(screw, TriniumTitanium, 16)
                .input(plate, TitanSteel, 4)
                .input(circuit, MarkerMaterials.Tier.Ultra)
                .outputs(GCYSciMetaBlocks.REACTOR_CASING.getItemVariant(HYPER_CORE_3, 4))
                .buildAndRegister();

        // Bio Reactor Casing
        ASSEMBLER_RECIPES.recipeBuilder().duration(150).EUt(120000)
                .input(frameGt, HSSS)
                .input(plate, NaquadahAlloy, 4)
                .input(screw, Dubnium, 4)
                .fluidInputs(SolderingAlloy.getFluid(L))
                .outputs(GCYSciMetaBlocks.MUTLIBLOCK_CASING2.getItemVariant(GAMultiblockCasing2.CasingType.BIO_REACTOR, 2))
                .buildAndRegister();

        // Qubit Computer Casing
        ASSEMBLER_RECIPES.recipeBuilder().duration(120).EUt(6000000)
                .fluidInputs(SolderingAlloy.getFluid(L * 10))
                .inputs(FIELD_GENERATOR_UEV.getStackForm(2))
                .inputs(ROBOT_ARM_UEV.getStackForm())
                .input(circuit, MarkerMaterials.Tier.Ultra, 7)
                .input(frameGt, Bohrium, 5)
                .outputs(GCYSciMetaBlocks.QUANTUM_CASING.getItemVariant(COMPUTER, 3))
                .buildAndRegister();
    }

    private static void componentCasings() {

        Arrays.stream(EmitterCasing.CasingType.values()).forEach(casing ->
                registerComponentBlockRecipe(casing.getTier(), casing, CraftingComponent.EMITTER, GCYSciMetaBlocks.EMITTER_CASING));

        Arrays.stream(MotorCasing.CasingType.values()).forEach(casing ->
                registerComponentBlockRecipe(casing.getTier(), casing, CraftingComponent.MOTOR, GCYSciMetaBlocks.MOTOR_CASING));

        Arrays.stream(PistonCasing.CasingType.values()).forEach(casing ->
                registerComponentBlockRecipe(casing.getTier(), casing, CraftingComponent.PISTON, GCYSciMetaBlocks.PISTON_CASING));

        Arrays.stream(SensorCasing.CasingType.values()).forEach(casing ->
                registerComponentBlockRecipe(casing.getTier(), casing, CraftingComponent.SENSOR, GCYSciMetaBlocks.SENSOR_CASING));

        Arrays.stream(FieldGenCasing.CasingType.values()).forEach(casing ->
                registerComponentBlockRecipe(casing.getTier(), casing, CraftingComponent.FIELD_GENERATOR, GCYSciMetaBlocks.FIELD_GEN_CASING));

        Arrays.stream(PumpCasing.CasingType.values()).forEach(casing ->
                registerComponentBlockRecipe(casing.getTier(), casing, CraftingComponent.PUMP, GCYSciMetaBlocks.PUMP_CASING));

        Arrays.stream(ConveyorCasing.CasingType.values()).forEach(casing ->
                registerComponentBlockRecipe(casing.getTier(), casing, CraftingComponent.CONVEYOR, GCYSciMetaBlocks.CONVEYOR_CASING));

        Arrays.stream(RobotArmCasing.CasingType.values()).forEach(casing ->
                registerComponentBlockRecipe(casing.getTier(), casing, CraftingComponent.ROBOT_ARM, GCYSciMetaBlocks.ROBOT_ARM_CASING));
    }

    private static <T extends Enum<T> & IStringSerializable> void registerComponentBlockRecipe(int tier, T inputComponent, CraftingComponent.Component inputStack, VariantBlock<T> outputCasing) {

        ItemStack stack = ((ItemStack) inputStack.getIngredient(tier)).copy();
        stack.setCount(2);
        ItemStack hull = (ItemStack) CraftingComponent.HULL.getIngredient(tier);
        UnificationEntry cable = (UnificationEntry) CraftingComponent.CABLE.getIngredient(tier);

        ASSEMBLER_RECIPES.recipeBuilder().EUt((int) (30 * Math.pow(4, tier - 1))).duration(200)
                .inputs(stack)
                .inputs(hull)
                .input(cableGtSingle, cable.material, 8)
                .fluidInputs(SolderingAlloy.getFluid(L * 2))
                .outputs(outputCasing.getItemVariant(inputComponent))
                .buildAndRegister();
    }
}
