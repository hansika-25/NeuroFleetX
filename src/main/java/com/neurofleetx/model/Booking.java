package com.neurofleetx.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "bookings")
public class Booking {
    @Id
    private String id;
    private String userId;
    private String busId;
    private String routeName;
    private int seatNumber;
    private LocalDateTime bookingTime = LocalDateTime.now();
    private String status;
    private String travelDate;
    private String busNumber;

    // Default Constructor
    public Booking() {}

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getBusId() { return busId; }
    public void setBusId(String busId) { this.busId = busId; }

    public String getRouteName() { return routeName; }
    public void setRouteName(String routeName) { this.routeName = routeName; }

    public int getSeatNumber() { return seatNumber; }
    public void setSeatNumber(int seatNumber) { this.seatNumber = seatNumber; }

    public LocalDateTime getBookingTime() { return bookingTime; }
    public void setBookingTime(LocalDateTime bookingTime) { this.bookingTime = bookingTime; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getTravelDate() { return travelDate; }
public void setTravelDate(String travelDate) { this.travelDate = travelDate; }

public String getBusNumber() { return busNumber; }
public void setBusNumber(String busNumber) { this.busNumber = busNumber; }
}