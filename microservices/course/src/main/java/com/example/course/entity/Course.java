package com.example.course.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "course")
public class Course {

    @Id
    private String id_course = null;

    private String name;

    private String teacher;

}
