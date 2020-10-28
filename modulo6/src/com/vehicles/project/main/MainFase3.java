package com.vehicles.project.main;

import com.vehicles.project.Bike;
import com.vehicles.project.Car;
import com.vehicles.project.Vehicle;
import com.vehicles.project.Wheel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainFase3 {
    public static void main(String[] arg) {
        //Fase 3

        List<Car> cars = new ArrayList<Car>();
        List<Bike> bikes = new ArrayList<Bike>();

        Scanner user = new Scanner(System.in);
        String bikeOrCar;
        do {
            System.out.println("Would you like to create a bike or a car?");
            bikeOrCar = user.nextLine();
        } while (!bikeOrCar.equalsIgnoreCase("bike") && !bikeOrCar.equalsIgnoreCase("car"));

        if ( bikeOrCar.equalsIgnoreCase("car")) {
            Car customerCar = Car.createCar(user, cars);
            Car.addCarWheels(user, customerCar);

            //print resume
            System.out.println("You have successfully created a car with the following atributes: " + customerCar.toString());
            System.out.println("\nThe car has " + customerCar.getWheels().size() + " wheels.");
            for(Wheel w : customerCar.getWheels()) {
                System.out.println("Brand: " + w.getBrand());
                System.out.println("Diameter: " + w.getDiameter());
            }
        } else if (bikeOrCar.equalsIgnoreCase("bike")){
            Bike customerBike = Bike.createBike(user, bikes);
            customerBike.addBikeWheels(user, customerBike);

            //print resume
            System.out.println("You have successfully created a car with the following atributes: " + customerBike.toString());
            System.out.println("The bike has " + customerBike.getWheels().size() + " wheels.");
            for(Wheel w : customerBike.getWheels()) {
                System.out.println("Brand: " + w.getBrand());
                System.out.println("Diameter: " + w.getDiameter());
            }
        }
    }
}
