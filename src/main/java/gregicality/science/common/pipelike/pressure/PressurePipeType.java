package gregicality.science.common.pipelike.pressure;

import gregicality.science.api.capability.IPressureContainer;
import gregtech.api.pipenet.block.IPipeType;

public enum PressurePipeType implements IPipeType<PressurePipeData> {
    NORMAL("normal", 0.5f, IPressureContainer.ATMOSPHERIC_PRESSURE * 10);

    public final float thickness;
    public final String name;
    public final double maxPressure;

    PressurePipeType(String name, float thickness, double maxPressure) {
        this.thickness = thickness;
        this.name = name;
        this.maxPressure = maxPressure;
    }

    @Override
    public float getThickness() {
        return thickness;
    }

    public double getMaxPressure() {
        return maxPressure;
    }

    @Override
    public PressurePipeData modifyProperties(PressurePipeData pipeData) {
        return new PressurePipeData(maxPressure);
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
