package com.stella.Patient.Service.controller;

import com.stella.Patient.Service.dto.AppointmentDTO;
import com.stella.Patient.Service.dto.NotesDTO;
import com.stella.Patient.Service.service.AppointmentService;
import com.stella.Patient.Service.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notes")
public class NotesController {

    @Autowired
    private  NotesService notesService;

    @PostMapping("/write")
    public ResponseEntity<String> writeNotes(@RequestBody NotesDTO notesDTO) {
        notesService.writeNotes(notesDTO);
        return ResponseEntity.ok("Notes Written successfully.");
    }



}
