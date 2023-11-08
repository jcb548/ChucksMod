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
    public static final TagKey<Block> DIRITIA_LOGS = ModBlockTags.of("diritia_logs");
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
    public static final TagKey<Block> FABIUM_ORES = ModBlockTags.of("fabium_ores");
    public static final TagKey<Block> DIRITONIUM_ORES = ModBlockTags.of("diritonium_ores");
    public static final TagKey<Block> DUST_BLOCKS = ModBlockTags.of("dust_blocks");

    private static TagKey<Block> of(String id) {
        return TagKey.of(RegistryKeys.BLOCK, new Identifier(ChucksMod.MOD_ID, id));
    }
    private static TagKey<Block> commonOf(String id) {
        return TagKey.of(RegistryKeys.BLOCK, new Identifier("c", id));
    }
}
