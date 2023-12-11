package com.webapp.mentorconnect2.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.beans.Transient;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.webapp.mentorconnect2.models.Appointment;

@DataJpaTest
public class AppointmentServiceTest(){

    @Autowired
    private AppointmentService appointmentService;

    private Appointment appointment;

    @BeforeEach
    void setup(){
        testAppointment = new Appointment();
        testAppointment.setAppointmentID(15543);
        testAppointment.setMenteeID(1454);
        testAppointment.setMentorID(4533);
        testAppointment.setDate("07-09-2026");
        testAppointment.setTime("8:00pm");
        testAppointment.setConfirmed(true);
    }

    @Test
    void saveTest(){

        Appointment appointment = appointmentDB.save(testAppointment);
        assertNotNull(appointment.getAppointmentID());
        assertNotNull(appointment.getMenteeID());
        assertNotNull(appointment.getMentorID());
        assertNotNull(appointment.getDate());
        assertNotNull(appointment.getTime());
        assertNotNull(appointment.getConfirmed());

    }

    void findAll(){
        appointmentDB.save(testAppointment);
        List<Appointment> appointments = (List<Appointment>) appointmentDB.findAll();
        assertEquals(1, appointments.size());
    }

    @Test
    void delete(){
        Appointment appointment =  appointmentDB.save(testAppointment);
        appointment.deleteById(appointment.getAppointmentID());
        Optional<Appointment> findappointment = accountDB.findById(appointment.getUserId());
        assertEquals(false, findappointment.isPresent());
    }
}
