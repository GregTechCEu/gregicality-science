package gregicality.science.common.metatileentities.singleblock;

import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.pipeline.IVertexOperation;
import codechicken.lib.vec.Matrix4;
import gregicality.science.api.GCYSValues;
import gregicality.science.api.capability.GCYSTileCapabilities;
import gregicality.science.api.capability.IPressureContainer;
import gregicality.science.api.capability.impl.PressureContainer;
import gregicality.science.api.utils.GCYSUtility;
import gregicality.science.api.utils.NumberFormattingUtil;
import gregtech.api.capability.impl.FilteredFluidHandler;
import gregtech.api.capability.impl.FluidTankList;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.ModularUI;
import gregtech.api.gui.widgets.ProgressWidget;
import gregtech.api.gui.widgets.TankWidget;
import gregtech.api.metatileentity.IDataInfoProvider;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.unification.material.Materials;
import gregtech.client.renderer.texture.Textures;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.*;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import org.apache.commons.lang3.tuple.Pair;
import org.lwjgl.input.Keyboard;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class MetaTileEntitySteamEjector extends MetaTileEntity implements IDataInfoProvider {

    private static final int PRESSURE_DECREASE = -2200;
    private static final int STEAM_CONSUMPTION = 160;

    private PressureContainer pressureContainer;
    private FluidTank fuelFluidTank;
    private boolean isHighPressure;

    public MetaTileEntitySteamEjector(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId);
        this.isHighPressure = true;
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity metaTileEntityHolder) {
        return new MetaTileEntitySteamEjector(metaTileEntityId);
    }

    @Override
    protected void initializeInventory() {
        super.initializeInventory();
        this.pressureContainer = new PressureContainer(this, 10E-6, GCYSValues.EARTH_ATMOSPHERIC_PRESSURE);
        this.mteTraits.add(pressureContainer);
    }

    @Override
    protected FluidTankList createImportFluidHandler() {
        FluidTankList superHandler = super.createImportFluidHandler();
        this.fuelFluidTank = new FilteredFluidHandler(16000)
                .setFillPredicate(fs -> fs.getFluid() == Materials.Steam.getFluid());
        return new FluidTankList(false, superHandler, fuelFluidTank);
    }

    @Override
    protected ModularUI createUI(@Nonnull EntityPlayer entityPlayer) {
        return ModularUI.builder(GuiTextures.BACKGROUND_STEAM.get(isHighPressure), 176, 166)
                .label(6, 6, getMetaFullName()).shouldColor(false)
                .widget(new ProgressWidget(this::getPressurePercent, 96, 26, 10, 54)
                        .setProgressBar(GuiTextures.PROGRESS_BAR_BOILER_EMPTY.get(isHighPressure),
                                GuiTextures.PROGRESS_BAR_BOILER_HEAT, ProgressWidget.MoveType.VERTICAL))

                .widget(new TankWidget(fuelFluidTank, 70, 26, 10, 54)
                        .setBackgroundTexture(GuiTextures.PROGRESS_BAR_BOILER_EMPTY.get(isHighPressure)))

                .bindPlayerInventory(entityPlayer.inventory, GuiTextures.SLOT_STEAM.get(isHighPressure), 0)
                .build(getHolder(), entityPlayer);
    }

    protected double getPressurePercent() {
        if (this.pressureContainer.getPressure() == 0) return 0;
        return this.pressureContainer.getMinPressure() / this.pressureContainer.getPressure();
    }

    @Override
    public void update() {
        super.update();
        if (getWorld().isRemote) return;
        if (getOffsetTimer() % 20 == 0) {
            if (pressureContainer.getPressure() > pressureContainer.getMinPressure()) {
                FluidStack drained = fuelFluidTank.drain(STEAM_CONSUMPTION, false);
                if (drained != null && drained.amount == STEAM_CONSUMPTION) {
                    fuelFluidTank.drain(STEAM_CONSUMPTION, true);
                    if (pressureContainer.canHandlePressureChange(PRESSURE_DECREASE)) {
                        pressureContainer.changePressure(PRESSURE_DECREASE);
                    } else {
                        // do not allow less than min pressure to prevent explosions and not require redstone control
                        pressureContainer.setPressure(Math.max(pressureContainer.getMinPressure(), pressureContainer.getPressure() / 2.0D));
                    }
                }
            }
            for (EnumFacing facing : EnumFacing.VALUES) {
                if (facing == getFrontFacing()) continue;
                TileEntity tile = getWorld().getTileEntity(getPos().offset(facing));
                if (tile != null) {
                    IPressureContainer container = tile.getCapability(GCYSTileCapabilities.CAPABILITY_PRESSURE_CONTAINER, facing.getOpposite());
                    if (container == null) continue;
                    if (container.getPressure() == container.getMinPressure()) continue;
                    if (container.canHandlePressureChange((container.getPressure() - pressureContainer.getPressure()) / 2.0D)) {
                        container.changePressure(-pressureContainer.getPressure());
                    } else {
                        container.setPressure(Math.max(container.getMinPressure(), container.getPressure() / 2.0D));
                    }
                }
            }
        }
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(I18n.format("gcys.steam_ejector.tooltip.1", PRESSURE_DECREASE));
        tooltip.add(I18n.format("gcys.steam_ejector.tooltip.2", Math.abs(STEAM_CONSUMPTION)));
        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
            tooltip.add(I18n.format("gcys.universal.tooltip.pressure.minimum", NumberFormattingUtil.formatDoubleToCompactString(pressureContainer.getMinPressure()), GCYSValues.PNF[GCYSUtility.getTierByPressure(pressureContainer.getMinPressure())]));
            tooltip.add(I18n.format("gcys.universal.tooltip.pressure.maximum", NumberFormattingUtil.formatDoubleToCompactString(pressureContainer.getMaxPressure()), GCYSValues.PNF[GCYSUtility.getTierByPressure(pressureContainer.getMaxPressure())]));
        } else {
            tooltip.add(I18n.format("gregtech.tooltip.hold_shift"));
        }
    }

    @Override
    @Nonnull
    public <T> T getCapability(@Nonnull Capability<T> capability, EnumFacing side) {
        if (capability.equals(GCYSTileCapabilities.CAPABILITY_PRESSURE_CONTAINER)) {
            return GCYSTileCapabilities.CAPABILITY_PRESSURE_CONTAINER.cast(pressureContainer);
        }
        return super.getCapability(capability, side);
    }

    @Override
    public void renderMetaTileEntity(CCRenderState renderState, Matrix4 translation, IVertexOperation[] pipeline) {
        super.renderMetaTileEntity(renderState, translation, pipeline);
        for (EnumFacing facing : EnumFacing.VALUES) {
            Textures.STEAM_CASING_STEEL.renderSided(facing, renderState, translation, pipeline);
        }
        Textures.AIR_VENT_OVERLAY.renderSided(getFrontFacing(), renderState, translation, pipeline);
    }

    @Override
    public Pair<TextureAtlasSprite, Integer> getParticleTexture() {
        return Pair.of(Textures.STEAM_CASING_STEEL.getParticleSprite(), getPaintingColorForRendering());
    }

    @Override
    public int getDefaultPaintingColor() {
        return 0xFFFFFF;
    }

    @Nonnull
    @Override
    public List<ITextComponent> getDataInfo() {
        List<ITextComponent> list = new ObjectArrayList<>();
        list.add(new TextComponentTranslation("behavior.tricorder.current_pressure", new TextComponentString(NumberFormattingUtil.formatDoubleToCompactString(pressureContainer.getPressure())).setStyle(new Style().setColor(TextFormatting.AQUA))));
        list.add(new TextComponentTranslation("behavior.tricorder.min_pressure", new TextComponentString(NumberFormattingUtil.formatDoubleToCompactString(pressureContainer.getMinPressure())).setStyle(new Style().setColor(TextFormatting.GREEN))));
        list.add(new TextComponentTranslation("behavior.tricorder.max_pressure", new TextComponentString(NumberFormattingUtil.formatDoubleToCompactString(pressureContainer.getMaxPressure())).setStyle(new Style().setColor(TextFormatting.GREEN))));
        return list;
    }
}
