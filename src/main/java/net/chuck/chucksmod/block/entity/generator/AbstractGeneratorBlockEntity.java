package net.chuck.chucksmod.block.entity.generator;

import net.chuck.chucksmod.block.custom.AbstractEnergyUsingBlock;
import net.chuck.chucksmod.block.entity.AbstractEnergyUsingBlockEntity;
import net.chuck.chucksmod.screen.generator.GeneratorScreenHandler;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import team.reborn.energy.api.EnergyStorage;
import team.reborn.energy.api.EnergyStorageUtil;

public abstract class AbstractGeneratorBlockEntity extends AbstractEnergyUsingBlockEntity {
    public static final int BURN_TIME_IDX = 0;
    public static final int FUEL_TIME_IDX = 1;
    public static final int DELEGATE_SIZE = 2;
    protected PropertyDelegate propertyDelegate;
    protected int burnTime = 0;
    protected int fuelTime = 0;
    private boolean burning_last_tick = false;
    public AbstractGeneratorBlockEntity(BlockEntityType type, BlockPos pos, BlockState state,
                                        int invSize, int generationSpeed, int energyStorageSize) {
        super(type, pos, state, invSize, energyStorageSize, generationSpeed);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                switch (index){
                    case BURN_TIME_IDX: return AbstractGeneratorBlockEntity.this.burnTime;
                    case FUEL_TIME_IDX: return AbstractGeneratorBlockEntity.this.fuelTime;
                    default: return BURN_TIME_IDX;
                }
            }
            @Override
            public void set(int index, int value) {
                switch (index) {
                    case BURN_TIME_IDX: AbstractGeneratorBlockEntity.this.burnTime = value; break;
                    case FUEL_TIME_IDX: AbstractGeneratorBlockEntity.this.fuelTime = value; break;
                }
            }
            @Override
            public int size() {
                return DELEGATE_SIZE;
            }
        };
    }

    @Override
    protected int getEnergyUsage() {
        return 0;
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        this.markDirty();
        sendEnergyPacket();
        return new GeneratorScreenHandler(syncId, playerInventory, this, propertyDelegate);
    }
    public abstract int getGeneration();
    public abstract int getMaxExtract();
    public abstract int getEnergyStorageCapacity();

    protected void generateEnergy() {
        try(Transaction transaction = Transaction.openOuter()){
            this.energyStorage.insert(this.getGeneration(), transaction);
            transaction.commit();
        }
    }
    protected boolean isGenerating() {
        return this.burnTime > 0 && hasLiquid();
    }
    protected void useFuel(){

    };
    public void tick(World world, BlockPos blockPos, BlockState blockState) {
        if (world.isClient()){
            return;
        }
        boolean burning_start_of_tick = this.isGenerating();
        if (this.isGenerating()){
            if(fuelTime > 0) --this.burnTime;
            this.useLiquid();
            this.generateEnergy();
        }
        if (!this.isGenerating() && this.energyStorage.amount < this.getEnergyStorageCapacity() && hasLiquid()){
            this.useFuel();
        }
        if (burning_start_of_tick != this.isGenerating() || burning_last_tick != this.isGenerating()){
            blockState = blockState.with(AbstractEnergyUsingBlock.LIT, this.isGenerating());
            world.setBlockState(blockPos, blockState, Block.NOTIFY_ALL);
            markDirty(world, blockPos, blockState);
        }
        for (Direction side : Direction.values()){
            EnergyStorageUtil.move(this.energyStorage, EnergyStorage.SIDED.find(world, pos.offset(side),
                    side.getOpposite()), getMaxExtract(), null);
        }
        burning_last_tick = this.isGenerating();
    }
    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.putInt("generator.burnTime", burnTime);
        nbt.putInt("generator.fuelTime", fuelTime);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        burnTime = nbt.getInt("generator.burnTime");
        fuelTime = nbt.getInt("generator.fuelTime");
    }
    protected void useLiquid(){}
    protected boolean hasLiquid(){
        return true;
    }
}
