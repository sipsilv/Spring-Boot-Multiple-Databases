package dev.silverscapes.smh.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String bloodType;
}
