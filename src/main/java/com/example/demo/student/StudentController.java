package com.example.demo.student;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/students/")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){

        return studentService.getStudents();
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> getStudentById(@PathVariable String id) {
        try{
            Long studentId = Long.parseLong(id);
            Student student = studentService.getStudentById(studentId);
            return  ResponseEntity.ok(student);
        }
        catch (NumberFormatException error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid student ID format");
        }
        catch (EntityNotFoundException error){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID not Found");
        }
    }


    @PostMapping
    public void registerNewStudent (@RequestBody Student student){
        studentService.addNewStudent(student);
    }
}
