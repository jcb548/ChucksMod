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
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public abstract class AbstractExperienceDrainBlockEntity extends BlockEntity {
    private BlockApiCache<Storage<FluidVariant>, Direction> belowCache = null;
    private int tickCount = 0;
    public AbstractExperienceDrainBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        tickCount = 0;
    }
    public void tick(World world, BlockPos pos, BlockState state){
        if(world.isClient) return;
        tickCount++;
        if(tickCount >= 5) {
            tickCount = 0;
            belowCache = updateBelowCache();
            for (ServerPlayerEntity player : PlayerLookup.around((ServerWorld) world, pos, 5)) {
                if (player.getBlockPos().equals(pos) && player.totalExperience > 0) {
                    if (belowCache.find(Direction.UP) instanceof SingleVariantStorage<FluidVariant> storage) {
                        long transferAmount = getDrainRate();
                        if (storage.getCapacity() - storage.amount < transferAmount) {
                            transferAmount = storage.getCapacity() - storage.amount;
                        }
                        if (player.totalExperience < transferAmount) {
                            transferAmount = player.totalExperience;
                        }
                        if(transferAmount > 0){
                            try (Transaction tx = Transaction.openOuter()) {
                                storage.insert(FluidVariant.of(ModFluids.STILL_LIQUID_XP), transferAmount, tx);
                                tx.commit();
                            }
                            player.addExperience((int) -transferAmount);
                            world.playSound(null, pos, SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.BLOCKS,
                                    1f, 0.5f + 0.5f * world.getRandom().nextFloat());
                        }
                    }
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
