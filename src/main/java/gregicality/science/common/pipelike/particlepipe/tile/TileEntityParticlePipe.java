package gregicality.science.common.pipelike.particlepipe.tile;

import gregicality.science.common.pipelike.particlepipe.ParticlePipeType;
import gregicality.science.common.pipelike.particlepipe.net.ParticleNodeData;
import gregtech.api.pipenet.tile.TileEntityPipeBase;

public class TileEntityParticlePipe extends TileEntityPipeBase<ParticlePipeType, ParticleNodeData> {

    // TODO do this, (base off of Item Pipes)
    @Override
    public Class<ParticlePipeType> getPipeTypeClass() {
        return ParticlePipeType.class;
    }

    @Override
    public boolean supportsTicking() {
        return false;
    }

    @Override
    public long getTickTimer() {
        return super.getTickTimer();
    }

    @Override
    public boolean canHaveBlockedFaces() {
        return super.canHaveBlockedFaces();
    }
}
