package com.neurofleetx.service;

import com.neurofleetx.model.Route;
import com.neurofleetx.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }

    public Route createRoute(Route route) {
        return routeRepository.save(route);
    }

    public void deleteRoute(String id) {
        routeRepository.deleteById(id);
    }
    
    public Route updateRoute(String id, Route routeDetails) {
        Route route = routeRepository.findById(id).orElseThrow();
        route.setName(routeDetails.getName());
        route.setOrigin(routeDetails.getOrigin());
        route.setDestination(routeDetails.getDestination());
        route.setStops(routeDetails.getStops());
        return routeRepository.save(route);
    }
}