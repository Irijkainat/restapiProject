package com.stella.Patient.Service.dto;

import lombok.Getter;
import java.time.LocalDate;
@Getter
public class ReportDTO {
    private String reportDetails;
    private LocalDate currentDate ;
    private String patientId;
    private String  appointmentId;
    private String doctorId;
    private String fileName;

}
