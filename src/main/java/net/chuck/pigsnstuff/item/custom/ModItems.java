package net.chuck.pigsnstuff.item.custom;

import net.chuck.pigsnstuff.PigsNStuff;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item CHEESEBURGER = registerItem("cheeseburger",
            new Item(new FabricItemSettings().food(ModFoodComponents.CHEESEBURGER)));

    //Prismarine Tools
    public static final Item PRISMARINE_SWORD = registerItem("prismarine_sword",
        new ModAquaSwordItem(ModToolMaterials.PRISMARINE, 3, -2.0f, new FabricItemSettings()));
    public static final Item PRISMARINE_PICKAXE = registerItem("prismarine_pickaxe",
            new ModAquaPickaxeItem(ModToolMaterials.PRISMARINE, 1, -2.4f, new FabricItemSettings()));
    public static final Item PRISMARINE_AXE = registerItem("prismarine_axe",
        new ModAquaAxeItem(ModToolMaterials.PRISMARINE, 6, -2.6f, new FabricItemSettings()));
    public static final Item PRISMARINE_SHOVEL = registerItem("prismarine_shovel",
            new ModAquaShovelItem(ModToolMaterials.PRISMARINE, 1, -3.6f, new FabricItemSettings()));
    public static final Item PRISMARINE_HOE = registerItem("prismarine_hoe",
            new ModAquaHoeItem(ModToolMaterials.PRISMARINE, -2, -0.4f, new FabricItemSettings()));
    // Tin
    public static final Item RAW_TIN = registerItem("raw_tin", new Item(new FabricItemSettings()));
    public static final Item TIN_INGOT = registerItem("tin_ingot", new Item(new FabricItemSettings()));
    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(PigsNStuff.MOD_ID, name), item);
    }
    public static void registerModItems() {
        PigsNStuff.LOGGER.info("Registering Mod Items for " + PigsNStuff.MOD_ID);
    }
}
