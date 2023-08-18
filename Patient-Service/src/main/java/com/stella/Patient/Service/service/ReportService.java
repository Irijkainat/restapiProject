package com.stella.Patient.Service.service;

import com.stella.Patient.Service.dto.ReportDTO;
import com.stella.Patient.Service.entity.Patient;
import com.stella.Patient.Service.entity.Report;
import com.stella.Patient.Service.repository.PatientRepository;
import com.stella.Patient.Service.repository.ReportRepository;
import com.stella.Patient.Service.sharedDTO.DoctorDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class ReportService {
    @Autowired
    private final ReportRepository reportRepository;
    @Autowired
    private  PatientRepository patientRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Value("${User-Info-Service.url}")
    private String userServiceUrl;


    public void uploadReport(String patientId, MultipartFile reportFile) {
        Report report = new Report();
        report.setPatientId(report.getPatientId());
        report.setFileName(reportFile.getOriginalFilename());
        reportRepository.save(report);
    }


public Patient getPatientData(String patientId) {
        Optional<Patient> patientOptional = patientRepository.findById(patientId);
        if (patientOptional.isPresent()) {
            return patientOptional.get();
        }
        else {
            throw new RuntimeException("Patient with Id " + patientId + " not found");
        }
    }
    public List<Report> getReportsByPatientId(String patientId) {
        List<Report> reports = reportRepository.findByPatientId(patientId);
        return reports;
    }
    public Report uploadReportData(ReportDTO reportDTO) {
        DoctorDTO doctorDTO = restTemplate.getForObject(
                userServiceUrl + "/doctor/get/{id}",
                DoctorDTO.class,
                reportDTO.getDoctorId()
        );
        DoctorDTO doctorData = getDoctorData(doctorDTO.getDoctorId());
        Patient patient = getPatientData(reportDTO.getPatientId());
        Report report = new Report();
        report.setPatient(patient);
        report.setDoctorDTO(doctorData);
        report.setReportDetails(reportDTO.getReportDetails());
        report.setCurrentDate(reportDTO.getCurrentDate());
        return reportRepository.save(report);
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
        }
        else {
            throw new RuntimeException("Failed to fetch doctor data");
        }
    }
}