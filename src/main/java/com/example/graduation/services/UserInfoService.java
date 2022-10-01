package com.example.graduation.services;

import com.example.graduation.entities.UserInfo;
import com.example.graduation.model.UserUpdateRequesModel;
import com.example.graduation.repositories.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoService implements DAOUserInfo {
    @Autowired
    UserInfoRepository repository;


    @Override
    public UserInfo get(String id) {
        return repository.findById(id).orElse(null);
    }
   @Override
    public UserInfo getGameId(Long id) {
        return repository.findByGameId(id).orElse(null);
    }

    @Override
    public List<UserInfo> getAll() {
        return repository.findAll();
    }

    @Override
    public UserInfo save(UserInfo userNew) {
        UserInfo user= repository.save(userNew);;
        return user;
    }

    @Override
    public UserInfo update(Long id, UserUpdateRequesModel userUpdateRequesModel) {

        UserInfo user= repository.findByGameId(id).orElseThrow();
        user.setUserName(userUpdateRequesModel.getUserName());
        user.setInfoEasy(userUpdateRequesModel.getInfoEasy());
        user.setInfoMedium(userUpdateRequesModel.getInfoMedium());
        user.setInfoHard(userUpdateRequesModel.getInfoHard());
        user.setBossLevel(userUpdateRequesModel.isBossLevel());
        user.setBossMax(userUpdateRequesModel.getBossMax());
        user.setIdTeacher(userUpdateRequesModel.getIdTeacher());
        repository.save(user);
        return user;

    }

    @Override
    public UserInfo delete(String id) {
        UserInfo userDel = repository.findById(id).orElse(null);
        if(userDel!=null) repository.deleteById(id);
        return userDel;
    }
}
