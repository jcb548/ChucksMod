package net.chuck.chucksmod.datagen.models;

import net.chuck.chucksmod.block.ModBlocks;
import net.chuck.chucksmod.block.custom.energy_storage.AbstractEnergyStorageBlock;
import net.chuck.chucksmod.util.DirectionIOProperty;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

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
        Models.GENERATED.upload(ModelIds.getItemModelId(wire.asItem()), TextureMap.layer0(wire.asItem()),
                blockStateModelGenerator.modelCollector);
    }
    public static void registerPipe(BlockStateModelGenerator blockStateModelGenerator, Block pipe){
        TextureMap textureMap = new TextureMap().put(ModTextureKeys.CABLE, TextureMap.getId(pipe));
        Identifier core = ModModels.THIN_WIRE_CORE.upload(pipe, "_core",textureMap,
                blockStateModelGenerator.modelCollector);
        Identifier side = ModModels.THIN_WIRE_SIDE.upload(pipe, "_side",textureMap,
                blockStateModelGenerator.modelCollector);
        TextureMap textureMap1 = new TextureMap().put(ModTextureKeys.CABLE, TextureMap.getSubId(pipe, "_extract"));
        Identifier extract = ModModels.THIN_WIRE_SIDE.upload(pipe, "_extract",
                textureMap1, blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(MultipartBlockStateSupplier.create(pipe)
                .with(BlockStateVariant.create().put(VariantSettings.MODEL, core))
                .with(When.create().set(DirectionIOProperty.NORTH, "insert"),
                        BlockStateVariant.create().put(VariantSettings.MODEL, side))
                .with(When.create().set(DirectionIOProperty.EAST, "insert"),
                        BlockStateVariant.create().put(VariantSettings.MODEL, side)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .with(When.create().set(DirectionIOProperty.SOUTH, "insert"),
                        BlockStateVariant.create().put(VariantSettings.MODEL, side)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .with(When.create().set(DirectionIOProperty.WEST, "insert"),
                        BlockStateVariant.create().put(VariantSettings.MODEL, side)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R270))
                .with(When.create().set(DirectionIOProperty.UP, "insert"),
                        BlockStateVariant.create().put(VariantSettings.MODEL, side)
                                .put(VariantSettings.X, VariantSettings.Rotation.R270))
                .with(When.create().set(DirectionIOProperty.DOWN, "insert"),
                        BlockStateVariant.create().put(VariantSettings.MODEL, side)
                                .put(VariantSettings.X, VariantSettings.Rotation.R90))
                .with(When.create().set(DirectionIOProperty.NORTH, "extract"),
                        BlockStateVariant.create().put(VariantSettings.MODEL, extract))
                .with(When.create().set(DirectionIOProperty.EAST, "extract"),
                        BlockStateVariant.create().put(VariantSettings.MODEL, extract)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .with(When.create().set(DirectionIOProperty.SOUTH, "extract"),
                        BlockStateVariant.create().put(VariantSettings.MODEL, extract)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .with(When.create().set(DirectionIOProperty.WEST, "extract"),
                        BlockStateVariant.create().put(VariantSettings.MODEL, extract)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R270))
                .with(When.create().set(DirectionIOProperty.UP, "extract"),
                        BlockStateVariant.create().put(VariantSettings.MODEL, extract)
                                .put(VariantSettings.X, VariantSettings.Rotation.R270))
                .with(When.create().set(DirectionIOProperty.DOWN, "extract"),
                        BlockStateVariant.create().put(VariantSettings.MODEL, extract)
                                .put(VariantSettings.X, VariantSettings.Rotation.R90))
        );
        Models.GENERATED.upload(ModelIds.getItemModelId(pipe.asItem()), TextureMap.layer0(pipe.asItem()),
                blockStateModelGenerator.modelCollector);
    }
    public static void registerEnergyStorage(BlockStateModelGenerator blockStateModelGenerator, Block storage) {
        TextureMap inventoryMap = new TextureMap().put(TextureKey.FRONT, TextureMap.getSubId(storage, "_front"))
                .put(TextureKey.SIDE, TextureMap.getId(storage))
                .put(TextureKey.TOP, TextureMap.getId(storage));
        Identifier disabled = Models.TEMPLATE_SINGLE_FACE.upload(storage,
                new TextureMap().put(TextureKey.TEXTURE, TextureMap.getId(storage)),
                blockStateModelGenerator.modelCollector);
        Identifier in = Models.TEMPLATE_SINGLE_FACE.upload(storage, "_in",
                new TextureMap().put(TextureKey.TEXTURE, TextureMap.getSubId(storage, "_in")),
                blockStateModelGenerator.modelCollector);
        Identifier out = Models.TEMPLATE_SINGLE_FACE.upload(storage, "_out",
                new TextureMap().put(TextureKey.TEXTURE, TextureMap.getSubId(storage, "_out")),
                blockStateModelGenerator.modelCollector);
        Identifier front = Models.TEMPLATE_SINGLE_FACE.upload(storage, "_front",
                new TextureMap().put(TextureKey.TEXTURE, TextureMap.getSubId(storage, "_front")),
                blockStateModelGenerator.modelCollector);
        Identifier frontIn = Models.TEMPLATE_SINGLE_FACE.upload(storage, "_front_in",
                new TextureMap().put(TextureKey.TEXTURE, TextureMap.getSubId(storage, "_front_in")),
                blockStateModelGenerator.modelCollector);
        Identifier frontOut = Models.TEMPLATE_SINGLE_FACE.upload(storage, "_front_out",
                new TextureMap().put(TextureKey.TEXTURE, TextureMap.getSubId(storage, "_front_out")),
                blockStateModelGenerator.modelCollector);
        Identifier inventory = Models.ORIENTABLE.upload(storage, "_inventory", inventoryMap,
                blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(MultipartBlockStateSupplier.create(storage)
                .with(When.create().set(AbstractEnergyStorageBlock.DOWN, DirectionIOProperty.DISABLED),
                        BlockStateVariant.create().put(VariantSettings.MODEL, disabled).put(VariantSettings.X, VariantSettings.Rotation.R90))
                .with(When.create().set(AbstractEnergyStorageBlock.DOWN, DirectionIOProperty.INSERT),
                        BlockStateVariant.create().put(VariantSettings.MODEL, in).put(VariantSettings.X, VariantSettings.Rotation.R90))
                .with(When.create().set(AbstractEnergyStorageBlock.DOWN, DirectionIOProperty.EXTRACT),
                        BlockStateVariant.create().put(VariantSettings.MODEL, out).put(VariantSettings.X, VariantSettings.Rotation.R90))
                
                .with(When.create().set(AbstractEnergyStorageBlock.UP, DirectionIOProperty.DISABLED),
                        BlockStateVariant.create().put(VariantSettings.MODEL, disabled).put(VariantSettings.X, VariantSettings.Rotation.R270))
                .with(When.create().set(AbstractEnergyStorageBlock.UP, DirectionIOProperty.INSERT),
                        BlockStateVariant.create().put(VariantSettings.MODEL, in).put(VariantSettings.X, VariantSettings.Rotation.R270))
                .with(When.create().set(AbstractEnergyStorageBlock.UP, DirectionIOProperty.EXTRACT),
                        BlockStateVariant.create().put(VariantSettings.MODEL, out).put(VariantSettings.X, VariantSettings.Rotation.R270))
                
                .with(When.create().set(AbstractEnergyStorageBlock.NORTH, DirectionIOProperty.DISABLED),
                        BlockStateVariant.create().put(VariantSettings.MODEL, disabled))
                .with(When.create().set(AbstractEnergyStorageBlock.NORTH, DirectionIOProperty.INSERT),
                        BlockStateVariant.create().put(VariantSettings.MODEL, in))
                .with(When.create().set(AbstractEnergyStorageBlock.NORTH, DirectionIOProperty.EXTRACT),
                        BlockStateVariant.create().put(VariantSettings.MODEL, out))
                .with(When.create().set(AbstractEnergyStorageBlock.NORTH, DirectionIOProperty.DISABLED)
                                .set(Properties.HORIZONTAL_FACING, Direction.NORTH),
                        BlockStateVariant.create().put(VariantSettings.MODEL, front))
                .with(When.create().set(AbstractEnergyStorageBlock.NORTH, DirectionIOProperty.INSERT)
                                .set(Properties.HORIZONTAL_FACING, Direction.NORTH),
                        BlockStateVariant.create().put(VariantSettings.MODEL, frontIn))
                .with(When.create().set(AbstractEnergyStorageBlock.NORTH, DirectionIOProperty.EXTRACT)
                                .set(Properties.HORIZONTAL_FACING, Direction.NORTH),
                        BlockStateVariant.create().put(VariantSettings.MODEL, frontOut))
                
                .with(When.create().set(AbstractEnergyStorageBlock.SOUTH, DirectionIOProperty.DISABLED),
                        BlockStateVariant.create().put(VariantSettings.MODEL, disabled).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .with(When.create().set(AbstractEnergyStorageBlock.SOUTH, DirectionIOProperty.INSERT),
                        BlockStateVariant.create().put(VariantSettings.MODEL, in).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .with(When.create().set(AbstractEnergyStorageBlock.SOUTH, DirectionIOProperty.EXTRACT),
                        BlockStateVariant.create().put(VariantSettings.MODEL, out).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .with(When.create().set(AbstractEnergyStorageBlock.SOUTH, DirectionIOProperty.DISABLED)
                                .set(Properties.HORIZONTAL_FACING, Direction.SOUTH),
                        BlockStateVariant.create().put(VariantSettings.MODEL, front).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .with(When.create().set(AbstractEnergyStorageBlock.SOUTH, DirectionIOProperty.INSERT)
                                .set(Properties.HORIZONTAL_FACING, Direction.SOUTH),
                        BlockStateVariant.create().put(VariantSettings.MODEL, frontIn).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .with(When.create().set(AbstractEnergyStorageBlock.SOUTH, DirectionIOProperty.EXTRACT)
                                .set(Properties.HORIZONTAL_FACING, Direction.SOUTH),
                        BlockStateVariant.create().put(VariantSettings.MODEL, frontOut).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                
                .with(When.create().set(AbstractEnergyStorageBlock.EAST, DirectionIOProperty.DISABLED),
                        BlockStateVariant.create().put(VariantSettings.MODEL, disabled).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .with(When.create().set(AbstractEnergyStorageBlock.EAST, DirectionIOProperty.INSERT),
                        BlockStateVariant.create().put(VariantSettings.MODEL, in).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .with(When.create().set(AbstractEnergyStorageBlock.EAST, DirectionIOProperty.EXTRACT),
                        BlockStateVariant.create().put(VariantSettings.MODEL, out).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .with(When.create().set(AbstractEnergyStorageBlock.EAST, DirectionIOProperty.DISABLED)
                                .set(Properties.HORIZONTAL_FACING, Direction.EAST),
                        BlockStateVariant.create().put(VariantSettings.MODEL, front).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .with(When.create().set(AbstractEnergyStorageBlock.EAST, DirectionIOProperty.INSERT)
                                .set(Properties.HORIZONTAL_FACING, Direction.EAST),
                        BlockStateVariant.create().put(VariantSettings.MODEL, frontIn).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .with(When.create().set(AbstractEnergyStorageBlock.EAST, DirectionIOProperty.EXTRACT)
                                .set(Properties.HORIZONTAL_FACING, Direction.EAST),
                        BlockStateVariant.create().put(VariantSettings.MODEL, frontOut).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                
                .with(When.create().set(AbstractEnergyStorageBlock.WEST, DirectionIOProperty.DISABLED),
                        BlockStateVariant.create().put(VariantSettings.MODEL, disabled).put(VariantSettings.Y, VariantSettings.Rotation.R270))
                .with(When.create().set(AbstractEnergyStorageBlock.WEST, DirectionIOProperty.INSERT),
                        BlockStateVariant.create().put(VariantSettings.MODEL, in).put(VariantSettings.Y, VariantSettings.Rotation.R270))
                .with(When.create().set(AbstractEnergyStorageBlock.WEST, DirectionIOProperty.EXTRACT),
                        BlockStateVariant.create().put(VariantSettings.MODEL, out).put(VariantSettings.Y, VariantSettings.Rotation.R270))
                .with(When.create().set(AbstractEnergyStorageBlock.WEST, DirectionIOProperty.DISABLED)
                                .set(Properties.HORIZONTAL_FACING, Direction.WEST),
                        BlockStateVariant.create().put(VariantSettings.MODEL, front).put(VariantSettings.Y, VariantSettings.Rotation.R270))
                .with(When.create().set(AbstractEnergyStorageBlock.WEST, DirectionIOProperty.INSERT)
                                .set(Properties.HORIZONTAL_FACING, Direction.WEST),
                        BlockStateVariant.create().put(VariantSettings.MODEL, frontIn).put(VariantSettings.Y, VariantSettings.Rotation.R270))
                .with(When.create().set(AbstractEnergyStorageBlock.WEST, DirectionIOProperty.EXTRACT)
                                .set(Properties.HORIZONTAL_FACING, Direction.WEST),
                        BlockStateVariant.create().put(VariantSettings.MODEL, frontOut).put(VariantSettings.Y, VariantSettings.Rotation.R270))
        );
        blockStateModelGenerator.registerParentedItemModel(storage, inventory);
    }
    public static void registerMachineBase(BlockStateModelGenerator blockStateModelGenerator, Block machineBase) {
        TextureMap textureMap = new TextureMap().put(TextureKey.TEXTURE, TextureMap.getId(machineBase));
        Identifier id = ModModels.MACHINE_BASE.upload(machineBase, textureMap, blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(machineBase,
                BlockStateVariant.create().put(VariantSettings.MODEL, id)));
    }
}
