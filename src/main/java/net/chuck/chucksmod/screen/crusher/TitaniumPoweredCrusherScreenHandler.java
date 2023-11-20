package net.chuck.chucksmod.screen.crusher;

import net.chuck.chucksmod.block.entity.crusher.TitaniumPoweredCrusherBlockEntity;
import net.chuck.chucksmod.screen.ModScreenHandlers;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;

public class TitaniumPoweredCrusherScreenHandler extends AbstractPoweredCrusherScreenHandler {
    public final TitaniumPoweredCrusherBlockEntity blockEntity;
    public TitaniumPoweredCrusherScreenHandler(int syncId, PlayerInventory inventory, PacketByteBuf buf){
        this(syncId, inventory, inventory.player.getWorld().getBlockEntity(buf.readBlockPos()),
                new ArrayPropertyDelegate(TitaniumPoweredCrusherBlockEntity.DELEGATE_SIZE));
    }
    public TitaniumPoweredCrusherScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity entity,
                                               PropertyDelegate delegate) {
        super(syncId, playerInventory, entity, delegate, ModScreenHandlers.TITANIUM_POWERED_CRUSHER_SCREEN_HANDLER);
        this.blockEntity = (TitaniumPoweredCrusherBlockEntity) entity;
    }

}
