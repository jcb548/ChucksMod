package net.chuck.pigsnstuff.entity.custom.client;

import net.chuck.pigsnstuff.PigsNStuff;
import net.chuck.pigsnstuff.entity.custom.WyattEntity;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.layer.ItemArmorGeoLayer;

import java.util.Arrays;

public class WyattRenderer extends GeoEntityRenderer<WyattEntity> {
    private static final String HEAD = "head";
    private static final String BODY = "main_body";
    private static final String LEFT_ARM = "left_arm";
    private static final String RIGHT_ARM = "right_arm";
    private static final String LEFT_LEG = "left_leg";
    private static final String LEFT_LEG_UPPER = "left_thigh";
    private static final String RIGHT_LEG = "right_leg";
    private static final String RIGHT_LEG_UPPER = "right_thigh";
    private static final String LEFT_FOOT = "left_foot";
    private static final String RIGHT_FOOT = "right_foot";
    public WyattRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new WyattModel());
        addRenderLayer(new ItemArmorGeoLayer<>(this){
            @Nullable
            @Override
            protected ItemStack getArmorItemForBone(GeoBone bone, WyattEntity animatable) {
                return switch (bone.getName()){
                    case LEFT_FOOT, RIGHT_FOOT -> this.bootsStack;
                    case LEFT_LEG_UPPER, RIGHT_LEG_UPPER -> this.leggingsStack;
                    case LEFT_ARM, RIGHT_ARM, BODY -> this.chestplateStack;
                    case HEAD -> this.helmetStack;
                    default -> null;
                };
            }

            @Override
            protected @NotNull EquipmentSlot getEquipmentSlotForBone(GeoBone bone, ItemStack stack, WyattEntity animatable) {
                return switch (bone.getName()){
                    case LEFT_FOOT, RIGHT_FOOT -> EquipmentSlot.FEET;
                    case LEFT_LEG_UPPER, RIGHT_LEG_UPPER -> EquipmentSlot.LEGS;
                    case LEFT_ARM, RIGHT_ARM, BODY -> EquipmentSlot.CHEST;
                    case HEAD -> EquipmentSlot.HEAD;
                    default -> null;
                };
            }

            @Override
            protected @NotNull ModelPart getModelPartForBone(GeoBone bone, EquipmentSlot slot, ItemStack stack, WyattEntity animatable, BipedEntityModel<?> baseModel) {
                return switch (bone.getName()){
                    case LEFT_LEG, LEFT_FOOT, LEFT_LEG_UPPER -> baseModel.leftLeg;
                    case RIGHT_LEG, RIGHT_FOOT, RIGHT_LEG_UPPER -> baseModel.rightLeg;
                    case LEFT_ARM -> baseModel.leftArm;
                    case RIGHT_ARM -> baseModel.rightArm;
                    case BODY -> baseModel.body;
                    case HEAD -> baseModel.head;
                    default -> super.getModelPartForBone(bone, slot, stack, animatable, baseModel);
                };
            }
        });
    }

    @Override
    public Identifier getTextureLocation(WyattEntity animatable) {
        return new Identifier(PigsNStuff.MOD_ID, "textures/entity/wyatt.png");
    }

    @Override
    public void render(WyattEntity entity, float entityYaw, float partialTick, MatrixStack poseStack,
                       VertexConsumerProvider bufferSource, int packedLight) {
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
