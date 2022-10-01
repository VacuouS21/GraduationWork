package com.example.graduation.cotrollers;


import com.example.graduation.entities.UserInfo;
import com.example.graduation.model.UserUpdateRequesModel;
import com.example.graduation.services.UserInfoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
@RestController
@RequestMapping("/")
public class UserInfoController  {
@Autowired
UserInfoService service;
    @PostMapping("/user")
    public UserInfo createUser(@RequestBody UserInfo user){
        return service.save(user);
    }

    @GetMapping("/user")
    List<UserInfo> getUsers(){
        return service.getAll();

    }
    @GetMapping("/user/{id}")
    UserInfo getUserFromId(@PathVariable String id){
        return service.get(id);
    }

    @GetMapping("/game/{id}")
    UserInfo getUserFromGameId(@PathVariable Long id){
        return service.getGameId(id);
    }

    @PutMapping("/user/{id}")
    public UserInfo updateUser(@PathVariable Long id, @Valid @RequestBody UserUpdateRequesModel userUpdateRequesModel) throws UnsupportedEncodingException {
        UserInfo user=service.update(id,userUpdateRequesModel);
        return user;
    }
    @PutMapping("/easy/{id}")
    public UserInfo updateEasyLevel(@PathVariable Long id,@RequestBody int ball){
        return null;
    }
    @PutMapping("/medium/{id}")
    public UserInfo updateMediumLevel(@PathVariable Long id,@RequestBody int ball){
        return null;
    }
    @PutMapping("/hard/{id}")
    public UserInfo updateHardLevel(@PathVariable Long id,@RequestBody int ball){
        return null;
    }
    @PutMapping("/boss/{id}")
    public UserInfo updateBossLevel(){
        return null;
    }
    @DeleteMapping("/user/{id}")
    public UserInfo deleteUser(@PathVariable String id){
        UserInfo status=service.delete(id);
        return status;
    }

    @GetMapping("/test/{name}")
    public String test(@PathVariable String name){
        return null;
    }
}
