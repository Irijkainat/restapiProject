package com.stella.Patient.Service.service;

import com.stella.Patient.Service.dto.AppointmentDTO;
import com.stella.Patient.Service.dto.NotesDTO;
import com.stella.Patient.Service.entity.Appointment;
import com.stella.Patient.Service.entity.Patient;
import com.stella.Patient.Service.repository.AppointmentRepository;
import com.stella.Patient.Service.repository.PatientRepository;
import com.stella.Patient.Service.sharedDTO.DoctorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class AppointmentService {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${User-Info-Service.url}")
    private String userServiceUrl;
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private PatientRepository patientRepository;

    public Appointment createAppointment(AppointmentDTO appointmentDTO) {
        DoctorDTO doctorDTO = restTemplate.getForObject(
                userServiceUrl + "/doctor/get/{id}",
                DoctorDTO.class,
                appointmentDTO.getDoctorId()
        );
        DoctorDTO doctorData = getDoctorData(doctorDTO.getDoctorId());
        Patient patient = getPatientData(appointmentDTO.getPatientIdentifier());
        Appointment appointment = new Appointment();
        appointment.setPatient(patient);
        appointment.setDoctorDTO(doctorData);
  //       appointment.setDoctorId(doctorDTO.getDoctorId());
        appointment.setAppointmentDateTime(appointmentDTO.getAppointmentDateTime());
//       appointment.setPatientId(appointmentDTO.getPatientId());
        return appointmentRepository.save(appointment);

    }
    public  Patient getPatientData(String patientId) {
        Optional<Patient> patientOptional = patientRepository.findById(patientId);

        if (patientOptional.isPresent()) {

            return patientOptional.get();
        } else {
            throw new RuntimeException("Patient with Identifier " + patientId + " not found");
        }
    }


    private DoctorDTO getDoctorData(String doctorId) {
        String doctorServiceUrl = userServiceUrl + "/doctor/get/{id}";
        ResponseEntity<DoctorDTO> response = restTemplate.exchange(
                doctorServiceUrl,
                HttpMethod.GET,
                null,
                DoctorDTO.class,
                doctorId
        );

        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            throw new RuntimeException("Failed to fetch doctor data");
        }
    }

    public Appointment getAppointment(String id) {
        Appointment appointment=appointmentRepository.findById(id).orElseThrow(()->new
                ResponseStatusException(HttpStatus.NOT_FOUND,"invalid Appointment Id"+id));
        return appointment;

    }


}



