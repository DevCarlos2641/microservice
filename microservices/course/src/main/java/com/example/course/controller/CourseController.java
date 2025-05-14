package com.example.course.controller;

import com.example.course.entity.Course;
import com.example.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    @Autowired
    private CourseService service;

    @GetMapping("all")
    public ResponseEntity<?> getAll(){
        return service.getAll();
    }

    @PostMapping
    public ResponseEntity<?> postCourse(@RequestBody Course course){
        return service.postCourse(course);
    }

    @GetMapping("/{id_course}")
    public ResponseEntity<?> getStudentByCourse(@PathVariable String id_course){
        return service.getStudentsByCourse(id_course);
    }

}
