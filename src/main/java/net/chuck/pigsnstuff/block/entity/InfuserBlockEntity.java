package net.chuck.pigsnstuff.block.entity;

import net.chuck.pigsnstuff.item.ModItems;
import net.chuck.pigsnstuff.screen.InfusingScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

/*
Code adapted from Kaupenjoe modding tutorials
*/
public class InfuserBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(3, ItemStack.EMPTY);
    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 72;
    private int fuelTime = 0;
    private int maxFuelTime = 0;
    public InfuserBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.INFUSER, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                switch (index){
                    case 0: return InfuserBlockEntity.this.progress;
                    case 1: return InfuserBlockEntity.this.maxProgress;
                    default: return 0;
                }
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0: InfuserBlockEntity.this.progress = value; break;
                    case 1: InfuserBlockEntity.this.maxProgress = value; break;
                }
            }

            @Override
            public int size() {
                return 2;
            }
        };
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.inventory;
    }

    @Override
    public Text getDisplayName() {
        return Text.literal("Infuser");
    }
    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new InfusingScreenHandler(syncId, playerInventory, this, propertyDelegate);
    }
    // For saving nbt on world close
    @Override
    protected void writeNbt(NbtCompound nbt) {
        Inventories.writeNbt(nbt, inventory);
        super.writeNbt(nbt);
        nbt.putInt("infuser.progress", progress);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
        nbt.getInt("infuser.progress");
    }

    public static void tick(World world, BlockPos blockPos, BlockState blockState,
                            InfuserBlockEntity infuserBlockEntity) {
        if (world.isClient()){
            return;
        }
        if(hasRecipe(infuserBlockEntity)){
            infuserBlockEntity.progress++;
            markDirty(world, blockPos, blockState);
            if(infuserBlockEntity.progress >= infuserBlockEntity.maxProgress){
                craftItem(infuserBlockEntity);
            }
        } else {
            infuserBlockEntity.resetProgress();
            markDirty(world, blockPos, blockState);
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private static void craftItem(InfuserBlockEntity infuserBlockEntity) {
        SimpleInventory inventory = new SimpleInventory(infuserBlockEntity.size());
        for(int i=0; i< infuserBlockEntity.size(); i++){
            inventory.setStack(1, infuserBlockEntity.getStack(1));
        }
        if(hasRecipe(infuserBlockEntity)) {
            infuserBlockEntity.removeStack(1,1);
            infuserBlockEntity.setStack(2, new ItemStack(ModItems.WITHER_BONE,
                    infuserBlockEntity.getStack(2).getCount() + 1));
            infuserBlockEntity.resetProgress();
        }
    }

    private static boolean hasRecipe(InfuserBlockEntity infuserBlockEntity) {
        SimpleInventory inventory = new SimpleInventory(infuserBlockEntity.size());
        for(int i=0; i< infuserBlockEntity.size(); i++){
            inventory.setStack(1, infuserBlockEntity.getStack(1));
        }
        boolean hasRawItemInFirstSlot = infuserBlockEntity.getStack(1).getItem() == Items.BONE;

        return hasRawItemInFirstSlot && canInsertAmountIntoOutputSlot(inventory) &&
                canInsertItemIntoOutputSlot(inventory, ModItems.WITHER_BONE);
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleInventory inventory, Item output) {
        return inventory.getStack(2).getItem() == output || inventory.getStack(2).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleInventory inventory) {
        return inventory.getStack(2).getMaxCount() > inventory.getStack(2).getCount();
    }
}
