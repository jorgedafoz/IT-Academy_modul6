package com.vehicles.project.main;

import com.vehicles.project.Car;
import com.vehicles.project.Vehicle;
import com.vehicles.project.Wheel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainFase2 {

    public static void main(String[] arg)  {
        //FASE 2
        //create car
        Scanner user = new Scanner(System.in);
        //check if plate is properly setted
        System.out.println("Enter the cars registration number:");
        String plate = Vehicle.plateDataController(user);
        System.out.println("Enter the cars brand:");
        String brand = user.nextLine();
        System.out.println("Enter the cars color:");
        String color = user.nextLine();

        Car car = new Car(plate, brand, color);

        //set brand
        System.out.println("Enter the back wheel brand:");
        String backWheelBrand = user.nextLine();
        System.out.println("Enter the front wheel brand:");
        String frontWheelBrand = user.nextLine();

        //set diameter
        System.out.println("Enter the back wheel diameter:");
        double backWheelDiameter = Wheel.size(user);
        System.out.println("Enter the front wheel diameter:");
        double frontWheelDiameter = Wheel.size(user);

        ArrayList<Wheel> frontWheels = new ArrayList<Wheel>();
        ArrayList<Wheel> backWheels = new ArrayList<Wheel>();
        List<ArrayList<Wheel>> wheels = new ArrayList<>();

        //create wheels
        Wheel frontRightWheel = new Wheel(frontWheelBrand,frontWheelDiameter);
        Wheel frontLeftWheel = new Wheel(frontWheelBrand,frontWheelDiameter);
        Wheel backRightWheel = new Wheel(backWheelBrand,backWheelDiameter);
        Wheel backLeftWheel = new Wheel(backWheelBrand,backWheelDiameter);

        frontWheels.add(frontLeftWheel);
        frontWheels.add(frontRightWheel);
        backWheels.add(backLeftWheel);
        backWheels.add(backRightWheel);

        user.close();

        try {
            car.addWheels(frontWheels, backWheels);
        } catch (Exception e) {
            System.out.println("Error, wheels must be identical.");
            e.printStackTrace();
        }

        //print resume
        System.out.println("The car has " + car.getWheels().size() + " wheels.");
        for(Wheel w : car.getWheels()) {
            System.out.println("Brand: " + w.getBrand());
            System.out.println("Diameter: " + w.getDiameter());
        }

        System.out.println("The car was successfully created with the following attributes: \n" + car.toString());
    }
}

