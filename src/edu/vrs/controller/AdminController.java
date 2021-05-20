package edu.vrs.controller; // name of the package

import edu.vrs.model.Loan; //importing class loan inside model package
import edu.vrs.model.Vehicle;//importing class vehicle inside model package
import edu.vrs.model.Customer;//importing class customer inside model package
import edu.vrs.service.FleetHandler;//importing class fleethandler inside service package

public class AdminController{
    FleetHandler fleetHandler = new FleetHandler(); // making aa object of fleethandler

    public void addCustomer(Customer customer){ // creating a method
        fleetHandler.addUserInfo(customer); // calling function of class fleethandler
        System.out.println("added! "); // print statement
    }

    public void removeCustomer(int customerId){ // creating a method
        fleetHandler.removeCustomer(customerId);// calling function of class fleethandler
    }
    public void addVehicle(Vehicle vehicle){ // creating a method
        fleetHandler.addVehicleInfo(vehicle);// calling function of class fleethandler
        System.out.println("added! ");// print statement
    }

    public void removeVehicle(int vehicleId){ // creating a method
        fleetHandler.removeVehicle(vehicleId);// calling function of class fleethandler
    }
    public void addLoan(Loan loan){ // creating a method
        fleetHandler.addLoanInfo(loan);// calling function of class fleethandler
        System.out.println("added! ");// print statement
    }

    public void removeLoan(int loanId){ // creating a method
        fleetHandler.removeLoan(loanId);// calling function of class fleethandler
    }

}


