package gregicality.science.common.metatileentities.multiblock;

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
import gregtech.common.blocks.BlockGlassCasing;
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.blocks.MetaBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

import static gregtech.api.unification.material.Materials.StainlessSteel;

public class MetaTileEntityGreenhouse extends RecipeMapMultiblockController{

    public MetaTileEntityGreenhouse(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, GCYSRecipeMaps.GREENHOUSE_RECIPES);
        this.recipeMapWorkable = new MultiblockRecipeLogic(this);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(MetaTileEntityHolder holder) {
        return new MetaTileEntityGreenhouse(metaTileEntityId);
    }

    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle(" XXXXXXXXX ", " XXXXXXXXX ", " XXXXXXXXX ", " XXXXXXXXX ", " XXXXXXXXX ", " XXXXXXXXX ", " XXXXXXXXX ", " XXXXXXXXX ", " XXXXXXXXX ")
                .aisle("FXXXXXXXXXF", "FX       XF", "FX       XF", "FX       XF", "FX       XF", "FX       XF", " X       X ", " X       X ", " XGGGGGGGX ")
                .aisle(" XXXXXXXXX ", " X       X ", " X       X ", " X       X ", " X       X ", " X       X ", " X       X ", " X       X ", " XGGGGGGGX ")
                .aisle("FXXXXXXXXXF", "FX       XF", "FX       XF", "FX       XF", "FX       XF", "FX       XF", " X       X ", " X       X ", " XGGGGGGGX ")
                .aisle(" XXXXXXXXX ", " X       X ", " X       X ", " X       X ", " X       X ", " X       X ", " X       X ", " X       X ", " XGGGGGGGX ")
                .aisle("FXXXXXXXXXF", "FX       XF", "FX       XF", "FX       XF", "FX       XF", "FX       XF", " X       X ", " X       X ", " XGGGGGGGX ")
                .aisle(" XXXXXXXXX ", " X       X ", " X       X ", " X       X ", " X       X ", " X       X ", " X       X ", " X       X ", " XGGGGGGGX ")
                .aisle("FXXXXXXXXXF", "FX       XF", "FX       XF", "FX       XF", "FX       XF", "FX       XF", " X       X ", " X       X ", " XGGGGGGGX ")
                .aisle(" XXXXXXXXX ", " X       X ", " X       X ", " X       X ", " X       X ", " X       X ", " X       X ", " X       X ", " XGGGGGGGX ")
                .aisle("FXXXXXXXXXF", "FX       XF", "FX       XF", "FX       XF", "FX       XF", "FX       XF", " X       X ", " X       X ", " XGGGGGGGX ")
                .aisle(" XXXXXXXXX ", " X       X ", " X       X ", " X       X ", " X       X ", " X       X ", " X       X ", " X       X ", " XGGGGGGGX ")
                .aisle("FXXXXXXXXXF", "FX       XF", "FX       XF", "FX       XF", "FX       XF", "FX       XF", " X       X ", " X       X ", " XGGGGGGGX ")
                .aisle(" XXXXXXXXX ", " X       X ", " X       X ", " X       X ", " X       X ", " X       X ", " X       X ", " X       X ", " XGGGGGGGX ")
                .aisle("FXXXXXXXXXF", "FX       XF", "FX       XF", "FX       XF", "FX       XF", "FX       XF", " X       X ", " X       X ", " XGGGGGGGX ")
                .aisle(" XXXXSXXXX ", " XXXXXXXXX ", " XXXXXXXXX ", " XXXXXXXXX ", " XXXXXXXXX ", " XXXXXXXXX ", " XXXXXXXXX ", " XXXXXXXXX ", " XXXXXXXXX ")
                .where('S', selfPredicate())
                .where('X', states(getCasingState()).setMinGlobalLimited(470).or(autoAbilities()))
                .where('G', states(getGlassState()))
                .where('F', states(getFrameState()))
                .where(' ', any())
                .build();
    }

    private static IBlockState getCasingState() {
        return MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.PTFE_INERT_CASING);
    }

    private static IBlockState getGlassState() {
        return MetaBlocks.TRANSPARENT_CASING.getState(BlockGlassCasing.CasingType.TEMPERED_GLASS);
    }

    @Nonnull
    private static IBlockState getFrameState() {
        return MetaBlocks.FRAMES.get(StainlessSteel).getBlock(StainlessSteel);
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return Textures.INERT_PTFE_CASING;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(I18n.format("gregtech.machine.perfect_oc"));
    }

}
