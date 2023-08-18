package com.stella.Patient.Service.service;

import com.stella.Patient.Service.entity.Patient;
import com.stella.Patient.Service.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PatientService{
    @Autowired
    private  PatientRepository patientRepository;
    public Patient savePatient(Patient patient){

        return patientRepository.save(patient);
}

    public Patient getPatientByIdentifier(String id) {
        Patient patient=patientRepository.findById(id).orElseThrow(()->new
                ResponseStatusException(HttpStatus.NOT_FOUND,"invalid patient id"+id));
        return patient;
    }
}
