package com.pluralsight;

import java.time.LocalDate;

public class Vehicle extends Asset {
    private String makeModel;
    private int year;
    private int odometer;

    public Vehicle(String description, String dateAcquired, double originalCost, String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    @Override
    public double getValue() {
        // A car's value is determined as
        // 0-3 years old - 3% reduced value of cost per year
        // 4-6 years old - 6% reduced value of cost per year
        // 7-10 years old - 8% reduced value of cost per year
        // over 10 years old - $1000.00
        double currentCost = getOriginalCost();
        int age = LocalDate.now().getYear() - year;

        double carValue = switch (age) {
            case 0, 1, 2, 3 -> currentCost * (1 - (0.03 * age));
            case 4, 5, 6 -> currentCost * (1 - (0.06 * age));
            case 7, 8, 9, 10 -> currentCost * (1 - (0.08 * age));
            default -> 1000.00;
        };

        // MINUS reduce final value by 25% if over 100,000 miles
        // unless makeModel contains word Honda or Toyota
        if (odometer > 100000) {
            boolean containMakeModel = makeModel.contains("Honda") || makeModel.contains("Toyota");
            if (!containMakeModel) {
                carValue *= .75; // Shorthand for: carValue -= carValue *.25;
            }
            return currentCost;
        }
        return carValue;
    }

    @Override
    public String toString() {
        System.out.println("description, dateAcquired, originalCost, makeModel, year, odometer");
        final StringBuilder sb = new StringBuilder("Vehicle: ");
        sb.append(makeModel);
        sb.append(", ").append(year);
        sb.append(", ").append(odometer);
        sb.append('.');
        return sb.toString();
    }
}
