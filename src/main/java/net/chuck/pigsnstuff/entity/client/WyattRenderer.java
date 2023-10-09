package net.chuck.pigsnstuff.entity.client;

import net.chuck.pigsnstuff.PigsNStuff;
import net.chuck.pigsnstuff.entity.custom.WyattEntity;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
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

public class WyattRenderer extends MobEntityRenderer<WyattEntity, WyattModel<WyattEntity>> {
    private static final Identifier TEXTURE = new Identifier(PigsNStuff.MOD_ID, "textures/entity/wyatt.png");
    public WyattRenderer(EntityRendererFactory.Context context) {
        super(context, new WyattModel<>(context.getPart(ModModelLayers.WYATT)), 0.6f);
    }
    @Override
    public Identifier getTexture(WyattEntity entity) {
        return TEXTURE;
    }
    @Override
    public void render(WyattEntity entity, float entityYaw, float partialTick, MatrixStack poseStack,
                       VertexConsumerProvider bufferSource, int packedLight) {
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
