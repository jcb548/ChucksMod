package net.chuck.chucksmod.block.entity.quarry;

import net.chuck.chucksmod.block.entity.ModBlockEntities;
import net.chuck.chucksmod.block.entity.tiers.IronTier;
import net.chuck.chucksmod.screen.quarry.IronQuarryScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class IronQuarryBlockEntity extends AbstractQuarryBlockEntity implements IronTier {
    public IronQuarryBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.IRON_QUARRY, pos, state, QUARRY_INV_SIZE, MACHINE_ENERGY_STORAGE,
                QUARRY_SPEED, HIGH_USAGE);
    }

    @Override
    protected int getEnergyUsage() {
        return HIGH_USAGE;
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("block.chucksmod.iron_quarry");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        this.markDirty();
        return new IronQuarryScreenHandler(syncId, playerInventory,this, propertyDelegate,
                this.energyStorage.amount);
    }

    @Override
    protected int getQuarrySize() {
        return QUARRY_SIZE;
    }

    @Override
    public ItemStack getTool() {
        return new ItemStack(Items.IRON_PICKAXE);
    }
}
