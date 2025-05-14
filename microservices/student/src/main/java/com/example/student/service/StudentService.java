package com.example.student.service;

import com.example.student.entity.Student;
import com.example.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    public ResponseEntity<?> postStudent(Student student){
        repository.save(student);
        return ResponseEntity.ok("ok");
    }

    public ResponseEntity<?> getByIdCourse(String idCourse) {
        return ResponseEntity.ok(repository.findByIdCourse(idCourse));
    }
}
