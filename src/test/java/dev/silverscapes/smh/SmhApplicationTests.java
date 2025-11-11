package dev.silverscapes.smh;

import dev.silverscapes.smh.model.Appointment;
import dev.silverscapes.smh.model.Insurance;
import dev.silverscapes.smh.model.Patient;
import dev.silverscapes.smh.service.AppointmentService;
import dev.silverscapes.smh.service.InsuranceService;
import dev.silverscapes.smh.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
class SmhApplicationTests {

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private PatientService patientService;

	@Test
	void contextLoads() {
	}

//    @Test
//    public void testInsurance() {
//        Insurance insurance = Insurance.builder()
//                .policyNumber("98392dfasdff89382")
//                .policyProvider("HDasdfaFC")
//                .validUntil(LocalDate.parse("2025-12-08"))
//                .build();
//
//        Patient patient = insuranceService.addInsuranceToPatient(insurance, 2L);
//    }

    @Test
    public void testAppointment() {
        Appointment appointment = Appointment.builder()
                .appointmentTime(LocalDateTime.of(12, 12, 12, 12, 12))
                .reason("Cancer")
                .build();
        appointmentService.createAppointment(appointment, 4L, 1L);

        appointmentService.reAssignAppointmentToNewDoctor(1L, 2L);


    }

}
