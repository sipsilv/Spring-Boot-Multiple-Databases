package dev.silverscapes.smh.service.impl;

import dev.silverscapes.smh.dto.PatientDTO;
import dev.silverscapes.smh.model.Patient;
import dev.silverscapes.smh.model.value.BloodGroup;
import dev.silverscapes.smh.repository.PatientRepository;
import dev.silverscapes.smh.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImplementation implements PatientService {
    private final PatientRepository patientRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<PatientDTO> getAllPatients() {
       List<Patient> patients = patientRepository.findAll();
       List<Patient> p = patientRepository.findPatientsByFirstNameContaining("John");
       return patients
               .stream()
               .map(patient -> modelMapper.map(patient, PatientDTO.class))
               .toList();
    }
//    @Override
//    public List<PatientDTO> getAllPatientsWithBloodGroup(BloodGroup bloodGroup){
//        List<Patient> patients = patientRepository.findPatientsByBloodGroup(String.valueOf(bloodGroup));
//        return patients
//                .stream()
//                .map(patient -> modelMapper.map(patient, PatientDTO.class))
//                .toList();
//    }

}
