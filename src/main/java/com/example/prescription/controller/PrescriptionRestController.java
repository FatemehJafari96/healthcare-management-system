package com.example.prescription.controller;

import com.example.prescription.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/prescriptions")
public class PrescriptionRestController {

    private final PrescriptionService prescriptionService;
    private final PatientService patientService;
    private final HealthcareProviderService healthcareProviderService;

    @Autowired
    public PrescriptionRestController(PrescriptionService prescriptionService, PatientService patientService, HealthcareProviderService healthcareProviderService) {
        this.prescriptionService = prescriptionService;
        this.patientService = patientService;
        this.healthcareProviderService = healthcareProviderService;
    }

    // Endpoint to display the form for creating a new prescription
    @GetMapping("/add")
    public String showAddPrescriptionForm(Model model) {
        model.addAttribute("prescription", new Prescription());
        model.addAttribute("patients", patientService.getAllPatients());
        model.addAttribute("healthcareProviders", healthcareProviderService.getAllHealthcareProviders());
        return "addPrescription";
    }

    // Endpoint to handle form submission for creating a new prescription
    @PostMapping
    public String createPrescription(@ModelAttribute Prescription prescription) {
        prescriptionService.createPrescription(prescription);
        return "redirect:/prescriptions";
    }

    // Endpoint to retrieve all prescriptions and display them in the listPrescriptions view
    @GetMapping
    public String getAllPrescriptions(Model model) {
        List<Prescription> prescriptions = prescriptionService.getAllPrescriptions();
        model.addAttribute("prescriptions", prescriptions);
        return "listPrescriptions";
    }

    // Endpoint to retrieve a prescription by ID (for viewing a specific prescription)
    @GetMapping("/{id}")
    public String getPrescriptionById(@PathVariable Long id, Model model) {
        Prescription prescription = prescriptionService.getById(id);
        model.addAttribute("prescription", prescription);
        return "viewPrescription";
    }

    // Endpoint to display the form for updating a prescription
    @GetMapping("/edit/{id}")
    public String showUpdatePrescriptionForm(@PathVariable Long id, Model model) {
        Prescription prescription = prescriptionService.getById(id);
        model.addAttribute("prescription", prescription);
        model.addAttribute("patients", patientService.getAllPatients());
        return "editPrescription";
    }

    // Endpoint to handle form submission for updating a prescription
    @PostMapping("/edit/{id}")
    public String updatePrescription(@PathVariable Long id, @ModelAttribute Prescription updatedPrescription) {
        prescriptionService.updatePrescription(id, updatedPrescription);
        return "redirect:/prescriptions";
    }

    // Endpoint to delete a prescription by ID
    @GetMapping("/delete/{id}")
    public String deletePrescription(@PathVariable Long id) {
        prescriptionService.deletePrescription(id);
        return "redirect:/prescriptions";
    }

    // Endpoint to retrieve prescriptions for a specific patient by ID
    @GetMapping("/patient/{patientId}")
    public String getPrescriptionsByPatient(@PathVariable Long patientId, Model model) {
        List<Prescription> prescriptions = prescriptionService.getPatientsPrescription(patientId);
        model.addAttribute("prescriptions", prescriptions);
        return "listPrescriptions";
    }
}
