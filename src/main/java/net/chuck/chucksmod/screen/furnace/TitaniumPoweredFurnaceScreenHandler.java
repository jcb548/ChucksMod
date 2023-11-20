package net.chuck.chucksmod.screen.furnace;

import net.chuck.chucksmod.block.entity.furnace.TitaniumPoweredFurnaceBlockEntity;
import net.chuck.chucksmod.screen.ModScreenHandlers;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;

public class TitaniumPoweredFurnaceScreenHandler extends AbstractPoweredFurnaceScreenHandler{
    public final TitaniumPoweredFurnaceBlockEntity blockEntity;
    public TitaniumPoweredFurnaceScreenHandler(int syncId, PlayerInventory inventory, PacketByteBuf buf){
        this(syncId, inventory, inventory.player.getWorld().getBlockEntity(buf.readBlockPos()),
                new ArrayPropertyDelegate(TitaniumPoweredFurnaceBlockEntity.DELEGATE_SIZE));
    }
    public TitaniumPoweredFurnaceScreenHandler(int syncId, PlayerInventory playerInventory,
                                               BlockEntity entity, PropertyDelegate delegate) {
        super(syncId, playerInventory, entity, delegate, ModScreenHandlers.TITANIUM_POWERED_FURNACE_SCREEN_HANDLER);
        this.blockEntity = (TitaniumPoweredFurnaceBlockEntity) entity;
    }

}
