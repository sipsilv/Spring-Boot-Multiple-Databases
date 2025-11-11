package dev.silverscapes.smh.controller;

import dev.silverscapes.smh.dto.PatientDTO;
import dev.silverscapes.smh.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;

    @GetMapping("/patients")
    public ResponseEntity<List<PatientDTO>> getAllPatients() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }
}
