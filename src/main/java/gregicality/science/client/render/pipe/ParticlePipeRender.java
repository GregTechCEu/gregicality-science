package gregicality.science.client.render.pipe;

import codechicken.lib.texture.TextureUtils;
import codechicken.lib.vec.uv.IconTransformation;
import gregicality.science.GregicalityScience;
import gregicality.science.client.render.GCYSTextures;
import gregicality.science.common.pipelike.particlepipe.ParticlePipeType;
import gregtech.api.pipenet.block.BlockPipe;
import gregtech.api.pipenet.block.IPipeType;
import gregtech.api.pipenet.tile.IPipeTile;
import gregtech.api.unification.material.Material;
import gregtech.client.renderer.pipe.PipeRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

@SideOnly(Side.CLIENT)
public class ParticlePipeRender extends PipeRenderer {

    public static final ParticlePipeRender INSTANCE = new ParticlePipeRender();
    private final Map<ParticlePipeType, TextureAtlasSprite> pipeTextures = new HashMap<>();

    public ParticlePipeRender() {
        super("gcys_particle_pipe", GCYSTextures.PARTICLE_PIPE_MODEL);
    }

    @Override
    public void registerIcons(TextureMap map) {
        for (ParticlePipeType type: ParticlePipeType.values()) {
            ResourceLocation location = new ResourceLocation(GregicalityScience.MODID, String.format("blocks/pipe/particle_%s", type.name));
            this.pipeTextures.put(type, map.registerSprite(location));
        }
    }

    @Override
    public void buildRenderer(PipeRenderContext renderContext, BlockPipe<?, ?, ?> blockPipe, @Nullable IPipeTile<?, ?> iPipeTile, IPipeType<?> pipeType, @Nullable Material material) {
        if (!(pipeType instanceof ParticlePipeType)) {
            return;
        }
        TextureAtlasSprite texture = this.pipeTextures.get(pipeType);
        renderContext.addOpenFaceRender(new IconTransformation((texture))).addSideRender(new IconTransformation((texture)));
    }

    @Override
    public TextureAtlasSprite getParticleTexture(IPipeType<?> pipeType, @Nullable Material material) {
        if (!(pipeType instanceof ParticlePipeType)) {
            return TextureUtils.getMissingSprite();
        }
        return pipeTextures.get(pipeType);
    }
}
