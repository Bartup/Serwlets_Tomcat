package com.tpo5_bg_s23591;

public class Car {

    String brand;
    String model;
    int prodyear;
    int fuelcons;
    int mileage;
    String type;

    public Car(String brand, String model,
               int prodyear, int fuelcons, int mileage, String type) {
        this.brand = brand;
        this.model = model;
        this.prodyear = prodyear;
        this.fuelcons = fuelcons;
        this.mileage = mileage;
        this.type = type;
    }


    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getProdyear() {
        return prodyear;
    }

    public int getFuelcons() {
        return fuelcons;
    }

    public int getMileage() {
        return mileage;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", prodyear=" + prodyear +
                ", fuelcons=" + fuelcons +
                ", mileage=" + mileage +
                ", type='" + type + '\'' +
                '}';
    }
}
