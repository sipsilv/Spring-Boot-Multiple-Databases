package dev.silverscapes.smh.service.impl;

import dev.silverscapes.smh.model.Insurance;
import dev.silverscapes.smh.model.Patient;
import dev.silverscapes.smh.repository.InsuranceRepository;
import dev.silverscapes.smh.repository.PatientRepository;
import dev.silverscapes.smh.service.InsuranceService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class InsuranceServiceImplementation implements InsuranceService {
    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    public Patient addInsuranceToPatient(Insurance insurance, Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(()-> new EntityNotFoundException("Patient with id: " + patientId + " not found"));

        patient.setInsurance(insurance);

        insurance.setPatient(patient); // bidirectional  consistency/inclusivity

        return patient;

    }
}
