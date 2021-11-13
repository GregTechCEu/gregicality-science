package gregicality.science.common.item;

import gregicality.science.GregicalityScience;
import gregicality.science.client.model.IReTexturedModel;
import gregicality.science.common.item.components.*;
import gregicality.science.common.item.fusion.GACryostatCasing;
import gregicality.science.common.item.fusion.GADivertorCasing;
import gregicality.science.common.item.fusion.GAFusionCasing;
import gregicality.science.common.item.fusion.GAVacuumCasing;
import gregicality.science.common.item.metal.NuclearCasing;
import gregicality.science.api.pipelike.opticalfiber.BlockOpticalFiber;
import gregicality.science.api.pipelike.opticalfiber.OpticalFiberSize;
import gregicality.science.api.pipelike.opticalfiber.tile.TileEntityOpticalFiber;
import gregicality.science.api.pipelike.opticalfiber.tile.TileEntityOpticalFiberTickable;
import gregicality.science.client.renderer.OpticalFiberRenderer;
import gregtech.api.unification.OreDictUnifier;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.DefaultStateMapper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import java.util.*;
import java.util.stream.Collectors;

public class GAMetaBlocks {

    public static GAMultiblockCasing MUTLIBLOCK_CASING;
    public static GAMultiblockCasing2 MUTLIBLOCK_CASING2;
    public static GASimpleBlock SIMPLE_BLOCK;
    public static GAExplosive EXPLOSIVE;
    public static GATransparentCasing TRANSPARENT_CASING;
    public static GAQuantumCasing QUANTUM_CASING;

    public static GAHeatingCoil HEATING_COIL;


    //reactor casing
    public static GAReactorCasing REACTOR_CASING;
    public static GAFusionCasing FUSION_CASING;
    public static GAVacuumCasing VACUUM_CASING;
    public static GADivertorCasing DIVERTOR_CASING;
    public static GACryostatCasing CRYOSTAT_CASING;

    //large simple multiblock casing
    public static MotorCasing MOTOR_CASING;
    public static ConveyorCasing CONVEYOR_CASING;
    public static EmitterCasing EMITTER_CASING;
    public static FieldGenCasing FIELD_GEN_CASING;
    public static PistonCasing PISTON_CASING;
    public static PumpCasing PUMP_CASING;
    public static RobotArmCasing ROBOT_ARM_CASING;
    public static SensorCasing SENSOR_CASING;

    public static BlockOpticalFiber OPTICAL_FIBER;


