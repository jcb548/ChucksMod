package net.chuck.chucksmod.screen.furnace;

import net.chuck.chucksmod.block.entity.furnace.IronPoweredFurnaceBlockEntity;
import net.chuck.chucksmod.screen.ModScreenHandlers;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;

public class IronPoweredFurnaceScreenHandler extends AbstractPoweredFurnaceScreenHandler{
    public final IronPoweredFurnaceBlockEntity blockEntity;
    public IronPoweredFurnaceScreenHandler(int syncId, PlayerInventory inventory, PacketByteBuf buf){
        this(syncId, inventory, inventory.player.getWorld().getBlockEntity(buf.readBlockPos()),
                new ArrayPropertyDelegate(IronPoweredFurnaceBlockEntity.DELEGATE_SIZE));
    }
    public IronPoweredFurnaceScreenHandler(int syncId, PlayerInventory playerInventory,
                                              BlockEntity entity, PropertyDelegate delegate) {
        super(syncId, playerInventory, entity, delegate, ModScreenHandlers.IRON_POWERED_FURNACE_SCREEN_HANDLER);
        this.blockEntity = (IronPoweredFurnaceBlockEntity) entity;
    }

}
