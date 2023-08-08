package net.chuck.pigsnstuff;

import net.chuck.pigsnstuff.block.ModBlocks;
import net.chuck.pigsnstuff.item.custom.ModItemGroups;
import net.chuck.pigsnstuff.item.custom.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PigsNStuff implements ModInitializer {
	public static final String MOD_ID = "pigsnstuff";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();

		ModBlocks.registerModBlocks();
	}
}