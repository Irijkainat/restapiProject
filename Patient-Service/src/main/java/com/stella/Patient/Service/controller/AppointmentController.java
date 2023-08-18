package com.stella.Patient.Service.controller;


import com.stella.Patient.Service.dto.AppointmentDTO;
import com.stella.Patient.Service.entity.Appointment;
import com.stella.Patient.Service.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;
    @PostMapping("/create")
    public ResponseEntity<String> createAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        appointmentService.createAppointment(appointmentDTO);
        return ResponseEntity.ok("Appointment created successfully.");
    }
    @GetMapping("/get/{id}")
    public Appointment getAppointment(@PathVariable String id){
        return appointmentService.getAppointment(id);
    }

//    @GetMapping("/patient/{patientId}")
//    public ResponseEntity<List<Appointment>> getAppointmentsByPatientId(@PathVariable String patientId) {
//        List<Appointment> appointments = appointmentService.getAppointmentsByPatientId(patientId);
//        return ResponseEntity.ok(appointments);
//    }


}
