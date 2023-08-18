package com.stella.Patient.Service.dto;

import lombok.Getter;
import java.time.LocalDate;
@Getter
public class PatientDTO {
    private String patientName;
    private LocalDate dob;
    private String contact;
    private String gender;
    private String medicalHistory;
}
