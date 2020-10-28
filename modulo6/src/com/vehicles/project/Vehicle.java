package com.vehicles.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Vehicle {

	protected String plate;
	protected String brand;
	protected String color;
	protected List<Wheel> wheels = new ArrayList<Wheel>();

	public Vehicle(String plate, String brand, String color, ArrayList wheels) {
		this.plate = plate;
		this.brand = brand;
		this.color = color;
		this.wheels = wheels;
	}
    public Vehicle(String plate, String brand, String color) {
        this.plate = plate;
        this.brand = brand;
        this.color = color;
    }

    public List<Wheel> getWheels() {
        return wheels;
    }

    public void setWheels(List<Wheel> wheels) {
        this.wheels = wheels;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Vehicle: \n" +
                "plate='" + plate + '\'' +
                ",\n brand='" + brand + '\'' +
                ",\n color='" + color + '\'';
    }
    //Fase 2 check if plate is properly defined
    public static String plateDataController(Scanner user) {

	    boolean correctData = false;
        String plate;
        do {
            plate = user.nextLine();
            plate = plate.toUpperCase();
            int plateLength = plate.length();

            if (plateLength < 6 || plateLength > 7) {
                System.out.println("License plate numbers must have 6 o 7 charachters. Please try again");
            }
            Matcher p = Pattern.compile("^[0-9]{4}[A-Z]{2,3}$").matcher(plate);
            if (p.find()) {
                System.out.println(plate + " is a valid plate number.");
                correctData = true;
            } else {
                System.out.println(plate + " is not an allowed plate number");
            }
        } while (!correctData);
        return plate;
    }
}
