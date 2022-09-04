package com.example.graduation.repositories;

import com.example.graduation.entities.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TeacherRepository extends MongoRepository<Teacher,String> {
    Optional<Teacher> findTeacherByName(String name);
}
