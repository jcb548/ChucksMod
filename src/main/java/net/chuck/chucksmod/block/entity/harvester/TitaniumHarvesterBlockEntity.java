package net.chuck.chucksmod.block.entity.harvester;

import net.chuck.chucksmod.block.entity.ModBlockEntities;
import net.chuck.chucksmod.block.entity.tiers.TitaniumTier;
import net.chuck.chucksmod.item.ModItems;
import net.chuck.chucksmod.screen.furnace.PoweredFurnaceScreenHandler;
import net.chuck.chucksmod.screen.harvester.TitaniumHarvesterScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class TitaniumHarvesterBlockEntity extends AbstractHarvesterBlockEntity implements TitaniumTier {
    public TitaniumHarvesterBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.TITANIUM_HARVESTER, pos, state, HARVESTER_SEEDS_INV_SIZE, HARVESTER_CROPS_INV_SIZE,
                MACHINE_ENERGY_STORAGE, QUARRY_SPEED, MAX_INSERT_EXTRACT);
    }

    @Override
    protected int getEnergyUsage() {
        return MEDIUM_USAGE;
    }

    @Override
    protected int getSize() {
        return QUARRY_SIZE;
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("block.chucksmod.titanium_harvester");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        this.markDirty();
        sendEnergyPacket();
        return new TitaniumHarvesterScreenHandler(syncId, playerInventory, this, propertyDelegate);
    }

    @Override
    public ItemStack getTool() {
        ItemStack tool = new ItemStack(ModItems.TITANIUM_PICKAXE);
        /*ItemStack mining_book = inventory.getStack(MINING_BOOK_SLOT);
        if(!mining_book.isEmpty()){
            EnchantmentHelper.set(EnchantmentHelper.get(mining_book), tool);
        }*/
        return tool;
    }
}
