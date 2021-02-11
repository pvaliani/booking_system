package com.example.codeclan.bookingsystem.controllers;

import com.example.codeclan.bookingsystem.models.Booking;
import com.example.codeclan.bookingsystem.models.Course;
import com.example.codeclan.bookingsystem.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value="/courses")
    public ResponseEntity<List<Course>> getAllCourses(
            @RequestParam(name="rating", required = false)Double rating,
            @RequestParam(name="name", required = false)String name



    ){
        if(rating != null){
            return new ResponseEntity<>(courseRepository.findByRating(rating), HttpStatus.OK);
        }

        if(name != null){
            return new ResponseEntity<>(courseRepository.findByBookingsCustomerNameIgnoreCase(name), HttpStatus.OK);
        }

        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);

    }

    @GetMapping(value ="/courses/{id}")
    public ResponseEntity<List<Course>> getCourseById(@PathVariable Long id){
        return new ResponseEntity(courseRepository.findById(id), HttpStatus.OK);
    }


    @PostMapping(value="courses")
    public ResponseEntity<Course> createCourse(@RequestBody Course course){
        return new ResponseEntity<>(courseRepository.save(course),HttpStatus.CREATED );
    }








}
