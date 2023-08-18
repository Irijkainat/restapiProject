package com.stella.User.Service.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
    @Id
    private String doctorId;
    private String doctorName;
    private String doctorContact;
    private String specialization;
}
