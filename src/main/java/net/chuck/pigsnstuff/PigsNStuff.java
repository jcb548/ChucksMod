package net.chuck.pigsnstuff;

import net.chuck.pigsnstuff.block.ModBlocks;
import net.chuck.pigsnstuff.block.entity.ModBlockEntities;
import net.chuck.pigsnstuff.item.ModItemGroups;
import net.chuck.pigsnstuff.item.ModItems;
import net.chuck.pigsnstuff.recipe.ModRecipes;
import net.chuck.pigsnstuff.screen.ModScreenHandlers;
import net.chuck.pigsnstuff.util.ModLootTableModifiers;
import net.chuck.pigsnstuff.util.ModRegistries;
import net.chuck.pigsnstuff.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.block.v1.FabricBlockState;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.color.block.BlockColorProvider;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockRenderView;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/*
 *  Code inspired by or copied from
 *  Kaupenjoe
 *  Copyright (c) 2023
 *
 *  This code is licensed under MIT License
 *  Details can be found in the license file in the root folder of this project
 */
public class PigsNStuff implements ModInitializer {
	public static final String MOD_ID = "pigsnstuff";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();

		ModWorldGeneration.generateModWorldGen();
		ModBlocks.registerModBlocks();
		ModRegistries.registerModStuffs();
		ModLootTableModifiers.modifyLootTables();

		ModBlockEntities.registerBlockEntities();
		ModScreenHandlers.registerAllScreenHandlers();

		ModRecipes.registerRecipes();

		//Custom portals
		CustomPortalBuilder.beginPortal().frameBlock(Blocks.GOLD_BLOCK)
				.lightWithItem(ModItems.WITHER_BONE)
				.destDimID(new Identifier("pigsnstuff", "test"))
				.tintColor(256, 0, 0).registerPortal();
		CustomPortalBuilder.beginPortal().frameBlock(ModBlocks.DIRITONIUM_BLOCK)
				.lightWithItem(ModItems.WITHER_BONE)
				.destDimID(new Identifier("pigsnstuff", "diritia"))
				.tintColor(211, 185, 255).registerPortal();
		//ServerTickEvents.START_SERVER_TICK.register(new PlayerTickHandler());
	}
}