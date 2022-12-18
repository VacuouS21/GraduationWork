package com.example.graduation.services;

import com.example.graduation.entities.Teacher;
import com.example.graduation.entities.UserInfo;
import com.example.graduation.model.TeacherDTO;
import com.example.graduation.model.UserDTO;

import java.util.List;

public interface ServiceTeacher {
    Teacher save(Teacher teacher);
    List<Teacher> getAll();
    Teacher getFromId(Long id);
    Teacher delete(Long id);
    Teacher update(Teacher teacherFromDb, TeacherDTO teacher);
}
