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
    public static final Identifier DIRITIA_BOAT_ID =
            new Identifier(ChucksMod.MOD_ID, "diritia_boat");
    public static final Identifier DIRITIA_CHEST_BOAT_ID =
            new Identifier(ChucksMod.MOD_ID, "diritia_chest_boat");

    public static final RegistryKey<TerraformBoatType> DIRITIA_BOAT_KEY =
            TerraformBoatTypeRegistry.createKey(DIRITIA_BOAT_ID);
    public static void registerBoats(){
        TerraformBoatType eucalyptusBoat = new TerraformBoatType.Builder()
                .item(ModItems.EUCALYPTUS_BOAT)
                .chestItem(ModItems.EUCALYPTUS_CHEST_BOAT)
                .planks(ModBlocks.EUCALYPTUS_PLANKS.asItem()).build();
        Registry.register(TerraformBoatTypeRegistry.INSTANCE, EUCALYPTUS_BOAT_KEY, eucalyptusBoat);
        TerraformBoatType diritiaBoat = new TerraformBoatType.Builder()
                .item(ModItems.DIRITIA_BOAT)
                .chestItem(ModItems.DIRITIA_CHEST_BOAT)
                .planks(ModBlocks.DIRITIA_PLANKS.asItem()).build();
        Registry.register(TerraformBoatTypeRegistry.INSTANCE, DIRITIA_BOAT_KEY, diritiaBoat);
    }
}

