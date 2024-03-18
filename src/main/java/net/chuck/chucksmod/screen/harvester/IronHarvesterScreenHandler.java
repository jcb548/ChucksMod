package net.chuck.chucksmod.screen.harvester;

import net.chuck.chucksmod.block.entity.harvester.AbstractHarvesterBlockEntity;
import net.chuck.chucksmod.block.entity.harvester.IronHarvesterBlockEntity;
import net.chuck.chucksmod.screen.ModScreenHandlers;
import net.chuck.chucksmod.screen.slot.SeedSlot;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.slot.Slot;

public class IronHarvesterScreenHandler extends AbstractHarvesterScreenHandler{
    public IronHarvesterScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity entity,
                                      PropertyDelegate delegate) {
        super(syncId, playerInventory, entity, delegate, ModScreenHandlers.IRON_HARVESTER_SCREEN_HANDLER,
                IronHarvesterBlockEntity.HARVESTER_SEEDS_INV_SIZE,
                IronHarvesterBlockEntity.HARVESTER_CROPS_INV_SIZE);

    }
    public IronHarvesterScreenHandler(int syncId, PlayerInventory inventory, PacketByteBuf buf){
        this(syncId, inventory, inventory.player.getWorld().getBlockEntity(buf.readBlockPos()),
                new ArrayPropertyDelegate(AbstractHarvesterBlockEntity.DELEGATE_SIZE));
    }

    @Override
    public void addSeedSlots() {
        this.addSlot(new SeedSlot(inventory, 0, 8, 35));
        this.addSlot(new SeedSlot(inventory, 1, 26, 35));
    }

    @Override
    public void addCropSlots() {
        for(int j=0;j<5;++j) {
            this.addSlot(new Slot(cropInventory, j, 62 + j*18, 35));
        }
    }

    @Override
    public int getStartOfSeedInventory() {
        return 36;
    }

    @Override
    public int getEndOfSeedInventory() {
        return 37;
    }

    @Override
    public int getStartOfCropInventory() {
        return 38;
    }

    @Override
    public int getEndOfCropInventory() {
        return 42;
    }
}
