package net.chuck.chucksmod.screen.generator.steam;

import net.chuck.chucksmod.block.entity.AbstractEnergyCookerBlockEntity;
import net.chuck.chucksmod.block.entity.FluidStoring;
import net.chuck.chucksmod.screen.FluidDisplayingScreenHandler;
import net.chuck.chucksmod.screen.ModScreenHandlers;
import net.chuck.chucksmod.screen.generator.GeneratorScreenHandler;
import net.chuck.chucksmod.util.FluidStack;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;

public class SteamGeneratorScreenHandler extends GeneratorScreenHandler implements FluidDisplayingScreenHandler {
    public SteamGeneratorScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity entity,
                                       PropertyDelegate delegate) {
        super(syncId, playerInventory, entity, delegate, ModScreenHandlers.STEAM_GENERATOR_SCREEN_HANDLER);
        if(entity instanceof FluidStoring fluidStoring){
            this.fluidStoring = fluidStoring;
        }
        setFluidStack(new FluidStack(fluidStoring.getFluidStorage().variant, fluidStoring.getFluidStorage().amount));
    }
    public SteamGeneratorScreenHandler(int syncId, PlayerInventory playerInventory, PacketByteBuf buf){
        this(syncId, playerInventory, playerInventory.player.getWorld().getBlockEntity(buf.readBlockPos()),
                new ArrayPropertyDelegate(AbstractEnergyCookerBlockEntity.DELEGATE_SIZE));
    }
}
