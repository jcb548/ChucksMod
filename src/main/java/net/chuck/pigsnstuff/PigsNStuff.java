package net.chuck.pigsnstuff;

import net.chuck.pigsnstuff.block.ModBlocks;
import net.chuck.pigsnstuff.block.entity.ModBlockEntities;
import net.chuck.pigsnstuff.item.custom.ModItemGroups;
import net.chuck.pigsnstuff.item.custom.ModItems;
import net.chuck.pigsnstuff.screen.ModScreenHandlers;
import net.chuck.pigsnstuff.util.ModLootTableModifiers;
import net.chuck.pigsnstuff.util.ModRegistries;
import net.chuck.pigsnstuff.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
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

		//ServerTickEvents.START_SERVER_TICK.register(new PlayerTickHandler());
	}
}