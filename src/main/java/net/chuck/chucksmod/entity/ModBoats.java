package net.chuck.chucksmod.entity;

import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry;
import net.chuck.chucksmod.ChucksMod;
import net.chuck.chucksmod.block.ModBlocks;
import net.chuck.chucksmod.item.ModItems;
import net.minecraft.item.Item;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModBoats {
    public static final Identifier EUCALYPTUS_BOAT_ID =
            new Identifier(ChucksMod.MOD_ID, "eucalyptus_boat");
    public static final Identifier EUCALYPTUS_CHEST_BOAT_ID =
            new Identifier(ChucksMod.MOD_ID, "eucalyptus_chest_boat");
    public static final RegistryKey<TerraformBoatType> EUCALYPTUS_BOAT_KEY =
            TerraformBoatTypeRegistry.createKey(EUCALYPTUS_BOAT_ID);

    public static final Identifier PACSARIA_BOAT_ID =
            new Identifier(ChucksMod.MOD_ID, "pacsaria_boat");
    public static final Identifier PACSARIA_CHEST_BOAT_ID =
            new Identifier(ChucksMod.MOD_ID, "pacsaria_chest_boat");
    public static final RegistryKey<TerraformBoatType> PACSARIA_BOAT_KEY =
            TerraformBoatTypeRegistry.createKey(PACSARIA_BOAT_ID);

    public static final Identifier TRIAFIA_BOAT_ID =
            new Identifier(ChucksMod.MOD_ID, "triafia_boat");
    public static final Identifier TRIAFIA_CHEST_BOAT_ID =
            new Identifier(ChucksMod.MOD_ID, "triafia_chest_boat");
    public static final RegistryKey<TerraformBoatType> TRIAFIA_BOAT_KEY =
            TerraformBoatTypeRegistry.createKey(TRIAFIA_BOAT_ID);
    public static void registerBoats(){
        TerraformBoatType eucalyptusBoat = new TerraformBoatType.Builder()
                .item(ModItems.EUCALYPTUS_BOAT)
                .chestItem(ModItems.EUCALYPTUS_CHEST_BOAT)
                .planks(ModBlocks.EUCALYPTUS_PLANKS.asItem()).build();
        Registry.register(TerraformBoatTypeRegistry.INSTANCE, EUCALYPTUS_BOAT_KEY, eucalyptusBoat);
        TerraformBoatType pacsariaBoat = new TerraformBoatType.Builder()
                .item(ModItems.PACSARIA_BOAT)
                .chestItem(ModItems.PACSARIA_CHEST_BOAT)
                .planks(ModBlocks.PACSARIA_PLANKS.asItem()).build();
        Registry.register(TerraformBoatTypeRegistry.INSTANCE, PACSARIA_BOAT_KEY, pacsariaBoat);
        TerraformBoatType triafiaBoat = new TerraformBoatType.Builder()
                .item(ModItems.TRIAFIA_BOAT)
                .chestItem(ModItems.TRIAFIA_CHEST_BOAT)
                .planks(ModBlocks.TRIAFIA_PLANKS.asItem()).build();
        Registry.register(TerraformBoatTypeRegistry.INSTANCE, TRIAFIA_BOAT_KEY, triafiaBoat);
    }
}

