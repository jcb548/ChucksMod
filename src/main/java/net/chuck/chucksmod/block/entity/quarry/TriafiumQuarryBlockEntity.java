package net.chuck.chucksmod.block.entity.quarry;

import net.chuck.chucksmod.block.entity.ModBlockEntities;
import net.chuck.chucksmod.block.entity.tiers.TriafiumTier;
import net.chuck.chucksmod.item.ModItems;
import net.chuck.chucksmod.screen.quarry.TriafiumQuarryScreenHandler;
import net.chuck.chucksmod.util.ModNbt;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class TriafiumQuarryBlockEntity extends AbstractQuarryBlockEntity implements TriafiumTier {
    protected SimpleInventory miningBookInventory;
    public static final int MINING_BOOK_SLOT = 25;
    public TriafiumQuarryBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.TRIAFIUM_QUARRY, pos, state, QUARRY_INV_SIZE, MACHINE_ENERGY_STORAGE,
                QUARRY_SPEED, MAX_INSERT_EXTRACT);
        miningBookInventory = new SimpleInventory(1);
    }
    public Inventory getMiningBookInventory(){
        return miningBookInventory;
    }
    @Override
    protected int getEnergyUsage() {
        return HIGH_USAGE;
    }
    @Override
    public Text getDisplayName() {
        return Text.translatable("block.chucksmod.triafium_quarry");
    }
    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        this.markDirty();
        sendEnergyPacket();
        return new TriafiumQuarryScreenHandler(syncId, playerInventory,this, propertyDelegate);
    }

    @Override
    protected int getSize() {
        return QUARRY_SIZE;
    }

    @Override
    public ItemStack getTool() {
        ItemStack tool = new ItemStack(ModItems.TRIAFIUM_PICKAXE);
        ItemStack miningBook = miningBookInventory.getStack(0);
        if(!miningBook.isEmpty()){
            EnchantmentHelper.set(EnchantmentHelper.get(miningBook), tool);
        }
        return tool;
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        ModNbt.readNbt(nbt, "Mining_Book", miningBookInventory.stacks);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        ModNbt.writeNbt(nbt, "Mining_Book", miningBookInventory.stacks);
    }
}
