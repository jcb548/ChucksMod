package net.chuck.chucksmod.screen.copier;

import net.chuck.chucksmod.block.entity.AbstractEnergyCookerBlockEntity;
import net.chuck.chucksmod.block.entity.FluidStoring;
import net.chuck.chucksmod.block.entity.copier.AbstractCopierBlockEntity;
import net.chuck.chucksmod.screen.AbstractEnergyCookerScreenHandler;
import net.chuck.chucksmod.screen.FluidDisplayingScreenHandler;
import net.chuck.chucksmod.screen.ModScreenHandlers;
import net.chuck.chucksmod.screen.slot.BucketSlot;
import net.chuck.chucksmod.screen.slot.SingleItemFilterSlot;
import net.chuck.chucksmod.util.FluidStack;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.BucketItem;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.slot.Slot;

public class CopierScreenHandler extends AbstractEnergyCookerScreenHandler implements FluidDisplayingScreenHandler {
    protected final static int BOOK_SCREEN_SLOT_IDX = 38;
    protected final static int XP_BUCKET_SLOT_IDX = 39;
    public AbstractCopierBlockEntity copier;
    public CopierScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity entity,
                                  PropertyDelegate delegate) {
        super(syncId, playerInventory, entity, delegate, ModScreenHandlers.COPIER_SCREEN_HANDLER,
                AbstractCopierBlockEntity.INV_SIZE);
        this.addSlot(new SingleItemFilterSlot(inventory, AbstractCopierBlockEntity.INPUT_SLOT, 28, 37,
                Items.ENCHANTED_BOOK));
        this.addSlot(new Slot(inventory, AbstractCopierBlockEntity.OUTPUT_SLOT, 135, 37));
        this.addSlot(new SingleItemFilterSlot(inventory, AbstractCopierBlockEntity.BOOK_SLOT, 77, 37,
                Items.BOOK));
        this.addSlot(new BucketSlot(inventory, AbstractCopierBlockEntity.XP_BUCKET_SLOT, 28, 15));
        if(this.blockEntity instanceof AbstractCopierBlockEntity) {
            copier = (AbstractCopierBlockEntity) blockEntity;
        }
        setFluidStack(new FluidStack(copier.fluidStorage.variant, copier.fluidStorage.amount));

    }
    public CopierScreenHandler(int syncId, PlayerInventory inventory, PacketByteBuf buf){
        this(syncId, inventory, inventory.player.getWorld().getBlockEntity(buf.readBlockPos()),
                new ArrayPropertyDelegate(AbstractEnergyCookerBlockEntity.DELEGATE_SIZE));
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot originalSlot = this.slots.get(invSlot);
        if(originalSlot != null && originalSlot.hasStack()){
            ItemStack oldStack = originalSlot.getStack();
            if(invSlot == OUTPUT_SCREEN_SLOT_IDX){
                if(!this.insertItem(oldStack, PLAYER_INVENTORY_START_IDX, PLAYER_INVENTORY_END_IDX+1, false)){
                    return ItemStack.EMPTY;
                }
                originalSlot.onQuickTransfer(oldStack, newStack);
            } else if(invSlot == INPUT_SCREEN_SLOT_IDX){
                if(!this.insertItem(oldStack, PLAYER_INVENTORY_START_IDX, PLAYER_INVENTORY_END_IDX+1, true)){
                    return newStack;
                }
            } else {
                if(oldStack.isEmpty()){
                    originalSlot.setStack(ItemStack.EMPTY);
                } else if(isRecipeItem(oldStack)){
                    if(!this.insertItem(oldStack, INPUT_SCREEN_SLOT_IDX, INPUT_SCREEN_SLOT_IDX+1, true)){
                        return ItemStack.EMPTY;
                    }
                    originalSlot.markDirty();
                } else if (oldStack.getItem().equals(Items.BOOK)){
                    if(!this.insertItem(oldStack, BOOK_SCREEN_SLOT_IDX, BOOK_SCREEN_SLOT_IDX+1, true)){
                        return ItemStack.EMPTY;
                    }
                    originalSlot.markDirty();
                } else if(oldStack.getItem() instanceof BucketItem){
                    if(!this.insertItem(oldStack, XP_BUCKET_SLOT_IDX, XP_BUCKET_SLOT_IDX+1, true)){
                        return ItemStack.EMPTY;
                    }
                    originalSlot.markDirty();
                } else {
                    if(invSlot < 9) {
                        if (!this.insertItem(oldStack, 9, PLAYER_INVENTORY_END_IDX, false)) {
                            return ItemStack.EMPTY;
                        }
                    } else {
                        if (!this.insertItem(oldStack, PLAYER_INVENTORY_START_IDX, 9, false)) {
                            return ItemStack.EMPTY;
                        }
                    }
                    originalSlot.setStack(ItemStack.EMPTY);
                }
                if(oldStack.getCount() == newStack.getCount()){
                    return ItemStack.EMPTY;
                }
                originalSlot.markDirty();
            }
        }
        return newStack;
    }

    @Override
    protected boolean isRecipeItem(ItemStack item) {
        return item.getItem() instanceof EnchantedBookItem;
    }
    @Override
    public FluidStoring getFluidStoring() {
        return copier;
    }
}
