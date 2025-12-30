
package com.neurofleetx.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "buses")
public class Bus {

    @Id
    private String id;
    private String busNumber;
    private String driverName;
    private int capacity;
    private int totalSeats;
    private int availableSeats; 
    private String status;
    private int reservedSeats = 0;

    @DBRef // This annotation tells Spring to fetch the full Route object
    private Route route;

    public Route getRoute() { return route; }
    public void setRoute(Route route) { this.route = route; }

    public Bus() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
        this.totalSeats = capacity;    
        this.availableSeats = capacity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Getter for availableSeats
public int getAvailableSeats() {
    return availableSeats;
}

// Setter for availableSeats
public void setAvailableSeats(int availableSeats) {
    this.availableSeats = availableSeats;
}

// Also add for totalSeats if not there
public int getTotalSeats() {
    return totalSeats;
}

public void setTotalSeats(int totalSeats) {
    this.totalSeats = totalSeats;
}

public int getReservedSeats() { return reservedSeats; }
public void setReservedSeats(int reservedSeats) { this.reservedSeats = reservedSeats; }

}
