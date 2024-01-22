package net.chuck.chucksmod.block.entity.generator.lava;

import net.chuck.chucksmod.block.entity.FluidStoring;
import net.chuck.chucksmod.block.entity.generator.AbstractGeneratorBlockEntity;
import net.chuck.chucksmod.screen.generator.lava.LavaGeneratorScreenHandler;
import net.chuck.chucksmod.screen.generator.steam.SteamGeneratorScreenHandler;
import net.chuck.chucksmod.util.FluidStack;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleVariantStorage;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.math.BlockPos;

public abstract class AbstractLavaGeneratorBlockEntity extends AbstractGeneratorBlockEntity implements FluidStoring {
    public static final int LAVA_USAGE = 5;
    public static final int LAVA_USAGE_TICKS = 20;
    private int ticksUntilExtractLava = LAVA_USAGE_TICKS;
    public SingleVariantStorage<FluidVariant> fluidStorage = new SingleVariantStorage<>() {
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

    public AbstractLavaGeneratorBlockEntity(BlockEntityType type, BlockPos pos, BlockState state, int invSize, int generationSpeed, int energyStorageSize) {
        super(type, pos, state, invSize, generationSpeed, energyStorageSize);
    }

    @Override
    protected void useLiquid() {
        --ticksUntilExtractLava;
        if(ticksUntilExtractLava<=0){
            try(Transaction tx = Transaction.openOuter()){
                if(fluidStorage.amount > 0) {
                    fluidStorage.extract(fluidStorage.variant, LAVA_USAGE, tx);
                }
                tx.commit();
            }
            ticksUntilExtractLava = LAVA_USAGE_TICKS;
        }
    }

    @Override
    public Fluid getAllowedFluid() {
        return Fluids.LAVA;
    }

    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        this.markDirty();
        sendEnergyPacket();
        return new LavaGeneratorScreenHandler(syncId, playerInventory, this, propertyDelegate);
    }

    @Override
    public boolean isGenerating() {
        return hasLiquid() && energyStorage.amount< energyStorage.capacity;
    }

    @Override
    protected boolean hasLiquid() {
        return fluidStorage.amount >= LAVA_USAGE;
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        fluidStorage.variant = FluidVariant.fromNbt((NbtCompound) nbt.get("generator.fluid_variant"));
        fluidStorage.amount = nbt.getLong("generator.fluid_level");
        super.readNbt(nbt);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        nbt.put("generator.fluid_variant", fluidStorage.variant.toNbt());
        nbt.putLong("generator.fluid_level", fluidStorage.amount);
        super.writeNbt(nbt);
    }
}
