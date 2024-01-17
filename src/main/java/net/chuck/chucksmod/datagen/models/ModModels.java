package net.chuck.chucksmod.datagen.models;

import net.chuck.chucksmod.ChucksMod;
import net.minecraft.data.client.Model;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModModels {
    public static final Model THIN_WIRE_CORE =
            new Model(Optional.of(new Identifier(ChucksMod.MOD_ID, "block/template/thin_wire_core_template")),
                    Optional.empty(), ModTextureKeys.CABLE);
    public static final Model THIN_WIRE_SIDE =
            new Model(Optional.of(new Identifier(ChucksMod.MOD_ID, "block/template/thin_wire_side_template")),
                    Optional.empty(), ModTextureKeys.CABLE);
}
