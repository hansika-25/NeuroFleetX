package com.neurofleetx.dto;

public class LocationDTO {
    private String busId;
    private double latitude;
    private double longitude;

    // Default Constructor 
    public LocationDTO() {}

    public LocationDTO(String busId, double latitude, double longitude) {
        this.busId = busId;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Getters and Setters
    public String getBusId() { return busId; }
    public void setBusId(String busId) { this.busId = busId; }

    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }
}