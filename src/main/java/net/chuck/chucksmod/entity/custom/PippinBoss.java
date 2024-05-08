package net.chuck.chucksmod.entity.custom;

import net.chuck.chucksmod.entity.ai.CustomMeleeAttackGoal;
import net.chuck.chucksmod.entity.ai.PippinGoToHealGoal;
import net.chuck.chucksmod.item.ModItems;
import net.chuck.chucksmod.networking.ModMessages;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Arm;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.*;
import org.jetbrains.annotations.Nullable;

public class PippinBoss extends CustomBoss{
    public static final int LANTERN_RANGE = 32;
    private static final int TICKS_BETWEEN_HEAL = 12;
    private int healTickCounter = 5;
    private BlockPos healingLanternPos = null;
    private final ServerBossBar bossBar = (ServerBossBar)new ServerBossBar(this.getDisplayName(), BossBar.Color.PURPLE,
            BossBar.Style.PROGRESS).setDarkenSky(false);
    public PippinBoss(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }
    @Override
    public int getAttackAnimationLength() {
        return 18;
    }
    @Override
    public int getAttackWindup() {
        return 5;
    }
    public static DefaultAttributeContainer.Builder setAttributes(){
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 200)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.6f)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 15);
    }
    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new PippinGoToHealGoal(this, 0.7f));
        this.goalSelector.add(2, new CustomMeleeAttackGoal(this, 1.0f, true,
                getAttackWindup(), getAttackAnimationLength(), 3f));
        this.goalSelector.add(3, new WanderAroundFarGoal(this, 0.5f, 1));
        this.goalSelector.add(4, new LookAtEntityGoal(this, PlayerEntity.class, 40));
        this.goalSelector.add(5, new LookAroundGoal(this));

        this.targetSelector.add(1, new RevengeGoal(this, new Class[0]));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }
    @Override
    public void tick() {
        super.tick();
        setPositionTarget(getBlockPos(), -1);
        if(!this.getWorld().isClient()){
            if(nearLantern()) {
               if(healTickCounter <=0) {
                   heal(1);
                   healTickCounter = TICKS_BETWEEN_HEAL;
                   if(healingLanternPos != null){
                       PacketByteBuf data = PacketByteBufs.create();
                       data.writeInt(getId());
                       data.writeBlockPos(healingLanternPos);
                       for(ServerPlayerEntity player : PlayerLookup.tracking(this)){
                           ServerPlayNetworking.send(player, ModMessages.PIPPIN_HEAL_PARTICLE, data);
                       }
                   }
               } else healTickCounter--;
            }
        }
    }
    private boolean nearLantern(){
        int range = 2;
        BlockPos pos = getBlockPos();
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        for(int x = -range; x < range; x++) {
            for(int y = -range; y < range;y++) {
                for(int z = -range;z < range; z++) {
                    if(BlockPos.ORIGIN.isWithinDistance(new Vec3i(x, y, z), range)){
                        mutable.set(pos, x, y, z);
                        if(getWorld().getBlockState(mutable).isOf(Blocks.LANTERN)){
                            healingLanternPos = mutable.mutableCopy();
                            return true;
                        }
                    }
                }
            }
        }
        healingLanternPos = null;
        return false;
    }
}
