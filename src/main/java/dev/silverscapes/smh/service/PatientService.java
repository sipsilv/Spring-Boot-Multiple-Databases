package dev.silverscapes.smh.service;

import dev.silverscapes.smh.dto.PatientDTO;
import dev.silverscapes.smh.model.value.BloodGroup;

import java.util.List;

public  interface PatientService {
    List<PatientDTO> getAllPatients();
    //List<PatientDTO> getAllPatientsWithBloodGroup(BloodGroup bloodGroup);

}
