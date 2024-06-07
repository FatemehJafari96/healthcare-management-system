package com.example.prescription.controller;

import com.example.prescription.models.HealthcareProvider;
import com.example.prescription.models.HealthcareProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/healthcare-providers")
public class HealthcareProviderRestController {

    private final HealthcareProviderService healthcareProviderService;

    public HealthcareProviderRestController(HealthcareProviderService healthcareProviderService) {
        this.healthcareProviderService = healthcareProviderService;
    }


    // Endpoint to display the form for creating a new healthcare provider
    @GetMapping("/add")
    public String showAddHealthcareProviderForm(Model model) {
        model.addAttribute("provider", new HealthcareProvider());
        return "addHealthcareProvider";
    }

    // Endpoint to handle form submission for creating a new healthcare provider
    @PostMapping
    public String createHealthcareProvider(@ModelAttribute HealthcareProvider provider) {
        healthcareProviderService.createHealthcareProvider(provider);
        return "redirect:/healthcare-providers";
    }

    // Endpoint to retrieve all healthcare providers and display them in the listHealthcareProviders view
    @GetMapping
    public String getAllHealthcareProviders(Model model) {
        List<HealthcareProvider> providers = healthcareProviderService.getAllHealthcareProviders();
        model.addAttribute("providers", providers);
        return "listHealthcareProviders";
    }

    // Endpoint to retrieve a healthcare provider by ID (for viewing a specific healthcare provider)
    @GetMapping("/{id}")
    public String getHealthcareProviderById(@PathVariable Long id, Model model) {
        HealthcareProvider provider = healthcareProviderService.getHealthcareProviderById(id);
        model.addAttribute("provider", provider);
        return "viewHealthcareProvider";
    }

    // Endpoint to display the form for updating a healthcare provider
    @GetMapping("/edit/{id}")
    public String showUpdateHealthcareProviderForm(@PathVariable Long id, Model model) {
        HealthcareProvider provider = healthcareProviderService.getHealthcareProviderById(id);
        model.addAttribute("provider", provider);
        return "editHealthcareProvider";
    }

    // Endpoint to handle form submission for updating a healthcare provider
    @PostMapping("/edit/{id}")
    public String updateHealthcareProvider(@PathVariable Long id, @ModelAttribute HealthcareProvider updatedProvider) {
        healthcareProviderService.updateHealthcareProvider(id, updatedProvider);
        return "redirect:/healthcare-providers";
    }

    // Endpoint to delete a healthcare provider by ID
    @GetMapping("/delete/{id}")
    public String deleteHealthcareProvider(@PathVariable Long id) {
        healthcareProviderService.deleteHealthcareProvider(id);
        return "redirect:/healthcare-providers";
    }
}
