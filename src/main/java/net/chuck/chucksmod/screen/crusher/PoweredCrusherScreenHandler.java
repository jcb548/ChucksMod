package net.chuck.chucksmod.screen.crusher;

import net.chuck.chucksmod.block.entity.crusher.AbstractCrusherBlockEntity;
import net.chuck.chucksmod.block.entity.crusher.IronPoweredCrusherBlockEntity;
import net.chuck.chucksmod.screen.ModScreenHandlers;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.slot.Slot;

public class PoweredCrusherScreenHandler extends AbstractCrusherScreenHandler {
    public final IronPoweredCrusherBlockEntity blockEntity;
    public PoweredCrusherScreenHandler(int syncId, PlayerInventory inventory, PacketByteBuf buf){
        this(syncId, inventory, inventory.player.getWorld().getBlockEntity(buf.readBlockPos()),
                new ArrayPropertyDelegate(IronPoweredCrusherBlockEntity.DELEGATE_SIZE));
    }
    public PoweredCrusherScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity entity,
                                PropertyDelegate delegate) {
        super(syncId, playerInventory, entity, delegate, ModScreenHandlers.POWERED_CRUSHER_SCREEN_HANDLER);
        this.blockEntity = (IronPoweredCrusherBlockEntity) entity;
        this.slots.set(AbstractCrusherBlockEntity.INPUT_SLOT,
                new Slot(inventory, AbstractCrusherBlockEntity.INPUT_SLOT, 56, 35));
    }

}
