package com.example.demo.student;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public ResponseEntity<String> deleteStudent(Long studentId){
        boolean studentIdExistence = studentRepository.existsById(studentId);
                if(!studentIdExistence){
                    throw new IllegalStateException("Student with ID " + studentId + " does not exist");
                }
                else {
                    studentRepository.deleteById(studentId);
                    return ResponseEntity.ok("Student with ID " + studentId + " deleted successfully");
                }
    }
}
