package net.chuck.chucksmod.screen.quarry;

import net.chuck.chucksmod.block.entity.quarry.AbstractQuarryBlockEntity;
import net.chuck.chucksmod.block.entity.quarry.TitaniumQuarryBlockEntity;
import net.chuck.chucksmod.screen.ModScreenHandlers;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.slot.Slot;

public class TitaniumQuarryScreenHandler extends IronQuarryScreenHandler {
    private static final int LAST_QUARRY_INV_SLOT = 51;
    private static final int INV_ROWS = 2;
    public TitaniumQuarryScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity entity,
                                       PropertyDelegate delegate, long energy) {
        super(syncId, playerInventory, entity, delegate, ModScreenHandlers.TITANIUM_QUARRY_SCREEN_HANDLER,
                TitaniumQuarryBlockEntity.QUARRY_INV_SIZE);
        this.blockEntity.setEnergyLevel(energy);
        addQuarryInventory();
    }
    public TitaniumQuarryScreenHandler(int syncId, PlayerInventory inventory, PacketByteBuf buf){
        this(syncId, inventory, inventory.player.getWorld().getBlockEntity(buf.readBlockPos()),
                new ArrayPropertyDelegate(AbstractQuarryBlockEntity.DELEGATE_SIZE), buf.readLong());
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
                        26+i*18));
            }
        }
        this.addSlot(new MiningBookSlot(inventory, INV_ROWS*INV_ROW_SIZE, 98, 64));
    }

    @Override
    public boolean moveToQuarry(ItemStack itemStack) {
        return MiningBookSlot.canAccept(itemStack) && slots.get(getEndOfInventory()+1).getStack().isEmpty() ?
                !this.insertItem(itemStack, getEndOfInventory()+1, getEndOfInventory()+2, true) :
                !this.insertItem(itemStack, getStartOfInventory(), getEndOfInventory()+1, false);
    }
}
