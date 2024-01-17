package net.chuck.chucksmod.datagen.models;

import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

public class ModModelGenerator {
    public static void registerVerticalColumn(BlockStateModelGenerator blockStateModelGenerator, Block block){
        TextureMap map =  new TextureMap()
                .put(TextureKey.PARTICLE, TextureMap.getId(block))
                .put(TextureKey.UP, TextureMap.getSubId(block, "_top"))
                .put(TextureKey.DOWN, TextureMap.getSubId(block, "_top"))
                .put(TextureKey.SIDE, TextureMap.getId(block));
        blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(block,
                Models.CUBE.upload(block, map, blockStateModelGenerator.modelCollector)));
    }

    public static void registerBars(BlockStateModelGenerator blockStateModelGenerator, Block barsBlock) {
        TextureMap textureMap = new TextureMap().put(TextureKey.PANE, TextureMap.getId(barsBlock)).put(TextureKey.EDGE, TextureMap.getId(barsBlock));
        Identifier identifier = Models.TEMPLATE_GLASS_PANE_POST.upload(barsBlock, textureMap, blockStateModelGenerator.modelCollector);
        Identifier identifier2 = Models.TEMPLATE_GLASS_PANE_SIDE.upload(barsBlock, textureMap, blockStateModelGenerator.modelCollector);
        Identifier identifier3 = Models.TEMPLATE_GLASS_PANE_SIDE_ALT.upload(barsBlock, textureMap, blockStateModelGenerator.modelCollector);
        Identifier identifier4 = Models.TEMPLATE_GLASS_PANE_NOSIDE.upload(barsBlock, textureMap, blockStateModelGenerator.modelCollector);
        Identifier identifier5 = Models.TEMPLATE_GLASS_PANE_NOSIDE_ALT.upload(barsBlock, textureMap, blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(MultipartBlockStateSupplier.create(barsBlock)
                .with(BlockStateVariant.create().put(VariantSettings.MODEL, identifier))
                .with(When.create().set(Properties.NORTH, true),
                        BlockStateVariant.create().put(VariantSettings.MODEL, identifier2))
                .with(When.create().set(Properties.EAST, true),
                        BlockStateVariant.create().put(VariantSettings.MODEL, identifier2)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .with(When.create().set(Properties.SOUTH, true),
                        BlockStateVariant.create().put(VariantSettings.MODEL, identifier3))
                .with(When.create().set(Properties.WEST, true),
                        BlockStateVariant.create().put(VariantSettings.MODEL, identifier3)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .with(When.create().set(Properties.NORTH, false),
                        BlockStateVariant.create().put(VariantSettings.MODEL, identifier4))
                .with(When.create().set(Properties.EAST, false),
                        BlockStateVariant.create().put(VariantSettings.MODEL, identifier5)).with(
                                When.create().set(Properties.SOUTH, false),
                        BlockStateVariant.create().put(VariantSettings.MODEL, identifier5)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .with(When.create().set(Properties.WEST, false),
                        BlockStateVariant.create().put(VariantSettings.MODEL, identifier4)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R270)));
        blockStateModelGenerator.registerItemModel(barsBlock);
    }

    public static void registerWire(BlockStateModelGenerator blockStateModelGenerator, Block wire){
        TextureMap textureMap = new TextureMap().put(ModTextureKeys.CABLE, TextureMap.getId(wire));
        Identifier core = ModModels.THIN_WIRE_CORE.upload(wire, "_core",textureMap,
                blockStateModelGenerator.modelCollector);
        Identifier side = ModModels.THIN_WIRE_SIDE.upload(wire, "_side",textureMap,
                blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(MultipartBlockStateSupplier.create(wire)
                .with(BlockStateVariant.create().put(VariantSettings.MODEL, core))
                .with(When.create().set(Properties.NORTH, true),
                        BlockStateVariant.create().put(VariantSettings.MODEL, side))
                .with(When.create().set(Properties.EAST, true),
                        BlockStateVariant.create().put(VariantSettings.MODEL, side)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .with(When.create().set(Properties.SOUTH, true),
                        BlockStateVariant.create().put(VariantSettings.MODEL, side)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .with(When.create().set(Properties.WEST, true),
                        BlockStateVariant.create().put(VariantSettings.MODEL, side)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R270))
                .with(When.create().set(Properties.UP, true),
                        BlockStateVariant.create().put(VariantSettings.MODEL, side)
                                .put(VariantSettings.X, VariantSettings.Rotation.R270))
                .with(When.create().set(Properties.DOWN, true),
                        BlockStateVariant.create().put(VariantSettings.MODEL, side)
                                .put(VariantSettings.X, VariantSettings.Rotation.R90))
        );
    }
}
