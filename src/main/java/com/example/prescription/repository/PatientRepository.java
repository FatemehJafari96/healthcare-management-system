package com.example.prescription.repository;

import com.example.prescription.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    List<Patient> findByLastName(String lastName);

    Patient findByEmail(String email);
}
