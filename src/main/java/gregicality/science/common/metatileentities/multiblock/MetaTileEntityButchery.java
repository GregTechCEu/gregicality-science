package gregicality.science.common.metatileentities.multiblock;

import gregicality.multiblocks.common.block.GCYMMetaBlocks;
import gregicality.multiblocks.common.block.blocks.BlockUniqueCasing;
import gregicality.science.api.recipes.GCYSRecipeMaps;
import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.MetaTileEntityHolder;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.blocks.MetaBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class MetaTileEntityButchery extends RecipeMapMultiblockController{

    public MetaTileEntityButchery(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, GCYSRecipeMaps.BUTCHERY_RECIPES);
        this.recipeMapWorkable = new MultiblockRecipeLogic(this);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(MetaTileEntityHolder holder) {
        return new MetaTileEntityButchery(metaTileEntityId);
    }

    @Override
    public BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("XXXXX", "XXXXX", "XXXXX", "XXXXX")
                .aisle("XXXXX", "XBBBX", "XCCCX", "XXXXX")
                .aisle("XXXXX", "XBBBX", "XCCCX", "XXXXX")
                .aisle("XXXXX", "XBBBX", "XCCCX", "XXXXX")
                .aisle("XXXXX", "XBBBX", "XCCCX", "XXXXX")
                .aisle("XXXXX", "XBBBX", "XCCCX", "XXXXX")
                .aisle("XXSXX", "XXXXX", "XXXXX", "XXXXX")
                .where('S', selfPredicate())
                .where('X', states(getCasingState()).setMinGlobalLimited(80).or(autoAbilities()))
                .where(' ', air())
                .where('B', states(getBladeState()))
                .where('C', states(getCrushingWheelState()))
                .build();
    }

    private static IBlockState getCasingState() {
        return MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.STAINLESS_CLEAN);
    }

    private static IBlockState getBladeState() {
        return GCYMMetaBlocks.UNIQUE_CASING.getState(BlockUniqueCasing.UniqueCasingType.SLICING_BLADES);
    }

    private static IBlockState getCrushingWheelState() {
        return GCYMMetaBlocks.UNIQUE_CASING.getState(BlockUniqueCasing.UniqueCasingType.CRUSHING_WHEELS);
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return Textures.CLEAN_STAINLESS_STEEL_CASING;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(I18n.format("gregtech.machine.perfect_oc"));
    }

}
