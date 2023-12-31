package net.chuck.chucksmod.screen.copier;

import net.chuck.chucksmod.block.entity.AbstractEnergyCookerBlockEntity;
import net.chuck.chucksmod.block.entity.copier.AbstractCopierBlockEntity;
import net.chuck.chucksmod.block.entity.furnace.AbstractPoweredFurnaceBlockEntity;
import net.chuck.chucksmod.networking.ModMessages;
import net.chuck.chucksmod.screen.AbstractEnergyCookerScreenHandler;
import net.chuck.chucksmod.screen.AbstractEnergyUsingScreenHandler;
import net.chuck.chucksmod.screen.ModScreenHandlers;
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
    public AbstractCopierBlockEntity copier;
    public CopierScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity entity,
                                  PropertyDelegate delegate, long energy, int xp) {
        super(syncId, playerInventory, entity, delegate, ModScreenHandlers.COPIER_SCREEN_HANDLER,
                AbstractCopierBlockEntity.INV_SIZE);
        this.addSlot(new Slot(inventory, AbstractCopierBlockEntity.INPUT_SLOT, 27, 37));
        this.addSlot(new Slot(inventory, AbstractCopierBlockEntity.OUTPUT_SLOT, 134, 37));
        this.addSlot(new Slot(inventory, AbstractCopierBlockEntity.BOOK_SLOT, 76, 37));
        this.blockEntity.setEnergyLevel(energy);
        if(this.blockEntity instanceof AbstractCopierBlockEntity) copier =
                (AbstractCopierBlockEntity) blockEntity;
        this.copier.xp = xp;

    }
    public CopierScreenHandler(int syncId, PlayerInventory inventory, PacketByteBuf buf){
        this(syncId, inventory, inventory.player.getWorld().getBlockEntity(buf.readBlockPos()),
                new ArrayPropertyDelegate(AbstractEnergyCookerBlockEntity.DELEGATE_SIZE), buf.readLong(),
                buf.readInt());
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
}
