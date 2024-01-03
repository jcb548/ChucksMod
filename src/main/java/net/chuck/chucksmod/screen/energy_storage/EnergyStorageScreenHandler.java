package net.chuck.chucksmod.screen.energy_storage;

import net.chuck.chucksmod.block.entity.energy_storage.AbstractEnergyStorageBlockEntity;
import net.chuck.chucksmod.networking.ModMessages;
import net.chuck.chucksmod.screen.ModScreenHandlers;
import net.chuck.chucksmod.util.DirectionEnergyIOProperty;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.Direction;

public class EnergyStorageScreenHandler extends ScreenHandler {
    protected final Inventory inventory;
    public final AbstractEnergyStorageBlockEntity blockEntity;
    public EnergyStorageScreenHandler(int syncId, PlayerInventory inventory, PacketByteBuf buf){
        this(syncId, inventory, inventory.player.getWorld().getBlockEntity(buf.readBlockPos()));
    }
    public EnergyStorageScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity entity) {
        super(ModScreenHandlers.ENERGY_STORAGE_SCREEN_HANDLER, syncId);
        checkSize(((Inventory) entity), AbstractEnergyStorageBlockEntity.INV_SIZE);
        this.inventory = (Inventory) entity;
        this.blockEntity = (AbstractEnergyStorageBlockEntity) entity;
        inventory.onOpen(playerInventory.player);
        this.addSlot(new Slot(inventory, AbstractEnergyStorageBlockEntity.INPUT_SLOT, 20, 35));
        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot != null && slot.hasStack()){
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if(invSlot < this.inventory.size()) {
                if(!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)){
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, AbstractEnergyStorageBlockEntity.INPUT_SLOT,
                    this.inventory.size(), false)){
                return ItemStack.EMPTY;
            }
            if(originalStack.isEmpty()){
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }
        return newStack;
    }
    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }
    public void addPlayerInventory(PlayerInventory inventory) {
        for(int i=0;i<3;++i) {
            for(int j=0;j<9;++j) {
                this.addSlot(new Slot(inventory, j + i*9 + 9, 8 + j*18, 84 + i*18));
            }
        }
    }

    public void addPlayerHotbar(PlayerInventory inventory){
        for(int i=0;i<9;++i) {
            this.addSlot(new Slot(inventory, i, 8 + i*18, 142));
        }
    }

    public void onButtonPress(byte id) {
        PacketByteBuf buf = PacketByteBufs.create();
        buf.writeBlockPos(blockEntity.getPos());
        buf.writeByte(id);
        buf.writeString(blockEntity.getCachedState().get(DirectionEnergyIOProperty.getSide(id)), 1);
        ClientPlayNetworking.send(ModMessages.ENERGY_STORAGE_BLOCK_SYNC, buf);
    }

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
