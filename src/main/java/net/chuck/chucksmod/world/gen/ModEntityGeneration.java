package net.chuck.chucksmod.world.gen;

import net.chuck.chucksmod.entity.ModEntities;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.Heightmap;

public class ModEntityGeneration {
    public static void addSpawns() {
        SpawnRestriction.register(ModEntities.WYATT, SpawnRestriction.Location.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnIgnoreLightLevel);
    }
}
