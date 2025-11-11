package dev.silverscapes.smh.service;

import dev.silverscapes.smh.model.Insurance;
import dev.silverscapes.smh.model.Patient;

public interface InsuranceService {
    Patient addInsuranceToPatient(Insurance insurance, Long PatientId);
}
