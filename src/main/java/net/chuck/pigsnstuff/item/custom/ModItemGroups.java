package net.chuck.pigsnstuff.item.custom;

import net.chuck.pigsnstuff.PigsNStuff;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ItemGroup.Entries;
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

                        entries.add(ModItems.COPPER_SWORD);
                    }).build());
    public static void registerItemGroups() {
        PigsNStuff.LOGGER.info("Registering Item Groups for " + PigsNStuff.MOD_ID);
    }
}
