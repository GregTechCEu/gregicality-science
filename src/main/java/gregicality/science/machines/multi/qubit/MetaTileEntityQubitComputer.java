package gregicality.science.machines.multi.qubit;

import gregicality.science.capabilities.GregicalityCapabilities;
import gregicality.science.capabilities.impl.QubitProducerRecipeLogic;
import gregicality.science.client.ClientHandler;
import gregicality.science.item.GAMetaBlocks;
import gregicality.science.item.GAQuantumCasing;
import gregicality.science.recipes.GARecipeMaps;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.MetaTileEntityHolder;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.multiblock.BlockPattern;
import gregtech.api.multiblock.FactoryBlockPattern;
import gregtech.api.render.ICubeRenderer;
import gregtech.api.render.OrientedOverlayRenderer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;

public class MetaTileEntityQubitComputer extends QubitRecipeMapMultiblockController {

    private static final MultiblockAbility<?>[] ALLOWED_ABILITIES = {MultiblockAbility.INPUT_ENERGY, MultiblockAbility.IMPORT_ITEMS, GregicalityCapabilities.OUTPUT_QBIT, MultiblockAbility.MAINTENANCE_HATCH};


    public MetaTileEntityQubitComputer(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, GARecipeMaps.SIMPLE_QUBIT_GENERATOR);
        this.recipeMapWorkable = new QubitProducerRecipeLogic(this);
    }

    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("CCCC", "CCCC", "CCCC")
                .aisle("CCCC", "CSCC", "CCCC")
                .where('S', selfPredicate())
                .where('C', statePredicate(getCasingState()).or(abilityPartPredicate(ALLOWED_ABILITIES)))
                .build();
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return ClientHandler.QUANTUM_COMPUTER;
    }

    protected IBlockState getCasingState() {
        return GAMetaBlocks.QUANTUM_CASING.getState(GAQuantumCasing.CasingType.COMPUTER);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(MetaTileEntityHolder metaTileEntityHolder) {
        return new MetaTileEntityQubitComputer(metaTileEntityId);
    }

    @Nonnull
    @Override
    protected OrientedOverlayRenderer getFrontOverlay() {
        return ClientHandler.QUBIT_COMPUTER_OVERLAY;
    }
}
