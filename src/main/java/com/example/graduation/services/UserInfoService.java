package com.example.graduation.services;

import com.example.graduation.entities.Teacher;
import com.example.graduation.entities.UserInfo;
import com.example.graduation.exception.ResouceNotFoundException;
import com.example.graduation.model.TeacherDTO;
import com.example.graduation.model.UserDTO;
import com.example.graduation.repositories.TeacherRepository;
import com.example.graduation.repositories.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoService implements ServiceUser {

    @Autowired
    UserInfoRepository userRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @Override
    public UserInfo save(UserDTO user) {
        UserInfo newUser= new UserInfo();
        newUser.setId(user.getId());
        return mappingUpdate(newUser,user);
    }

    @Override
    public List<UserInfo> getAll() {
        return userRepository.findAll();
    }

    @Override
    public UserInfo getFromId(Long id) {
        return userRepository.findById(id).orElseThrow( ()-> new ResouceNotFoundException("User from database with " + id));
    }

    @Override
    public UserInfo delete(Long id) {
        UserInfo user=userRepository.findById(id).orElseThrow(()-> new ResouceNotFoundException("User from database with " + id));
        userRepository.deleteById(id);
        return user;

    }

    @Override
    public UserInfo update(UserInfo userFromDb, UserDTO user) {
        UserInfo newUser= mappingUpdate(userFromDb,user);
        userRepository.save(newUser);
        return newUser;
    }

    @Override
    public List<UserInfo> getAllUsersOfTeacher(String teacherName) {
        return userRepository.findAllByTeacherName(teacherName);
    }

    @Override
    public List<UserInfo> getBestTeachers() {
        return null;
    }

    @Override
    public List<UserInfo> getBestUsers() {
        return null;
    }

    @Override
    public UserDTO getUserFromName(String name) {
        return mappingForDTO(userRepository.findByName(name));
    }

    @Override
    public void updateUserFromName(String name) {
    }

    private UserInfo mappingUpdate(UserInfo userFromDb, UserDTO user){
        userFromDb.setName(user.getUsername());
        userFromDb.setPassword(user.getPassword());
        userFromDb.setInfoEasy(user.getInfoEasy());
        userFromDb.setInfoMedium(user.getInfoMedium());
        userFromDb.setInfoHard(user.getInfoHard());
        userFromDb.setBossLevel(user.isBossLevel());
        userFromDb.setBossMax(user.getBossMax());
        userFromDb.setTeacher(teacherRepository.findById(user.getTeacher()).orElseThrow(()-> new ResouceNotFoundException("Teacher from database with " + user.getTeacher())));
        return userFromDb;
    }
    private UserDTO mappingForDTO(UserInfo userFromDB){
        UserDTO user = new UserDTO(userFromDB.getId(),
                userFromDB.getName(),
                userFromDB.getPassword(),
                userFromDB.getInfoEasy(),
                userFromDB.getInfoMedium(),
                userFromDB.getInfoHard(),
                userFromDB.isBossLevel(),
                userFromDB.getBossMax(),
                userFromDB.getTeacher().getId());
        return  user;
    }
}
