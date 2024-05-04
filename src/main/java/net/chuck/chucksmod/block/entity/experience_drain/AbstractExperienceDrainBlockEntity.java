package net.chuck.chucksmod.block.entity.experience_drain;

import net.chuck.chucksmod.fluid.ModFluids;
import net.fabricmc.fabric.api.lookup.v1.block.BlockApiCache;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidStorage;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.Storage;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleVariantStorage;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public abstract class AbstractExperienceDrainBlockEntity extends BlockEntity {
    private BlockApiCache<Storage<FluidVariant>, Direction> belowCache = null;
    public AbstractExperienceDrainBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }
    public void tick(World world, BlockPos pos, BlockState state){
        if(world.isClient) return;
        belowCache = updateBelowCache();
        for(ServerPlayerEntity player : PlayerLookup.around((ServerWorld) world, pos, 5)){
            if(player.getBlockPos().equals(pos) && player.totalExperience > 0){
                if(belowCache.find(Direction.UP) instanceof SingleVariantStorage<FluidVariant> storage){
                    long transferAmount = getDrainRate();
                    if(storage.getCapacity()-storage.amount < transferAmount){
                        transferAmount = storage.getCapacity()-storage.amount;
                    }
                    if(player.totalExperience < transferAmount){
                        transferAmount = player.totalExperience;
                    }
                    try(Transaction tx = Transaction.openOuter()){
                        storage.insert(FluidVariant.of(ModFluids.STILL_LIQUID_XP), transferAmount, tx);
                        tx.commit();
                    }
                    player.addExperience((int)-transferAmount);
                }
            }
        }
    }
    private BlockApiCache<Storage<FluidVariant>, Direction> updateBelowCache(){
        if(belowCache == null)
            belowCache = BlockApiCache.create(FluidStorage.SIDED, (ServerWorld) world, pos.offset(Direction.DOWN));
        return belowCache;
    }
    public abstract int getDrainRate();
}
