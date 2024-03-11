package net.chuck.chucksmod;

import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import com.terraformersmc.terraform.sign.SpriteIdentifierRegistry;
import net.chuck.chucksmod.block.ModBlocks;
import net.chuck.chucksmod.client.ArmorHudOverlay;
import net.chuck.chucksmod.client.LookingAtBlockOverlay;
import net.chuck.chucksmod.entity.ModBoats;
import net.chuck.chucksmod.entity.ModEntities;
import net.chuck.chucksmod.entity.client.*;
import net.chuck.chucksmod.fluid.ModFluids;
import net.chuck.chucksmod.networking.ModMessages;
import net.chuck.chucksmod.screen.*;
import net.chuck.chucksmod.screen.bag.BagScreen3x1;
import net.chuck.chucksmod.screen.bag.BagScreen5x1;
import net.chuck.chucksmod.screen.bag.BagScreen7x1;
import net.chuck.chucksmod.screen.bag.BagScreen9x1;
import net.chuck.chucksmod.screen.bag.BagScreen7x2;
import net.chuck.chucksmod.screen.copier.CopierScreen;
import net.chuck.chucksmod.screen.crusher.CrusherScreen;
import net.chuck.chucksmod.screen.crusher.PoweredCrusherScreen;
import net.chuck.chucksmod.screen.furnace.PoweredFurnaceScreen;
import net.chuck.chucksmod.screen.generator.heat.HeatGeneratorScreen;
import net.chuck.chucksmod.screen.energy_storage.EnergyStorageScreen;
import net.chuck.chucksmod.screen.generator.steam.SteamGeneratorScreen;
import net.chuck.chucksmod.screen.generator.lava.LavaGeneratorScreen;
import net.chuck.chucksmod.screen.portal_builder.PortalBuilderScreen;
import net.chuck.chucksmod.screen.pump.PumpScreen;
import net.chuck.chucksmod.screen.quarry.IronQuarryScreen;
import net.chuck.chucksmod.screen.quarry.TitaniumQuarryScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.color.item.ItemColorProvider;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.util.Identifier;

/*
 *  Code inspired by or copied from
 *  Kaupenjoe
 *  Copyright (c) 2023
 *
 *  This code is licensed under MIT License
 *  Details can be found in the license file in the root folder of this project
 */
