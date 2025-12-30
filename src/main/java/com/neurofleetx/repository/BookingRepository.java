package com.neurofleetx.repository;

import com.neurofleetx.model.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookingRepository extends MongoRepository<Booking, String> {
    // Fetch all bookings for a specific user to show in "My Tickets"
    List<Booking> findByUserId(String userId); 
}