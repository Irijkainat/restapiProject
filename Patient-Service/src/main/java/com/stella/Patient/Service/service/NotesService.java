package com.stella.Patient.Service.service;

import com.stella.Patient.Service.dto.AppointmentDTO;
import com.stella.Patient.Service.dto.NotesDTO;
import com.stella.Patient.Service.entity.Appointment;
import com.stella.Patient.Service.entity.Notes;
import com.stella.Patient.Service.repository.AppointmentRepository;
import com.stella.Patient.Service.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class NotesService {
    @Autowired
    private NotesRepository notesRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;

    public Notes writeNotes(NotesDTO notesDTO) {
      Appointment  appointment  = getAppointmentData(notesDTO.getAppointmentId());
      Notes notes=new Notes();
        notes.setAppointment(appointment);
        notes.setNotesText(notesDTO.getNotesText());
        notes.setNotesDateTime(notesDTO.getNotesDateTime());
        return notesRepository.save(notes);

    }
    public  Appointment getAppointmentData(String appointmentId) {
        Optional<Appointment> appointmentOptional = appointmentRepository.findById(appointmentId);

        if (appointmentOptional.isPresent()) {

            return appointmentOptional.get();
        } else {
            throw new RuntimeException("Appointment with ID " + appointmentId + " not found");
        }
    }


}



