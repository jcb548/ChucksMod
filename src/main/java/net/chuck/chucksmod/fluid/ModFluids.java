package net.chuck.chucksmod.fluid;

import net.chuck.chucksmod.ChucksMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModFluids {
    public static FlowableFluid STILL_LIQUID_XP;
    public static FlowableFluid FLOWING_LIQUID_XP;
    public static Block LIQUID_XP_BLOCK;
    public static Item LIQUID_XP_BUCKET;

    public static void register(){
        STILL_LIQUID_XP = Registry.register(Registries.FLUID,
                new Identifier(ChucksMod.MOD_ID, "liquid_xp"), new LiquidXp.Still());
        FLOWING_LIQUID_XP = Registry.register(Registries.FLUID,
                new Identifier(ChucksMod.MOD_ID, "flowing_liquid_xp"), new LiquidXp.Flowing());
        LIQUID_XP_BLOCK = Registry.register(Registries.BLOCK, new Identifier(ChucksMod.MOD_ID, "liquid_xp_block"),
                new FluidBlock(ModFluids.STILL_LIQUID_XP, FabricBlockSettings.copyOf(Blocks.WATER)){ });
        LIQUID_XP_BUCKET = Registry.register(Registries.ITEM, new Identifier(ChucksMod.MOD_ID, "liquid_xp_bucket"),
                new BucketItem(ModFluids.STILL_LIQUID_XP, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1)));
    }
}
