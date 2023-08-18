package com.stella.Patient.Service.repository;

import com.stella.Patient.Service.entity.Report;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableMongoRepositories
public interface ReportRepository extends MongoRepository<Report,String> {
    List<Report> findByPatientId(String patientId);
}
