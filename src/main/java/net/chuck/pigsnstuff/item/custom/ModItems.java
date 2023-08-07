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

    public static final Item COPPER_SWORD = registerItem("copper_sword",
            new SwordItem(ToolMaterials.IRON, 6, -2.0f, new FabricItemSettings()));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(PigsNStuff.MOD_ID, name), item);
    }
    public static void registerModItems() {
        PigsNStuff.LOGGER.info("Registering Mod Items for " + PigsNStuff.MOD_ID);
    }
}
