package dev.silverscapes.smh.service;

import dev.silverscapes.smh.model.Appointment;

public interface AppointmentService {
    public Appointment createAppointment(Appointment appointment, Long patientId, Long doctorId);
    public void reAssignAppointmentToNewDoctor(Long appointmentId, Long doctorId);
}
