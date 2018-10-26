package occupancy;

public class RoomsOccupationState {
    private RoomAvailabilityState[] availableRooms;
    private double[] potentialGuests;

    public RoomsOccupationState(RoomAvailabilityState[] availableRooms, double[] potentialGuests) {
        this.availableRooms = availableRooms;
        this.potentialGuests = potentialGuests;
    }

    public RoomAvailabilityState[] getAvailableRooms() {
        return availableRooms;
    }

    public void setAvailableRooms(RoomAvailabilityState[] availableRooms) {
        this.availableRooms = availableRooms;
    }

    public double[] getPotentialGuests() {
        return potentialGuests;
    }

    public void setPotentialGuests(double[] potentialGuests) {
        this.potentialGuests = potentialGuests;
    }

    public RoomTypeRevenue[] getRoomTypeRevenue() {
        RoomTypeRevenue[] roomTypeRevenues = new RoomTypeRevenue[availableRooms.length];
        for (int i = 0; i < availableRooms.length; i++) {
            RoomAvailabilityState availableRoom = availableRooms[i];
            roomTypeRevenues[i] = new RoomTypeRevenue(availableRoom.getRoomType(), availableRoom.getRevenue());
        }

        return roomTypeRevenues;
    }
}
