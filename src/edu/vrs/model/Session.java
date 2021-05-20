package edu.vrs.model;

public class Session {
    static Customer currentUser; // object of class customer

    public static Customer getCurrentUser() {
        return currentUser;
    } // getting current logged in user inside getter method

    public static void setCurrentUser(Customer currentUser) {
        Session.currentUser = currentUser;
    }
    // setting current logged in through this setter method
}

