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

    // CRUD GET REQUEST --> http://localhost:8080/api/v1/students/
    // OUTPUT
//    [
//    {
//        "id": 1,
//            "name": "Marco",
//            "age": 26,
//            "email": "marco@gmail.com",
//            "dateOfBirth": "1997-01-17"
//    },
//    {
//        "id": 2,
//            "name": "Giacomo",
//            "age": 24,
//            "email": "giacomo@gmail.com",
//            "dateOfBirth": "1999-03-20"
//    },
//    {
//        "id": 3,
//            "name": "Alex",
//            "age": 23,
//            "email": "Alex@gmail.com",
//            "dateOfBirth": "2000-04-11"
//    },
    @GetMapping
    public List<Student> getStudents(){

        return studentService.getStudents();
    }


    // CRUD GET REQUEST --> http://localhost:8080/api/v1/students/studentId
    // OUTPUT
//    {
//        "id": 2,
//            "name": "Giacomo",
//            "age": 24,
//            "email": "giacomo@gmail.com",
//            "dateOfBirth": "1999-03-20"
//    }


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


    // CRUD POST REQUEST --> http://localhost:8080/api/v1/students/
    // JSON
    //    {
    //            "name": "Stefano",
    //            "email": "stefano@gmail.com",
    //            "dateOfBirth": "1966-01-17"
    //    }
    @PostMapping
    public void registerNewStudent (@RequestBody Student student){
        studentService.addNewStudent(student);
    }


    // CRUD DELETE REQUEST --> http://localhost:8080/api/v1/students/studentId
    @DeleteMapping(path = "{studentId}")
    public  void  deleteStudent (@PathVariable Long studentId){
        studentService.deleteStudent(studentId);
    }


    // CRUD PUT REQUEST --> http://localhost:8080/api/v1/students/studentId?paramName=valueName&paramEmail=valueEmail

    @PutMapping(path = "{studentId}")
    public  void  updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
    ){
        studentService.updateStudent(studentId,name,email);
    }
}
