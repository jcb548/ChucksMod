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
    public PippinGoToHealGoal(PippinBoss mob, double speed) {
        super(mob, speed, PippinBoss.LANTERN_RANGE, 8);
        cooldown = getInterval(mob);
        this.lowestY = 0;
    }

    @Override
    protected int getInterval(PathAwareEntity mob) {
        return 0;
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
    public boolean canStart() {
        mob.getWorld().getPlayers().get(0).sendMessage(Text.literal(cooldown + " " + findTargetPos() + mob.getPositionTarget()));
        return findTargetPos();
    }

    @Override
    public boolean shouldContinue() {
        return true;
    }
    protected boolean findTargetPos() {
        super.findTargetPos();
        int localRange = 5;
        int localMaxYDifference = 5;
        BlockPos blockPos = this.mob.getBlockPos();
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        int k = this.lowestY;
        while (k <= localMaxYDifference) {
            for (int l = 0; l < localRange; ++l) {
                int m = 0;
                while (m <= l) {
                    int n;
                    int n2 = n = m < l && m > -l ? l : 0;
                    while (n <= l) {
                        mutable.set(blockPos, m, k - 1, n);
                        if(this.isTargetPos(this.mob.getWorld(), mutable)) mob.getWorld().getPlayers().get(0).sendMessage(Text.literal(" " + mob.getWorld().getBlockState(mutable) + " " + mutable));
                        if (this.mob.isInWalkTargetRange(mutable) && this.isTargetPos(this.mob.getWorld(), mutable)) {
                            this.targetPos = mutable;
                            return true;
                        }
                        n = n > 0 ? -n : 1 - n;
                    }
                    m = m > 0 ? -m : 1 - m;
                }
            }
            k = k > 0 ? -k : 1 - k;
        }
        return false;
    }
}
