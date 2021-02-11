package com.example.codeclan.bookingsystem.controllers;

import com.example.codeclan.bookingsystem.models.Course;
import com.example.codeclan.bookingsystem.models.Customer;
import com.example.codeclan.bookingsystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

//    GET - extension 2 /customers?age=17&town=glasgow&course=java

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value="/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(
            @RequestParam(required = false, name = "course") String course,
            @RequestParam(required = false, name = "town") String town,
            @RequestParam(required = false, name = "age") Integer age

    ){
        if(course !=null && town != null && age != null){
            return new ResponseEntity<>(customerRepository.findByAgeGreaterThanAndTownIgnoreCaseAndBookingsCourseNameIgnoreCase(age, town, course), HttpStatus.OK);
        }


        if(course != null && town !=null){
            return new ResponseEntity<>(customerRepository.findByTownAndBookingsCourseNameIgnoreCase(town, course), HttpStatus.OK);
        }

        if(course != null){
            return new ResponseEntity<>(customerRepository.findByBookingsCourseNameIgnoreCase(course), HttpStatus.OK);
        }

        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value ="/customers/{id}")
    public ResponseEntity<List<Customer>> getCustomerById(@PathVariable Long id){
        return new ResponseEntity(customerRepository.findById(id), HttpStatus.OK);
    }





}
