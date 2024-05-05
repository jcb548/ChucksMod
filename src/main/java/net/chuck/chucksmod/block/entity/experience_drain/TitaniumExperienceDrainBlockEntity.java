package net.chuck.chucksmod.block.entity.experience_drain;

import net.chuck.chucksmod.block.entity.ModBlockEntities;
import net.chuck.chucksmod.block.entity.tiers.TitaniumTier;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class TitaniumExperienceDrainBlockEntity extends AbstractExperienceDrainBlockEntity implements TitaniumTier {
    public TitaniumExperienceDrainBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.TITANIUM_EXPERIENCE_DRAIN, pos, state);
    }
    public int getDrainRate(){
        return XP_DRAIN_RATE;
    }
}
