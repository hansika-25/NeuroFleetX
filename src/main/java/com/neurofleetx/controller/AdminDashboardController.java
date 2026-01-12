package com.neurofleetx.controller;

import com.neurofleetx.service.DashboardService; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/admin/stats")
@CrossOrigin(origins = "*", allowedHeaders = "*") 
public class AdminDashboardController {

    @Autowired
    private DashboardService dashboardService; 

    @GetMapping("/summary")
    public ResponseEntity<Map<String, Object>> getSummary() {
        try {
           
            Map<String, Object> stats = dashboardService.getDashboardStats();
            return ResponseEntity.ok(stats);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}