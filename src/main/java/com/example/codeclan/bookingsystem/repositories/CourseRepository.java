package com.example.codeclan.bookingsystem.repositories;

import com.example.codeclan.bookingsystem.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository <Course, Long> {
//
    List<Course> findByRating(double rating);
//
    List<Course> findByBookingsCustomerNameIgnoreCase(String customerName);

}
