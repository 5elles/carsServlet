package it.academy.model.repository;

import it.academy.model.entity.Car;

import java.util.ArrayList;
import java.util.List;

public class CarRepository {
    private static CarRepository carRepository = new CarRepository();
    public static CarRepository getInstance() {return carRepository;}
    public List<Car> getCars(){
        final List<Car> carList = new ArrayList<>();
        Car car1 = new Car("X123KL12", "BMW", "X3");
        Car car2 = new Car("Y123GHL12", "SAAB", "9000");
        Car car3 = new Car("GG1SD3K90", "VOLVO", "XC90");
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        return carList;
    }
}
