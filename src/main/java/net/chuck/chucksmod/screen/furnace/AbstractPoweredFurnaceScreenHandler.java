package net.chuck.chucksmod.screen.furnace;

import net.chuck.chucksmod.block.entity.AbstractEnergyCookerBlockEntity;
import net.chuck.chucksmod.screen.AbstractEnergyCookerScreenHandler;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeType;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandlerType;

public abstract class AbstractPoweredFurnaceScreenHandler extends AbstractEnergyCookerScreenHandler {
    protected AbstractPoweredFurnaceScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity entity,
                                                  PropertyDelegate delegate, ScreenHandlerType type) {
        super(syncId, playerInventory, entity, delegate, type);
    }
    public int getScaledProgress() {
        int progress = this.propertyDelegate.get(AbstractEnergyCookerBlockEntity.PROGRESS_IDX);
        int maxProgress = this.propertyDelegate.get(AbstractEnergyCookerBlockEntity.MAX_PROGRESS_IDX);
        int progressArrowSize = 24;

        return maxProgress != 0 && progress != 0 ? progress * progressArrowSize / maxProgress : 0;
    }

    @Override
    protected boolean isRecipeItem(ItemStack item) {
        return this.world.getRecipeManager().getFirstMatch(RecipeType.SMELTING, new SimpleInventory(item), this.world).isPresent();
    }
}
