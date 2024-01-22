package net.chuck.chucksmod.screen.bag;

import net.chuck.chucksmod.item.custom.bag.BagItem7x2;
import net.chuck.chucksmod.screen.ModScreenHandlers;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.slot.ShulkerBoxSlot;
import net.minecraft.screen.slot.Slot;

public class BagScreenHandler7x2 extends AbstractBagScreenHandler{
    public BagScreenHandler7x2(int syncId, PlayerInventory playerInventory, PacketByteBuf buf){
        this(syncId, playerInventory, buf.readItemStack());
    }
    public BagScreenHandler7x2(int syncId, PlayerInventory playerInventory, ItemStack itemStack) {
        super(ModScreenHandlers.BAG_7X2_SCREEN_HANDLER, syncId);
        inventory = new SimpleInventory(BagItem7x2.INV_SIZE);
        init(playerInventory, itemStack);
    }
    @Override
    public void addPlayerInventory(PlayerInventory playerInventory) {
        addPlayerInventory(playerInventory, ModScreenHandlers.DOUBLE_ROW_INV_TITLE +
                ModScreenHandlers.INV_BELOW_TITLE);
    }

    @Override
    public void addPlayerHotbar(PlayerInventory playerInventory){
        addPlayerHotbar(playerInventory, ModScreenHandlers.DOUBLE_ROW_INV_TITLE +
                ModScreenHandlers.HOTBAR_BELOW_TITLE);
    }
    @Override
    protected void addBagInventory() {
        for(int i=0;i< BagItem7x2.INV_HEIGHT;i++) {
            for (int j = 0; j < BagItem7x2.INV_WIDTH; j++) {
                this.addSlot(new ShulkerBoxSlot(inventory, j+BagItem7x2.INV_WIDTH*i, 26 + j * 18, 18 + i * 18));
            }
        }
    }
}
