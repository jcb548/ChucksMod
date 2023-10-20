package net.chuck.chucksmod.screen.bag;

import net.chuck.chucksmod.item.custom.bag.LeatherBagItem;
import net.chuck.chucksmod.screen.ModScreenHandlers;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.slot.ShulkerBoxSlot;

public class LeatherBagScreenHandler extends AbstractBagScreenHandler{
    public LeatherBagScreenHandler(int syncId, PlayerInventory playerInventory, PacketByteBuf buf){
        this(syncId, playerInventory, buf.readItemStack());
    }
    public LeatherBagScreenHandler(int syncId, PlayerInventory playerInventory, ItemStack itemStack) {
        super(ModScreenHandlers.LEATHER_BAG_SCREEN_HANDLER, syncId);
        inventory = new SimpleInventory(LeatherBagItem.INV_SIZE);
        init(playerInventory, itemStack);
    }

    @Override
    protected void addBagInventory() {
        for(int i = 0; i< LeatherBagItem.INV_SIZE; i++){
            this.addSlot(new ShulkerBoxSlot(inventory, i, 44+i*18, 18));
        }
    }
}
