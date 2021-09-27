package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.util.*;


public class HotelResource {
    public static Customer getCustomer(String email){
        Customer customer = CustomerService.allCustomers.get(email);
        if(customer!= null){
            return customer;
        }
        else
            return null;
    }

    public static void createACustomer(String email, String firstName, String lastName){
        CustomerService.addCustomer(email,firstName,lastName);
    }
    public static Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate){
        return null;
    }

    public static Collection<Reservation> getCustomerReservations(String customerEmail){
        List<Reservation> customerReservations = new ArrayList<>();
        for(Map.Entry<String, Reservation> reservation:ReservationService.allReservations.entrySet()) {
           if(reservation.getValue().customer.getEmail().equals(customerEmail)){
               customerReservations.add(reservation.getValue());
               System.out.println(reservation);
           }
       }
        return customerReservations;
    }

    public static Collection<IRoom> findARoom(Date chechIn, Date checkOut){

        return null;
    }
}
