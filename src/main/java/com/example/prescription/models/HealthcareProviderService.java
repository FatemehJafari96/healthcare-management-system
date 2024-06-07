package com.example.prescription.models;

import com.example.prescription.repository.HealthcareProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthcareProviderService {

    @Autowired
    private HealthcareProviderRepository healthcareProviderRepository;

    public HealthcareProviderService(HealthcareProviderRepository healthcareProviderRepository) {
        this.healthcareProviderRepository = healthcareProviderRepository;
    }

    public HealthcareProvider getHealthcareProviderByEmail(String email){
        return healthcareProviderRepository.getHealthcareProviderByEmail(email);
    }

    public HealthcareProvider createHealthcareProvider (HealthcareProvider healthcareProvider){
        return healthcareProviderRepository.save(healthcareProvider);
    }

    public HealthcareProvider updateHealthcareProvider(Long id, HealthcareProvider healthcareProvider){
        if (healthcareProviderRepository.existsById(id)){
            healthcareProvider.setId(id);
            healthcareProviderRepository.save(healthcareProvider);
        }
        return null;
    }

    public void deleteHealthcareProvider(Long id){
        healthcareProviderRepository.deleteById(id);
    }

    public HealthcareProvider getHealthcareProviderById(Long id){
        return healthcareProviderRepository.findById(id).orElse(null);
    }

    public List<HealthcareProvider> findBySpecialty(String specialty){
        return healthcareProviderRepository.findBySpecialty(specialty);
    }

    public List<HealthcareProvider> getAllHealthcareProviders(){
        return healthcareProviderRepository.findAll();
    }
}
