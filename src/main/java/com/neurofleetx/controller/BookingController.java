package com.neurofleetx.controller;

import com.neurofleetx.model.Booking;
import com.neurofleetx.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "*") // Allows communication with your React frontend
public class BookingController {

    @Autowired
    private BookingService bookingService;

    /**
     * Endpoint to process a new ticket booking request.
     * Decrements seat count and saves booking record.
     */
    @PostMapping("/book")
    public ResponseEntity<?> createBooking(@RequestBody Booking booking) {
        try {
            Booking confirmedBooking = bookingService.bookTicket(booking);
            return ResponseEntity.ok(confirmedBooking);
        } catch (RuntimeException e) {
            // Returns error message if seats are full or bus is missing
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * Endpoint to fetch booking history for a specific passenger.
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Booking>> getUserBookings(@PathVariable String userId) {
        return ResponseEntity.ok(bookingService.getUserBookings(userId));
    }
}