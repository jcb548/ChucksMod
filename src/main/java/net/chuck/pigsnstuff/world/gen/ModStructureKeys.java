package net.chuck.pigsnstuff.world.gen;

import net.chuck.pigsnstuff.PigsNStuff;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.structure.Structure;
import net.minecraft.world.gen.structure.StructureKeys;

public class ModStructureKeys {
    public static final RegistryKey<Structure> MODERN_TOWER = ModStructureKeys.registerKey("modern_tower");

    public static RegistryKey<Structure> registerKey(String id){
        return RegistryKey.of(RegistryKeys.STRUCTURE, new Identifier(PigsNStuff.MOD_ID, id));
    }
}
