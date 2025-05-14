package com.example.course.service;

import com.example.course.client.StudentClient;
import com.example.course.entity.Course;
import com.example.course.repository.CourseRepository;
import http.response.StudentByCourseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository repository;

    @Autowired
    private StudentClient studentClient;

    public ResponseEntity<?> getById(String id){
        return ResponseEntity.ok(repository.findById(id));
    }

    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    public ResponseEntity<?> postCourse(Course course){
        repository.save(course);
        return ResponseEntity.ok("ok");
    }

    public ResponseEntity<?> getStudentsByCourse(String id_course){
        Course course = repository.findById(id_course).orElse(new Course());

        List<?> list = studentClient.findAllStudentsByCourse(id_course);

        StudentByCourseResponse response = new StudentByCourseResponse();
        response.setStudents(list);
        response.setCourse_name(course.getName());
        response.setTeacher(course.getTeacher());
        return ResponseEntity.ok(response);
    }

}
