package net.chuck.chucksmod.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractModScreenHandler extends ScreenHandler {
    protected final static int PLAYER_INVENTORY_START_IDX = 0;
    protected final static int PLAYER_INVENTORY_END_IDX = 35;
    protected AbstractModScreenHandler(@Nullable ScreenHandlerType<?> type, int syncId) {
        super(type, syncId);
    }
    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }
    public void addPlayerInventory(PlayerInventory playerInventory, int y){
        for(int i=0;i<3;++i) {
            for(int j=0;j<9;++j) {
                this.addSlot(new Slot(playerInventory, j + i*9 + 9, 8 + j*18, y + i*18));
            }
        }
    }
    public void addPlayerHotbar(PlayerInventory playerInventory, int y){
        for(int i=0;i<9;++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i*18, y));
        }
    }
}
