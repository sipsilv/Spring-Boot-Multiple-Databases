package dev.silverscapes.smh.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true, length = 50)
    private String policyNumber;
    @Column(nullable = false, length = 50)
    private String policyProvider;
    @Column(nullable = false)
    private LocalDate validUntil;

    @CreationTimestamp
    private LocalDateTime createdDate;

    @OneToOne(mappedBy = "insurance") // insurance is the column in the patient repo, there should only be one single source of truth/origin
    private Patient patient;
}
