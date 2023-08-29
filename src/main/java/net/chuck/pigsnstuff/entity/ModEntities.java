package net.chuck.pigsnstuff.entity;

import net.chuck.pigsnstuff.PigsNStuff;
import net.chuck.pigsnstuff.entity.custom.DiritiaHostileEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<DiritiaHostileEntity> DIRITIA_HOSTILE = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(PigsNStuff.MOD_ID, "diritia_hostile"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, DiritiaHostileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.8f, 1.6f)).build());
}
