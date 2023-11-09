package net.chuck.chucksmod.block.entity.generator;
import net.chuck.chucksmod.block.entity.ModBlockEntities;
import net.chuck.chucksmod.block.entity.tiers.IronTier;
import net.chuck.chucksmod.screen.generator.IronHeatGeneratorScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class IronHeatGeneratorBlockEntity extends AbstractHeatGeneratorBlockEntity implements IronTier {
    public IronHeatGeneratorBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.IRON_HEAT_GENERATOR, pos, state, GENERATION, MACHINE_ENERGY_STORAGE);
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("block.chucksmod.iron_heat_generator");
    }
    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        this.markDirty();
        return new IronHeatGeneratorScreenHandler(syncId, playerInventory, this, propertyDelegate);
    }
    @Override
    public int getGeneration() {
        return GENERATION;
    }

    @Override
    public int getMaxExtract() {
        return GEN_MAX_EXTRACT;
    }

    @Override
    public int getEnergyStorageCapacity() {
        return MACHINE_ENERGY_STORAGE;
    }
}
