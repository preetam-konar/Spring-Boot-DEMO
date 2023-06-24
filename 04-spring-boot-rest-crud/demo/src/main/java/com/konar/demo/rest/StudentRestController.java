package com.konar.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.konar.demo.entity.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    List<Student> theStudents;

    @PostConstruct
    public void addStudents() {
        theStudents = new ArrayList<>();

        theStudents.add(new Student("a", "b"));
        theStudents.add(new Student("c", "d"));
        theStudents.add(new Student("e", "f"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }

    @GetMapping("/student/{studentId}")
    public Student getStudentById(@PathVariable int studentId) {

        if (studentId > theStudents.size() || studentId < 0) {
            throw new StudentNotFoundException("No student with id - " + studentId);
        }

        return theStudents.get(studentId);
    }


}
