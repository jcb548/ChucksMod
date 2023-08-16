package net.chuck.pigsnstuff.data;

import net.chuck.pigsnstuff.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK,
                new Identifier("fabric", "needs_tool_level_4")))
                .add(ModBlocks.DIRITONIUM_ORE)
                .add(ModBlocks.DIRITONIUM_BLOCK)
                .add(ModBlocks.RAW_DIRITONIUM_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.FABIUM_BLOCK)
                .add(ModBlocks.RAW_FABIUM_BLOCK)
                .add(ModBlocks.FABIUM_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.INFUSER)
                .add(ModBlocks.SLATED_DIRT)
                .add(ModBlocks.SLATED_GRASS);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.TIN_BLOCK)
                .add(ModBlocks.TIN_ORE)
                .add(ModBlocks.DEEPSLATE_TIN_ORE);

        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK,
                new Identifier("pigsnstuff", "base_end_stone")))
                .add(Blocks.END_STONE);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.FABIUM_ORE)
                .add(ModBlocks.RAW_FABIUM_BLOCK)
                .add(ModBlocks.FABIUM_BLOCK)

                .add(ModBlocks.TIN_BLOCK)
                .add(ModBlocks.TIN_ORE)
                .add(ModBlocks.DEEPSLATE_TIN_ORE)

                .add(ModBlocks.DIRITONIUM_BLOCK)
                .add(ModBlocks.RAW_DIRITONIUM_BLOCK)
                .add(ModBlocks.DIRITONIUM_ORE)

                .add(ModBlocks.INFUSER);

        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
                .add(ModBlocks.SLATED_GRASS)
                .add(ModBlocks.SLATED_DIRT);

        getOrCreateTagBuilder(BlockTags.PLANKS)
                .add(ModBlocks.EUCALYPTUS_PLANKS);
        getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS)
                .add(ModBlocks.EUCALYPTUS_BUTTON);
        getOrCreateTagBuilder(BlockTags.WOODEN_DOORS)
                .add(ModBlocks.EUCALYPTUS_DOOR);
        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.EUCALYPTUS_FENCE);
        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS)
                .add(ModBlocks.EUCALYPTUS_SLAB);
        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS)
                .add(ModBlocks.EUCALYPTUS_STAIRS);
        getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.EUCALYPTUS_PRESSURE_PLATE);
        getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS)
                .add(ModBlocks.EUCALYPTUS_TRAPDOOR);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.EUCALYPTUS_FENCE_GATE);

        getOrCreateTagBuilder(BlockTags.DIRT)
                .add(ModBlocks.SLATED_DIRT)
                .add(ModBlocks.SLATED_GRASS);

        getOrCreateTagBuilder(BlockTags.DRAGON_IMMUNE)
                .add(ModBlocks.DIRITONIUM_BLOCK)
                .add(ModBlocks.DIRITONIUM_ORE)
                .add(ModBlocks.RAW_DIRITONIUM_BLOCK);

        getOrCreateTagBuilder(BlockTags.LOGS)
                .add(ModBlocks.EUCALYPTUS_LOG)
                .add(ModBlocks.EUCALYPTUS_WOOD)
                .add(ModBlocks.STRIPPED_EUCALYPTUS_LOG)
                .add(ModBlocks.STRIPPED_EUCALYPTUS_WOOD);
    }
}
