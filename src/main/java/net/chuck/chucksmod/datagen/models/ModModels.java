package net.chuck.chucksmod.datagen.models;

import net.chuck.chucksmod.ChucksMod;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.data.client.TextureKey;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModModels {
    public static final Model THIN_WIRE_CORE =
            new Model(Optional.of(new Identifier(ChucksMod.MOD_ID, "block/template/thin_wire_core_template")),
                    Optional.empty(), ModTextureKeys.CABLE);
    public static final Model THIN_WIRE_SIDE =
            new Model(Optional.of(new Identifier(ChucksMod.MOD_ID, "block/template/thin_wire_side_template")),
                    Optional.empty(), ModTextureKeys.CABLE);
    public static final Model MACHINE_BASE =
            new Model(Optional.of(new Identifier(ChucksMod.MOD_ID, "block/template/machine_base_template")),
                    Optional.empty(), TextureKey.TEXTURE);
    public static final Model HANDHELD_WIRE =
            new Model(Optional.of(new Identifier(ChucksMod.MOD_ID, "item/template/handheld_wire")),
                    Optional.empty(), TextureKey.LAYER0);
}
