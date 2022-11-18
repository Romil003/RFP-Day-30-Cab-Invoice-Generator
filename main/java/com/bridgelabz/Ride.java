package com.bridgelabz;

public class Ride {
    double distance;
    double time;

    String type;
    public Ride(double distance, double time) {
        this.distance = distance;
        this.time = time;
    }

    public Ride(double distance, double time, String type) {
        this.distance = distance;
        this.time = time;
        this.type = type;
    }
}
