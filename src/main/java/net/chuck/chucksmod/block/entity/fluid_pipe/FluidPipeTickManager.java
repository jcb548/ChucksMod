package net.chuck.chucksmod.block.entity.fluid_pipe;

import net.chuck.chucksmod.block.entity.OfferedEnergyStorage;
import net.chuck.chucksmod.block.entity.OfferedFluidStorage;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.Storage;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleVariantStorage;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.fluid.Fluids;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
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
public class FluidPipeTickManager {
    private static final List<AbstractFluidPipeBlockEntity> pipes = new ArrayList<>();
    private static final List<OfferedFluidStorage> extractionStorages = new ArrayList<>();
    private static final List<OfferedFluidStorage> targetStorages = new ArrayList<>();
    private static final Deque<AbstractFluidPipeBlockEntity> bfsQueue = new ArrayDeque<>();
    private static long tickCounter = 0;

    static {
        ServerTickEvents.START_SERVER_TICK.register(server -> tickCounter++);
    }
    public static void handleFluidPipeTick(AbstractFluidPipeBlockEntity start){
        if (!(start.getWorld() instanceof ServerWorld)) throw new IllegalStateException();
        try{
            gatherPipes(start);
            if(pipes.isEmpty()) return;
            // group all energy on the network
            long networkCapacity = 0;
            long networkAmount = 0;
            FluidVariant variant = FluidVariant.of(Fluids.EMPTY);
            for(AbstractFluidPipeBlockEntity pipe : pipes){
                // get variant in pipes
                if(variant == FluidVariant.of(Fluids.EMPTY) && !pipe.fluidStorage.variant.equals(FluidVariant.of(Fluids.EMPTY))){
                    variant = pipe.fluidStorage.variant;
                }
                //get capacity and amount in network
                networkCapacity += pipe.fluidStorage.getCapacity();
                networkAmount += pipe.fluidStorage.amount;
                // update pipe connections
                pipe.appendTargets(targetStorages, extractionStorages);
                // Block any I/O while we access the network amount directly to keep pipes and network in sync, to
                // avoid duping or voiding fluids
                pipe.ioBlocked = true;
            }
            if(networkAmount > networkCapacity){
                networkAmount = networkCapacity;
            }
            // Pull energy from storages.
            ExtractResult extractResult = extract(networkCapacity - networkAmount, start.getTransferRate());
            if(variant.equals(FluidVariant.of(Fluids.EMPTY))){
                variant = extractResult.variant;
            }
            networkAmount += extractResult.amount;
            if(start.getWorld().getPlayers().size()>0)start.getWorld().getPlayers().get(0).sendMessage(Text.literal(networkAmount + " " + networkCapacity + " "+extractResult.amount));
            //networkAmount += dispatchTransfer(Storage<FluidVariant>::extract, networkCapacity - networkAmount, start.getTransferRate());
            // Push energy into storages
            //networkAmount -= dispatchTransfer(Storage<FluidVariant>::insert, networkAmount, start.getTransferRate());
            // split energy evenly across pipes
            int pipeCount = pipes.size();
            for(AbstractFluidPipeBlockEntity pipe : pipes){
                pipe.fluidStorage.variant = variant;
                pipe.fluidStorage.amount = networkAmount/pipeCount;
                networkAmount -= pipe.fluidStorage.amount;
                pipeCount--;
                pipe.markDirty();
                pipe.ioBlocked = false;
            }
        } finally {
            pipes.clear();
            targetStorages.clear();
            extractionStorages.clear();
            bfsQueue.clear();
        }
    }

    private static void gatherPipes(AbstractFluidPipeBlockEntity start){
        if(!shouldTickCable(start)) return;
        bfsQueue.add(start);
        start.lastTick = tickCounter;
        pipes.add(start);
        while(!bfsQueue.isEmpty()){
            AbstractFluidPipeBlockEntity current = bfsQueue.removeFirst();
            for (Direction direction : Direction.values()){
                if(current.getAdjacentBlockEntity(direction) instanceof AbstractFluidPipeBlockEntity adjPipe){
                    if(shouldTickCable(adjPipe) && (adjPipe.fluidStorage.variant.equals(FluidVariant.of(Fluids.EMPTY))
                            || adjPipe.fluidStorage.variant.equals(current.fluidStorage.variant))){
                        bfsQueue.add(adjPipe);
                        adjPipe.lastTick = tickCounter;
                        pipes.add(adjPipe);
                    }
                }
            }
        }
    }

    private static boolean shouldTickCable(AbstractFluidPipeBlockEntity pipe) {
        // Only gather and tick each cable once per tick.
        if(pipe.lastTick == tickCounter) return false;
        // Ignore cables in non-ticking chunks
        return pipe.getWorld() instanceof ServerWorld serverWorld && serverWorld.isChunkLoaded(pipe.getPos());
    }
    private static ExtractResult extract(long maxAmount, long transferRate){
        long extractedAmount = 0;
        FluidVariant variant = FluidVariant.of(Fluids.EMPTY);
        for(OfferedFluidStorage storage : extractionStorages){
            if(storage.storage() instanceof SingleVariantStorage<FluidVariant> fluidStorage &&
                    !fluidStorage.variant.equals(FluidVariant.blank())) {
                try (Transaction tx = Transaction.openOuter()) {
                    if(maxAmount > transferRate) {
                        extractedAmount += fluidStorage.extract(fluidStorage.variant, transferRate, tx);
                    } else {
                        extractedAmount += fluidStorage.extract(fluidStorage.variant, maxAmount, tx);
                    }
                    if(variant.equals(FluidVariant.of(Fluids.EMPTY))) variant = fluidStorage.variant;
                    tx.commit();
                }
            }
        }
        return new ExtractResult(extractedAmount, variant);
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
        long transfer(Storage<FluidVariant> storage, long maxAmount, Transaction transaction);
    }
    private static class SortableStorage {
        private final OfferedFluidStorage storage;
        private final long simulationResult;

        SortableStorage(TransferOperation operation, OfferedFluidStorage storage) {
            this.storage = storage;
            try (Transaction tx = Transaction.openOuter()) {
                this.simulationResult = operation.transfer(storage.storage(), Long.MAX_VALUE, tx);
            }
        }
    }
    private record ExtractResult(long amount, FluidVariant variant){}
}
