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
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
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
        buf.writeString(blockEntity.getCachedState().get(DirectionEnergyIOProperty.getSide(id)), 1);
        ClientPlayNetworking.send(ModMessages.ENERGY_STORAGE_BLOCK_SYNC, buf);
    }

    @Override
    public String getSideState(byte id) {
        return blockEntity.getCachedState().get(DirectionEnergyIOProperty.getSide(id));
    }

    public byte directionToGUISide(byte id){
        Direction facing = blockEntity.getCachedState().get(Properties.HORIZONTAL_FACING);
        if(facing.equals(Direction.EAST)){
            switch(id){
                case DirectionEnergyIOProperty.NORTH_KEY: return DirectionEnergyIOProperty.EAST_KEY;
                case DirectionEnergyIOProperty.SOUTH_KEY: return DirectionEnergyIOProperty.WEST_KEY;
                case DirectionEnergyIOProperty.EAST_KEY: return DirectionEnergyIOProperty.SOUTH_KEY;
                default: return DirectionEnergyIOProperty.NORTH_KEY;
            }
        }
        if(facing.equals(Direction.SOUTH)){
            switch (id) {
                case DirectionEnergyIOProperty.NORTH_KEY: return DirectionEnergyIOProperty.SOUTH_KEY;
                case DirectionEnergyIOProperty.SOUTH_KEY: return DirectionEnergyIOProperty.NORTH_KEY;
                case DirectionEnergyIOProperty.EAST_KEY: return DirectionEnergyIOProperty.WEST_KEY;
                default: return DirectionEnergyIOProperty.EAST_KEY;
            }
        }
        if(facing.equals(Direction.WEST)){
            switch (id) {
                case DirectionEnergyIOProperty.NORTH_KEY: return DirectionEnergyIOProperty.WEST_KEY;
                case DirectionEnergyIOProperty.SOUTH_KEY: return DirectionEnergyIOProperty.EAST_KEY;
                case DirectionEnergyIOProperty.EAST_KEY: return DirectionEnergyIOProperty.NORTH_KEY;
                default: return DirectionEnergyIOProperty.SOUTH_KEY;
            }
        }
        return id;
    }
}
