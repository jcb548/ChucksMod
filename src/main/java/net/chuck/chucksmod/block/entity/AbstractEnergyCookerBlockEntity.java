package net.chuck.chucksmod.block.entity;

import net.chuck.chucksmod.block.custom.AbstractEnergyCookerBlock;
import net.chuck.chucksmod.block.custom.AbstractEnergyUsingBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractEnergyCookerBlockEntity extends AbstractEnergyUsingBlockEntity{
    public static final int OUTPUT_SLOT = 1;
    public static final int PROGRESS_IDX = 0;
    public static final int MAX_PROGRESS_IDX = 1;
    public static final int DELEGATE_SIZE = 2;
    public static final int INV_SIZE = 2;
    protected int progress = 0;
    protected int maxProgress;
    protected final PropertyDelegate propertyDelegate;
    public AbstractEnergyCookerBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state,
                                           int energyStorageSize, int maxProgress, int maxInsertExtract) {
        super(type, pos, state, INV_SIZE, energyStorageSize, maxInsertExtract);
        this.maxProgress = maxProgress;
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                switch (index){
                    case PROGRESS_IDX: return AbstractEnergyCookerBlockEntity.this.progress;
                    case MAX_PROGRESS_IDX: return AbstractEnergyCookerBlockEntity.this.maxProgress;
                    default: return PROGRESS_IDX;
                }
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case PROGRESS_IDX: AbstractEnergyCookerBlockEntity.this.progress = value; break;
                    case MAX_PROGRESS_IDX: AbstractEnergyCookerBlockEntity.this.maxProgress = value; break;
                }
            }
            @Override
            public int size() {
                return DELEGATE_SIZE;
            }
        };
    }
    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.putInt("cooker.progress", progress);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        progress = nbt.getInt("cooker.progress");
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
        blockState = blockState.with(AbstractEnergyCookerBlock.LIT, isCrafting());
        world.setBlockState(blockPos, blockState, Block.NOTIFY_ALL);
    }
    private void resetProgress() {
        this.progress = 0;
    }

    protected abstract void craftItem();

    private boolean hasCraftingFinished() {
        return progress >= maxProgress;
    }

    private void increaseCraftProgress() {
        progress++;
    }

    protected abstract boolean hasRecipe();
    protected boolean canInsertItemIntoOutputSlot(Item output) {
        return this.getStack(OUTPUT_SLOT).getItem() == output || this.getStack(OUTPUT_SLOT).isEmpty();
    }

    protected boolean canInsertAmountIntoOutputSlot() {
        return this.getStack(OUTPUT_SLOT).getMaxCount() > this.getStack(OUTPUT_SLOT).getCount();
    }
    private boolean isCrafting(){
        return progress > 0;
    }
    @Override
    public boolean canInsert(int slot, ItemStack stack, @Nullable Direction side) {
        if(side == this.getWorld().getBlockState(this.pos).get(AbstractEnergyUsingBlock.FACING)){
            return false;
        } else {
            return slot == INPUT_SLOT;
        }
    }

    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction side) {
        if(side == this.getWorld().getBlockState(this.pos).get(AbstractEnergyUsingBlock.FACING)){
            return false;
        }
        else {
            return slot == OUTPUT_SLOT;
        }
    }
}
