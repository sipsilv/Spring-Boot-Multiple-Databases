package dev.silverscapes.smh.repository;

import dev.silverscapes.smh.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
}
