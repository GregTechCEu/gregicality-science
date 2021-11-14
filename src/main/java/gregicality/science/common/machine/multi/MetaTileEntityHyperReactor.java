package gregicality.science.common.machine.multi;

import gregicality.science.client.GCYSciTextures;
import gregicality.science.common.GCYSciConfig;
import gregicality.science.common.block.GAMetaBlocks;
import gregicality.science.common.block.GAMultiblockCasing;
import gregicality.science.common.block.GAReactorCasing;
import gregicality.science.common.block.GATransparentCasing;
import gregicality.science.api.machines.GABoostableWorkableHandler;
import gregicality.science.loaders.recipes.GCYSciRecipeMaps;
import gregicality.science.api.GCYSciLog;
import gregtech.api.capability.impl.FuelRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.MetaTileEntityHolder;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.multiblock.BlockPattern;
import gregtech.api.multiblock.FactoryBlockPattern;
import gregtech.api.render.ICubeRenderer;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.metatileentities.multi.electric.generator.FueledMultiblockController;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.*;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import javax.annotation.Nullable;
import java.util.List;

public class MetaTileEntityHyperReactor extends FueledMultiblockController {

    private static final MultiblockAbility<?>[] ALLOWED_ABILITIES = {
            MultiblockAbility.OUTPUT_ENERGY, MultiblockAbility.IMPORT_FLUIDS, MultiblockAbility.MAINTENANCE_HATCH
    };

    private final int tier_internal;

    public MetaTileEntityHyperReactor(ResourceLocation metaTileEntityId, int tier) {
        super(metaTileEntityId, GCYSciRecipeMaps.HYPER_REACTOR_FUELS, GCYSciConfig.multis.hyperReactors.euGeneration[tier]);
        this.maxVoltage = GCYSciConfig.multis.hyperReactors.euGeneration[tier];
        Fluid temp = FluidRegistry.getFluid(GCYSciConfig.multis.hyperReactors.boosterFluid[tier]);
        if (temp == null) {
            Material m;
            if (tier == 1) m = Materials.Radon;
            else m = Materials.Helium;
            temp = m.getPlasma(0).getFluid();
            GCYSciLog.logger.warn("Incorrect fluid given to hyper reactor: " + GCYSciConfig.multis.hyperReactors.boosterFluid[tier]);
        }
        booster = new FluidStack(temp, GCYSciConfig.multis.hyperReactors.boosterFluidAmounts[tier]);

        this.tier_internal = tier;
    }

    long maxVoltage;
    FluidStack booster;

    @Override
    public MetaTileEntity createMetaTileEntity(MetaTileEntityHolder holder) {
        return new MetaTileEntityHyperReactor(metaTileEntityId, tier_internal);
    }

    @Override
    protected FuelRecipeLogic createWorkable(long maxVoltage) {
        int fuelMultiplier = GCYSciConfig.multis.hyperReactors.boostedFuelAmount[tier_internal];
        int euMultiplier = GCYSciConfig.multis.hyperReactors.boostedEuAmount[tier_internal];
        return new GABoostableWorkableHandler(this, recipeMap, () -> energyContainer, () -> importFluidHandler,
                maxVoltage, booster, fuelMultiplier, euMultiplier);
    }

    @Override
    protected void addDisplayText(List<ITextComponent> textList) {
        if (isStructureFormed()) {
            FluidStack booster = importFluidHandler.drain(this.booster, false);
            FluidStack fuelStack = ((GABoostableWorkableHandler) workableHandler).getFuelStack();
            boolean isBoosted = ((GABoostableWorkableHandler) workableHandler).isBoosted();
            int boosterAmount = booster == null ? 0 : booster.amount;
            int fuelAmount = fuelStack == null ? 0 : fuelStack.amount;

            if (fuelStack == null)
                textList.add(new TextComponentTranslation("gregtech.multiblock.large_rocket_engine.no_fuel").setStyle(new Style().setColor(TextFormatting.RED)));
            else
                textList.add(new TextComponentString(String.format("%s: %dmb", fuelStack.getLocalizedName(), fuelAmount)).setStyle(new Style().setColor(TextFormatting.GREEN)));

            if (isBoosted) {
                textList.add(new TextComponentTranslation("gregtech.multiblock.large_rocket_engine.boost").setStyle(new Style().setColor(TextFormatting.GREEN)));
                if (booster != null)
                    textList.add(new TextComponentString(String.format("%s: %dmb", booster.getLocalizedName(), boosterAmount)).setStyle(new Style().setColor(TextFormatting.AQUA)));
            }
        }
        super.addDisplayText(textList);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, boolean advanced) {
        // todo fix default fluids
        //tooltip.add(I18n.format("gtadditions.multiblock.hyper_reactor.tooltip.1", Objects.requireNonNull(FluidRegistry.getFluidStack(GCYSciConfig.multis.hyperReactors.boosterFluid[tier_internal], 1)).getLocalizedName()));
        tooltip.add(I18n.format("gtadditions.multiblock.hyper_reactor.tooltip.2", maxVoltage));
    }

