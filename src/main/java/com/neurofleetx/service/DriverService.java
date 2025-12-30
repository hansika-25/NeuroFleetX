package com.neurofleetx.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.neurofleetx.model.Driver;
import com.neurofleetx.repository.DriverRepository;

@Service
public class DriverService {

    private final DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    public Driver createDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    public Driver updateDriver(String id, Driver driver) {
        driver.setId(id);
        return driverRepository.save(driver);
    }

    public void deleteDriver(String id) {
        driverRepository.deleteById(id);
    }
}
