package net.chuck.chucksmod.screen.cleanser;

import net.chuck.chucksmod.block.entity.AbstractEnergyCookerBlockEntity;
import net.chuck.chucksmod.block.entity.FluidStoring;
import net.chuck.chucksmod.block.entity.cleanser.AbstractCleanserBlockEntity;
import net.chuck.chucksmod.screen.AbstractEnergyCookerScreenHandler;
import net.chuck.chucksmod.screen.FluidDisplayingScreenHandler;
import net.chuck.chucksmod.screen.ModScreenHandlers;
import net.chuck.chucksmod.util.FluidStack;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;

public class CleanserScreenHandler extends AbstractEnergyCookerScreenHandler implements FluidDisplayingScreenHandler {
    public AbstractCleanserBlockEntity cleanser;
    public CleanserScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity entity,
                                    PropertyDelegate delegate) {
        super(syncId, playerInventory, entity, delegate, ModScreenHandlers.CLEANSER_SCREEN_HANDLER);
        if(this.blockEntity instanceof AbstractCleanserBlockEntity)cleanser = (AbstractCleanserBlockEntity) blockEntity;
        setFluidStack(new FluidStack(cleanser.fluidStorage.variant, cleanser.fluidStorage.amount));
    }
    public CleanserScreenHandler(int syncId, PlayerInventory inventory, PacketByteBuf buf){
        this(syncId, inventory, inventory.player.getWorld().getBlockEntity(buf.readBlockPos()),
                new ArrayPropertyDelegate(AbstractEnergyCookerBlockEntity.DELEGATE_SIZE));
    }

    @Override
    protected boolean isRecipeItem(ItemStack item) {
        return item.getRepairCost() > 0;
    }

    @Override
    public FluidStoring getFluidStoring() {
        return cleanser;
    }
}
