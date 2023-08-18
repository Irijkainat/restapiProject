package com.stella.Patient.Service.entity;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Data
@Document(collection = "patients")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Patient {
    @Id
    private String patientId;
    private String patientIdentifier;
    private String patientName;
    private String gender;
    private String contact;
    private LocalDate dob;
    private String medicalHistory;
}
