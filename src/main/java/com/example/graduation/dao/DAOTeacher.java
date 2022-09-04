package com.example.graduation.dao;

import com.example.graduation.entities.Teacher;

import java.util.List;

public interface DAOTeacher {
    List<Teacher> getAll();
    Teacher getId(String id);

}
