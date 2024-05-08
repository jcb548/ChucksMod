package net.chuck.chucksmod.entity.client;

import net.chuck.chucksmod.entity.animation.FarmabynAnimations;
import net.chuck.chucksmod.entity.animation.TriafianPigAnimations;
import net.chuck.chucksmod.entity.custom.TriafianPigEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class TriafianPigModel <T extends TriafianPigEntity> extends CustomSinglePartEntityModel<T> {
	public TriafianPigModel(ModelPart root) {
		this.bone = root.getChild("bone");
		this.head = bone.getChild("body").getChild("head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData bone = modelPartData.addChild("bone", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData body = bone.addChild("body", ModelPartBuilder.create().uv(12, 16).cuboid(-5.0F, -14.0F, -8.0F, 10.0F, 8.0F, 16.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData head = body.addChild("head", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -8.0F, -6.0F));

		ModelPartData upper_jaw = head.addChild("upper_jaw", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -6.0F, -8.0F, 8.0F, 6.0F, 8.0F, new Dilation(0.0F))
		.uv(16, 16).cuboid(-2.0F, -2.0F, -9.0F, 4.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -2.0F, 0.0F));

		ModelPartData lower_jaw = head.addChild("lower_jaw", ModelPartBuilder.create().uv(32, 0).cuboid(-4.0F, 0.0F, -8.0F, 8.0F, 2.0F, 8.0F, new Dilation(0.0F))
		.uv(16, 19).cuboid(-2.0F, 0.0F, -9.0F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -2.0F, 0.0F));

		ModelPartData front_legs = body.addChild("front_legs", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData front_right_leg = front_legs.addChild("front_right_leg", ModelPartBuilder.create().uv(0, 16).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(3.0F, -6.0F, -5.0F));

		ModelPartData front_left_leg = front_legs.addChild("front_left_leg", ModelPartBuilder.create().uv(0, 16).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.0F, -6.0F, -5.0F));

		ModelPartData rear_legs = body.addChild("rear_legs", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData rear_right_leg = rear_legs.addChild("rear_right_leg", ModelPartBuilder.create().uv(0, 16).cuboid(4.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.0F, -6.0F, 7.0F));

		ModelPartData rear_left_leg = rear_legs.addChild("rear_left_leg", ModelPartBuilder.create().uv(0, 16).cuboid(-8.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(3.0F, -6.0F, 7.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}
	@Override
	public void setAngles(TriafianPigEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(headYaw, headPitch);
		this.animateMovement(TriafianPigAnimations.WALK, limbAngle, limbDistance, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, TriafianPigAnimations.IDLE, animationProgress, 1f);
		this.updateAnimation(entity.attackAnimationState, TriafianPigAnimations.BITE, animationProgress, 1f);
	}
}