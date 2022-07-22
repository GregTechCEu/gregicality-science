package gregicality.science.common.metatileentities.singleblock;

import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.pipeline.ColourMultiplier;
import codechicken.lib.render.pipeline.IVertexOperation;
import codechicken.lib.vec.Cuboid6;
import codechicken.lib.vec.Matrix4;
import gregicality.science.api.GCYSValues;
import gregicality.science.api.capability.GCYSTileCapabilities;
import gregicality.science.api.capability.IPressureContainer;
import gregtech.api.GTValues;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.ModularUI;
import gregtech.api.gui.widgets.CycleButtonWidget;
import gregtech.api.gui.widgets.ImageWidget;
import gregtech.api.gui.widgets.TextFieldWidget2;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.texture.Textures;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.tuple.Pair;

import javax.annotation.Nonnull;
import java.util.function.Function;

public class MetaTileEntityCreativePressurePump extends MetaTileEntity implements IPressureContainer {

    private double pressure;
    private double pressureLimit = GCYSValues.EARTH_ATMOSPHERIC_PRESSURE * 10;

    private boolean active = false;
    private boolean source = true;

    private boolean doExplosion = false;

    public MetaTileEntityCreativePressurePump(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new MetaTileEntityCreativePressurePump(metaTileEntityId);
    }

    @Override
    public void renderMetaTileEntity(CCRenderState renderState, Matrix4 translation, IVertexOperation[] pipeline) {
        IVertexOperation[] renderPipeline = ArrayUtils.add(pipeline, new ColourMultiplier(GTUtility.convertRGBtoOpaqueRGBA_CL(getPaintingColorForRendering())));
        Textures.VOLTAGE_CASINGS[GTValues.MAX].render(renderState, translation, renderPipeline, Cuboid6.full);
        for (EnumFacing face : EnumFacing.VALUES) {
            Textures.INFINITE_EMITTER_FACE.renderSided(face, renderState, translation, pipeline);
        }
    }

    @Override
    public Pair<TextureAtlasSprite, Integer> getParticleTexture() {
        return Pair.of(Textures.VOLTAGE_CASINGS[GTValues.MAX].getParticleSprite(), getPaintingColorForRendering());
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing side) {
        if (capability == GCYSTileCapabilities.CAPABILITY_PRESSURE_CONTAINER)
            return GCYSTileCapabilities.CAPABILITY_PRESSURE_CONTAINER.cast(this);
        return super.getCapability(capability, side);
    }

    @Override
    protected ModularUI createUI(EntityPlayer entityPlayer) {
        ModularUI.Builder builder = ModularUI.defaultBuilder();
        builder.label(7, 32, "Pressure"); //TODO Localize
        builder.widget(new ImageWidget(7, 44, 156, 20, GuiTextures.DISPLAY));
        builder.widget(new TextFieldWidget2(9, 50, 152, 16, () -> String.valueOf(pressure), value -> {
            if (!value.isEmpty()) pressure = Double.parseDouble(value);
        }).setAllowedChars(TextFieldWidget2.NATURAL_NUMS).setMaxLength(19).setValidator(getTextFieldValidator()));

        builder.label(7, 74, "Max Pressure"); //TODO Localize
        builder.widget(new ImageWidget(29, 87, 118, 20, GuiTextures.DISPLAY));
        builder.widget(new TextFieldWidget2(31, 93, 114, 16, () -> String.valueOf(pressureLimit), value -> {
            if (!value.isEmpty()) {
                pressureLimit = Double.parseDouble(value);
            }
        }).setMaxLength(10).setNumbersOnly(1, Integer.MAX_VALUE));

        builder.widget(new CycleButtonWidget(7, 139, 77, 20, () -> active, value -> active = value, "gregtech.creative.activity.off", "gregtech.creative.activity.on"));
        builder.widget(new CycleButtonWidget(85, 139, 77, 20, () -> source, value -> source = value, "Sink", "Source")); //TODO: localization

        return builder.build(getHolder(), entityPlayer);
    }

    @Override
    public void update() {
        super.update();
        if (getOffsetTimer() % 20 == 0) {
            if (doExplosion) {
                getWorld().createExplosion(null, getPos().getX() + 0.5, getPos().getY() + 0.5, getPos().getZ() + 0.5,
                        1, false);
                doExplosion = false;
            }
        }
        if (getWorld().isRemote || !active || pressure <= 0) return;
        for (EnumFacing facing : EnumFacing.values()) {
            TileEntity tile = getWorld().getTileEntity(getPos().offset(facing));
            if (tile != null) {
                IPressureContainer container = tile.getCapability(GCYSTileCapabilities.CAPABILITY_PRESSURE_CONTAINER, facing.getOpposite());
                if (container == null) continue;
                container.changeParticles(source ? pressure : -pressure, false);
            }
        }
    }

    @Override
    public NBTTagCompound writeToNBT(@Nonnull NBTTagCompound data) {
        super.writeToNBT(data);
        data.setDouble("Pressure", pressure);
        data.setBoolean("Active", active);
        data.setBoolean("Source", source);
        return data;
    }

    @Override
    public void readFromNBT(@Nonnull NBTTagCompound data) {
        super.readFromNBT(data);
        pressure = data.getDouble("Pressure");
        active = data.getBoolean("Active");
        source = data.getBoolean("Source");
    }

    @Override
    public double getParticles() {
        return 0;
    }

    @Override
    public double getVolume() {
        return 0;
    }

    @Override
    public double getPressure() {
        return this.pressure;
    }

    @Override
    public void setParticles(double amount) {/**/}

    @Override
    public double getMaxPressure() {
        return pressureLimit;
    }

    @Override
    public double getMinPressure() {
        return 0;
    }

    @Nonnull
    public static Function<String, String> getTextFieldValidator() {
        return val -> {
            if (val.isEmpty()) return "0";
            return val;
        };
    }
}
