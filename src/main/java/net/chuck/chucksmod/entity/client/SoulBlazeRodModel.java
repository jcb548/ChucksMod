package net.chuck.chucksmod.entity.client;

import net.chuck.chucksmod.entity.custom.SoulBlazeRodEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class SoulBlazeRodModel<T extends SoulBlazeRodEntity> extends CustomSinglePartEntityModel<T> {
	public SoulBlazeRodModel(ModelPart root) {
		this.bone = root.getChild("bone");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData bone = modelPartData.addChild("bone", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData cube_r1 = bone.addChild("cube_r1", ModelPartBuilder.create().uv(0, 16).cuboid(-1.0F, -5.0F, -2.0F, 2.0F, 10.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 32, 32);
	}
	@Override
	public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
	}
	public void setHeadRotation(float yaw, float pitch) {
		this.bone.yaw = yaw * ((float)Math.PI / 180);
		this.bone.pitch = pitch * ((float)Math.PI / 180);
	}
}