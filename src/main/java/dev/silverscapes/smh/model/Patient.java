package dev.silverscapes.smh.model;

import dev.silverscapes.smh.model.converter.BloodGroupConverter;
import dev.silverscapes.smh.model.value.BloodGroup;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "patient",
indexes = {@Index(name = "idx_dateOfBirth", columnList = "dateOfBirth")})
@Data
@Getter
@Setter
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(nullable = false)
    private Long id;
    @JoinColumn(nullable = false)
    private String firstName;
    private String lastName;
    @Column(nullable = false)
//    @Enumerated(EnumType.STRING)
//    @Convert(converter = BloodGroupConverter.class)
    private String bloodGroup;
    @JoinColumn(nullable = false)
    @ToString.Exclude
    private LocalDate dateOfBirth;
    @JoinColumn(nullable = false)
    private String email;
    @JoinColumn(nullable = false)
    private String gender;

    @OneToOne(cascade = {CascadeType.MERGE , CascadeType.PERSIST})
    @JoinColumn(name = "patient_insurance_id")  // owning side
    private Insurance insurance;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.REMOVE, orphanRemoval = true) // inverse side
    private List<Appointment> appointments;
}
