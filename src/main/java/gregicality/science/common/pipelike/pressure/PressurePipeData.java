package gregicality.science.common.pipelike.pressure;

import gregicality.science.api.capability.IPressureContainer;

public class PressurePipeData {

    public static final PressurePipeData EMPTY = new PressurePipeData(IPressureContainer.ATMOSPHERIC_PRESSURE, IPressureContainer.ATMOSPHERIC_PRESSURE, 1000);

    private final double minPressure;
    private final double maxPressure;
    private final int maxVolume;

    public PressurePipeData(double minPressure, double maxPressure, int maxVolume) {
        this.minPressure = minPressure;
        this.maxPressure = maxPressure;
        this.maxVolume = maxVolume;
    }

    public double getMinPressure() {
        return minPressure;
    }

    public double getMaxPressure() {
        return maxPressure;
    }

    public int getMaxVolume() {
        return maxVolume;
    }
}
