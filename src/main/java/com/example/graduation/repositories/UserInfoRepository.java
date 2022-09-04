package com.example.graduation.repositories;

import com.example.graduation.entities.UserInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserInfoRepository extends MongoRepository<UserInfo,String> {
}
