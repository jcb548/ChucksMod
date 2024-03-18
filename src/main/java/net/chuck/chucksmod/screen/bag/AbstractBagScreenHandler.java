package net.chuck.chucksmod.screen.bag;

import net.chuck.chucksmod.item.custom.bag.AbstractBagItem;
import net.chuck.chucksmod.item.custom.bag.BagItem5x1;
import net.chuck.chucksmod.screen.AbstractModScreenHandler;
import net.chuck.chucksmod.screen.ModScreenHandlers;
import net.chuck.chucksmod.screen.slot.ModDisableBagSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.InventoryChangedListener;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;

;

public abstract class AbstractBagScreenHandler extends AbstractModScreenHandler implements InventoryChangedListener {
    protected SimpleInventory inventory;
    protected ItemStack bagItemStack;
    private int invSize = 0;
    public AbstractBagScreenHandler(ScreenHandlerType<?> type, int syncId){
        super(type, syncId);
    }
    protected void init(PlayerInventory playerInventory, ItemStack itemStack){
        bagItemStack = itemStack;
        if(bagItemStack.getItem() instanceof AbstractBagItem bagItem) invSize = bagItem.getInvSize();
        if(bagItemStack.getNbt() != null) {
            Inventories.readNbt(bagItemStack.getNbt(), inventory.stacks);
        } else {
            NbtCompound newNbt = new NbtCompound();
            Inventories.writeNbt(newNbt, inventory.stacks, false);
            bagItemStack.setNbt(newNbt);
        }
        inventory.onOpen(playerInventory.player);
        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);
        disableBagSlot();
        addBagInventory();
        inventory.addListener(this);
    }
    @Override
    public ItemStack quickMove(PlayerEntity player, int slot) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot originalSlot = this.slots.get(slot);
        if (originalSlot.hasStack()) {
            ItemStack itemStack2 = originalSlot.getStack();
            itemStack = itemStack2.copy();
            if (slot <= PLAYER_INVENTORY_END_IDX ?
                    !this.insertItem(itemStack2, PLAYER_INVENTORY_END_IDX+1, PLAYER_INVENTORY_END_IDX+invSize+1, false) :
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
    public void addPlayerInventory(PlayerInventory playerInventory) {
        addPlayerInventory(playerInventory, ModScreenHandlers.SINGLE_ROW_INV_TITLE +
                ModScreenHandlers.INV_BELOW_TITLE);
    }
    public void addPlayerHotbar(PlayerInventory playerInventory){
        addPlayerHotbar(playerInventory, ModScreenHandlers.SINGLE_ROW_INV_TITLE +
                ModScreenHandlers.HOTBAR_BELOW_TITLE);
    }

    protected abstract void addBagInventory();

    @Override
    public void onInventoryChanged(Inventory sender) {
        NbtCompound newNbt = new NbtCompound();
        Inventories.writeNbt(newNbt, inventory.stacks, false);
        bagItemStack.setNbt(newNbt);
    }

    public void disableBagSlot(){
        for(int i=0; i<slots.size();i++){
            if(slots.get(i).getStack().equals(bagItemStack)){
                slots.set(i, new ModDisableBagSlot(slots.get(i)));
            }
        }
    }
}
