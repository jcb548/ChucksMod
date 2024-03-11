package net.chuck.chucksmod.entity.ai;

import net.chuck.chucksmod.entity.custom.PippinBoss;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.ai.goal.MoveToTargetPosGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;

public class PippinGoToHealGoal extends MoveToTargetPosGoal {
    private static final int MOVE_TO_HEAL_INTERVAL = 70;
    public PippinGoToHealGoal(PippinBoss mob, double speed) {
        super(mob, speed, PippinBoss.LANTERN_RANGE, 8);
        cooldown = getInterval(mob);
        this.lowestY = 0;
    }

    @Override
    protected int getInterval(PathAwareEntity mob) {
        return MOVE_TO_HEAL_INTERVAL+mob.getRandom().nextInt(30);
    }

    @Override
    public boolean canStart() {
        return super.canStart();
    }

    @Override
    public void stop() {
        super.stop();
        mob.getNavigation().stop();
    }

    @Override
    protected boolean isTargetPos(WorldView world, BlockPos pos) {
        return world.getBlockState(pos).isOf(Blocks.LANTERN);
    }
    @Override
    public void tick() {
        super.tick();
        if(!isTargetPos(mob.getWorld(), targetPos)) findTargetPos();
    }

    @Override
    public boolean shouldContinue() {
        return tryingTime < MOVE_TO_HEAL_INTERVAL && tryingTime > -MOVE_TO_HEAL_INTERVAL;
    }
}
