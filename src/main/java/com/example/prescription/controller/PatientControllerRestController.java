package com.example.prescription.controller;

import com.example.prescription.models.Patient;
import com.example.prescription.models.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/patients")
public class PatientControllerRestController {

    @Autowired
    private final PatientService patientService;

    public PatientControllerRestController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public String getAllPatients(Model model) {
        model.addAttribute("patients", patientService.getAllPatients());
        return "patients-list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("patient", new Patient());
        model.addAttribute("title", "Create Patient");
        return "patient-form";
    }

    @PostMapping
    public String createOrUpdatePatient(@ModelAttribute("patient") Patient patient) {
        patientService.createPatient(patient);
        return "redirect:/patients";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("patient", patientService.getPatientById(id));
        model.addAttribute("title", "Edit Patient");
        return "patient-form";
    }

    @GetMapping("/delete/{id}")
    public String deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return "redirect:/patients";
    }

}
