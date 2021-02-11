package com.example.codeclan.bookingsystem.repositories;

import com.example.codeclan.bookingsystem.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByBookingsCourseNameIgnoreCase(String course); //derived query
//
    List<Customer> findByTownAndBookingsCourseNameIgnoreCase(String town, String courseName);
//
    List<Customer> findByAgeGreaterThanAndTownIgnoreCaseAndBookingsCourseNameIgnoreCase(int age, String town, String courseName);

}
