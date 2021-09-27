package model;

import java.util.regex.Pattern;

public class Customer {
    private String firstName;
    private String lastName;
    private String email;

    private String eMailRegEx ="^(.+)@(.+)\\.com$";
    private Pattern pattern = Pattern.compile(eMailRegEx);

    public Customer(String firstName, String lastName, String email){
        if(!pattern.matcher(email).matches()){
            throw new IllegalArgumentException("Invalid email");
        }
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getEmail(){
        return this.email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
