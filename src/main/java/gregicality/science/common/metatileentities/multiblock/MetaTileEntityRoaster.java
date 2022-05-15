package gregicality.science.common.metatileentities.multiblock;

import gregicality.science.api.recipes.GCYSRecipeMaps;
import gregicality.science.api.recipes.recipeproperties.NoCoilTemperatureProperty;
import gregicality.science.client.render.GCYSTextures;
import gregicality.science.common.metatileentities.GCYSMetaTileEntities;
import gregtech.api.GTValues;
import gregtech.api.capability.IHeatingCoil;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.*;
import gregtech.api.recipes.Recipe;
import gregtech.api.util.BlockInfo;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.ConfigHolder;
import gregtech.common.blocks.BlockFireboxCasing;
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.metatileentities.MetaTileEntities;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import org.apache.commons.lang3.ArrayUtils;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MetaTileEntityRoaster extends RecipeMapMultiblockController implements IHeatingCoil {

    private int temperature;

    public MetaTileEntityRoaster(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, GCYSRecipeMaps.ROASTER_RECIPES);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityRoaster(metaTileEntityId);
    }

    @Override
    protected void formStructure(PatternMatchContext context) {
        super.formStructure(context);
        Object type = context.get("CasingType");
        if (type instanceof BlockFireboxCasing.FireboxCasingType)
            this.temperature = ((BlockFireboxCasing.FireboxCasingType) type).ordinal() * 500 + 1500;
        else this.temperature = 1500;
    }

    @Override
    public void invalidateStructure() {
        super.invalidateStructure();
        this.temperature = 0;
        replaceFireboxAsActive(false);
    }

    @Override
    public void onRemoval() {
        super.onRemoval();
        if (!getWorld().isRemote && isStructureFormed()) {
            replaceFireboxAsActive(false);
        }
    }

    public void replaceFireboxAsActive(boolean isActive) {
        BlockPos centerPos = getPos().offset(getFrontFacing().getOpposite()).down();
        for (int x = -1; x <= 1; x++) {
            for (int z = -1; z <= 1; z++) {
                BlockPos blockPos = centerPos.add(x, 0, z);
                IBlockState blockState = getWorld().getBlockState(blockPos);
                if (blockState.getBlock() instanceof BlockFireboxCasing) {
                    blockState = blockState.withProperty(BlockFireboxCasing.ACTIVE, isActive);
                    getWorld().setBlockState(blockPos, blockState);
                }
            }
        }
    }

    @Override
    public boolean checkRecipe(@Nonnull Recipe recipe, boolean consumeIfSuccess) {
        return this.temperature >= recipe.getProperty(NoCoilTemperatureProperty.getInstance(), 0);
    }

    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("FFF", "XXX", "XXX", "XXX", "XXX", "XXX", " X ")
                .aisle("FFF", "X#X", "X#X", "X#X", "X#X", "X#X", "XMX")
                .aisle("FFF", "XSX", "XXX", "XXX", "XXX", "XXX", " X ")
                .where('S', selfPredicate())
                .where('X', states(MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.STEEL_SOLID)).setMinGlobalLimited(35)
                        .or(autoAbilities(true, true, true, true, true, true, false)))
                .where('M', abilities(MultiblockAbility.MUFFLER_HATCH))
                .where('F', fireboxPredicate())
                .where('#', air())
                .where(' ', any())
                .build();
    }

    private static TraceabilityPredicate fireboxPredicate() {
        return new TraceabilityPredicate(blockWorldState -> {
            IBlockState blockState = blockWorldState.getBlockState();
            if ((blockState.getBlock() instanceof BlockFireboxCasing)) {
                BlockFireboxCasing BlockFireboxCasing = (BlockFireboxCasing) blockState.getBlock();
                BlockFireboxCasing.FireboxCasingType casingType = BlockFireboxCasing.getState(blockState);
                Object currentCasingType = blockWorldState.getMatchContext().getOrPut("CasingType", casingType);
                if (!currentCasingType.toString().equals(casingType.toString())) {
                    blockWorldState.setError(new PatternStringError("gregtech.multiblock.pattern.error.coils"));
                    return false;
                }
                blockWorldState.getMatchContext().getOrPut("VABlock", new LinkedList<>()).add(blockWorldState.getPos());
                return true;
            }
            return false;
        }, () -> ArrayUtils.addAll(Arrays.stream(BlockFireboxCasing.FireboxCasingType.values())
                .map(type -> new BlockInfo(MetaBlocks.BOILER_FIREBOX_CASING.getState(type), null)).toArray(BlockInfo[]::new)))
                .addTooltips("gregtech.multiblock.pattern.error.coils");
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return Textures.SOLID_STEEL_CASING;
    }

    @Override
    protected void addDisplayText(List<ITextComponent> textList) {
        if (isStructureFormed()) {
            textList.add(new TextComponentTranslation("gregtech.multiblock.blast_furnace.max_temperature",
                    new TextComponentTranslation(GTUtility.formatNumbers(temperature) + "K").setStyle(new Style().setColor(TextFormatting.RED))));
        }
        super.addDisplayText(textList);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
    }

    @Override
    public int getCurrentTemperature() {
        return this.temperature;
    }

    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return GCYSTextures.ROASTER_OVERLAY;
    }

    @Override
    public boolean canBeDistinct() {
        return true;
    }

    @Override
    public boolean hasMufflerMechanics() {
        return true;
    }

    @Nonnull
    @Override
    public List<ITextComponent> getDataInfo() {
        List<ITextComponent> list = super.getDataInfo();
        list.add(new TextComponentTranslation("gregtech.multiblock.blast_furnace.max_temperature",
                new TextComponentTranslation(GTUtility.formatNumbers(temperature) + "K").setStyle(new Style().setColor(TextFormatting.RED))));
        return list;
    }

    @Override
    public List<MultiblockShapeInfo> getMatchingShapes() {
        ArrayList<MultiblockShapeInfo> shapeInfo = new ArrayList<>();
        MultiblockShapeInfo.Builder builder = MultiblockShapeInfo.builder()
                .aisle("FFF", "XEM", "XXX", "XXX", "XXX", "XXX", " X ")
                .aisle("FFF", "X X", "X X", "X X", "X X", "X X", "XHX")
                .aisle("FFF", "ISO", "DXL", "XXX", "XXX", "XXX", " X ")
                .where('S', GCYSMetaTileEntities.ROASTER, EnumFacing.SOUTH)
                .where('X', MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.STEEL_SOLID))
                .where(' ', Blocks.AIR.getDefaultState())
                .where('E', MetaTileEntities.ENERGY_INPUT_HATCH[GTValues.MV], EnumFacing.NORTH)
                .where('I', MetaTileEntities.ITEM_IMPORT_BUS[GTValues.LV], EnumFacing.SOUTH)
                .where('O', MetaTileEntities.ITEM_EXPORT_BUS[GTValues.LV], EnumFacing.SOUTH)
                .where('L', MetaTileEntities.FLUID_IMPORT_HATCH[GTValues.LV], EnumFacing.WEST)
                .where('D', MetaTileEntities.FLUID_EXPORT_HATCH[GTValues.LV], EnumFacing.EAST)
                .where('H', MetaTileEntities.MUFFLER_HATCH[GTValues.LV], EnumFacing.UP)
                .where('M', () -> ConfigHolder.machines.enableMaintenance ? MetaTileEntities.MAINTENANCE_HATCH : MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.INVAR_HEATPROOF), EnumFacing.NORTH);
        Arrays.stream(BlockFireboxCasing.FireboxCasingType.values()).forEach(casingType -> shapeInfo.add(builder.where('F', MetaBlocks.BOILER_FIREBOX_CASING.getState(casingType)).build()));
        return shapeInfo;
    }
}
