package net.chuck.chucksmod.screen.crusher;

import net.chuck.chucksmod.block.entity.AbstractEnergyCookerBlockEntity;
import net.chuck.chucksmod.screen.AbstractEnergyCookerScreenHandler;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandlerType;

public abstract class AbstractPoweredCrusherScreenHandler extends AbstractEnergyCookerScreenHandler {
    public AbstractPoweredCrusherScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity entity,
                                               PropertyDelegate delegate, ScreenHandlerType type) {
        super(syncId, playerInventory, entity, delegate, type);
    }
    public int getScaledProgress() {
        int progress = this.propertyDelegate.get(AbstractEnergyCookerBlockEntity.PROGRESS_IDX);
        int maxProgress = this.propertyDelegate.get(AbstractEnergyCookerBlockEntity.MAX_PROGRESS_IDX);
        int progressArrowSize = 16;

        return maxProgress != 0 && progress != 0 ? progress * progressArrowSize / maxProgress : 0;
    }
}
