package net.chuck.chucksmod.screen.quarry;

import net.chuck.chucksmod.block.entity.quarry.AbstractQuarryBlockEntity;
import net.chuck.chucksmod.networking.ModMessages;
import net.chuck.chucksmod.screen.AbstractEnergyUsingScreenHandler;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;
import net.minecraft.text.Text;

public abstract class AbstractQuarryScreenHandler extends AbstractEnergyUsingScreenHandler {
    protected static final int INV_ROW_SIZE = 8;
    protected AbstractQuarryScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity entity, PropertyDelegate delegate, ScreenHandlerType type, int invSize) {
        super(syncId, playerInventory, entity, delegate, type, invSize);
    }
    public void onButtonPress(){
        PacketByteBuf buf = PacketByteBufs.create();
        buf.writeBlockPos(blockEntity.getPos());
        ClientPlayNetworking.send(ModMessages.RESET_QUARRY_SYNC, buf);
    }
    @Override
    public ItemStack quickMove(PlayerEntity player, int slot) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot originalSlot = this.slots.get(slot);
        if (originalSlot.hasStack()) {
            ItemStack itemStack2 = originalSlot.getStack();
            itemStack = itemStack2.copy();
            if (slot <= PLAYER_INVENTORY_END_IDX ?
                    moveToQuarry(itemStack2) :
                    !this.insertItem(itemStack2, PLAYER_INVENTORY_START_IDX, PLAYER_INVENTORY_END_IDX+1, false)) {
                return ItemStack.EMPTY;
            }
            if (itemStack2.isEmpty()) {
                originalSlot.setStack(ItemStack.EMPTY);
            } else {
                originalSlot.markDirty();
            }
        }
        return itemStack;
    }
    public abstract int getStartOfInventory();
    public abstract int getEndOfInventory();

    public boolean moveToQuarry(ItemStack itemStack){
        return !this.insertItem(itemStack, getStartOfInventory(), getEndOfInventory()+1, false);
    }
}
