package com.example.demo.student;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow( () -> new EntityNotFoundException("ID not found"));
    }

    public void addNewStudent(Student student){
        Long studentId = student.getId();

        if (studentRepository.findById(studentId).isPresent()) {
            throw new IllegalStateException("Student with ID " + studentId + " already exists");
        }

        studentRepository.save(student);
    }
}
