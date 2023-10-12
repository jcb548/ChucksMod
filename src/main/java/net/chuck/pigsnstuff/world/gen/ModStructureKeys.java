package net.chuck.pigsnstuff.world.gen;

import net.chuck.pigsnstuff.PigsNStuff;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.structure.Structure;
import net.minecraft.world.gen.structure.StructureKeys;

public class ModStructureKeys {
    public static final RegistryKey<Structure> MODERN_TOWER = ModStructureKeys.registerKey("modern_tower");
    public static final RegistryKey<Structure> CORPORATE_HELL = ModStructureKeys.registerKey("corporate_hell");
    public static final RegistryKey<Structure> ANCIENT_DIRITIA_TREE =
            ModStructureKeys.registerKey("ancient_diritia_tree");
    public static final RegistryKey<Structure> DIRITIA_DUNGEON = ModStructureKeys.registerKey("diritia_dungeon");
    public static final RegistryKey<Structure> DIRITIA_HOUSE = ModStructureKeys.registerKey("diritia_house");
    public static final RegistryKey<Structure> CREEPER_DUNGEON = ModStructureKeys.registerKey("creeper_dungeon");

    public static RegistryKey<Structure> registerKey(String id){
        return RegistryKey.of(RegistryKeys.STRUCTURE, new Identifier(PigsNStuff.MOD_ID, id));
    }
}
