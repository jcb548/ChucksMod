package net.chuck.chucksmod.entity.client;
import dev.architectury.platform.Mod;
import net.chuck.chucksmod.entity.animation.FarmabynAnimations;
import net.chuck.chucksmod.entity.animation.PippinAnimations;
import net.chuck.chucksmod.entity.custom.PippinBoss;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.render.entity.model.ModelWithArms;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Arm;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;

// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class PippinModel <T extends PippinBoss> extends SinglePartEntityModel<T> implements ModelWithArms {
	private final ModelPart bone;
	private final ModelPart head;
	private final ModelPart rightArm;
	private final ModelPart torso;
	public PippinModel(ModelPart root) {
		this.bone = root.getChild("bone");
		this.head = bone.getChild("body").getChild("head");
		this.torso = bone.getChild("body").getChild("torso");
		this.rightArm = torso.getChild("right_arm");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData bone = modelPartData.addChild("bone", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData legs = bone.addChild("legs", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData left_leg = legs.addChild("left_leg", ModelPartBuilder.create(), ModelTransform.pivot(1.0F, -8.0F, 0.0F));

		ModelPartData left_leg_upper = left_leg.addChild("left_leg_upper", ModelPartBuilder.create().uv(27, 7).cuboid(1.0F, 0.0F, -2.0F, 3.0F, 4.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, 0.0F, 0.0F));

		ModelPartData left_leg_lower = left_leg.addChild("left_leg_lower", ModelPartBuilder.create().uv(24, 26).cuboid(-1.0F, 0.0F, -2.0F, 3.0F, 4.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 4.0F, 0.0F));

		ModelPartData right_leg = legs.addChild("right_leg", ModelPartBuilder.create(), ModelTransform.pivot(-1.0F, -8.0F, 0.0F));

		ModelPartData right_leg_upper = right_leg.addChild("right_leg_upper", ModelPartBuilder.create().uv(0, 23).cuboid(-4.0F, 0.0F, -2.0F, 3.0F, 4.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, 0.0F, 0.0F));

		ModelPartData right_leg_lower = right_leg.addChild("right_leg_lower", ModelPartBuilder.create().uv(12, 26).cuboid(-2.0F, 0.0F, -2.0F, 3.0F, 4.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 4.0F, 0.0F));

		ModelPartData body = bone.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -8.0F, 0.0F));

		ModelPartData torso = body.addChild("torso", ModelPartBuilder.create().uv(0, 12).cuboid(-3.0F, -8.0F, -2.0F, 6.0F, 8.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData right_arm = torso.addChild("right_arm", ModelPartBuilder.create(), ModelTransform.pivot(-3.0F, -8.0F, 0.0F));

		ModelPartData right_arm_upper = right_arm.addChild("right_arm_upper", ModelPartBuilder.create().uv(39, 0).cuboid(-4.0F, 0.0F, -2.0F, 3.0F, 8.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(1.0F, 0.0F, 0.0F));

		ModelPartData left_arm = torso.addChild("left_arm", ModelPartBuilder.create(), ModelTransform.pivot(3.0F, -8.0F, 0.0F));

		ModelPartData left_arm_upper = left_arm.addChild("left_arm_upper", ModelPartBuilder.create().uv(18, 12).cuboid(-4.0F, 0.0F, -2.0F, 3.0F, 8.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(4.0F, 0.0F, 0.0F));

		ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -6.0F, -3.0F, 6.0F, 6.0F, 6.0F, new Dilation(0.0F))
				.uv(22, 33).cuboid(-2.0F, -2.0F, -4.0F, 4.0F, 2.0F, 1.0F, new Dilation(0.0F))
				.uv(0, 4).cuboid(-1.0F, -3.0F, -4.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -8.0F, 0.0F));

		ModelPartData jaw = head.addChild("jaw", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 16.0F, 1.0F));

		ModelPartData upper_jaw = jaw.addChild("upper_jaw", ModelPartBuilder.create().uv(13, 34).cuboid(-1.0F, -1.0F, -2.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -17.0F, -5.0F));

		ModelPartData lower_jaw = jaw.addChild("lower_jaw", ModelPartBuilder.create().uv(31, 23).cuboid(-1.0F, 0.0F, -2.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -17.0F, -5.0F));

		ModelPartData left_ear = head.addChild("left_ear", ModelPartBuilder.create().uv(30, 14).cuboid(-2.0F, -2.0F, -1.0F, 4.0F, 3.0F, 1.0F, new Dilation(0.0F))
				.uv(0, 2).cuboid(-1.0F, -3.0F, -1.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, -6.0F, 1.0F, 0.5672F, 0.0F, 0.7854F));

		ModelPartData right_ear = head.addChild("right_ear", ModelPartBuilder.create().uv(30, 18).cuboid(-2.0F, -2.0F, -1.0F, 4.0F, 3.0F, 1.0F, new Dilation(0.0F))
				.uv(1, 0).cuboid(-1.0F, -3.0F, -1.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, -6.0F, 1.0F, 0.5672F, 0.0F, -0.7854F));
		return TexturedModelData.of(modelData, 64, 64);
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		bone.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return bone;
	}

	@Override
	public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(headYaw, headPitch);
		this.animateMovement(PippinAnimations.WALK, limbAngle, limbDistance, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, PippinAnimations.IDLE, animationProgress, 1f);
		this.updateAnimation(entity.attackAnimationState, PippinAnimations.ATTACK, animationProgress, 1f);
	}
	private void setHeadAngles(float headYaw, float headPitch){
		headYaw = MathHelper.clamp(headYaw, -30.0f, 30.0f);
		headPitch = MathHelper.clamp(headPitch, -25.0f, 45.0f);
		this.head.yaw = headYaw*0.017453292F;
		this.head.pitch = headPitch*0.017453292F;
	}
	@Override
	public void setArmAngle(Arm arm, MatrixStack matrices) {
		ModelPart modelPart = getArm();
		modelPart.pivotX += 1.0f;
		modelPart.setAngles(modelPart.pitch+torso.pitch, modelPart.yaw+ torso.yaw,modelPart.roll+torso.roll);
		matrices.translate(-0.12f, 0.9f, 0);
		matrices.scale(0.8f, 0.8f, 0.8f);
		modelPart.rotate(matrices);
		modelPart.pivotX -= 1.0f;
	}
	protected ModelPart getArm(){
		return rightArm;
	}
}