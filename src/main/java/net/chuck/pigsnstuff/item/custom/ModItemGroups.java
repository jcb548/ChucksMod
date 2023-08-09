package net.chuck.pigsnstuff.item.custom;

import net.chuck.pigsnstuff.PigsNStuff;
import net.chuck.pigsnstuff.block.ModBlocks;
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

                        entries.add(ModBlocks.EUCALYPTUS_LOG);
                        entries.add(ModBlocks.EUCALYPTUS_WOOD);
                        entries.add(ModBlocks.STRIPPED_EUCALYPTUS_LOG);
                        entries.add(ModBlocks.STRIPPED_EUCALYPTUS_WOOD);
                        entries.add(ModBlocks.EUCALYPTUS_PLANKS);
                        entries.add(ModBlocks.EUCALYPTUS_LEAVES);
                        entries.add(ModBlocks.EUCALYPTUS_SAPLING);
                    }).build());
    public static void registerItemGroups() {
        PigsNStuff.LOGGER.info("Registering Item Groups for " + PigsNStuff.MOD_ID);
    }
}
