package edu.vrs;

import edu.vrs.service.FleetHandler;
import edu.vrs.view.LoginView;

public class Run {
    public static void main(String[] args) {
        FleetHandler fleetHandler = new FleetHandler();
        fleetHandler.loadUsers();
        fleetHandler.loadVehicles();
        fleetHandler.loadLoan();
        LoginView adminLogin = new LoginView();
    }
}
