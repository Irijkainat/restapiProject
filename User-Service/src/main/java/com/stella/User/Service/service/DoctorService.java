package com.stella.User.Service.service;

import com.stella.User.Service.entity.Doctor;
import com.stella.User.Service.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;
    public void addDoctor( Doctor doctor){
        doctorRepository.save(doctor);
    }
    public List<Doctor> getDoctors() {

        return doctorRepository.findAll();
    }
    public Doctor getDoctor(String id) {
            Doctor doctor=doctorRepository.findById(id).orElseThrow(()->new
                    ResponseStatusException(HttpStatus.NOT_FOUND,"invalid Doctor Id"+id));
            return doctor;

    }
    public void updateDoctor(String id,Doctor doctor) {
        doctorRepository.findById(id).orElseThrow(()->new
                ResponseStatusException(HttpStatus.NOT_FOUND,"invalid Doctor Id"+id));
        doctor.setDoctorId(id);
        doctorRepository.save(doctor);
    }
    public void deleteDoctor(String id) {
        Doctor doctor=doctorRepository.findById(id).orElseThrow(()->new
                ResponseStatusException(HttpStatus.NOT_FOUND,"invalid Doctor Id"+id));
        doctorRepository.delete(doctor);

    }
}
