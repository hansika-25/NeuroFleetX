package com.neurofleetx.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
//import jakarta.annotation.security.PermitAll;
import com.neurofleetx.model.Bus;
import com.neurofleetx.service.BusService;

@CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*")
@RestController
@RequestMapping("/api/buses")

public class BusController {

    private final BusService busService;

    public BusController(BusService busService) {
        this.busService = busService;
    }

    @GetMapping
    //@PermitAll
    public List<Bus> getAllBuses() {
        return busService.getAllBuses();
    }

    @PostMapping
    public Bus addBus(@RequestBody Bus bus) {
     
        bus.setTotalSeats(bus.getCapacity());
        bus.setAvailableSeats(bus.getCapacity());
     return busService.createBus(bus);
    }

    @PutMapping("/{id}")
    public Bus updateBus(@PathVariable String id, @RequestBody Bus bus) {
        return busService.updateBus(id, bus);
    }

    @DeleteMapping("/{id}")
    public void deleteBus(@PathVariable String id) {
        busService.deleteBus(id);
    }

    @GetMapping("/{id}")
    public Bus getBusById(@PathVariable String id) {
        return busService.getBusById(id); 
    }
}

