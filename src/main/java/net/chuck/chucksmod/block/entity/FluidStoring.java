package net.chuck.chucksmod.block.entity;

import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleVariantStorage;
import net.minecraft.server.network.ServerPlayerEntity;

public interface FluidStoring {
    SingleVariantStorage<FluidVariant> getFluidStorage();
    void sendFluidPacket(ServerPlayerEntity player);
}
