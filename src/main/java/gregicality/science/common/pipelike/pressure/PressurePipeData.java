package gregicality.science.common.pipelike.pressure;

import gregicality.science.api.GCYSValues;

public class PressurePipeData {

    public static final PressurePipeData EMPTY = new PressurePipeData(GCYSValues.EARTH_ATMOSPHERIC_PRESSURE, GCYSValues.EARTH_ATMOSPHERIC_PRESSURE, 1000);

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
