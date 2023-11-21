package net.chuck.chucksmod.screen.crusher;

import net.chuck.chucksmod.block.entity.AbstractEnergyCookerBlockEntity;
import net.chuck.chucksmod.block.entity.AbstractEnergyUsingBlockEntity;
import net.chuck.chucksmod.block.entity.crusher.AbstractPoweredCrusherBlockEntity;
import net.chuck.chucksmod.block.entity.energy_storage.AbstractEnergyStorageBlockEntity;
import net.chuck.chucksmod.recipe.CrusherRecipe;
import net.chuck.chucksmod.screen.AbstractEnergyCookerScreenHandler;
import net.chuck.chucksmod.screen.ModScreenHandlers;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandlerType;

public class PoweredCrusherScreenHandler extends AbstractEnergyCookerScreenHandler {
    public PoweredCrusherScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity entity,
                                       PropertyDelegate delegate, long energy) {
        super(syncId, playerInventory, entity, delegate, ModScreenHandlers.POWERED_CRUSHER_SCREEN_HANDLER);
        this.blockEntity.setEnergyLevel(energy);
    }
    public PoweredCrusherScreenHandler(int syncId, PlayerInventory inventory, PacketByteBuf buf){
        this(syncId, inventory, inventory.player.getWorld().getBlockEntity(buf.readBlockPos()),
                new ArrayPropertyDelegate(AbstractPoweredCrusherBlockEntity.DELEGATE_SIZE), buf.readLong());
    }
    public int getScaledProgress() {
        int progress = this.propertyDelegate.get(AbstractEnergyCookerBlockEntity.PROGRESS_IDX);
        int maxProgress = this.propertyDelegate.get(AbstractEnergyCookerBlockEntity.MAX_PROGRESS_IDX);
        int progressArrowSize = 16;

        return maxProgress != 0 && progress != 0 ? progress * progressArrowSize / maxProgress : 0;
    }

    @Override
    protected boolean isRecipeItem(ItemStack item) {
        return this.world.getRecipeManager().getFirstMatch(CrusherRecipe.Type.INSTANCE, new SimpleInventory(item), this.world).isPresent();
    }
}
