package ru.antlau2000.taxi.model;

import java.util.ArrayList;
import java.util.List;

public class FleetComfort extends Fleet {
    private List<Car> cars;
    private int carId;
    private static int id = 0;

//    TODO figure out id
    public FleetComfort(String colour) {
        super(id++, colour);
        this.cars = new ArrayList<>();
    }

    @Override
    public void addCar(Car car) {
        cars.add(car);
    }

    @Override
    public Car getNearestCar(Location location) {
        Car nearestCar = null;
        double nearestDistance = Double.POSITIVE_INFINITY;
        for (Car car : cars) {
            if (car.getStatus() == 1) {
                if (car.distanceToLocation(location) < nearestDistance) {
                    nearestDistance = car.distanceToLocation(location);
                    nearestCar = car;
                }
            }
        }
        return nearestCar;
    }

    @Override
    public List<? extends Car> getCars() {
        return cars;
    }
}
