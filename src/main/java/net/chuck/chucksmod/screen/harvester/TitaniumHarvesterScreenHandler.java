package net.chuck.chucksmod.screen.harvester;

import net.chuck.chucksmod.block.entity.harvester.AbstractHarvesterBlockEntity;
import net.chuck.chucksmod.block.entity.harvester.TitaniumHarvesterBlockEntity;
import net.chuck.chucksmod.block.entity.quarry.TitaniumQuarryBlockEntity;
import net.chuck.chucksmod.screen.ModScreenHandlers;
import net.chuck.chucksmod.screen.slot.SeedSlot;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;

public class TitaniumHarvesterScreenHandler extends AbstractHarvesterScreenHandler{
    public TitaniumHarvesterScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity entity,
                                          PropertyDelegate delegate) {
        super(syncId, playerInventory, entity, delegate, ModScreenHandlers.TITANIUM_HARVESTER_SCREEN_HANDLER,
                TitaniumHarvesterBlockEntity.HARVESTER_SEEDS_INV_SIZE,
                TitaniumHarvesterBlockEntity.HARVESTER_CROPS_INV_SIZE);

    }
    public TitaniumHarvesterScreenHandler(int syncId, PlayerInventory inventory, PacketByteBuf buf){
        this(syncId, inventory, inventory.player.getWorld().getBlockEntity(buf.readBlockPos()),
                new ArrayPropertyDelegate(AbstractHarvesterBlockEntity.DELEGATE_SIZE));
    }

    @Override
    public void addSeedSlots() {
        this.addSlot(new SeedSlot(inventory, 0, 8, 26));
        this.addSlot(new SeedSlot(inventory, 1, 26, 26));
        this.addSlot(new SeedSlot(inventory, 2, 8, 44));
        this.addSlot(new SeedSlot(inventory, 3, 26, 44));
    }

    @Override
    public void addCropSlots() {
        for(int i=0;i<2;++i) {
            for(int j=0;j<5;++j) {
                this.addSlot(new Slot(cropInventory, j + i*5, 62 + j*18, 26 + i*18));
            }
        }
    }

    @Override
    public int getStartOfSeedInventory() {
        return 36;
    }

    @Override
    public int getEndOfSeedInventory() {
        return 39;
    }

    @Override
    public int getStartOfCropInventory() {
        return 40;
    }

    @Override
    public int getEndOfCropInventory() {
        return 49;
    }
}
