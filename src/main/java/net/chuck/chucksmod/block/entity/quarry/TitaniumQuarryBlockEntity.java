package net.chuck.chucksmod.block.entity.quarry;

import net.chuck.chucksmod.block.entity.ModBlockEntities;
import net.chuck.chucksmod.block.entity.tiers.IronTier;
import net.chuck.chucksmod.block.entity.tiers.TitaniumTier;
import net.chuck.chucksmod.item.ModItems;
import net.chuck.chucksmod.screen.quarry.IronQuarryScreenHandler;
import net.chuck.chucksmod.screen.quarry.TitaniumQuarryScreenHandler;
import net.chuck.chucksmod.util.ModNbt;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class TitaniumQuarryBlockEntity extends AbstractBookSlotQuarryBlockEntity implements TitaniumTier {
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
        sendEnergyPacket();
        return new TitaniumQuarryScreenHandler(syncId, playerInventory,this, propertyDelegate);
    }

    @Override
    protected int getSize() {
        return QUARRY_SIZE;
    }

    @Override
    public ItemStack getBaseTool() {
        return new ItemStack(ModItems.TITANIUM_PICKAXE);
    }
}
