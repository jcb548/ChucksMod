package net.chuck.chucksmod.block.entity.quarry;

import net.chuck.chucksmod.util.ModNbt;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;

public abstract class AbstractBookSlotQuarryBlockEntity extends AbstractQuarryBlockEntity{
    protected SimpleInventory miningBookInventory;
    public AbstractBookSlotQuarryBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state,
                                             int invSize, int energyStorageSize, int maxProgress, int maxInsertExtract){
        super(type, pos, state, invSize, energyStorageSize, maxProgress, maxInsertExtract);
        miningBookInventory = new SimpleInventory(1);
    }
    public Inventory getMiningBookInventory(){
        return miningBookInventory;
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
    @Override
    public ItemStack getTool() {
        ItemStack tool = getBaseTool();
        ItemStack miningBook = miningBookInventory.getStack(0);
        if (!miningBook.isEmpty()) {
            EnchantmentHelper.set(EnchantmentHelper.get(miningBook), tool);
        }
        return tool;
    }
}
