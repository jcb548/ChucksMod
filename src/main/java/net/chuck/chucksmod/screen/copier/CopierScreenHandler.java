package net.chuck.chucksmod.screen.copier;

import net.chuck.chucksmod.block.entity.AbstractEnergyCookerBlockEntity;
import net.chuck.chucksmod.block.entity.copier.AbstractCopierBlockEntity;
import net.chuck.chucksmod.block.entity.furnace.AbstractPoweredFurnaceBlockEntity;
import net.chuck.chucksmod.networking.ModMessages;
import net.chuck.chucksmod.screen.AbstractEnergyCookerScreenHandler;
import net.chuck.chucksmod.screen.AbstractEnergyUsingScreenHandler;
import net.chuck.chucksmod.screen.ModScreenHandlers;
import net.chuck.chucksmod.util.FluidStack;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;
import net.minecraft.text.Text;

public class CopierScreenHandler extends AbstractEnergyCookerScreenHandler {
    protected final static int BOOK_SCREEN_SLOT_IDX = 38;
    protected final static int XP_BUCKET_SLOT_IDX = 39;

    public FluidStack fluidStack;
    public AbstractCopierBlockEntity copier;
    public CopierScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity entity,
                                  PropertyDelegate delegate) {
        super(syncId, playerInventory, entity, delegate, ModScreenHandlers.COPIER_SCREEN_HANDLER,
                AbstractCopierBlockEntity.INV_SIZE);
        this.addSlot(new Slot(inventory, AbstractCopierBlockEntity.INPUT_SLOT, 28, 37));
        this.addSlot(new Slot(inventory, AbstractCopierBlockEntity.OUTPUT_SLOT, 135, 37));
        this.addSlot(new Slot(inventory, AbstractCopierBlockEntity.BOOK_SLOT, 77, 37));
        this.addSlot(new Slot(inventory, AbstractCopierBlockEntity.XP_BUCKET_SLOT, 28, 15));
        if(this.blockEntity instanceof AbstractCopierBlockEntity) copier =
                (AbstractCopierBlockEntity) blockEntity;
        this.fluidStack = new FluidStack(copier.fluidStorage.variant, copier.fluidStorage.amount);

    }
    public CopierScreenHandler(int syncId, PlayerInventory inventory, PacketByteBuf buf){
        this(syncId, inventory, inventory.player.getWorld().getBlockEntity(buf.readBlockPos()),
                new ArrayPropertyDelegate(AbstractEnergyCookerBlockEntity.DELEGATE_SIZE));
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slot) {
        return null;
    }

    @Override
    protected boolean isRecipeItem(ItemStack item) {
        return false;
    }
    public int getScaledProgress() {
        int progress = this.propertyDelegate.get(AbstractEnergyCookerBlockEntity.PROGRESS_IDX);
        int maxProgress = this.propertyDelegate.get(AbstractEnergyCookerBlockEntity.MAX_PROGRESS_IDX);
        int progressArrowSize = 22;

        return maxProgress != 0 && progress != 0 ? progress * progressArrowSize / maxProgress : 0;
    }

    public void onButtonPress(){
        PacketByteBuf buf = PacketByteBufs.create();
        buf.writeBlockPos(blockEntity.getPos());
        ClientPlayNetworking.send(ModMessages.COPIER_XP_DRAIN, buf);
    }

    public void setXp(FluidStack stack) {
        fluidStack = stack;
    }
}
