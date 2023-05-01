package com.example.graduation.services;

import com.example.graduation.entities.Teacher;
import com.example.graduation.exception.ResouceNotFoundException;
import com.example.graduation.model.TeacherDTO;
import com.example.graduation.repositories.TeacherRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    TeacherRepository repository;
    @Autowired
    UserInfoService userService;


    public Teacher getFromId(Long id)
    {
        return repository.findById(id).orElseThrow(
                ()-> new ResouceNotFoundException("Teacher from database with " + id));
    }

    public List<Teacher> getAll(){
        return repository.findAll();
    }

    public Teacher save(Teacher teacher) {
        return repository.save(teacher);

    }

    public Teacher update(Teacher teacherFromDb,TeacherDTO teacher) {
        teacherFromDb.setLogin(teacher.getLogin());
        teacherFromDb.setName(teacher.getName());
        teacherFromDb.setPassword(teacher.getPassword());
        return teacherFromDb;
    }

    public Teacher delete(Long id) {
        Teacher teacher=repository.findById(id).orElseThrow(()-> new ResouceNotFoundException("Teacher from database with " + id));
        repository.deleteById(id);
        return teacher;
    }


}
