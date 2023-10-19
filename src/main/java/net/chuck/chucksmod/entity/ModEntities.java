package net.chuck.chucksmod.entity;

import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.entity.custom.FrankBoss;
import net.chuck.chucksmod.entity.custom.FrankFireballEntity;
import net.chuck.chucksmod.entity.custom.WyattEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<WyattEntity> WYATT = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(ChucksMod.MOD_ID, "wyatt"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, WyattEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6f, 1.6f)).build());
    public static final EntityType<FrankBoss> FRANK_BOSS = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(ChucksMod.MOD_ID, "frank"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, FrankBoss::new)
                    .dimensions(EntityDimensions.fixed(0.8f, 2.0f)).fireImmune().build());
    public static final EntityType<FrankFireballEntity> FRANK_FIREBALL = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(ChucksMod.MOD_ID, "frank_fireball"),
            FabricEntityTypeBuilder.<FrankFireballEntity>create(SpawnGroup.MISC, FrankFireballEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());
}
