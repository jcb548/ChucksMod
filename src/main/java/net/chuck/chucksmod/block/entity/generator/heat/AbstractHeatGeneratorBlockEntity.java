package net.chuck.chucksmod.block.entity.generator.heat;

import net.chuck.chucksmod.block.custom.generator.heat.IronHeatGeneratorBlock;
import net.chuck.chucksmod.block.entity.generator.AbstractGeneratorBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public abstract class AbstractHeatGeneratorBlockEntity extends AbstractGeneratorBlockEntity {
    public static final int FUEL_SLOT = 0;

    public static final int INV_SIZE = 1;
    public static final Map<Item, Integer> FUELS = AbstractFurnaceBlockEntity.createFuelTimeMap();
    public AbstractHeatGeneratorBlockEntity(BlockEntityType type, BlockPos pos, BlockState state,
                                            int generationSpeed, int energyStorageSize) {
        super(type, pos, state, INV_SIZE, generationSpeed, energyStorageSize);
        FUELS.remove(Items.LAVA_BUCKET);
    }
    protected int getFuelTime(ItemStack fuel) {
        if (fuel.isEmpty()) {
            return 0;
        }
        Item item = fuel.getItem();
        return (FUELS.getOrDefault(item, 0)/10);
    }

    @Override
    protected void useFuel() {
        if (this.getFuelTime(this.inventory.getStack(FUEL_SLOT)) > 0){
            this.fuelTime = this.getFuelTime(this.inventory.getStack(FUEL_SLOT));
            this.burnTime = this.getFuelTime(this.inventory.getStack(FUEL_SLOT));
            this.removeStack(FUEL_SLOT, 1);
        }
    }

    @Override
    public boolean canInsert(int slot, ItemStack stack, @Nullable Direction side) {
        Direction localDir = this.getWorld().getBlockState(this.pos).get(IronHeatGeneratorBlock.FACING);

        if(side == Direction.DOWN){
            return false;
        }
        // From top insert into 1
        if(side == Direction.UP){
            return slot == FUEL_SLOT;
        }
        // right insert into 1
        // From left insert into 0
        return switch (localDir) {
            default ->
                    side.getOpposite() == Direction.NORTH && slot == FUEL_SLOT|| //&& stack.getItem() == ModBlockTags.CRUSHABLE
                            side.getOpposite() == Direction.EAST && slot == FUEL_SLOT ||
                            side.getOpposite() == Direction.WEST && slot == FUEL_SLOT;
            case EAST ->
                    side.rotateYClockwise() == Direction.NORTH && slot == FUEL_SLOT ||
                            side.rotateYClockwise() == Direction.EAST && slot == FUEL_SLOT ||
                            side.rotateYClockwise() == Direction.WEST && slot == FUEL_SLOT;
            case SOUTH ->
                    side  == Direction.NORTH && slot == FUEL_SLOT ||
                            side == Direction.EAST && slot == FUEL_SLOT ||
                            side == Direction.WEST && slot == FUEL_SLOT;
            case WEST ->
                    side.rotateYCounterclockwise() == Direction.NORTH && slot == FUEL_SLOT ||
                            side.rotateYCounterclockwise() == Direction.EAST && slot == FUEL_SLOT ||
                            side.rotateYCounterclockwise() == Direction.WEST && slot == FUEL_SLOT;
        };
    }
}
