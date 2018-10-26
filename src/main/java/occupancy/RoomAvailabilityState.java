package occupancy;

import java.util.Arrays;

/**
 * It represents the current status of a hotel room. It has the room type, the number of available beds, and the price
 * paid in for the occupied beds.
 */
public class RoomAvailabilityState {
    private RoomType roomType;

    private int availability;

    private double[] occupancy;

    public RoomAvailabilityState(RoomType roomType, int availability, double[] occupancy) {
        this.roomType = roomType;
        this.availability = availability;
        this.occupancy = occupancy;
    }

    public RoomAvailabilityState(RoomType roomType, int availability) {
        this(roomType, availability, new double[availability]);
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public double[] getOccupancy() {
        return occupancy;
    }

    public void setOccupancy(double[] occupancy) {
        this.occupancy = occupancy;
    }

    public double getRevenue() {
        return Arrays.stream(occupancy).reduce((x, y) -> x + y).getAsDouble();
    }
}
