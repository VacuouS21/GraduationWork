package com.example.graduation.services;


import com.example.graduation.entities.UserInfo;
import com.example.graduation.model.UserUpdateRequesModel;

import java.util.List;


public interface DAOUserInfo  {

    UserInfo getGameId(Long id);
    UserInfo get(String id);
    List<UserInfo> getAll();
    UserInfo save( UserInfo user);

    UserInfo update(Long id, UserUpdateRequesModel userUpdateRequesModel);

    UserInfo delete(String id);
}
