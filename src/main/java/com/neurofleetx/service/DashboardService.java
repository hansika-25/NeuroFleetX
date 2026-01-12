package com.neurofleetx.service;

import com.neurofleetx.repository.BusRepository;
import com.neurofleetx.repository.DriverRepository;
import com.neurofleetx.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class DashboardService {

    @Autowired
    private BusRepository busRepository;
    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private DriverRepository driverRepository;

    public Map<String, Object> getDashboardStats() {
        Map<String, Object> stats = new HashMap<>();
        long totalBuses = busRepository.count();
        long activeBuses = busRepository.countByStatus("Active");
        stats.put("totalBuses",totalBuses); // Counts from MongoDB
        stats.put("totalRoutes", routeRepository.count());
        stats.put("totalDrivers", driverRepository.count());
        stats.put("activeBuses", activeBuses); 
        return stats;
    }
}