package gregicality.science.common.metatileentities.multiblock;

import gregicality.science.api.recipes.GCYSRecipeMaps;
import gregicality.science.client.render.GCYSTextures;
import gregicality.science.common.block.GCYSMetaBlocks;
import gregicality.science.common.block.blocks.BlockMultiblockCasing;
import gregicality.science.common.metatileentities.GCYSMetaTileEntities;
import gregtech.api.GTValues;
import gregtech.api.capability.IHeatingCoil;
import gregtech.api.capability.impl.HeatingCoilRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.MetaTileEntityHolder;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.MultiblockShapeInfo;
import gregtech.api.pattern.PatternMatchContext;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.recipeproperties.TemperatureProperty;
import gregtech.api.unification.material.Materials;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.cube.OrientedOverlayRenderer;
import gregtech.common.ConfigHolder;
import gregtech.common.blocks.BlockWireCoil;
import gregtech.common.blocks.BlockWireCoil.CoilType;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.metatileentities.MetaTileEntities;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static gregtech.api.unification.material.Materials.StainlessSteel;

public class MetaTileEntityCrystallizer extends RecipeMapMultiblockController implements IHeatingCoil{

    private int crystallizerTemperature;

    public MetaTileEntityCrystallizer(ResourceLocation metaTileEntityId){
        super(metaTileEntityId, GCYSRecipeMaps.CRYSTALLIZER_RECIPES);
        this.recipeMapWorkable = new HeatingCoilRecipeLogic(this);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(MetaTileEntityHolder holder){
        return new MetaTileEntityCrystallizer(metaTileEntityId);
    }

    @Override
    protected void addDisplayText(List<ITextComponent> textList) {
        if (isStructureFormed()) {
            textList.add(new TextComponentTranslation("gregtech.multiblock.crystallizer.max_temperature",
                    new TextComponentTranslation(GTUtility.formatNumbers(crystallizerTemperature) + "K").setStyle(new Style().setColor(TextFormatting.RED))));
        }
        super.addDisplayText(textList);
    }

    @Override
    protected void formStructure(PatternMatchContext context) {
        super.formStructure(context);
        Object type = context.get("CoilType");
        if (type instanceof CoilType)
            this.crystallizerTemperature = ((CoilType) type).getCoilTemperature();
        else
            this.crystallizerTemperature = CoilType.CUPRONICKEL.getCoilTemperature();

        this.crystallizerTemperature += 100 * Math.max(0, GTUtility.getTierByVoltage(getEnergyContainer().getInputVoltage()) - GTValues.MV);
    }

    @Override
    public void invalidateStructure() {
        super.invalidateStructure();
        this.crystallizerTemperature = 0;
    }

    @Override
    public boolean checkRecipe(@Nonnull Recipe recipe, boolean consumeIfSuccess) {
        return this.crystallizerTemperature >= recipe.getProperty(TemperatureProperty.getInstance(), 0);
    }

    private IBlockState getCasingState() {
        return GCYSMetaBlocks.MULTIBLOCK_CASING.getState(BlockMultiblockCasing.CasingType.CRYSTALLIZER_CASING);
    }

    private IBlockState getFrameState(){
        return MetaBlocks.FRAMES.get(StainlessSteel).getBlock(StainlessSteel);
    }

    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("XXXXX", "G###G", "G###G", "XXXXX")
                .aisle("XXXXX", "#CCC#", "#CCC#", "XXXXX")
                .aisle("XXXXX", "#CCC#", "#CCC#", "XXMXX")
                .aisle("XXXXX", "#CCC#", "#CCC#", "XXXXX")
                .aisle("XXSXX", "G###G", "G###G", "XXXXX")
                .where('S', selfPredicate())
                .where('X', states(getCasingState()).setMinGlobalLimited(9).or(autoAbilities(true, true, true, true, true, false, false)))
                .where('C', heatingCoils())
                .where('M', abilities(MultiblockAbility.MUFFLER_HATCH))
                .where('G', states(getFrameState()))
                .where('A', air())
                .where('#', any())
                .build();
    }

    @Override
    public List<MultiblockShapeInfo> getMatchingShapes() {
        ArrayList<MultiblockShapeInfo> shapeInfo = new ArrayList<>();
        MultiblockShapeInfo.Builder builder = MultiblockShapeInfo.builder()
                .aisle("XXEXX", "G###G", "G###G", "XXXXX")
                .aisle("XXXXX", "#CCC#", "#CCC#", "XXXXX")
                .aisle("FXXXH", "#CCC#", "#CCC#", "XXMXX")
                .aisle("XXXXX", "#CCC#", "#CCC#", "XXXXX")
                .aisle("XISOX", "G###G", "G###G", "XXXXX")
                .where('S', GCYSMetaTileEntities.CRYSTALLIZER, EnumFacing.SOUTH)
                .where('X', getCasingState())
                .where('M', MetaTileEntities.MUFFLER_HATCH[GTValues.HV], EnumFacing.UP)
                .where('I', MetaTileEntities.ITEM_IMPORT_BUS[GTValues.HV], EnumFacing.SOUTH)
                .where('F', MetaTileEntities.FLUID_IMPORT_HATCH[GTValues.HV], EnumFacing.WEST)
                .where('O', MetaTileEntities.ITEM_EXPORT_BUS[GTValues.HV], EnumFacing.SOUTH)
                .where('E', MetaTileEntities.ENERGY_INPUT_HATCH[GTValues.EV], EnumFacing.NORTH)
                .where('G', getFrameState())
                .where('H', () -> ConfigHolder.machines.enableMaintenance ? MetaTileEntities.MAINTENANCE_HATCH : getCasingState(), EnumFacing.EAST)
                .where('#', Blocks.AIR.getDefaultState());


        Arrays.stream(BlockWireCoil.CoilType.values())
                .sorted(Comparator.comparingInt(BlockWireCoil.CoilType::getLevel))
                .forEach(coilType -> shapeInfo.add(builder.where('C', MetaBlocks.WIRE_COIL.getState(coilType)).build()));
        return shapeInfo;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(I18n.format("gregtech.machine.crystallizer.tooltip.1"));
        tooltip.add(I18n.format("gregtech.machine.crystallizer.tooltip.2"));
        tooltip.add(I18n.format("gregtech.machine.crystallizer.tooltip.3"));
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GCYSTextures.CRYSTALLIZER_CASING;
    }

    @Nonnull
    @Override
    protected OrientedOverlayRenderer getFrontOverlay() {
        return GCYSTextures.CRYSTALLIZER_OVERLAY;
    }

    @Override
    public boolean hasMufflerMechanics() {
        return true;
    }

    @Override
    public boolean canBeDistinct() {
        return true;
    }

    @Override
    public int getCurrentTemperature() {
        return this.crystallizerTemperature;
    }

}
