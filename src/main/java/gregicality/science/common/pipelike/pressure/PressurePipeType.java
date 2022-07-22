package gregicality.science.common.pipelike.pressure;

import gregicality.science.api.GCYSValues;
import gregtech.api.pipenet.block.IPipeType;

import javax.annotation.Nonnull;

public enum PressurePipeType implements IPipeType<PressurePipeData> {
    NORMAL("normal", 0.5f, 10E-6, GCYSValues.EARTH_ATMOSPHERIC_PRESSURE * 10, 1000);

    public final float thickness;
    public final String name;
    public final double maxPressure;
    private final double minPressure;
    private final double volume;

    PressurePipeType(String name, float thickness, double minPressure, double maxPressure, double volume) {
        this.thickness = thickness;
        this.name = name;
        this.minPressure = minPressure;
        this.maxPressure = maxPressure;
        this.volume = volume;
    }

    @Override
    public float getThickness() {
        return this.thickness;
    }

    public double getMinPressure() {
        return this.minPressure;
    }

    public double getMaxPressure() {
        return this.maxPressure;
    }

    public double getVolume() {
        return this.volume;
    }

    @Nonnull
    @Override
    public PressurePipeData modifyProperties(PressurePipeData pipeData) {
        return new PressurePipeData(minPressure, maxPressure, volume);
    }

    @Override
    public boolean isPaintable() {
        return true;
    }

    @Nonnull
    @Override
    public String getName() {
        return name;
    }
}
