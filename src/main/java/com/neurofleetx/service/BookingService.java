package com.neurofleetx.service;

import com.neurofleetx.model.Booking;
import com.neurofleetx.model.Bus;
import com.neurofleetx.repository.BookingRepository;
import com.neurofleetx.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.stream.Collectors;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private BusRepository busRepository;

    @Transactional
    public Booking bookTicket(Booking booking) {
        // 1. Retrieve bus by ID
        Bus bus = busRepository.findById(booking.getBusId())
                .orElseThrow(() -> new RuntimeException("Bus not found"));

         System.out.println("DEBUG: Bus Seats in DB = " + bus.getAvailableSeats());

        // 2. Validate availability
        if (bus.getAvailableSeats() <= 0) {
            throw new RuntimeException("No seats available");
        }

        // 3. Update seats
        bus.setAvailableSeats(bus.getAvailableSeats() - 1);
        bus.setReservedSeats(bus.getReservedSeats() + 1);
        busRepository.save(bus);

        // 🎯 Automatic Seat Assignment Logic
        int nextSeat = bus.getReservedSeats() + 1;
    booking.setSeatNumber(nextSeat);

        // 4. Finalize booking
        booking.setStatus("CONFIRMED");
        return bookingRepository.save(booking);
    }

    public List<Booking> getUserBookings(String userId) {
        List<Booking> bookings = bookingRepository.findByUserId(userId);
       // return bookingRepository.findByUserId(userId);
       return bookings.stream().map(booking -> {
       
        busRepository.findById(booking.getBusId()).ifPresent(bus -> {
            
            booking.setBusNumber(bus.getBusNumber()); 
        });
        return booking;
    }).collect(Collectors.toList());
}
    
}