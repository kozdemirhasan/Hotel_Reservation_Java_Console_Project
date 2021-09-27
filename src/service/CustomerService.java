package service;

import menus.AdminMenu;
import model.Customer;

import java.util.HashMap;
import java.util.Map;

public class CustomerService {
    public static Map<String, Customer> allCustomers = new HashMap<>();

    public static void addCustomer(String email,String firstName, String lastName){
     try{
         if(!allCustomers.containsKey(email)){
             Customer customer = new Customer(firstName, lastName, email);
             allCustomers.put(email,customer);
             System.out.println("Account Created Successfully");
         }
         else {
             System.out.println("This email is already registered!");
         }
     }
     catch (Exception e) {
         e.printStackTrace();
     }
    }

    public static Customer getCustomer(String customerEmail){
        System.out.println(CustomerService.allCustomers.get("email"));
        return CustomerService.allCustomers.get("email");
    }

    public static void getAllCustomers(){
        if(CustomerService.allCustomers.size()==0) {
            System.out.println("No Account Added Yet!");
            AdminMenu.adminMenu();
        } else{
            for(Map.Entry<String, Customer> rm:CustomerService.allCustomers.entrySet()){
                System.out.println(rm);
            }
            //AdminMenu.adminMenu();
        }
    }
}
