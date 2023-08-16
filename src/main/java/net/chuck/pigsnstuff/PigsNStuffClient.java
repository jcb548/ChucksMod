package net.chuck.pigsnstuff;

import net.chuck.pigsnstuff.block.ModBlocks;
import net.chuck.pigsnstuff.screen.InfusingScreen;
import net.chuck.pigsnstuff.screen.ModScreenHandlers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.GrassColors;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;

import java.awt.*;

public class PigsNStuffClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.EUCALYPTUS_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.EUCALYPTUS_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.EUCALYPTUS_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.EUCALYPTUS_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SLATED_GRASS, RenderLayer.getCutout());
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> BiomeColors.getGrassColor(view, pos),
                ModBlocks.SLATED_GRASS);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DIRITIA_PLANT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DIRITIA_LIGHT_PLANT, RenderLayer.getCutout());
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> BiomeColors.getGrassColor(view, pos),
                ModBlocks.DIRITIA_PLANT);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0xFE8738,
                ModBlocks.DIRITIA_LIGHT_PLANT);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DIRITIA_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DIRITIA_LEAVES, RenderLayer.getCutout());
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> BiomeColors.getGrassColor(view, pos),
                ModBlocks.DIRITIA_LEAVES);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DIRITIA_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DIRITIA_TRAPDOOR, RenderLayer.getCutout());

        HandledScreens.register(ModScreenHandlers.INFUSING_SCREEN_HANDLER, InfusingScreen::new);
    }
}
