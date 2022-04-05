package gregicality.science.api.capability.impl;

import gregicality.science.api.capability.GCYSTileCapabilities;
import gregicality.science.api.capability.IPressureContainer;
import gregtech.api.metatileentity.MTETrait;
import gregtech.api.metatileentity.MetaTileEntity;
import net.minecraftforge.common.capabilities.Capability;

public class PressureContainerHandler extends MTETrait implements IPressureContainer {

    private final double minPressure, maxPressure;
    private double currentPressure;

    public PressureContainerHandler(MetaTileEntity metaTileEntity, double maxPressure) {
        this(metaTileEntity, maxPressure, ATMOSPHERIC_PRESSURE / maxPressure);
    }

    public PressureContainerHandler(MetaTileEntity metaTileEntity, double maxPressure, double minPressure) {
        super(metaTileEntity);
        this.minPressure = minPressure;
        this.maxPressure = maxPressure;
    }

    @Override
    public double getPressure() {
        return this.currentPressure;
    }

    @Override
    public double changePressure(double amount) {
        this.currentPressure += amount;
        if (!canHandlePressure(getPressure())) {
            IPressureContainer.causePressureExplosion(isVacuum(), getMetaTileEntity().getWorld(), getMetaTileEntity().getPos());
        }
        return amount;
    }

    @Override
    public double getMaxPressure() {
        return maxPressure;
    }

    @Override
    public double getMinPressure() {
        return minPressure;
    }

    @Override
    public String getName() {
        return "PressureContainer";
    }

    @Override
    public int getNetworkID() {
        return 10;
    }

    @Override
    public <T> T getCapability(Capability<T> capability) {
        if (capability == GCYSTileCapabilities.CAPABILITY_PRESSURE_CONTAINER) {
            return GCYSTileCapabilities.CAPABILITY_PRESSURE_CONTAINER.cast(this);
        }
        return null;
    }
}
