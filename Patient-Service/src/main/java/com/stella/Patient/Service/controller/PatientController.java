package com.stella.Patient.Service.controller;

import com.stella.Patient.Service.dto.PatientDTO;
import com.stella.Patient.Service.entity.Patient;
import com.stella.Patient.Service.service.PatientIdGenerator;
import com.stella.Patient.Service.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;
    private final PatientIdGenerator patientIdGenerator;
    @PostMapping("/add")
    public Patient createPatient(@RequestBody PatientDTO patientDTO) {
        Patient patient = new Patient();
        patient.setPatientIdentifier(patientIdGenerator.generateId());
        patient.setPatientName(patientDTO.getPatientName());
        patient.setDob(patientDTO.getDob());
        patient.setContact(patientDTO.getContact());
        patient.setGender(patientDTO.getGender());
        patient.setMedicalHistory(patientDTO.getMedicalHistory());
        return patientService.savePatient(patient);
}
    @GetMapping("/get")
    public Patient getPatientByIdentifier(@PathVariable String id){
        return patientService.getPatientByIdentifier(id);
    }
}