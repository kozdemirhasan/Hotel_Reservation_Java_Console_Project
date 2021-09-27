package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

public class Room implements IRoom {
    String roomNumber;
    double price;
    RoomType roomType;
    boolean isFree;
    List<Reservation> reservations = new ArrayList<>();

    String regexRoomNumber = "\\d{3}";
    Pattern pattern = Pattern.compile(regexRoomNumber);

    public Room(String roomNumber, RoomType roomType, double price){
        if(!pattern.matcher(roomNumber).matches()){
            throw new IllegalArgumentException("Invalid room number");
        }

        this.roomNumber = roomNumber;
        this.price = price;
        this.roomType = roomType;
    }

    public List<Reservation> addReservationToTheRoom(Reservation reservation){
        this.reservations.add(reservation);
        return this.reservations;
    }


    @Override
    public Double getRoomPrice() {
        return this.price;
    }

    @Override
    public RoomType getRoomType() {
        return this.roomType;
    }

    @Override
    public String getRoomNumber() {
        return this.roomNumber;
    }

    @Override
    public boolean isFree(Date checkInDate, Date checkOutDate) {
        return true;
    }

    @Override
    public List<Reservation> getReservations(){
        return this.reservations;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber='" + roomNumber + '\'' +
                ", price=" + price +
                ", roomType=" + roomType +
                '}';
    }
}
