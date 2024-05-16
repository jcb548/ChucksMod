// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

package net.chuck.chucksmod.entity.client;
import net.chuck.chucksmod.entity.animation.TriafianCowAnimations;
import net.chuck.chucksmod.entity.custom.TriafianCowEntity;
import net.minecraft.client.model.*;

public class TriafianCowModel <T extends TriafianCowEntity> extends CustomSinglePartEntityModel<T> {
	public TriafianCowModel(ModelPart root) {
		this.bone = root.getChild("body");
		this.head = bone.getChild("head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-6.0F, -10.0F, -15.0F, 12.0F, 10.0F, 18.0F, new Dilation(0.0F))
		.uv(42, 0).cuboid(-2.0F, 0.0F, -3.0F, 4.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 12.0F, 7.0F));

		ModelPartData right_rear_leg = body.addChild("right_rear_leg", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, 0.0F, 0.0F));

		ModelPartData left_rear_leg = body.addChild("left_rear_leg", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(4.0F, 0.0F, 0.0F));

		ModelPartData right_front_leg = body.addChild("right_front_leg", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, 0.0F, -13.0F));

		ModelPartData left_front_leg = body.addChild("left_front_leg", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(4.0F, 0.0F, -13.0F));

		ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(0, 28).cuboid(-3.0F, -5.0F, -6.0F, 6.0F, 6.0F, 6.0F, new Dilation(0.0F))
		.uv(42, 7).cuboid(-2.0F, -3.0F, -9.0F, 4.0F, 4.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -7.0F, -15.0F));

		ModelPartData left_ear = head.addChild("left_ear", ModelPartBuilder.create().uv(12, 40).cuboid(3.0F, -24.0F, -9.0F, 4.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 28).cuboid(4.0F, -25.0F, -9.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(10, 16).cuboid(4.0F, -22.0F, -9.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 20.0F, 7.0F));

		ModelPartData right_ear = head.addChild("right_ear", ModelPartBuilder.create().uv(18, 28).cuboid(3.0F, -24.0F, -9.0F, 4.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(12, 2).cuboid(4.0F, -25.0F, -9.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(12, 0).cuboid(4.0F, -22.0F, -9.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-10.0F, 20.0F, 7.0F));

		ModelPartData right_horn = head.addChild("right_horn", ModelPartBuilder.create().uv(0, 30).cuboid(-7.0F, -3.0F, 0.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 16).cuboid(-7.0F, -1.0F, 0.0F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -4.0F, -4.0F, 0.3054F, 0.0F, 0.0F));

		ModelPartData left_horn = head.addChild("left_horn", ModelPartBuilder.create().uv(42, 14).cuboid(3.0F, -1.0F, 0.0F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(6.0F, -3.0F, 0.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -4.0F, -4.0F, 0.3054F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}
	@Override
	public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(headYaw, headPitch);
		this.animateMovement(TriafianCowAnimations.WALK, limbAngle, limbDistance, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, TriafianCowAnimations.IDLE, animationProgress, 1f);
		this.updateAnimation(entity.attackAnimationState, TriafianCowAnimations.HEADBUTT, animationProgress, 1f);
	}
}