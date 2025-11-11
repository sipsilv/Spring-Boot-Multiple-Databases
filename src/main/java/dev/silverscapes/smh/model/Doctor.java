package dev.silverscapes.smh.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String specialization;


    @OneToMany(mappedBy = "doctor", cascade = CascadeType.REMOVE,  orphanRemoval = true)
    //@JoinColumn(nullable = false)
    private List<Appointment> appointments;


}
