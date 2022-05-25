package gregicality.science.common.pipelike.axle;

import gregicality.science.api.capability.EnumRotation;

public class AxlePipeData {

    public static final AxlePipeData EMPTY = new AxlePipeData(32, 1, EnumRotation.NONE);

    private final long maxSpeed;
    private final int maxPower;
    private final EnumRotation rotation;

    public AxlePipeData(long maxSpeed, int maxPower, EnumRotation rotation) {
        this.maxSpeed = maxSpeed;
        this.maxPower = maxPower;
        this.rotation = rotation;
    }

    public long getMaxSpeed() {
        return maxSpeed;
    }

    public int getMaxPower() {
        return maxPower;
    }

    public EnumRotation getRotation() {
        return rotation;
    }
}
