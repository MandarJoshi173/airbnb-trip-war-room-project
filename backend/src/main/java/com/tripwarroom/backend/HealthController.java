package com.tripwarroom.backend;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HealthController {
    @GetMapping 
    public String health() {
        return "AI trip war room Backend is running!";
    }
}
