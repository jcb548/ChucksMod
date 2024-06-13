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
    public static final Model VINE =
            new Model(Optional.of(new Identifier(ChucksMod.MOD_ID, "block/template/vine_template")),
                    Optional.empty(), TextureKey.TEXTURE);
    public static final Model EXPERIENCE_DRAIN =
            new Model(Optional.of(new Identifier(ChucksMod.MOD_ID, "block/template/experience_drain_template")),
                    Optional.empty(), TextureKey.TEXTURE);
    public static final Model RAIL =
            new Model(Optional.of(new Identifier(ChucksMod.MOD_ID, "block/template/rail_template")),
                    Optional.empty(), TextureKey.TEXTURE);
    public static final Model RAIL_RAISED =
            new Model(Optional.of(new Identifier(ChucksMod.MOD_ID, "block/template/rail_raised_template")),
                    Optional.empty(), TextureKey.TEXTURE);
    public static final Model RAIL_CORNER =
            new Model(Optional.of(new Identifier(ChucksMod.MOD_ID, "block/template/rail_corner_template")),
                    Optional.empty(), TextureKey.TEXTURE);
    public static final Model DETECTOR_RAIL =
            new Model(Optional.of(new Identifier(ChucksMod.MOD_ID, "block/template/detector_rail_template")),
                    Optional.empty(), TextureKey.TEXTURE);
    public static final Model DETECTOR_RAIL_RAISED =
            new Model(Optional.of(new Identifier(ChucksMod.MOD_ID, "block/template/detector_rail_raised_template")),
                    Optional.empty(), TextureKey.TEXTURE);
    public static final Model DETECTOR_RAIL_ON =
            new Model(Optional.of(new Identifier(ChucksMod.MOD_ID, "block/template/detector_rail_on_template")),
                    Optional.empty(), TextureKey.TEXTURE);
    public static final Model DETECTOR_RAIL_RAISED_ON =
            new Model(Optional.of(new Identifier(ChucksMod.MOD_ID, "block/template/detector_rail_raised_on_template")),
                    Optional.empty(), TextureKey.TEXTURE);
}
