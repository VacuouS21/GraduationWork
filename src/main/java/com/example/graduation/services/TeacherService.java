package com.example.graduation.services;

import com.example.graduation.entities.Teacher;
import com.example.graduation.model.TeacherUpdateRequesModel;
import com.example.graduation.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService implements DAOTeacher {
    @Autowired
    TeacherRepository repository;


    @Override
    public List<Teacher> getAll() {
        return repository.findAll();
    }

    @Override
    public Teacher getId(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Teacher save(Teacher teacher) {
        Teacher teacherNew=repository.save(teacher);
        return teacherNew;
    }

    @Override
    public Teacher update(String id, TeacherUpdateRequesModel teacherUpdateRequesModel) {
        Teacher teacher= repository.findById(id).orElseThrow();
        teacher.setNameOfTeacher(teacherUpdateRequesModel.getNameOfTeacher());
        repository.save(teacher);
        return teacher;
    }

    @Override
    public Teacher delete(String id) {
        Teacher teacher=repository.findById(id).orElse(null);
        if(teacher!=null) repository.deleteById(id);
        return teacher;
    }

    @Override
    public Teacher findByName(String name){
        return null;
    }
}
