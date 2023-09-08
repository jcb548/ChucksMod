package net.chuck.pigsnstuff.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import software.bernie.geckolib.GeckoLib;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class WyattEntity extends HostileEntity implements GeoEntity{
    private AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    public WyattEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }
    public static DefaultAttributeContainer.Builder setAttributes() {
        return HostileEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0d)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 12.0f)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 2.0f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.4f);
    }
    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, new MeleeAttackGoal(this, 1.0d, false));
        this.goalSelector.add(3, new WanderAroundFarGoal(this, 0.75f, 1));
        this.goalSelector.add(4, new LookAroundGoal(this));

        targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller",
                0, this::predicate),
                new AnimationController<>(this, "attackController",
                0, this::attackPredicate));
    }

    private <T extends GeoAnimatable> PlayState predicate(AnimationState<T> tAnimationState) {
        if(tAnimationState.isMoving()){
            tAnimationState.getController().setAnimation(RawAnimation.begin()
                    .then("animation.wyatt.walk", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        } else {
            tAnimationState.getController().setAnimation(RawAnimation.begin()
                    .then("animation.wyatt.idle", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }
    }

    private <T extends GeoAnimatable> PlayState attackPredicate(AnimationState<T> tAnimationState){
        if(this.handSwinging) {
            return tAnimationState.setAndContinue(RawAnimation.begin()
                    .thenPlay("animation.wyatt.attack"));
        }
            tAnimationState.getController().forceAnimationReset();
        return PlayState.STOP;
    }
    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
    @Override
    protected ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);

        if (this.getWorld().isClient() || stack.isEmpty())
            return super.interactMob(player, hand);

        EquipmentSlot slot = LivingEntity.getPreferredEquipmentSlot(stack);

        equipStack(slot, stack.copy());
        player.sendMessage(Text.translatable("entity." + GeckoLib.MOD_ID + ".mutant_zombie.equip", stack.toHoverableText()));

        if (slot == EquipmentSlot.MAINHAND || slot == EquipmentSlot.OFFHAND)
            triggerAnim(getActiveHand() == hand ? "Left Hand" : "Right Hand", "interact");

        return ActionResult.SUCCESS;
    }
}
