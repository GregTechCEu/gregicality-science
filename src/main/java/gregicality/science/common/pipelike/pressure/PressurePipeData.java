package gregicality.science.common.pipelike.pressure;

import gregicality.science.api.GCYSValues;

public class PressurePipeData {

    public static final PressurePipeData EMPTY = new PressurePipeData(GCYSValues.EARTH_PRESSURE, GCYSValues.EARTH_PRESSURE, 1.0);

    private final double minPressure;
    private final double maxPressure;
    private final double volume;

    public PressurePipeData(double minPressure, double maxPressure, double volume) {
        this.minPressure = minPressure;
        this.maxPressure = maxPressure;
        this.volume = volume;
    }

    public double getMinPressure() {
        return minPressure;
    }

    public double getMaxPressure() {
        return maxPressure;
    }

    public double getVolume() {
        return volume;
    }
}
