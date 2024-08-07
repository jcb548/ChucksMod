package net.chuck.chucksmod.entity;

import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.entity.custom.*;
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
    public static final EntityType<SoulBlazeBoss> SOUL_BLAZE_BOSS = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(ChucksMod.MOD_ID, "soul_blaze"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, SoulBlazeBoss::new)
                    .dimensions(EntityDimensions.fixed(1.2f, 2.5f)).fireImmune().build());
    public static final EntityType<SoulBlazeRodEntity> SOUL_BLAZE_ROD = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(ChucksMod.MOD_ID, "soul_blaze_rod"),
            FabricEntityTypeBuilder.<SoulBlazeRodEntity>create(SpawnGroup.MISC, SoulBlazeRodEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.5f))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());
    public static final EntityType<FarmabynEntity> FARMABYN = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(ChucksMod.MOD_ID, "farmabyn"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, FarmabynEntity::new)
                    .dimensions(EntityDimensions.fixed(0.8f, 2.0f)).build());
    public static final EntityType<TriafianPigEntity> TRIAFIAN_PIG = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(ChucksMod.MOD_ID, "triafian_pig"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, TriafianPigEntity::new)
                    .dimensions(EntityDimensions.fixed(0.9f, 0.9f)).build());
    public static final EntityType<TriafianCowEntity> TRIAFIAN_COW = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(ChucksMod.MOD_ID, "triafian_cow"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, TriafianCowEntity::new)
                    .dimensions(EntityDimensions.fixed(0.9f, 1.5f)).build());
    public static final EntityType<PippinBoss> PIPPIN = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(ChucksMod.MOD_ID, "pippin"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, PippinBoss::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 1.4f)).build());
    public static final EntityType<BigTallBoss> BIG_TALL = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(ChucksMod.MOD_ID, "big_tall"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, BigTallBoss::new)
                    .dimensions(EntityDimensions.fixed(0.8f, 3.0f)).build());
    public static final EntityType<SmotolEntity> SMOTOL = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(ChucksMod.MOD_ID, "smotol"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, SmotolEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 1.4f)).build());
}
