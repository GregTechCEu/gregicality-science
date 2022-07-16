package gregicality.science.common.pipelike.pressure;

import gregicality.science.api.capability.IPressureContainer;

public class PressurePipeData {

    public static final PressurePipeData EMPTY = new PressurePipeData(IPressureContainer.ATMOSPHERIC_PRESSURE, IPressureContainer.ATMOSPHERIC_PRESSURE);

    private final double minPressure;
    private final double maxPressure;

    public PressurePipeData(double minPressure, double maxPressure) {
        this.minPressure = minPressure;
        this.maxPressure = maxPressure;
    }

    public double getMinPressure() {
        return minPressure;
    }

    public double getMaxPressure() {
        return maxPressure;
    }
}