    public static void init() {

        QUANTUM_CASING = new GAQuantumCasing();
        QUANTUM_CASING.setRegistryName("ga_quantum_casing");

        MUTLIBLOCK_CASING = new GAMultiblockCasing();
        MUTLIBLOCK_CASING.setRegistryName("ga_multiblock_casing");

        MUTLIBLOCK_CASING2 = new GAMultiblockCasing2();
        MUTLIBLOCK_CASING2.setRegistryName("ga_multiblock_casing2");

        SIMPLE_BLOCK = new GASimpleBlock();
        SIMPLE_BLOCK.setRegistryName("ga_simple_block");

        EXPLOSIVE = new GAExplosive();
        EXPLOSIVE.setRegistryName("ga_explosive");

        REACTOR_CASING = new GAReactorCasing();
        REACTOR_CASING.setRegistryName("ga_reactor_casing");

        FUSION_CASING = new GAFusionCasing();
        FUSION_CASING.setRegistryName("ga_fusion_casing");

        VACUUM_CASING = new GAVacuumCasing();
        VACUUM_CASING.setRegistryName("ga_vacuum_casing");

        HEATING_COIL = new GAHeatingCoil();
        HEATING_COIL.setRegistryName("ga_heating_coil");

        DIVERTOR_CASING = new GADivertorCasing();
        DIVERTOR_CASING.setRegistryName("ga_divertor_casing");

        CRYOSTAT_CASING = new GACryostatCasing();
        CRYOSTAT_CASING.setRegistryName("ga_cryostat_casing");

        TRANSPARENT_CASING = new GATransparentCasing();
        TRANSPARENT_CASING.setRegistryName("ga_transparent_casing");

        MOTOR_CASING = new MotorCasing();
        MOTOR_CASING.setRegistryName("ga_motor_casing");

        CONVEYOR_CASING = new ConveyorCasing();
        CONVEYOR_CASING.setRegistryName("ga_conveyor_casing");

        FIELD_GEN_CASING = new FieldGenCasing();
        FIELD_GEN_CASING.setRegistryName("ga_field_gen_casing");

        PISTON_CASING = new PistonCasing();
        PISTON_CASING.setRegistryName("ga_piston_casing");

        PUMP_CASING = new PumpCasing();
        PUMP_CASING.setRegistryName("ga_pump_casing");

        ROBOT_ARM_CASING = new RobotArmCasing();
        ROBOT_ARM_CASING.setRegistryName("ga_robot_arm_casing");

        SENSOR_CASING = new SensorCasing();
        SENSOR_CASING.setRegistryName("ga_sensor_casing");

        EMITTER_CASING = new EmitterCasing();
        EMITTER_CASING.setRegistryName("ga_emitter_casing");

        OPTICAL_FIBER = new BlockOpticalFiber();
        OPTICAL_FIBER.setRegistryName("ga_cable");

/* TODO Check that all these are set in the respective Materials classes
        GA_CABLE.addCableMaterial(UHVSuperconductorBase, new WireProperties(GAValues.V[GAValues.UHV], 4, 2));
        GA_CABLE.addCableMaterial(UEVSuperconductorBase, new WireProperties(GAValues.V[GAValues.UEV], 4, 2));
        GA_CABLE.addCableMaterial(UIVSuperconductorBase, new WireProperties(GAValues.V[GAValues.UIV], 4, 2));
        GA_CABLE.addCableMaterial(UMVSuperconductorBase, new WireProperties(GAValues.V[GAValues.UMV], 4, 2));
        GA_CABLE.addCableMaterial(UXVSuperconductorBase, new WireProperties(GAValues.V[GAValues.UXV], 4, 2));
        GA_CABLE.addCableMaterial(TungstenTitaniumCarbide, new WireProperties(GAValues.V[GAValues.UHV], 4, 16));
        GA_CABLE.addCableMaterial(AbyssalAlloy, new WireProperties(GAValues.V[GAValues.UHV], 2, 8));
        GA_CABLE.addCableMaterial(EnrichedNaquadahAlloy, new WireProperties(GAValues.V[GAValues.UHV], 1, 4));
        GA_CABLE.addCableMaterial(Pikyonium, new WireProperties(GAValues.V[GAValues.UEV], 4, 32));
        GA_CABLE.addCableMaterial(TitanSteel, new WireProperties(GAValues.V[GAValues.UEV], 2, 16));
        GA_CABLE.addCableMaterial(Cinobite, new WireProperties(GAValues.V[GAValues.UIV], 4, 64));
        GA_CABLE.addCableMaterial(BlackTitanium, new WireProperties(GAValues.V[GAValues.UIV], 2, 32));
        GA_CABLE.addCableMaterial(Neutronium, new WireProperties(GAValues.V[GAValues.UMV], 2, 32));
        GA_CABLE.addCableMaterial(UHVSuperconductor, new WireProperties(GAValues.V[GAValues.UHV], 4, 0));
        GA_CABLE.addCableMaterial(UEVSuperconductor, new WireProperties(GAValues.V[GAValues.UEV], 4, 0));
        GA_CABLE.addCableMaterial(UIVSuperconductor, new WireProperties(GAValues.V[GAValues.UIV], 4, 0));
        GA_CABLE.addCableMaterial(UMVSuperconductor, new WireProperties(GAValues.V[GAValues.UMV], 4, 0));
        GA_CABLE.addCableMaterial(UXVSuperconductor, new WireProperties(GAValues.V[GAValues.UXV], 4, 0));
*/
        registerTileEntity();
    }

