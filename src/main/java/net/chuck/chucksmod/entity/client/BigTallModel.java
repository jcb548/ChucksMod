// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

package net.chuck.chucksmod.entity.client;

import net.chuck.chucksmod.entity.animation.BigTallAnimations;
import net.chuck.chucksmod.entity.animation.FarmabynAnimations;
import net.chuck.chucksmod.entity.custom.BigTallBoss;
import net.chuck.chucksmod.entity.custom.FarmabynEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.ModelWithArms;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Arm;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;

public class BigTallModel<T extends BigTallBoss> extends SinglePartEntityModel<T> {
	private final ModelPart bone;
	private final ModelPart head;
	public BigTallModel(ModelPart root) {
		this.bone = root.getChild("bone");
		this.head = bone.getChild("body").getChild("upper_body").getChild("head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData bone = modelPartData.addChild("bone", ModelPartBuilder.create(), ModelTransform.of(0.0F, 24.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		ModelPartData body = bone.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(-2.0F, 0.0F, 0.0F));

		ModelPartData legs = body.addChild("legs", ModelPartBuilder.create(), ModelTransform.pivot(2.0F, 0.0F, 0.0F));

		ModelPartData left_leg = legs.addChild("left_leg", ModelPartBuilder.create().uv(8, 4).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 16.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-1.0F, 14.0F, 1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.0F, -16.0F, 0.0F));

		ModelPartData right_leg = legs.addChild("right_leg", ModelPartBuilder.create().uv(0, 4).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 16.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-1.0F, 14.0F, 1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(3.0F, -16.0F, 0.0F));

		ModelPartData pelvis = legs.addChild("pelvis", ModelPartBuilder.create().uv(0, 42).cuboid(-4.0F, 0.0F, -1.0F, 8.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -18.0F, 0.0F));

		ModelPartData upper_body = body.addChild("upper_body", ModelPartBuilder.create(), ModelTransform.pivot(2.0F, -18.0F, 0.0F));

		ModelPartData torso = upper_body.addChild("torso", ModelPartBuilder.create().uv(0, 22).cuboid(-1.0F, -14.0F, -1.0F, 2.0F, 14.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData shoulders = upper_body.addChild("shoulders", ModelPartBuilder.create().uv(20, 34).cuboid(-4.0F, -2.0F, -1.0F, 8.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -14.0F, 0.0F));

		ModelPartData left_arm = shoulders.addChild("left_arm", ModelPartBuilder.create().uv(14, 20).cuboid(-2.0F, -1.0F, -1.0F, 2.0F, 13.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(0.0F, 11.0F, -1.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-3.0F, 11.0F, -1.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, -1.0F, 0.0F));

		ModelPartData right_arm = shoulders.addChild("right_arm", ModelPartBuilder.create().uv(16, 4).cuboid(0.0F, -1.0F, -1.0F, 2.0F, 13.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-1.0F, 11.0F, -1.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(2.0F, 11.0F, -1.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(4.0F, -1.0F, 0.0F));

		ModelPartData staff = right_arm.addChild("staff", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -1.0F, -19.0F, 2.0F, 2.0F, 40.0F, new Dilation(0.0F))
		.uv(30, 6).cuboid(-1.0F, -2.0F, -15.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(28, 0).cuboid(-1.0F, 1.0F, -15.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(24, 16).cuboid(-1.0F, 1.0F, 16.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(22, 0).cuboid(-1.0F, -2.0F, 16.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(33, 1).cuboid(1.0F, -1.0F, -15.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(32, 17).cuboid(-2.0F, -1.0F, -15.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(32, 8).cuboid(-2.0F, -1.0F, 16.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(8, 31).cuboid(1.0F, -1.0F, 16.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, 13.0F, 0.0F, 0.1309F, 0.0F, 0.0F));

		ModelPartData head = upper_body.addChild("head", ModelPartBuilder.create().uv(28, 27).cuboid(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-5.0F, -6.0F, -1.0F, 10.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(24, 6).cuboid(-5.0F, -11.0F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F))
		.uv(22, 22).cuboid(3.0F, -11.0F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -16.0F, 0.0F));

		ModelPartData left_eye = head.addChild("left_eye", ModelPartBuilder.create().uv(22, 18).cuboid(-2.0F, -2.0F, 0.0F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(22, 29).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(8, 28).cuboid(-1.0F, -2.0F, 2.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(30, 22).cuboid(-1.0F, -3.0F, 0.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F))
		.uv(30, 14).cuboid(-1.0F, 0.0F, 0.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, -11.0F, 1.0F, -0.3491F, 0.0F, 0.0F));

		ModelPartData right_eye = head.addChild("right_eye", ModelPartBuilder.create().uv(22, 2).cuboid(-2.0F, -2.0F, 0.0F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(8, 25).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(8, 22).cuboid(-1.0F, -2.0F, 2.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(30, 11).cuboid(-1.0F, -3.0F, 0.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F))
		.uv(24, 13).cuboid(-1.0F, 0.0F, 0.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, -11.0F, 1.0F, -0.3054F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 128, 128);
	}
	@Override
	public void setAngles(BigTallBoss entity, float limbSwing, float limbSwingAmount, float ageInTicks, float headYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(headYaw, headPitch);

		if(entity.isRunning())
			this.animateMovement(BigTallAnimations.RUN, limbSwing, limbSwingAmount, 2.0f, 2.5f);
		else
			this.animateMovement(BigTallAnimations.WALK, limbSwing, limbSwingAmount, 2.0f, 2.5f);

		this.updateAnimation(entity.idleAnimationState, BigTallAnimations.IDLE, ageInTicks, 1f);
		this.updateAnimation(entity.attackAnimationState, BigTallAnimations.ATTACK, ageInTicks, 1f);
		this.updateAnimation(entity.spinAnimationState, BigTallAnimations.SPIN, ageInTicks, 1f);
	}
	private void setHeadAngles(float headYaw, float headPitch){
		headYaw = MathHelper.clamp(headYaw, -30.0f, 30.0f);
		headPitch = MathHelper.clamp(headPitch, -25.0f, 45.0f);
		this.head.yaw = headYaw*0.017453292F;
		this.head.pitch = headPitch*0.017453292F;
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