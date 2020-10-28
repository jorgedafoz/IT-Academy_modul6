package com.vehicles.project;

import java.util.Objects;
import java.util.Scanner;

public class Wheel {
	private String brand;
	private double diameter;

	public Wheel(String brand, double diameter) {
		this.brand = brand;
		this.diameter = diameter;
	}

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    @Override
    public String toString() {
        return "Wheel: " +
                "brand='" + brand + '\'' +
                ", diameter=" + diameter +
                '}';
    }
    //Fase 2
    public static double size(Scanner user) {
        boolean correctSize = false;
        double wheelDiameter;
        do {
           wheelDiameter = user.nextDouble();
           if (wheelDiameter > 0.4 && wheelDiameter < 4 ) {
               correctSize = true;
           } else {
               System.out.println("Value must be between 0.4 and 4. Insert a new value:");
           }
        } while (!correctSize);
        return wheelDiameter;
    }

    //override equals() and hasshCode() methods to check if wheels are equal
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Wheel)) return false;
        Wheel wheel = (Wheel) o;
        return Double.compare(wheel.getDiameter(), getDiameter()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDiameter());
    }
}
