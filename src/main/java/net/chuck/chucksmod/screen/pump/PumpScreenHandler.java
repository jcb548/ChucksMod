package net.chuck.chucksmod.screen.pump;

import net.chuck.chucksmod.block.entity.pump.AbstractPumpBlockEntity;
import net.chuck.chucksmod.screen.AbstractEnergyUsingScreenHandler;
import net.chuck.chucksmod.screen.ModScreenHandlers;
import net.chuck.chucksmod.util.FluidStack;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;

public class PumpScreenHandler extends AbstractEnergyUsingScreenHandler {
    public AbstractPumpBlockEntity pump;
    public FluidStack fluidStack;
    public PumpScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity entity,
                             PropertyDelegate delegate) {
        super(syncId, playerInventory, entity, delegate, ModScreenHandlers.PUMP_SCREEN_HANDLER, 0);
        if(this.blockEntity instanceof AbstractPumpBlockEntity)pump = (AbstractPumpBlockEntity) blockEntity;
        this.fluidStack = new FluidStack(pump.fluidStorage.variant, pump.fluidStorage.amount);
    }
    public PumpScreenHandler(int syncId, PlayerInventory inventory, PacketByteBuf buf){
        this(syncId, inventory, inventory.player.getWorld().getBlockEntity(buf.readBlockPos()),
                new ArrayPropertyDelegate(AbstractPumpBlockEntity.DELEGATE_SIZE));
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slot) {
        return null;
    }

    public void setFluidStack(FluidStack fluidStack) {
        this.fluidStack = fluidStack;
    }
}
