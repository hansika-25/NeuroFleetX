package com.neurofleetx.controller;

import com.neurofleetx.dto.LocationDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ConcurrentHashMap;

@CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@RestController
@RequestMapping("/api/buses")

public class BusLocationController {

   
    private static final ConcurrentHashMap<String, LocationDTO> busLocations = new ConcurrentHashMap<>();

    //driver sending the data
    @PostMapping("/update")
    public ResponseEntity<String> updateLocation(@RequestBody LocationDTO loc) {
        busLocations.put(loc.getBusId(), loc);
        System.out.println("Location updated for Bus: " + loc.getBusId());
        return ResponseEntity.ok("Location Updated Successfully");
    }

    // 2. Passenger sending the data
@GetMapping("/location/{busId}")
public ResponseEntity<LocationDTO> getLocation(@PathVariable String busId) {
   
    LocationDTO loc = busLocations.get(busId);

    if (loc != null) {
        
        return ResponseEntity.ok(loc);
    } else {
      
        LocationDTO puneDefault = new LocationDTO(busId, 18.5913, 73.7389);
        System.out.println("⚠️ Bus ID " + busId + " not found. Sending Pune default.");
        return ResponseEntity.ok(puneDefault);
    }
}
}