    @Override
    protected BlockPattern createStructurePattern() {
        switch (tier_internal) {
            case 1: return hyperReactorIIStructure();
            case 2: return hyperReactorIIIStructure();
            default: return hyperReactorIStructure();
        }
    }

    private BlockPattern hyperReactorIStructure() {
        return FactoryBlockPattern.start()
                .aisle("CCCCC", "CGGGC", "CGGGC", "CGGGC", "CCCCC")
                .aisle("CCCCC", "G###G", "G#H#G", "G###G", "CCCCC")
                .aisle("CCCCC", "G#H#G", "GHHHG", "G#H#G", "CCCCC")
                .aisle("CCCCC", "G###G", "G#H#G", "G###G", "CCCCC")
                .aisle("CCSCC", "CGGGC", "CGGGC", "CGGGC", "CCCCC")
                .where('S', selfPredicate())
                .where('C', statePredicate(getCasingState()).or(abilityPartPredicate(ALLOWED_ABILITIES)))
                .where('T', statePredicate(GAMetaBlocks.MUTLIBLOCK_CASING.getState(GAMultiblockCasing.CasingType.TIERED_HULL_UV)))
                .where('G', statePredicate(GAMetaBlocks.TRANSPARENT_CASING.getState(GATransparentCasing.CasingType.OSMIRIDIUM_GLASS)))
                .where('H', statePredicate(GAMetaBlocks.REACTOR_CASING.getState(GAReactorCasing.CasingType.HYPER_CORE)))
                .where('#', isAirPredicate())
                .setAmountAtLeast('c', 55)
                .where('c', statePredicate(getCasingState()))
                .build();
    }

    private BlockPattern hyperReactorIIStructure() {
        return FactoryBlockPattern.start()
                .aisle("#######C#######", "#####CCCCC#####", "#######C#######")
                .aisle("####CCCCCCC####", "###CC#####CC###", "####CCCCCCC####")
                .aisle("###CCCCCCCCC###", "##C##CCCCC##C##", "###CCCCCCCCC###")
                .aisle("##CCC#####CCC##", "#C##C#####C##C#", "##CCC#####CCC##")
                .aisle("#CCC#######CCC#", "#C#C#######C#C#", "#CCC#######CCC#")
                .aisle("#CC#########CC#", "C#C#########C#C", "#CC#########CC#")
                .aisle("#CC####F####CC#", "C#C####H####C#C", "#CC#########CC#")
                .aisle("CCC###FHF###CCC", "C#C###HHH###C#C", "CCC####H####CCC")
                .aisle("#CC####F####CC#", "C#C####H####C#C", "#CC#########CC#")
                .aisle("#CC#########CC#", "C#C#########C#C", "#CC#########CC#")
                .aisle("#CCC#######CCC#", "#C#C#######C#C#", "#CCC#######CCC#")
                .aisle("##CCC#####CCC##", "#C##C#####C##C#", "##CCC#####CCC##")
                .aisle("###CCCCCCCCC###", "##C##CCCCC##C##", "###CCCCCCCCC###")
                .aisle("####CCCCCCC####", "###CC#####CC###", "####CCCCCCC####")
                .aisle("#######C#######", "#####CCSCC#####", "#######C#######")
                .where('C', statePredicate(getCasingState()).or(abilityPartPredicate(ALLOWED_ABILITIES)))
                .where('#', (tile) -> true)
                .where('S', selfPredicate())
                .where('F', statePredicate(MetaBlocks.FRAMES.get(Materials.Naquadria).getDefaultState()))
                .where('H', statePredicate(GAMetaBlocks.REACTOR_CASING.getState(GAReactorCasing.CasingType.HYPER_CORE_2)))
                .setAmountAtLeast('c', 220)
                .where('c', statePredicate(getCasingState()))
                .build();
    }

