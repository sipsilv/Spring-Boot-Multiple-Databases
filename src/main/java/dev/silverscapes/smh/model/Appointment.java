package dev.silverscapes.smh.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnCloudPlatform;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime appointmentTime;

    @Column(length = 500)
    private String reason;

    @ManyToOne // owning side
    @JoinColumn(nullable = false)
    private Patient patient;

    @ManyToOne  // owning side
    @JoinColumn(nullable = false)
    private Doctor doctor;
}
