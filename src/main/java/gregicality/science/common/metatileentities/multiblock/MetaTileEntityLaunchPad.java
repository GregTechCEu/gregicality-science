package gregicality.science.common.metatileentities.multiblock;

import gregicality.multiblocks.api.unification.GCYMMaterials;
import gregicality.science.api.recipes.GCYSRecipeMaps;
import gregicality.science.common.block.GCYSMetaBlocks;
import gregicality.science.common.block.blocks.BlockMultiblockCasing;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.blocks.BlockStoneSmooth;
import gregtech.common.blocks.MetaBlocks;
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
        return FactoryBlockPattern.start()
                .aisle("   CCC   ", "  CAAAC  ", "  CAAAC  ", "  C   C  ", "   CCC   ", "   III   ", "   PPP   ", "   PPP   ", "   III   ", "   B B   ", "   B B   ", "   B B   ", "   B B   ", "   B B   ", "   III   ", "   B B   ", "   B B   ", "   B B   ", "   B B   ", "   B B   ", "   III   ", "   B B   ", "   B B   ", "   B B   ", "   B B   ", "   B B   ", "   III   ", "   B B   ", "   B B   ", "   B B   ", "   B B   ", "   B B   ", "   III   ", "         ", "         ", "         ")
                .aisle("   CCC   ", " CCAAACC ", " CCAAACC ", " CCCCCCC ", "  BCCCB  ", "  BPBPB  ", "  BPBPB  ", "  BPBPB  ", "  BPBPB  ", "  BPTPB  ", "  BPTPB  ", "  BPTPB  ", "  BPBPB  ", "  BPBPB  ", "  BPBPB  ", "  BPTPB  ", "  BPTPB  ", "  BPTPB  ", "  BPBPB  ", "  BPBPB  ", "  BPBPB  ", "  BPTPB  ", "  BPTPB  ", "  BPTPB  ", "  BPBPB  ", "  BPBPB  ", "  BPBPB  ", "  BPTPB  ", "  BPTPB  ", "  BPTPB  ", "  BPBPB  ", "  BPBPB  ", "  BPBPB  ", "  BPBPB  ", "  BPBPB  ", "  IIIII  ")
                .aisle("   CCC   ", " CCAAACC ", " CCAAACC ", " CCCCCCC ", "  IIIII  ", "  FABAF  ", "  FABAF  ", "  FABAF  ", "  FABAF  ", "  FATAF  ", "  FATAF  ", "  FATAF  ", "  FABAF  ", "  FABAF  ", "  FABAF  ", "  FATAF  ", "  FATAF  ", "  FATAF  ", "  FABAF  ", "  FABAF  ", "  FABAF  ", "  FATAF  ", "  FATAF  ", "  FATAF  ", "  FABAF  ", "  FABAF  ", "  FABAF  ", "  FATAF  ", "  FATAF  ", "  FATAF  ", "  FABAF  ", "  FABAF  ", "  FABAF  ", "  FABAF  ", "  FABAF  ", "    I    ")
                .aisle("   CCC   ", "CCCAAACCC", "CCCAAACCC", " CCCCCCC ", "  CCCCC  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ")
                .aisle("CCCCCCCCC", "AAAAAAAAA", "AAAAAAAAA", "CCCAAACCC", " CCFFFCC ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ")
                .aisle("CCCCCCCCC", "AAAAAAAAA", "AAAAAAAAA", "CCCAAACCC", " CCFFFCC ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ")
                .aisle("CCCCCCCCC", "AAAAAAAAA", "AAAAAAAAA", "CCCAAACCC", " CCFFFCC ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ")
                .aisle("   CCC   ", "CCCAAACCC", "CCCAAACCC", " CCCCCCC ", "  CCCCC  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ", "  AAAAA  ")
                .aisle("   CCC   ", " CCAAACC ", " CCAAACC ", " CCCCCCC ", "  IIIII  ", "  FABAF  ", "  FABAF  ", "  FABAF  ", "  FABAF  ", "  FATAF  ", "  FATAF  ", "  FATAF  ", "  FABAF  ", "  FABAF  ", "  FABAF  ", "  FATAF  ", "  FATAF  ", "  FATAF  ", "  FABAF  ", "  FABAF  ", "  FABAF  ", "  FATAF  ", "  FATAF  ", "  FATAF  ", "  FABAF  ", "  FABAF  ", "  FABAF  ", "  FATAF  ", "  FATAF  ", "  FATAF  ", "  FABAF  ", "  FABAF  ", "  FABAF  ", "  FABAF  ", "  FABAF  ", "    I    ")
                .aisle("   CCC   ", " CCAAACC ", " CCAAACC ", " CCCCCCC ", "  BCCCB  ", "  BPBPB  ", "  BPBPB  ", "  BPBPB  ", "  BPBPB  ", "  BPTPB  ", "  BPTPB  ", "  BPTPB  ", "  BPBPB  ", "  BPBPB  ", "  BPBPB  ", "  BPTPB  ", "  BPTPB  ", "  BPTPB  ", "  BPBPB  ", "  BPBPB  ", "  BPBPB  ", "  BPTPB  ", "  BPTPB  ", "  BPTPB  ", "  BPBPB  ", "  BPBPB  ", "  BPBPB  ", "  BPTPB  ", "  BPTPB  ", "  BPTPB  ", "  BPBPB  ", "  BPBPB  ", "  BPBPB  ", "  BPBPB  ", "  BPBPB  ", "  IIIII  ")
                .aisle("   CCC   ", "  CAAAC  ", "  CAAAC  ", "  C   C  ", "   CCC   ", "   ISI   ", "   PPP   ", "   PPP   ", "   III   ", "   B B   ", "   B B   ", "   B B   ", "   B B   ", "   B B   ", "   III   ", "   B B   ", "   B B   ", "   B B   ", "   B B   ", "   B B   ", "   III   ", "   B B   ", "   B B   ", "   B B   ", "   B B   ", "   B B   ", "   III   ", "   B B   ", "   B B   ", "   B B   ", "   B B   ", "   B B   ", "   III   ", "         ", "         ", "         ")
                .where('S', selfPredicate())
                .where('C', states(MetaBlocks.STONE_SMOOTH.getState(BlockStoneSmooth.BlockType.CONCRETE_LIGHT)).or(states(MetaBlocks.STONE_SMOOTH.getState(BlockStoneSmooth.BlockType.CONCRETE_DARK))))
                .where('A', air())
                .where('F', states(MetaBlocks.FRAMES.get(GCYMMaterials.HSLASteel).getBlock(GCYMMaterials.HSLASteel)))
                .where('I', states(MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.STEEL_SOLID)))
                .where('B', states(GCYSMetaBlocks.MULTIBLOCK_CASING.getState(BlockMultiblockCasing.CasingType.STRUCTURAL_BEAM)))
                .where('T', states(GCYSMetaBlocks.MULTIBLOCK_CASING.getState(BlockMultiblockCasing.CasingType.TOWER_INSTRUMENTS)))
                .where('P', states(GCYSMetaBlocks.MULTIBLOCK_CASING.getState(BlockMultiblockCasing.CasingType.TOWER_PIPING)))
                .where(' ', any())
                .build();
        //TODO: Create pattern
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return Textures.SOLID_STEEL_CASING;
    }
}
