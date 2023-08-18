package com.stella.Patient.Service.repository;

import com.stella.Patient.Service.entity.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends MongoRepository<Appointment,String> {


//    List<Appointment> findByPatientId(String patientId);
}
