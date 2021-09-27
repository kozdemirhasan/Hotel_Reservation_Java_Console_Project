package model;

public class FreeRoom extends Room{


    public FreeRoom(String roomNumber, RoomType roomType, double price) {
        super(roomNumber, roomType, price);
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber='" + roomNumber + '\'' +
                ", price=" + 0 +
                ", roomType=" + roomType +
                '}';
    }
}
