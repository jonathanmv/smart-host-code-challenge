package occupancy;

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
        return null;
    }
}
