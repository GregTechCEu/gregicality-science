package gregicality.science.common.pipelike.particlepipe;

import gregicality.science.common.pipelike.particlepipe.net.ParticleNodeData;
import gregtech.api.pipenet.block.IPipeType;

import javax.annotation.Nonnull;

public enum ParticlePipeType implements IPipeType<ParticleNodeData> {
    NORMAL("normal", 0.5F);

    public final String name;
    private final float thickness;

    ParticlePipeType(String name, float thickness) {
        this.name = name;
        this.thickness = thickness;
    }

    @Override
    public float getThickness() {
        return thickness;
    }

    @Override
    public ParticleNodeData modifyProperties(ParticleNodeData baseNodeData) {
        return baseNodeData;
    }

    @Override
    public boolean isPaintable() {
        return false;
    }

    @Override
    @Nonnull
    public String getName() {
        return name;
    }
}
