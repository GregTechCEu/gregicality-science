package gregicality.science.client.render.pipe;

import codechicken.lib.vec.uv.IconTransformation;
import gregicality.science.GregicalityScience;
import gregicality.science.client.render.GCYSTextures;
import gregtech.api.pipenet.block.BlockPipe;
import gregtech.api.pipenet.block.IPipeType;
import gregtech.api.pipenet.tile.IPipeTile;
import gregtech.api.unification.material.Material;
import gregtech.client.renderer.pipe.PipeRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class AxlePipeRenderer extends PipeRenderer {

    public static final AxlePipeRenderer INSTANCE = new AxlePipeRenderer();

    private AxlePipeRenderer() {
        super("axle", new ResourceLocation(GregicalityScience.MODID, "axle"));
    }

    @Override
    public void registerIcons(TextureMap textureMap) {
    }

    @Override
    public void buildRenderer(PipeRenderContext pipeRenderContext, BlockPipe<?, ?, ?> blockPipe, @Nullable IPipeTile<?, ?> iPipeTile, IPipeType<?> iPipeType, @Nullable Material material) {
        pipeRenderContext.addOpenFaceRender(new IconTransformation(GCYSTextures.AXLE_OPEN))
                .addSideRender(new IconTransformation(GCYSTextures.AXLE_SIDE_VERTICAL));
    }

    @Override
    public TextureAtlasSprite getParticleTexture(IPipeType<?> iPipeType, @Nullable Material material) {
        return GCYSTextures.AXLE_OPEN;
    }
}
