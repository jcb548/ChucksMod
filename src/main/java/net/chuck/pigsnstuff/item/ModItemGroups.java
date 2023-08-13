package net.chuck.pigsnstuff.item;

import net.chuck.pigsnstuff.PigsNStuff;
import net.chuck.pigsnstuff.block.ModBlocks;
import net.chuck.pigsnstuff.item.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup PIGS_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(PigsNStuff.MOD_ID, "pigsnstuff"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.pigsnstuff"))
                .icon(() -> new ItemStack(Items.PORKCHOP)).entries((displayContext, entries) -> {
                        entries.add(ModItems.CHEESEBURGER);

                        entries.add(ModItems.PRISMARINE_SWORD);
                        entries.add(ModItems.PRISMARINE_PICKAXE);
                        entries.add(ModItems.PRISMARINE_AXE);
                        entries.add(ModItems.PRISMARINE_SHOVEL);
                        entries.add(ModItems.PRISMARINE_HOE);

                        entries.add(ModItems.RAW_TIN);
                        entries.add(ModItems.TIN_INGOT);
                        entries.add(ModBlocks.TIN_BLOCK);
                        entries.add(ModBlocks.TIN_ORE);
                        entries.add(ModBlocks.DEEPSLATE_TIN_ORE);

                        entries.add(ModItems.RAW_FABIUM);
                        entries.add(ModItems.FABIUM_INGOT);
                        entries.add(ModBlocks.RAW_FABIUM_BLOCK);
                        entries.add(ModBlocks.FABIUM_BLOCK);
                        entries.add(ModBlocks.FABIUM_ORE);
                        entries.add(ModItems.FABIUM_SWORD);
                        entries.add(ModItems.FABIUM_PICKAXE);
                        entries.add(ModItems.FABIUM_AXE);
                        entries.add(ModItems.FABIUM_SHOVEL);
                        entries.add(ModItems.FABIUM_HOE);

                        entries.add(ModItems.RAW_DIRITONIUM);
                        entries.add(ModItems.DIRITONIUM_INGOT);
                        entries.add(ModBlocks.RAW_DIRITONIUM_BLOCK);
                        entries.add(ModBlocks.DIRITONIUM_BLOCK);
                        entries.add(ModBlocks.DIRITONIUM_ORE);
                        entries.add(ModItems.DIRITONIUM_SWORD);
                        entries.add(ModItems.DIRITONIUM_PICKAXE);
                        entries.add(ModItems.DIRITONIUM_AXE);
                        entries.add(ModItems.DIRITONIUM_SHOVEL);
                        entries.add(ModItems.DIRITONIUM_HOE);

                        entries.add(ModItems.WITHER_BONE);
                        entries.add(ModItems.WITHER_SWORD);
                        entries.add(ModItems.WITHER_PICKAXE);
                        entries.add(ModItems.WITHER_AXE);
                        entries.add(ModItems.WITHER_SHOVEL);
                        entries.add(ModItems.WITHER_HOE);;

                        entries.add(ModBlocks.EUCALYPTUS_LOG);
                        entries.add(ModBlocks.EUCALYPTUS_WOOD);
                        entries.add(ModBlocks.STRIPPED_EUCALYPTUS_LOG);
                        entries.add(ModBlocks.STRIPPED_EUCALYPTUS_WOOD);
                        entries.add(ModBlocks.EUCALYPTUS_PLANKS);
                        entries.add(ModBlocks.EUCALYPTUS_LEAVES);
                        entries.add(ModBlocks.EUCALYPTUS_SAPLING);

                        entries.add(ModBlocks.INFUSER);

                        entries.add(ModBlocks.SLATED_DIRT);
                        entries.add(ModBlocks.SLATED_GRASS);
                    }).build());
    public static void registerItemGroups() {
        PigsNStuff.LOGGER.info("Registering Item Groups for " + PigsNStuff.MOD_ID);
    }
}