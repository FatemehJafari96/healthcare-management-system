package com.example.prescription.models;

import com.example.prescription.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    // Constructor injection for the repository
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    // Method to create a new patient
    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    // Method to retrieve all patients
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    // Method to retrieve a patient by ID
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    // Method to update a patient by ID
    public Patient updatePatient(Long id, Patient updatedPatient) {
        if (patientRepository.existsById(id)) {
            updatedPatient.setId(id);
            return patientRepository.save(updatedPatient);
        }
        return null;
    }

    // Method to delete a patient by ID
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    // Method to retrieve a patient by email
    public Patient getPatientByEmail(String email) {
        return patientRepository.findByEmail(email);
    }

    // Method to retrieve patients by last name
    public List<Patient> findByLastName(String lastName) {
        return patientRepository.findByLastName(lastName);
    }
}