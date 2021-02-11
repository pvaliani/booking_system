package com.example.codeclan.bookingsystem;

import com.example.codeclan.bookingsystem.models.Course;
import com.example.codeclan.bookingsystem.repositories.BookingRepository;
import com.example.codeclan.bookingsystem.repositories.CourseRepository;
import com.example.codeclan.bookingsystem.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BookingsystemApplicationTests {

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Test
	void contextLoads() {
	}


	@Test
	public void canCreateCourse(){
//		Course java = new Course("Java", "Edinburgh", 4.5);
//		courseRepository.save(java);
		assertEquals(3,courseRepository.findAll().size());

	}

	@Test
	public void canCreateBooking(){
		assertEquals(3,bookingRepository.findAll().size());

	}

	@Test
	public void canCreateCustomer(){
		assertEquals(3,customerRepository.findAll().size());

	}








}
