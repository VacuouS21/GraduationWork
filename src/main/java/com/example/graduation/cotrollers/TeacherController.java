package com.example.graduation.cotrollers;

import com.example.graduation.entities.Teacher;
import com.example.graduation.entities.UserInfo;
import com.example.graduation.model.TeacherUpdateRequesModel;
import com.example.graduation.model.UserUpdateRequesModel;
import com.example.graduation.services.TeacherService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@RequestMapping("/")
public class TeacherController {
@Autowired
TeacherService service;
    @PostMapping("/teacher")
    public Teacher createTeacher(@RequestBody Teacher teacher){
        return service.save(teacher);
    }

    @GetMapping("/teacher")
    List<Teacher> getTeachers(){
        return service.getAll();

    }
    @GetMapping("/teacher/{id}")
    Teacher getTeacherFromId(@PathVariable String id){
        return service.getId(id);
    }

    @PutMapping("/teacher/{id}")
    public Teacher updateTeacher(@PathVariable String id, @Valid @RequestBody TeacherUpdateRequesModel teacherUpdateRequesModel) throws UnsupportedEncodingException {
        Teacher teacher=service.update(id,teacherUpdateRequesModel);
        return teacher;
    }

    @DeleteMapping("/teacher/{id}")
    public Teacher deleteTeacher(@PathVariable String id){
        Teacher status=service.delete(id);
        return status;
    }
/*    @GetMapping("/name/{name}")
    public String getId(@PathVariable String name){
        Teacher teacher=service.findByName(name);
        return teacher.getId();
    }*/
}
