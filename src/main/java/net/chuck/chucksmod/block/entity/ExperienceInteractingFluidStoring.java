package net.chuck.chucksmod.block.entity;

import net.chuck.chucksmod.fluid.ModFluids;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;

public interface ExperienceInteractingFluidStoring extends FluidStoring{
    int getXpDrainRate();
    default void interactExperience(PlayerEntity player){
        long extractAmount = getXpDrainRate();
        if(extractAmount > getFluidStorage().amount) extractAmount = getFluidStorage().amount;
        try(Transaction tx = Transaction.openOuter()){
            getFluidStorage().extract(FluidVariant.of(ModFluids.STILL_LIQUID_XP), extractAmount, tx);
            tx.commit();
            player.addExperience((int)extractAmount);
        }
    }
}
