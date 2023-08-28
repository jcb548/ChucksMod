package net.chuck.pigsnstuff.mixin;

import net.minecraft.entity.attribute.ClampedEntityAttribute;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(EntityAttributes.class)
public class ModGenericArmorModification {
    @Shadow
    public static EntityAttribute GENERIC_ARMOR = EntityAttributes.register("mod.armor", new ClampedEntityAttribute("attribute.name.mod.armor", 0.0, 0.0, 50.0).setTracked(true));
}
