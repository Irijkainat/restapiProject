package com.stella.Patient.Service.dto;

import lombok.Getter;
import java.time.LocalDateTime;
@Getter
public class NotesDTO {
    private LocalDateTime notesDateTime;
    private String notesText;
    private String appointmentId;
}
