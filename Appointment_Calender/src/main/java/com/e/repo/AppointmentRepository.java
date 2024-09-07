package com.e.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.e.cal.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}

