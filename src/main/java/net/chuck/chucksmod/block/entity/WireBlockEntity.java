package net.chuck.chucksmod.block.entity;

import net.chuck.chucksmod.block.custom.WireBlock;
import net.fabricmc.fabric.api.lookup.v1.block.BlockApiCache;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import team.reborn.energy.api.EnergyStorage;
import team.reborn.energy.api.base.SimpleEnergyStorage;
import team.reborn.energy.api.base.SimpleSidedEnergyContainer;

import java.util.ArrayList;
import java.util.List;

/*
 * This file is part of TechReborn, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2020 TechReborn
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

public class WireBlockEntity extends BlockEntity {
    public final SimpleEnergyStorage energyStorage = new SimpleEnergyStorage(4*TRANSFER_RATE,
            TRANSFER_RATE, TRANSFER_RATE) {

    };
    public long lastTick = 0;
    public int blockedSides = 0;
    public boolean ioBlocked = false;
    // null means that it needs to be re-queried
    public List<WireTarget> targets = null;
    public static final long TRANSFER_RATE = 128;
    /**
     * Adjacent caches, used to quickly query adjacent cable block entities.
     */
    @SuppressWarnings("unchecked")
    private final BlockApiCache<EnergyStorage, Direction>[] adjacentCaches = new BlockApiCache[6];
    public WireBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.WIRE, pos, state);
    }
    private boolean allowTransfer(Direction side){
        return !ioBlocked && (blockedSides & (1 << side.ordinal())) == 0;
    }

    public EnergyStorage getEnergyStorage(){
        return energyStorage;
    }
    public long getEnergy() {
        return energyStorage.amount;
    }

    public void setEnergy(long energy) {
        energyStorage.amount = energy;
    }

    private BlockApiCache<EnergyStorage, Direction> getAdjacentCache(Direction direction) {
        if (adjacentCaches[direction.getId()] == null) {
            adjacentCaches[direction.getId()] = BlockApiCache.create(EnergyStorage.SIDED, (ServerWorld) world, pos.offset(direction));
        }
        return adjacentCaches[direction.getId()];
    }
    @Nullable
    BlockEntity getAdjacentBlockEntity(Direction direction) {
        return getAdjacentCache(direction).getBlockEntity();
    }
    public void appendTargets(List<OfferedEnergyStorage> targetStorages){
        ServerWorld serverWorld = (ServerWorld) world;
        if(serverWorld == null){
            return;
        }
        // update targets
        if(targets == null){
            BlockState newBlockState = getCachedState();
            targets = new ArrayList<>();
            for (Direction direction: Direction.values()){
                boolean foundSomething = false;
                BlockApiCache<EnergyStorage, Direction> adjCache = getAdjacentCache(direction);
                if(adjCache.getBlockEntity() instanceof WireBlockEntity adjWire){
                    foundSomething = true;
                } else if(adjCache.find(direction.getOpposite()) != null){
                    foundSomething = true;
                    targets.add(new WireTarget(direction, adjCache));
                }
                newBlockState = newBlockState.with(WireBlock.PROPERTY_MAP.get(direction), foundSomething);
            }
            serverWorld.setBlockState(getPos(), newBlockState);
        }
        // fill the list
        for(WireTarget target: targets){
            EnergyStorage storage = target.find();
            if(storage == null){
                //Schedule a rebuild next tick
                targets = null;
            } else {
                targetStorages.add(new OfferedEnergyStorage(this, target.directionTo, storage));
            }
        }
        // reset blocked sides
        blockedSides = 0;
    }

    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return createNbt();
    }

    @Override
    public BlockEntityUpdateS2CPacket toUpdatePacket() {
        NbtCompound nbtTag = new NbtCompound();
        writeNbt(nbtTag);
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        if (nbt.contains("energy")){
            energyStorage.amount = nbt.getLong("energy");
        }
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.putLong("energy", energyStorage.amount);
    }

    public void neighbourUpdate(){
        targets=null;
    }

    public void tick(World world, BlockPos pos, BlockState state){
        if(world == null || world.isClient){
            return;
        }
        WireTickManager.handleWireTick(this);
    }
    private record WireTarget(Direction directionTo, BlockApiCache<EnergyStorage, Direction> cache){
        @Nullable
        EnergyStorage find(){
            return cache.find(directionTo.getOpposite());
        }
    }
}