    @SideOnly(Side.CLIENT)
    public static void registerItemModels() {

        ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(OPTICAL_FIBER), stack -> OpticalFiberRenderer.MODEL_LOCATION);
        registerItemModel(MUTLIBLOCK_CASING);
        registerItemModel(QUANTUM_CASING);
        registerItemModel(MUTLIBLOCK_CASING2);
        registerItemModel(SIMPLE_BLOCK);
        registerItemModel(EXPLOSIVE);
        registerItemModel(REACTOR_CASING);
        registerItemModel(FUSION_CASING);
        registerItemModel(VACUUM_CASING);
        registerItemModel(HEATING_COIL);
        registerItemModel(DIVERTOR_CASING);
        registerItemModel(CRYOSTAT_CASING);
        registerItemModel(TRANSPARENT_CASING);
        registerItemModel(CONVEYOR_CASING);
        registerItemModel(EMITTER_CASING);
        registerItemModel(FIELD_GEN_CASING);
        registerItemModel(MOTOR_CASING);
        registerItemModel(PISTON_CASING);
        registerItemModel(PUMP_CASING);
        registerItemModel(ROBOT_ARM_CASING);
        registerItemModel(SENSOR_CASING);
    }

    public static void registerTileEntity() {
        GameRegistry.registerTileEntity(TileEntityOpticalFiber.class, new ResourceLocation(GregicalityScience.MODID, "cable"));
        GameRegistry.registerTileEntity(TileEntityOpticalFiberTickable.class, new ResourceLocation(GregicalityScience.MODID, "cable_tickable"));
    }

    @SideOnly(Side.CLIENT)
    public static void registerStateMappers() {
        ModelLoader.setCustomStateMapper(OPTICAL_FIBER, new DefaultStateMapper() {
            @Override
            protected @Nonnull ModelResourceLocation getModelResourceLocation(IBlockState state) {
                return OpticalFiberRenderer.MODEL_LOCATION;
            }
        });
    }

    @SideOnly(Side.CLIENT)
    public static void registerItemModel(Block block) {
        for (IBlockState state : block.getBlockState().getValidStates()) {
            //noinspection ConstantConditions
            ModelResourceLocation resourceLocation = new ModelResourceLocation(block.getRegistryName(), statePropertiesToString(state.getProperties()));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), block.getMetaFromState(state), resourceLocation);
            if (block instanceof IReTexturedModel) {
                ((IReTexturedModel) block).register(state, resourceLocation);
            }
        }
    }

    public static void registerOreDict() {
        for (OpticalFiberSize opticalFiberSize : OpticalFiberSize.values()) {
            ItemStack itemStack = OPTICAL_FIBER.getItem(opticalFiberSize);
            OreDictUnifier.registerOre(itemStack, opticalFiberSize.getOrePrefix().name());
        }
    }


    public static String statePropertiesToString(Map<IProperty<?>, Comparable<?>> properties) {
        StringBuilder stringbuilder = new StringBuilder();

        List<Map.Entry<IProperty<?>, Comparable<?>>> entries = properties.entrySet().stream().sorted(Comparator.comparing(c -> c.getKey().getName())).collect(Collectors.toList());

        for (Map.Entry<IProperty<?>, Comparable<?>> entry : entries) {
            if (stringbuilder.length() != 0) {
                stringbuilder.append(",");
            }

            IProperty<?> property = entry.getKey();
            stringbuilder.append(property.getName());
            stringbuilder.append("=");
            stringbuilder.append(getPropertyName(property, entry.getValue()));
        }

        if (stringbuilder.length() == 0) {
            stringbuilder.append("normal");
        }

        return stringbuilder.toString();
    }

    @SuppressWarnings("unchecked")
    private static <T extends Comparable<T>> String getPropertyName(IProperty<T> property, Comparable<?> value) {
        return property.getName((T) value);
    }
}
