package gregicality.science.common.pipelike.pressure;

import gregicality.science.api.capability.IPressureContainer;

public class PressurePipeData {

    public static final PressurePipeData EMPTY = new PressurePipeData(IPressureContainer.ATMOSPHERIC_PRESSURE);

    private final double maxPressure;

    public PressurePipeData(double maxPressure) {
        this.maxPressure = maxPressure;
    }

    public double getMaxPressure() {
        return maxPressure;
    }
}
