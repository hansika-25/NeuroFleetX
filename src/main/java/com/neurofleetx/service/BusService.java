package com.neurofleetx.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.neurofleetx.model.Bus;
import com.neurofleetx.repository.BusRepository;

@Service
public class BusService {

    private final BusRepository busRepository;

    public BusService(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    public List<Bus> getAllBuses() {
        // This will now return Bus objects including their full Route data
        return busRepository.findAll();
    }

    public Bus createBus(Bus bus) {
    if (bus.getCapacity() > 0) {
        bus.setTotalSeats(bus.getCapacity());
        bus.setAvailableSeats(bus.getCapacity());
        bus.setReservedSeats(0);
    }
    return busRepository.save(bus);
}

    public Bus updateBus(String id, Bus bus) {
        bus.setId(id);
        return busRepository.save(bus);
    }

    public void deleteBus(String id) {
        busRepository.deleteById(id);
    }
    
    
public Bus getBusById(String id) {
    return busRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Bus not found with id: " + id));
}
   
}
