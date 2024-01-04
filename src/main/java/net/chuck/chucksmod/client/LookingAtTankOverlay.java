package net.chuck.chucksmod.client;

import net.chuck.chucksmod.block.entity.fluid_tank.AbstractFluidTankBlockEntity;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.registry.Registries;
import net.minecraft.server.MinecraftServer;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;

import java.text.NumberFormat;

public class LookingAtTankOverlay implements HudRenderCallback {
    private static final NumberFormat nf = NumberFormat.getIntegerInstance();
    @Override
    public void onHudRender(DrawContext drawContext, float tickDelta) {
        MinecraftClient client = MinecraftClient.getInstance();
        HitResult lookingAt = client.crosshairTarget;
        if(lookingAt != null && lookingAt.getType() == HitResult.Type.BLOCK){
            if(client.world.getBlockEntity(((BlockHitResult)lookingAt).getBlockPos())
                    instanceof AbstractFluidTankBlockEntity fluidTank){
                //int width = client.getWindow().getScaledWidth();
                int height = client.getWindow().getScaledHeight();
                MutableText displayName = Text.translatable("block." +
                        Registries.FLUID.getId(fluidTank.fluidStorage.variant.getFluid()).toTranslationKey());
                drawContext.drawText(client.textRenderer, displayName, 2,
                        height-2*(2+client.textRenderer.fontHeight), 0xFFFFFF, true);
                MutableText amountString = Text.translatable("chucksmod.tooltip.liquid.amount.with.capacity",
                        nf.format(fluidTank.fluidStorage.amount), nf.format(fluidTank.fluidStorage.getCapacity()));
                drawContext.drawText(client.textRenderer, amountString, 2,
                        height-2-client.textRenderer.fontHeight, 0xFFFFFF, true);
            }
        }
    }
}
