package com.e.cal;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String title;
    private Date appointmentDateAndTime;
   
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	public Date getAppointmentDateAndTime() {
		return appointmentDateAndTime;
	}
	public void setAppointmentDateAndTime(Date appointmentDateAndTime) {
		this.appointmentDateAndTime = appointmentDateAndTime;
	}
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Appointment(Long id, String name, String title, Date appointmentDateAndTime) {
		super();
		this.id = id;
		this.name = name;
		this.title = title;
		this.appointmentDateAndTime = appointmentDateAndTime;
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", name=" + name + ", title=" + title + ", appointmentDateAndTime="
				+ appointmentDateAndTime + "]";
	}
	

  
}
