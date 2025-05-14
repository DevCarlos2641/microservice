package com.example.student.controller;

import com.example.student.entity.Student;
import com.example.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService service;


    @GetMapping
    public ResponseEntity<?> getStudents(){
        return service.getAll();
    }

    @PostMapping
    public ResponseEntity<?> postStudent(@RequestBody Student student){
        return service.postStudent(student);
    }

    @GetMapping("/{id_course}")
    public ResponseEntity<?> getByIdCourse(@PathVariable String id_course){
        return service.getByIdCourse(id_course);
    }

}