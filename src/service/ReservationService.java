package service;

import api.AdminResource;
import model.Customer;
import model.IRoom;
import model.Reservation;
import model.Room;

import java.text.DateFormat;
import java.util.*;

public class ReservationService {

  public static Map<String, Reservation> allReservations = new HashMap<>();

    public static void addRoom(IRoom room){

    }

    public static IRoom getARoom(String roomId){
        AdminResource.allRooms.get(roomId);
        return  AdminResource.allRooms.get(roomId);
    }

    public static Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        // Creating reservation
        Reservation reservation = new Reservation(customer,getARoom(room.getRoomNumber()),
              checkInDate, checkOutDate);

        // Adding the resevervation to the List
        allReservations.put(room.getRoomNumber()+
                " checkin date: "+ DateFormat.getDateInstance().format(checkInDate) +
                " checkout date: " + DateFormat.getDateInstance().format(checkOutDate), reservation);
        System.out.println("Reservation created succesfully!");
        addReservationToTheRoom(room.getRoomNumber(),reservation);
        return reservation;
    }

    public static Set<IRoom> findRoom(Date checkInDate, Date checkOutDate){
       Set<IRoom> availableRooms = new HashSet<IRoom>();

       for(Map.Entry<String, IRoom> roomSet:AdminResource.allRooms.entrySet()){ // check all rooms
               IRoom room = roomSet.getValue();
               if(room.getReservations().size() > 0){
                   for(Reservation res:room.getReservations()){ // get romm's all reservations
                       if(checkInDate.before(res.checkInDate) && checkOutDate.before(res.checkInDate)){ //match reservations' dates of each rooms with given dates
//                           System.out.println(res.room);
                           availableRooms.add(res.room);
                       }
                       else if(checkInDate.after(res.checkOutDate) && checkOutDate.after(res.checkOutDate)){
//                           System.out.println(res.room);
                           availableRooms.add(res.room);
                       }
                   }
               }
               else if(room.getReservations().size() == 0){
//                   System.out.println(room);
                   availableRooms.add(room);
               }

          }
        return availableRooms;
    }

    public Collection<Reservation> getCustomersReservation(Customer customer){
        return null;
    }
    public static void printAllReservation(){

    }

    public static List<Reservation> addReservationToTheRoom(String roomId, Reservation reservation){
        Room room = (Room) AdminResource.allRooms.get(roomId);
       return room.addReservationToTheRoom(reservation);

    }

}
