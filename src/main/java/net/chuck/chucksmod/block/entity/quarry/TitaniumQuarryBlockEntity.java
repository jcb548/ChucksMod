package net.chuck.chucksmod.block.entity.quarry;

import net.chuck.chucksmod.block.entity.ModBlockEntities;
import net.chuck.chucksmod.block.entity.tiers.IronTier;
import net.chuck.chucksmod.block.entity.tiers.TitaniumTier;
import net.chuck.chucksmod.item.ModItems;
import net.chuck.chucksmod.screen.quarry.IronQuarryScreenHandler;
import net.chuck.chucksmod.screen.quarry.TitaniumQuarryScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class TitaniumQuarryBlockEntity extends AbstractQuarryBlockEntity implements TitaniumTier {
    public static final int MINING_BOOK_SLOT = 16;
    public TitaniumQuarryBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.TITANIUM_QUARRY, pos, state, QUARRY_INV_SIZE, MACHINE_ENERGY_STORAGE,
                QUARRY_SPEED, MAX_INSERT_EXTRACT);
    }

    @Override
    protected int getEnergyUsage() {
        return HIGH_USAGE;
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("block.chucksmod.titanium_quarry");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        this.markDirty();
        return new TitaniumQuarryScreenHandler(syncId, playerInventory,this, propertyDelegate,
                this.energyStorage.amount);
    }

    @Override
    protected int getQuarrySize() {
        return QUARRY_SIZE;
    }

    @Override
    public ItemStack getTool() {
        ItemStack tool = new ItemStack(ModItems.TITANIUM_PICKAXE);
        ItemStack mining_book = inventory.getStack(MINING_BOOK_SLOT);
        if(!mining_book.isEmpty()){
            EnchantmentHelper.set(EnchantmentHelper.get(mining_book), tool);
        }
        return tool;
    }
}
