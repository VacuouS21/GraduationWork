package com.example.graduation.cotrollers;

import com.example.graduation.entities.UserInfo;
import com.example.graduation.model.UserDTO;
import com.example.graduation.services.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@RequestMapping("/")
public class UserInfoController  {

    @Autowired
    ServiceUser userService;

    @PostMapping("/user")
    public UserInfo createUser(@RequestBody UserDTO user){
        return userService.save(user);
    }

    @GetMapping("/user")
    List<UserInfo> getUsers(){
        return userService.getAll();

    }
    @GetMapping("/user/{id}")
    UserInfo getUserFromId(@PathVariable Long id){
        return userService.getFromId(id);
    }

    @GetMapping("/user/name/{name}")
    UserDTO geUserFromName(@PathVariable String name){
        return userService.getUserFromName(name);
    }
    @PutMapping("/user/{id}")
    public UserInfo updateUser(@PathVariable("id") UserInfo userFromDb, @Valid @RequestBody UserDTO user) throws UnsupportedEncodingException {
        UserInfo newUser=userService.update(userFromDb,user);
        return newUser;
    }

    @DeleteMapping("/user/{id}")
    public UserInfo deleteUser(@PathVariable Long id){
        UserInfo status=userService.delete(id);
        return status;
    }


    //Для получения лучших 20 учеников по всем ученикам
    @GetMapping("/user/best")
    public List<UserInfo> getBestUsers(@PathVariable Long id){

        return null;
    }

    //Для получения всех учеников учителя
    @GetMapping("/user/teacher/{id}")
    public List<UserInfo> getAllUsersOfTeachers(@PathVariable Long idTeacher){

        return null;
    }

    @GetMapping("/user/teacher/best/{id}")
    public List<UserInfo> getBestUserOfTeacher(@PathVariable Long id){

        return null;
    }
}
