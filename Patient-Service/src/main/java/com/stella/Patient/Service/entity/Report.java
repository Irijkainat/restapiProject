package com.stella.Patient.Service.entity;

import com.stella.Patient.Service.sharedDTO.DoctorDTO;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;
@Data
@Document(collection = "reports")
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Report {
    @Id
    private String reportId;
    private String reportDetails;
    private LocalDate currentDate ;       // LocalDate.now();
    private Patient patient;
    private String patientId;
    private Appointment  appointment;
    private DoctorDTO doctorDTO;
    private String fileName;
}
