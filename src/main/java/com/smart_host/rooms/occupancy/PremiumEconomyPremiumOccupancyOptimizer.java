package com.smart_host.rooms.occupancy;

import java.util.ArrayList;
import java.util.List;

/**
 * Assigns room occupation with the following rules
 * 1. Premium guests will be assigned to premium rooms using highest price sorting
 * 2. Economy guests will be assigned to economy rooms using highest price sorting
 * 3. Economy guests will be assigned to premium rooms only if all economy rooms have been assigned
 * and there are premium rooms available
 */
public class PremiumEconomyPremiumOccupancyOptimizer implements IRoomOccupancyOptimizer {
    List<IRoomOccupancyOptimizer> optimizers = new ArrayList<>();

    public PremiumEconomyPremiumOccupancyOptimizer() {
        optimizers.add(new RoomOccupancyHighestPriceFirstOptimizer(Double.MAX_VALUE, 100, RoomType.PREMIUM));
        optimizers.add(new RoomOccupancyHighestPriceFirstOptimizer(100, 0, RoomType.ECONOMY));
        optimizers.add(new RoomOccupancyHighestPriceFirstOptimizer(100, 0, RoomType.PREMIUM));
    }

    @Override
    public RoomsOccupationState optimizeRoomOccupation(RoomsOccupationState roomsOccupationState) {
        for (IRoomOccupancyOptimizer optimizer : optimizers) {
            roomsOccupationState = optimizer.optimizeRoomOccupation(roomsOccupationState);
        }
        return roomsOccupationState;
    }
}
