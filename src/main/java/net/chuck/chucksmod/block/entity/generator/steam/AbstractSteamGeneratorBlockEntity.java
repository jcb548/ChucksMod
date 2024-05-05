package net.chuck.chucksmod.block.entity.generator.steam;

import net.chuck.chucksmod.block.entity.FluidStoring;
import net.chuck.chucksmod.block.entity.generator.heat.AbstractHeatGeneratorBlockEntity;
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
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.math.BlockPos;

public abstract class AbstractSteamGeneratorBlockEntity extends AbstractHeatGeneratorBlockEntity implements FluidStoring {
    public static final int WATER_USAGE = 5;
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
    public AbstractSteamGeneratorBlockEntity(BlockEntityType type, BlockPos pos, BlockState state, int generationSpeed, int energyStorageSize) {
        super(type, pos, state, generationSpeed, energyStorageSize);
    }

    @Override
    protected int getFuelTime(ItemStack fuel) {
        return super.getFuelTime(fuel)*2;
    }

    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        this.markDirty();
        sendEnergyPacket();
        return new SteamGeneratorScreenHandler(syncId, playerInventory, this, propertyDelegate);
    }
    @Override
    protected void useLiquid() {
        try (Transaction tx = Transaction.openOuter()){
            if(fluidStorage.amount > 0 && this.burnTime > 0) {
                fluidStorage.extract(fluidStorage.variant, WATER_USAGE, tx);
            }
            tx.commit();
        }
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

    @Override
    protected boolean hasLiquid() {
        return fluidStorage.amount >= WATER_USAGE;
    }
    public boolean isGenerating() {
        return this.burnTime > 0 && hasLiquid();
    }

    @Override
    public Fluid getAllowedFluid() {
        return Fluids.WATER;
    }
}
