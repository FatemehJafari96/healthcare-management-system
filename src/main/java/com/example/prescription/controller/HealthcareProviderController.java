package com.example.prescription.controller;

import com.example.prescription.models.HealthcareProvider;
import com.example.prescription.models.HealthcareProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/rest/healthcare-providers")
public class HealthcareProviderController {
    @Autowired
    private HealthcareProviderService healthcareProviderService;

    // Constructor injection for the service
    public HealthcareProviderController(HealthcareProviderService healthcareProviderService) {
        this.healthcareProviderService = healthcareProviderService;
    }

    // Endpoint to create a new healthcare provider
    @PostMapping
    public HealthcareProvider createHealthcareProvider(@RequestBody HealthcareProvider healthcareProvider) {
        return healthcareProviderService.createHealthcareProvider(healthcareProvider);
    }

    // Endpoint to retrieve healthcare providers by specialty
    @GetMapping("/specialty/{specialty}")
    public List<HealthcareProvider> findBySpecialty(@PathVariable String specialty) {
        return healthcareProviderService.findBySpecialty(specialty);
    }

    // Endpoint to retrieve a healthcare provider by ID
    @GetMapping("/{id}")
    public HealthcareProvider getHealthcareProviderById(@PathVariable Long id) {
        return healthcareProviderService.getHealthcareProviderById(id);
    }

    // Endpoint to update a healthcare provider by ID
    @PutMapping("/{id}")
    public HealthcareProvider updateHealthcareProvider(@PathVariable Long id, @RequestBody HealthcareProvider healthcareProvider) {
        return healthcareProviderService.updateHealthcareProvider(id, healthcareProvider);
    }

    // Endpoint to delete a healthcare provider by ID
    @DeleteMapping("/{id}")
    public void deleteHealthcareProvider(@PathVariable Long id) {
        healthcareProviderService.deleteHealthcareProvider(id);
    }

    // Endpoint to retrieve a healthcare provider by email
    @GetMapping("/email/{email}")
    public HealthcareProvider getHealthcareProviderByEmail(@PathVariable String email) {
        return healthcareProviderService.getHealthcareProviderByEmail(email);
    }
}
