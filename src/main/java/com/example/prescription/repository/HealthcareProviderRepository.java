package com.example.prescription.repository;

import com.example.prescription.models.HealthcareProvider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HealthcareProviderRepository extends JpaRepository<HealthcareProvider, Long> {

     HealthcareProvider getHealthcareProviderByEmail(String email);

     List<HealthcareProvider> findBySpecialty(String specialty);
}
