package net.chuck.chucksmod.block.entity.tiers;

public interface IronTier {
    int MAX_INSERT_EXTRACT = 64;
    int USAGE = 32;
    int GENERATION = MAX_INSERT_EXTRACT;
    int GEN_MAX_EXTRACT = GENERATION;
    int MACHINE_ENERGY_STORAGE = 10000;
    int ENERGY_STORAGE = 5*MACHINE_ENERGY_STORAGE;
    int ENERGY_STORAGE_INSERT_EXTRACT = 2*MAX_INSERT_EXTRACT;
    int SPEED = 175;
}
