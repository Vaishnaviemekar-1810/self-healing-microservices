package com.selfhealing.health_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/")
    public String home() {
        return "Self-Healing Microservices Platform is running!";
    }

    @GetMapping("/health")
    public String health() {
        return "Application is healthy";
    }
}