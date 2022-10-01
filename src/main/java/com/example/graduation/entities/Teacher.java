package com.example.graduation.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@Data
@Document
public class Teacher {

    @Id
    private String id;
    private String nameOfTeacher;

    public Teacher(String nameOfTeacher) {
        this.nameOfTeacher = nameOfTeacher;
    }
}
