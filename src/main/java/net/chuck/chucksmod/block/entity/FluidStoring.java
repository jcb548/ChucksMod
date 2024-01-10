package net.chuck.chucksmod.block.entity;

import net.chuck.chucksmod.networking.ModMessages;
import net.chuck.chucksmod.util.FluidStack;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleVariantStorage;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BucketItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public interface FluidStoring {
    SingleVariantStorage<FluidVariant> getFluidStorage();
    int getBucketCapacity();
    default void sendFluidPacket() {
        for (ServerPlayerEntity player : ((ServerWorld) getWorld()).getPlayers()){
            sendFluidPacket(player);
        }
    }
    default void sendFluidPacket(ServerPlayerEntity player){
        PacketByteBuf data = PacketByteBufs.create();
        getFluidStorage().variant.toPacket(data);
        data.writeLong(getFluidStorage().amount);
        data.writeBlockPos(getPos());
        ServerPlayNetworking.send(player, ModMessages.FLUID_SYNC, data);
    }
    default void setFluidStorage(FluidVariant fluidVariant, long fluidLevel){
        getFluidStorage().variant = fluidVariant;
        getFluidStorage().amount = fluidLevel;
    }
    default void interactBucket(PlayerEntity player, Hand hand){
        if(player.getStackInHand(hand).getItem() instanceof BucketItem bucketItem){
            if(bucketItem.fluid == Fluids.EMPTY){
                if(getFluidStorage().amount >= FluidStack.BUCKET_MB){
                    try(Transaction transaction = Transaction.openOuter()){
                        ItemStack filledBucket = new ItemStack(getFluidStorage().variant.getFluid().getBucketItem());
                        this.getFluidStorage().extract(getFluidStorage().variant,
                                FluidStack.convertDropletsToMb(FluidConstants.BUCKET), transaction);
                        transaction.commit();
                        if(player.getStackInHand(hand).getCount() > 1){
                            player.setStackInHand(hand, new ItemStack(Items.BUCKET, player.getStackInHand(hand).getCount()-1));
                            if(!player.getInventory().insertStack(filledBucket)){
                                ItemEntity bucket = new ItemEntity(player.getWorld(), player.getX(), player.getY(), player.getZ(), filledBucket);
                                player.getWorld().spawnEntity(bucket);
                            }
                        } else if(!player.isCreative()) player.setStackInHand(hand, filledBucket);
                    }
                }
            } else {
                if((getFluidStorage().variant.getFluid().equals(Fluids.EMPTY) &&
                        (bucketItem.fluid.equals(getAllowedFluid()) ||
                                getAllowedFluid() == null)) ||
                        (getFluidStorage().variant.getFluid().equals(bucketItem.fluid) && getFluidStorage().amount +
                        FluidStack.BUCKET_MB <= getFluidStorage().getCapacity())){
                    try(Transaction transaction = Transaction.openOuter()){
                        this.getFluidStorage().insert(FluidVariant.of(bucketItem.fluid),
                                FluidStack.convertDropletsToMb(FluidConstants.BUCKET), transaction);
                        transaction.commit();
                        if(!player.isCreative()) player.setStackInHand(hand, new ItemStack(Items.BUCKET));
                    }
                }
            }
        }
    }
    default Fluid getAllowedFluid(){
        return null;
    }
    World getWorld();
    BlockPos getPos();
}
