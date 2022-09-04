package com.example.graduation.cotrollers;

import com.example.graduation.dao.Dao;
import com.example.graduation.entities.UserInfo;

import java.util.List;
import java.util.Optional;

public class UserInforController implements Dao<UserInfo> {

    @Override
    public Optional<UserInfo> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<UserInfo> getAll() {
        return null;
    }

    @Override
    public void save(UserInfo userInfo) {

    }

    @Override
    public void update(UserInfo userInfo, String[] params) {

    }

    @Override
    public void delete(UserInfo userInfo) {

    }
}
