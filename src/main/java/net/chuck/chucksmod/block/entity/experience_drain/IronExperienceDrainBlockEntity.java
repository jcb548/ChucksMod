package net.chuck.chucksmod.block.entity.experience_drain;

import net.chuck.chucksmod.block.entity.ModBlockEntities;
import net.chuck.chucksmod.block.entity.tiers.IronTier;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;

public class IronExperienceDrainBlockEntity extends AbstractExperienceDrainBlockEntity implements IronTier {
    public IronExperienceDrainBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.IRON_EXPERIENCE_DRAIN, pos, state);
    }
    public int getDrainRate(){
        return XP_DRAIN_RATE;
    }
}
