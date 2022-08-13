package gregicality.science.common.metatileentities.singleblock;

import gregicality.science.api.GCYSValues;
import gregicality.science.api.capability.GCYSTileCapabilities;
import gregicality.science.api.capability.IPressureContainer;
import gregicality.science.api.capability.IPressureMachine;
import gregicality.science.api.capability.impl.PressureContainer;
import gregicality.science.api.capability.impl.PressureSteamRecipeLogic;
import gregicality.science.api.recipes.GCYSRecipeMaps;
import gregicality.science.api.utils.GCYSUtility;
import gregicality.science.api.utils.NumberFormattingUtil;
import gregtech.api.capability.impl.NotifiableItemStackHandler;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.ModularUI;
import gregtech.api.gui.widgets.ImageWidget;
import gregtech.api.gui.widgets.ProgressWidget;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.SteamMetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.client.renderer.texture.Textures;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.IItemHandlerModifiable;
import org.lwjgl.input.Keyboard;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class MetaTileEntitySteamVacuumChamber extends SteamMetaTileEntity implements IPressureMachine {

    private PressureContainer pressureContainer;

    public MetaTileEntitySteamVacuumChamber(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, GCYSRecipeMaps.PRESSURE_CHAMBER_RECIPES, Textures.COMPRESSOR_OVERLAY, true);
        this.workableHandler = new PressureSteamRecipeLogic(this, GCYSRecipeMaps.PRESSURE_CHAMBER_RECIPES, isHighPressure, this.steamFluidTank, 1.0);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntitySteamVacuumChamber(metaTileEntityId);
    }

    @Override
    protected void initializeInventory() {
        super.initializeInventory();
        this.pressureContainer = new PressureContainer(this, 13E-5, GCYSValues.EARTH_PRESSURE, 1.0);
    }

    @Override
    protected IItemHandlerModifiable createImportItemHandler() {
        return new NotifiableItemStackHandler(4, this, false);
    }

    @Override
    protected IItemHandlerModifiable createExportItemHandler() {
        return new NotifiableItemStackHandler(1, this, true);
    }

    @Override
    public void update() {
        super.update();
        if (!getWorld().isRemote && getOffsetTimer() % 20 == 0) {
            for (EnumFacing facing : EnumFacing.VALUES) {
                if (facing == getFrontFacing() || facing == this.workableHandler.getVentingSide()) continue;

                TileEntity te = getWorld().getTileEntity(getPos().offset(facing));
                if (te != null) {
                    IPressureContainer container = te.getCapability(GCYSTileCapabilities.CAPABILITY_PRESSURE_CONTAINER, facing.getOpposite());
                    if (container != null) {
                        IPressureContainer.mergeContainers(false, container, pressureContainer);
                    }
                }
            }

            if (!this.pressureContainer.isPressureSafe()) {
                this.pressureContainer.causePressureExplosion(getWorld(), getPos());
            }
        }
    }

    @Override
    public ModularUI createUI(EntityPlayer player) {
        return createUITemplate(player)
                .slot(this.importItems, 0, 35, 25, GuiTextures.SLOT_STEAM.get(isHighPressure), GuiTextures.COMPRESSOR_OVERLAY_STEAM.get(isHighPressure))
                .slot(this.importItems, 1, 53, 25, GuiTextures.SLOT_STEAM.get(isHighPressure), GuiTextures.COMPRESSOR_OVERLAY_STEAM.get(isHighPressure))
                .slot(this.importItems, 2, 35, 43, GuiTextures.SLOT_STEAM.get(isHighPressure), GuiTextures.COMPRESSOR_OVERLAY_STEAM.get(isHighPressure))
                .slot(this.importItems, 3, 53, 43, GuiTextures.SLOT_STEAM.get(isHighPressure), GuiTextures.COMPRESSOR_OVERLAY_STEAM.get(isHighPressure))

                // TODO add tooltip directly to ProgressWidget in CEu
                .widget(new ImageWidget(12, 21, 10, 54, GuiTextures.SLOT)
                        .setTooltip(NumberFormattingUtil.formatDoubleToCompactString(pressureContainer.getPressure()) + "Pa / " +
                                NumberFormattingUtil.formatDoubleToCompactString(pressureContainer.getMinPressure()) + "Pa"))
                .widget(new ProgressWidget(() -> pressureContainer.getPressurePercent(true), 12, 21, 10, 54)
                        .setProgressBar(GuiTextures.PROGRESS_BAR_BOILER_EMPTY.get(true),
                                GuiTextures.PROGRESS_BAR_BOILER_HEAT, ProgressWidget.MoveType.VERTICAL))

                .progressBar(workableHandler::getProgressPercent, 79, 35, 20, 18,
                        GuiTextures.PROGRESS_BAR_COMPRESS_STEAM.get(isHighPressure), ProgressWidget.MoveType.HORIZONTAL, workableHandler.getRecipeMap())

                .slot(this.exportItems, 0, 107, 35, true, false, GuiTextures.SLOT_STEAM.get(isHighPressure))

                .build(getHolder(), player);
    }

    @Override
    public ModularUI.Builder createUITemplate(@Nonnull EntityPlayer player) {
        return ModularUI.builder(GuiTextures.BACKGROUND_STEAM.get(this.isHighPressure), 176, 166)
                .label(6, 6, this.getMetaFullName()).shouldColor(false)

                .widget((new ImageWidget(79, 51, 18, 18, GuiTextures.INDICATOR_NO_STEAM.get(this.isHighPressure)))
                        .setPredicate(() -> this.workableHandler.isHasNotEnoughEnergy()))

                .bindPlayerInventory(player.inventory, GuiTextures.SLOT_STEAM.get(this.isHighPressure), 0);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
            tooltip.add(I18n.format("gcys.universal.tooltip.pressure.minimum", NumberFormattingUtil.formatDoubleToCompactString(pressureContainer.getMinPressure()), GCYSValues.PNF[GCYSUtility.getTierByPressure(pressureContainer.getMinPressure())]));
            tooltip.add(I18n.format("gcys.universal.tooltip.pressure.maximum", NumberFormattingUtil.formatDoubleToCompactString(pressureContainer.getMaxPressure()), GCYSValues.PNF[GCYSUtility.getTierByPressure(pressureContainer.getMaxPressure())]));
        } else {
            tooltip.add(I18n.format("gregtech.tooltip.hold_shift"));
        }
    }

    @Override
    @Nullable
    public <T> T getCapability(@Nonnull Capability<T> capability, EnumFacing side) {
        if (capability.equals(GCYSTileCapabilities.CAPABILITY_PRESSURE_CONTAINER)) {
            return GCYSTileCapabilities.CAPABILITY_PRESSURE_CONTAINER.cast(pressureContainer);
        }
        return super.getCapability(capability, side);
    }

    @Override
    public IPressureContainer getPressureContainer() {
        return this.pressureContainer;
    }

    // the vacuum chamber does not emit particles
    @Override
    public void randomDisplayTick() {/**/}
}
