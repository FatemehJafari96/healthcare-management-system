package com.example.prescription.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.prescription.repository.PrescriptionRepository;

import java.util.List;

@Service
public class PrescriptionService {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    public PrescriptionService(PrescriptionRepository prescriptionRepository) {
        this.prescriptionRepository = prescriptionRepository;
    }

    public Prescription createPrescription(Prescription prescription){

        return prescriptionRepository.save(prescription);
    }

    public List<Prescription> getAllPrescriptions(){
        return prescriptionRepository.findAll();
    }

    public Prescription getById(Long id){
        return prescriptionRepository.findById(id).orElse(null);
    }

    public Prescription updatePrescription(Long id , Prescription prescription){
        if (prescriptionRepository.existsById(id)){
            prescription.setId(id);
            return prescriptionRepository.save(prescription);
        }
        return null;
    }

    public void deletePrescription(Long id){
         prescriptionRepository.deleteById(id);
    }

    public List<Prescription> getPatientsPrescription(Long patientId){
        return prescriptionRepository.findByPatientId(patientId);
    }
    public List<Prescription> getPrescriptionsByHealthCareProvider(Long healthcareProviderId){
        return prescriptionRepository.findByHealthcareProviderId(healthcareProviderId);
    }
}
