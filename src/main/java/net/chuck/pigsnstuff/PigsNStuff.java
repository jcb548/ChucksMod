package net.chuck.pigsnstuff;

import net.chuck.pigsnstuff.block.ModBlocks;
import net.chuck.pigsnstuff.block.entity.ModBlockEntities;
import net.chuck.pigsnstuff.item.ModItemGroups;
import net.chuck.pigsnstuff.item.ModItems;
import net.chuck.pigsnstuff.screen.ModScreenHandlers;
import net.chuck.pigsnstuff.util.ModLootTableModifiers;
import net.chuck.pigsnstuff.util.ModRegistries;
import net.chuck.pigsnstuff.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

		//Custom portals
		CustomPortalBuilder.beginPortal().frameBlock(ModBlocks.FABIUM_BLOCK)
				.lightWithItem(ModItems.WITHER_BONE)
				.destDimID(new Identifier("pigsnstuff", "test"))
				.tintColor(256, 0, 0).registerPortal();
		//ServerTickEvents.START_SERVER_TICK.register(new PlayerTickHandler());
	}
}