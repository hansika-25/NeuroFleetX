// package com.neurofleetx.repository;

// import com.neurofleetx.model.Bus;
// import org.springframework.data.mongodb.repository.MongoRepository;

// public interface BusRepository extends MongoRepository<Bus, String> { }
package com.neurofleetx.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.neurofleetx.model.Bus;

@Repository
public interface BusRepository extends MongoRepository<Bus, String> {
    long countByStatus(String status);
}
