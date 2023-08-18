package com.stella.Patient.Service.dto;

import lombok.Getter;
import java.time.LocalDateTime;
@Getter
public class AppointmentDTO {

    private LocalDateTime appointmentDateTime;
    private String patientIdentifier;
    private String doctorId;

}
