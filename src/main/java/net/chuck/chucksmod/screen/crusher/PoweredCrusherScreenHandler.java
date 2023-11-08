package net.chuck.chucksmod.screen.crusher;

import net.chuck.chucksmod.block.entity.crusher.AbstractCrusherBlockEntity;
import net.chuck.chucksmod.block.entity.crusher.PoweredCrusherBlockEntity;
import net.chuck.chucksmod.screen.ModScreenHandlers;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.slot.Slot;

public class PoweredCrusherScreenHandler extends AbstractCrusherScreenHandler {
    public final PoweredCrusherBlockEntity blockEntity;
    public PoweredCrusherScreenHandler(int syncId, PlayerInventory inventory, PacketByteBuf buf){
        this(syncId, inventory, inventory.player.getWorld().getBlockEntity(buf.readBlockPos()),
                new ArrayPropertyDelegate(PoweredCrusherBlockEntity.DELEGATE_SIZE));
    }
    public PoweredCrusherScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity entity,
                                PropertyDelegate delegate) {
        super(syncId, playerInventory, entity, delegate, ModScreenHandlers.POWERED_CRUSHER_SCREEN_HANDLER);
        this.blockEntity = (PoweredCrusherBlockEntity) entity;
        this.slots.set(AbstractCrusherBlockEntity.INPUT_SLOT,
                new Slot(inventory, AbstractCrusherBlockEntity.INPUT_SLOT, 56, 35));
    }

}
