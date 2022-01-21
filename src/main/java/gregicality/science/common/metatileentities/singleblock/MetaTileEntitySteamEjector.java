package gregicality.science.common.metatileentities.singleblock;

import gregicality.science.api.capability.GCYSTileCapabilities;
import gregicality.science.api.metatileentity.EnumVacuumLevel;
import gregicality.science.api.metatileentity.IVacuumProducer;
import gregtech.api.capability.IMultipleTankHandler;
import gregtech.api.capability.impl.FluidTankList;
import gregtech.api.capability.impl.RecipeLogicSteam;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.ModularUI;
import gregtech.api.gui.widgets.LabelWidget;
import gregtech.api.gui.widgets.ProgressWidget;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.MetaTileEntityHolder;
import gregtech.api.metatileentity.SteamMetaTileEntity;
import gregtech.api.recipes.RecipeMap;
import gregtech.client.renderer.ICubeRenderer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.IFluidTank;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class MetaTileEntitySteamEjector extends SteamMetaTileEntity implements IVacuumProducer {

    private FluidTank inputTank;

    public MetaTileEntitySteamEjector(ResourceLocation metaTileEntityId, RecipeMap<?> recipeMap, ICubeRenderer renderer, boolean isHighPressure) {
        super(metaTileEntityId, recipeMap, renderer, isHighPressure);
        this.workableHandler = new VacuumEjectorRecipeLogic(this, recipeMap, isHighPressure, steamFluidTank, 1.0);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(MetaTileEntityHolder metaTileEntityHolder) {
        return new MetaTileEntitySteamEjector(metaTileEntityId, getRecipeMap(), renderer, isHighPressure);
    }

    @Override
    protected void initializeInventory() {
        super.initializeInventory();
        this.inputTank = steamFluidTank;
    }

    @Override
    protected ModularUI createUI(@Nonnull EntityPlayer entityPlayer) {
        return ModularUI.builder(GuiTextures.BACKGROUND_STEAM.get(isHighPressure), 176, 166)
                .widget(new LabelWidget(5, 5, getMetaFullName()))
                .widget(new LabelWidget(5, 15, getProductionLevel().getName()))
                .progressBar(workableHandler::getProgressPercent, 79, 25, 20, 18,
                        GuiTextures.PROGRESS_BAR_EXTRACT_STEAM.get(isHighPressure), ProgressWidget.MoveType.HORIZONTAL, workableHandler.getRecipeMap())
                .bindPlayerInventory(entityPlayer.inventory, GuiTextures.SLOT_STEAM.get(isHighPressure), 0)
                .build(getHolder(), entityPlayer);
    }

    @Override
    public EnumVacuumLevel getProductionLevel() {
        // only produce a vacuum when working
        if (workableHandler.isWorking())
            return EnumVacuumLevel.LOW_VACUUM;
        return EnumVacuumLevel.NONE; //todo this doesn't get set to none when there progress depletes to 0
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(I18n.format("gcys.steam_ejector.tooltip"));
    }

    @Override
    @Nonnull
    public <T> T getCapability(@Nonnull Capability<T> capability, EnumFacing side) {
        if (capability.equals(GCYSTileCapabilities.CAPABILITY_VACUUM_PRODUCER))
            return GCYSTileCapabilities.CAPABILITY_VACUUM_PRODUCER.cast(this);
        return super.getCapability(capability, side);
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    private class VacuumEjectorRecipeLogic extends RecipeLogicSteam {

        public VacuumEjectorRecipeLogic(MetaTileEntity tileEntity, RecipeMap<?> recipeMap, boolean isHighPressure, IFluidTank steamFluidTank, double conversionRate) {
            super(tileEntity, recipeMap, isHighPressure, steamFluidTank, conversionRate);
        }

        @Override
        @Nonnull
        protected IMultipleTankHandler getInputTank() {
            return new FluidTankList(false, inputTank);
        }

        @Override
        protected long getEnergyInputPerSecond() {
            return 1;
        }
    }
}
