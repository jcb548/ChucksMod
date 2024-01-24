package net.chuck.chucksmod.world.dimension;

import net.chuck.chucksmod.ChucksMod;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.DimensionTypes;

import java.util.OptionalLong;

public class ModDimensions {
    public static final RegistryKey<DimensionOptions> FABIA_KEY = RegistryKey.of(RegistryKeys.DIMENSION,
            new Identifier(ChucksMod.MOD_ID, "fabia"));
    public static final RegistryKey<World> FABIA_LEVEL_KEY = RegistryKey.of(RegistryKeys.WORLD,
            new Identifier(ChucksMod.MOD_ID, "fabia"));
    public static final RegistryKey<DimensionType> FABIA_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            new Identifier(ChucksMod.MOD_ID, "fabia_type"));
    public static final RegistryKey<DimensionOptions> DIRITIA_KEY = RegistryKey.of(RegistryKeys.DIMENSION,
            new Identifier(ChucksMod.MOD_ID, "diritia"));
    public static final RegistryKey<World> DIRITIA_LEVEL_KEY = RegistryKey.of(RegistryKeys.WORLD,
            new Identifier(ChucksMod.MOD_ID, "diritia"));
    public static final RegistryKey<DimensionType> DIRITIA_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            new Identifier(ChucksMod.MOD_ID, "diritia_type"));

    public static void bootstrapType(Registerable<DimensionType> context){
        context.register(FABIA_TYPE, new DimensionType(
                OptionalLong.of(12000),     //fixedTime
                true,       //hasSkylight
                false,      //hasCeiling
                false,      //ultraWarm
                true,       //natural
                1.0,        //coordinateScale
                true,       //bedWorks
                false,      //respawnAnchorWorks
                0,          //minY
                256,        //height
                256,        //logicalHeight
                BlockTags.INFINIBURN_END,    //infiniburn
                DimensionTypes.OVERWORLD_ID,     //effectsLocation
                1.0f,        //ambient light
                new DimensionType.MonsterSettings(false, false, UniformIntProvider.create(0, 0), 4)));
        context.register(DIRITIA_TYPE, new DimensionType(
                OptionalLong.of(12000),     //fixedTime
                true,       //hasSkylight
                false,      //hasCeiling
                false,      //ultraWarm
                true,       //natural
                1.0,        //coordinateScale
                true,       //bedWorks
                false,      //respawnAnchorWorks
                -64,          //minY
                256,        //height
                256,        //logicalHeight
                BlockTags.INFINIBURN_END,    //infiniburn
                DimensionTypes.OVERWORLD_ID,     //effectsLocation
                1.0f,        //ambient light
                new DimensionType.MonsterSettings(false, false, UniformIntProvider.create(0, 7), 3)));
    }
}
