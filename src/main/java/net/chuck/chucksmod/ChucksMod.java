package net.chuck.chucksmod;

import net.chuck.chucksmod.block.ModBlocks;
import net.chuck.chucksmod.block.entity.ModBlockEntities;
import net.chuck.chucksmod.entity.ModBoats;
import net.chuck.chucksmod.entity.ModEntities;
import net.chuck.chucksmod.entity.custom.FrankBoss;
import net.chuck.chucksmod.entity.custom.SoulBlazeBoss;
import net.chuck.chucksmod.entity.custom.WyattEntity;
import net.chuck.chucksmod.fluid.ModFluids;
import net.chuck.chucksmod.item.ModItemGroups;
import net.chuck.chucksmod.item.ModItems;
import net.chuck.chucksmod.item.enchantment.ModEnchantments;
import net.chuck.chucksmod.networking.ModMessages;
import net.chuck.chucksmod.recipe.ModRecipes;
import net.chuck.chucksmod.screen.ModScreenHandlers;
import net.chuck.chucksmod.util.ModCustomTrades;
import net.chuck.chucksmod.util.ModLootTableModifiers;
import net.chuck.chucksmod.util.ModRegistries;
import net.chuck.chucksmod.world.gen.ModWorldGeneration;
import net.chuck.chucksmod.world.tree.ModFoliagePlacerTypes;
import net.chuck.chucksmod.world.tree.ModTrunkPlacerTypes;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
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
public class ChucksMod implements ModInitializer {
	public static final String MOD_ID = "chucksmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();

		ModWorldGeneration.generateModWorldGen();
		ModBlocks.registerModBlocks();
		ModRegistries.registerModStuffs();
		ModLootTableModifiers.modifyLootTables();
		ModCustomTrades.registerCustomTrades();

		ModBlockEntities.registerBlockEntities();
		ModScreenHandlers.registerAllScreenHandlers();

		ModRecipes.registerRecipes();
		ModBoats.registerBoats();
		ModEnchantments.registerEnchantments();

		ModFluids.register();
		ModTrunkPlacerTypes.register();
		ModFoliagePlacerTypes.register();

		//Custom portals
		CustomPortalBuilder.beginPortal().frameBlock(ModBlocks.TRIAFIUM_PORTAL_BLOCK)
				.lightWithItem(ModItems.WITHER_BONE)
				.destDimID(new Identifier(MOD_ID, "triafia"))
				.tintColor(256, 0, 0).registerPortal();
		CustomPortalBuilder.beginPortal().frameBlock(ModBlocks.PACSARIUM_BLOCK)
				.lightWithItem(ModItems.WITHER_BONE)
				.destDimID(new Identifier(MOD_ID, "pacsaria"))
				.tintColor(211, 185, 255).registerPortal();
		//ServerTickEvents.START_SERVER_TICK.register(new PlayerTickHandler());
		FabricDefaultAttributeRegistry.register(ModEntities.WYATT, WyattEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.FRANK_BOSS, FrankBoss.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.SOUL_BLAZE_BOSS, SoulBlazeBoss.createSoulBlazeAttributes());
		ModMessages.registerC2SPackets();
	}
}