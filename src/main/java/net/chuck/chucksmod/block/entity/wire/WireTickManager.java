package net.chuck.chucksmod.block.entity.wire;

import net.chuck.chucksmod.block.entity.OfferedEnergyStorage;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Direction;
import team.reborn.energy.api.EnergyStorage;

import java.util.*;

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
public class WireTickManager {
    private static final List<WireBlockEntity> wires = new ArrayList<>();
    private static final List<OfferedEnergyStorage> targetStorages = new ArrayList<>();
    private static final Deque<WireBlockEntity> bfsQueue = new ArrayDeque<>();
    private static long tickCounter = 0;

    static {
        ServerTickEvents.START_SERVER_TICK.register(server -> tickCounter++);
    }
    public static void handleWireTick(WireBlockEntity start){
        if (!(start.getWorld() instanceof ServerWorld)) throw new IllegalStateException();
        try{
            gatherWires(start);
            if(wires.isEmpty())return;
            // group all energy on the network
            long networkCapacity = 0;
            long networkAmount = 0;
            for(WireBlockEntity wire : wires){
                networkCapacity += wire.energyStorage.getCapacity();
                networkAmount += wire.energyStorage.amount;
                // update cable connections
                wire.appendTargets(targetStorages);
                // Block any I/O while we access the network amount directly to keep wires and network in sync, to
                // avoid duping or voiding energy
                wire.ioBlocked = true;
            }
            if( networkAmount > networkCapacity){
                networkAmount = networkCapacity;
            }
            // Pull energy from storages.
            networkAmount += dispatchTransfer(EnergyStorage::extract, networkCapacity - networkAmount, start.getTransferRate());
            // Push energy into storages
            networkAmount -= dispatchTransfer(EnergyStorage::insert, networkAmount, start.getTransferRate());
            // split energy evenly across wires
            int wireCount = wires.size();
            for(WireBlockEntity wire : wires){
                wire.energyStorage.amount = networkAmount/wireCount;
                networkAmount -= wire.energyStorage.amount;
                wireCount--;
                wire.markDirty();
                wire.ioBlocked = false;
            }
        } finally {
            wires.clear();
            targetStorages.clear();
            bfsQueue.clear();
        }
    }

    private static void gatherWires(WireBlockEntity start){
        if(!shouldTickCable(start)) return;
        bfsQueue.add(start);
        start.lastTick = tickCounter;
        wires.add(start);
        while(!bfsQueue.isEmpty()){
            WireBlockEntity current = bfsQueue.removeFirst();
            for (Direction direction : Direction.values()){
                if(current.getAdjacentBlockEntity(direction) instanceof WireBlockEntity adjCable){
                    if(shouldTickCable(adjCable)){
                        bfsQueue.add(adjCable);
                        adjCable.lastTick = tickCounter;
                        wires.add(adjCable);
                    }
                }
            }
        }
    }

    private static boolean shouldTickCable(WireBlockEntity wire) {
        // Only gather and tick each cable once per tick.
        if(wire.lastTick == tickCounter) return false;
        // Ignore cables in non-ticking chunks
        return wire.getWorld() instanceof ServerWorld serverWorld && serverWorld.isChunkLoaded(wire.getPos());
    }
    private static long dispatchTransfer(TransferOperation operation, long maxAmount, long transferRate){
        List<SortableStorage> sortedTargets = new ArrayList<>();
        for (var storage : targetStorages){
            sortedTargets.add(new SortableStorage(operation, storage));
        }
        // shuffle for better average transfer
        Collections.shuffle(sortedTargets);
        // sort by lowest simulation target
        sortedTargets.sort(Comparator.comparingLong(sortableStorage -> sortableStorage.simulationResult));
        // actually perform the transfer
        try (Transaction transaction = Transaction.openOuter()){
            long transferredAmount = 0;
            for(int i=0; i<sortedTargets.size();i++){
                SortableStorage target = sortedTargets.get(i);
                int remainingTargets = sortedTargets.size()-i;
                long remainingAmount = maxAmount - transferredAmount;
                // Limit max amount to the cable transfer rate.
                long targetMaxAmount = Math.min((remainingAmount/remainingTargets), transferRate);
                long localTransferred = operation.transfer(target.storage.storage(), targetMaxAmount, transaction);
                if(localTransferred > 0){
                    transferredAmount += localTransferred;
                    // Block duplicate transactions
                    target.storage.afterTransfer();
                }
            }
            transaction.commit();
            return transferredAmount;
        }
    }
    private interface TransferOperation{
        long transfer(EnergyStorage storage, long maxAmount, Transaction transaction);
    }
    private static class SortableStorage {
        private final OfferedEnergyStorage storage;
        private final long simulationResult;

        SortableStorage(TransferOperation operation, OfferedEnergyStorage storage) {
            this.storage = storage;
            try (Transaction tx = Transaction.openOuter()) {
                this.simulationResult = operation.transfer(storage.storage(), Long.MAX_VALUE, tx);
            }
        }
    }
}
