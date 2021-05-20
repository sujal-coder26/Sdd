package edu.vrs.model;// name of package

import java.io.Serializable; //importing serializable

public class Customer implements Serializable {
    private int customerId; // variable of customer id
    private String nameOfCorporation; // variable for customer's name of corporation
    private String address; // variable for customer's address
    private String phoneNumber;// variable for customer's phonenumber
    private String emailAddress; // variable for customer's email
    private String userName;// variable for customer's username
    private String password; // variable for customer's password

    public Customer(String nameOfCorporation, String address,String phoneNumber, String emailAddress, String userName, String password){ // creating constructor
        this.nameOfCorporation = nameOfCorporation; //initializing the value
        this.address = address; //initializing the value
        this.phoneNumber = phoneNumber;//initializing the value
        this.emailAddress = emailAddress;//initializing the value
        this.userName = userName;//initializing the value
        this.password = password;//initializing the value
    }

    public String getAddress() {
        return address;
    } //getter method

    public int getCustomerId() {
        return customerId;//getter method
    }

    public String getEmailAddress() {
        return emailAddress;
    }//getter method

    public String getNameOfCorporation() {
        return nameOfCorporation;
    }//getter method

    public String getPassword() {
        return password;
    }//getter method

    public String getPhoneNumber() {
        return phoneNumber;
    }//getter method

    public String getUserName() {
        return userName;
    }//getter method

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }//setter method

    @Override
    public String toString() { //overriding toString method
        return "edu.vrs.model.Customer{" +
                "customerId='" + customerId + '\'' +
                ", nameOfCorporation='" + nameOfCorporation + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';

        // printing all details
    }
}

