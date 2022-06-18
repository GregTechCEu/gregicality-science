package gregicality.science.client.render.handler;

import gregicality.science.api.GCYSValues;
import gregicality.science.common.entities.RocketEntity;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraft.client.renderer.entity.Render;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

@SideOnly(Side.CLIENT)
public class RocketRenderer extends Render<RocketEntity>{

    private static final ResourceLocation texture = new ResourceLocation(GCYSValues.MODID, "textures/entities/rocket.png");
    protected RocketModel model = new RocketModel();

    public RocketRenderer(RenderManager renderManagerIn){
        super(renderManagerIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(RocketEntity entity) {
        return texture;
    }

    @Override
    public void doRender(RocketEntity entity, double x, double y, double z, float entityYaw, float partialTicks) {
        GlStateManager.pushMatrix();
        this.setupTranslation(x, y, z);
        this.bindEntityTexture(entity);
        float scaleX = 0.0625F, scaleY = 0.0625F, scaleZ = 0.0625F;
        GlStateManager.scale(scaleX, scaleY, scaleZ);
        GlStateManager.rotate(180, 1.0F, 0.0F, 0.5F);
        this.model.render(entity, partialTicks, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F);
        GlStateManager.popMatrix();
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

    public void setupTranslation(double x, double y, double z) {
        GlStateManager.translate((float)x, (float)y + 2.F, (float)z);
    }

}
