package net.chuck.chucksmod.block.entity.pump;

import net.chuck.chucksmod.block.custom.AbstractEnergyUsingBlock;
import net.chuck.chucksmod.block.entity.AbstractEnergyUsingBlockEntity;
import net.chuck.chucksmod.block.entity.AbstractMiningBlockEntity;
import net.chuck.chucksmod.block.entity.FluidStoring;
import net.chuck.chucksmod.screen.pump.PumpScreenHandler;
import net.chuck.chucksmod.util.FluidStack;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleVariantStorage;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.fluid.Fluids;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractPumpBlockEntity extends AbstractMiningBlockEntity implements FluidStoring {
    public SingleVariantStorage<FluidVariant> fluidStorage = new SingleVariantStorage<FluidVariant>() {
        @Override
        protected FluidVariant getBlankVariant() {
            return FluidVariant.blank();
        }

        @Override
        protected long getCapacity(FluidVariant variant) {
            return FluidStack.convertDropletsToMb(FluidConstants.BUCKET)* getBucketCapacity();
        }

        @Override
        protected void onFinalCommit() {
            markDirty();
            if(!world.isClient) {
                sendFluidPacket();
            }
        }
    };
    public AbstractPumpBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state, int energyStorageSize, int maxProgress, int maxInsertExtract) {
        super(type, pos, state, 0, energyStorageSize, maxProgress, maxInsertExtract);
    }

    @Override
    public SingleVariantStorage<FluidVariant> getFluidStorage() {
        return fluidStorage;
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        this.markDirty();
        sendEnergyPacket();
        sendFluidPacket();
        return new PumpScreenHandler(syncId, playerInventory, this, propertyDelegate);
    }
    public void tick(World world, BlockPos pos, BlockState blockState) {
        if (world.isClient()) {
            return;
        }
        super.tick(world, pos, blockState);
        boolean shouldTryPump = world.isReceivingRedstonePower(pos) && this.hasEnoughEnergy() && yPos>-64 &&
                this.fluidStorage.amount+1000 <= this.fluidStorage.getCapacity();
        if(shouldTryPump){
            this.increaseProgress();
            this.extractEnergy();
            markDirty(world, pos, blockState);
            if(shouldBreakBlock()){
                BlockPos nextBlockPos = getNextBlockPos();
                BlockState nextBlockState = world.getBlockState(nextBlockPos);
                world.getPlayers().get(0).sendMessage(Text.literal(nextBlockPos.toString() + ", " +
                        nextBlockState.toString()));
                if(nextBlockState.getBlock() instanceof FluidBlock fluidBlock){
                    if(fluidBlock.getFluidState(nextBlockState).getFluid().equals(fluidStorage.variant.getFluid())
                            || fluidStorage.amount == 0){
                        world.getPlayers().get(0).sendMessage(Text.literal(nextBlockPos.toString() + ", " +
                                fluidBlock.getFluidState(nextBlockState).getFluid().toString()));
                        //world.getPlayers().get(0).sendMessage(Text.literal(fluidBlock.getFluidState(nextBlockState).getFluid().toString()));
                        try(Transaction transaction = Transaction.openOuter()){
                            fluidStorage.insert(FluidVariant.of(fluidBlock.getFluidState(nextBlockState).getFluid()),
                                    FluidStack.convertDropletsToMb(FluidConstants.BUCKET), transaction);
                            transaction.commit();
                            world.setBlockState(nextBlockPos, Blocks.AIR.getDefaultState());
                        }
                    }
                }
                resetProgress();
            }
        }
        blockState = blockState.with(AbstractEnergyUsingBlock.LIT, shouldTryPump);
        world.setBlockState(pos, blockState, Block.NOTIFY_ALL);
    }
    private boolean isPumpable(BlockState state){
        if(state.getBlock() instanceof FluidBlock fluidBlock){
            if(fluidBlock.getFluidState(state).getFluid().equals(fluidStorage.variant.getFluid())
                    || fluidStorage.amount == 0){
                return true;
            }
        }
        if(state.get(Properties.WATERLOGGED) &&
                (fluidStorage.variant.getFluid().equals(Fluids.WATER) || fluidStorage.amount == 0)){
            return true;
        }
        return false;
    }
    public abstract int getBucketCapacity();
    @Override
    public void readNbt(NbtCompound nbt) {
        fluidStorage.variant = FluidVariant.fromNbt((NbtCompound) nbt.get("pump.fluid_variant"));
        fluidStorage.amount = nbt.getLong("pump.fluid_level");
        super.readNbt(nbt);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        nbt.put("pump.fluid_variant", fluidStorage.variant.toNbt());
        nbt.putLong("pump.fluid_level", fluidStorage.amount);
        super.writeNbt(nbt);
    }

    @Override
    protected void resetPos() {
        this.xPos = 0;
        this.yPos = pos.getY()-1;
        this.zPos = 0;
        shouldResetPos = false;
    }
}
