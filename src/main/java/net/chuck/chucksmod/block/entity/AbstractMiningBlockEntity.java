package net.chuck.chucksmod.block.entity;

import net.chuck.chucksmod.block.custom.AbstractEnergyUsingBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class AbstractMiningBlockEntity extends AbstractEnergyUsingBlockEntity{
    public static final int PROGRESS_IDX = 0;
    public static final int MAX_PROGRESS_IDX = 1;
    public static final int DELEGATE_SIZE = 2;
    protected int progress = 0;
    protected int maxProgress;
    protected int minOffsetX;
    protected int maxOffsetX;
    protected int minOffsetZ;
    protected int maxOffsetZ;
    public int xPos;
    public int yPos;
    public int zPos;
    protected boolean shouldResetPos = false;
    protected final PropertyDelegate propertyDelegate;
    public AbstractMiningBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state,
                                     int invSize, int energyStorageSize, int maxProgress , int maxInsertExtract) {
        super(type, pos, state, invSize, energyStorageSize, maxInsertExtract);
        this.maxProgress = maxProgress;
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                switch (index){
                    case PROGRESS_IDX: return AbstractMiningBlockEntity.this.progress;
                    case MAX_PROGRESS_IDX: return AbstractMiningBlockEntity.this.maxProgress;
                    default: return PROGRESS_IDX;
                }
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case PROGRESS_IDX: AbstractMiningBlockEntity.this.progress = value; break;
                    case MAX_PROGRESS_IDX: AbstractMiningBlockEntity.this.maxProgress = value; break;
                }
            }
            @Override
            public int size() {
                return DELEGATE_SIZE;
            }
        };
        resetPos();
        setupOffsets(getSize());
    }
    protected BlockPos getNextBlockPos(){
        int xOffset = minOffsetX + xPos;
        int zOffset = minOffsetZ + zPos;
        BlockPos newPos = new BlockPos(pos.getX() + xOffset, yPos, pos.getZ() + zOffset);
        xPos++;
        if(xPos>=getSize()){
            xPos = 0;
            zPos++;
            if(zPos>=getSize()){
                zPos = 0;
                yPos--;
            }
        }
        return newPos;
    }
    protected void increaseProgress(){
        progress++;
    }
    protected boolean shouldBreakBlock(){
        return progress >= maxProgress;
    }
    protected abstract int getSize();
    protected void resetProgress(){
        progress = 0;
    }
    /*
     * Facing:
     * west: -x
     * east: +x
     * north: -z
     * south: +z
     * */

    protected void setupOffsets(int quarrySize){
        switch(getCachedState().get(AbstractEnergyUsingBlock.FACING)){
            case NORTH -> {
                this.minOffsetX = -(quarrySize/2);
                this.maxOffsetX = quarrySize/2;
                this.minOffsetZ = -quarrySize;
                this.maxOffsetZ = 0;
            }
            case SOUTH -> {
                this.minOffsetX = -(quarrySize/2);
                this.maxOffsetX = quarrySize/2;
                this.minOffsetZ = quarrySize;
                this.maxOffsetZ = 0;
            }
            case EAST -> {
                this.minOffsetX = 0;
                this.maxOffsetX = quarrySize;
                this.minOffsetZ = -(quarrySize/2);
                this.maxOffsetZ = quarrySize/2;
            }
            default -> {
                this.minOffsetX = -quarrySize;
                this.maxOffsetX = 0;
                this.minOffsetZ = -(quarrySize/2);
                this.maxOffsetZ = quarrySize/2;
            }
        }
    }
    protected void resetPos(){
        this.xPos = 0;
        this.yPos = pos.getY()+2;
        this.zPos = 0;
        shouldResetPos = false;
    }
    public void shouldResetPos(){
        this.shouldResetPos = true;
    }
    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.putInt("mining_block.xPos", xPos);
        nbt.putInt("mining_block.yPos", yPos);
        nbt.putInt("mining_block.zPos", zPos);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        xPos = nbt.getInt("mining_block.xPos");
        yPos = nbt.getInt("mining_block.yPos");
        zPos = nbt.getInt("mining_block.zPos");
    }
    public void tick(World world, BlockPos pos, BlockState blockState) {
        if (shouldResetPos) {
            resetPos();
        }
    }
}
