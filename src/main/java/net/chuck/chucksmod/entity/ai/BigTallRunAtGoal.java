package net.chuck.chucksmod.entity.ai;

import net.chuck.chucksmod.entity.custom.BigTallBoss;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;

import java.util.EnumSet;

public class BigTallRunAtGoal extends Goal {
    private final BigTallBoss bigTall;
    public final double speed;
    protected int cooldown;
    protected int tryingTime;
    public static final int RUN_AT_INTERVAL = 100;
    protected int lowestY;
    private final int DESIRED_DISTANCE_FROM_TARGET = 2;
    private boolean reached;
    private int spinningTime = 0;
    private final int SPIN_1 = 9;
    private final int SPIN_2 = 20;
    public BigTallRunAtGoal(BigTallBoss bigTall, double speed) {
        this.bigTall = bigTall;
        this.speed = speed;
        this.lowestY = 0;
        this.setControls(EnumSet.of(Goal.Control.MOVE, Goal.Control.JUMP));
    }
    @Override
    public boolean canStart() {
        if (this.cooldown > 0) {
            --this.cooldown;
            //bigTall.getWorld().getPlayers().get(0).sendMessage(Text.literal(""+cooldown));
            return false;
        }
        this.cooldown = this.getInterval(this.bigTall);
        return this.bigTall.getTarget() != null && this.bigTall.getTarget().isInRange(bigTall, BigTallBoss.RUN_AT_RANGE);
    }
    protected int getInterval(PathAwareEntity mob) {
        return RUN_AT_INTERVAL + mob.getRandom().nextInt(30);
    }
    @Override
    public boolean shouldContinue() {
        return spinningTime <= BigTallBoss.SPINNING_ANIMATION_LENGTH;
    }
    @Override
    public void start() {
        this.startMovingToTarget();
        this.tryingTime = 0;
        bigTall.setRunning(true);
        this.reached = false;
        this.spinningTime = 0;
    }
    protected void startMovingToTarget() {
        LivingEntity target = bigTall.getTarget();
        int speedMultiplier = bigTall.isRunning() ? 3 : 1;
        if (target != null) {
            this.bigTall.getNavigation().startMovingTo(target, speedMultiplier*this.speed);
        }
    }
    @Override
    public void stop() {
        super.stop();
        bigTall.getNavigation().stop();
        if(bigTall.isRunning()) bigTall.setRunning(false);
        if(bigTall.isSpinning()) bigTall.setSpinning(false);
        this.cooldown = getInterval(bigTall);
    }
    @Override
    public boolean shouldRunEveryTick() {
        return true;
    }
    @Override
    public void tick() {
        if(bigTall.getTarget() == null) return;
        this.bigTall.getLookControl().lookAt(bigTall.getTarget(), 30.0f, 30.0f);
            if (!this.bigTall.getTarget().isInRange(bigTall, DESIRED_DISTANCE_FROM_TARGET)) {
                ++this.tryingTime;
                if (this.shouldResetPath()) {
                    startMovingToTarget();
                }
            } else {
                this.reached = true;
                bigTall.setRunning(false);
                this.tryingTime = 0;
                bigTall.setSpinning(true);
            }
        if(reached){
            spinningTime++;
            if(spinningTime == SPIN_1 || spinningTime == SPIN_2){
                for(Entity entity : bigTall.getWorld().getOtherEntities(bigTall, bigTall.getBoundingBox().expand(5, 0, 5))) {
                    if (entity instanceof LivingEntity livingEntity) {
                        //bigTall.getWorld().getPlayers().get(0).sendMessage(Text.literal("healing"));
                        if (livingEntity.damage(livingEntity.getDamageSources().mobAttack(bigTall), 10.0f)) {
                            livingEntity.setVelocity(new Vec3d(0, 0, 0));
                            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 40, 4));
                            bigTall.heal((3 + bigTall.getMaxHealth() - bigTall.getHealth()) * 0.05f);
                        }
                    }
                }
            }
            if(spinningTime > BigTallBoss.SPINNING_ANIMATION_LENGTH) {
                stop();
                bigTall.attackAnimationCooldown = BigTallBoss.ATTACK_ANIMATION_LENGTH + 10;
            }
        }
    }
    public boolean shouldResetPath() {
        return this.tryingTime % 2 == 0;
    }
}
