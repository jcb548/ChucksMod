package net.chuck.chucksmod.item.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class WitheringEnchantment extends Enchantment {
    protected WitheringEnchantment() {
        super(Rarity.VERY_RARE, EnchantmentTarget.BREAKABLE, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMinPower(int level) {
        return level * 22;
    }

    @Override
    public int getMaxPower(int level) {
        return this.getMinPower(level) + 25;
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
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(target instanceof LivingEntity livingTarget){
            livingTarget.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER,
                    20*6, ((int) (level/2.0)) + 1));
        }
    }

    @Override
    public Text getName(int level) {
        MutableText text = Text.translatable(this.getTranslationKey());
        text.setStyle(text.getStyle().withColor(0x333333));
        return text;
    }
}
