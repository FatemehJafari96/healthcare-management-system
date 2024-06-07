package com.example.prescription.controller;

import com.example.prescription.models.Prescription;
import com.example.prescription.models.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/prescriptions")
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    @PostMapping
    public Prescription createPrescription(@RequestBody Prescription prescription){

        return prescriptionService.createPrescription(prescription);
    }

    @GetMapping
    public List<Prescription> getAllPrescriptions(){
        return prescriptionService.getAllPrescriptions();
    }

    @GetMapping("/{id}")
    public Prescription getById(@PathVariable Long id){
        return prescriptionService.getById(id);
    }

    @PutMapping("/{id}")
    public Prescription updateByID(@PathVariable Long id, @RequestBody Prescription prescription){
        return prescriptionService.updatePrescription(id, prescription);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        prescriptionService.deletePrescription(id);
    }

    @GetMapping("/patient/{patientId}")
    public List<Prescription> getPatientsPrescriptions(@PathVariable Long patientId){
        return prescriptionService.getPatientsPrescription(patientId);
    }

    @GetMapping("/provider/{healthcareProviderId}")
    public List<Prescription> getPrescriptionsByHealthcareProvider(@PathVariable Long healthcareProviderId) {
        return prescriptionService.getPrescriptionsByHealthCareProvider(healthcareProviderId);
    }
}
