package net.chuck.chucksmod.datagen;

import dev.architectury.platform.Mod;
import net.chuck.chucksmod.block.ModBlocks;
import net.chuck.chucksmod.item.ModItemTags;
import net.chuck.chucksmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

/*
 *  Code inspired by or copied from
 *  Kaupenjoe
 *  Copyright (c) 2023
 *
 *  This code is licensed under MIT License
 *  Details can be found in the license file in the root folder of this project
 */
public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }
    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.BRONZE_HELMET)
                .add(ModItems.BRONZE_CHESTPLATE)
                .add(ModItems.BRONZE_LEGGINGS)
                .add(ModItems.BRONZE_BOOTS)
                .add(ModItems.TITANIUM_HELMET)
                .add(ModItems.TITANIUM_CHESTPLATE)
                .add(ModItems.TITANIUM_LEGGINGS)
                .add(ModItems.TITANIUM_BOOTS)
                .add(ModItems.PRISMARINE_HELMET)
                .add(ModItems.PRISMARINE_CHESTPLATE)
                .add(ModItems.PRISMARINE_LEGGINGS)
                .add(ModItems.PRISMARINE_BOOTS)
                .add(ModItems.TRIAFIUM_HELMET)
                .add(ModItems.TRIAFIUM_CHESTPLATE)
                .add(ModItems.TRIAFIUM_LEGGINGS)
                .add(ModItems.TRIAFIUM_BOOTS)
                .add(ModItems.PACSARIUM_HELMET)
                .add(ModItems.PACSARIUM_CHESTPLATE)
                .add(ModItems.PACSARIUM_LEGGINGS)
                .add(ModItems.PACSARIUM_BOOTS);

        getOrCreateTagBuilder(ModItemTags.COOKED_MEAT)
                .add(Items.COOKED_BEEF)
                .add(Items.COOKED_PORKCHOP)
                .add(Items.COOKED_CHICKEN)
                .add(Items.COOKED_RABBIT)
                .add(Items.COOKED_COD)
                .add(Items.COOKED_SALMON)
                .add(Items.COOKED_MUTTON);

        getOrCreateTagBuilder(ModItemTags.RAW_MEAT)
                .add(Items.BEEF)
                .add(Items.PORKCHOP)
                .add(Items.CHICKEN)
                .add(Items.RABBIT)
                .add(Items.COD)
                .add(Items.SALMON)
                .add(Items.MUTTON);

        getOrCreateTagBuilder(ModItemTags.SEEDS)
                .add(Items.WHEAT_SEEDS)
                .add(Items.BEETROOT_SEEDS)
                .add(Items.MELON_SEEDS)
                .add(Items.PUMPKIN_SEEDS)
                .add(ModItems.TOMATO_SEEDS)
                .add(ModItems.LETTUCE_SEEDS)
                .add(ModItems.PINEAPPLE_SEEDS)
                .add(ModItems.COPPER_SEEDS)
                .add(ModItems.IRON_SEEDS)
                .add(ModItems.GOLD_SEEDS)
                .add(ModItems.REDSTONE_SEEDS)
                .add(ModItems.DIAMOND_SEEDS)
                .add(ModItems.LAPIS_SEEDS)
                .add(ModItems.TITANIUM_SEEDS)
                .add(ModItems.COAL_SEEDS);

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.BRONZE_SWORD)
                .add(ModItems.TRIAFIUM_SWORD)
                .add(ModItems.WITHER_SWORD)
                .add(ModItems.PRISMARINE_SWORD)
                .add(ModItems.PACSARIUM_SWORD)
                .add(ModItems.TITANIUM_SWORD);

        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.BRONZE_PICKAXE)
                .add(ModItems.TRIAFIUM_PICKAXE)
                .add(ModItems.WITHER_PICKAXE)
                .add(ModItems.PRISMARINE_PICKAXE)
                .add(ModItems.PACSARIUM_PICKAXE)
                .add(ModItems.TITANIUM_PICKAXE);

        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.BRONZE_AXE)
                .add(ModItems.TRIAFIUM_AXE)
                .add(ModItems.WITHER_AXE)
                .add(ModItems.PRISMARINE_AXE)
                .add(ModItems.PACSARIUM_AXE)
                .add(ModItems.TITANIUM_AXE);

        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.BRONZE_SHOVEL)
                .add(ModItems.TRIAFIUM_SHOVEL)
                .add(ModItems.WITHER_SHOVEL)
                .add(ModItems.PRISMARINE_SHOVEL)
                .add(ModItems.PACSARIUM_SHOVEL)
                .add(ModItems.TITANIUM_SHOVEL);

        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.BRONZE_HOE)
                .add(ModItems.TRIAFIUM_HOE)
                .add(ModItems.WITHER_HOE)
                .add(ModItems.PRISMARINE_HOE)
                .add(ModItems.PACSARIUM_HOE)
                .add(ModItems.TITANIUM_HOE);

        getOrCreateTagBuilder(ModItemTags.TIN_INGOTS)
                .add(ModItems.TIN_INGOT);

        getOrCreateTagBuilder(ModItemTags.BRONZE_INGOTS)
                .add(ModItems.BRONZE_INGOT);

        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.EUCALYPTUS_PLANKS.asItem())
                .add(ModBlocks.PACSARIA_PLANKS.asItem())
                .add(ModBlocks.TRIAFIA_PLANKS.asItem());

        getOrCreateTagBuilder(ItemTags.WOODEN_BUTTONS)
                .add(ModBlocks.EUCALYPTUS_BUTTON.asItem())
                .add(ModBlocks.PACSARIA_BUTTON.asItem())
                .add(ModBlocks.TRIAFIA_BUTTON.asItem());

        getOrCreateTagBuilder(ItemTags.WOODEN_DOORS)
                .add(ModBlocks.EUCALYPTUS_DOOR.asItem())
                .add(ModBlocks.PACSARIA_DOOR.asItem())
                .add(ModBlocks.TRIAFIA_DOOR.asItem());

        getOrCreateTagBuilder(ItemTags.WOODEN_FENCES)
                .add(ModBlocks.EUCALYPTUS_FENCE.asItem())
                .add(ModBlocks.PACSARIA_FENCE.asItem())
                .add(ModBlocks.TRIAFIA_FENCE.asItem());

        getOrCreateTagBuilder(ItemTags.WOODEN_SLABS)
                .add(ModBlocks.EUCALYPTUS_SLAB.asItem())
                .add(ModBlocks.PACSARIA_SLAB.asItem())
                .add(ModBlocks.TRIAFIA_SLAB.asItem());

        getOrCreateTagBuilder(ItemTags.WOODEN_STAIRS)
                .add(ModBlocks.EUCALYPTUS_STAIRS.asItem())
                .add(ModBlocks.PACSARIA_STAIRS.asItem())
                .add(ModBlocks.TRIAFIA_STAIRS.asItem());

        getOrCreateTagBuilder(ItemTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.EUCALYPTUS_PRESSURE_PLATE.asItem())
                .add(ModBlocks.PACSARIA_PRESSURE_PLATE.asItem())
                .add(ModBlocks.TRIAFIA_PRESSURE_PLATE.asItem());

        getOrCreateTagBuilder(ItemTags.WOODEN_TRAPDOORS)
                .add(ModBlocks.EUCALYPTUS_TRAPDOOR.asItem())
                .add(ModBlocks.PACSARIA_TRAPDOOR.asItem())
                .add(ModBlocks.TRIAFIA_TRAPDOOR.asItem());

        getOrCreateTagBuilder(ItemTags.FENCE_GATES)
                .add(ModBlocks.EUCALYPTUS_FENCE_GATE.asItem())
                .add(ModBlocks.PACSARIA_FENCE_GATE.asItem())
                .add(ModBlocks.TRIAFIA_FENCE_GATE.asItem());

        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.EUCALYPTUS_LOG.asItem())
                .add(ModBlocks.EUCALYPTUS_WOOD.asItem())
                .add(ModBlocks.STRIPPED_EUCALYPTUS_LOG.asItem())
                .add(ModBlocks.STRIPPED_EUCALYPTUS_WOOD.asItem())
                .add(ModBlocks.PACSARIA_LOG.asItem())
                .add(ModBlocks.PACSARIA_WOOD.asItem())
                .add(ModBlocks.STRIPPED_PACSARIA_LOG.asItem())
                .add(ModBlocks.STRIPPED_PACSARIA_WOOD.asItem())
                .add(ModBlocks.TRIAFIA_LOG.asItem())
                .add(ModBlocks.TRIAFIA_WOOD.asItem())
                .add(ModBlocks.STRIPPED_TRIAFIA_LOG.asItem())
                .add(ModBlocks.STRIPPED_TRIAFIA_WOOD.asItem());

        getOrCreateTagBuilder(ItemTags.WALLS)
                .add(ModBlocks.SANDSTONE_BRICK_WALL.asItem())
                .add(ModBlocks.ECLOGITE_WALL.asItem())
                .add(ModBlocks.ECLOGITE_BRICK_WALL.asItem())
                .add(ModBlocks.SERPENTINITE_WALL.asItem())
                .add(ModBlocks.SERPENTINITE_BRICK_WALL.asItem())
                .add(ModBlocks.POLISHED_SERPENTINITE_WALL.asItem())
                .add(ModBlocks.SOUL_STONE_BRICK_WALL.asItem())
                ;

        getOrCreateTagBuilder(ModItemTags.DUSTS)
                .add(ModItems.BRONZE_DUST)
                .add(ModItems.IRON_DUST)
                .add(ModItems.COPPER_DUST)
                .add(ModItems.TIN_DUST)
                .add(ModItems.GOLD_DUST)
                .add(ModItems.OBSIDIAN_DUST)
                .add(ModItems.PRISMARINE_DUST)
                .add(ModItems.TITANIUM_DUST)
                .add(ModItems.PRISMARINE_IRON_DUST)
                .add(ModItems.TRIAFIA_CRYSTAL_DUST);

        getOrCreateTagBuilder(ModItemTags.HELMETS)
                .add(Items.TURTLE_HELMET)
                .add(Items.DIAMOND_HELMET)
                .add(Items.IRON_HELMET)
                .add(Items.LEATHER_HELMET)
                .add(Items.GOLDEN_HELMET)
                .add(Items.NETHERITE_HELMET)
                .add(Items.CHAINMAIL_HELMET)
                .add(ModItems.PRISMARINE_HELMET)
                .add(ModItems.BRONZE_HELMET)
                .add(ModItems.TRIAFIUM_HELMET)
                .add(ModItems.PACSARIUM_HELMET)
                .add(ModItems.TITANIUM_HELMET);
        getOrCreateTagBuilder(ModItemTags.CHESTPLATES)
                .add(Items.DIAMOND_CHESTPLATE)
                .add(Items.IRON_CHESTPLATE)
                .add(Items.LEATHER_CHESTPLATE)
                .add(Items.GOLDEN_CHESTPLATE)
                .add(Items.NETHERITE_CHESTPLATE)
                .add(Items.CHAINMAIL_CHESTPLATE)
                .add(ModItems.PRISMARINE_CHESTPLATE)
                .add(ModItems.BRONZE_CHESTPLATE)
                .add(ModItems.TRIAFIUM_CHESTPLATE)
                .add(ModItems.PACSARIUM_CHESTPLATE)
                .add(ModItems.TITANIUM_CHESTPLATE);
        getOrCreateTagBuilder(ModItemTags.LEGGINGS)
                .add(Items.DIAMOND_LEGGINGS)
                .add(Items.IRON_LEGGINGS)
                .add(Items.LEATHER_LEGGINGS)
                .add(Items.GOLDEN_LEGGINGS)
                .add(Items.NETHERITE_LEGGINGS)
                .add(Items.CHAINMAIL_LEGGINGS)
                .add(ModItems.PRISMARINE_LEGGINGS)
                .add(ModItems.BRONZE_LEGGINGS)
                .add(ModItems.TRIAFIUM_LEGGINGS)
                .add(ModItems.PACSARIUM_LEGGINGS)
                .add(ModItems.TITANIUM_LEGGINGS);
        getOrCreateTagBuilder(ModItemTags.BOOTS)
                .add(Items.DIAMOND_BOOTS)
                .add(Items.IRON_BOOTS)
                .add(Items.LEATHER_BOOTS)
                .add(Items.GOLDEN_BOOTS)
                .add(Items.NETHERITE_BOOTS)
                .add(Items.CHAINMAIL_BOOTS)
                .add(ModItems.PRISMARINE_BOOTS)
                .add(ModItems.BRONZE_BOOTS)
                .add(ModItems.TRIAFIUM_BOOTS)
                .add(ModItems.PACSARIUM_BOOTS)
                .add(ModItems.TITANIUM_BOOTS);

        getOrCreateTagBuilder(ModItemTags.ENCHANTABLES)
                .addTag(ItemTags.SWORDS)
                .addTag(ItemTags.PICKAXES)
                .addTag(ItemTags.AXES)
                .addTag(ItemTags.SHOVELS)
                .addTag(ItemTags.HOES)
                .addTag(ItemTags.TRIMMABLE_ARMOR)
                .add(Items.SHEARS)
                .add(Items.FLINT_AND_STEEL)
                .add(Items.ELYTRA)
                .add(Items.TRIDENT);

        getOrCreateTagBuilder(ModItemTags.ELYTRAS)
                .add(Items.ELYTRA);

        getOrCreateTagBuilder(ModItemTags.BAGS)
                .add(ModItems.WOOL_BAG)
                .add(ModItems.LEATHER_BAG)
                .add(ModItems.BRONZE_BAG)
                .add(ModItems.COPPER_BAG)
                .add(ModItems.TITANIUM_BAG)
                .add(ModItems.TRIAFIUM_BAG)
                .add(ModItems.IRON_BAG)
                .add(ModItems.NETHERITE_BAG);
        
        getOrCreateTagBuilder(ModItemTags.HARDENED_GLASS)
                .add(ModBlocks.HARDENED_GLASS.asItem())
                .add(ModBlocks.HARDENED_BLACK_GLASS.asItem())
                .add(ModBlocks.HARDENED_BLUE_GLASS.asItem())
                .add(ModBlocks.HARDENED_BROWN_GLASS.asItem())
                .add(ModBlocks.HARDENED_CYAN_GLASS.asItem())
                .add(ModBlocks.HARDENED_GRAY_GLASS.asItem())
                .add(ModBlocks.HARDENED_GREEN_GLASS.asItem())
                .add(ModBlocks.HARDENED_LIGHT_BLUE_GLASS.asItem())
                .add(ModBlocks.HARDENED_LIGHT_GRAY_GLASS.asItem())
                .add(ModBlocks.HARDENED_LIME_GLASS.asItem())
                .add(ModBlocks.HARDENED_MAGENTA_GLASS.asItem())
                .add(ModBlocks.HARDENED_ORANGE_GLASS.asItem())
                .add(ModBlocks.HARDENED_PINK_GLASS.asItem())
                .add(ModBlocks.HARDENED_PURPLE_GLASS.asItem())
                .add(ModBlocks.HARDENED_RED_GLASS.asItem())
                .add(ModBlocks.HARDENED_WHITE_GLASS.asItem())
                .add(ModBlocks.HARDENED_YELLOW_GLASS.asItem());

        getOrCreateTagBuilder(ModItemTags.GEARS)
                .add(ModItems.BRONZE_GEAR)
                .add(ModItems.GOLD_GEAR)
                .add(ModItems.COPPER_GEAR)
                .add(ModItems.IRON_GEAR)
                .add(ModItems.TIN_GEAR)
                .add(ModItems.TITANIUM_GEAR)
                .add(ModItems.TRIAFIUM_GEAR)
                .add(ModItems.PACSARIUM_GEAR)
                .add(ModItems.PRISMARINE_GEAR);

        getOrCreateTagBuilder(ModItemTags.CRUSHERS)
                .add(ModBlocks.CRUSHER.asItem())
                .add(ModBlocks.IRON_POWERED_CRUSHER.asItem());

        getOrCreateTagBuilder(ModItemTags.GLASS)
                .addTag(ModItemTags.HARDENED_GLASS)
                .add(Items.GLASS)
                .add(Items.BLACK_STAINED_GLASS)
                .add(Items.BLUE_STAINED_GLASS)
                .add(Items.BROWN_STAINED_GLASS)
                .add(Items.CYAN_STAINED_GLASS)
                .add(Items.GRAY_STAINED_GLASS)
                .add(Items.GREEN_STAINED_GLASS)
                .add(Items.LIGHT_BLUE_STAINED_GLASS)
                .add(Items.LIGHT_GRAY_STAINED_GLASS)
                .add(Items.LIME_STAINED_GLASS)
                .add(Items.MAGENTA_STAINED_GLASS)
                .add(Items.ORANGE_STAINED_GLASS)
                .add(Items.PINK_STAINED_GLASS)
                .add(Items.PURPLE_STAINED_GLASS)
                .add(Items.RED_STAINED_GLASS)
                .add(Items.WHITE_STAINED_GLASS)
                .add(Items.YELLOW_STAINED_GLASS);
        
        getOrCreateTagBuilder(ModItemTags.WRENCHES)
                .add(ModItems.WRENCH);

        getOrCreateTagBuilder(ModItemTags.EUCALYPTUS_LOGS)
                .add(ModBlocks.EUCALYPTUS_LOG.asItem())
                .add(ModBlocks.STRIPPED_EUCALYPTUS_LOG.asItem())
                .add(ModBlocks.EUCALYPTUS_WOOD.asItem())
                .add(ModBlocks.STRIPPED_EUCALYPTUS_WOOD.asItem());

        getOrCreateTagBuilder(ModItemTags.TRIAFIA_LOGS)
                .add(ModBlocks.TRIAFIA_LOG.asItem())
                .add(ModBlocks.STRIPPED_TRIAFIA_LOG.asItem())
                .add(ModBlocks.TRIAFIA_WOOD.asItem())
                .add(ModBlocks.STRIPPED_TRIAFIA_WOOD.asItem());

        getOrCreateTagBuilder(ModItemTags.PACSARIA_LOGS)
                .add(ModBlocks.PACSARIA_LOG.asItem())
                .add(ModBlocks.STRIPPED_PACSARIA_LOG.asItem())
                .add(ModBlocks.PACSARIA_WOOD.asItem())
                .add(ModBlocks.STRIPPED_PACSARIA_WOOD.asItem());
        getOrCreateTagBuilder(ModItemTags.NETHERITE_TOOLS_ARMOR)
                .add(Items.NETHERITE_HELMET)
                .add(Items.NETHERITE_CHESTPLATE)
                .add(Items.NETHERITE_LEGGINGS)
                .add(Items.NETHERITE_BOOTS)
                .add(Items.NETHERITE_SWORD)
                .add(Items.NETHERITE_PICKAXE)
                .add(Items.NETHERITE_AXE)
                .add(Items.NETHERITE_SHOVEL)
                .add(Items.NETHERITE_HOE);
    }
}
