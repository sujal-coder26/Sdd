package edu.vrs.model;// package name

import java.io.*;//importing all
import java.util.HashMap; // importing hashmap
import java.util.Map;// importing map

public class Fleet implements Serializable {
    private  Map<Integer, Customer> customer; //creating a customer map
    private  Map<Integer, Vehicle> vehicle;// creating a vehicle map
    private  Map<Integer, Loan> loan;// creating a loan map
    private  int currentVehicleId = 1;// creating a variable
    private  int currentCustomerId = 1;// creating a variable
    private  int currentLoanId = 1;//creating a variable

    public Fleet() { // constructor
        this.customer = new HashMap<>(); // initializing
         vehicle = new HashMap<>();// initializing
        loan = new HashMap<>();//initializing
    }

    public int getNextVehicleId() { // getter that will increase the current value by 1
        return currentVehicleId++;
    } // increases the value by 1

    public int getNextLoanId() {// getter that will increase the current value by 1
        return currentLoanId++;
    }// increases the value by 1
    public int getNextCustomerId() {// getter that will increase the current value by 1
        return currentCustomerId++;
    } // increases the value by 1

    public Map<Integer, Customer> getCustomerMap() { //getter methods
        return customer;
    }// this method returns the customer map

    public void setCustomer(Map<Integer, Customer> customer) {//setter methods
        this.customer = customer;
    }// setter for the map

    public Map<Integer, Vehicle> getVehicleMap() {//getter methods
        return vehicle;
    }//  this method returns the vehicle map

    public void setVehicle(Map<Integer, Vehicle> vehicle) {// setter method
        this.vehicle = vehicle;
    }// this setter sets the vehicle map

    public Map<Integer, Loan> getLoanMap() {
        return loan;
    }// this method returns the loan map

    public void setLoan(Map<Integer, Loan> loan) {
        this.loan = loan;
    } // this method sets the loan map
}




