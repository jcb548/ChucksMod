package net.chuck.chucksmod.screen.energy_storage;

import net.chuck.chucksmod.block.entity.energy_storage.IronEnergyStorageBlockEntity;
import net.chuck.chucksmod.networking.ModMessages;
import net.chuck.chucksmod.screen.ModScreenHandlers;
import net.chuck.chucksmod.util.DirectionEnergyIOProperty;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class IronEnergyStorageScreenHandler extends AbstractEnergyStorageScreenHandler {
    public final IronEnergyStorageBlockEntity blockEntity;
    public IronEnergyStorageScreenHandler(int syncId, PlayerInventory inventory, PacketByteBuf buf){
        this(syncId, inventory, inventory.player.getWorld().getBlockEntity(buf.readBlockPos()));
    }
    public IronEnergyStorageScreenHandler(int syncId, PlayerInventory playerInventory,
                                          BlockEntity entity) {
        super(syncId, playerInventory, entity, ModScreenHandlers.IRON_ENERGY_STORAGE_SCREEN_HANDLER);
        this.blockEntity = (IronEnergyStorageBlockEntity) entity;
    }

    @Override
    public void onButtonPress(byte id) {
        PacketByteBuf buf = PacketByteBufs.create();
        buf.writeBlockPos(blockEntity.getPos());
        buf.writeByte(id);
        buf.writeString(blockEntity.getCachedState().get(DirectionEnergyIOProperty.getSide(id)));
        ClientPlayNetworking.send(ModMessages.ENERGY_STORAGE_BLOCK_SYNC, buf);
    }
}
