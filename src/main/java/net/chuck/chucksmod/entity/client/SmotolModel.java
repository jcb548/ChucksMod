// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

package net.chuck.chucksmod.entity.client;

import net.chuck.chucksmod.entity.animation.SmotolAnimations;
import net.chuck.chucksmod.entity.custom.SmotolEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class SmotolModel<T extends SmotolEntity> extends CustomSinglePartEntityModel<T> {
	public SmotolModel(ModelPart root) {
		this.bone = root.getChild("bone");
		this.head = bone.getChild("torso").getChild("head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData bone = modelPartData.addChild("bone", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData legs = bone.addChild("legs", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -9.0F, 0.0F));

		ModelPartData left_leg = legs.addChild("left_leg", ModelPartBuilder.create().uv(0, 17).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, 2.0F, 0.0F));

		ModelPartData right_leg = legs.addChild("right_leg", ModelPartBuilder.create().uv(16, 0).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, 2.0F, 0.0F));

		ModelPartData torso = bone.addChild("torso", ModelPartBuilder.create().uv(0, 4).cuboid(-3.0F, 0.0F, -1.0F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(-3.0F, -9.0F, -1.0F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(14, 15).cuboid(-1.0F, -7.0F, -1.0F, 2.0F, 7.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.0F, 0.0F));

		ModelPartData left_arm = torso.addChild("left_arm", ModelPartBuilder.create().uv(8, 8).cuboid(0.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(3.0F, -9.0F, 0.0F));

		ModelPartData heldItem = left_arm.addChild("heldItem", ModelPartBuilder.create().uv(0, 28).mirrored().cuboid(-0.5F, 0.0F, -11.0F, 1.0F, 1.0F, 13.0F, new Dilation(0.0F)).mirrored(false)
				.uv(0, 42).cuboid(-0.5F, -1.0F, -10.0F, 1.0F, 1.0F, 7.0F, new Dilation(0.0F))
				.uv(0, 50).cuboid(0.5F, 0.0F, -10.0F, 1.0F, 1.0F, 7.0F, new Dilation(0.0F))
				.uv(16, 42).cuboid(-0.5F, 1.0F, -10.0F, 1.0F, 1.0F, 7.0F, new Dilation(0.0F))
				.uv(16, 50).cuboid(-1.5F, 0.0F, -10.0F, 1.0F, 1.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, 6.0F, 0.0F, 0.2618F, 0.0F, 0.0F));

		ModelPartData right_arm = torso.addChild("right_arm", ModelPartBuilder.create().uv(0, 8).cuboid(-2.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.0F, -9.0F, 0.0F));

		ModelPartData head = torso.addChild("head", ModelPartBuilder.create().uv(16, 9).cuboid(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F))
				.uv(24, 0).cuboid(-1.0F, -4.0F, -2.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F))
				.uv(22, 21).cuboid(-1.0F, -4.0F, 1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F))
				.uv(22, 17).cuboid(-2.0F, -4.0F, -1.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(22, 13).cuboid(1.0F, -4.0F, -1.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(22, 7).cuboid(-1.0F, -5.0F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.0F, 0.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}
	@Override
	public void setAngles(SmotolEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(headYaw, headPitch);
		this.animateMovement(SmotolAnimations.MOVE, limbAngle, limbDistance, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, SmotolAnimations.IDLE, animationProgress, 1f);
		this.updateAnimation(entity.attackAnimationState, SmotolAnimations.ATTACK, animationProgress, 1f);
	}
}