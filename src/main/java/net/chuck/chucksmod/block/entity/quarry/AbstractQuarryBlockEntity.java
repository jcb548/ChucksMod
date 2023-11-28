package net.chuck.chucksmod.block.entity.quarry;

import net.chuck.chucksmod.block.custom.AbstractEnergyUsingBlock;
import net.chuck.chucksmod.block.entity.AbstractEnergyUsingBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public abstract class AbstractQuarryBlockEntity extends AbstractEnergyUsingBlockEntity {
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
    private boolean shouldResetPos = false;
    protected final PropertyDelegate propertyDelegate;
    public AbstractQuarryBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state,
                                     int invSize, int energyStorageSize, int maxProgress, int maxInsertExtract) {
        super(type, pos, state, invSize, energyStorageSize, maxInsertExtract);
        this.maxProgress = maxProgress;
        resetPos();
        setupOffsets(getQuarrySize());
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                switch (index){
                    case PROGRESS_IDX: return AbstractQuarryBlockEntity.this.progress;
                    case MAX_PROGRESS_IDX: return AbstractQuarryBlockEntity.this.maxProgress;
                    default: return PROGRESS_IDX;
                }
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case PROGRESS_IDX: AbstractQuarryBlockEntity.this.progress = value; break;
                    case MAX_PROGRESS_IDX: AbstractQuarryBlockEntity.this.maxProgress = value; break;
                }
            }
            @Override
            public int size() {
                return DELEGATE_SIZE;
            }
        };
    }
    public void tick(World world, BlockPos pos, BlockState blockState) {
        if (world.isClient()){
            return;
        }
        ServerWorld serverWorld = (ServerWorld) world;
        if(shouldResetPos){
            xPos = 0;
            yPos = this.getPos().getY()+2;
            zPos = 0;
            shouldResetPos = false;
        }
        boolean shouldTryMine = world.isReceivingRedstonePower(pos) && this.hasEnoughEnergy() && yPos>-64;
        if(shouldTryMine){
            this.increaseProgress();
            this.extractEnergy();
            markDirty(world, pos, blockState);
            if(shouldBreakBlock()){
                /*if(!world.getPlayers().isEmpty()) {
                    for(int i=0; i< world.getPlayers().size(); i++) {
                        world.getPlayers().get(i).sendMessage(Text.literal("xPos: " + xPos + ", yPos: " + yPos +
                                ", zPos: " + zPos));
                    }
                }*/
                BlockPos nextBlockPos = getNextBlockPos();
                BlockState nextBlockState = world.getBlockState(nextBlockPos);
                if(isBreakable(nextBlockState) && canBreak(nextBlockState)) {
                    List<ItemStack> drops = Block.getDroppedStacks(nextBlockState, serverWorld, nextBlockPos,
                            serverWorld.getBlockEntity(nextBlockPos), null, getTool());
                    for (int i = 0; i < drops.size(); i++) {
                        ItemStack excess = inventory.addStack(drops.get(i));
                        if (!excess.equals(ItemStack.EMPTY)) {
                            ItemEntity items = new ItemEntity(serverWorld, pos.getX() + 0.5, pos.getY() + 1,
                                    pos.getZ() + 0.5, excess);
                            world.spawnEntity(items);
                        }
                    }
                    world.breakBlock(nextBlockPos, false);
                }
                this.resetProgress();
            }

        }
        blockState = blockState.with(AbstractEnergyUsingBlock.LIT, shouldTryMine);
        world.setBlockState(pos, blockState, Block.NOTIFY_ALL);
    }

    private boolean isBreakable(BlockState state){
        return !state.isIn(BlockTags.WITHER_IMMUNE) &&  !state.isLiquid();
    }
    protected abstract boolean canBreak(BlockState state);
    /*
     * Facing:
     * west: -x
     * east: +x
     * north: -z
     * south: +z
     * */

    private void setupOffsets(int quarrySize){
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
    private BlockPos getNextBlockPos(){
        int xOffset = minOffsetX + xPos;
        int zOffset = minOffsetZ + zPos;
        BlockPos newPos = new BlockPos(pos.getX() + xOffset, yPos, pos.getZ() + zOffset);
        xPos++;
        if(xPos>=getQuarrySize()){
            xPos = 0;
            zPos++;
            if(zPos>=getQuarrySize()){
                zPos = 0;
                yPos--;
            }
        }
        return newPos;
    }
    private void increaseProgress(){
        progress++;
    }
    private boolean shouldBreakBlock(){
        return progress >= maxProgress;
    }
    protected abstract int getQuarrySize();
    private void resetProgress(){
        progress = 0;
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.putInt("quarry.xPos", xPos);
        nbt.putInt("quarry.yPos", yPos);
        nbt.putInt("quarry.zPos", zPos);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        xPos = nbt.getInt("quarry.xPos");
        yPos = nbt.getInt("quarry.yPos");
        zPos = nbt.getInt("quarry.zPos");
    }
    public abstract ItemStack getTool();

    private void resetPos(){
        this.xPos = 0;
        this.yPos = pos.getY()-1;
        this.zPos = 0;
    }
    public void shouldResetPos(){
        this.shouldResetPos = true;
    }
}
