package com.stella.Patient.Service.sharedDTO;

import lombok.Getter;
import org.springframework.data.annotation.Id;

@Getter
public class DoctorDTO {
    private String doctorId;
    private String doctorName;
    private String doctorContact;
    private String specialization;

}
