package net.chuck.chucksmod.screen.quarry;

import net.chuck.chucksmod.block.entity.furnace.AbstractPoweredFurnaceBlockEntity;
import net.chuck.chucksmod.block.entity.quarry.AbstractQuarryBlockEntity;
import net.chuck.chucksmod.block.entity.quarry.IronQuarryBlockEntity;
import net.chuck.chucksmod.screen.AbstractEnergyUsingScreenHandler;
import net.chuck.chucksmod.screen.ModScreenHandlers;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;

public class IronQuarryScreenHandler extends AbstractQuarryScreenHandler {
    protected static final int FIRST_QUARRY_INV_SLOT = 36;
    private static final int LAST_QUARRY_INV_SLOT = 43;
    public IronQuarryScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity entity,
                                   PropertyDelegate delegate, long energy) {
        super(syncId, playerInventory, entity, delegate, ModScreenHandlers.IRON_QUARRY_SCREEN_HANDLER,
                IronQuarryBlockEntity.QUARRY_INV_SIZE);
        this.blockEntity.setEnergyLevel(energy);
        addQuarryInventory();
    }
    public IronQuarryScreenHandler(int syncId, PlayerInventory inventory, PacketByteBuf buf){
        this(syncId, inventory, inventory.player.getWorld().getBlockEntity(buf.readBlockPos()),
                new ArrayPropertyDelegate(AbstractQuarryBlockEntity.DELEGATE_SIZE), buf.readLong());
    }

    public IronQuarryScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity entity,
                                   PropertyDelegate delegate, ScreenHandlerType type, int invSize){
        super(syncId, playerInventory, entity, delegate, type, invSize);
    }

    public int getStartOfInventory(){
        return FIRST_QUARRY_INV_SLOT;
    }
    public int getEndOfInventory(){
        return LAST_QUARRY_INV_SLOT;
    }
    protected void addQuarryInventory(){
        for(int i=0; i<inventory.size();i++){
            this.addSlot(new Slot(inventory, i, 8+i*18, 35));
        }
    }
}
