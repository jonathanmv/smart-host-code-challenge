package occupancy;

public class RoomTypeRevenue {
    private RoomType roomType;
    private double revenue;

    public RoomTypeRevenue(RoomType roomType, double revenue) {
        this.roomType = roomType;
        this.revenue = revenue;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }
}
