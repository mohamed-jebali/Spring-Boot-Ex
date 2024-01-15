package com.example.demo.student;
import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return  args -> {
            Student marco = new Student(
                    "Marco",
                    26,
                    "marco@gmail.com",
                    LocalDate.of(1997, Month.JANUARY, 17)
            );
            Student giacomo = new Student(
                    "Giacomo",
                    24,
                    "giacomo@gmail.com",
                    LocalDate.of(1999, Month.MARCH, 20)
            );
            Student alex = new Student(
                    "Alex",
                    23,
                    "Alex@gmail.com",
                    LocalDate.of(2000, Month.APRIL, 11)
            );
            repository.saveAll(
                    List.of(
                            marco,
                            giacomo,
                            alex
                    )
            );
        };
    }
}
