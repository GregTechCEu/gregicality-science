package gregicality.science.client.render.handler;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class RocketModel extends ModelBase {
	private final ModelRenderer body;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer tip_mid;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;
	private final ModelRenderer fairing;
	private final ModelRenderer cube_r9;
	private final ModelRenderer cube_r10;
	private final ModelRenderer cube_r11;
	private final ModelRenderer cube_r12;
	private final ModelRenderer tip_top;
	private final ModelRenderer cube_r13;
	private final ModelRenderer cube_r14;
	private final ModelRenderer cube_r15;
	private final ModelRenderer cube_r16;
	private final ModelRenderer engine;

	public RocketModel() {
		textureWidth = 512;
		textureHeight = 512;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0613F, -176.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 0, 0, -12.6863F, -272.0F, -8.0F, 32, 472, 16, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 96, 0, -8.0F, -272.0F, 3.3137F, 16, 472, 16, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 0, 0, -19.3137F, -272.0F, -8.0F, 32, 472, 16, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 96, 0, -8.0F, -272.0F, -19.3137F, 16, 472, 16, 0.0F, false));

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(-8.0F, 0.0F, -8.0F);
		body.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.7854F, 0.0F);
		cube_r1.cubeList.add(new ModelBox(cube_r1, 96, 0, -8.0F, -272.0F, -8.0F, 16, 472, 16, 0.0F, false));

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(-8.0F, 0.0F, 8.0F);
		body.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.7854F, 0.0F);
		cube_r2.cubeList.add(new ModelBox(cube_r2, 96, 0, -8.0F, -272.0F, -8.0F, 16, 472, 16, 0.0F, false));

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(8.0F, 0.0F, 8.0F);
		body.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 0.7854F, 0.0F);
		cube_r3.cubeList.add(new ModelBox(cube_r3, 96, 0, -8.0F, -272.0F, -8.0F, 16, 472, 16, 0.0F, false));

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(8.0F, 0.0F, -8.0F);
		body.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, 0.7854F, 0.0F);
		cube_r4.cubeList.add(new ModelBox(cube_r4, 96, 0, -8.0F, -272.0F, -8.0F, 16, 472, 16, 0.0F, false));

		tip_mid = new ModelRenderer(this);
		tip_mid.setRotationPoint(0.0F, -452.0F, 0.0647F);
		tip_mid.cubeList.add(new ModelBox(tip_mid, 160, 210, -6.0F, -4.0F, 2.4853F, 12, 8, 12, 0.0F, false));
		tip_mid.cubeList.add(new ModelBox(tip_mid, 160, 190, -5.5147F, -4.0F, -6.0F, 20, 8, 12, 0.0F, false));
		tip_mid.cubeList.add(new ModelBox(tip_mid, 160, 210, -6.0F, -4.0F, -14.4853F, 12, 8, 12, 0.0F, false));
		tip_mid.cubeList.add(new ModelBox(tip_mid, 160, 190, -14.4853F, -4.0F, -6.0F, 20, 8, 12, 0.0F, false));

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(-6.0F, 2.0F, 6.0F);
		tip_mid.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, 0.7854F, 0.0F);
		cube_r5.cubeList.add(new ModelBox(cube_r5, 160, 210, -6.0F, -6.0F, -6.0F, 12, 8, 12, 0.0F, false));

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(-6.0F, 2.0F, -6.0F);
		tip_mid.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0F, 0.7854F, 0.0F);
		cube_r6.cubeList.add(new ModelBox(cube_r6, 160, 210, -6.0F, -6.0F, -6.0F, 12, 8, 12, 0.0F, false));

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(6.0F, 2.0F, -6.0F);
		tip_mid.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.0F, 0.7854F, 0.0F);
		cube_r7.cubeList.add(new ModelBox(cube_r7, 160, 210, -6.0F, -6.0F, -6.0F, 12, 8, 12, 0.0F, false));

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(6.0F, 2.0F, 6.0F);
		tip_mid.addChild(cube_r8);
		setRotationAngle(cube_r8, 0.0F, 0.7854F, 0.0F);
		cube_r8.cubeList.add(new ModelBox(cube_r8, 160, 210, -6.0F, -6.0F, -6.0F, 12, 8, 12, 0.0F, false));

		fairing = new ModelRenderer(this);
		fairing.setRotationPoint(0.0F, -408.0F, -0.0079F);
		fairing.cubeList.add(new ModelBox(fairing, 160, 0, -10.0F, -32.0F, -24.1421F, 20, 64, 20, 0.0F, false));
		fairing.cubeList.add(new ModelBox(fairing, 160, 84, -24.1421F, -32.0F, -10.0F, 32, 64, 20, 0.0F, false));
		fairing.cubeList.add(new ModelBox(fairing, 160, 0, -10.0F, -32.0F, 4.1421F, 20, 64, 20, 0.0F, false));
		fairing.cubeList.add(new ModelBox(fairing, 160, 84, -7.8579F, -32.0F, -10.0F, 32, 64, 20, 0.0F, false));

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(10.0F, 0.0F, -10.0F);
		fairing.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.0F, 0.7854F, 0.0F);
		cube_r9.cubeList.add(new ModelBox(cube_r9, 160, 0, -10.0F, -32.0F, -10.0F, 20, 64, 20, 0.0F, false));

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(10.0F, 0.0F, 10.0F);
		fairing.addChild(cube_r10);
		setRotationAngle(cube_r10, 0.0F, 0.7854F, 0.0F);
		cube_r10.cubeList.add(new ModelBox(cube_r10, 160, 0, -10.0F, -32.0F, -10.0F, 20, 64, 20, 0.0F, false));

		cube_r11 = new ModelRenderer(this);
		cube_r11.setRotationPoint(-10.0F, 0.0F, 10.0F);
		fairing.addChild(cube_r11);
		setRotationAngle(cube_r11, 0.0F, 0.7854F, 0.0F);
		cube_r11.cubeList.add(new ModelBox(cube_r11, 160, 0, -10.0F, -32.0F, -10.0F, 20, 64, 20, 0.0F, false));

		cube_r12 = new ModelRenderer(this);
		cube_r12.setRotationPoint(-10.0F, 0.0F, -10.0F);
		fairing.addChild(cube_r12);
		setRotationAngle(cube_r12, 0.0F, 0.7854F, 0.0F);
		cube_r12.cubeList.add(new ModelBox(cube_r12, 160, 0, -10.0F, -32.0F, -10.0F, 20, 64, 20, 0.0F, false));

		tip_top = new ModelRenderer(this);
		tip_top.setRotationPoint(0.0F, -460.0F, 0.0069F);
		setRotationAngle(tip_top, 0.0F, 0.7854F, 0.0F);
		tip_top.cubeList.add(new ModelBox(tip_top, 80, 0, -4.0F, -4.0F, -9.6569F, 8, 8, 8, 0.0F, false));
		tip_top.cubeList.add(new ModelBox(tip_top, 80, 0, -9.6569F, -4.0F, -4.0F, 8, 8, 8, 0.0F, false));
		tip_top.cubeList.add(new ModelBox(tip_top, 80, 0, 1.6569F, -4.0F, -4.0F, 8, 8, 8, 0.0F, false));
		tip_top.cubeList.add(new ModelBox(tip_top, 80, 0, -4.0F, -4.0F, 1.6569F, 8, 8, 8, 0.0F, false));

		cube_r13 = new ModelRenderer(this);
		cube_r13.setRotationPoint(4.0F, 0.0F, 4.0F);
		tip_top.addChild(cube_r13);
		setRotationAngle(cube_r13, 0.0F, -0.7854F, 0.0F);
		cube_r13.cubeList.add(new ModelBox(cube_r13, 80, 0, -4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F, false));

		cube_r14 = new ModelRenderer(this);
		cube_r14.setRotationPoint(4.0F, 0.0F, -4.0F);
		tip_top.addChild(cube_r14);
		setRotationAngle(cube_r14, 0.0F, 0.7854F, 0.0F);
		cube_r14.cubeList.add(new ModelBox(cube_r14, 220, 4, -8.0F, -4.0F, -4.0F, 12, 8, 8, 0.0F, false));

		cube_r15 = new ModelRenderer(this);
		cube_r15.setRotationPoint(-4.0F, 0.0F, 4.0F);
		tip_top.addChild(cube_r15);
		setRotationAngle(cube_r15, 0.0F, -0.7854F, 0.0F);
		cube_r15.cubeList.add(new ModelBox(cube_r15, 244, 84, -4.0F, -4.0F, -8.0F, 8, 8, 12, 0.0F, false));

		cube_r16 = new ModelRenderer(this);
		cube_r16.setRotationPoint(-4.0F, 0.0F, -4.0F);
		tip_top.addChild(cube_r16);
		setRotationAngle(cube_r16, 0.0F, -0.7854F, 0.0F);
		cube_r16.cubeList.add(new ModelBox(cube_r16, 80, 0, -4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F, false));

		engine = new ModelRenderer(this);
		engine.setRotationPoint(0.0F, 24.0F, 0.0F);
		engine.cubeList.add(new ModelBox(engine, 160, 254, -8.0F, 0.0F, -8.0F, 16, 2, 16, 0.0F, false));
		engine.cubeList.add(new ModelBox(engine, 160, 170, -9.0F, 2.0F, -9.0F, 18, 2, 18, 0.0F, false));
		engine.cubeList.add(new ModelBox(engine, 160, 466, -10.0F, 4.0F, -10.0F, 20, 2, 20, 0.0F, false));
		engine.cubeList.add(new ModelBox(engine, 160, 230, -11.0F, 6.0F, -11.0F, 22, 2, 22, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		body.render(f5);
		tip_mid.render(f5);
		fairing.render(f5);
		tip_top.render(f5);
		engine.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
