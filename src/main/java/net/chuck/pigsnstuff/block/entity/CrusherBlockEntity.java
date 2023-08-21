package net.chuck.pigsnstuff.block.entity;

import net.chuck.pigsnstuff.block.custom.CrusherBlock;
import net.chuck.pigsnstuff.recipe.CrusherRecipe;
import net.chuck.pigsnstuff.screen.CrusherScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

/*
Code adapted from Kaupenjoe modding tutorials
*/
public class CrusherBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(3, ItemStack.EMPTY);
    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 72;
    public CrusherBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.CRUSHER, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                switch (index){
                    case 0: return CrusherBlockEntity.this.progress;
                    case 1: return CrusherBlockEntity.this.maxProgress;
                    default: return 0;
                }
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0: CrusherBlockEntity.this.progress = value; break;
                    case 1: CrusherBlockEntity.this.maxProgress = value; break;
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
        return Text.literal("Crusher");
    }
    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new CrusherScreenHandler(syncId, playerInventory, this, propertyDelegate);
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
                            CrusherBlockEntity crusherBlockEntity) {
        if (world.isClient()){
            return;
        }
        if(hasRecipe(crusherBlockEntity)){
            crusherBlockEntity.progress++;
            markDirty(world, blockPos, blockState);
            if(crusherBlockEntity.progress >= crusherBlockEntity.maxProgress){
                craftItem(crusherBlockEntity);
            }
        } else {
            crusherBlockEntity.resetProgress();
            markDirty(world, blockPos, blockState);
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private static void craftItem(CrusherBlockEntity crusherBlockEntity) {
        SimpleInventory inventory = new SimpleInventory(crusherBlockEntity.size());
        for(int i = 0; i< crusherBlockEntity.size(); i++){
            inventory.setStack(1, crusherBlockEntity.getStack(1));
        }
        Optional<CrusherRecipe> recipe = crusherBlockEntity.getWorld().getRecipeManager()
                .getFirstMatch(CrusherRecipe.Type.INSTANCE, inventory, crusherBlockEntity.getWorld());

        if(hasRecipe(crusherBlockEntity)) {
            crusherBlockEntity.removeStack(1,1);
            crusherBlockEntity.setStack(2, new ItemStack(recipe.get().getOutputNoReg().getItem(),
                    crusherBlockEntity.getStack(2).getCount() + 1));
            crusherBlockEntity.resetProgress();
        }
    }

    private static boolean hasRecipe(CrusherBlockEntity crusherBlockEntity) {
        SimpleInventory inventory = new SimpleInventory(crusherBlockEntity.size());
        for(int i = 0; i< crusherBlockEntity.size(); i++){
            inventory.setStack(1, crusherBlockEntity.getStack(1));
        }
        //boolean hasRawItemInFirstSlot = crusherBlockEntity.getStack(1).getItem() == Items.BONE;
        Optional<CrusherRecipe> match = crusherBlockEntity.getWorld().getRecipeManager()
                .getFirstMatch(CrusherRecipe.Type.INSTANCE, inventory, crusherBlockEntity.getWorld());

        return match.isPresent() && canInsertAmountIntoOutputSlot(inventory) &&
                canInsertItemIntoOutputSlot(inventory, match.get().getOutputNoReg().getItem());
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleInventory inventory, Item output) {
        return inventory.getStack(2).getItem() == output || inventory.getStack(2).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleInventory inventory) {
        return inventory.getStack(2).getMaxCount() > inventory.getStack(2).getCount();
    }

    @Override
    public boolean canInsert(int slot, ItemStack stack, @Nullable Direction side) {
        Direction localDir = this.getWorld().getBlockState(this.pos).get(CrusherBlock.FACING);

        if(side == Direction.DOWN){
            return false;
        }
        // From top insert into 1
        if(side == Direction.UP){
            return slot == 1;
        }
        // right insert into 1
        // From left insert into 0
        return switch (localDir) {
            default ->
                side.getOpposite() == Direction.NORTH && slot == 1 || //&& stack.getItem() == ModBlockTags.CRUSHABLE
                        side.getOpposite() == Direction.EAST && slot == 1 ||
                        side.getOpposite() == Direction.WEST && slot == 0;
            case EAST ->
                side.rotateYClockwise() == Direction.NORTH && slot == 1 ||
                        side.rotateYClockwise() == Direction.EAST && slot == 1 ||
                        side.rotateYClockwise() == Direction.WEST && slot == 0;
            case SOUTH ->
                side  == Direction.NORTH && slot == 1 ||
                        side == Direction.EAST && slot == 1 ||
                        side == Direction.WEST && slot == 0;
            case WEST ->
                side.rotateYCounterclockwise() == Direction.NORTH && slot == 1 ||
                        side.rotateYCounterclockwise() == Direction.EAST && slot == 1 ||
                        side.rotateYCounterclockwise() == Direction.WEST && slot == 0;
        };
    }




    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction side) {
        Direction localDir = this.getWorld().getBlockState(this.pos).get(CrusherBlock.FACING);

        if(side == Direction.UP){
            return false;
        }

        // From Down extract from 2
        if(side == Direction.DOWN){
            return slot == 2;
        }
        // From bottom extract from 2
        // From right extract from 2
        return switch (localDir) {
            default ->
                    side.getOpposite() == Direction.NORTH && slot == 2 || //&& stack.getItem() == ModBlockTags.CRUSHABLE
                            side.getOpposite() == Direction.EAST && slot == 2;
            case EAST ->
                    side.rotateYClockwise() == Direction.NORTH && slot == 2 ||
                            side.rotateYClockwise() == Direction.EAST && slot == 2;
            case SOUTH ->
                    side  == Direction.NORTH && slot == 2 ||
                            side == Direction.EAST && slot == 2;
            case WEST ->
                    side.rotateYCounterclockwise() == Direction.NORTH && slot == 2 ||
                            side.rotateYCounterclockwise() == Direction.EAST && slot == 2;
        };
    }
}
