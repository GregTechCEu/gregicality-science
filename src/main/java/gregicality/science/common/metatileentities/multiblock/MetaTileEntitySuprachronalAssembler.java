package gregicality.science.common.metatileentities.multiblock;

import gregicality.science.api.recipes.GCYSRecipeMaps;
import gregicality.science.client.render.GCYSTextures;
import gregicality.science.common.block.GCYSMetaBlocks;
import gregicality.science.common.block.blocks.BlockGCYSMultiblockCasing;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.client.renderer.ICubeRenderer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;

public class MetaTileEntitySuprachronalAssembler extends RecipeMapMultiblockController {


    public MetaTileEntitySuprachronalAssembler(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, GCYSRecipeMaps.SUPRACHRONAL_ASSEMBLER_RECIPES);
    }

    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("##XXXXDDDXXXX##", "######DDD######", "###############", "###############", "###############", "###############", "###############", "###############", "###############", "###############", "###############", "###############", "###############", "######DDD######", "##XXXXDDDXXXX##")
                .aisle("#XXXXXXXXXXXXX#", "#######X#######", "#######X#######", "#######X#######", "#######X#######", "#######X#######", "#######X#######", "#######X#######", "#######X#######", "#######X#######", "#######X#######", "#######X#######", "#######X#######", "#######X#######", "#XXXXXXXXXXXXX#")
                .aisle("XXXXXXXXXXXXXXX", "#######X#######", "#######X#######", "#######X#######", "#######X#######", "######XXX######", "#####XXXXX#####", "#####XXXXX#####", "#####XXXXX#####", "######XXX######", "#######X#######", "#######X#######", "#######X#######", "#######X#######", "XXXXXXXXXXXXXXX")
                .aisle("XXXXXXXXXXXXXXX", "#######X#######", "#######X#######", "#######X#######", "#####XXXXX#####", "####XXAAAXX####", "####XAAAAAX####", "####XAAAAAX####", "####XAAAAAX####", "####XXAAAXX####", "#####XXXXX#####", "#######X#######", "#######X#######", "#######X#######", "XXXXXXXXXXXXXXX")
                .aisle("XXXXXXXXXXXXXXX", "#######X#######", "#######X#######", "#####XXXXX#####", "####XAAAAAX####", "###XAAAAAAAX###", "###XAAAAAAAX###", "###XAAAAAAAX###", "###XAAAAAAAX###", "###XAAAAAAAX###", "####XAAAAAX####", "#####XXXXX#####", "#######X#######", "#######X#######", "XXXXXXXXXXXXXXX")
                .aisle("XXXXXXXXXXXXXXX", "#######X#######", "######XXX######", "####XXAAAXX####", "###XAAAAAAAX###", "###XAAAAAAAX###", "##XAAAAAAAAAX##", "##XAAAAAAAAAX##", "##XAAAAAAAAAX##", "###XAAAAAAAX###", "###XAAAAAAAX###", "####XXAAAXX####", "######XXX######", "#######X#######", "XXXXXXXXXXXXXXX")
                .aisle("DXXXXXXXXXXXXXD", "D#####XXX#####D", "#####XXXXX#####", "####XAAAAAX####", "###XAAAAAAAX###", "##XAAAAAAAAAX##", "##XAAAAAAAAAX##", "##XAAAAAAAAAX##", "##XAAAAAAAAAX##", "##XAAAAAAAAAX##", "###XAAAAAAAX###", "####XAAAAAX####", "#####XXXXX#####", "D#####XXX#####D", "DXXXXXXXXXXXXXD")
                .aisle("DXXXXXXXXXXXXXD", "DXXXXXXXXXXXXXD", "#XXXXXXXXXXXXX#", "#XXXXAAAAAXXXX#", "#XXXAAAAAAAXXX#", "#XXAAAAAAAAAXX#", "#XXAAAAAAAAAXX#", "#XXAAAAAAAAAXX#", "#XXAAAAAAAAAXX#", "#XXAAAAAAAAAXX#", "#XXXAAAAAAAXXX#", "#XXXXAAAAAXXXX#", "#XXXXXXXXXXXXX#", "DXXXXXXXXXXXXXD", "DXXXXXXXXXXXXXD")
                .aisle("DXXXXXXXXXXXXXD", "D#####XXX#####D", "#####XXXXX#####", "####XAAAAAX####", "###XAAAAAAAX###", "##XAAAAAAAAAX##", "##XAAAAAAAAAX##", "##XAAAAAAAAAX##", "##XAAAAAAAAAX##", "##XAAAAAAAAAX##", "###XAAAAAAAX###", "####XAAAAAX####", "#####XXXXX#####", "D#####XXX#####D", "DXXXXXXXXXXXXXD")
                .aisle("XXXXXXXXXXXXXXX", "#######X#######", "######XXX######", "####XXAAAXX####", "###XAAAAAAAX###", "###XAAAAAAAX###", "##XAAAAAAAAAX##", "##XAAAAAAAAAX##", "##XAAAAAAAAAX##", "###XAAAAAAAX###", "###XAAAAAAAX###", "####XXAAAXX####", "######XXX######", "#######X#######", "XXXXXXXXXXXXXXX")
                .aisle("XXXXXXXXXXXXXXX", "#######X#######", "#######X#######", "#####XXXXX#####", "####XAAAAAX####", "###XAAAAAAAX###", "###XAAAAAAAX###", "###XAAAAAAAX###", "###XAAAAAAAX###", "###XAAAAAAAX###", "####XAAAAAX####", "#####XXXXX#####", "#######X#######", "#######X#######", "XXXXXXXXXXXXXXX")
                .aisle("XXXXXXXXXXXXXXX", "#######X#######", "#######X#######", "#######X#######", "#####XXXXX#####", "####XXAAAXX####", "####XAAAAAX####", "####XAAAAAX####", "####XAAAAAX####", "####XXAAAXX####", "#####XXXXX#####", "#######X#######", "#######X#######", "#######X#######", "XXXXXXXXXXXXXXX")
                .aisle("XXXXXXXXXXXXXXX", "#######X#######", "#######X#######", "#######X#######", "#######X#######", "######XXX######", "#####XXXXX#####", "#####XXXXX#####", "#####XXXXX#####", "######XXX######", "#######X#######", "#######X#######", "#######X#######", "#######X#######", "XXXXXXXXXXXXXXX")
                .aisle("#XXXXXXXXXXXXX#", "#######X#######", "#######X#######", "#######X#######", "#######X#######", "#######X#######", "#######X#######", "#######X#######", "#######X#######", "#######X#######", "#######X#######", "#######X#######", "#######X#######", "#######X#######", "#XXXXXXXXXXXXX#")
                .aisle("##XXXXDDDXXXX##", "######DSD######", "###############", "###############", "###############", "###############", "###############", "###############", "###############", "###############", "###############", "###############", "###############", "######DDD######", "##XXXXDDDXXXX##")
                .where('S', selfPredicate())
                .where('X', states(getCasingState()))
                .where('D', states(getCasingState()).or(
                        autoAbilities(true, true, true, true, true, false, false)
                ))
                .where('C', heatingCoils())
                .where('M', abilities(MultiblockAbility.MUFFLER_HATCH))
                .where('A', air())
                .where('#', any())
                .build();
    }

    @Nonnull
    private static IBlockState getCasingState() {
        return GCYSMetaBlocks.MULTIBLOCK_CASING.getState(BlockGCYSMultiblockCasing.CasingType.SUPRACHRONAL_CASING);
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GCYSTextures.SUPRACHRONAL_CASING;
    }

    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return GCYSTextures.SUPRACHRONAL_OVERLAY;
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new MetaTileEntitySuprachronalAssembler(metaTileEntityId);
    }
}
