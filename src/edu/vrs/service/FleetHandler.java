package edu.vrs.service; // package name

import edu.vrs.model.Vehicle;// importing class vehicle of package model
import edu.vrs.model.Customer;// importing class customer of package model
import edu.vrs.model.Fleet;// importing class fleet of package model
import edu.vrs.model.Loan;// importing class loan  of package model

import java.io.*; // importing all
import java.nio.file.Files;// importing files
import java.nio.file.Path;// importing path
import java.nio.file.Paths;// importing paths
import java.util.ArrayList;//importing arraylist
import java.util.List;// importing list

public class FleetHandler  {
    private static Fleet fleet = null; // creating object of class Fleet

    String fileName = "D:\\JavaHash\\src\\vehicle.dat"; // name of the file

    public void loadUsers() { // method to read the information
        Path path = Paths.get(fileName);
        if(Files.exists(path)) { // if file exists then
            try(ObjectInputStream lof = new ObjectInputStream(new FileInputStream(fileName))) {
                fleet = (Fleet) lof.readObject(); // reading from the file

            }catch(Exception e){
                System.out.println("oppss"); // if not then handling exception
            }
        }else{
            fleet = new Fleet(); // if file not exist then
        }
    }
    public void addUserInfo(Customer customer) {// creating a method
        int customerId = fleet.getNextCustomerId(); // storing customer's id
        customer.setCustomerId(customerId); // setting customer's id
        fleet.getCustomerMap().put(customerId,customer);// keeping in the map
        saveUser(); // calling saveUser function
    }

    public void removeCustomer(int id) {// creating a method
        fleet.getCustomerMap().remove(id); // removing the customer with the mentioned id
        saveUser();// calling saveUser function
    }

    public void saveUser() {// creating a method
        if(fleet != null) {
            try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){ // for writing to the file
                oos.writeObject(fleet);// writing the details inside fleet
                oos.flush(); // flushing the object
            }catch(Exception e){
                throw new RuntimeException(e); // otherwise throwing exception
            }
        }
    }
    public void loadVehicles() {// method to read the information
        Path path = Paths.get(fileName);
        if(Files.exists(path)) { // if file exists then
            try(ObjectInputStream lof = new ObjectInputStream(new FileInputStream(fileName))) { // for reading purpose
                fleet = (Fleet) lof.readObject();// reading from the file

            }catch(Exception e){
                System.out.println("oppss"); // printing if exception comes
            }
        }else{
            fleet = new Fleet();// if file not exist then
        }
    }
    public void addVehicleInfo(Vehicle vehicle) {// creating a method
        int vehicleId = fleet.getNextVehicleId();// storing vehicle's id
        vehicle.setId(vehicleId);// setting vehicle's id
        fleet.getVehicleMap().put(vehicleId, vehicle);// adding to the map
        saveVehicle();// calling save function
    }

    public void removeVehicle(int id) {// creating a method
        fleet.getVehicleMap().remove(id);// removing the vehicle with the mentioned id
        saveVehicle(); // calling save fucntion
    }

    public void saveVehicle() {// creating a method
        if(fleet != null) {
            try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){ // for writing purpose
                oos.writeObject(fleet); //writing the object to the file
                oos.flush(); // flushing
            }catch(Exception e){
                throw new RuntimeException(e); // incase for the exception
            }
        }
    }
    public void loadLoan() {// method to read the information
        Path path = Paths.get(fileName);
        if(Files.exists(path)) {// if file exists then
            try(ObjectInputStream lof = new ObjectInputStream(new FileInputStream(fileName))) { // for reading purpose
                fleet = (Fleet) lof.readObject();// reading from the file

            }catch(Exception e){
                System.out.println("oppss");// printing if exception comes
            }
        }else{
            fleet = new Fleet(); // if file dont exist then
        }
    }
    public void addLoanInfo(Loan loan) {// creating a method
        int loanId = fleet.getNextLoanId(); // getting loan id
        loan.setLoanId(loanId);// setting loan id
        fleet.getLoanMap().put(loanId, loan);// adding to the map
        saveLoan();// calling save function
    }

    public void removeLoan(int id) {// creating a method
        fleet.getLoanMap().remove(id); // removing the loan with the mentioned loan id
        saveLoan(); // calling save function
    }

    public void saveLoan() { // creating a method
        if(fleet != null) {
            try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){ // for writing purpose
                oos.writeObject(fleet); // writing to the file
                oos.flush(); //flushing
            }catch(Exception e){
                throw new RuntimeException(e); // throwing exception in case
            }
        }
    }

    public static List<Customer> getCustomers() {
        return new ArrayList<>(fleet.getCustomerMap().values());
    } // getter method that will give the value of the map

    public static List<Vehicle> getVehicles() {
        return new ArrayList<>(fleet.getVehicleMap().values());
    }// getter method that will give the value of the map

    public static List<Loan> getLoans() {
        return new ArrayList<>(fleet.getLoanMap().values());
    }// getter method that will give the value of the map

    public static Customer getCustomerById(int id) {
        return fleet.getCustomerMap().get(id);
    } // getter method that will give the id of the customer

    public static Vehicle getVehiclesId(int id) {
        return fleet.getVehicleMap().get(id);
    } // getter method that will give the id of the vehicle

}
