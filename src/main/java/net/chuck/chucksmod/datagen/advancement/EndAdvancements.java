package net.chuck.chucksmod.datagen.advancement;

import net.chuck.chucksmod.ChucksMod;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.ChangedDimensionCriterion;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import java.util.function.Consumer;

public class EndAdvancements {
    public static void generateAdvancements(Consumer<AdvancementEntry> consumer){
        AdvancementEntry root = Advancement.Builder.create()
                .display(Items.END_STONE, // The display icon
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".end.root.title"),
                        Text.translatable("advancements." + ChucksMod.MOD_ID + ".end.root.desc"), // The description
                        new Identifier("minecraft", "textures/block/end_stone.png"), // Background image used
                        AdvancementFrame.TASK, true, true, false
                )
                .criterion("enter_end", ChangedDimensionCriterion.Conditions.to(World.END))
                .build(consumer, ChucksMod.MOD_ID + "/end/root");
    }
}
