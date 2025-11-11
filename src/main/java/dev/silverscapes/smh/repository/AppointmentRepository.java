package dev.silverscapes.smh.repository;

import dev.silverscapes.smh.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
}
