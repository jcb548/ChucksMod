package net.chuck.chucksmod.block.entity.fluid_tank;

import net.chuck.chucksmod.block.entity.FluidStoring;
import net.chuck.chucksmod.networking.ModMessages;
import net.chuck.chucksmod.util.FluidStack;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleVariantStorage;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BucketItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class AbstractFluidTankBlockEntity extends BlockEntity implements FluidStoring {
    int prevPlayerCount = 0;
    public SingleVariantStorage<FluidVariant> fluidStorage = new SingleVariantStorage<>() {
        @Override
        protected FluidVariant getBlankVariant() {
            return FluidVariant.blank();
        }

        @Override
        protected long getCapacity(FluidVariant variant) {
            return FluidStack.convertDropletsToMb(FluidConstants.BUCKET)*getFluidCapacity();
        }
        @Override
        protected void onFinalCommit() {
            markDirty();
            if(!world.isClient) {
                sendFluidPacket();
            }
        }
    };
    public AbstractFluidTankBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public abstract int getFluidCapacity();
    public void interactBucket(PlayerEntity player, Hand hand){
        if(player.getStackInHand(hand).getItem() instanceof BucketItem bucketItem){
            if(bucketItem.fluid == Fluids.EMPTY){
                if(fluidStorage.amount >= FluidStack.BUCKET_MB){
                    try(Transaction transaction = Transaction.openOuter()){
                        ItemStack filledBucket = new ItemStack(fluidStorage.variant.getFluid().getBucketItem());
                        this.fluidStorage.extract(fluidStorage.variant,
                                FluidStack.convertDropletsToMb(FluidConstants.BUCKET), transaction);
                        transaction.commit();
                        if(player.getStackInHand(hand).getCount() > 1){
                            player.setStackInHand(hand, new ItemStack(Items.BUCKET, player.getStackInHand(hand).getCount()-1));
                            if(!player.getInventory().insertStack(filledBucket)){
                                ItemEntity bucket = new ItemEntity(player.getWorld(), player.getX(), player.getY(), player.getZ(), filledBucket);
                                player.getWorld().spawnEntity(bucket);
                            }
                        } else {
                            player.setStackInHand(hand, filledBucket);
                        }
                    }
                }
            } else {
                if((fluidStorage.variant.getFluid().equals(Fluids.EMPTY)) || (fluidStorage.variant.getFluid().equals(bucketItem.fluid) && fluidStorage.amount +
                        FluidStack.BUCKET_MB < fluidStorage.getCapacity())){
                    try(Transaction transaction = Transaction.openOuter()){
                        this.fluidStorage.insert(FluidVariant.of(bucketItem.fluid),
                                FluidStack.convertDropletsToMb(FluidConstants.BUCKET), transaction);
                        transaction.commit();
                        player.setStackInHand(hand, new ItemStack(Items.BUCKET));
                    }
                }
            }
        }
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        fluidStorage.variant = FluidVariant.fromNbt((NbtCompound) nbt.get("tank.fluid_variant"));
        fluidStorage.amount = nbt.getLong("tank.fluid_level");
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        nbt.put("tank.fluid_variant", fluidStorage.variant.toNbt());
        nbt.putLong("tank.fluid_level", fluidStorage.amount);
    }

    public void sendFluidPacket() {
        for (ServerPlayerEntity player : ((ServerWorld) world).getPlayers()){
            sendFluidPacket(player);
        }
    }
    public void sendFluidPacket(ServerPlayerEntity player){
        PacketByteBuf data = PacketByteBufs.create();
        fluidStorage.variant.toPacket(data);
        data.writeLong(fluidStorage.amount);
        data.writeBlockPos(getPos());
        ServerPlayNetworking.send(player, ModMessages.FLUID_SYNC, data);
    }

    public void setFluidStorage(FluidVariant fluidVariant, long fluidLevel) {
        this.fluidStorage.variant = fluidVariant;
        this.fluidStorage.amount = fluidLevel;
    }

    @Override
    public SingleVariantStorage<FluidVariant> getFluidStorage() {
        return fluidStorage;
    }
}
