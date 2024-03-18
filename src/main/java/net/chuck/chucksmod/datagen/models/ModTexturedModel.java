package net.chuck.chucksmod.datagen.models;

import net.minecraft.data.client.Models;
import net.minecraft.data.client.TextureMap;
import net.minecraft.data.client.TexturedModel;

public class ModTexturedModel {
    public static final TexturedModel.Factory ORIENTABLE_MACHINE = TexturedModel.makeFactory(ModTextureMap::machineSideFrontTop, Models.ORIENTABLE);
}
