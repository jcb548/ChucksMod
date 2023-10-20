package net.chuck.chucksmod.item.custom.bag;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public abstract class AbstractBagItem extends Item{
    public AbstractBagItem(Settings settings) {
        super(settings.maxCount(1));
    }

    @Override
    public boolean canBeNested() {
        return false;
    }
}
