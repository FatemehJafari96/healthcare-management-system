package com.example.prescription.repository;

import com.example.prescription.models.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

    List<Prescription> findByPatientId(Long patientId);
    List<Prescription> findByHealthcareProviderId(Long healthcareProviderId);

}
