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

    private double pressure;

    public PressureContainer(MetaTileEntity metaTileEntity, double minPressure, double maxPressure) {
        super(metaTileEntity);
        this.minPressure = minPressure;
        this.maxPressure = maxPressure;
        this.pressure = GCYSValues.EARTH_ATMOSPHERIC_PRESSURE;
    }

    @Override
    public double getPressure() {
        return this.pressure;
    }

    @Override
    public double setPressure(double amount) {
        this.pressure = amount;
        return amount;
    }

    @Override
    public double getMaxPressure() {
        return this.maxPressure;
    }

    @Override
    public double getMinPressure() {
        return this.minPressure;
    }

    @Override
    public NBTTagCompound serializeNBT() {
        NBTTagCompound compound = new NBTTagCompound();
        compound.setDouble("pressure", this.pressure);
        return compound;
    }

    @Override
    public void deserializeNBT(@Nonnull NBTTagCompound compound) {
        this.pressure = compound.getDouble("pressure");
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
