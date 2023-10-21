package net.chuck.chucksmod.block.entity;

import net.chuck.chucksmod.networking.ModMessages;
import net.chuck.chucksmod.screen.crusher.PoweredCrusherScreenHandler;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import team.reborn.energy.api.base.SimpleEnergyStorage;

/*
 *  Code inspired by or copied from
 *  Kaupenjoe
 *  Copyright (c) 2023
 *
 *  This code is licensed under MIT License
 *  Details can be found in the license file in the root folder of this project
 */
public class PoweredCrusherBlockEntity extends AbstractCrusherBlockEntity {
    public static final int MAX_INSERT = 32;
    public static final int MAX_EXTRACT = MAX_INSERT;
    public static final int DELEGATE_SIZE = 2;
    public static final int INV_SIZE = 2;
    public static final int ENERGY_STORAGE = 30000;
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(INV_SIZE, ItemStack.EMPTY);
    public final SimpleEnergyStorage energyStorage = new SimpleEnergyStorage(ENERGY_STORAGE, MAX_INSERT, MAX_EXTRACT){
        @Override
        protected void onFinalCommit() {
            markDirty();
            if(!world.isClient()){
                PacketByteBuf data = PacketByteBufs.create();
                data.writeLong(amount);
                data.writeBlockPos(getPos());

                for(ServerPlayerEntity player : PlayerLookup.tracking((ServerWorld) world, getPos())){
                    ServerPlayNetworking.send(player, ModMessages.ENERGY_SYNC, data);
                }
            }

        }
    };
    protected final PropertyDelegate propertyDelegate;
    public PoweredCrusherBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.POWERED_CRUSHER, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                switch (index){
                    case PROGRESS_IDX: return PoweredCrusherBlockEntity.this.progress;
                    case MAX_PROGRESS_IDX: return PoweredCrusherBlockEntity.this.maxProgress;
                    default: return PROGRESS_IDX;
                }
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case PROGRESS_IDX: PoweredCrusherBlockEntity.this.progress = value; break;
                    case MAX_PROGRESS_IDX: PoweredCrusherBlockEntity.this.maxProgress = value; break;
                }
            }
            @Override
            public int size() {
                return DELEGATE_SIZE;
            }
        };
    }
    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.inventory;
    }

    @Override
    public Text getDisplayName() {
        return Text.literal("Powered Crusher");
    }
    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        this.markDirty();
        return new PoweredCrusherScreenHandler(syncId, playerInventory, this, propertyDelegate);
    }
    // For saving nbt on world close
    @Override
    protected void writeNbt(NbtCompound nbt) {
        Inventories.writeNbt(nbt, inventory);
        super.writeNbt(nbt);
        nbt.putInt("powered_crusher.progress", progress);
        nbt.putLong("powered_crusher.energy", energyStorage.amount);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
        progress = nbt.getInt("powered_crusher.progress");
        energyStorage.amount= nbt.getLong("powered_crusher.energy");
    }
    public void tick(World world, BlockPos blockPos, BlockState blockState) {
        if (world.isClient()){
            return;
        }
        if(this.hasRecipe() && this.hasEnoughEnergy()){
            this.increaseCraftProgress();
            this.extractEnergy();
            markDirty(world, blockPos, blockState);
            if(this.hasCraftingFinished()){
                this.craftItem();
                this.resetProgress();
            }
        } else {
            this.resetProgress();
            markDirty(world, blockPos, blockState);
        }
    }
    public void setEnergyLevel(long energyLevel){
        this.energyStorage.amount = energyLevel;
    }

    private void extractEnergy() {
        try(Transaction transaction = Transaction.openOuter()){
            this.energyStorage.extract(32, transaction);
            transaction.commit();
        }
    }

    private boolean hasEnoughEnergy() {
        return this.energyStorage.amount >= 32;
    }
}
