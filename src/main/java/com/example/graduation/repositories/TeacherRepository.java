package com.example.graduation.repositories;

import com.example.graduation.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {
   // Optional<Teacher> findByName(String name);

}
