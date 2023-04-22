package com.example.graduation.cotrollers;

import com.example.graduation.entities.Teacher;
import com.example.graduation.model.TeacherDTO;
import com.example.graduation.model.TeacherUpdate;
import com.example.graduation.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
*Контроллер для учителей
 */
@RestController
@RequestMapping("/")
public class TeacherController {

@Autowired
TeacherService service;

    @PostMapping("/teacher")
    public Teacher createTeacher(@RequestBody TeacherUpdate teacher){
        return null;
    }

    @GetMapping("/teacher")
    List<Teacher> getTeachers(){
        return service.getAll();

    }
    @GetMapping("/teacher/{id}")
    Teacher getTeacherFromId(@PathVariable Long id){
        return service.getFromId(id);
    }

    @PutMapping("/teacher/{id}")
    public Teacher updateTeacher(@PathVariable("id") Teacher teacherFromDb, @Valid @RequestBody TeacherDTO teacher){
        Teacher newTeacher=service.update(teacherFromDb,teacher);
        return newTeacher;
    }

    @DeleteMapping("/teacher/{id}")
    public Teacher deleteTeacher(@PathVariable Long id){
        Teacher status=service.delete(id);
        return status;
    }

    @GetMapping("/teacher/filtred/{id}")
    public List<Teacher> getBestTeachers(@PathVariable Long id){

        return null;
    }
}
