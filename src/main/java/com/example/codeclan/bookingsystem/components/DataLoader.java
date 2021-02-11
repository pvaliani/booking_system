package com.example.codeclan.bookingsystem.components;

import com.example.codeclan.bookingsystem.models.Booking;
import com.example.codeclan.bookingsystem.models.Course;
import com.example.codeclan.bookingsystem.models.Customer;
import com.example.codeclan.bookingsystem.repositories.BookingRepository;
import com.example.codeclan.bookingsystem.repositories.CourseRepository;
import com.example.codeclan.bookingsystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;


    public DataLoader() {

    }


    public void run(ApplicationArguments args){

//        COURSES
    Course java = new Course("Java", "Edinburgh", 4.5);
    courseRepository.save(java);

    Course python = new Course("Python", "Glasgow", 2.1);
    courseRepository.save(python);

    Course javascript = new Course("JavaScript", "Inverness", 3.6);
    courseRepository.save(javascript);

    Customer kurt = new Customer("Kurt", "Glasgow", 36);
    customerRepository.save(kurt);

    Customer anna = new Customer("Anna", "Glasgow", 18);
    customerRepository.save(anna);


    Customer mitch = new Customer("Mitch", "Inverness", 22);
    customerRepository.save(mitch);

    Customer pedram = new Customer("Pedram", "Edinburgh", 30);
    customerRepository.save(pedram);

    Customer colin = new Customer("Colin", "Edinburgh", 34);
    customerRepository.save(colin);

    Booking booking1 = new Booking("11-02-2021", python, pedram);
    bookingRepository.save(booking1);

    Booking booking2 = new Booking("29-02-2021", java, kurt);
    bookingRepository.save(booking2);

    Booking booking3 = new Booking("29-02-2009", javascript, mitch);
    bookingRepository.save(booking3);

    Booking booking4 = new Booking("29-02-2007", java, colin);
    bookingRepository.save(booking4);

    Booking booking5 = new Booking("29-02-2004", java, anna);
    bookingRepository.save(booking5);














    }
}
