package net.chuck.chucksmod.block.entity.furnace;

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
import net.minecraft.recipe.*;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import team.reborn.energy.api.base.SimpleEnergyStorage;

public abstract class AbstractPoweredFurnaceBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory,
        ImplementedInventory {
    public static final int INPUT_SLOT = 0;
    public static final int OUTPUT_SLOT = 1;
    public static final int PROGRESS_IDX = 0;
    public static final int MAX_PROGRESS_IDX = 1;
    public static final int DELEGATE_SIZE = 2;
    public static final int INV_SIZE = 2;
    protected final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(INV_SIZE, ItemStack.EMPTY);
    public final SimpleEnergyStorage energyStorage;
    protected final PropertyDelegate propertyDelegate;
    protected int progress = 0;
    protected int maxProgress;
    private final RecipeManager.MatchGetter<Inventory, SmeltingRecipe> matchGetter;
    public AbstractPoweredFurnaceBlockEntity(BlockEntityType entity, BlockPos pos, BlockState state,
                                             int energyStorageSize, int maxProgress, int maxInsertExtract) {
        super(entity, pos, state);
        this.matchGetter = RecipeManager.createCachedMatchGetter(RecipeType.SMELTING);
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
                    case PROGRESS_IDX: return AbstractPoweredFurnaceBlockEntity.this.progress;
                    case MAX_PROGRESS_IDX: return AbstractPoweredFurnaceBlockEntity.this.maxProgress;
                    default: return PROGRESS_IDX;
                }
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case PROGRESS_IDX: AbstractPoweredFurnaceBlockEntity.this.progress = value; break;
                    case MAX_PROGRESS_IDX: AbstractPoweredFurnaceBlockEntity.this.maxProgress = value; break;
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
        nbt.putInt("powered_furnace.progress", progress);
        nbt.putLong("powered_furnace.energy", energyStorage.amount);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
        progress = nbt.getInt("powered_furnace.progress");
        energyStorage.amount= nbt.getLong("powered_furnace.energy");
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

    private void resetProgress() {
        this.progress = 0;
    }

    private void craftItem() {
        RecipeEntry<SmeltingRecipe> recipe = getCurrentRecipe();
        if(recipe != null){
            this.removeStack(INPUT_SLOT,1);
            this.setStack(OUTPUT_SLOT, new ItemStack(recipe.value().getResult(null).getItem(),
                    getStack(OUTPUT_SLOT).getCount() + recipe.value().getResult(null).getCount()));
        }
    }

    private boolean hasCraftingFinished() {
        return progress >= maxProgress;
    }

    private void increaseCraftProgress() {
        progress++;
    }

    private boolean hasRecipe() {
        RecipeEntry<SmeltingRecipe> recipe = getCurrentRecipe();
        return recipe != null && canInsertAmountIntoOutputSlot(recipe.value().getResult(null))
                && canInsertItemIntoOutputSlot(recipe.value().getResult(null).getItem());
    }

    private RecipeEntry<SmeltingRecipe> getCurrentRecipe() {
        return this.matchGetter.getFirstMatch(this, world).orElse(null);
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
    private boolean canInsertItemIntoOutputSlot(Item output) {
        return this.getStack(OUTPUT_SLOT).getItem() == output || this.getStack(OUTPUT_SLOT).isEmpty();
    }

    private boolean canInsertAmountIntoOutputSlot(ItemStack result) {
        return this.getStack(OUTPUT_SLOT).getMaxCount() > this.getStack(OUTPUT_SLOT).getCount();
    }
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }
}
