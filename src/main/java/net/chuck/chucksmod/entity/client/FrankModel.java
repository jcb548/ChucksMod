package net.chuck.chucksmod.entity.client;

import net.chuck.chucksmod.entity.animation.FrankAnimations;
import net.chuck.chucksmod.entity.custom.FrankBoss;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class FrankModel<T extends FrankBoss> extends CustomSinglePartEntityModel<T> {
	public FrankModel(ModelPart root) {
		this.bone = root.getChild("bone");
		this.head = bone.getChild("upper_body").getChild("head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData bone = modelPartData.addChild("bone", ModelPartBuilder.create(), ModelTransform.pivot(-6.0F, -2.0F, -1.0F));

		ModelPartData upper_body = bone.addChild("upper_body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData body = upper_body.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData main_body = body.addChild("main_body", ModelPartBuilder.create().uv(0, 16).cuboid(2.0F, 2.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData left_arm = body.addChild("left_arm", ModelPartBuilder.create(), ModelTransform.pivot(10.0F, 2.0F, 0.0F));

		ModelPartData left_arm_upper = left_arm.addChild("left_arm_upper", ModelPartBuilder.create().uv(36, 10).cuboid(0.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData left_arm_lower = left_arm.addChild("left_arm_lower", ModelPartBuilder.create().uv(32, 0).cuboid(10.0F, 8.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-10.0F, -2.0F, 0.0F));

		ModelPartData right_arm = body.addChild("right_arm", ModelPartBuilder.create(), ModelTransform.pivot(2.0F, 2.0F, 0.0F));

		ModelPartData right_arm_upper = right_arm.addChild("right_arm_upper", ModelPartBuilder.create().uv(16, 36).cuboid(-4.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData right_arm_lower = right_arm.addChild("right_arm_lower", ModelPartBuilder.create().uv(0, 32).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, 6.0F, 0.0F));

		ModelPartData head = upper_body.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(6.0F, 2.0F, 0.0F));

		ModelPartData legs = bone.addChild("legs", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData right_leg = legs.addChild("right_leg", ModelPartBuilder.create(), ModelTransform.pivot(4.0F, 14.0F, 0.0F));

		ModelPartData right_leg_upper = right_leg.addChild("right_leg_upper", ModelPartBuilder.create().uv(40, 20).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData right_leg_lower = right_leg.addChild("right_leg_lower", ModelPartBuilder.create().uv(24, 16).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 6.0F, 0.0F));

		ModelPartData left_leg = legs.addChild("left_leg", ModelPartBuilder.create(), ModelTransform.pivot(8.0F, 14.0F, 0.0F));

		ModelPartData left_leg_upper = left_leg.addChild("left_leg_upper", ModelPartBuilder.create().uv(32, 36).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData left_leg_lower = left_leg.addChild("left_leg_lower", ModelPartBuilder.create().uv(24, 26).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 6.0F, 0.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public void setAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw, headPitch);
		this.animateMovement(FrankAnimations.WALK, limbSwing, limbSwingAmount, 2f, 2f);
		this.updateAnimation(entity.idleAnimationState, FrankAnimations.IDLE, ageInTicks);
		this.updateAnimation(entity.attackingAnimationState, FrankAnimations.THROW_FIREBALL, ageInTicks);
	}
}