package com.example.codeclan.bookingsystem.controllers;

import com.example.codeclan.bookingsystem.models.Booking;
import com.example.codeclan.bookingsystem.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;




@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    // GET - /bookings - ALL BOOKINGS
    // GET - /bookings?date=29-02-2009 - mitchs date

    @GetMapping(value = "/bookings")
    public ResponseEntity<List<Booking>> getAllBookings(
            @RequestParam(name="date", required = false) String date
    ){
        if(date != null){
            return new ResponseEntity<>(bookingRepository.findByDate(date), HttpStatus.OK);
        }
        return new ResponseEntity<>(bookingRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value ="/bookings/{id}")
    public ResponseEntity<List<Booking>> getBookingById(@PathVariable Long id){
        return new ResponseEntity(bookingRepository.findById(id), HttpStatus.OK);
    }






}
