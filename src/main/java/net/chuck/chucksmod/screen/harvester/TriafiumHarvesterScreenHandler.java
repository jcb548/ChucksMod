package net.chuck.chucksmod.screen.harvester;

import net.chuck.chucksmod.block.entity.harvester.AbstractHarvesterBlockEntity;
import net.chuck.chucksmod.block.entity.harvester.TriafiumHarvesterBlockEntity;
import net.chuck.chucksmod.screen.ModScreenHandlers;
import net.chuck.chucksmod.screen.slot.SeedSlot;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.slot.Slot;

public class TriafiumHarvesterScreenHandler extends AbstractHarvesterScreenHandler{
    public TriafiumHarvesterScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity entity,
                                          PropertyDelegate delegate) {
        super(syncId, playerInventory, entity, delegate, ModScreenHandlers.TRIAFIUM_HARVESTER_SCREEN_HANDLER,
                TriafiumHarvesterBlockEntity.HARVESTER_SEEDS_INV_SIZE,
                TriafiumHarvesterBlockEntity.HARVESTER_CROPS_INV_SIZE);

    }
    public TriafiumHarvesterScreenHandler(int syncId, PlayerInventory inventory, PacketByteBuf buf){
        this(syncId, inventory, inventory.player.getWorld().getBlockEntity(buf.readBlockPos()),
                new ArrayPropertyDelegate(AbstractHarvesterBlockEntity.DELEGATE_SIZE));
    }

    @Override
    public void addSeedSlots() {
        this.addSlot(new SeedSlot(inventory, 0, 8, 17));
        this.addSlot(new SeedSlot(inventory, 1, 26, 17));
        this.addSlot(new SeedSlot(inventory, 2, 8, 35));
        this.addSlot(new SeedSlot(inventory, 3, 26, 35));
        this.addSlot(new SeedSlot(inventory, 4, 8, 53));
        this.addSlot(new SeedSlot(inventory, 5, 26, 53));
    }

    @Override
    public void addCropSlots() {
        for(int i=0;i<3;++i) {
            for(int j=0;j<5;++j) {
                this.addSlot(new Slot(cropInventory, j + i*5, 62 + j*18, 17 + i*18));
            }
        }
    }

    @Override
    public int getStartOfSeedInventory() {
        return 36;
    }

    @Override
    public int getEndOfSeedInventory() {
        return 41;
    }

    @Override
    public int getStartOfCropInventory() {
        return 42;
    }

    @Override
    public int getEndOfCropInventory() {
        return 56;
    }
}
