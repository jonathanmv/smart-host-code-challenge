package occupancy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomOccupancyHighestPriceFirstOptimizerTest {

    @Test
    void optimizeRoomOccupation() {
        RoomAvailabilityState economyRooms = new RoomAvailabilityState(RoomType.ECONOMY, 2);
        RoomAvailabilityState[] availableRooms = { economyRooms };
        double[] potentialGuests = { 40.0, 120.0, 60.0 };
        RoomsOccupationState roomsOccupationState = new RoomsOccupationState(availableRooms, potentialGuests);

        RoomOccupancyHighestPriceFirstOptimizer optimizer = new RoomOccupancyHighestPriceFirstOptimizer(100, 0, RoomType.ECONOMY);

        RoomsOccupationState actual = optimizer.optimizeRoomOccupation(roomsOccupationState);
        assertNotNull(actual);
        assertEquals(1, actual.getRoomTypeRevenue().length);
        RoomTypeRevenue roomTypeRevenue = actual.getRoomTypeRevenue()[0];
        assertEquals(100, roomTypeRevenue.getRevenue());
    }
}