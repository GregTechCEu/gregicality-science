package gregicality.science.common.metatileentities.singleblock;

import codechicken.lib.raytracer.CuboidRayTraceResult;
import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.pipeline.IVertexOperation;
import codechicken.lib.vec.Matrix4;
import gregicality.science.api.GCYSValues;
import gregicality.science.api.capability.GCYSTileCapabilities;
import gregicality.science.api.capability.IPressureContainer;
import gregicality.science.api.capability.impl.PressureContainer;
import gregicality.science.api.utils.GCYSUtility;
import gregicality.science.api.utils.NumberFormattingUtil;
import gregtech.api.GTValues;
import gregtech.api.capability.GregtechDataCodes;
import gregtech.api.capability.GregtechTileCapabilities;
import gregtech.api.capability.IActiveOutputSide;
import gregtech.api.capability.impl.FilteredFluidHandler;
import gregtech.api.capability.impl.FluidTankList;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.ModularUI;
import gregtech.api.gui.widgets.ImageWidget;
import gregtech.api.gui.widgets.ProgressWidget;
import gregtech.api.gui.widgets.TankWidget;
import gregtech.api.metatileentity.IDataInfoProvider;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.unification.material.Materials;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.ConfigHolder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSnow;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.*;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import org.apache.commons.lang3.tuple.Pair;
import org.lwjgl.input.Keyboard;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class MetaTileEntitySteamEjector extends MetaTileEntity implements IDataInfoProvider, IActiveOutputSide {

    private static final int PRESSURE_DECREASE = -1000;
    private static final int STEAM_CONSUMPTION = 160;

    private PressureContainer pressureContainer;
    private FluidTank fuelFluidTank;
    @SuppressWarnings("FieldMayBeFinal")
    private boolean isHighPressure;

    protected EnumFacing outputFacing;

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
        this.pressureContainer = new PressureContainer(this, 13E-5, GCYSValues.EARTH_PRESSURE, 1.0);
    }

    @Override
    protected FluidTankList createImportFluidHandler() {
        FluidTankList superHandler = super.createImportFluidHandler();
        this.fuelFluidTank = new FilteredFluidHandler(16000)
                .setFillPredicate(fs -> fs.getFluid() == Materials.Steam.getFluid());
        return new FluidTankList(false, superHandler, fuelFluidTank);
    }

    @Override
    public void renderMetaTileEntity(CCRenderState renderState, Matrix4 translation, IVertexOperation[] pipeline) {
        super.renderMetaTileEntity(renderState, translation, pipeline);
        for (EnumFacing facing : EnumFacing.VALUES) {
            Textures.STEAM_CASING_STEEL.renderSided(facing, renderState, translation, pipeline);
        }
        Textures.AIR_VENT_OVERLAY.renderSided(getFrontFacing(), renderState, translation, pipeline);
        Textures.PIPE_OUT_OVERLAY.renderSided(getOutputFacing(), renderState, translation, pipeline);
    }

    @Override
    public Pair<TextureAtlasSprite, Integer> getParticleTexture() {
        return Pair.of(Textures.STEAM_CASING_STEEL.getParticleSprite(), getPaintingColorForRendering());
    }

    @Override
    protected ModularUI createUI(@Nonnull EntityPlayer entityPlayer) {
        return ModularUI.builder(GuiTextures.BACKGROUND_STEAM.get(isHighPressure), 176, 166)
                .label(6, 6, getMetaFullName()).shouldColor(false)

                // TODO add tooltip directly to ProgressWidget in CEu
                .widget(new ImageWidget(96, 26, 10, 54, GuiTextures.SLOT)
                        .setTooltip(NumberFormattingUtil.formatDoubleToCompactString(pressureContainer.getPressure()) + "Pa / " +
                                NumberFormattingUtil.formatDoubleToCompactString(pressureContainer.getMinPressure()) + "Pa"))
                .widget(new ProgressWidget(() -> pressureContainer.getPressurePercent(true), 96, 26, 10, 54)
                        .setProgressBar(GuiTextures.PROGRESS_BAR_BOILER_EMPTY.get(true),
                                GuiTextures.PROGRESS_BAR_BOILER_HEAT, ProgressWidget.MoveType.VERTICAL))

                .widget(new TankWidget(fuelFluidTank, 70, 26, 10, 54)
                        .setBackgroundTexture(GuiTextures.PROGRESS_BAR_BOILER_EMPTY.get(isHighPressure)))

                .bindPlayerInventory(entityPlayer.inventory, GuiTextures.SLOT_STEAM.get(isHighPressure), 0)
                .build(getHolder(), entityPlayer);
    }

    @Override
    public boolean onWrenchClick(@Nonnull EntityPlayer playerIn, EnumHand hand, EnumFacing facing, CuboidRayTraceResult hitResult) {
        if (!playerIn.isSneaking()) {
            if (getOutputFacing() == facing || getFrontFacing() == facing) return false;
            this.setOutputFacing(facing);
            return true;
        }
        return super.onWrenchClick(playerIn, hand, facing, hitResult);
    }

    @Override
    public void update() {
        super.update();
        if (!getWorld().isRemote && getOffsetTimer() % 20 == 0) {
            if (pressureContainer.getPressure() > pressureContainer.getMinPressure()) {
                FluidStack drained = fuelFluidTank.drain(STEAM_CONSUMPTION, false);
                if (drained != null && drained.amount == STEAM_CONSUMPTION && ventSteam(true)) {
                    fuelFluidTank.drain(STEAM_CONSUMPTION, true);

                    if (pressureContainer.changeParticles(PRESSURE_DECREASE, true)) {
                        pressureContainer.changeParticles(PRESSURE_DECREASE, false);
                    } else if (pressureContainer.changeParticles(-pressureContainer.getParticles() / 2, true)) {
                        // divide pressure by 2 if the regular decrease is too much
                        pressureContainer.changeParticles(-pressureContainer.getParticles() / 2, false);
                    } else {
                        // do not allow less than min pressure to prevent explosions and not require redstone control
                        pressureContainer.setParticles(pressureContainer.getMinPressure() * pressureContainer.getVolume());
                    }

                    ventSteam(false);
                }
            }

            TileEntity te = getWorld().getTileEntity(getPos().offset(getOutputFacing()));
            if (te != null) {
                IPressureContainer container = te.getCapability(GCYSTileCapabilities.CAPABILITY_PRESSURE_CONTAINER, this.getOutputFacing().getOpposite());
                if (container != null) {
                    IPressureContainer.mergeContainers(false, container, pressureContainer);
                }
            }

            if (!this.pressureContainer.isPressureSafe()) {
                this.pressureContainer.causePressureExplosion(getWorld(), getPos());
            }
        }
    }

    private boolean ventSteam(boolean simulate) {
        BlockPos pos = getPos().offset(getFrontFacing());
        IBlockState targetBlock = getWorld().getBlockState(pos);
        if (targetBlock.getCollisionBoundingBox(getWorld(), pos) == Block.NULL_AABB) {
            if (!simulate) performVentingAnimation();
            return true;
        } else if (targetBlock.getBlock() == Blocks.SNOW_LAYER && targetBlock.getValue(BlockSnow.LAYERS) == 1) {
            if (!simulate) {
                performVentingAnimation();
                getWorld().destroyBlock(pos, false);
            }
            return true;
        }
        return false;
    }

    private void performVentingAnimation() {
        final BlockPos pos = getPos();
        final EnumFacing facing = getFrontFacing();
        double posX = pos.getX() + 0.5 + facing.getXOffset() * 0.6;
        double posY = pos.getY() + 0.5 + facing.getYOffset() * 0.6;
        double posZ = pos.getZ() + 0.5 + facing.getZOffset() * 0.6;

        ((WorldServer) getWorld()).spawnParticle(EnumParticleTypes.CLOUD, posX, posY, posZ,
                7 + GTValues.RNG.nextInt(3),
                facing.getXOffset() / 2.0,
                facing.getYOffset() / 2.0,
                facing.getZOffset() / 2.0, 0.1);
        if (ConfigHolder.machines.machineSounds && !isMuffled()) {
            getWorld().playSound(null, posX, posY, posZ, SoundEvents.BLOCK_LAVA_EXTINGUISH, SoundCategory.BLOCKS, 1.0F, 1.0F);
        }
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(I18n.format("gcys.steam_ejector.tooltip.1"));
        tooltip.add(I18n.format("gcys.steam_ejector.tooltip.2", NumberFormattingUtil.formatDoubleToCompactString(Math.abs(PRESSURE_DECREASE))));
        tooltip.add(I18n.format("gcys.steam_ejector.tooltip.3", STEAM_CONSUMPTION));
        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
            tooltip.add(I18n.format("gcys.universal.tooltip.pressure.minimum", NumberFormattingUtil.formatDoubleToCompactString(pressureContainer.getMinPressure()), GCYSValues.PNF[GCYSUtility.getTierByPressure(pressureContainer.getMinPressure())]));
            tooltip.add(I18n.format("gcys.universal.tooltip.pressure.maximum", NumberFormattingUtil.formatDoubleToCompactString(pressureContainer.getMaxPressure()), GCYSValues.PNF[GCYSUtility.getTierByPressure(pressureContainer.getMaxPressure())]));
        } else {
            tooltip.add(I18n.format("gregtech.tooltip.hold_shift"));
        }
    }

    @Override
    public void setFrontFacing(EnumFacing frontFacing) {
        super.setFrontFacing(frontFacing);
        if (getWorld() != null && !getWorld().isRemote && outputFacing == null) {
            setOutputFacing(frontFacing.getOpposite());

        }
    }

    @Nonnull
    @Override
    public NBTTagCompound writeToNBT(@Nonnull NBTTagCompound data) {
        super.writeToNBT(data);
        data.setInteger("outputFacing", getOutputFacing().getIndex());
        return data;
    }

    @Override
    public void readFromNBT(@Nonnull NBTTagCompound data) {
        super.readFromNBT(data);
        this.outputFacing = EnumFacing.VALUES[data.getInteger("outputFacing")];
    }

    @Override
    public void writeInitialSyncData(@Nonnull PacketBuffer buf) {
        super.writeInitialSyncData(buf);
        buf.writeInt(getOutputFacing().getIndex());
    }

    @Override
    public void receiveInitialSyncData(@Nonnull PacketBuffer buf) {
        super.receiveInitialSyncData(buf);
        this.outputFacing = EnumFacing.VALUES[buf.readInt()];
    }

    @Override
    public void receiveCustomData(int dataId, @Nonnull PacketBuffer buf) {
        super.receiveCustomData(dataId, buf);
        if (dataId == GregtechDataCodes.VENTING_SIDE) {
            this.outputFacing = EnumFacing.VALUES[buf.readByte()];
            scheduleRenderUpdate();
        }
    }

    public EnumFacing getOutputFacing() {
        return this.outputFacing == null ? EnumFacing.SOUTH : this.outputFacing;
    }

    public void setOutputFacing(@Nonnull EnumFacing outputFacing) {
        this.outputFacing = outputFacing;
        if (!this.getWorld().isRemote) {
            this.markDirty();
            writeCustomData(GregtechDataCodes.VENTING_SIDE, buf -> buf.writeByte(this.getOutputFacing().getIndex()));
        }
    }

    @Override
    @Nullable
    public <T> T getCapability(@Nonnull Capability<T> capability, EnumFacing side) {
        if (capability == GregtechTileCapabilities.CAPABILITY_ACTIVE_OUTPUT_SIDE) {
            return side == this.getOutputFacing() ? GregtechTileCapabilities.CAPABILITY_ACTIVE_OUTPUT_SIDE.cast(this) : null;
        }
        if (capability.equals(GCYSTileCapabilities.CAPABILITY_PRESSURE_CONTAINER)) {
            return GCYSTileCapabilities.CAPABILITY_PRESSURE_CONTAINER.cast(pressureContainer);
        }
        return super.getCapability(capability, side);
    }

    @Override
    public int getDefaultPaintingColor() {
        return 0xFFFFFF;
    }

    @Override
    public boolean isValidFrontFacing(EnumFacing facing) {
        return super.isValidFrontFacing(facing) && facing != this.outputFacing;
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

    @Override
    public boolean isAutoOutputItems() {
        return false;
    }

    @Override
    public boolean isAutoOutputFluids() {
        return false;
    }

    @Override
    public boolean isAllowInputFromOutputSideItems() {
        return false;
    }

    @Override
    public boolean isAllowInputFromOutputSideFluids() {
        return false;
    }
}
