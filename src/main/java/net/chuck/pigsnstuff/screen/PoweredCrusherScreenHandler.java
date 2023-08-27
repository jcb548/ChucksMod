package net.chuck.pigsnstuff.screen;

import net.chuck.pigsnstuff.block.entity.AbstractCrusherBlockEntity;
import net.chuck.pigsnstuff.block.entity.CrusherBlockEntity;
import net.chuck.pigsnstuff.block.entity.PoweredCrusherBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
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
