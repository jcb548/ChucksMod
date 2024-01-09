package net.chuck.chucksmod.client;

import net.chuck.chucksmod.block.entity.EnergyStoring;
import net.chuck.chucksmod.block.entity.FluidStoring;
import net.chuck.chucksmod.networking.ModMessages;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.registry.Registries;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;

import java.text.NumberFormat;

public class LookingAtBlockOverlay implements HudRenderCallback {
    private static final NumberFormat nf = NumberFormat.getIntegerInstance();
    @Override
    public void onHudRender(DrawContext drawContext, float tickDelta) {
        MinecraftClient client = MinecraftClient.getInstance();
        HitResult lookingAt = client.crosshairTarget;
        //int width = client.getWindow().getScaledWidth();
        int height = client.getWindow().getScaledHeight();
        if(lookingAt != null && lookingAt.getType() == HitResult.Type.BLOCK){
            BlockPos pos = ((BlockHitResult)lookingAt).getBlockPos();
            int offset = 0;
            if(client.world.getBlockEntity(pos)
                    instanceof FluidStoring fluidStoring){
                updateClientfluidStoring(fluidStoring, pos);
                drawInfo(drawContext, client, Text.translatable("block." + Registries.FLUID
                                .getId(fluidStoring.getFluidStorage().variant.getFluid()).toTranslationKey()),
                        height, fluidStoring.getFluidStorage().getAmount(),
                        fluidStoring.getFluidStorage().getCapacity(),
                        "chucksmod.tooltip.liquid.amount.with.capacity", offset);
                offset += 2*(client.textRenderer.fontHeight+1);
            }
            if(client.world.getBlockEntity(pos)
                    instanceof EnergyStoring energyStoring){
                updateClientEnergyStorage(energyStoring.getEnergyStorage().getAmount(), pos);
                drawInfo(drawContext, client, client.world.getBlockState(pos).getBlock().getName(), height,
                        energyStoring.getEnergyStorage().getAmount(), energyStoring.getEnergyStorage().getCapacity(),
                        "chucksmod.tooltip.energy.amount.with.capacity", offset);
            }
        }
    }
    private void drawInfo(DrawContext drawContext, MinecraftClient client, MutableText displayName,
                          int height, long amount, long capacity, String amountTranslation, int offset){
        drawContext.drawText(client.textRenderer, displayName, 2,
                height-2*(1+client.textRenderer.fontHeight)-offset, 0xFFFFFF, true);
        MutableText amountString = Text.translatable(amountTranslation,
                nf.format(amount),
                nf.format(capacity));
        drawContext.drawText(client.textRenderer, amountString, 2,
                height-1-client.textRenderer.fontHeight-offset, 0xFFFFFF, true);
    }
    private static void updateClientfluidStoring(FluidStoring tank, BlockPos pos){
        PacketByteBuf data = PacketByteBufs.create();
        tank.getFluidStorage().variant.toPacket(data);
        data.writeBlockPos(pos);
        data.writeLong(tank.getFluidStorage().amount);
        ClientPlayNetworking.send(ModMessages.LOOKING_AT_FLUID_STORAGE, data);
    }
    private static void updateClientEnergyStorage(long amount, BlockPos pos){
        PacketByteBuf data = PacketByteBufs.create();
        data.writeBlockPos(pos);
        data.writeLong(amount);
        ClientPlayNetworking.send(ModMessages.LOOKING_AT_ENERGY_STORAGE, data);
    }
}
