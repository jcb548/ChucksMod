package net.chuck.chucksmod.block.entity;

import net.chuck.chucksmod.fluid.ModFluids;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;

public interface ExperienceInteractingFluidStoring extends FluidStoring{
    int getXpDrainRate();
    default void interactExperience(PlayerEntity player){
        long extractAmount = getXpDrainRate();
        if(extractAmount > getFluidStorage().amount) extractAmount = getFluidStorage().amount;
        if(extractAmount > 0) {
            try (Transaction tx = Transaction.openOuter()) {
                getFluidStorage().extract(FluidVariant.of(ModFluids.STILL_LIQUID_XP), extractAmount, tx);
                tx.commit();
                int oldLevel = player.experienceLevel;
                player.addExperience((int) extractAmount);
                if (player.experienceLevel / 5 > oldLevel / 5) {
                    getWorld().playSound(null, getPos(), SoundEvents.ENTITY_PLAYER_LEVELUP, SoundCategory.BLOCKS,
                            1.0f, 1.0f);
                } else {
                    getWorld().playSound(null, getPos(), SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.BLOCKS,
                            1.0f, 0.5f + getWorld().getRandom().nextFloat() * 0.5f);
                }
            }
        }
    }
}
