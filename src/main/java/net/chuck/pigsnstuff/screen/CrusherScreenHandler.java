package net.chuck.pigsnstuff.screen;

import net.chuck.pigsnstuff.block.entity.AbstractCrusherBlockEntity;
import net.chuck.pigsnstuff.block.entity.CrusherBlockEntity;
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

public class CrusherScreenHandler extends AbstractCrusherScreenHandler {
    public final CrusherBlockEntity blockEntity;
    public CrusherScreenHandler(int syncId, PlayerInventory inventory, PacketByteBuf buf){
        this(syncId, inventory, inventory.player.getWorld().getBlockEntity(buf.readBlockPos()),
                new ArrayPropertyDelegate(CrusherBlockEntity.DELEGATE_SIZE));
    }
    public CrusherScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity entity,
                                       PropertyDelegate delegate) {
        super(syncId, playerInventory, entity, delegate, ModScreenHandlers.CRUSHER_SCREEN_HANDLER);
        this.blockEntity = (CrusherBlockEntity) entity;
        this.addSlot(new Slot(inventory, CrusherBlockEntity.FUEL_SLOT, 56, 53));
    }

    public boolean isBurning() {
        return propertyDelegate.get(CrusherBlockEntity.BURN_TIME_IDX) > 0;
    }

    public int getScaledBurning() {
        int burnTime = this.propertyDelegate.get(CrusherBlockEntity.BURN_TIME_IDX);
        int fuelTime = this.propertyDelegate.get(CrusherBlockEntity.FUEL_TIME_IDX);
        int burnFlameSize = 13;

        return fuelTime != 0 && burnTime != 0 ? burnTime * burnFlameSize / fuelTime : 0;
    }
}
