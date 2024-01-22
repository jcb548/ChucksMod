package net.chuck.chucksmod.screen;

import net.chuck.chucksmod.block.entity.AbstractEnergyUsingBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;
import net.minecraft.world.World;

public abstract class AbstractEnergyUsingScreenHandler extends AbstractModScreenHandler {
    protected final World world;
    protected final Inventory inventory;
    protected final PropertyDelegate propertyDelegate;
    public final AbstractEnergyUsingBlockEntity blockEntity;
    protected AbstractEnergyUsingScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity entity,
                                               PropertyDelegate delegate, ScreenHandlerType type, int invSize) {
        super(type, syncId);
        checkSize(((Inventory) entity), invSize);
        this.inventory = (Inventory) entity;
        this.blockEntity = (AbstractEnergyUsingBlockEntity) entity;
        inventory.onOpen(playerInventory.player);
        this.propertyDelegate = delegate;
        addPlayerHotbar(playerInventory, 142);
        addPlayerInventory(playerInventory, 84);
        addProperties(delegate);
        world = playerInventory.player.getWorld();
    }
}
