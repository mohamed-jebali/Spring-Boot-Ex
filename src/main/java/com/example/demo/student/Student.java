package com.example.demo.student;

import java.time.LocalDate;

public class Student {

    private Long id;
    private String name;
    private Integer age;

    private String email;
    private LocalDate dateOfBirth;

    public Student(Long id, String name, Integer age, String email, LocalDate dateOfBirth) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public Student(String name, Integer age, String email, LocalDate dateOfBirth) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
