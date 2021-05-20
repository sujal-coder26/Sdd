package edu.vrs.model;//package name

import java.io.Serializable; //importing serializable

public class Loan implements Serializable {
    private int loanId; // variable
    private Customer customer; // object of class customer
    private Vehicle vehicle;// object of class vehicle

    public Loan (int loanId, Customer user, Vehicle vehicle){
        this.loanId = loanId; //initializing
        this.customer = user;//initializing
        this.vehicle = vehicle;//initializing
    }

    public int getLoanId() {// getter methods
        return loanId;
    }

    public void setCustomer(Customer customer) {//setter methods
        this.customer = customer;
    }

    public void setLoanId(int loanId) { //setter methods
        this.loanId = loanId;
    }

    public void setVehicle(Vehicle vehicle) {//setter methods
        this.vehicle = vehicle;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }//getter methods

    public Customer getUser() {
        return customer;
    }// getter methods
}
