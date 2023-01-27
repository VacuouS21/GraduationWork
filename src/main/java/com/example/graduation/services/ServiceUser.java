package com.example.graduation.services;

import com.example.graduation.entities.UserInfo;
import com.example.graduation.model.UserDTO;

import java.util.List;

public interface ServiceUser {
    UserInfo save(UserDTO user);
    List<UserInfo> getAll();
    UserInfo getFromId(Long id);
    UserInfo delete(Long id);
    UserInfo update(UserInfo userFromDb, UserDTO user);
    List<UserInfo> getAllUsersOfTeacher(String teacherName);
    List<UserInfo> getBestTeachers();
    List<UserInfo> getBestUsers();

    UserDTO getUserFromName(String name);

    void updateUserFromName(String name);
}
