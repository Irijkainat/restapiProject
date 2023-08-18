package com.stella.Patient.Service.entity;

import com.stella.Patient.Service.sharedDTO.DoctorDTO;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
@Data
@Document(collection = "appointments")
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Appointment {
   @Id
   private String appointmentId;
    private LocalDateTime appointmentDateTime;
    private Patient patient;
    private DoctorDTO doctorDTO;
}
