package com.stella.Patient.Service.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@Document(collection = "notes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Notes {
    @Id
    private String notesId;
    private LocalDateTime notesDateTime;
    private String notesText;
   // private String appointmentId;
    private Appointment appointment;
    private Patient patient;
}
