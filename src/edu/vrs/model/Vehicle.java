package edu.vrs.model;// name of the package

import java.io.Serializable; // importing serializable

public class Vehicle implements Serializable {
    private int id; // variable for the vehicle's id
    private String make;// variable for the vehicle's make
    private String model;// variable for the vehicle's model
    private String topSpeed;// variable for the vehicle's topSpeed
    private String registrationNumber;// variable for the vehicle's registrationNumber
    private String dailyHireRate;// variable for the vehicle's dailyHireRate
    private String noOfDoors;// variable for the vehicle's noOfDoors
    private String fuelType;// variable for the vehicle's fuelType
    private String seatCapacity;// variable for the vehicle's seatCapacity
    private String loadCapacity;// variable for the vehicle's loadCapacity
    private Type type;// variable for the vehicle's type
    public enum Type {
        CAR, MINI_BUS, LORRY // enum used to determine type of vehicle
    }
    public Vehicle (String make, String model, String topSpeed, String registrationNumber, String dailyHireRate,
                   String fuelType, String noOfDoors,String seatCapacity, String loadCapacity, Type type) { // creating constructor
        this.make = make; // initializing
        this.model = model;// initializing
        this.topSpeed = topSpeed;// initializing
        this.registrationNumber = registrationNumber;// initializing
        this.dailyHireRate = dailyHireRate;// initializing
        this.noOfDoors = noOfDoors;// initializing
        this.fuelType = fuelType;// initializing
        this.seatCapacity = seatCapacity;// initializing
        this.loadCapacity = loadCapacity;// initializing
        this.type = type;// initializing

    }

    public String getMake() {
        return make;
    }// getter method that will return make

    public int getId() {
        return id;
    }// getter method that will return id

    public void setId(int id) {
        this.id = id;
    }// setter method that will return make

    public String getModel() {
        return model;
    }// getter method that will return model

    public String getTopSpeed() {
        return topSpeed;
    }// getter method that will return topSpeed

    public String getRegistrationNumber() {
        return registrationNumber;
    }// getter method that will return registrationNumber

    public String getDailyHireRate() {
        return dailyHireRate;// getter method that will return getDailyHireRate
    }

    public String getNoOfDoors() {// getter method that will return getNoOfDoors
        return noOfDoors;
    }

    public Type getType() {// getter method that will return type
        return type;
    }

    public String getFuelType() {
        return fuelType;
    }// getter  method that will return fuelType

    public String getSeatCapacity() {
        return seatCapacity;
    }// getter method that will return seatCapacity

    public String getLoadCapacity() {
        return loadCapacity;
    }// getter method that will return loadCapacity

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", topSpeed='" + topSpeed + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", dailyHireRate='" + dailyHireRate + '\'' +
                ", noOfDoors='" + noOfDoors + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", seatCapacity='" + seatCapacity + '\'' +
                ", loadCapacity='" + loadCapacity + '\'' +
                ", type=" + type +
                '}';
        //will give details of the vehicle
    }
}