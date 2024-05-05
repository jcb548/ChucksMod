package net.chuck.chucksmod.block.entity.experience_drain;

import net.chuck.chucksmod.block.entity.ModBlockEntities;
import net.chuck.chucksmod.block.entity.tiers.TriafiumTier;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class TriafiumExperienceDrainBlockEntity extends AbstractExperienceDrainBlockEntity implements TriafiumTier {
    public TriafiumExperienceDrainBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.TRIAFIUM_EXPERIENCE_DRAIN, pos, state);
    }
    public int getDrainRate(){
        return XP_DRAIN_RATE;
    }
}
