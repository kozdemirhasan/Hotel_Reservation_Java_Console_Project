package model;

import java.util.Date;
import java.util.List;

public interface IRoom {
    public String getRoomNumber();
    public Double getRoomPrice();
    public RoomType getRoomType();
    public boolean isFree(Date checkInDate, Date checkOutDate);
    public List<Reservation> getReservations();
}
