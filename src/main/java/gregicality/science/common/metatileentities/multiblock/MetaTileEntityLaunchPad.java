package gregicality.science.common.metatileentities.multiblock;

import gregicality.multiblocks.api.render.GCYMTextures;
import gregicality.science.api.recipes.GCYSRecipeMaps;
import gregicality.science.client.render.GCYSTextures;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.client.renderer.ICubeRenderer;
import net.minecraft.util.ResourceLocation;

public class MetaTileEntityLaunchPad extends RecipeMapMultiblockController {

    public MetaTileEntityLaunchPad(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, GCYSRecipeMaps.LAUNCHPAD_RECIPES);
        //TODO: Add handler
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity metaTileEntityHolder) {
        return new MetaTileEntityLaunchPad(metaTileEntityId);
    }

    @Override
    public BlockPattern createStructurePattern(){
        return FactoryBlockPattern.start().build();
        //TODO: Create pattern
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GCYSTextures.LAUNCHPAD_OVERLAY;
    }
}
