package menus;

import api.AdminResource;
import api.HotelResource;
import model.Customer;
import model.IRoom;
import service.CustomerService;
import service.ReservationService;

import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Set;

public class MainMenu {

    public static void mainMenu(){
        System.out.println("----MAIN MENU----");
        System.out.println("1.Find and reserve a room");
        System.out.println("2.See my reservations");
        System.out.println("3.Create and account");
        System.out.println("4.Admin");
        System.out.println("5.Exit");
        System.out.println("------------------");

        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();


        if(number.equalsIgnoreCase("1")){
            // Account check
            System.out.println("Do you have an acount?  Y/N");
            Scanner scanner1 = new Scanner(System.in);
            String accountResponse1 = scanner1.nextLine();
           switch(accountResponse1) {
               case "Y":
               case "y":
                   try{
                       // Creating Reservaiton=========
                       // Getting Customer
                       System.out.println("Please enter your email:");
                       Scanner scanner2 = new Scanner(System.in);
                       String email = scanner2.nextLine();
                       Customer customer = HotelResource.getCustomer(email);
                        if(customer != null){
                            // Entering checkin-out dates
                            System.out.println("Please enter checkin date: (in format 21-12-2021)");
                            Scanner scanner4 = new Scanner(System.in);
                            String checkInDate = scanner4.nextLine();

                            System.out.println("Please enter checkout date: (in format 21-12-2021)");
                            Scanner scanner5 = new Scanner(System.in);
                            String checkOutDate = scanner5.nextLine();

                            // Selecting a room
                            Set<IRoom> availableRooms = ReservationService.findRoom( new SimpleDateFormat("dd-MM-yyyy").parse(checkInDate),
                                    new SimpleDateFormat("dd-MM-yyyy").parse(checkOutDate));

                            if(availableRooms.size() > 0){
                                System.out.println("Please select a room number:");
                                for(IRoom room:availableRooms){
                                    System.out.println(room);
                                }
                                Scanner scanner3 = new Scanner(System.in);
                                String roomId = scanner3.nextLine();

                                // Creating Reservation
                                ReservationService.reserveARoom(
                                        CustomerService.allCustomers.get(email),
                                        AdminResource.allRooms.get(roomId),
                                        new SimpleDateFormat("dd-MM-yyyy").parse(checkInDate),
                                        new SimpleDateFormat("dd-MM-yyyy").parse(checkOutDate)
                                );

                            }else{
                                System.out.println("There is no available room for your reservation period!");
                                MainMenu.mainMenu();
                            }

                        }
                        else
                            System.out.println("The email is not regsitered!");

                   } catch (Exception e) {
                       e.printStackTrace();
                   }
                   break;
               case "N":
               case "n":
                   try {
                       System.out.println("Create an account please!  Y/N") ;
                       Scanner scanner6 = new Scanner(System.in);
                       String accountResponse2 = scanner6.nextLine();

                       switch (accountResponse2){
                           case "Y":
                               System.out.println("Please enter an email:  (in format jeffry@mysite.com)");
                               Scanner scanner7 = new Scanner(System.in);
                               String email = scanner7.nextLine();

                               System.out.println("Please enter your first name:");
                               Scanner scanner8 = new Scanner(System.in);
                               String firstName = scanner8.nextLine();

                               System.out.println("Please enter your last name:");
                               Scanner scanner9 = new Scanner(System.in);
                               String lastName = scanner9.nextLine();

                               CustomerService.addCustomer(email,firstName,lastName);
                               MainMenu.mainMenu();

                               break;
                           case "N":
                               MainMenu.mainMenu();
                               break;
                       }
                   }
                   catch (Exception e) {
                       e.printStackTrace();
                   }

           }
        }
        if(number.equalsIgnoreCase("2")){
            System.out.println("Please enter your email:");
            Scanner scanner1 = new Scanner(System.in);
            String email = scanner1.nextLine();
            HotelResource.getCustomerReservations(email);
        }
        if(number.equalsIgnoreCase("3")){
            // email
            System.out.println("enter a email please:");
            Scanner scanner1 = new Scanner(System.in);
            String email = scanner1.nextLine();

            // first name
            System.out.println("enter your first name please:");
            Scanner scanner2 = new Scanner(System.in);
            String firstName = scanner2.nextLine();

            // last name
            System.out.println("enter your last name please:");
            Scanner scanner3 = new Scanner(System.in);
            String lastName = scanner3.nextLine();

            CustomerService.addCustomer(email,firstName,lastName);
        }
        if(number.equalsIgnoreCase("4")){
            AdminMenu.adminMenu();
        }
        if(number.equalsIgnoreCase("5")){
            System.exit(0);
        }

        mainMenu();
    }

}

