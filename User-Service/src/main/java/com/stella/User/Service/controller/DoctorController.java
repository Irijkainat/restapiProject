package com.stella.User.Service.controller;

import com.stella.User.Service.entity.Doctor;
import com.stella.User.Service.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    @PostMapping("/add")
    public String  addDoctor(@RequestBody Doctor doctor){
        try{
            doctorService.addDoctor(doctor);
            return "Successfully add the doctor";
        }
        catch(Exception e){
            return "Doctor Not added";      //+e;
        }
    }
    @GetMapping
    public List<Doctor> getDoctors(){

        return doctorService.getDoctors();
    }
    @GetMapping("/get/{id}")
    public Doctor getDoctor(@PathVariable String id){
        return doctorService.getDoctor(id);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateDoctor(@PathVariable String id,@RequestBody Doctor doctor){
        doctorService.updateDoctor(id,doctor);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable String id) {
        doctorService.deleteDoctor(id);
        return ResponseEntity.noContent().build();
    }
}
