package net.chuck.chucksmod.block.entity.energy_storage;

import net.chuck.chucksmod.block.entity.ImplementedInventory;
import net.chuck.chucksmod.networking.ModMessages;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.block.AbstractFurnaceBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.SmeltingRecipe;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import team.reborn.energy.api.base.SimpleEnergyStorage;

public abstract class AbstractEnergyStorageBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory,
        ImplementedInventory {
    public static final int INPUT_SLOT = 0;
    public static final int INV_SIZE = 1;
    protected final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(INV_SIZE, ItemStack.EMPTY);
    public final SimpleEnergyStorage energyStorage;
    public AbstractEnergyStorageBlockEntity(BlockEntityType entity, BlockPos pos, BlockState state,
                                            int energyStorageSize, int maxInsertExtract) {
        super(entity, pos, state);
        energyStorage = new SimpleEnergyStorage(energyStorageSize, maxInsertExtract, maxInsertExtract){
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
    }
    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.inventory;
    }
    // For saving nbt on world close
    @Override
    protected void writeNbt(NbtCompound nbt) {
        Inventories.writeNbt(nbt, inventory);
        super.writeNbt(nbt);
        nbt.putLong("energy_storage.energy", energyStorage.amount);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
        energyStorage.amount= nbt.getLong("energy_storage.energy");
    }
    public void tick(World world, BlockPos blockPos, BlockState blockState) {
        if (world.isClient()){
            return;
        }
    }

    public void setEnergyLevel(long energyLevel){
        this.energyStorage.amount = energyLevel;
    }
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }
}
