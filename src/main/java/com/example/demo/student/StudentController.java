package com.example.demo.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {

    @GetMapping
    public List<Student> getStudents(){
        return List.of(
                new Student(
                        1L,
                        "Marco",
                        26,
                        "marco@gmail.com",
                        LocalDate.of(1997, Month.JANUARY,17)
                ),
                new Student(
                        2L,
                        "Giacomo",
                        24,
                        "giacomo@gmail.com",
                        LocalDate.of(1999, Month.MARCH,20)
                ),
                new Student(
                        3L,
                        "Alex",
                        23,
                        "Alex@gmail.com",
                        LocalDate.of(2000, Month.APRIL,11)
                )
        );
    }

}
