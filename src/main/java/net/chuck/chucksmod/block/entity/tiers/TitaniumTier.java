package net.chuck.chucksmod.block.entity.tiers;

public interface TitaniumTier {
    int WIRE_TRANSFER_RATE = 512;
    int MAX_INSERT_EXTRACT = 256;
    int LOW_USAGE = 32;
    int MEDIUM_USAGE = 64;
    int HIGH_USAGE = 128;
    int GENERATION = MAX_INSERT_EXTRACT;
    int GEN_MAX_EXTRACT = GENERATION;
    int MACHINE_ENERGY_STORAGE = 40000;
    int ENERGY_STORAGE = 5*MACHINE_ENERGY_STORAGE;
    int ENERGY_STORAGE_INSERT_EXTRACT = 2*MAX_INSERT_EXTRACT;
    int SPEED = 150;
    int QUARRY_INV_SIZE = 17;
    int QUARRY_SIZE = 9;
    int QUARRY_SPEED = SPEED / 10;
    int FLUID_TANK_BUCKETS = 16;
    int XP_BUCKETS = 4;
    int XP_DRAIN_RATE = 100;
}
