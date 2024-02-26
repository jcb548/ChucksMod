package net.chuck.chucksmod.world.gen;

import net.chuck.chucksmod.ChucksMod;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.structure.Structure;

public class ModStructureKeys {
    public static final RegistryKey<Structure> MODERN_TOWER = ModStructureKeys.registerKey("modern_tower");
    public static final RegistryKey<Structure> CORPORATE_HELL = ModStructureKeys.registerKey("corporate_hell");
    public static final RegistryKey<Structure> ANCIENT_PACSARIA_TREE =
            ModStructureKeys.registerKey("ancient_pacsaria_tree");
    public static final RegistryKey<Structure> PACSARIA_DUNGEON = ModStructureKeys.registerKey("pacsaria_dungeon");
    public static final RegistryKey<Structure> PACSARIA_HOUSE = ModStructureKeys.registerKey("pacsaria_house");
    public static final RegistryKey<Structure> CREEPER_DUNGEON = ModStructureKeys.registerKey("creeper_dungeon");
    public static final RegistryKey<Structure> SOUL_BLAZE_ALTAR = ModStructureKeys.registerKey("soul_blaze_altar");

    public static RegistryKey<Structure> registerKey(String id){
        return RegistryKey.of(RegistryKeys.STRUCTURE, new Identifier(ChucksMod.MOD_ID, id));
    }
}
