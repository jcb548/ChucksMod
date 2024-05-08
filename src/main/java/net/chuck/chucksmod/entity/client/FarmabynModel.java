package net.chuck.chucksmod.entity.client;

import net.chuck.chucksmod.entity.animation.FarmabynAnimations;
import net.chuck.chucksmod.entity.custom.FarmabynEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.ModelWithArms;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Arm;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;


// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class FarmabynModel<T extends FarmabynEntity> extends CustomSinglePartEntityModel<T> {
	public FarmabynModel(ModelPart root) {
		this.bone = root.getChild("bone");
		this.head = bone.getChild("upper_body").getChild("head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData bone = modelPartData.addChild("bone", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData legs = bone.addChild("legs", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -12.0F, 0.0F));

		ModelPartData left = legs.addChild("left", ModelPartBuilder.create(), ModelTransform.pivot(2.0F, 0.0F, 0.0F));

		ModelPartData left_upper = left.addChild("left_upper", ModelPartBuilder.create().uv(32, 4).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData left_lower = left.addChild("left_lower", ModelPartBuilder.create().uv(20, 25).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 6.0F, 0.0F));

		ModelPartData right = legs.addChild("right", ModelPartBuilder.create(), ModelTransform.pivot(-2.0F, 0.0F, 0.0F));

		ModelPartData right_upper = right.addChild("right_upper", ModelPartBuilder.create().uv(32, 4).cuboid(-2.0F, -6.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 6.0F, 0.0F));

		ModelPartData right_lower = right.addChild("right_lower", ModelPartBuilder.create().uv(20, 25).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 6.0F, 0.0F));

		ModelPartData upper_body = bone.addChild("upper_body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -12.0F, 0.0F));

		ModelPartData head = upper_body.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -12.0F, 0.0F));

		ModelPartData hat = head.addChild("hat", ModelPartBuilder.create().uv(0, 50).cuboid(-4.0F, -32.0F, -5.0F, 8.0F, 3.0F, 1.0F, new Dilation(0.0F))
		.uv(42, 40).cuboid(4.0F, -32.0F, -4.0F, 1.0F, 3.0F, 8.0F, new Dilation(0.0F))
		.uv(24, 42).cuboid(-5.0F, -32.0F, -4.0F, 1.0F, 3.0F, 8.0F, new Dilation(0.0F))
		.uv(0, 16).cuboid(-4.0F, -33.0F, -4.0F, 8.0F, 1.0F, 8.0F, new Dilation(0.0F))
		.uv(46, 17).cuboid(-4.0F, -30.0F, -7.0F, 8.0F, 1.0F, 2.0F, new Dilation(0.0F))
		.uv(46, 14).cuboid(-4.0F, -30.0F, 5.0F, 8.0F, 1.0F, 2.0F, new Dilation(0.0F))
		.uv(12, 41).cuboid(-7.0F, -30.0F, -4.0F, 2.0F, 1.0F, 8.0F, new Dilation(0.0F))
		.uv(0, 19).cuboid(-6.0F, -30.0F, 4.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 16).cuboid(4.0F, -30.0F, 4.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 3).cuboid(4.0F, -30.0F, -6.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-6.0F, -30.0F, -6.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 39).cuboid(5.0F, -30.0F, -4.0F, 2.0F, 1.0F, 8.0F, new Dilation(0.0F))
		.uv(46, 32).cuboid(-4.0F, -32.0F, 4.0F, 8.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData main = upper_body.addChild("main", ModelPartBuilder.create().uv(0, 25).cuboid(-4.0F, -12.0F, -1.0F, 8.0F, 12.0F, 2.0F, new Dilation(0.0F))
		.uv(48, 0).cuboid(-4.0F, -12.0F, 1.0F, 8.0F, 6.0F, 1.0F, new Dilation(0.0F))
		.uv(48, 7).cuboid(-4.0F, -12.0F, -2.0F, 8.0F, 5.0F, 1.0F, new Dilation(0.0F))
		.uv(50, 24).cuboid(-2.0F, -5.0F, 1.0F, 4.0F, 5.0F, 1.0F, new Dilation(0.0F))
		.uv(50, 22).cuboid(-3.0F, -6.0F, 1.0F, 6.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(50, 20).cuboid(-3.0F, -7.0F, -2.0F, 6.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(24, 16).cuboid(-2.0F, -6.0F, -2.0F, 4.0F, 6.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData body = upper_body.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 12.0F, 0.0F));

		ModelPartData arms = body.addChild("arms", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData right2 = arms.addChild("right2", ModelPartBuilder.create().uv(36, 16).cuboid(-2.5F, 0.0F, -2.0F, 3.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.5F, -24.0F, 0.0F));

		ModelPartData left2 = arms.addChild("left2", ModelPartBuilder.create().uv(36, 32).cuboid(0.0F, 0.0F, -2.0F, 3.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(4.0F, -24.0F, 0.0F));
		return TexturedModelData.of(modelData, 128, 128);
	}
	@Override
	public void setAngles(FarmabynEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(headYaw, headPitch);
		this.animateMovement(FarmabynAnimations.FARMABYAN_WALK, limbAngle, limbDistance, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, FarmabynAnimations.FARMABYAN_IDLE, animationProgress, 1f);
		this.updateAnimation(entity.attackAnimationState, FarmabynAnimations.FARMABYAN_ATTACK, animationProgress, 1f);
	}
}