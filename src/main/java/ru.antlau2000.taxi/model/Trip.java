package ru.antlau2000.taxi.model;

public class Trip {
    private Location startLocation;
    private Location endLocation;

    public Trip(Location startLocation, Location endLocation) {
        this.startLocation = startLocation;
        this.endLocation = endLocation;
    }

    public Location getStartLocation() {
        return startLocation;
    }

    public Location getEndLocation() {
        return endLocation;
    }
}
