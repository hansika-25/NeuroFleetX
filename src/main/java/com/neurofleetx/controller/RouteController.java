package com.neurofleetx.controller;

import com.neurofleetx.model.Route;
import com.neurofleetx.service.RouteService; // Service import zaroori hai
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/admin/routes")

@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class RouteController {

    @Autowired
    private RouteService routeService; 

    @GetMapping
    public List<Route> getAllRoutes() {
        return routeService.getAllRoutes(); 
    }

    @PostMapping
    public Route addRoute(@RequestBody Route route) {
        return routeService.createRoute(route); 
    }

   
    @PutMapping("/{id}")
    public ResponseEntity<Route> updateRoute(@PathVariable String id, @RequestBody Route routeDetails) {
        try {
            Route updatedRoute = routeService.updateRoute(id, routeDetails);
            return ResponseEntity.ok(updatedRoute);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteRoute(@PathVariable String id) {
        routeService.deleteRoute(id);
    }
}