package net.chuck.pigsnstuff.entity;

import net.chuck.pigsnstuff.PigsNStuff;
import net.chuck.pigsnstuff.entity.custom.WyattEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<WyattEntity> WYATT = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(PigsNStuff.MOD_ID, "wyatt"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, WyattEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6f, 1.6f)).build());
}
