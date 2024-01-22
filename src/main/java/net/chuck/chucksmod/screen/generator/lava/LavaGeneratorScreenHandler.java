package net.chuck.chucksmod.screen.generator.lava;

import net.chuck.chucksmod.block.entity.AbstractEnergyCookerBlockEntity;
import net.chuck.chucksmod.block.entity.FluidStoring;
import net.chuck.chucksmod.block.entity.generator.lava.AbstractLavaGeneratorBlockEntity;
import net.chuck.chucksmod.screen.FluidStoringScreenHandler;
import net.chuck.chucksmod.screen.ModScreenHandlers;
import net.chuck.chucksmod.screen.generator.GeneratorScreenHandler;
import net.chuck.chucksmod.util.FluidStack;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;

public class LavaGeneratorScreenHandler extends GeneratorScreenHandler implements FluidStoringScreenHandler {
    public FluidStack fluidStack;
    public AbstractLavaGeneratorBlockEntity lavaGenerator;
    public LavaGeneratorScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity entity,
                                      PropertyDelegate delegate) {
        super(syncId, playerInventory, entity, delegate, ModScreenHandlers.LAVA_GENERATOR_SCREEN_HANDLER, 0);
        if(entity instanceof AbstractLavaGeneratorBlockEntity lavaGenerator){
            this.lavaGenerator = lavaGenerator;
        }
        setFluidStack(new FluidStack(lavaGenerator.getFluidStorage().variant, lavaGenerator.getFluidStorage().amount));
    }
    public LavaGeneratorScreenHandler(int syncId, PlayerInventory playerInventory, PacketByteBuf buf){
        this(syncId, playerInventory, playerInventory.player.getWorld().getBlockEntity(buf.readBlockPos()),
                new ArrayPropertyDelegate(AbstractEnergyCookerBlockEntity.DELEGATE_SIZE));
    }

    @Override
    public FluidStoring getFluidStoring() {
        return lavaGenerator;
    }

    @Override
    public void setFluidStack(FluidStack fluidStack) {
        this.fluidStack = fluidStack;
    }

    @Override
    public boolean isBurning() {
        return lavaGenerator.isGenerating();
    }
}
