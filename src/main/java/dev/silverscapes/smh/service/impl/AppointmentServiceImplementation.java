package dev.silverscapes.smh.service.impl;

import dev.silverscapes.smh.model.Appointment;
import dev.silverscapes.smh.model.Doctor;
import dev.silverscapes.smh.model.Patient;
import dev.silverscapes.smh.repository.AppointmentRepository;
import dev.silverscapes.smh.repository.DoctorRepository;
import dev.silverscapes.smh.repository.PatientRepository;
import dev.silverscapes.smh.service.AppointmentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImplementation implements AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    @Transactional
    public Appointment createAppointment(Appointment appointment, Long patientId, Long doctorId) {
       Patient patient = patientRepository.findById(patientId).orElseThrow();
       Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

       appointment.setPatient(patient);
       appointment.setDoctor(doctor);

       patient.getAppointments().add(appointment); // bidirectional connection

       doctor.getAppointments().add(appointment);

       return appointmentRepository.save(appointment);
    }

    @Transactional
    public void reAssignAppointmentToNewDoctor(Long appointmentId, Long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();
        Appointment newAppointment = appointmentRepository.findById(appointmentId).orElseThrow();

        newAppointment.setDoctor(doctor);

    }




}
