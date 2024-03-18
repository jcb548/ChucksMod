package net.chuck.chucksmod.datagen.models;

import net.chuck.chucksmod.ChucksMod;
import net.minecraft.block.Block;
import net.minecraft.data.client.TextureKey;
import net.minecraft.data.client.TextureMap;
import net.minecraft.util.Identifier;

public class ModTextureMap {
    public static TextureMap machineSideFrontTop(Block block) {
        String tier = "";
        if(block.getTranslationKey().contains("iron")) tier = "iron";
        if(block.getTranslationKey().contains("titanium")) tier = "titanium";
        if(block.getTranslationKey().contains("triafium")) tier = "triafium";
        return new TextureMap().put(TextureKey.SIDE, new Identifier(ChucksMod.MOD_ID, "block/" + tier + "_machine_side"))
                .put(TextureKey.FRONT, TextureMap.getSubId(block, "_front"))
                .put(TextureKey.TOP, new Identifier(ChucksMod.MOD_ID, "block/" + tier + "_machine_top"));
    }
}
