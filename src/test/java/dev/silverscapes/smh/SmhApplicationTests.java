package dev.silverscapes.smh;

import dev.silverscapes.smh.model.Insurance;
import dev.silverscapes.smh.model.Patient;
import dev.silverscapes.smh.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class SmhApplicationTests {

    @Autowired
    private InsuranceService insuranceService;

	@Test
	void contextLoads() {
	}

    @Test
    public void testInsurance() {
        Insurance insurance = Insurance.builder()
                .policyNumber("98392dfasdff89382")
                .policyProvider("HDasdfaFC")
                .validUntil(LocalDate.parse("2025-12-08"))
                .build();

        Patient patient = insuranceService.addInsuranceToPatient(insurance, 2L);
    }

}
