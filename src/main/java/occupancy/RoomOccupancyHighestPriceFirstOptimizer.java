package occupancy;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class RoomOccupancyHighestPriceFirstOptimizer implements IRoomOccupancyOptimizer {
    private double upperLimit;
    private double lowerLimit;
    private RoomType roomType;

    public RoomOccupancyHighestPriceFirstOptimizer(double upperLimit, double lowerLimit, RoomType roomType) {
        this.upperLimit = upperLimit;
        this.lowerLimit = lowerLimit;
        this.roomType = roomType;
    }

    public double getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(double upperLimit) {
        this.upperLimit = upperLimit;
    }

    public double getLowerLimit() {
        return lowerLimit;
    }

    public void setLowerLimit(double lowerLimit) {
        this.lowerLimit = lowerLimit;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    @Override
    public RoomsOccupationState optimizeRoomOccupation(RoomsOccupationState roomsOccupationState) {
        List<Double> potentialGuests = roomsOccupationState.getPotentialGuests();
        if (potentialGuests.size() < 1) {
            return roomsOccupationState;
        }
        potentialGuests.sort(Collections.reverseOrder());

        RoomAvailabilityState roomAvailability = roomsOccupationState.getRoomAvailabilityStateByType(roomType);
        int availability = roomAvailability.getAvailability();

        List<Double> deniedGuests = potentialGuests.stream()
                .filter(price -> upperLimit <= price || price <= lowerLimit)
                .collect(Collectors.toList());
        List<Double> availableGuests = potentialGuests.stream()
                .filter(price -> upperLimit > price && price > lowerLimit)
                .collect(Collectors.toList());

        int assignedGuests = roomAvailability.assignGuests(availableGuests);

        List<Double> unassignedGuests = availableGuests.stream()
                .skip(assignedGuests)
                .collect(Collectors.toList());

        List<Double> newPotentialGuests = Stream.concat(deniedGuests.stream(), unassignedGuests.stream())
                .collect(Collectors.toList());

        roomsOccupationState.setPotentialGuests(newPotentialGuests);
        return roomsOccupationState;
    }
}
