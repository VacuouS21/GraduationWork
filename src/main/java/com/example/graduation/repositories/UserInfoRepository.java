package com.example.graduation.repositories;

import com.example.graduation.entities.Teacher;
import com.example.graduation.entities.UserInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserInfoRepository extends MongoRepository<UserInfo,String> {

    Optional<UserInfo> findByGameId(Long gameID);
}
