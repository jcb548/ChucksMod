package net.chuck.chucksmod.sounds;

import net.chuck.chucksmod.ChucksMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent BIGTAL_SWING_STAFF = registerSoundEvent("bigtal_swing_staff");
    public static final SoundEvent BIGTAL_AMBIENT = registerSoundEvent("bigtal_ambient");
    public static final SoundEvent BIGTAL_HURT = registerSoundEvent("bigtal_hurt");
    public static final SoundEvent BIGTAL_DEATH = registerSoundEvent("bigtal_death");
    public static final SoundEvent BIGTAL_SMALL_FALL = registerSoundEvent("bigtal_small_fall");
    public static final SoundEvent BIGTAL_BIG_FALL = registerSoundEvent("bigtal_big_fall");
    private static SoundEvent registerSoundEvent(String name){
        Identifier id = new Identifier(ChucksMod.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds(){
        ChucksMod.LOGGER.info("Registering Sounds for "+ ChucksMod.MOD_ID);
    }
}
