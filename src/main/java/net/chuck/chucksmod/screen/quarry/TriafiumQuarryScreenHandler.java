package net.chuck.chucksmod.screen.quarry;

import net.chuck.chucksmod.block.entity.quarry.AbstractQuarryBlockEntity;
import net.chuck.chucksmod.block.entity.quarry.TriafiumQuarryBlockEntity;
import net.chuck.chucksmod.screen.ModScreenHandlers;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.slot.Slot;

public class TriafiumQuarryScreenHandler extends IronQuarryScreenHandler {
    protected TriafiumQuarryBlockEntity quarry = null;
    protected Inventory miningBookInventory;
    private static final int LAST_QUARRY_INV_SLOT = 59;
    private static final int INV_ROWS = 2;
    public TriafiumQuarryScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity entity,
                                       PropertyDelegate delegate) {
        super(syncId, playerInventory, entity, delegate, ModScreenHandlers.TRIAFIUM_QUARRY_SCREEN_HANDLER,
                TriafiumQuarryBlockEntity.QUARRY_INV_SIZE);
        if(entity instanceof TriafiumQuarryBlockEntity quarryBlockEntity) quarry = quarryBlockEntity;
        checkSize(quarry.getMiningBookInventory(),1);
        miningBookInventory = quarry.getMiningBookInventory();
        addQuarryInventory();
    }
    public TriafiumQuarryScreenHandler(int syncId, PlayerInventory inventory, PacketByteBuf buf){
        this(syncId, inventory, inventory.player.getWorld().getBlockEntity(buf.readBlockPos()),
                new ArrayPropertyDelegate(AbstractQuarryBlockEntity.DELEGATE_SIZE));
    }
    @Override
    public int getEndOfInventory(){
        return LAST_QUARRY_INV_SLOT;
    }
    @Override
    protected void addQuarryInventory(){
        for(int i=0; i<INV_ROWS; i++) {
            for (int j = 0; j < INV_ROW_SIZE; j++) {
                this.addSlot(new Slot(inventory, i * INV_ROW_SIZE + j, 8 + j * 18,
                        17+i*18));
            }
        }
        this.addSlot(new MiningBookSlot(miningBookInventory, 0, 98, 73));
    }

    @Override
    public boolean moveToQuarry(ItemStack itemStack) {
        return MiningBookSlot.canAccept(itemStack) && slots.get(getEndOfInventory()+1).getStack().isEmpty() ?
                !this.insertItem(itemStack, getEndOfInventory()+1, getEndOfInventory()+2, true) :
                !this.insertItem(itemStack, getStartOfInventory(), getEndOfInventory()+1, false);
    }

    @Override
    public void addPlayerHotbar(PlayerInventory playerInventory) {
        addPlayerHotbar(playerInventory, 151);
    }

    @Override
    public void addPlayerInventory(PlayerInventory playerInventory) {
        addPlayerInventory(playerInventory, 93);
    }
}
