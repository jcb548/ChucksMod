package net.chuck.chucksmod.screen.portal_builder;

import net.chuck.chucksmod.block.entity.AbstractEnergyCookerBlockEntity;
import net.chuck.chucksmod.block.entity.portal_builder.AbstractPortalBuilderBlockEntity;
import net.chuck.chucksmod.screen.AbstractEnergyCookerScreenHandler;
import net.chuck.chucksmod.screen.ModScreenHandlers;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;

public class PortalBuilderScreenHandler extends AbstractEnergyCookerScreenHandler {
    public static final int FIRST_BOSS_ITEM_SLOT_IDX = 38;
    public static final int SECOND_BOSS_ITEM_SLOT_IDX = 39;
    public PortalBuilderScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity entity,
                                      PropertyDelegate delegate) {
        super(syncId, playerInventory, entity, delegate, ModScreenHandlers.PORTAL_BUILDER_SCREEN_HANDLER,
                AbstractPortalBuilderBlockEntity.INV_SIZE);
        this.addSlot(new Slot(inventory, AbstractPortalBuilderBlockEntity.INPUT_SLOT, 64, 35));
        this.addSlot(new Slot(inventory, AbstractPortalBuilderBlockEntity.OUTPUT_SLOT, 116, 35));
        this.addSlot(new Slot(inventory, AbstractPortalBuilderBlockEntity.FIRST_BOSS_ITEM_SLOT, 23, 17));
        this.addSlot(new Slot(inventory, AbstractPortalBuilderBlockEntity.SECOND_BOSS_ITEM_SLOT, 23, 53));
    }
    public PortalBuilderScreenHandler(int syncId, PlayerInventory playerInventory, PacketByteBuf buf){
        this(syncId, playerInventory, playerInventory.player.getWorld().getBlockEntity(buf.readBlockPos()),
                new ArrayPropertyDelegate(AbstractEnergyCookerBlockEntity.DELEGATE_SIZE));
    }
    @Override
    protected boolean isRecipeItem(ItemStack item) {
        return false;
    }
}
