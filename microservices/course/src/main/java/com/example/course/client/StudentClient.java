package com.example.course.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-student", url = "msvc-gateway:8080/api/student")
public interface StudentClient {

    @GetMapping("/{id_course}")
    List<?> findAllStudentsByCourse(@PathVariable String id_course);

}
