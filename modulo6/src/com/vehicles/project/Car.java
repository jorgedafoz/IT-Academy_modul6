package com.vehicles.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Car extends Vehicle {

    private static String plate;

    public Car(String plate, String brand, String color) {

        super(plate, brand, color);
    }
    //Fase 1
	public void addWheels(List<Wheel> frontWheels, List<Wheel> backWheels) throws Exception {
		addTwoWheels(frontWheels);
		addTwoWheels(backWheels);
	}

    public void addTwoWheels(List<Wheel> wheels)  {

        boolean correctNumber = false;
		while(!correctNumber) {
            if (wheels.size() != 2){
                System.out.println("Incorrect number of wheels, please try again.");
            } else {
                correctNumber = true;
            }
        }
		Wheel rightWheel = wheels.get(0);
		Wheel leftWheel = wheels.get(1);

		boolean equalWheels = false;
		while(!equalWheels) {
            if (!(rightWheel.equals(leftWheel))) {
                System.out.println("Wheels must be equal, please try again.");
            } else {
                equalWheels = true;
            }
        }
		this.wheels.add(leftWheel);
		this.wheels.add(rightWheel);
	}
    public static Car createCar(Scanner user, List cars) {
        //check if plate is properly defined
        System.out.println("Enter your car registration number:");
        String carPlate = Vehicle.plateDataController(user);
        System.out.println("Enter your car brand: ");
        String carBrand = user.nextLine();
        System.out.println("Enter your car color: ");
        String carColor = user.nextLine();

        Car customerCar = new Car(carPlate, carBrand, carColor);

        cars.add(customerCar);
        return customerCar;
    }
    //FASE 3
    public static void addCarWheels (Scanner user, Car customerCar) {
        //Crete car wheels
        //set brand
        System.out.println("Enter the back wheel brand:");
        String backWheelBrand = user.nextLine();
        System.out.println("Enter the front wheel brand:");
        String frontWheelBrand = user.nextLine();

        //ser diameter
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
            customerCar.addWheels(frontWheels, backWheels);
        } catch (Exception e) {
            System.out.println("Error, wheels must be identical.");
            e.printStackTrace();
        }
    }
}
