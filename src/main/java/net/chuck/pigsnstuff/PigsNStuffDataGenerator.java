package net.chuck.pigsnstuff;

import net.chuck.pigsnstuff.data.ModLootTableGenerator;
import net.chuck.pigsnstuff.data.ModModelProvider;
import net.chuck.pigsnstuff.data.ModRecipeGenerator;
import net.chuck.pigsnstuff.data.ModWorldGenerator;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class PigsNStuffDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModLootTableGenerator::new);
		pack.addProvider(ModRecipeGenerator::new);
		pack.addProvider(ModModelProvider::new);
		//pack.addProvider(ModWorldGenerator::new);
	}
}
