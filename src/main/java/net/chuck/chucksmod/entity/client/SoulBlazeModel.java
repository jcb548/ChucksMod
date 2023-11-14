package net.chuck.chucksmod.entity.client;

import net.chuck.chucksmod.entity.animation.SoulBlazeAnimations;
import net.chuck.chucksmod.entity.custom.SoulBlazeBoss;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class SoulBlazeModel<T extends SoulBlazeBoss> extends SinglePartEntityModel<T> {
	private final ModelPart bone;
	private final ModelPart head;
	public SoulBlazeModel(ModelPart root) {
		this.bone = root.getChild("bone");
		this.head = bone.getChild("head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData bone = modelPartData.addChild("bone", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData head = bone.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -16.0F, 0.0F));

		ModelPartData upper_rods = bone.addChild("upper_rods", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -9.0F, 0.0F));

		ModelPartData rod8 = upper_rods.addChild("rod8", ModelPartBuilder.create().uv(0, 16).cuboid(-1.0F, -10.0F, -1.0F, 2.0F, 10.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.0F, -1.0F, -8.0F));

		ModelPartData rod7 = upper_rods.addChild("rod7", ModelPartBuilder.create().uv(0, 16).cuboid(-1.0F, -10.0F, -1.0F, 2.0F, 10.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(6.0F, 0.0F, 5.0F));

		ModelPartData rod6 = upper_rods.addChild("rod6", ModelPartBuilder.create().uv(0, 16).cuboid(-1.0F, -10.0F, -1.0F, 2.0F, 10.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(5.0F, 0.0F, -7.0F));

		ModelPartData rod5 = upper_rods.addChild("rod5", ModelPartBuilder.create().uv(0, 16).cuboid(-1.0F, -10.0F, -1.0F, 2.0F, 10.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-7.0F, 0.0F, -5.0F));

		ModelPartData rod4 = upper_rods.addChild("rod4", ModelPartBuilder.create().uv(0, 16).cuboid(-1.0F, -10.0F, -1.0F, 2.0F, 10.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-5.0F, 0.0F, 7.0F));

		ModelPartData rod3 = upper_rods.addChild("rod3", ModelPartBuilder.create().uv(0, 16).cuboid(-1.0F, -10.0F, -1.0F, 2.0F, 10.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-8.0F, -1.0F, 1.0F));

		ModelPartData rod2 = upper_rods.addChild("rod2", ModelPartBuilder.create().uv(0, 16).cuboid(-1.0F, -10.0F, -1.0F, 2.0F, 10.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(8.0F, -1.0F, -1.0F));

		ModelPartData rod1 = upper_rods.addChild("rod1", ModelPartBuilder.create().uv(0, 16).cuboid(-1.0F, -10.0F, -1.0F, 2.0F, 10.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(1.0F, -1.0F, 8.0F));

		ModelPartData lower_rods = bone.addChild("lower_rods", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData rod9 = lower_rods.addChild("rod9", ModelPartBuilder.create().uv(8, 16).cuboid(3.0F, -11.0F, -4.0F, 2.0F, 10.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, 0.0F, 0.0F));

		ModelPartData rod10 = lower_rods.addChild("rod10", ModelPartBuilder.create().uv(8, 16).cuboid(-4.0F, -11.0F, -3.0F, 2.0F, 10.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData rod11 = lower_rods.addChild("rod11", ModelPartBuilder.create().uv(8, 16).cuboid(-8.0F, -11.0F, 1.0F, 2.0F, 10.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(5.0F, 0.0F, 1.0F));

		ModelPartData rod12 = lower_rods.addChild("rod12", ModelPartBuilder.create().uv(8, 16).cuboid(-3.0F, -11.0F, -3.0F, 2.0F, 10.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(5.0F, 0.0F, 4.0F));
		return TexturedModelData.of(modelData, 32, 32);
	}
	@Override
	public void setAngles(SoulBlazeBoss entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw, headPitch);
		this.animateMovement(SoulBlazeAnimations.SOUL_BLAZE_MOVE, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, SoulBlazeAnimations.SOUL_BLAZE_IDLE, ageInTicks, 1);
		this.updateAnimation(entity.leftAttackAnimationState, SoulBlazeAnimations.SOUL_BLAZE_LEFT_MELEE_ATTACK, ageInTicks, 1f);
		this.updateAnimation(entity.rightAttackAnimationState, SoulBlazeAnimations.SOUL_BLAZE_RIGHT_MELEE_ATTACK, ageInTicks, 1f);
		this.updateAnimation(entity.shootAnimationState, SoulBlazeAnimations.SOUL_BLAZE_RANGED_ATTACK, ageInTicks, 1f);
	}
	private void setHeadAngles(float headYaw, float headPitch){
		headYaw = MathHelper.clamp(headYaw, -30.0f, 30.0f);
		headPitch = MathHelper.clamp(headPitch, -25.0f, 25.0f);
		this.head.yaw = headYaw * ((float)Math.PI/180);
		this.head.pitch = headPitch * ((float)Math.PI/180);
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