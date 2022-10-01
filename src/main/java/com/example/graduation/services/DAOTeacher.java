package com.example.graduation.services;

import com.example.graduation.entities.Teacher;
import com.example.graduation.model.TeacherUpdateRequesModel;
import com.example.graduation.model.UserUpdateRequesModel;

import java.util.List;

public interface DAOTeacher {
    List<Teacher> getAll();
    Teacher getId(String id);
    Teacher save(Teacher teacher);
    Teacher update(String id, TeacherUpdateRequesModel teacherUpdateRequesModel);

    Teacher delete(String id);

    Teacher findByName(String name);
}