public class ChucksModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModMessages.registerS2CPackets();

        registerTintedBlocks();
        registerCutoutBlocks();
        registerTranslucentBlocks();
        registerHandledScreens();

        HudRenderCallback.EVENT.register(new ArmorHudOverlay());
        HudRenderCallback.EVENT.register(new LookingAtBlockOverlay());
        registerEntityRenderers();

        registerSignRenderers();
        registerFluidRenderers();

        TerraformBoatClientHelper.registerModelLayers(ModBoats.EUCALYPTUS_BOAT_ID, false);
        TerraformBoatClientHelper.registerModelLayers(ModBoats.PACSARIA_BOAT_ID, false);
        TerraformBoatClientHelper.registerModelLayers(ModBoats.TRIAFIA_BOAT_ID, false);
    }

    private void registerFluidRenderers() {
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_LIQUID_XP, ModFluids.FLOWING_LIQUID_XP,
                new SimpleFluidRenderHandler(
                        new Identifier("minecraft:block/water_still"),
                        new Identifier("minecraft:block/water_flow"),
                        0xA11CF700
                ));
    }

    private void registerSignRenderers(){
        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE,
                ModBlocks.EUCALYPTUS_SIGN_TEXTURE));

        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE,
                ModBlocks.EUCALYPTUS_HANGING_SIGN_TEXTURE));

        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE,
                ModBlocks.PACSARIA_SIGN_TEXTURE));

        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE,
                ModBlocks.PACSARIA_HANGING_SIGN_TEXTURE));

        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE,
                ModBlocks.TRIAFIA_SIGN_TEXTURE));

        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE,
                ModBlocks.TRIAFIA_HANGING_SIGN_TEXTURE));
    }
    private void registerEntityRenderers(){
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.WYATT, WyattModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.WYATT, WyattRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.FRANK, FrankModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.FRANK_BOSS, FrankRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.FRANK_FIREBALL, FrankFireballModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.FRANK_FIREBALL, FrankFireballRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.SOUL_BLAZE, SoulBlazeModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.SOUL_BLAZE_BOSS, SoulBlazeRenderer::new);
        EntityModelLayerRegistry.registerModelLayer((ModModelLayers.SOUL_BLAZE_ROD), SoulBlazeRodModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.SOUL_BLAZE_ROD, SoulBlazeRodRenderer::new);
        EntityModelLayerRegistry.registerModelLayer((ModModelLayers.FARMABYN), FarmabynModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.FARMABYN, FarmabynRenderer::new);
        EntityModelLayerRegistry.registerModelLayer((ModModelLayers.TRIAFIAN_PIG), TriafianPigModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.TRIAFIAN_PIG, TriafianPigRenderer::new);
        EntityModelLayerRegistry.registerModelLayer((ModModelLayers.PIPPIN), PippinModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.PIPPIN, PippinRenderer::new);

    }

    private void registerTintedBlocks(){
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> BiomeColors.getGrassColor(view, pos),
                ModBlocks.PACSARIA_PLANT);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0xFE8738,
                ModBlocks.PACSARIA_LIGHT_PLANT);

        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> BiomeColors.getGrassColor(view, pos),
                ModBlocks.TRIAFIA_PLANT);

        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> BiomeColors.getFoliageColor(view, pos),
                ModBlocks.PACSARIA_LEAVES);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> BiomeColors.getFoliageColor(view, pos),
                ModBlocks.TRIAFIA_LEAVES);

        ColorProviderRegistry.ITEM.register(((stack, tintIndex) -> 0x51912C),
                ModBlocks.PACSARIA_LEAVES.asItem());
        ColorProviderRegistry.ITEM.register(((stack, tintIndex) -> 0x328009),
                ModBlocks.TRIAFIA_LEAVES.asItem());

        ColorProviderRegistry.ITEM.register(((stack, tintIndex) -> 0x328009),
                ModBlocks.TRIAFIA_PLANT.asItem());
        ColorProviderRegistry.ITEM.register(((stack, tintIndex) -> 0x51912C),
                ModBlocks.PACSARIA_PLANT.asItem());
    }
    private void registerCutoutBlocks(){
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.EUCALYPTUS_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.EUCALYPTUS_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.EUCALYPTUS_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.EUCALYPTUS_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PACSARIA_PLANT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PACSARIA_LIGHT_PLANT, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PACSARIA_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PACSARIA_LEAVES, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PACSARIA_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PACSARIA_TRAPDOOR, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TRIAFIA_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TRIAFIA_PLANT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TRIAFIA_LEAVES, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TRIAFIA_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TRIAFIA_TRAPDOOR, RenderLayer.getCutout());
        
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.COPPER_BARS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GOLD_BARS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BRONZE_BARS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TIN_BARS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PRISMARINE_BARS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PACSARIUM_BARS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TRIAFIUM_BARS, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TOMATO_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LETTUCE_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PINEAPPLE_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.IRON_MACHINE_BASE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TITANIUM_MACHINE_BASE, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.NETHER_CRYSTAL_CROP, RenderLayer.getCutout());
    }

    private void registerTranslucentBlocks(){
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HARDENED_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HARDENED_GLASS_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HARDENED_TINTED_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HARDENED_BLACK_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HARDENED_BLACK_GLASS_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HARDENED_BLUE_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HARDENED_BLUE_GLASS_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HARDENED_BROWN_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HARDENED_BROWN_GLASS_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HARDENED_CYAN_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HARDENED_CYAN_GLASS_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HARDENED_GRAY_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HARDENED_GRAY_GLASS_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HARDENED_GREEN_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HARDENED_GREEN_GLASS_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HARDENED_LIGHT_BLUE_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HARDENED_LIGHT_BLUE_GLASS_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HARDENED_LIGHT_GRAY_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HARDENED_LIGHT_GRAY_GLASS_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HARDENED_LIME_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HARDENED_LIME_GLASS_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HARDENED_MAGENTA_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HARDENED_MAGENTA_GLASS_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HARDENED_ORANGE_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HARDENED_ORANGE_GLASS_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HARDENED_PINK_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HARDENED_PINK_GLASS_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HARDENED_PURPLE_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HARDENED_PURPLE_GLASS_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HARDENED_RED_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HARDENED_RED_GLASS_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HARDENED_WHITE_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HARDENED_WHITE_GLASS_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HARDENED_YELLOW_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HARDENED_YELLOW_GLASS_PANE, RenderLayer.getTranslucent());

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluids.STILL_LIQUID_XP,
                ModFluids.FLOWING_LIQUID_XP);
    }
    private void registerHandledScreens(){
        HandledScreens.register(ModScreenHandlers.CRUSHER_SCREEN_HANDLER, CrusherScreen::new);
        HandledScreens.register(ModScreenHandlers.POWERED_CRUSHER_SCREEN_HANDLER, PoweredCrusherScreen::new);
        HandledScreens.register(ModScreenHandlers.POWERED_FURNACE_SCREEN_HANDLER, PoweredFurnaceScreen::new);
        HandledScreens.register(ModScreenHandlers.GENERATOR_SCREEN_HANDLER, HeatGeneratorScreen::new);
        HandledScreens.register(ModScreenHandlers.ENERGY_STORAGE_SCREEN_HANDLER, EnergyStorageScreen::new);
        HandledScreens.register(ModScreenHandlers.COPIER_SCREEN_HANDLER, CopierScreen::new);
        HandledScreens.register(ModScreenHandlers.PUMP_SCREEN_HANDLER, PumpScreen::new);
        HandledScreens.register(ModScreenHandlers.STEAM_GENERATOR_SCREEN_HANDLER, SteamGeneratorScreen::new);
        HandledScreens.register(ModScreenHandlers.LAVA_GENERATOR_SCREEN_HANDLER, LavaGeneratorScreen::new);
        HandledScreens.register(ModScreenHandlers.IRON_QUARRY_SCREEN_HANDLER, IronQuarryScreen::new);
        HandledScreens.register(ModScreenHandlers.TITANIUM_QUARRY_SCREEN_HANDLER, TitaniumQuarryScreen::new);
        HandledScreens.register(ModScreenHandlers.PORTAL_BUILDER_SCREEN_HANDLER, PortalBuilderScreen::new);
        HandledScreens.register(ModScreenHandlers.BAG_3X1_SCREEN_HANDLER, BagScreen3x1::new);
        HandledScreens.register(ModScreenHandlers.BAG_5X1_SCREEN_HANDLER, BagScreen5x1::new);
        HandledScreens.register(ModScreenHandlers.BAG_7X1_SCREEN_HANDLER, BagScreen7x1::new);
        HandledScreens.register(ModScreenHandlers.BAG_9X1_SCREEN_HANDLER, BagScreen9x1::new);
        HandledScreens.register(ModScreenHandlers.BAG_7X2_SCREEN_HANDLER, BagScreen7x2::new);
    }
}
