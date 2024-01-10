package net.chuck.chucksmod.block.entity.tiers;

public interface IronTier {
    int WIRE_TRANSFER_RATE = 128;
    int MAX_INSERT_EXTRACT = 64;
    int LOW_USAGE = 8;
    int MEDIUM_USAGE = 16;
    int HIGH_USAGE = 32;
    int GENERATION = MAX_INSERT_EXTRACT;
    int GEN_MAX_EXTRACT = GENERATION;
    int MACHINE_ENERGY_STORAGE = 10000;
    int ENERGY_STORAGE = 5*MACHINE_ENERGY_STORAGE;
    int ENERGY_STORAGE_INSERT_EXTRACT = 2*MAX_INSERT_EXTRACT;
    int SPEED = 175;
    int QUARRY_INV_SIZE = 8;
    int QUARRY_SIZE = 7;
    int QUARRY_SPEED = SPEED / 10;
    int FLUID_TANK_BUCKETS = 8;
    int PUMP_SIZE = 2*QUARRY_SIZE-1;
    int PUMP_SPEED = SPEED/15;
    int MACHINE_BUCKET_STORAGE = 2;
}
