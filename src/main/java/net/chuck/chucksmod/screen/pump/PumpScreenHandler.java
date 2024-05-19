package net.chuck.chucksmod.screen.pump;

import net.chuck.chucksmod.block.entity.FluidStoring;
import net.chuck.chucksmod.block.entity.pump.AbstractPumpBlockEntity;
import net.chuck.chucksmod.screen.AbstractEnergyUsingScreenHandler;
import net.chuck.chucksmod.screen.FluidDisplayingScreenHandler;
import net.chuck.chucksmod.screen.ModScreenHandlers;
import net.chuck.chucksmod.util.FluidStack;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.slot.Slot;

public class PumpScreenHandler extends AbstractEnergyUsingScreenHandler implements FluidDisplayingScreenHandler {
    public AbstractPumpBlockEntity pump;
    public PumpScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity entity,
                             PropertyDelegate delegate) {
        super(syncId, playerInventory, entity, delegate, ModScreenHandlers.PUMP_SCREEN_HANDLER, 0);
        if(this.blockEntity instanceof AbstractPumpBlockEntity)pump = (AbstractPumpBlockEntity) blockEntity;
        setFluidStack(new FluidStack(pump.fluidStorage.variant, pump.fluidStorage.amount));
    }
    public PumpScreenHandler(int syncId, PlayerInventory inventory, PacketByteBuf buf){
        this(syncId, inventory, inventory.player.getWorld().getBlockEntity(buf.readBlockPos()),
                new ArrayPropertyDelegate(AbstractPumpBlockEntity.DELEGATE_SIZE));
    }
    @Override
    public FluidStoring getFluidStoring() {
        return pump;
    }
}
