package it.academy.model.entity;

public class Car {
    private String vin;
    private String brand;
    private String model;

    public Car(String vin, String brand, String model) {
        this.vin = vin;
        this.brand = brand;
        this.model = model;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
