package gregicality.science.common.metatileentities.multiblock;

import gregicality.multiblocks.api.unification.GCYMMaterials;
import gregicality.multiblocks.common.block.GCYMMetaBlocks;
import gregicality.multiblocks.common.block.blocks.BlockLargeMultiblockCasing;
import gregicality.science.api.recipes.GCYSRecipeMaps;
import gregicality.science.client.render.GCYSTextures;
import gregicality.science.common.block.GCYSMetaBlocks;
import gregicality.science.common.block.blocks.BlockGCYSMultiblockCasing;
import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.capability.impl.NotifiableItemStackHandler;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.PatternMatchContext;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.recipes.Recipe;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.blocks.BlockMultiblockCasing;
import gregtech.common.blocks.BlockTurbineCasing;
import gregtech.common.blocks.MetaBlocks;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.IItemHandlerModifiable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class MetaTileEntityIndustrialDrill extends RecipeMapMultiblockController {

    protected BlockPos targetBlock = null;

    public MetaTileEntityIndustrialDrill(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, GCYSRecipeMaps.DRILLING_RECIPES);
        this.recipeMapWorkable = new IndustrialDrillWorkableHandler(this);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new MetaTileEntityIndustrialDrill(metaTileEntityId);
    }

    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("       ", "XXXXXXX", "X     X", "X     X", "X     X", "X     X", "X     X", "XXXXXXX")
                .aisle("       ", "X     X", "       ", " F   F ", "       ", "       ", "       ", "X  F  X")
                .aisle("       ", "X     X", "   C   ", "  FCF  ", "   C   ", "  CVC  ", "  CVC  ", "X BBB X")
                .aisle("   R   ", "X  D  X", "  CGC  ", "  CGC  ", "  CGC  ", "  VGV  ", "  VGV  ", "XFBBBFX")
                .aisle("       ", "X     X", "   C   ", "  FCF  ", "   C   ", "  CSC  ", "  CVC  ", "X BBB X")
                .aisle("       ", "X     X", "       ", " F   F ", "       ", "       ", "       ", "X  F  X")
                .aisle("       ", "XXXXXXX", "X     X", "X     X", "X     X", "X     X", "X     X", "XXXXXXX")
                .where('S', selfPredicate())
                .where('X', states(GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getState(BlockLargeMultiblockCasing.CasingType.ATOMIC_CASING)))
                .where('F', states(MetaBlocks.FRAMES.get(GCYMMaterials.HSLASteel).getBlock(GCYMMaterials.HSLASteel)))
                .where('C', states(MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.STEEL_SOLID)))
                .where('G', states(MetaBlocks.TURBINE_CASING.getState(BlockTurbineCasing.TurbineCasingType.TUNGSTENSTEEL_GEARBOX)))
                .where('V', states(MetaBlocks.MULTIBLOCK_CASING.getState(BlockMultiblockCasing.MultiblockCasingType.GRATE_CASING)))
                .where('B', states(MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.STEEL_SOLID))
                        .setMinGlobalLimited(4)
                        .or(autoAbilities(true, true, false, true, true, true, true)))
                .where('D', states(GCYSMetaBlocks.MULTIBLOCK_CASING.getState(BlockGCYSMultiblockCasing.CasingType.DRILL_HEAD)))
                .where('R', bedrockPredicate())
                .where(' ', any())
                .build();
    }

    @Nonnull
    protected TraceabilityPredicate bedrockPredicate() {
        return new TraceabilityPredicate(blockWorldState -> {
            this.targetBlock = blockWorldState.getPos();
            if (this.isStructureFormed()) {
                this.inputInventory.setStackInSlot(0, GTUtility.toItem(getWorld().getBlockState(targetBlock)));
            }
            return true;
        });
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return Textures.SOLID_STEEL_CASING;
    }

    @Override
    protected void initializeAbilities() {
        super.initializeAbilities();
        this.inputInventory = new NotifiableItemStackHandler(1, this, false);
    }

    @Override
    protected void formStructure(PatternMatchContext context) {
        super.formStructure(context);
        if (this.targetBlock != null) {
            this.inputInventory.setStackInSlot(0, GTUtility.toItem(getWorld().getBlockState(targetBlock)));
        }
    }

    @Override
    public void invalidateStructure() {
        this.inputInventory.setStackInSlot(0, ItemStack.EMPTY);
        this.targetBlock = null;
        super.invalidateStructure();
    }

    @Override
    public boolean canBeDistinct() {
        return false;
    }

    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return GCYSTextures.INDUSTRIAL_DRILL_OVERLAY;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(I18n.format("gcys.multiblock.industrial_drill.tooltip.1"));
        tooltip.add(I18n.format("gcys.multiblock.industrial_drill.tooltip.2"));
    }

    protected static class IndustrialDrillWorkableHandler extends MultiblockRecipeLogic {

        public IndustrialDrillWorkableHandler(RecipeMapMultiblockController tileEntity) {
            super(tileEntity);
        }

        @Override
        public MetaTileEntityIndustrialDrill getMetaTileEntity() {
            return (MetaTileEntityIndustrialDrill) super.getMetaTileEntity();
        }

        @Override
        protected boolean setupAndConsumeRecipeInputs(Recipe recipe, IItemHandlerModifiable importInventory) {
            boolean result = super.setupAndConsumeRecipeInputs(recipe, importInventory);

            // break the block in world if it is consumable
            if (result && !recipe.getInputs().get(0).isNonConsumable()) {
                MetaTileEntityIndustrialDrill drill = getMetaTileEntity();
                if (drill != null) {
                    drill.getWorld().destroyBlock(drill.targetBlock, false);
                }
            }

            return result;
        }
    }
}
