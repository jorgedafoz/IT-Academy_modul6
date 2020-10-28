package com.vehicles.project;

import java.util.List;
import java.util.Scanner;

public class Bike extends Vehicle {
    //Fase 3
	public Bike(String plate, String brand, String color) {

	    super(plate, brand, color);
	}

    public static Bike createBike(Scanner user, List bikes) {
        //check if plate is properly defined
        System.out.println("Enter your bike registration number:");
        String bikePlate = Vehicle.plateDataController(user);
        System.out.println("Enter your bike brand: ");
        String bikeBrand = user.nextLine();
        System.out.println("Enter your bike color: ");
        String bikeColor = user.nextLine();

        Bike customerBike = new Bike(bikePlate, bikeBrand, bikeColor);
        bikes.add(customerBike);
        return customerBike;
    }

    public void addBikeWheels(Scanner user, Bike customerBike) {
	    //set brand
        System.out.println("Enter your  front wheel brand: ");
        String frontWheelBrand = user.nextLine();
        System.out.println("Enter your  back wheel brand: ");
        String backWheelBrand = user.nextLine();

        //set diameter checking correct size
        System.out.println("Enter your front wheel diameter: ");
        double frontWheelDiameter = Wheel.size(user);
        System.out.println("Enter your back wheel diameter: ");
        double backWheelDiameter = Wheel.size(user);

        //create wheels
        Wheel backWheel = new Wheel(backWheelBrand,backWheelDiameter);
        Wheel frontWheel = new Wheel(frontWheelBrand,frontWheelDiameter);

        this.wheels.add(frontWheel);
        this.wheels.add(backWheel);

        user.close();
    }
}
