package ru.antlau2000.taxi.model;

public class CarComfort extends Car {
    private Location location;
    private int status;
    private Trip trip;


    // TODO another location(fleet location for example) or no location !
    public CarComfort(int id, int maxSpeed) {
        super(id, maxSpeed);
        this.location = new Location(0, 0);
        this.status = FREE;
        this.trip = null;
    }

    @Override
    public Location getLocation() {
        return location;
    }

    @Override
    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public int getStatus() {
        return status;
    }

    @Override
    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public Trip getTrip() {
        return trip;
    }

    @Override
    public void assignTrip(Trip trip) {
        this.trip = trip;
    }

    @Override
    public Location getStart() {
        return trip.getStartLocation();
    }

    @Override
    public Location getDestination() {
        return trip.getEndLocation();
    }

    @Override
    public double distanceToLocation(Location location) {
        int distanceX = this.location.getX() - location.getX();
        int distanceY = this.location.getY() - location.getY();
        return Math.sqrt(distanceX * distanceX + distanceY * distanceY);
    }


    @Override
    public void updateLocation(double time) {
        int x = location.getX();
        int y = location.getY();

        if (status != FREE) {
            if (status == BOOKED) {
                int distanceX = this.location.getX() - trip.getStartLocation().getX();
                int distanceY = this.location.getY() - trip.getStartLocation().getY();
                double distanceToStart = Math.sqrt(distanceX * distanceX + distanceY * distanceY);
                if (maxSpeed * time >= distanceToStart) {
                    //    TODO use less calls to DB
                    this.setStatus(ON_TRIP);
                    x = trip.getStartLocation().getX();
                    y = trip.getStartLocation().getY();
                } else {
                    x += (distanceX / distanceToStart) * maxSpeed * time;
                    y += (distanceY / distanceToStart) * maxSpeed * time;
                }
            } else {
                int distanceX = this.location.getX() - trip.getEndLocation().getX();
                int distanceY = this.location.getY() - trip.getEndLocation().getY();
                double distanceToDestination = Math.sqrt(distanceX * distanceX + distanceY * distanceY);
                if (maxSpeed * time >= distanceToDestination) {
                    setStatus(FREE);
                    x = trip.getEndLocation().getX();
                    y = trip.getEndLocation().getY();
                } else {
                    x += (distanceX / distanceToDestination) * maxSpeed * time;
                    y += (distanceY / distanceToDestination) * maxSpeed * time;
                }
            }
            location.set(x, y);
        }
    }
}