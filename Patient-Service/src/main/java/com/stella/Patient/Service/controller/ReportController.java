package com.stella.Patient.Service.controller;

import com.stella.Patient.Service.dto.ReportDTO;
import com.stella.Patient.Service.entity.Report;
import com.stella.Patient.Service.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
@RestController
@RequestMapping("/reports")
@RequiredArgsConstructor
public class ReportController {

    private final  ReportService reportService;
        @PostMapping("/upload")
    public ResponseEntity<String> uploadReport(
            @RequestParam("patientId") String patientId,
            @RequestParam("reportFile") MultipartFile reportFile)
           //@RequestBody ReportDTO reportDTO) {
    {
        reportService.uploadReport(patientId, reportFile);
        return ResponseEntity.ok("Report uploaded successfully");
    }
    @GetMapping("/view/{patientId}")
    public ResponseEntity<List<Report>> viewReports(@PathVariable String patientId) {
        List<Report> reports = reportService.getReportsByPatientId(patientId);
        return ResponseEntity.ok(reports);
    }
    @PostMapping("/reportData")
    public ResponseEntity<String> uploadReportData(@RequestBody ReportDTO reportDTO)
    {
        reportService.uploadReportData(reportDTO);
        return ResponseEntity.ok("Report data uploaded successfully");
    }
}
