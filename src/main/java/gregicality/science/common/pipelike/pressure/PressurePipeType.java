package gregicality.science.common.pipelike.pressure;

import gregicality.science.api.capability.IPressureContainer;
import gregtech.api.pipenet.block.IPipeType;

import javax.annotation.Nonnull;

public enum PressurePipeType implements IPipeType<PressurePipeData> {
    NORMAL("normal", 0.5f, IPressureContainer.ATMOSPHERIC_PRESSURE / 10, IPressureContainer.ATMOSPHERIC_PRESSURE * 10, 1000);

    public final float thickness;
    public final String name;
    public final double maxPressure;
    private final double minPressure;
    private final int maxVolume;

    PressurePipeType(String name, float thickness, double minPressure, double maxPressure, int maxVolume) {
        this.thickness = thickness;
        this.name = name;
        this.minPressure = minPressure;
        this.maxPressure = maxPressure;
        this.maxVolume = maxVolume;
    }

    @Override
    public float getThickness() {
        return thickness;
    }

    public double getMinPressure() {
        return minPressure;
    }

    public double getMaxPressure() {
        return maxPressure;
    }

    @Nonnull
    @Override
    public PressurePipeData modifyProperties(PressurePipeData pipeData) {
        return new PressurePipeData(minPressure, maxPressure, maxVolume);
    }

    @Override
    public boolean isPaintable() {
        return true;
    }

    @Override
    public String getName() {
        return name;
    }
}
