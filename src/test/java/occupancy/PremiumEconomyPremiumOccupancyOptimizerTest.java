package occupancy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PremiumEconomyPremiumOccupancyOptimizerTest {
    List<Double> potentialGuests = Arrays.asList(23.0, 45.0, 155.0, 374.0, 22.0, 99.0, 100.0, 101.0, 115.0, 209.0);

    PremiumEconomyPremiumOccupancyOptimizer target = new PremiumEconomyPremiumOccupancyOptimizer();

    void runTest(int premiumRoomsAvailability, int economyRoomsAvailability, double expectedPremiumRevenue, double expectedEconomyRevenue) {
        RoomAvailabilityState premiumRooms = new RoomAvailabilityState(RoomType.PREMIUM, premiumRoomsAvailability);
        RoomAvailabilityState economyRooms = new RoomAvailabilityState(RoomType.ECONOMY, economyRoomsAvailability);
        List<RoomAvailabilityState> availableRooms = Arrays.asList(premiumRooms, economyRooms);

        RoomsOccupationState roomsOccupationState = new RoomsOccupationState(availableRooms, potentialGuests);

        RoomsOccupationState actual = target.optimizeRoomOccupation(roomsOccupationState);

        double actualEconomyRoomRevenue = actual.getRevenueByRoomType(RoomType.ECONOMY);
        assertEquals(expectedEconomyRevenue, actualEconomyRoomRevenue);
        double actualPremiumRoomRevenue = actual.getRevenueByRoomType(RoomType.PREMIUM);
        assertEquals(expectedPremiumRevenue, actualPremiumRoomRevenue);
    }

    /**
     * Test 1
     * Free Premium rooms: 3 Free Economy rooms: 3
     * Usage Premium: 3 (EUR 738) Usage Economy: 3 (EUR 167)
      */
    @Test
    void optimizeRoomOccupationTestOne() {
        runTest(3, 3, 738, 167);
    }
}