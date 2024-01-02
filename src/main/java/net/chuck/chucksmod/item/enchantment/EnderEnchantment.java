package net.chuck.chucksmod.item.enchantment;

import net.chuck.chucksmod.networking.ModMessages;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.event.GameEvent;

public class EnderEnchantment extends Enchantment {
    protected EnderEnchantment() {
        super(Rarity.VERY_RARE, EnchantmentTarget.BOW, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(target instanceof LivingEntity livingTarget &&
                livingTarget.getRecentDamageSource().isIn(DamageTypeTags.IS_PROJECTILE)){
            user.getWorld().playSound(null, BlockPos.ofFloored(user.getPos()),
                    SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.PLAYERS, 2.0f, 1.0f);
            PacketByteBuf data = PacketByteBufs.create();
            data.writeInt(target.getId());
            data.writeDouble(user.getPos().x);
            data.writeDouble(user.getPos().y);
            data.writeDouble(user.getPos().z);
            for(ServerPlayerEntity player : PlayerLookup.tracking((ServerWorld) user.getWorld(), BlockPos.ofFloored(user.getPos()))){
                ServerPlayNetworking.send(player, ModMessages.TELEPORT_PARTICLE, data);
            }
            user.getWorld().emitGameEvent(GameEvent.TELEPORT, user.getPos(), GameEvent.Emitter.of(user));
            user.requestTeleport(target.getX(), target.getY(), target.getZ());
        }
    }
    @Override
    public int getMinPower(int level) {
        return level * 34;
    }

    @Override
    public int getMaxPower(int level) {
        return this.getMinPower(level) + 26;
    }

    @Override
    public boolean isTreasure() {
        return true;
    }

    @Override
    public boolean isAvailableForEnchantedBookOffer() {
        return false;
    }

    @Override
    public boolean isAvailableForRandomSelection() {
        return false;
    }

    @Override
    public Text getName(int level) {
        MutableText text = Text.translatable(this.getTranslationKey());
        text.formatted(Formatting.DARK_PURPLE);
        return text;
    }
}
