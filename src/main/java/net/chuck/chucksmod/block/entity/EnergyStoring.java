package net.chuck.chucksmod.block.entity;

import net.minecraft.server.network.ServerPlayerEntity;
import team.reborn.energy.api.EnergyStorage;

public interface EnergyStoring {
    EnergyStorage getEnergyStorage();
    void sendEnergyPacket(ServerPlayerEntity player);
    void setEnergyLevel(long energyLevel);
}
