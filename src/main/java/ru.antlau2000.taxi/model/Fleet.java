package ru.antlau2000.taxi.model;

import java.util.List;

public abstract class Fleet {
    private int id;
    private String colour;

    protected Fleet(int id, String colour) {
        this.id = id;
        this.colour = colour;
    }

    public int getId() {
        return id;
    }

    public String getColour() {
        return colour;
    }

    public abstract void addCar(Car car);

    public abstract Car getNearestCar(Location location);

    public abstract List<? extends Car> getCars();
}