    private BlockPattern hyperReactorIIIStructure() {
        return FactoryBlockPattern.start()
                .aisle("###########","###########","###########","###########","###########", "###########", "###########", "###########", "####CCC####", "###CCCCC###", "###CCCCC###", "###CCCCC###", "####CCC####", "###########", "###########", "###########")
                .aisle("###########","###########","###########","###########","###########", "###########", "###########", "###CCCCC###", "##CC###CC##", "##C#####C##", "##C#####C##", "##C#####C##", "##CC###CC##", "###CCCCC###", "###########", "###########")
                .aisle("##F#####F##","##F#####F##","##F#####F##","##F#####F##","##F#####F##", "##F#####F##", "##FCCCCCF##", "##C#####C##", "#C#######C#", "#C#######C#", "#C#######C#", "#C#######C#", "#C#######C#", "##C#####C##", "###CCCCC###", "###########")
                .aisle("###F###F###","###F###F###","###F###F###","###F###F###","###F###F###", "###FCCCF###", "##CC###CC##", "#C#######C#", "#C#######C#", "C#########C", "C####H####C", "C#########C", "#C#######C#", "#C#######C#", "##CC###CC##", "####CCC####")
                .aisle("###########","###########","###########","###########","###########", "###CCCCC###", "##C#####C##", "#C#######C#", "C#########C", "G####H####G", "G###HHH###G", "G####H####G", "C#########C", "#C#######C#", "##C#####C##", "###CCCCC###")
                .aisle("###########","###########","###########","###########","###########", "###CCCCC###", "##C#####C##", "#C#######C#", "C####H####C", "G###HHH###G", "G##HHHHH##G", "G###HHH###G", "C####H####C", "#C#######C#", "##C#####C##", "###CCCCC###")
                .aisle("###########","###########","###########","###########","###########", "###CCCCC###", "##C#####C##", "#C#######C#", "C#########C", "G####H####G", "G###HHH###G", "G####H####G", "C#########C", "#C#######C#", "##C#####C##", "###CCCCC###")
                .aisle("###F###F###","###F###F###","###F###F###","###F###F###","###F###F###", "###FCCCF###", "##CC###CC##", "#C#######C#", "#C#######C#", "C#########C", "C####H####C", "C#########C", "#C#######C#", "#C#######C#", "##CC###CC##", "####CCC####")
                .aisle("##F#####F##","##F#####F##","##F#####F##","##F#####F##","##F#####F##", "##F#####F##", "##FCCCCCF##", "##C#####C##", "#C#######C#", "#C#######C#", "#C#######C#", "#C#######C#", "#C#######C#", "##C#####C##", "###CCCCC###", "###########")
                .aisle("###########","###########","###########","###########","###########", "###########", "###########", "###CCCCC###", "##CC###CC##", "##C#####C##", "##C#####C##", "##C#####C##", "##CC###CC##", "###CCCCC###", "###########", "###########")
                .aisle("###########","###########","###########","###########","###########", "###########", "###########", "###########", "####CCC####", "###CCCCC###", "###CCSCC###", "###CCCCC###", "####CCC####", "###########", "###########", "###########")
                .where('C', statePredicate(getCasingState()).or(abilityPartPredicate(ALLOWED_ABILITIES)))
                .where('#', (tile) -> true)
                .where('S', selfPredicate())
                .where('F', statePredicate(MetaBlocks.FRAMES.get(Materials.Naquadria).getDefaultState()))
                .where('H', statePredicate(GAMetaBlocks.REACTOR_CASING.getState(GAReactorCasing.CasingType.HYPER_CORE_3)))
                .where('G', statePredicate(GAMetaBlocks.TRANSPARENT_CASING.getState(GATransparentCasing.CasingType.OSMIRIDIUM_GLASS)))
                .setAmountAtLeast('c', 250)
                .where('c', statePredicate(getCasingState()))
                .build();
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        switch (tier_internal) {
            case 1: return GCYSciTextures.HYPER_CASING;
            case 2: return GCYSciTextures.HYPER_CASING_2;
            default: return GCYSciTextures.NAQUADRIA_CASING;
        }
    }

    protected IBlockState getCasingState() {
        switch (tier_internal) {
            case 1: return GAMetaBlocks.REACTOR_CASING.getState(GAReactorCasing.CasingType.HYPER_CASING);
            case 2: return GAMetaBlocks.REACTOR_CASING.getState(GAReactorCasing.CasingType.HYPER_CASING_2);
            default: return METAL_CASING_2.getState(MetalCasing2.CasingType.NAQUADRIA);
        }
    }
}
