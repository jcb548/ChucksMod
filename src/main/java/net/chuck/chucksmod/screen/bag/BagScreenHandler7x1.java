package net.chuck.chucksmod.screen.bag;

import net.chuck.chucksmod.item.custom.bag.BagItem7x1;
import net.chuck.chucksmod.screen.ModScreenHandlers;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.slot.ShulkerBoxSlot;

public class BagScreenHandler7x1 extends AbstractBagScreenHandler{
    public BagScreenHandler7x1(int syncId, PlayerInventory playerInventory, PacketByteBuf buf){
        this(syncId, playerInventory, buf.readItemStack());
    }
    public BagScreenHandler7x1(int syncId, PlayerInventory playerInventory, ItemStack itemStack) {
        super(ModScreenHandlers.BAG_7X1_SCREEN_HANDLER, syncId);
        inventory = new SimpleInventory(BagItem7x1.INV_SIZE);
        init(playerInventory, itemStack);
    }

    @Override
    protected void addBagInventory() {
        for(int i = 0; i< BagItem7x1.INV_SIZE; i++){
            this.addSlot(new ShulkerBoxSlot(inventory, i, 26+i*18, 18));
        }
    }
}
