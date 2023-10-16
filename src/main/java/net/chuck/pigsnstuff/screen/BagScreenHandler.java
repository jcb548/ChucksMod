package net.chuck.pigsnstuff.screen;

import net.chuck.pigsnstuff.item.custom.BagItem;
import net.chuck.pigsnstuff.item.custom.ItemInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.collection.DefaultedList;

import java.util.Objects;

import static net.chuck.pigsnstuff.item.custom.BagItem.ITEMS_KEY;

public class BagScreenHandler extends ScreenHandler {
    protected final ItemInventory inventory;
    public BagScreenHandler(int syncId, PlayerInventory playerInventory, PacketByteBuf buf) {
        this(syncId, playerInventory, buf.readItemStack());
    }

    public BagScreenHandler(int syncId, PlayerInventory playerInventory, ItemStack itemStack){
        super(ModScreenHandlers.BAG_SCREEN_HANDLER, syncId);
        if(!itemStack.hasNbt()){
            NbtCompound nbt_temp = new NbtCompound();
            Inventories.writeNbt(nbt_temp, DefaultedList.ofSize(BagItem.INV_SIZE, ItemStack.EMPTY));
            itemStack.setSubNbt(ITEMS_KEY, nbt_temp);
        }
        NbtCompound nbt = itemStack.getNbt();

        DefaultedList<ItemStack> nbtInventory = DefaultedList.ofSize(BagItem.INV_SIZE, ItemStack.EMPTY);
        if (nbt.contains(ITEMS_KEY, NbtElement.LIST_TYPE)) {
            Inventories.readNbt(nbt, nbtInventory);
        }
        this.inventory = ItemInventory.of(nbtInventory);
        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);
        addBagInventory();
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slot) {
        return null;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }

    @Override
    public void onClosed(PlayerEntity player) {
        ItemStack bag_item = player.getMainHandStack();
        NbtCompound nbt = new NbtCompound();
        Inventories.writeNbt(nbt, this.inventory.getItems(), false);
        bag_item.setSubNbt(ITEMS_KEY, nbt);
        super.onClosed(player);
    }

    public void addPlayerInventory(PlayerInventory playerInventory) {
        for(int i=0;i<3;++i) {
            for(int j=0;j<9;++j) {
                this.addSlot(new Slot(playerInventory, j + i*9 + 9, 8 + j*18, 51 + i*18));
            }
        }
    }
    public void addPlayerHotbar(PlayerInventory playerInventory){
        for(int i=0;i<9;++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i*18, 110));
        }
    }

    private void addBagInventory(){
        for(int i=0; i<BagItem.INV_SIZE;++i){
            this.addSlot(new Slot(inventory, i, 8+ i*18, 21));
        }
    }
}
