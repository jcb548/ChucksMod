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
    public static final RegistryKey<DimensionOptions> TRIAFIA_KEY = RegistryKey.of(RegistryKeys.DIMENSION,
            new Identifier(ChucksMod.MOD_ID, "triafia"));
    public static final RegistryKey<World> TRIAFIA_LEVEL_KEY = RegistryKey.of(RegistryKeys.WORLD,
            new Identifier(ChucksMod.MOD_ID, "triafia"));
    public static final RegistryKey<DimensionType> TRIAFIA_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            new Identifier(ChucksMod.MOD_ID, "triafia_type"));
    public static final RegistryKey<DimensionOptions> PACSARIA_KEY = RegistryKey.of(RegistryKeys.DIMENSION,
            new Identifier(ChucksMod.MOD_ID, "pacsaria"));
    public static final RegistryKey<World> PACSARIA_LEVEL_KEY = RegistryKey.of(RegistryKeys.WORLD,
            new Identifier(ChucksMod.MOD_ID, "pacsaria"));
    public static final RegistryKey<DimensionType> PACSARIA_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            new Identifier(ChucksMod.MOD_ID, "pacsaria_type"));

    public static void bootstrapType(Registerable<DimensionType> context){
        context.register(TRIAFIA_TYPE, new DimensionType(
                OptionalLong.empty(),     //fixedTime
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
                0.0f,        //ambient light
                new DimensionType.MonsterSettings(false, false, UniformIntProvider.create(0, 0), 4)));
        context.register(PACSARIA_TYPE, new DimensionType(
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
