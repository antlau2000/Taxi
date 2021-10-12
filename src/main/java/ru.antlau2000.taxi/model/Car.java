package ru.antlau2000.taxi.model;

public abstract class Car extends AbstractBaseEntity {
    protected int maxSpeed;

    public static final int FREE = 1;
    public static final int BOOKED = 2;
    public static final int ON_TRIP = 3;

    protected Car(int id, int maxSpeed) {
        this.id = id;
        this.maxSpeed = maxSpeed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public abstract double distanceToLocation(Location location);

    public abstract void setLocation(Location location);

    public abstract Location getLocation();

    public abstract void setStatus(int status);

    public abstract int getStatus();

    public abstract Trip getTrip();

    public abstract void assignTrip(Trip trip);

    public abstract Location getStart();

    public abstract Location getDestination();

    public abstract void updateLocation(double time);
}
