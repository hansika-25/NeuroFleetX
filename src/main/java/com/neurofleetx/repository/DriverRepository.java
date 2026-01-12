package com.neurofleetx.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.neurofleetx.model.Driver;

public interface DriverRepository extends MongoRepository<Driver, String> {
}

