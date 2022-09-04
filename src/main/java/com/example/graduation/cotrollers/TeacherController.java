package com.example.graduation.cotrollers;

import com.example.graduation.dao.Dao;
import com.example.graduation.entities.Teacher;

import java.util.List;
import java.util.Optional;

public class TeacherController implements Dao<Teacher> {
    @Override
    public Optional get(long id) {
        return Optional.empty();
    }

    @Override
    public List getAll() {
        return null;
    }

    @Override
    public void save(Teacher teacher) {

    }

    @Override
    public void update(Teacher teacher, String[] params) {

    }

    @Override
    public void delete(Teacher teacher) {

    }
    
}
