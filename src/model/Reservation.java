package model;

import java.text.DateFormat;
import java.util.Date;

public class Reservation {
    public Customer customer;
    public IRoom room;
    public Date checkInDate;
    public Date checkOutDate;

   public Reservation(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {

        this.customer = customer;
        this.room = room;
        if(checkInDate.before(checkOutDate)){
            this.checkInDate = checkInDate;
            this.checkOutDate = checkOutDate;
        }
       else
           throw new IllegalArgumentException("Invalid time zone");
   }

    @Override
    public String toString() {
        return "Reservation{" +
                "customer=" + customer +
                ", room=" + room +
                ", checkInDate=" + DateFormat.getDateInstance().format(checkInDate) +
                ", checkOutDate=" + DateFormat.getDateInstance().format(checkOutDate) +
                '}';
    }
}
