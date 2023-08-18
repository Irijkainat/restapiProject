package com.stella.Patient.Service.service;

import org.springframework.stereotype.Service;
import java.util.Random;
@Service
public class PatientIdGenerator {
    private final Random random = new Random();
    public String generateId() {
        int randomNumber = random.nextInt(90000000) + 10000000;
        return String.valueOf(randomNumber);
    }
}
