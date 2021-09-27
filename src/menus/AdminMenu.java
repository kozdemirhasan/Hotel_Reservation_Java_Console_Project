package menus;

import api.AdminResource;
import service.CustomerService;

import java.util.Scanner;

public class AdminMenu {

    public static void adminMenu(){
        System.out.println("----ADMIN MENU----");
        System.out.println("1.See all Customers");
        System.out.println("2.See all rooms");
        System.out.println("3.See all reservations");
        System.out.println("4.Add a room");
        System.out.println("5.Back to main menu");
        System.out.println("------------------");
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();

        if(number.equalsIgnoreCase("1")){
            CustomerService.getAllCustomers();
        }
        if(number.equalsIgnoreCase("2")){
            AdminResource.getAllRooms();
        }
        if(number.equalsIgnoreCase("3")){
           AdminResource.displayAllReservations();
        }
        if(number.equalsIgnoreCase("4")){
            AdminResource.addRoom(AdminResource.allRooms);
        }
        if(number.equalsIgnoreCase("5")){
            MainMenu.mainMenu();
        }
    }

}

