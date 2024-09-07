package com.e.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.e.cal.Appointment;
import com.e.repo.AppointmentRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class AppointmentController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    // Fetch all appointments
    @GetMapping("/appointments")
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    // Add a new appointment
    @PostMapping("/add-event")
    public Appointment addAppointment(@RequestBody Appointment appointment) {
    	
        return appointmentRepository.save(appointment);
    }

    // Update an existing appointment
//    @PutMapping("/update-event")
//    public List<Appointment> updateAppointment(@RequestBody Appointment updatedAppointment) {
//        Appointment appointment = appointmentRepository.findById(updatedAppointment.getId()).orElseThrow();
//        appointment.setName(updatedAppointment.getName());
//        appointment.setAppointmentDateAndTime(updatedAppointment.getAppointmentDateAndTime());
//      
//         appointment.setTitle(updatedAppointment.getTitle());
//        appointmentRepository.save(appointment);
//        return appointmentRepository.findAll(); 
//    }
    
    @PutMapping("/update-event")
    public List<Appointment> updateAppointment(@RequestBody Appointment updatedAppointment) {
        Appointment appointment = appointmentRepository.findById(updatedAppointment.getId())
                .orElseThrow(() -> new RuntimeException("Appointment not found with id: " + updatedAppointment.getId()));

        // Debugging: Log the received appointmentDateAndTime
        System.out.println("Updating appointment with new date and time: " + updatedAppointment.getAppointmentDateAndTime());

        // Update fields
        appointment.setName(updatedAppointment.getName());
        appointment.setAppointmentDateAndTime(updatedAppointment.getAppointmentDateAndTime());
        appointment.setTitle(updatedAppointment.getTitle());

        // Save the updated appointment
        appointmentRepository.save(appointment);

        return appointmentRepository.findAll();
    }


    // Delete an appointment
    @DeleteMapping("/delete-event/{id}")
    public List<Appointment> deleteAppointment(@PathVariable Long id) {
        appointmentRepository.deleteById(id);
        return appointmentRepository.findAll(); 
    }
}
