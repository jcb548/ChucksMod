package net.chuck.chucksmod.item.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class AlacrityEnchantment extends Enchantment {
    public static final double ATTACK_SPEED_BONUS = 0.4;
    protected AlacrityEnchantment() {
        super(Rarity.UNCOMMON, EnchantmentTarget.BREAKABLE, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMinPower(int level) {
        return 1 + (level + 1) * 11;
    }

    @Override
    public int getMaxPower(int level) {
        return this.getMinPower(level) + 20;
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }

    @Override
    public Text getName(int level) {
        MutableText text = Text.translatable(this.getTranslationKey());
        text.formatted(Formatting.YELLOW);
        return text;
    }
}
