package net.chuck.chucksmod.entity.custom;

import net.chuck.chucksmod.entity.ModEntities;
import net.chuck.chucksmod.entity.ai.CustomMeleeAttackGoal;
import net.chuck.chucksmod.item.ModItems;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class TriafianPigEntity extends CustomAnimalEntity{
    private static final Ingredient BREEDING_INGREDIENT = Ingredient.ofItems(Items.CARROT, ModItems.TOMATO);
    private static final TrackedData<Boolean> ATTACKING =
            DataTracker.registerData(TriafianPigEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    public TriafianPigEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }
    @Override
    public int getAttackAnimationLength() {
        return 11;
    }
    @Override
    public int getAttackWindup() {
        return 8;
    }
    public static DefaultAttributeContainer.Builder setAttributes(){
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 15)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.33f)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 6);
    }
    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.TRIAFIAN_PIG.create(world);
    }
    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return BREEDING_INGREDIENT.test(stack);
    }
    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        //this.goalSelector.add(1, new EscapeDangerGoal(this, 1.25f));
        this.goalSelector.add(2, new CustomMeleeAttackGoal(this, 0.8f, false,
                getAttackWindup(), getAttackAnimationLength(), 2f));
        this.goalSelector.add(3, new AnimalMateGoal(this, 1.0f));
        this.goalSelector.add(3, new TemptGoal(this, 1.2f, BREEDING_INGREDIENT, false));
        this.goalSelector.add(4, new FollowParentGoal(this, 1.1f));
        this.goalSelector.add(5, new WanderAroundFarGoal(this, 0.8f, 5));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 6));
        this.goalSelector.add(7, new LookAroundGoal(this));

        this.targetSelector.add(1, new RevengeGoal(this, new Class[0]));
    }
    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(ATTACKING, false);
    }
    public void setAttacking(boolean attacking){
        this.dataTracker.set(ATTACKING, attacking);
    }
    public boolean isAttacking(){
        return this.dataTracker.get(ATTACKING);
    }
    @Override
    public int getXpToDrop() {
        return 2 + this.getWorld().random.nextInt(5);
    }
}
