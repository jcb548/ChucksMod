package net.chuck.chucksmod.block.entity.crusher;

import net.chuck.chucksmod.networking.ModMessages;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.block.AbstractFurnaceBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import team.reborn.energy.api.base.SimpleEnergyStorage;

public abstract class AbstractPoweredCrusherBlockEntity extends AbstractCrusherBlockEntity{
    public static final int DELEGATE_SIZE = 2;
    public static final int INV_SIZE = 2;
    protected final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(INV_SIZE, ItemStack.EMPTY);
    public final SimpleEnergyStorage energyStorage;
    protected final PropertyDelegate propertyDelegate;
    public AbstractPoweredCrusherBlockEntity(BlockEntityType entity, BlockPos pos, BlockState state,
                                             int energyStorageSize, int maxProgress, int maxInsertExtract) {
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
        this.maxProgress = maxProgress;
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                switch (index){
                    case PROGRESS_IDX: return AbstractPoweredCrusherBlockEntity.this.progress;
                    case MAX_PROGRESS_IDX: return AbstractPoweredCrusherBlockEntity.this.maxProgress;
                    default: return PROGRESS_IDX;
                }
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case PROGRESS_IDX: AbstractPoweredCrusherBlockEntity.this.progress = value; break;
                    case MAX_PROGRESS_IDX: AbstractPoweredCrusherBlockEntity.this.maxProgress = value; break;
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
        blockState = (BlockState)blockState.with(AbstractFurnaceBlock.LIT, isCrafting());
        world.setBlockState(blockPos, blockState, Block.NOTIFY_ALL);
    }
    public void setEnergyLevel(long energyLevel){
        this.energyStorage.amount = energyLevel;
    }

    private void extractEnergy() {
        try(Transaction transaction = Transaction.openOuter()){
            this.energyStorage.extract(this.getEnergyUsage(), transaction);
            transaction.commit();
        }
    }
    private boolean hasEnoughEnergy() {
        return this.energyStorage.amount >= getEnergyUsage();
    }
    private boolean isCrafting(){
        return progress > 0;
    }
    protected abstract int getEnergyUsage();
}
