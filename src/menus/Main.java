package menus;

import api.AdminResource;
import model.Customer;
import model.Room;
import model.RoomType;
import service.CustomerService;
import service.ReservationService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ParseException {

        AdminResource.allRooms.put("122",new Room("122",RoomType.SINGLE,100.0));
        AdminResource.allRooms.put("123",new Room("123",RoomType.DOUBLE,200.0));

        Customer customer = new Customer("hasan", "murat","kozdemirhasan@gmail.com");
        CustomerService.allCustomers.put(customer.getEmail(),customer);

        Date checkInDate= new SimpleDateFormat("dd-MM-yyyy").parse("10-10-2021");
        Date checkOutDate= new SimpleDateFormat("dd-MM-yyyy").parse("20-10-2021");
//        Reservation reservation = new Reservation(customer,AdminResource.allRooms.get("122"),
//                checkInDate,
//                checkOutDate
//                );
        ReservationService.reserveARoom(customer, AdminResource.allRooms.get("122"), checkInDate, checkOutDate);
//        ReservationService.allReservations.put("122"+" checkin date: "+ checkInDate +
//                " checkout date: " + checkOutDate,reservation);

        MainMenu.mainMenu();
    }
}
