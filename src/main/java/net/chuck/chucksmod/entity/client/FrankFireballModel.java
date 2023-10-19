package net.chuck.chucksmod.entity.client;

import net.chuck.chucksmod.entity.custom.FrankFireballEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.VertexConsumer;

// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class FrankFireballModel<T extends FrankFireballEntity> extends SinglePartEntityModel<T> {
	private final ModelPart bone;
	public FrankFireballModel(ModelPart root) {
		this.bone = root.getChild("bone");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData bone = modelPartData.addChild("bone", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -3.0F, -2.0F, 4.0F, 2.0F, 4.0F, new Dilation(0.0F))
		.uv(8, 7).cuboid(-1.0F, -1.0F, -2.0F, 2.0F, 1.0F, 4.0F, new Dilation(0.0F))
		.uv(0, 6).cuboid(-1.0F, -4.0F, -2.0F, 2.0F, 1.0F, 4.0F, new Dilation(0.0F))
		.uv(10, 12).cuboid(-2.0F, -4.0F, -1.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F))
		.uv(4, 12).cuboid(1.0F, -4.0F, -1.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F))
		.uv(12, 0).cuboid(1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 11).cuboid(-2.0F, -1.0F, -1.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
		return TexturedModelData.of(modelData, 32, 32);
	}
	@Override
	public void setAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		bone.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return bone;
	}
}