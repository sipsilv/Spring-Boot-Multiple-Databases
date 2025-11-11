package dev.silverscapes.smh.repository;

import dev.silverscapes.smh.model.Patient;
import dev.silverscapes.smh.model.value.BloodGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findPatientsByFirstNameContaining(String FirstName);
    List<Patient> findPatientsByEmail(String Email);
    //List<Patient> findPatientsByBloodGroup(BloodGroup bloodGroup); // check spring jpa for the queries

//    @Query("SELECT p from PATIENT p WHERE p.bloodGroup = ?1")
//    List<Patient> findPatientsByBloodGroup(@Param("bloodGroup") String bloodGroup);
}
