package net.chuck.chucksmod.block;

import net.chuck.chucksmod.ChucksMod;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
/*
 *  Code inspired by or copied from
 *  Kaupenjoe
 *  Copyright (c) 2023
 *
 *  This code is licensed under MIT License
 *  Details can be found in the license file in the root folder of this project
 */
public class ModBlockTags {
    public static final TagKey<Block> EUCALYPTUS_LOGS = ModBlockTags.of("eucalyptus_logs");
    public static final TagKey<Block> PACSARIA_LOGS = ModBlockTags.of("pacsaria_logs");
    public static final TagKey<Block> TRIAFIA_LOGS = ModBlockTags.of("triafia_logs");
    public static final TagKey<Block> HARDENED_GLASS = ModBlockTags.of("hardened_glass");
    public static final TagKey<Block> HARDENED_GLASS_PANES = ModBlockTags.of("hardened_glass_panes");
    public static final TagKey<Block> WIRES = ModBlockTags.of("wires");
    public static final TagKey<Block> BARS = ModBlockTags.of("bars");
    public static final TagKey<Block> TIN_ORES = ModBlockTags.commonOf("tin_ores");
    public static final TagKey<Block> TIN_BLOCKS = ModBlockTags.commonOf("tin_blocks");
    public static final TagKey<Block> RAW_TIN_BLOCKS = ModBlockTags.commonOf("raw_tin_blocks");
    public static final TagKey<Block> BRONZE_BLOCKS = ModBlockTags.commonOf("bronze_blocks");
    public static final TagKey<Block> TITANIUM_ORES = ModBlockTags.commonOf("titanium_ores");
    public static final TagKey<Block> TITANIUM_BLOCKS = ModBlockTags.commonOf("titanium_blocks");
    public static final TagKey<Block> RAW_TITANIUM_BLOCKS = ModBlockTags.commonOf("raw_titanium_blocks");
    public static final TagKey<Block> TRIAFIUM_ORES = ModBlockTags.of("triafium_ores");
    public static final TagKey<Block> PACSARIUM_ORES = ModBlockTags.of("pacsarium_ores");
    public static final TagKey<Block> DUST_BLOCKS = ModBlockTags.of("dust_blocks");
    public static final TagKey<Block> CRUSHERS = ModBlockTags.of("crushers");
    public static final TagKey<Block> GENERATORS = ModBlockTags.of("generators");
    public static final TagKey<Block> MACHINE_BASES = ModBlockTags.of("machine_bases");

    private static TagKey<Block> of(String id) {
        return TagKey.of(RegistryKeys.BLOCK, new Identifier(ChucksMod.MOD_ID, id));
    }
    private static TagKey<Block> commonOf(String id) {
        return TagKey.of(RegistryKeys.BLOCK, new Identifier("c", id));
    }
}
