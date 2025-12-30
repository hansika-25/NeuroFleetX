package com.neurofleetx.model;

public class Stop {
    private String name;
    private double latitude;
    private double longitude;
    private int sequenceOrder;

    // Default Constructor
    public Stop() {}

    public Stop(String name, double latitude, double longitude, int sequenceOrder) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.sequenceOrder = sequenceOrder;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }

    public int getSequenceOrder() { return sequenceOrder; }
    public void setSequenceOrder(int sequenceOrder) { this.sequenceOrder = sequenceOrder; }
}