package gregicality.science.api.capability.impl;

import gregicality.science.api.GCYSValues;
import gregicality.science.api.capability.GCYSTileCapabilities;
import gregicality.science.api.capability.IPressureContainer;
import gregtech.api.metatileentity.MTETrait;
import gregtech.api.metatileentity.MetaTileEntity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class PressureContainer extends MTETrait implements IPressureContainer {

    private final double minPressure;
    private final double maxPressure;
    private final double volume;

    private double particles;

    /**
     * Default pressure container
     * {@link IPressureContainer}
     *
     * @param volume the volume of the container, must be nonzero
     */
    public PressureContainer(MetaTileEntity metaTileEntity, double minPressure, double maxPressure, double volume) {
        super(metaTileEntity);
        this.minPressure = minPressure;
        this.maxPressure = maxPressure;
        this.volume = volume;
        this.particles = volume * GCYSValues.EARTH_ATMOSPHERIC_PRESSURE;
    }

    @Override
    public double getMaxPressure() {
        return this.maxPressure;
    }

    @Override
    public double getParticles() {
        return this.particles;
    }

    @Override
    public double getVolume() {
        return this.volume;
    }

    @Override
    public void setParticles(double amount) {
        this.particles = amount;
    }

    @Override
    public double getMinPressure() {
        return this.minPressure;
    }

    @Override
    public NBTTagCompound serializeNBT() {
        NBTTagCompound compound = new NBTTagCompound();
        compound.setDouble("particles", this.particles);
        return compound;
    }

    @Override
    public void deserializeNBT(@Nonnull NBTTagCompound compound) {
        this.particles = compound.getDouble("particles");
    }

    @Override
    public String getName() {
        return "PressureContainer";
    }

    @Override
    public int getNetworkID() {
        return 3;
    }

    @Nullable
    @Override
    public <T> T getCapability(Capability<T> capability) {
        if (capability == GCYSTileCapabilities.CAPABILITY_PRESSURE_CONTAINER) {
            return GCYSTileCapabilities.CAPABILITY_PRESSURE_CONTAINER.cast(this);
        }
        return null;
    }
}
