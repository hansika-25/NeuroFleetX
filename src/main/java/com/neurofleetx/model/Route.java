// Route.java
package com.neurofleetx.model; 

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "routes")
public class Route {

    @Id
    private String id;
    private String name;
    private String origin;
    private String destination;
   private List<Stop> stops;

    // Default Constructor
    public Route() {
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public List<Stop> getStops() {
    return stops;
}

    public void setStops(List<Stop> stops) {
    this.stops = stops;
}
}