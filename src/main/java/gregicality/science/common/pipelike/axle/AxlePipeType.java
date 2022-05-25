package gregicality.science.common.pipelike.axle;

import gregicality.science.api.capability.EnumRotation;
import gregtech.api.pipenet.block.IPipeType;

import javax.annotation.Nonnull;

public enum AxlePipeType implements IPipeType<AxlePipeData> {
    NORMAL("normal", 0.5f, 32, 1);

    public final float thickness;
    public final String name;
    public final int speed;
    public final int power;

    AxlePipeType(String name, float thickness, int speed, int power) {
        this.thickness = thickness;
        this.name = name;
        this.speed = speed;
        this.power = power;
    }

    @Override
    public float getThickness() {
        return thickness;
    }

    public double getSpeed() {
        return speed;
    }

    public double getPower() {
        return power;
    }

    @Nonnull
    @Override
    public AxlePipeData modifyProperties(AxlePipeData pipeData) {
        return new AxlePipeData(speed, power, EnumRotation.NONE);
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
