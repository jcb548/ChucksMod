package net.chuck.chucksmod.block.custom;

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

    private static TagKey<Block> of(String id) {
        return TagKey.of(RegistryKeys.BLOCK, new Identifier(ChucksMod.MOD_ID, id));
    }
}
