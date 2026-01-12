package com.neurofleetx.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.neurofleetx.model.Driver;
import com.neurofleetx.service.DriverService;

@RestController
@RequestMapping("/api/admin/drivers")
@CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*")
public class DriverController {

    private final DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping
    public List<Driver> getAllDrivers() {
        return driverService.getAllDrivers();
    }

    @PostMapping
    public Driver addDriver(@RequestBody Driver driver) {
        return driverService.createDriver(driver);
    }

    @PutMapping("/{id}")
    public Driver updateDriver(@PathVariable String id, @RequestBody Driver driver) {
        return driverService.updateDriver(id, driver);
    }

    @DeleteMapping("/{id}")
    public void deleteDriver(@PathVariable String id) {
        driverService.deleteDriver(id);
    }
}
